package easyreading.app.results


sealed class WellOrUnfit<out Well, out Message> {
    companion object {
        inline fun <R> catch(action: () -> R): WellOrUnfit<R, Throwable> {
            return try {
                Well(action())
            } catch (t: Throwable) {
                Unfit(t)
            }
        }
    }
}

fun Boolean.wellOr(message: String) = if (this) Well(Unit) else {
    Unfit(message)
}

fun <R> Collection<() -> R>.tryOut() =
    runCatching { this.forEach { it.invoke() } }.toWellOrUnfit().mapUnfit { "tried but ${it.message}" }

fun <R> Collection<() -> R>.tryOutAndCombine(): WellsAndUnfits<Unit, String> =
    this.map { runCatching { this.forEach { it.invoke() } }.toWellOrUnfit().mapUnfit { "tried but ${it.message}" } }
        .combine()

data class WellsAndUnfits<R, U>(
    val wells: Well<Collection<R>>,
    val unfits: Unfit<Collection<U>>,
) {

    fun unfitIfAnyUnfitsElseWell() = if (unfits.reason.isEmpty()) Well(Unit) else Unfit(unfits.reason.joinToString())
    fun firstWellIfAllWell() =
        if (unfits.reason.isEmpty()) Well(wells.value.first()) else Unfit(unfits.reason.joinToString())

}

fun <R, U> Pair<Well<List<R>>, Unfit<List<U>>>.toWellsUnfits() = WellsAndUnfits(this.first, this.second)


private fun <R, U> Collection<WellOrUnfit<R, U>>.combineToPair(): Pair<Well<List<R>>, Unfit<List<U>>> {
    val unfitStrings = mutableListOf<U>()
    val results = mutableListOf<R>()
    this.forEach { result ->
        result.onUnfit { unfit: U -> unfitStrings.add(unfit) }.onWell { well -> results.add(well) }
    }
    return Well(results.toList()) to Unfit(unfitStrings.toList())
}

fun <R, U> Collection<WellOrUnfit<R, U>>.combine() = this.combineToPair().toWellsUnfits()


data class Well<out Well>(val value: Well) : WellOrUnfit<Well, Nothing>() {
    companion object {
        infix fun <T> of(value: T) = Well(value)
    }
}

data class Unfit<out Message>(val reason: Message) : WellOrUnfit<Nothing, Message>() {
    companion object {
        infix fun <T> of(value: T) = Unfit(value)
    }
}

inline fun <W, M1, M2> WellOrUnfit<W, M1>.mapUnfit(mapUnfit: (M1) -> M2): WellOrUnfit<W, M2> = when (this) {
    is Well -> this
    is Unfit -> Unfit(mapUnfit(reason))
}

inline fun <T, R, M> WellOrUnfit<T, M>.andThen(transform: (T) -> WellOrUnfit<R, M>): WellOrUnfit<R, M> = when (this) {
    is Well -> transform(value)
    is Unfit -> this
}

inline fun <W1, W2, M> WellOrUnfit<W1, M>.mapWell(mapSuccess: (W1) -> W2): WellOrUnfit<W2, M> = when (this) {
    is Well -> Well(mapSuccess(value))
    is Unfit -> this
}


inline fun <S, M> WellOrUnfit<S, M>.onUnfit(action: (M) -> Unit): WellOrUnfit<S, M> {
    if (this is Unfit) action(reason)

    return this
}


inline fun <W, M> WellOrUnfit<W, M>.onWell(action: (W) -> Unit): WellOrUnfit<W, M> {
    if (this is Well) action(value)

    return this
}

val <T> WellOrUnfit<T, *>.wellValueOrNull: T?
    get() = when (this) {
        is Well -> value
        is Unfit -> null
    }

inline fun <W, F> WellOrUnfit<W, F>.wellOrElse(onFailure: (F) -> W): W = when (this) {
    is Well -> value
    is Unfit -> onFailure(reason)
}

fun <T> Result<T>.toWellOrUnfit(): WellOrUnfit<T, Throwable> =
    exceptionOrNull()?.let(::Unfit) ?: Well(getOrThrow())

val <T> WellOrUnfit<*, T>.errorOrNull: T?
    get() = when (this) {
        is Well -> null
        is Unfit -> reason
    }


fun <W, F> WellOrUnfit<W, F>.wellUnit(): WellOrUnfit<Unit, F> = mapWell { }
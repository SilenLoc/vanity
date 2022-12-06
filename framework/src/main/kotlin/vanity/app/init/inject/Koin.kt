package vanity.app.init.inject

import vanity.app.VanityChest
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.named
import vanity.app.init.inject.general.configuration.configurationModule
import vanity.app.init.inject.general.configuration.generalModule

class Koin {

    fun start(plugin: () -> Collection<VanityChest> = { emptyList() }) {
        startKoin {
            modules(configurationModule, generalModule, *plugin().map { it.module }.toTypedArray())
        }
    }


}



inline fun <reified T : Any> getService(name: String? = null): T =
    getService(qualifier = name?.let(::named))


inline fun <reified T : Any> getService(qualifier: Qualifier?): T =
    GlobalContext.get().get(qualifier)
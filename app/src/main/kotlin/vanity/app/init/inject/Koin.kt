package vanity.app.init.inject

import vanity.app.init.inject.general.configuration.configurationModule
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.named
import vanity.app.init.inject.general.configuration.generalModule

class Koin {

    fun start() {

        startKoin {
            modules(configurationModule, generalModule)
        }
    }


}

inline fun <reified T : Any> getService(name: String? = null): T =
    getService(qualifier = name?.let(::named))


inline fun <reified T : Any> getService(qualifier: Qualifier?): T =
    GlobalContext.get().get(qualifier)
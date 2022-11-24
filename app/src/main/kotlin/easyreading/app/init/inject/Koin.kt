package easyreading.app.init.inject

import easyreading.app.init.inject.general.configuration.configurationModule
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.named

class Koin {

  fun start() {

    startKoin {
      modules(configurationModule)
    }
  }


}

inline fun <reified T : Any> getService(name: String? = null): T =
  getService(qualifier = name?.let(::named))


inline fun <reified T : Any> getService(qualifier: Qualifier?): T =
  GlobalContext.get().get(qualifier)
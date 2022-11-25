package vanity.app.init.inject.general.configuration

import vanity.app.init.services.*
import org.koin.dsl.module

val configurationModule = module {
  single<IFilePathService> { DefaultFilePathService() }
  single<IFilePathValidationService> { DefaultFilePathValidationService(get()) }
  single<IConfigurationService> { ConfigurationService(get()) }



}
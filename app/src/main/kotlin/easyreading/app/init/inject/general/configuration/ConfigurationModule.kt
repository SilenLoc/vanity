package easyreading.app.init.inject.general.configuration

import easyreading.app.init.services.DefaultFilePathService
import easyreading.app.init.services.DefaultFilePathValidationService
import easyreading.app.init.services.IFilePathService
import easyreading.app.init.services.IFilePathValidationService
import org.koin.dsl.module

val configurationModule = module {
  single<IFilePathService> { DefaultFilePathService() }
  single<IFilePathValidationService> { DefaultFilePathValidationService(get()) }



}
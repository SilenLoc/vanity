package easyreading.app.init.services

import easyreading.app.results.WellOrUnfit
import easyreading.app.results.tryOutAndCombine

interface IFilePathValidationService {

  fun validate(): WellOrUnfit<Unit, String>

}


class DefaultFilePathValidationService(private val filePathService: IFilePathService) : IFilePathValidationService {

  override fun validate(): WellOrUnfit<Unit, String> = listOf(
    { filePathService.configurationFile.asPath().toFile().canRead() },
    { filePathService.fxCssFile.asPath().toFile().canRead() },
    { filePathService.resources.asPath().toFile().isDirectory }
  ).tryOutAndCombine().unfitIfAnyUnfitsElseWell()

}
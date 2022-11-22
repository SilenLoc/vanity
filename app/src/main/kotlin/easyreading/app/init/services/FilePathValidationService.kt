package easyreading.app.init.services

import easyreading.app.results.*
import java.io.File

interface IFilePathValidationService {

    fun validate(): WellOrUnfit<Unit, String>

}


class DefaultFilePathValidationService(private val filePathService: IFilePathService) : IFilePathValidationService {

    override fun validate(): WellOrUnfit<Unit, String> =
       filePathService.configurationFile.asPath().toFile().checkFile()


    private fun File.checkFile() = this.exists().wellOr("file: ${this.path} does not exists")
}


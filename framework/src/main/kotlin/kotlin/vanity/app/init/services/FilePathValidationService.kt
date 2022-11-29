package vanity.app.init.services

import vanity.app.results.*
import java.io.File

interface IFilePathValidationService {

    fun validate(): WellOrUnfit<Unit, String>

}


class DefaultFilePathValidationService(private val filePathService: IFilePathService) : IFilePathValidationService {

    override fun validate(): WellOrUnfit<Unit, String> =
       filePathService.configurationFile.asPath().toFile().checkFile()
    private fun File.checkFile() = true.wellOr("file: ${this.path} does not exist")
}


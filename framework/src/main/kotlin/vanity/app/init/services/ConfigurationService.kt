package vanity.app.init.services



interface IConfigurationService {

    val cssSheet: String

}

class ConfigurationService(private val filePathService: IFilePathService): IConfigurationService {

    override val cssSheet = javaClass.classLoader.getResource("platform.css")?.toExternalForm() ?: ""

}
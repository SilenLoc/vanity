package vanity.app.init.services


import org.kordamp.bootstrapfx.BootstrapFX

interface IConfigurationService {

    val cssSheet: String

}

class ConfigurationService(private val filePathService: IFilePathService): IConfigurationService {

    override val cssSheet = BootstrapFX.bootstrapFXStylesheet()

}
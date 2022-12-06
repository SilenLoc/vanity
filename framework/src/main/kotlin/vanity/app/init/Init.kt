package vanity.app.init

import vanity.app.init.services.IFilePathValidationService
import vanity.app.results.onUnfit
import vanity.app.results.onWell
import vanity.app.Log

class Init(
    private val filePathValidationService: IFilePathValidationService,
    private val onError: (String) -> Unit,
    private val onWell: () -> Unit
) {


    init {
        Log.info { "init App" }
        files()
    }

    private fun files() {
        Log.info { "trying to load files" }
        val result = filePathValidationService.validate()
        result
            .onUnfit {
                Log.info { "files paths are not valid: $it" }
                onError("files paths are not valid: $it")
            }
            .onWell {
                Log.info { "paths are valid" }
                onWell()
            }
    }


}
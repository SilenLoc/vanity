package easyreading.app.init

import easyreading.app.init.services.IFilePathValidationService
import easyreading.app.results.onUnfit
import easyreading.app.results.onWell
import easyreading.utilities.Log

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
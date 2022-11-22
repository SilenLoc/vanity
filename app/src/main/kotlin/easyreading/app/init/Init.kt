package easyreading.app.init

import easyreading.app.init.services.IFilePathValidationService
import easyreading.app.results.onUnfit
import easyreading.app.results.onWell
import easyreading.utilities.Log

class Init(private val filePathValidationService: IFilePathValidationService) {


  init {
    Log.info { "init App" }
    files()
  }

  private fun files() {
    Log.info { "trying to load files" }

    filePathValidationService.validate().onUnfit { Log.info { "files paths are not valid: $it" } }.onWell { Log.info { "paths are valid" } }

  }


}
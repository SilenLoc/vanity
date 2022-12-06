package vanity.app.apps.services

import vanity.app.IAppService
import vanity.app.JavaFxAppModule
import vanity.app.view.platformview.apps.applications.elbishtranslator.ElbishTranslator
import vanity.app.view.platformview.apps.applications.elbishtranslator.ExampleApp

class AppService : IAppService {

  override val javaFxAppModules: Collection<JavaFxAppModule>
    get() = listOf(
      JavaFxAppModule(
        "Fantasy",
        listOf(
          ElbishTranslator(),
          ExampleApp("NameGenerator")
        )
      ),
      JavaFxAppModule(
        "Dev",
        listOf(
          ExampleApp("Just Just")
        )
      ),
    )

}
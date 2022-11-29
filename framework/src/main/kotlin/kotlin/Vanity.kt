import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.withContext
import org.koin.core.module.Module
import vanity.app.init.Init
import vanity.app.init.inject.Koin
import vanity.app.init.inject.getService
import vanity.app.init.services.IConfigurationService
import vanity.app.view.failurewindows.showError
import vanity.app.view.javafx.screenBounds
import vanity.app.view.platformview.PlatformCoreView
import vanity.utilities.Log

object Vanity {

  suspend fun start(plugin: () -> Collection<VanityChest> = { emptyList() }) = withContext(Dispatchers.JavaFx) {
    Koin().start(plugin)
    Init(getService(), { message -> showError(message) }) { startPlatform() }
    Unit
  }


  private fun startPlatform() {
    val fxApp = PlatformApp()
    fxApp.start(Stage())
  }

  class PlatformApp : Application() {
    override fun start(stage: Stage) {

      val scene = Scene(PlatformCoreView(), screenBounds.width, screenBounds.height)
      val x = getService<IConfigurationService>().cssSheet
      Log.info { "style sheet$x" }
      scene.stylesheets.add(getService<IConfigurationService>().cssSheet)
      stage.title = "vanity Platform"
      stage.scene = scene
      stage.show()
    }
  }

}

data class VanityChest(
  val name: String,
  val module: Module
)
package vanity.app.view.platformview.apps

import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.BorderPane
import javafx.scene.layout.HBox
import javafx.stage.Stage
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import vanity.app.init.inject.getService
import vanity.app.init.services.IConfigurationService
import vanity.app.notifications.AppNotification
import vanity.app.notifications.INotificationService
import vanity.app.view.javafx.action
import vanity.app.view.javafx.cssBlackWhite
import vanity.app.view.javafx.cssBtnGreyAndGreen
import vanity.app.view.javafx.screenBounds
import vanity.app.view.platformview.apps.applications.elbishtranslator.ElbishTranslator

@OptIn(DelicateCoroutinesApi::class)
class Apps : BorderPane() {

    init {
        cssBlackWhite()

        val box = HBox()

        listOf(
            ElbishTranslator(),
        ).forEach {
            val btn = Button(it.name)
            btn.cssBtnGreyAndGreen()
            btn.action {
                showApp(it)
            }
            box.children.add(btn)
        }

        center = box
        show()
    }

    private fun showApp(app: App) {
        GlobalScope.launch {
            getService<INotificationService>().notify(AppNotification(app.name, app))
        }
    }

    fun show() {
        val scene = Scene(this, screenBounds.width / 4, screenBounds.height / 4)
        scene.stylesheets.add(getService<IConfigurationService>().cssSheet)
        val stage = Stage()
        stage.title = "Apps"
        stage.scene = scene
        stage.show()

    }

}
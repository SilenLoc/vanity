package vanity.app.view.platformview.apps

import javafx.scene.control.Button
import javafx.scene.layout.VBox
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import vanity.app.init.inject.getService
import vanity.app.notifications.AppNotification
import vanity.app.notifications.INotificationService
import vanity.app.view.javafx.VanityToggleButton
import vanity.app.view.javafx.action
import vanity.app.view.javafx.cssBlackWhite
import vanity.app.view.javafx.cssBtnGreyAndGreen

@OptIn(DelicateCoroutinesApi::class)
class Apps(name: String, private val javaFxApps: Collection<JavaFxApp>) : VBox() {

    private val box = VBox()

    init {
        val mainBtn = VanityToggleButton("$name <", "$name >", { showAppOptions() }, { hideAppOptions() })
        this.children.add(mainBtn)

        cssBlackWhite()
    }

    private fun hideAppOptions() {
        this.box.children.clear()
        this.children.remove(box)
    }

    private fun showAppOptions() {
        javaFxApps.forEach {
            val btn = Button(it.name)
            btn.cssBtnGreyAndGreen()
            btn.action {
                showApp(it)
            }
            box.children.add(btn)
        }
        this.children.add(box)
    }

    private fun showApp(javaFxApp: JavaFxApp) {
        GlobalScope.launch {
            getService<INotificationService>().notify(AppNotification(javaFxApp.name, javaFxApp))
        }
    }

}
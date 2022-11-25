package vanity.app.view.platformview



import javafx.application.Platform
import javafx.scene.layout.BorderPane
import kotlinx.coroutines.*
import vanity.app.init.inject.getService
import vanity.app.notifications.AppNotification
import vanity.app.notifications.INotificationService
import vanity.app.view.javafx.cssBlackWhite
import vanity.app.view.platformview.apps.App
import vanity.app.view.platformview.menu.MenuRegion

@OptIn(DelicateCoroutinesApi::class)
class PlatformCoreView : BorderPane() {

    init {
        cssBlackWhite()

        GlobalScope.launch {
            getService<INotificationService>().notifications.collect{
                Platform.runLater {
                    if(it is AppNotification)
                    setAndResetCenter(it.data)
                }
            }
        }

        left = MenuRegion()
    }



    private fun setAndResetCenter(app: App){
        center = null
        center = app.node
    }



}
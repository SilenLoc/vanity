package vanity.app.platformview

import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.layout.BorderPane
import vanity.app.javafx.cssBlackWhite
import vanity.app.platformview.changelog.Changelog
import vanity.app.platformview.menu.LeftSideMenu
import vanity.app.platformview.menu.SideOption
import vanity.app.platformview.menu.sideOption
import vanity.utilities.Log

class PlatformCoreView : BorderPane() {

    init {
        cssBlackWhite()
        val btn = Button("Menu")


        btn.onAction = EventHandler {
            Log.info { "open menu" }
            openLeftMenu()
        }

        center = btn
    }

    fun openLeftMenu() {
        left = null
        val menu = LeftSideMenu(
            listOf(
                sideOption("Changelog") { Changelog() },
            )
        )
        left = menu
        menu.buildUp()
    }

}
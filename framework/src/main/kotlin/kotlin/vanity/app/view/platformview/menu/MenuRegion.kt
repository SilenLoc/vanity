package vanity.app.view.platformview.menu

import javafx.scene.control.Button
import javafx.scene.layout.HBox
import vanity.app.view.javafx.action
import vanity.app.view.javafx.cssBtnGreyAndGreen
import vanity.app.view.javafx.cssBlackWhite
import vanity.app.view.platformview.apps.Apps
import vanity.app.view.platformview.changelog.Changelog
import vanity.utilities.Log

class MenuRegion : HBox() {

    init {
        addOpenBtn()
        cssBlackWhite()
    }

    private fun addOpenBtn() {
        val btn = Button(">")
        btn.cssBtnGreyAndGreen()
        btn.action {
            Log.info { "open menu" }
            openLeftMenu()
        }
        this.children.add(btn)
    }

    private fun addCloseBtn() {
        val btn = Button("<")
        btn.cssBtnGreyAndGreen()
        btn.action {
            Log.info { "close menu" }
            closeLeftMenu()
        }
        this.children.add(btn)
    }

    private fun openLeftMenu() {
        this.children.clear()
        val menu = LeftSideMenu(
            listOf(
                sideOption("Changelog") { Changelog() },
                sideOption("Apps") { Apps() },
            )
        )
        this.children.add(menu)
        addCloseBtn()
        menu.buildUp()
    }

    private fun closeLeftMenu() {
        this.children.clear()
        addOpenBtn()
    }


}
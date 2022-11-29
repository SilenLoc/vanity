package vanity.app.view.platformview.menu

import IAppService
import javafx.scene.layout.VBox
import vanity.app.init.inject.getService
import vanity.app.view.javafx.VanityToggleButton
import vanity.app.view.javafx.cssBlackWhite
import vanity.app.view.javafx.cssBtnGreyAndGreen
import vanity.app.view.platformview.apps.Apps
import vanity.app.view.platformview.changelog.Changelog

class MenuRegion : VBox() {

    private val box = VBox()

    init {
        val switchBtn = VanityToggleButton(">", "<", { openLeftMenu() }, { closeLeftMenu() })
        switchBtn.cssBtnGreyAndGreen()
        this.children.add(switchBtn)
        this.children.add(box)
        cssBlackWhite()
    }


    private fun openLeftMenu() {
        box.children.clear()
        val menu = LeftSideMenu(
            listOf(
                sideOption("Changelog") { Changelog() },
            ),
            getService<IAppService>().javaFxAppModules.map {
                richSideOption(Apps(it.name, it.apps))
            }
        )
        box.children.add(menu)
        menu.buildUp()
    }

    private fun closeLeftMenu() {
        box.children.clear()
    }


}
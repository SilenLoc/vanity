package vanity.app.view.platformview.menu

import javafx.scene.control.Button
import javafx.scene.layout.VBox
import vanity.app.view.javafx.action
import vanity.app.view.javafx.cssBtnGreyAndGreen
import vanity.app.view.javafx.cssBlackWhite

data class SideOption(val btn: () -> Button, val action: () -> Unit)

fun sideOption(title: String, action: () -> Unit) = SideOption({ Button(title) }, action)

class LeftSideMenu(private val options: Collection<SideOption>) : VBox() {

    init {
        cssBlackWhite()
    }

    fun buildUp() {
        this.options.map {
            val btn = it.btn()
            btn.cssBtnGreyAndGreen()
            btn.action {
                it.action()
            }
            btn
        }.let { this.children.addAll(it) }
    }

}

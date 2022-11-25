package vanity.app.platformview.menu

import javafx.scene.control.Button
import javafx.scene.layout.VBox
import vanity.app.javafx.action
import vanity.app.javafx.cssBlackWhite

data class SideOption(val btn: () -> Button, val action: () -> Unit)

fun sideOption(title: String, action: () -> Unit) = SideOption({ Button(title) }, action)

class LeftSideMenu(private val options: Collection<SideOption>) : VBox() {

    init {
        cssBlackWhite()
    }

    fun buildUp() {
        this.options.map {
            val btn = it.btn()
            btn.action {
                it.action()
            }
            btn
        }.let { this.children.addAll(it) }
    }


    fun stripDown() {
        this.children.clear()
    }

}

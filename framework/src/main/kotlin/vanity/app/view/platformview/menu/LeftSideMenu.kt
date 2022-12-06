package vanity.app.view.platformview.menu

import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.layout.VBox
import vanity.app.view.javafx.action
import vanity.app.view.javafx.cssBlackWhite
import vanity.app.view.javafx.cssBtnGreyAndGreen

data class SideOption(val btn: () -> Button, val action: () -> Unit)
data class RichSideOption(val node: Node)

fun sideOption(title: String, action: () -> Unit) = SideOption({ Button(title) }, action)
fun richSideOption(node: Node) = RichSideOption(node)

class LeftSideMenu(
    private val options: Collection<SideOption>,
    private val richOptions: Collection<RichSideOption>
) : VBox() {

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
        this.richOptions.forEach {
            this.children.add(it.node)
        }
    }

}

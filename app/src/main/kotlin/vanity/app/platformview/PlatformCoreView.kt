package vanity.app.platformview

import vanity.app.javafx.cssCore
import javafx.scene.Group
import javafx.scene.layout.Pane
import javafx.scene.shape.Circle

class PlatformCoreView : Pane() {

    init {
        cssCore()
        val circ = Circle(40.0, 40.0, 30.0)
        val root = Group(circ)
        this.children.add(root)
    }

}
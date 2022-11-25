package vanity.app.javafx

import javafx.scene.Node

fun Node.cssClass(classS: String) = this.styleClass.add(classS)
fun Node.cssCore() = this.styleClass.add("core")


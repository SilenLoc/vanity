package vanity.app.javafx

import javafx.scene.Node
import javafx.scene.layout.Region

fun Node.cssClass(classS: String) = this.styleClass.add(classS)
fun Region.cssBlackWhite() = this.styleClass.add("blackWhite")


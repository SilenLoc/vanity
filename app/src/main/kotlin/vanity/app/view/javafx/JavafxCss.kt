package vanity.app.view.javafx

import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.layout.HBox
import javafx.scene.layout.Region
import javafx.scene.layout.VBox

fun Node.cssClass(classS: String) = this.styleClass.add(classS)
fun Region.cssBlackWhite() = this.styleClass.add("blackWhite")
fun HBox.cssBlackWhite() = this.styleClass.add("blackWhiteHBox")
fun VBox.cssBlackWhite() = this.styleClass.add("blackWhiteVBox")
fun Button.cssBtnGreyAndGreen() = this.styleClass.add("btnGreyAndGreen")


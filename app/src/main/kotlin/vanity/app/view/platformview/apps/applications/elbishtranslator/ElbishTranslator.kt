package vanity.app.view.platformview.apps.applications.elbishtranslator

import javafx.scene.Node
import javafx.scene.control.Label
import vanity.app.view.platformview.apps.App

class ElbishTranslator() : App {

    override val name: String = "Elbish Translator"
    override val node: Node = Label(name)

}
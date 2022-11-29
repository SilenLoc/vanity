package vanity.app.view.platformview.apps.applications.elbishtranslator

import javafx.scene.Node
import javafx.scene.control.Label
import vanity.app.view.platformview.apps.JavaFxApp

class ElbishTranslator() : JavaFxApp {

    override val name: String = "Elbish Translator"
    override val node: Node = Label(name)

}


class ExampleApp(override val name: String) : JavaFxApp {
    override val node: Node = Label(name)
}


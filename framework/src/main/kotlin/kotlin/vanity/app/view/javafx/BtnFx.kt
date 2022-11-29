package vanity.app.view.javafx

import javafx.event.EventHandler
import javafx.scene.control.Button


fun Button.action(action: () -> Unit) {
    this.onAction = EventHandler {
        action()
    }
}


class VanityToggleButton(openName: String, closeName: String, action: () -> Unit, returnAction: () -> Unit) : Button(openName) {

    init {
        this.cssBtnGreyAndGreen()
    }

    sealed interface ToggleState
    class On(val returnAction: () -> Unit, val closeName: String) : ToggleState
    class Off(val action: () -> Unit, val openName: String) : ToggleState

    private var state: ToggleState = Off(action, openName)

    init {
        this.action {
            state = when (state) {
                is Off -> {
                    (state as Off).let {
                        it.action()
                        this.text = it.openName
                    }
                    On(returnAction, closeName)
                }

                is On  -> {
                    (state as On).let {
                        it.returnAction()
                        this.text = it.closeName
                    }
                    Off(action, openName)
                }
            }
        }
    }


}

package vanity.app.javafx

import javafx.scene.control.Button
import javafx.event.EventHandler


fun Button.action(action: () -> Unit) {
    this.onAction = EventHandler {
        action()
    }
}
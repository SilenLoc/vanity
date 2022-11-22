package easyreading.app.failurewindows

import javafx.application.Application
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.stage.Stage


class ErrorApplication(private val message: String) : Application() {

    override fun start(stage: Stage) {
        setAndShow(stage)
    }

    private fun setAndShow(stage: Stage) {
        val messageLabel = Label(message)
        val root = Group(messageLabel)
        val scene = Scene(root, 400.0, 300.0)
        stage.title = "Error"
        stage.scene = scene
        stage.show()
    }


}

fun showError(message: String){
    ErrorApplication(message).start(Stage())
}




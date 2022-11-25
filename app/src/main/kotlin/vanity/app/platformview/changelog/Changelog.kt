package vanity.app.platformview.changelog

import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.layout.BorderPane
import javafx.stage.Stage
import vanity.app.init.inject.getService
import vanity.app.init.services.IConfigurationService
import vanity.app.javafx.cssBlackWhite
import vanity.app.javafx.screenBounds


class Changelog : BorderPane() {

    init {
        cssBlackWhite()
        center = Label("changelog")
        show()
    }

    fun show() {
        val scene = Scene(this, screenBounds.width / 4, screenBounds.height / 4)
        scene.stylesheets.add(getService<IConfigurationService>().cssSheet)
        val stage = Stage()
        stage.title = "Changelog"
        stage.scene = scene
        stage.show()

    }

}
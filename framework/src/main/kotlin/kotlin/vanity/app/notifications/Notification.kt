package vanity.app.notifications

import vanity.app.view.platformview.apps.JavaFxApp


interface INotification<T> {

    val key: String

    val data: T

}

class AppNotification(override val key: String, override val data: JavaFxApp) : INotification<JavaFxApp>
package vanity.app.notifications

import vanity.app.view.platformview.apps.App


interface INotification<T> {

    val key: String

    val data: T

}

class AppNotification(override val key: String, override val data: App) : INotification<App>
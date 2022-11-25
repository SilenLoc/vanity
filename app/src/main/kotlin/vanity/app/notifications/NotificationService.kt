package vanity.app.notifications


import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow


interface INotificationService {

    val notifications: SharedFlow<INotification<*>>

    suspend fun notify(notification: INotification<*>)

}


class NotificationService : INotificationService {
    override val notifications: MutableSharedFlow<INotification<*>> = MutableSharedFlow(100, 100)

    override suspend fun notify(notification: INotification<*>) {
        notifications.tryEmit(notification)
    }

}
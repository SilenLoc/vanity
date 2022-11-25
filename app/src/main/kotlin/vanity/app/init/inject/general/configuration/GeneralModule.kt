package vanity.app.init.inject.general.configuration

import org.koin.dsl.module
import vanity.app.notifications.INotificationService
import vanity.app.notifications.NotificationService

val generalModule = module {
    single<INotificationService> { NotificationService() }
}
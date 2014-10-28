package com.samsullivan.orator.service;

import android.app.Notification;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;

public class NotificationListener extends NotificationListenerService {

    private Notification notification;

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        this.notification = sbn.getNotification();
        this.handleNotification();
    }

    private void handleNotification() {
        String notifiedText = this.notification.tickerText.toString();
    }

}

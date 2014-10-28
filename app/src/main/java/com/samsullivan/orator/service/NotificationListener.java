package com.samsullivan.orator.service;

import android.app.Notification;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;

import com.samsullivan.orator.util.SettingsUtil;
import com.samsullivan.orator.util.SpeechUtil;

public class NotificationListener extends NotificationListenerService {

    private SpeechUtil speechUtil;

    public NotificationListener() {
        this.speechUtil = new SpeechUtil(this);
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        if(SettingsUtil.getReadNotifications(getApplicationContext())) {
            Notification notification = sbn.getNotification();
            handleNotification(notification);
        }
    }

    private void handleNotification(Notification notification) {
        String notifiedText = notification.tickerText.toString();
        this.speechUtil.speak(notifiedText);
    }

}

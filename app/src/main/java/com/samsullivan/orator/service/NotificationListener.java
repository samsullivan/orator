package com.samsullivan.orator.service;

import android.app.Notification;
import android.content.Intent;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;

import com.samsullivan.orator.model.Speech;
import com.samsullivan.orator.util.SettingsUtil;
import com.samsullivan.orator.util.SpeechUtil;
import com.samsullivan.orator.util.StorageUtil;

public class NotificationListener extends NotificationListenerService {

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        if(SettingsUtil.getReadNotifications(getApplicationContext())) {
            Notification notification = sbn.getNotification();
            handleNotification(notification);
        }
    }

    private void handleNotification(Notification notification) {
        Speech speech = new Speech();
        speech.text = notification.tickerText.toString();
        speech.type = Speech.TYPE_NOTIFICATION;

        SpeechUtil speechUtil = new SpeechUtil(getApplicationContext());
        speechUtil.speak(speech);
    }

}

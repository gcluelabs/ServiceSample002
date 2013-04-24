package com.example.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class ServiceSampleService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.i("SERVICE", "onCreate()");
		// Notifiation Managerを取得
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		// nofiticationの作成
		Notification notification = new Notification(R.drawable.ic_launcher, null, System.currentTimeMillis());

		// PendingIntentはタイミングを指定したインテント
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0, new Intent(this, ServiceSampleActivity.class), 0);

		// notificationを設定
		notification.setLatestEventInfo(this, "ServiceSample", "onCreate()", contentIntent);

		// Notificationを表示
		mNotificationManager.notify(1, notification);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i("SERVICE", "onDestroy()");
	}

	@Override
	public void onStart(Intent intent, int startId) {
		Log.i("SERVICE", "onStart");
	}
}
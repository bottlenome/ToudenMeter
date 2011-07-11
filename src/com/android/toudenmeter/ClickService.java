package com.android.toudenmeter;

import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;

public class ClickService extends Service{

	private final String BUTTON_CLICK_ACTION = "BUTTON_CLICK_ACTION";
	
	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		
		Intent buttoIntent = new Intent();
		buttoIntent.setAction(BUTTON_CLICK_ACTION);
		PendingIntent pendingIntent = PendingIntent.getService(this, 0, buttoIntent, 0);
		RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.loaderror);
		remoteViews.setOnClickPendingIntent(R.id.button1, pendingIntent);

		if(BUTTON_CLICK_ACTION.equals(intent.getAction())) {
			UpdateDataHolder i = UpdateDataHolder.getInstance();
			try {
				ToudenUpdate.update(i.getContext(), i.getAppWidgetManager(), i.getAppwidgetIds());
				Log.v("Toudenmeter", "Refesh");
			} catch (Exception e) {
				Log.v("Toudenmeter", "UnabletoRefesh");
				e.printStackTrace();
			}
		}
		else {
			ComponentName thisWidget = new ComponentName(this, ToudenMeterProvider.class);
			AppWidgetManager manager = AppWidgetManager.getInstance(this);
			manager.updateAppWidget(thisWidget, remoteViews);
		}
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}

/**
 * 
 */
package com.android.toudenmeter;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * @author urota
 *
 */
public class ToudenMeterProvider extends AppWidgetProvider {
	Boolean getFlag = false;
	@Override
	public void onEnabled(Context context){
		Log.v("HelloAndroidWiget", "onEnabled");
		super.onEnabled(context);
	}
	
	@Override
	public void onUpdate(Context context,
						 AppWidgetManager appWidgetManager,
						 int[] appWidgetIds){
		try
		{
			UpdateDataHolder i = UpdateDataHolder.getInstance();
			i.setUpdateData(context, appWidgetManager, appWidgetIds);
			ToudenUpdate.update(context, appWidgetManager, appWidgetIds);
			getFlag = true;
		}
		catch (Exception e)
		{
			if(getFlag == false) {
				Intent clickIntent = new Intent(context, com.android.toudenmeter.ClickService.class);
				context.startService(clickIntent);
			}
			Log.v("ToudenMeter", e.toString());
		}
		Log.v("ToudenMeter", "onUpdate");
		
		super.onUpdate(context, appWidgetManager, appWidgetIds);
	}
	@Override
	public void onDeleted(Context context,
						  int[] appWidgetIds) {
		Log.v("ToudenMeter", "onDeleted");
		super.onDeleted(context, appWidgetIds);
	}
	@Override
	public void onDisabled(Context context) {
		Log.v("ToudenMeter","onDisabled");
		super.onDisabled(context);
	}
	@Override
	public void onReceive(Context context,
						  Intent intent){
		Log.v("ToudenMeter", "onRecieve");
		Log.v("ToudenMeter", intent.getAction());
		super.onReceive(context, intent);
	}
}

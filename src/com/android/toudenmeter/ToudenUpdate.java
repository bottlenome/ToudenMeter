package com.android.toudenmeter;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.RemoteViews;

public class ToudenUpdate {
	public static void update(Context context,
						AppWidgetManager appWidgetManager,
						int[] appWidgetIds) throws Exception
	{
		Meter mt = new Meter(ToudenBrowser.get());
		Log.v("ToudenMeter", "now:" + mt.getNow());
		Log.v("ToudenMeter", "max:" + mt.getMax());
		Log.v("ToudenMeter", "update:" + mt.getUpdate());
		Log.v("ToudenMeter", "rate:" + mt.getRate());
		LayoutHolder layoutHolder = LayoutHolder.getInstance();
		RemoteViews remoteViews = new RemoteViews(context.getPackageName(), layoutHolder.getlayout());
		Bitmap glaph = Imager.getOriginalGraph(context,mt);
		remoteViews.setImageViewBitmap(R.id.imageView1, glaph);
		String displayText = String.valueOf(mt.getRate()) + "%";
		remoteViews.setTextViewText(R.id.textPercent, displayText);
		remoteViews.setTextViewText(R.id.textSupplyPower, mt.getMax() + "ñúKw");
		remoteViews.setTextViewText(R.id.textUpdateTime, mt.getUpdate() + "çXêV");
		
		for (int i = 0; i < appWidgetIds.length; i++) {
			appWidgetManager.updateAppWidget(appWidgetIds[i], remoteViews);
		}
	}

}

package com.android.toudenmeter;

import android.appwidget.AppWidgetManager;
import android.content.Context;

public final class UpdateDataHolder {
	private static final UpdateDataHolder instance = new UpdateDataHolder();
	private Context context;
	private AppWidgetManager appWidgetManager;
	private int[] appWidgetIds;
	
	public static UpdateDataHolder getInstance(){
		return instance;
	}
	
	public void setUpdateData(Context context,
						 AppWidgetManager appWidgetManager,
						 int[] appWidgetIds){
		this.context = context;
		this.appWidgetManager = appWidgetManager;
		this.appWidgetIds = appWidgetIds;
	}
	
	public Context getContext(){
		return this.context;
	}
	
	public AppWidgetManager getAppWidgetManager(){
		return this.appWidgetManager;
	}

	public int[] getAppwidgetIds(){
		return this.appWidgetIds;
	}
}

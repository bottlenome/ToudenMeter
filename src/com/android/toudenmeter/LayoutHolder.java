package com.android.toudenmeter;

import android.util.Log;

public final class LayoutHolder {
	private static final LayoutHolder instance = new LayoutHolder();
	private Boolean layoutGot = false;
	private int layoutNum;
	private LayoutHolder(){};
	public static LayoutHolder getInstance(){
		return instance;
	}
	public int getlayout(){
		if(layoutGot == false) {
			if(android.os.Build.MODEL.equals("IS01")){
				Log.v("ToudenMeter", "IS01");
				layoutNum = R.layout.is01;
			}
			else {
				layoutNum = R.layout.main;
			}			
			layoutGot = true;
			return layoutNum;
		}
		else {
			return layoutNum;
		}
	}
}

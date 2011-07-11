package com.android.toudenmeter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

public class Imager {
	static final int glaphWidth = 125;
	static final int glaphHeight = 30;
	static final int scaleWidth = 25;
	static final int scaleHeight = 30;
	static final int glaphMargin = 2;
	static final int glaphScale = 10;
	static final int offset = 60;
	
	private static Bitmap cutBitmap(Bitmap bmp,int x,int y,int w,int h) {
		Bitmap result=Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
		Canvas canvas=new Canvas(result);
		canvas.drawBitmap(bmp,-x,-y,null);
		return result;
	}	
	
	public static Bitmap getOriginalGraph(Context context, Meter mt)
	{
	  	Bitmap unused = BitmapFactory.decodeResource(context.getResources(), R.drawable.unused240);
	  	Bitmap used = BitmapFactory.decodeResource(context.getResources(), R.drawable.used240);

	  	int width = unused.getWidth();
	  	int height = unused.getHeight();
		Log.v("HelloAndroidWidget", "width:" + width);
		Log.v("HelloAndroidWidget", "height:" + height);
		
	  	Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888); 
		
	  	Canvas offScreen = new Canvas(bitmap);
        offScreen.drawBitmap(used, 0, 0, (Paint)null);
        
        int offset = mt.getRate() - 50;
        if(offset > 0) {
        	offset = (int)((16 + 3.8 * offset) * width / 240.0);
        	offScreen.drawBitmap(cutBitmap(unused, offset, 0, width - offset, height), offset, 0, (Paint)null); 
        }

		return bitmap;
	}
	
}

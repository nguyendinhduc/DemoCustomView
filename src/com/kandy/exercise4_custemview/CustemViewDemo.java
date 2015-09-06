package com.kandy.exercise4_custemview;

import com.example.exercise4_custemview.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

public class CustemViewDemo extends View{
	private int widthScreen, heightScreen;
	private Paint paint;
	public CustemViewDemo(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initCommon();
	}

	public CustemViewDemo(Context context, AttributeSet attrs) {
		super(context, attrs);
		initCommon();
	}

	public CustemViewDemo(Context context) {
		super(context);
		initCommon();
	}
    private void initCommon() {
    	paint = new Paint();
    	WindowManager window = (WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics metric= new DisplayMetrics();
		window.getDefaultDisplay().getMetrics(metric);

		widthScreen = metric.widthPixels;
		heightScreen = metric.heightPixels;
		heightScreen = heightScreen/11*8;
    }
    private void drawIcon( Canvas canvas) {
    	paint.setColor(Color.rgb(2, 135, 207));
    	paint.setStyle(Style.STROKE);
    	
    	Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.icon_shape);
		int width = icon.getWidth();
	    int height = icon.getHeight();
	    int newWidth = widthScreen/5;
	    int newHeight = widthScreen/7;
	    float scaleWidth = ((float) newWidth) / width;
	    float scaleHeight = ((float) newHeight) / height;
	    // CREATE A MATRIX FOR THE MANIPULATION
	    Matrix matrix = new Matrix();
	    // RESIZE THE BIT MAP
	    matrix.postScale(scaleWidth, scaleHeight);
//
//	    // "RECREATE" THE NEW BITMAP
	    icon = Bitmap.createBitmap(icon, 0, 0, width, height, matrix, false);
	    canvas.drawBitmap(icon,widthScreen/5, heightScreen/7, paint);
        paint.setTextSize(60);
	    canvas.drawText("Draw your pattern",widthScreen/5+newWidth, heightScreen/7+newHeight-newHeight/2+30, paint);
    	
    	
    }
    private void drawCustem(Canvas canvas ) {
    	paint.setStyle(Style.STROKE);
    	paint.setStrokeWidth(17);
    	canvas.drawCircle(widthScreen/4, ((int)(heightScreen/2.5)), 30, paint);
    	canvas.drawCircle(widthScreen/2, (int)(heightScreen/2.5), 30, paint);
    	canvas.drawCircle(widthScreen*3/4, (int)(heightScreen/2.5), 30, paint);
    	
    	canvas.drawCircle(widthScreen/4, (int)(heightScreen/2.5)+widthScreen/4, 30, paint);
    	canvas.drawCircle(widthScreen/2, (int)(heightScreen/2.5)+widthScreen/4, 30, paint);
    	canvas.drawCircle(widthScreen*3/4, (int)(heightScreen/2.5)+widthScreen/4, 30, paint);
    	
    	canvas.drawCircle(widthScreen/4, (int)(heightScreen/2.5)+widthScreen/2, 30, paint);
    	canvas.drawCircle(widthScreen/2, (int)(heightScreen/2.5)+widthScreen/2, 30, paint);
    	canvas.drawCircle(widthScreen*3/4, (int)(heightScreen/2.5)+widthScreen/2, 30, paint);
    	

    }
    @Override
    protected void onDraw(Canvas canvas) {
    	super.onDraw(canvas);
    	drawIcon(canvas);
    	drawCustem(canvas);
    }
}

package com.ckt.test.customerdraw.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by D22400
 * on 2017/8/21.
 */

public class MyCircle3 extends View {

    private Paint mPaint;

    public MyCircle3(Context context) {
        super(context);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(30f);
        canvas.drawCircle(200, 400, 100, mPaint);
    }
}

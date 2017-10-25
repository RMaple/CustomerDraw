package com.ckt.test.customerdraw.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by D22400 on 2017/10/16.
 */

public class StrokeView extends View {

    private Paint mPaint;
    private Path mPath;
    private CornerPathEffect mEffect;

    public StrokeView(Context context) {
        this(context, null);
    }

    public StrokeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPath = new Path();
        mPath.lineTo(50,50);
        mPath.lineTo(30,20);
        mPath.lineTo(100,100);
        mEffect = new CornerPathEffect(20);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpaceSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpaceSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(100, 100);
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(200, heightSpaceSize);
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpaceSize, 200);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStrokeWidth(10);
//        mPaint.setStrokeCap(Paint.Cap.);
        mPaint.setStrokeJoin(Paint.Join.MITER);
        mPaint.setStrokeMiter(1);
        mPaint.setPathEffect(mEffect);
        canvas.drawPath(mPath,mPaint);
    }
}

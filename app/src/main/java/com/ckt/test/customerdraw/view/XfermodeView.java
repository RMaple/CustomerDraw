package com.ckt.test.customerdraw.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.ckt.test.customerdraw.R;

/**
 * Created by D22400 on 2017/10/16.
 */

public class XfermodeView extends View {

    private Paint mPaint1;
    private Xfermode mXfermode;
    private Bitmap mBitmap;

    public XfermodeView(Context context) {
        this(context, null);
    }

    public XfermodeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        BitmapFactory.Options options = new BitmapFactory.Options();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bitmap, options);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpaceSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpaceSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(400, 400);
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(200, heightSpaceSize);
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpaceSize, 200);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        int saved = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG);
//        mPaint1.setColor(Color.GREEN);
//        canvas.drawBitmap(mBitmap,0,0,mPaint1);
//
//        mPaint1.setXfermode(mXfermode);
//        mPaint1.setColor(Color.RED);
//        canvas.drawBitmap(mBitmap,100,100,mPaint1);
//
//        mPaint1.setXfermode(null);
//        canvas.restoreToCount(saved);
    }
}

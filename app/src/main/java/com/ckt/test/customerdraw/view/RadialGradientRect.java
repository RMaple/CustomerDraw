package com.ckt.test.customerdraw.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by D22400 on 2017/8/25.
 */

public class RadialGradientRect extends View {

    private final Paint mPaint;
    private Xfermode mXfermode;
    private Shader mShader;

    public RadialGradientRect(Context context) {
        this(context, null);
    }

    public RadialGradientRect(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

//        在设置了 Shader 的情况下， Paint.setColor/ARGB() 所设置的颜色就不再起作用。
//        mXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpaceSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpaceSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(200, 200);
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(200, heightSpaceSize);
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpaceSize, 200);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawCircle(300,300,200,mPaint);
//        mPaint.setXfermode(mXfermode);
        if (mShader == null) {
            mShader = new RadialGradient(getWidth() / 2, getHeight() / 2,
                    Math.min(getWidth() / 2, getHeight() / 2), Color.parseColor("#E91E63"),
                    Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
            mPaint.setShader(mShader);
        }
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
//        mPaint.setXfermode(null);
    }
}

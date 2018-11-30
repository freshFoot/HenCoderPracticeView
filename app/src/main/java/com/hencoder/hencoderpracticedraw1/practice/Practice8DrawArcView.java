package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        Paint paint = new Paint();
        RectF rectF = new RectF();
        rectF.set(getWidth()/2-100,getHeight()/2-100,getWidth()/2,getHeight()/2);
        canvas.drawArc(rectF,0,-90,true,paint);
        canvas.drawArc(rectF,-270,-80,false,paint);

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rectF,-100,-100,false,paint);
    }
}

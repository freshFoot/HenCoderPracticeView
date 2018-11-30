package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        Paint paint = new Paint();

        Path path = new Path();
        int x = getWidth() / 2;
        int y = getHeight() / 2;
        path.moveTo(x, y);

        //        前两个参数表示第一个控制点的坐标，第三四个参数表示第二个控制点的坐标，第五六个参数表示最终的坐标点
        path.cubicTo(x + 20, y - 20, x + 60, y, x, y + 40);

        path.moveTo(x, y);
        path.cubicTo(x - 20, y - 20, x - 60, y, x, y + 40);

        canvas.drawPath(path, paint);
    }
}


















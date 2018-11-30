package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Arrays;
import java.util.List;

public class Practice10HistogramView extends View {

    private List<String> mStrings = Arrays.asList("froyo", "CB", "CS", "JB", "KitKat", "L", "M");

    private List<Integer> mIntegers = Arrays.asList(2, 6, 6, 20, 40, 50, 30);
    private Paint mPaint;

    public Practice10HistogramView(Context context) {
        super(context);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setStrokeWidth(1);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = 400;
        int margin = 20;

        int eachWidth = width / (mStrings.size()) - 20;

        int startX = getWidth() / 2 - 100;
        int startY = getHeight() / 2 + 100;

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        mPaint.setColor(Color.WHITE);
        canvas.drawLine(startX, startY, startX, startY - 200, mPaint);
        canvas.drawLine(startX, startY, startX + width+margin, startY, mPaint);

        //画下面的字的间距
        mPaint.setTextSize(12);
        int y = startY + 20;
        for (int i = 0; i < mStrings.size(); i++) {
            int textX = startX + (i + 1) * margin + i * eachWidth;
            Rect rect = new Rect();
            mPaint.getTextBounds(mStrings.get(i), 0, mStrings.get(i).length(), rect);
            canvas.drawText(mStrings.get(i), 0, mStrings.get(i).length(), textX + eachWidth / 2 - rect.width() / 2, y, mPaint);
        }

        //画柱形图
        for (int i = 0; i < mIntegers.size(); i++) {
            Rect rect = new Rect();
            rect.left =startX + (i + 1) * margin + i * eachWidth;
            rect.right=startX + (i + 1) * margin + i * eachWidth+eachWidth;
            rect.top=startY-mIntegers.get(i);
            rect.bottom = startY;
            canvas.drawRect(rect, mPaint);
        }

        String text = "直方图";
        mPaint.setTextSize(28);
        canvas.drawText(text,0,text.length(),getWidth()/2,getHeight()/2,mPaint);
    }
}


























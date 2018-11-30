package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Arrays;
import java.util.List;

public class Practice11PieChartView extends View {

    private List<Integer> mIntegers = Arrays.asList(40, 20, 7, 3, 20, 30);

    private List<String> mStrings = Arrays.asList("AAFSF", "BFDBC", "CDF", "DFE", "EDSFSDFD", "FFDCX");

    private int sum = 0;
    private int sumAngle = 360;
    private Paint mPaint;
    private Paint mTextPaint;

    /**
     * 分成四个象限
     */
    RectF rectF1 = new RectF();
    RectF rectF2 = new RectF();
    RectF rectF3 = new RectF();
    RectF rectF4 = new RectF();

    /**
     * 半径100
     */
    private int radius = 100;

    private int offset = 5;

    public Practice11PieChartView(Context context) {
        super(context);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.FILL);
        for (int i = 0; i < mIntegers.size(); i++) {
            sum = sum + mIntegers.get(i);
        }

        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setStrokeWidth(1);
        mTextPaint.setColor(Color.WHITE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        rectF1.set(getWidth() / 2 - radius, getHeight() / 2 - radius,
                getWidth() / 2 + radius, getHeight() / 2 + radius);

        rectF2.set(getWidth() / 2 - radius, getHeight() / 2 - radius - offset,
                getWidth() / 2 + radius, getHeight() / 2 + radius - offset);

        rectF3.set(getWidth() / 2 - radius - 5, getHeight() / 2 - radius - 5,
                getWidth() / 2 + radius - 5, getHeight() / 2 + radius - 5);

        rectF4.set(getWidth() / 2 - radius - 5, getHeight() / 2 - radius,
                getWidth() / 2 + radius - 5, getHeight() / 2 + radius);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        //用到数学知识 弧度制和角度值转换：弧度数/π=角度值/180°。  Math.cos(x); x指的是弧度。
//        1弧度=180/pai  度
//        1度 = pai/180  弧度

//        如：30度的余弦=Math.cos(30*Math.PI/180);
        //x = r*cosθ

        float sumSweepAngle = 0f;
        for (int i = 0; i < mStrings.size(); i++) {
            float sweepAngle = (mIntegers.get(i) * sumAngle) / sum;
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            mPaint.setColor(Color.rgb(red, green, blue));
            Log.d("onDraw", "onDraw: SweepAngle= " + sweepAngle);

            if (sumSweepAngle < 180) {
                float centerDegree = sumSweepAngle + sweepAngle/2;
                if (sumSweepAngle < 90) {
                    //sweepAngle 正数表示顺时针扫过的面积弧度
                    canvas.drawArc(rectF1, sumSweepAngle, sweepAngle, true, mPaint);

                    //画线和text
                    float x = (float) (getWidth()/2 + radius*Math.cos(centerDegree*Math.PI/180));
                    float y =(float) (getHeight()/2 + radius*Math.sin(centerDegree*Math.PI/180));
                    float endX = x +25;
                    float endY = y+25;
                    canvas.drawLine(x,y,endX,endY,mTextPaint);
                    canvas.drawLine(endX,endY,endX+30,endY,mTextPaint);
                    canvas.drawText(mStrings.get(i),0,mStrings.get(i).length(),endX+35,endY,mTextPaint);
                } else {
                    canvas.drawArc(rectF4, sumSweepAngle, sweepAngle, true, mPaint);
                }
            } else {
                if (sumSweepAngle < 270) {
                    canvas.drawArc(rectF3, sumSweepAngle, sweepAngle, true, mPaint);
                } else {
                    //sweepAngle 正数表示顺时针扫过的面积弧度
                    canvas.drawArc(rectF2, sumSweepAngle, sweepAngle, true, mPaint);
                }
            }
            sumSweepAngle = sumSweepAngle + sweepAngle;
        }

    }
}








































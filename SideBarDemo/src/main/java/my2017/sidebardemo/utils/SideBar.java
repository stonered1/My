package my2017.sidebardemo.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author Stone
 * @version V1.0
 * @description:
 * @date 17/3/24 21:58
 * @email redsstone@163.com
 */
public class SideBar extends View {

    private Context context;
    //private SlideLetter slideLetter;
    private Paint paint;
    private String[] sortKey = {"#", "A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z"
    };
    public SideBar(Context context) {
        super(context);
        init(context);
    }

    public SideBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SideBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        this.context = context;
    }
    @Override
    protected void onDraw(Canvas canvas) {

        if (paint == null){
            paint = new Paint();
        }
        paint.setColor(Color.GRAY);
        paint.setTextSize(15);
        for (int i = 0; i < sortKey.length; i++){
            canvas.drawText(sortKey[i], 8, 20 *(i+1) +100, paint);
        }
        super.onDraw(canvas);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        /*if(mSlideLetter == null){//获取contactsLayout的实例
            mSlideLetter = context.();
        }
        // 触发事件时获取当前坐标
        int y = (int) event.getY();
        //当前使用的是绝对坐标，对不不同机型待改进
        if (y >= 100 && y <= 640) {
            // 监听按下时的事件
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                mSlideLetter.showLetter();
                // 监听抬起的事件
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                mSlideLetter.hideLetter();
            }
            // 监听move的事件，text随着手势移动
            else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                mSlideLetter.showLetter();
            }
            int number = (y - 105) / 20;
            String letter = sortKey[number];
            mSlideLetter.showToast(letter);
            invalidate();
        } else {
            mSlideLetter.hideLetter();
        }
        return true;
    }


    public interface SlideLetter{

        *//**
         * 字母可见
         *//*
        void showLetter();

        *//**
         * 隐藏字母
         *//*
        void hideLetter();

        *//**
         * 显示字母
         *//*

        void showToast(String letter);*/
        return false;
    }
}

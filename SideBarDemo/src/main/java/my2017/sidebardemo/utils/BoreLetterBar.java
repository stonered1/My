package my2017.sidebardemo.utils;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author Stone
 * @version V1.0
 * @description:
 * @date 17/3/25 21:50
 * @email redsstone@163.com
 */
public class BoreLetterBar extends LinearLayout {

    private int layoutType;
    private OnLetterChangedListener listener;
    private String[] mItems = {
            "A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z"
    };
    public BoreLetterBar(Context context) {
        super(context);
    }

    public BoreLetterBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER_VERTICAL);
        initItems();
        setItemsLayoutType(0);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final int action = event.getAction();
        TextView child = null;
        switch (action & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                child = findChildByLocation(event.getX(), event.getY());
                if (listener != null){
                    listener.onLetterSelected(child == null ? null : child.getText().toString());
                }
                break;

            case MotionEvent.ACTION_UP:

                //抬起视为非选中操作
                if (listener != null){
                    listener.onLetterSelected(null);
                }
                break;
        }
        return true;
    }


    public void setItemsLayoutType(int layoutType){
        this.layoutType = layoutType;
        initItems();
    }


    private TextView findChildByLocation(float x, float y){
        TextView child = null;
        //第一个child的top位置
        int mContentTop = getChildAt(0).getTop();
        int mContentBottom = getChildAt(getChildCount() - 1).getBottom();
        int defSize = (mContentBottom - mContentTop)/mItems.length;

        int index = (int) ((y - mContentTop)/defSize);

        if (index >= 0 && index < mItems.length && x >= 0 && x <= getWidth()){
            child = (TextView) getChildAt(index);
        }
        return child;
    }

    /**
     *
     */
    private void initItems() {
        //先移除所有的child
        removeAllViews();
        //根据Item添加textView
        for(CharSequence s : mItems){
            TextView childTextView = new TextView(getContext());
            childTextView.setText(s);
            childTextView.setTextSize(10);
            childTextView.setTextColor(Color.WHITE);

            LinearLayout.LayoutParams params;
            if (layoutType == 1){

                params = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
                );

                //字母间的距离
                int padding = dp2px(4);
                params.setMargins(0, padding, 0, 0);
            } else {
                params = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, 0
                );
                params.weight = 1;
            }
            childTextView.setLayoutParams(params);
            addView(childTextView);

        }
    }

    /*public BoreLetterBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }*/

    public int dp2px(float dpValue){
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue*scale +0.5f);
    }

    public void setOnLetterChangedListener(OnLetterChangedListener listener) {
        this.listener = listener;
    }

    /**
     * 获取字母栏字母的接口
     */
    public interface OnLetterChangedListener{
        /**
         * 选择字母
         * @param letter 从字母栏选择的字母,null时代表无选中字母,或抬起未选择状态
         */
        void onLetterSelected(String letter);
    }

    /**
     * 设置字母的颜色
     * @param color
     */
    public void setChildTextColor(int color){
        TextView child = null;
        for (int i=0; i < getChildCount(); i++){
            child = (TextView) getChildAt(i);
            child.setTextColor(color);
        }
    }




}

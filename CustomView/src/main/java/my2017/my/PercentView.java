package my2017.my;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Stone on 17/3/4.
 */

public class PercentView extends View {


    private final static String TAG = PercentView.class.getSimpleName();
    private Paint mPaint;
    private RectF oval;
    private static final int LEFT = 0;
    private static final int TOP = 1;
    private static final int CENTER = 2;
    private static final int RIGHT = 3;
    private static final int BOTTOM = 4;
    private int gravity = CENTER;
    private int backgroundColor = Color.GRAY;
    private int progressColor = Color.BLUE;
    private float radius;
    private int progress;
    private float centerX = 0;
    private float centerY = 0;
    public PercentView(Context context) {
        super(context);
        init();
    }

    public PercentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPrams(context, attrs);
    }

    public PercentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPrams(context, attrs);
    }


    private void init(){
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        oval=new RectF();
    }


    private void initPrams(Context context, AttributeSet attrs){
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        oval = new RectF();

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PercentView);
        if (typedArray != null){
            gravity = typedArray.getInt(R.styleable.PercentView_percent_circle_gravity, CENTER);
            backgroundColor = typedArray.getColor(R.styleable.PercentView_percent_background_color, Color.GRAY);
            progressColor = typedArray.getColor(R.styleable.PercentView_percent_progress_color, Color.BLUE);
            radius = typedArray.getDimension(R.styleable.PercentView_percent_circle_radius, 0);
            progress = typedArray.getInt(R.styleable.PercentView_percent_circle_progress, 0);
            typedArray.recycle();
        }

    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        /*super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        Log.e(TAG, "onMeasure--widthMode-->" + widthMode);
        switch (widthMode) {
            case MeasureSpec.EXACTLY:

                break;
            case MeasureSpec.AT_MOST:

                break;
            case MeasureSpec.UNSPECIFIED:

                break;
        }
        Log.e(TAG, "onMeasure--widthSize-->" + widthSize);
        Log.e(TAG, "onMeasure--heightMode-->" + heightMode);
        Log.e(TAG, "onMeasure--heightSize-->" + heightSize);
        */

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        Log.e(TAG, "onMeasure--widthMode-->" + widthMode);
        switch (widthMode) {
            case MeasureSpec.EXACTLY://
                break;
            case MeasureSpec.AT_MOST:
                break;
            case MeasureSpec.UNSPECIFIED:
                break;
        }
        Log.e(TAG, "onMeasure--widthSize-->" + widthSize);
        Log.e(TAG, "onMeasure--heightMode-->" + heightMode);
        Log.e(TAG, "onMeasure--heightSize-->" + heightSize);
        int with = getWidth();
        int height = getHeight();
        Log.e(TAG, "onDraw---->" + with + "*" + height);
        centerX = with / 2;
        centerY = with / 2;
        switch (gravity) {
            case LEFT:
                centerX = radius + getPaddingLeft();
                break;
            case TOP:
                centerY = radius + getPaddingTop();
                break;
            case CENTER:
                break;
            case RIGHT:
                centerX = with - radius - getPaddingRight();
                break;
            case BOTTOM:
                centerY = height - radius - getPaddingBottom();
                break;
        }
        float left = centerX - radius;
        float top = centerY - radius;
        float right = centerX + radius;
        float bottom = centerY + radius;
        oval.set(left, top, right, bottom);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.e(TAG, "onLayout");
    }

    @Override
    protected void onDraw(Canvas canvas) {

        /*super.onDraw(canvas);
        mPaint.setColor(Color.GRAY);
        // FILL填充, STROKE描边,FILL_AND_STROKE填充和描边
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        int with = getWidth();
        int height = getHeight();
        Log.e(TAG, "onDraw---->" + with + "*" + height);
        float radius = with / 4;
        canvas.drawCircle(with / 2, with / 2, radius, mPaint);
        mPaint.setColor(Color.BLUE);
        oval.set(with / 2 - radius, with / 2 - radius, with / 2
                + radius, with / 2 + radius);//用于定义的圆弧的形状和大小的界限
        canvas.drawArc(oval, 270, 120, true, mPaint);  //根据进度画圆弧
        */
        mPaint.setColor(backgroundColor);
        // FILL填充, STROKE描边,FILL_AND_STROKE填充和描边
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawCircle(centerX, centerY, radius, mPaint);
        mPaint.setColor(progressColor);

        double percent = progress * 1.0 / 100;
        int angle = (int) (percent * 360);
        canvas.drawArc(oval, 270, angle, true, mPaint);  //根据进度画圆弧
    }

}

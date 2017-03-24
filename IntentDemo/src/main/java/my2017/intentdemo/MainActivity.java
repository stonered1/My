package my2017.intentdemo;

import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_CODE_PICK_IMAGE = 1;
    private Button alarmBt;
    private Button cameraBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView(){
        alarmBt = (Button) findViewById(R.id.my_button);
        cameraBt = (Button) findViewById(R.id.goto_camera);

        alarmBt.setOnClickListener(this);
        cameraBt.setOnClickListener(this);
    }


    /**
     * 设置闹钟
     * @param message 闹钟的标题
     * @param hour  小时
     * @param minutes 分钟
     */
    public void creatAlarm(String message, int hour, int minutes){
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);

        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }


    private void capturePhone(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");//相片类型
        startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.my_button://设置闹钟定时
                creatAlarm("起来了", 16, 15);
                break;
            case R.id.goto_camera://去相机
                capturePhone();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_PICK_IMAGE){
            Uri uri = data.getData();
        }

    }
}

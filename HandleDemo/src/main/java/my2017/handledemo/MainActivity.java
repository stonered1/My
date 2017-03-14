package my2017.handledemo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    class CalThread extends Thread{

        public Handler mHandler;
        @Override
        public void run() {

            mHandler = new Handler(Looper.getMainLooper()){
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);

                    button.setText("Stone");


                }
            };

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        final CalThread calThread = new CalThread();
        calThread.start();
        Button button = (Button) findViewById(R.id.my_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calThread.mHandler.sendEmptyMessage(1);
            }
        });
    }

    private void initView() {

        button = (Button) findViewById(R.id.my_button);

    }
}

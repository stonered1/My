package my2017.my;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import my2017.my.uitl.CustomTitleBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomTitleBar customTitleBar = (CustomTitleBar) findViewById(R.id.my_titlebar);
        customTitleBar.setTitleClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.title_bar_left:
                        Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.title_bar_right:
                        Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

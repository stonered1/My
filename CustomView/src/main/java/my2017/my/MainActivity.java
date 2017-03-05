package my2017.my;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import my2017.my.uitl.CustomTitleBar;
import my2017.my.uitl.TagsLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_silder_bar);

        /*CustomTitleBar customTitleBar = (CustomTitleBar) findViewById(R.id.my_titlebar);
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
        });*/


        /*TagsLayout imageViewGroup = (TagsLayout) findViewById(R.id.image_layout);
        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        String[] string={"从我写代码那天起，我就没有打算写代码","从我写代码那天起","我就没有打算写代码","没打算","写代码"};
        for (int i = 0; i < 5; i++) {
            TextView textView = new TextView(this);
            textView.setText(string[i]);
            textView.setTextColor(Color.WHITE);
            textView.setBackgroundColor(Color.BLUE);
            imageViewGroup.addView(textView, lp);
        }*/
    }
}

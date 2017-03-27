package my2017.sidebardemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import my2017.sidebardemo.bean.DataBean;
import my2017.sidebardemo.utils.BoreLetterBar;

public class MainActivity extends AppCompatActivity implements BoreLetterBar.OnLetterChangedListener {

    private TextView showTV;
    private BoreLetterBar boreLetterBar;
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        float a = 0.8f;
        int b = (int) a;
        Log.e("stone","b="+b);
        initView();


    }

    @Override
    public void onLetterSelected(String letter) {
        if (letter == null){
            showTV.setVisibility(View.GONE);
        } else {
            showTV.setVisibility(View.VISIBLE);
            showTV.setText(letter);
        }
    }

    /**
     * 初始化视图
     */
    private void initView(){
        showTV = (TextView) findViewById(R.id.tv_firstletter_overlay);
        boreLetterBar = (BoreLetterBar) findViewById(R.id.slider_bar);
        lv = (ListView) findViewById(R.id.list_view);

        boreLetterBar.setOnLetterChangedListener(this);
        boreLetterBar.setChildTextColor(Color.BLACK);
    }


    /**
     * 初始化数据
     */
    private void initData(){

        //模拟数据
        List<DataBean> datas = new ArrayList<DataBean>();
        for (int i = 0; i < 5; i++){
            DataBean dataBean = new DataBean();
            dataBean.setName("MMMM" + i);
            datas.add(dataBean);
        }
        for (int i = 0; i < 5; i++) {
            DataBean data = new DataBean();
            data.setName("VVV" + i);
            datas.add(data);
        }
        for (int i = 0; i < 5; i++) {
            DataBean data = new DataBean();
            data.setName("PPP" + i);
            datas.add(data);
        }
        for (int i = 0; i < 5; i++) {
            DataBean data = new DataBean();
            data.setName("NNN" + i);
            datas.add(data);
        }
        for (int i = 0; i < 5; i++) {
            DataBean data = new DataBean();
            data.setName("BBB" + i);
            datas.add(data);
        }
        for (int i = 0; i < 5; i++) {
            DataBean data = new DataBean();
            data.setName("AAA" + i);
            datas.add(data);
        }


    }
}

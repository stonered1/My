package my2017.listviewdemo;

import android.content.Context;
import android.content.Intent;
import android.media.audiofx.LoudnessEnhancer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import my2017.listviewdemo.bean.Datas;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;

    private List<Datas> listDatas;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.my_list_view);
        button = (Button) findViewById(R.id.my_button);
        listView.setOnItemClickListener(this);
        listDatas = getDatas();
        MyAdapter adapter = new MyAdapter(this, listDatas);
        listView.setAdapter(adapter);
        Log.e("stone", listView.getAdapter().getCount()+"");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, listView.getChildCount()+"", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();
    }

    /**
     * ListView的适配器
     */
    class MyAdapter extends BaseAdapter {

        private Context context;
        private List<Datas> listDatas;

        public MyAdapter(Context context, List<Datas> listDatas) {
            this.context = context;
            this.listDatas = listDatas;
        }

        @Override
        public int getCount() {
            return listDatas.size();
        }

        @Override
        public Datas getItem(int position) {
            return listDatas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        Intent intent;
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {

                convertView = LayoutInflater.from(context).inflate(R.layout.item_listview, null);
                viewHolder = new ViewHolder();
                viewHolder.gridView = (GridViewForScroll) convertView.findViewById(R.id.my_grid_view);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            MyGridAdapter myAdapter = new MyGridAdapter(context, listDatas.get(position).getTitles());
            viewHolder.gridView.setAdapter(myAdapter);
            final int item = position;
            viewHolder.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(MainActivity.this, item +" " +position  , Toast.LENGTH_SHORT).show();
                    if (item == 0 && position ==0){//去gridView多选界面
                        intent = new Intent(MainActivity.this, GridViewActivity.class);
                        startActivity(intent);
                    }

                    if (item == 0 && position == 1){
                        intent = new Intent(MainActivity.this, ImageViewActivity.class);
                        startActivity(intent);
                    }
                }
            });

            return convertView;
        }


        private class ViewHolder {
            GridViewForScroll gridView;
        }
    }


    class MyGridAdapter extends BaseAdapter {

        private Context context;
        private List<String> datas;

        public MyGridAdapter(Context context, List<String> datas) {
            this.context = context;
            this.datas = datas;
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public String getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = LayoutInflater.from(context).inflate(R.layout.item_gridview, null);
                viewHolder.title = (TextView) convertView.findViewById(R.id.item_grid_view);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.title.setText(datas.get(position));
            return convertView;
        }


        private class ViewHolder {
            TextView title;
        }
    }

    private List<Datas> getDatas() {

        List<Datas> listDatas = new ArrayList<Datas>();
        for (int i = 0; i < 100; i++) {
            List<String> list = new ArrayList<String>();
            list.add("Stone" + i);
            list.add("Stone" + i);
            list.add("Stone" + i);
            list.add("Stone" + i);
            list.add("Stone" + i);
            list.add("Stone" + i);
            list.add("Stone" + i);
            list.add("Stone" + i);
            list.add("Stone" + i);
            list.add("Stone" + i);

            Datas datas = new Datas();
            datas.setTitles(list);
            listDatas.add(datas);

        }
        return listDatas;
    }
}

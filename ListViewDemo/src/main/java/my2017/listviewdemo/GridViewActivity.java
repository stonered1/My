package my2017.listviewdemo;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;

import my2017.listviewdemo.R;
import my2017.listviewdemo.util.GridItem;


/**
 * girdView 的多项选
 */
public class GridViewActivity extends AppCompatActivity implements AbsListView.MultiChoiceModeListener {

    private GridView gridView;
    private GridAdapter adapter;
    private TextView mTextView;
    private final static int MENU_SELECT_ALL = 0;
    private final static int MENU_UNSELECT_ALL = MENU_SELECT_ALL + 1;
    private int[] imgsId = new int[]{
            R.mipmap.img_1, R.mipmap.img_2, R.mipmap.img_3, R.mipmap.img_4,
            R.mipmap.img_5, R.mipmap.img_6, R.mipmap.img_7, R.mipmap.img_8,
            R.mipmap.img_9, R.mipmap.img_1, R.mipmap.img_2, R.mipmap.img_3
    };

    private HashMap<Integer, Boolean>  mSecteMaps = new HashMap<Integer, Boolean>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //ActionBar actionBar = getSupportActionBar();//高版本可以换成 ActionBar actionBar = getActionBar();
        setContentView(R.layout.activity_grid_view);
        gridView = (GridView) findViewById(R.id.my_grid_view);
        gridView.setChoiceMode(GridView.CHOICE_MODE_MULTIPLE_MODAL);
        adapter = new GridAdapter(this);
        gridView.setAdapter(adapter);//适配数据
        gridView.setMultiChoiceModeListener(this);//设置多选监听

    }

    @Override
    public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
        mTextView.setText(formatString(gridView.getCheckedItemCount()));
        mSecteMaps.put(position, checked);
        mode.invalidate();
    }


    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {

        View v = LayoutInflater.from(this).inflate(R.layout.actionbar_layout, null);
        mTextView = (TextView) v.findViewById(R.id.actionbar_tv);
        mTextView.setText(formatString(gridView.getCheckedItemCount()));
        mode.setCustomView(v);
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        menu.getItem(MENU_SELECT_ALL).setEnabled(gridView.getCheckedItemCount() != gridView.getCount());
        return true;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_select:

                for (int i = 0; i < gridView.getCount(); i++) {
                    gridView.setItemChecked(i, true);
                    mSecteMaps.put(i, true);
                }
                break;
            case R.id.menu_unselect:
                for (int i = 0; i < gridView.getCount(); i++) {
                    gridView.setItemChecked(i, false);
                    mSecteMaps.clear();
                }
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        gridView.deferNotifyDataSetChanged();
    }



    /*private String formatString(int count){

        //return String.format(getResources().getString(R.string.selection), Integer.);
    }
*/
    private String formatString(int count) {
        return String.format(getString(R.string.selection), count);
    }


    private class GridAdapter extends BaseAdapter{

        private Context mContent;
        public GridAdapter(Context mContent) {
            this.mContent = mContent;
        }

        @Override
        public int getCount() {
            return imgsId.length;
        }

        @Override
        public Integer getItem(int position) {
            return Integer.valueOf(imgsId[position]);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            GridItem gridItem;
            if (convertView == null){
                gridItem = new GridItem(mContent);
                gridItem.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.MATCH_PARENT));
            }else {
                gridItem = (GridItem) convertView;
            }

            gridItem.setImgResId(imgsId[position]);
            gridItem.setChecked(mSecteMaps.get(position) == null ? false : mSecteMaps.get(position));
            return gridItem;
        }


    }
}

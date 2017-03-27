package my2017.sidebardemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import my2017.sidebardemo.bean.DataBean;

/**
 * @author Stone
 * @version V1.0
 * @description:
 * @date 17/3/26 09:47
 * @email redsstone@163.com
 */
public class ListLetterAdapter extends BaseAdapter {

    private Context context;
    private List<DataBean> datas;

    public ListLetterAdapter(Context context, List<DataBean> datas) {
        this.context = context;
        this.datas = datas;
        initList();
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public DataBean getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    private void initList(){

    }
}

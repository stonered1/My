package my2017.sidebardemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import my2017.sidebardemo.R;
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
        HoldView holdView = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_view, null);
            holdView = new HoldView();
            holdView.tv_firstLetter = (TextView) convertView.findViewById(R.id.firstletter);
            holdView.tv_name = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(holdView);
        } else {
            holdView = (HoldView) convertView.getTag();
        }

        
        return convertView;
    }

    private class HoldView{
        public TextView tv_firstLetter;
        public TextView tv_name;
    }
    private void initList(){

    }
}

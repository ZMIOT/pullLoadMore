package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public abstract class CommonAdapter<T> extends BaseAdapter{

    private Context mContext;
    private List<T> mList;
    private LayoutInflater mInflater;
    private final int mItemLayoutId;

    public CommonAdapter(Context mContext, List<T> mList, LayoutInflater mInflater, int mItemLayoutId) {
        this.mContext = mContext;
        this.mList = mList;
        this.mInflater = mInflater;
        this.mItemLayoutId = mItemLayoutId;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public T getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder = getViewHolder(position, convertView,parent);
        convert(viewHolder, getItem(position));
        return viewHolder.getConvertView();
    }

    public abstract void convert(ViewHolder helper,T item);


    private ViewHolder getViewHolder(int position, View convertView,
                                     ViewGroup parent)
    {
        return ViewHolder.get(mContext, convertView, parent, mItemLayoutId,
                position);
    }
}

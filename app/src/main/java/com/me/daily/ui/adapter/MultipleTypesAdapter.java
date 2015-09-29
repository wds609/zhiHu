package com.me.daily.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.me.daily.ui.adapter.holder.ViewHolderFactory;
import com.me.daily.ui.adapter.item.MultipleTypesAdapterItem;

import java.util.ArrayList;

/**
 * Created by wds on 9/22/2015.
 */
public class MultipleTypesAdapter extends RecyclerView.Adapter {
    private ArrayList<MultipleTypesAdapterItem> mData = new ArrayList<>();
    private Context mContext;

    public MultipleTypesAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getViewType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ViewHolderFactory.getViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        mData.get(position).onBindViewHolder(holder, mContext);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public ArrayList<MultipleTypesAdapterItem> getDataList() {
        return mData;
    }
}

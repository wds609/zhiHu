package com.me.daily.ui.adapter.item;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

/**
 * Created by wds on 9/23/2015.
 */
public abstract class MultipleTypesAdapterItem<T> {

    public int viewType;

    public T data;

    public MultipleTypesAdapterItem(int viewType, T data) {
        this.viewType = viewType;
        this.data = data;
    }

    public abstract void onBindViewHolder(RecyclerView.ViewHolder holder, Context context);

    public int getViewType() {
        return viewType;
    }
}

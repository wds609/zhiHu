package com.me.daily.ui.adapter.item;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.me.daily.ui.adapter.holder.DailyNewsHeaderViewHolder;
import com.me.daily.utils.DateUtil;

import java.util.Date;

/**
 * Created by wds on 9/24/2015.
 */
public class DailyNewsHeaderItem extends MultipleTypesAdapterItem<Date> {
    public DailyNewsHeaderItem(int viewType, Date data) {
        super(viewType, data);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, Context context) {
        ((DailyNewsHeaderViewHolder) holder).date.setText(DateUtil.getFormatedDate(data));
    }
}

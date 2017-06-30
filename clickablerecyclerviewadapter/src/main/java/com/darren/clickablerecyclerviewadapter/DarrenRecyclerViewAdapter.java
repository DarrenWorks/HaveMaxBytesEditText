package com.darren.clickablerecyclerviewadapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * Created by Darren on 2017/5/25.
 * <p>This is a viewHolder which implement the onClickListener.</p>
 * <p>You need to use this and {@link DarrenViewHolder} together.</p>
 */

public abstract class DarrenRecyclerViewAdapter<VH extends DarrenViewHolder> extends RecyclerView.Adapter<VH> {
    DarrenOnItemClickListener mOnClickListener;
    DarrenOnItemLongClickListener mOnLongClickListener;

    public void setOnItemClickListener(DarrenOnItemClickListener listener) {
        mOnClickListener = listener;
    }

    public void setOnItemLongClickListener(DarrenOnItemLongClickListener listener) {
        mOnLongClickListener = listener;
    }

    public DarrenOnItemClickListener getOnItemClickListener() {
        return mOnClickListener;
    }

    public DarrenOnItemLongClickListener getOnItemLongClickListener() {
        return mOnLongClickListener;
    }


    public interface DarrenOnItemClickListener {
        void onRvItemClick(View view, int position);
    }

    public interface DarrenOnItemLongClickListener {
        void onRvItemLongClick(View view, int position);
    }
}

package com.darren.clickablerecyclerviewadapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.darren.clickablerecyclerviewadapter.DarrenRecyclerViewAdapter.DarrenOnItemClickListener;

/**
 * Created by Darren on 2017/5/25.
 *
 *<p> this is a viewHolder which implement onClickListener and onLongClickListener.</p>
 */

public abstract class DarrenViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    private DarrenOnItemClickListener mOnClickListener;
    private DarrenRecyclerViewAdapter.DarrenOnItemLongClickListener mOnLongClickListener;

    public DarrenViewHolder(View itemView) {
        super(itemView);
    }


//    @Override
//    public void onClick(View view) {
//        if (mOnClickListener != null) {
//            mOnClickListener.onRvItemClick(view, getLayoutPosition());
//        }
//    }
//
//    @Override
//    public boolean onLongClick(View view) {
//        if (mOnLongClickListener != null) {
//            mOnLongClickListener.onRvItemLongClick(view, getLayoutPosition());
//        }
//        return false;
//    }

    public void setOnClickListener(DarrenOnItemClickListener listener) {
        mOnClickListener = listener;
    }

    public void setOnLongClickListener(DarrenRecyclerViewAdapter.DarrenOnItemLongClickListener listener) {
        mOnLongClickListener = listener;
    }

    /**
     * please call this in constructor
     */
    void setItemOnClick(View... views) {
        for (View view : views) {
            view.setOnClickListener(this);
        }
    }

    /**
     * please call this in constructor
     */
    void setItemOnLongClick(View... views) {
        for (View view : views) {
            view.setOnLongClickListener(this);
        }
    }
}

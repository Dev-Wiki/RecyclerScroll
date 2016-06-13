package net.devwiki.recyclerscroll.base;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * RecyclerView的基础Holder
 * Created by zyz on 2016/4/28.
 */
public abstract class BaseHolder<M> extends RecyclerView.ViewHolder {

    public BaseHolder(ViewGroup group, @LayoutRes int resId){
        super(LayoutInflater.from(group.getContext()).inflate(resId, group, false));
    }

    public abstract void setData(M data);

    protected <T extends View> T getView(@IdRes int id) {
        return (T) itemView.findViewById(id);
    }

    protected Context getContext(){
        return itemView.getContext();
    }
}

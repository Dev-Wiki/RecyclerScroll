package net.devwiki.recyclerscroll.base;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * 可监听滚动事件的RecyclerView
 * Created by zyz on 2016/6/13.
 */

public class ScrollRecycler extends RecyclerView {

    public ScrollRecycler(Context context) {
        super(context);
    }

    public ScrollRecycler(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setOnScrollCallback(final OnScrollCallback callback) {
        if (callback == null) {
            return;
        }
        addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                callback.onStateChanged(ScrollRecycler.this, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    if (!recyclerView.canScrollVertically(1)) {
                        callback.onScrollToBottom();
                    }
                    if (!recyclerView.canScrollVertically(-1)) {
                        callback.onScrollToTop();
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    callback.onScrollDown(ScrollRecycler.this, dy);
                } else {
                    callback.onScrollUp(ScrollRecycler.this, dy);
                }
            }
        });
    }
}

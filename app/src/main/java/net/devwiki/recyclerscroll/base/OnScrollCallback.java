package net.devwiki.recyclerscroll.base;

/**
 * Created by zyz on 2016/6/13.
 */

public interface OnScrollCallback {

    void onStateChanged(ScrollRecycler recycler, int state);

    void onScrollUp(ScrollRecycler recycler, int dy);

    void onScrollToBottom();

    void onScrollDown(ScrollRecycler recycler, int dy);

    void onScrollToTop();
}

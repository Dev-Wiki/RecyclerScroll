package net.devwiki.recyclerscroll.book;

import android.view.ViewGroup;

import net.devwiki.recyclerscroll.R;
import net.devwiki.recyclerscroll.base.BaseAdapter;

/**
 * 图书列表的适配器
 * Created by zyz on 2016/6/13.
 */

public class BookAdapter extends BaseAdapter<Book, BookHolder> {

    public BookAdapter() {
        super();
    }

    @Override
    public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BookHolder(parent, R.layout.item_book);
    }
}

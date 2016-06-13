package net.devwiki.recyclerscroll.book;

import android.support.annotation.LayoutRes;
import android.view.ViewGroup;
import android.widget.TextView;

import net.devwiki.recyclerscroll.R;
import net.devwiki.recyclerscroll.base.BaseHolder;

/**
 * Created by zyz on 2016/6/13.
 */

public class BookHolder extends BaseHolder<Book> {

    private TextView bookTv;

    public BookHolder(ViewGroup group, @LayoutRes int resId) {
        super(group, resId);
        bookTv = getView(R.id.book_tv);
    }

    @Override
    public void setData(Book data) {
        bookTv.setText(data.getName() + ":" + data.getAuthor());
    }
}

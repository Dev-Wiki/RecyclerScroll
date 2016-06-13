package net.devwiki.recyclerscroll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import net.devwiki.recyclerscroll.base.DividerItemDecoration;
import net.devwiki.recyclerscroll.base.MockService;
import net.devwiki.recyclerscroll.base.OnScrollCallback;
import net.devwiki.recyclerscroll.base.ScrollRecycler;
import net.devwiki.recyclerscroll.book.BookAdapter;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static final int TAG_CHECK_SCROLL_UP = 1;
    private static final int TAG_CHECK_SCROLL_DOWN = -1;

    private ScrollRecycler demoRv;
    private BookAdapter bookAdapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        demoRv = (ScrollRecycler) findViewById(R.id.demo_rv);
        layoutManager = new LinearLayoutManager(this);
        demoRv.setLayoutManager(layoutManager);
        demoRv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        bookAdapter = new BookAdapter();
        bookAdapter.fillList(MockService.getBookList());
        demoRv.setAdapter(bookAdapter);
        setScrollCallback();
    }

    private void setScrollCallback() {
        demoRv.setOnScrollCallback(new OnScrollCallback() {
            @Override
            public void onStateChanged(ScrollRecycler recycler, int state) {
                Log.i(TAG, "onStateChanged: state:" + state);
            }

            @Override
            public void onScrollUp(ScrollRecycler recycler, int dy) {
                Log.i(TAG, "onScrollUp: " + dy);
            }

            @Override
            public void onScrollDown(ScrollRecycler recycler, int dy) {
                Log.i(TAG, "onScrollDown: " + dy);
            }
        });
    }

    private void setScrollListener() {
        demoRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.i(TAG, "-----------onScrollStateChanged-----------");
                Log.i(TAG, "newState: " + newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.i(TAG, "-----------onScrolled-----------");
                Log.i(TAG, "dx: " + dx);
                Log.i(TAG, "dy: " + dy);
                Log.i(TAG, "CHECK_SCROLL_UP: " + recyclerView.canScrollVertically(TAG_CHECK_SCROLL_UP));
                Log.i(TAG, "CHECK_SCROLL_DOWN: " + recyclerView.canScrollVertically(TAG_CHECK_SCROLL_DOWN));
            }
        });
    }
}

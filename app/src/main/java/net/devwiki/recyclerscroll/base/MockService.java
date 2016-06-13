package net.devwiki.recyclerscroll.base;

import net.devwiki.recyclerscroll.book.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试提供
 * Created by zyz on 2016/6/13.
 */

public class MockService {

    /**
     * 获取图示列表
     * @return 图书列表
     */
    public static List<Book> getBookList () {
        List<Book> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Book book = new Book();
            book.setName("Book-" + i);
            book.setAuthor("Author-" + i);
            list.add(book);
        }
        return list;
    }
}

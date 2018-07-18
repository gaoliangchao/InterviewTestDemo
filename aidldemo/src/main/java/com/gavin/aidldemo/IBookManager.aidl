// IBookManager.aidl
package com.gavin.aidldemo;

// Declare any non-default types here with import statements

import com.gavin.aidldemo.Book;
interface IBookManager {

    List<Book> getBookList();

    void addBook(in Book book);
}

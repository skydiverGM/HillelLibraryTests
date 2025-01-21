package ua.hillel;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        if (isExist(book)) {
            throw new LibraryException("Book already exists");
        } else if (book == null) {
            throw new LibraryException("Book cannot be null");
        } else {
            books.add(book);
        }
    }

    public boolean removeBook(Book book) {
        if (!isExist(book) || book == null) {
            return false;
        } else {
            books.remove(book);
            return true;
        }
    }

    public List<Book> getBooks() {
            return books;
    }

    public int getBookCount() {
        return books.size();
    }

    private boolean isExist(Book book) {
        return books.contains(book);
    }
}

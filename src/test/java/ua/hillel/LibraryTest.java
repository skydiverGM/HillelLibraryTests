package ua.hillel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;
    private Book book;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book = new Book("Book", "Writer");
    }

    @Test
    void addBook_Book_Added() {
        library.addBook(book);
        List<Book> books = library.getBooks();
        assertTrue(books.contains(book));
        assertEquals(book.getTitle(), books.get(0).getTitle());
        assertEquals(book.getAuthor(), books.get(0).getAuthor());
    }

    @Test
    void addBook_Null_ThrowsException() {
        book = null;
        LibraryException exception = assertThrows(LibraryException.class, () -> library.addBook(book));
        assertEquals("Book cannot be null", exception.getMessage());
    }

    @Test
    void addBook_ExistingBook_ThrowsException(){
        library.addBook(book);
        assertThrows(LibraryException.class, () -> library.addBook(book));
    }

    @Test
    void removeBook_Book_RemovedTrue() {
        library.addBook(book);
        assertTrue(library.removeBook(book));
        assertFalse(library.getBooks().contains(book));
    }

    @Test
    void removeBook_NullOrNonExistingBook_False() {
        assertFalse(library.removeBook(book));
        library.addBook(book);
        book = null;
        assertFalse(library.removeBook(book));
    }

    @Test
    void getBooks_Library_ListOfBooks() {
        List<Book> list = library.getBooks();
        assertTrue(list.isEmpty());
        library.addBook(book);
        list = library.getBooks();
        assertEquals(1, list.size());
        assertTrue(list.contains(book));
    }

    @Test
    void getBookCount_Library_NumberOfBooks() {
        assertEquals(0, library.getBookCount());
        library.addBook(book);
        assertEquals(1, library.getBookCount());
    }
}

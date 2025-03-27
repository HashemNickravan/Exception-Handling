package libraryDatabase;

import exceptions.BookNotFoundException;
import exceptions.EmptyLibraryException;
import exceptions.InvalidBookException;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) throws InvalidBookException {
        if (book == null) {
            throw new InvalidBookException("Book can't be empty!!!");
        }
        books.add(book);
    }

    public void borrowBook(String title) throws BookNotFoundException, EmptyLibraryException {
        if (books.isEmpty()) {
            throw new EmptyLibraryException("Library is empty!!!");
        }

        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                books.remove(book);
                System.out.println("borrowed: " + book);
                return;
            }
        }

        throw new BookNotFoundException("Book's title \"" + title + "\" not exist!!!");
    }

    public void returnBook(Book book) throws InvalidBookException {
        if (book == null) {
            throw new InvalidBookException("Can not show book!!!");
        }
        books.add(book);
        System.out.println("returned: " + book);
    }

    public void listBooks() throws EmptyLibraryException {
        if (books.isEmpty()) {
            throw new EmptyLibraryException("Library is empty!!!");
        }

        System.out.println("Books in library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}


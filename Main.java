import exceptions.BookNotFoundException;
import exceptions.EmptyLibraryException;
import exceptions.InvalidBookException;
import libraryDatabase.Book;
import libraryDatabase.Library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        try {
            library.listBooks();
        } catch (EmptyLibraryException e) {
            System.out.println(e.getMessage());
        }

        try {
            Book harryBook = new Book("Harry Potter", 1200);
            // بعضی وقتا فکر میکنم جورج اورول این کتابو واسه یه کشور دیگه نوشته :)
            Book theBestBook = new Book("1984", 700);
            Book nullBook = new Book(null, -3);
            Book emptyBook = new Book("", 20);
            Book interestingBook = new Book("A Brief History of Time", 500);
            Book hobbitBook = new Book("The Hobbit", 350);
            Book homesBook = new Book("Sherlock Holmes", 450);
            Book republicBook = new Book("The Republic", 600);
            Book atomicBook = new Book("Atomic Habits", 300);
            Book novelBook = new Book("To Kill a Mockingbird", 400);
            Book islamicBook = new Book("Islamic Economy", 250);
            // کتاب بالا عالیه واقعا، دلار 100 هزار تومانی هم کار دژمنه...
            //این شیطان بزرگ هم که 25 سال آینده رو نخواهد دید
            Book israelBook = new Book("Israel is bad", 450);

            library.addBook(harryBook);
            library.addBook(theBestBook);
            library.addBook(nullBook);
            library.addBook(emptyBook);
            library.addBook(interestingBook);
            library.addBook(hobbitBook);
            library.addBook(homesBook);
            library.addBook(republicBook);
            library.addBook(atomicBook);
            library.addBook(novelBook);
            library.addBook(islamicBook);
            library.addBook(israelBook);

        } catch (IllegalArgumentException | InvalidBookException e) {
            System.out.println(e.getMessage());
        }

        try {
            library.listBooks();
        } catch (EmptyLibraryException e) {
            System.out.println(e.getMessage());
        }

        try {
            library.borrowBook("Harry Potter");
            library.borrowBook("Sherlock Holmes");
            library.borrowBook("Atomic Habits");
        } catch (EmptyLibraryException | BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            library.returnBook(new Book("Harry Potter", 1200));
            library.returnBook(new Book("The Hobbit", 350));
        } catch (InvalidBookException e) {
            System.out.println(e.getMessage());
        }
    }
}

package libraryDatabase;

public class Book {
    private String title;
    private int pageCount;

    public Book(String title, int pageCount) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title part can not be empty!!!");
        }
        if (pageCount <= 0) {
            throw new IllegalArgumentException("Page numbers must be bigger than zero!!!");
        }
        this.title = title;
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }

    @Override
    public String toString() {
        return title + " (" + pageCount + " pages)";
    }
}


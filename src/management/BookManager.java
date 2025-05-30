package management;

import library.Book;
import library.Member;

import java.util.HashMap;
import java.util.Map;

public class BookManager {
    private Map<String, Book> books;
    private MemberManager memberManager;

    public BookManager(MemberManager memberManager) {
        this.memberManager = memberManager;
        this.books = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public Book getBookByIsbn(String isbn) {
        return books.get(isbn);
    }

    public boolean isBookAvailable(String isbn) {
        Book book = books.get(isbn);
        return book != null && book.isAvailable();
    }

    public void setBookAvailability(String isbn, boolean available) {
        Book book = books.get(isbn);
        if (book != null) {
            book.setAvailable(available);
        }
    }

    public void addToWaitlist(String isbn, String memberId) {
        Book book = books.get(isbn);
        Member member = memberManager.getMember(memberId);
        if (book != null && member != null) {
            book.addToWaitlist(member);
        }
    }

    public Member getNextFromWaitlist(String isbn) {
        Book book = books.get(isbn);
        if (book != null) {
            return book.getNextInWaitlist();
        }
        return null;
    }

    public boolean hasWaitlist(String isbn) {
        Book book = books.get(isbn);
        return book != null && book.hasWaitlist();
    }
}

package library;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String memberId;
    private String name;

    // Define a data structure to hold transactions of each member
    private List<Transaction> transactions;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.transactions = new ArrayList<>(); // Initialize the list
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public Transaction getLastTransaction() {
        if (!transactions.isEmpty()) {
            return transactions.get(transactions.size() - 1);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

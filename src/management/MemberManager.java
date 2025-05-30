package management;

import library.Member;
import library.Transaction;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MemberManager {
    private Map<String, Member> members;
    private Map<String, List<Transaction>> transactions;

    public MemberManager() {
        members = new HashMap<>();
        transactions = new HashMap<>();
    }

    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
        transactions.put(member.getMemberId(), new ArrayList<>());
    }

    public Member getMember(String memberId) {
        return members.get(memberId);
    }

    public void recordTransaction(String memberId, Transaction transaction) {
        List<Transaction> memberTransactions = transactions.get(memberId);
        if (memberTransactions != null) {
            memberTransactions.add(transaction);
        }
    }

    public Transaction getLastTransaction(String memberId) {
        List<Transaction> memberTransactions = transactions.get(memberId);
        if (memberTransactions != null && !memberTransactions.isEmpty()) {
            return memberTransactions.get(memberTransactions.size() - 1);
        }
        return null;
    }
}

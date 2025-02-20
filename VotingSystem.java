// Design a Voting System
// Description: Design a system where:
// Votes are stored in a HashMap (Candidate -> Votes).
// TreeMap is used to display the results in sorted order.
// LinkedHashMap is used to maintain the order of votes.

// Implement a Shopping Cart
// Description:
// Use HashMap to store product prices.
// Use LinkedHashMap to maintain the order of items added.
// Use TreeMap to display items sorted by price.


import java.util.*;

public class VotingSystem {
    private Map<String, Integer> voteMap = new HashMap<>();
    private Map<String, Integer> voteOrder = new LinkedHashMap<>();
    private TreeMap<String, Integer> sortedVotes = new TreeMap<>();

    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteOrder.getOrDefault(candidate, 0) + 1);
        sortedVotes.put(candidate, sortedVotes.getOrDefault(candidate, 0) + 1);
    }

    public void displayResults() {
        System.out.println("\nVotes in insertion order:");
        for (Map.Entry<String, Integer> entry : voteOrder.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nVotes sorted by candidate name:");
        for (Map.Entry<String, Integer> entry : sortedVotes.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public String getWinner() {
        return Collections.max(voteMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        VotingSystem voting = new VotingSystem();
        voting.castVote("Alice");
        voting.castVote("Bob");
        voting.castVote("Alice");
        voting.castVote("Charlie");
        voting.castVote("Bob");
        voting.castVote("Alice");

        voting.displayResults();
        System.out.println("\nWinner: " + voting.getWinner());
    }
}

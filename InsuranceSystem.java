// Insurance Policy Management System

// Build a system for managing insurance policies where you have to:
// Store and manage policies with unique identifiers.
// Retrieve and manipulate policies based on different criteria.
// Track policies by various attributes such as policyholder name and expiry date.

// Requirements:
// 1. Store Policies in a Map:
// Use HashMap to store policies with policy numbers as keys and policy
// details as values.
// Use LinkedHashMap to maintain the insertion order of policies.
// Use TreeMap to store policies sorted by expiry date.

// 2. Retrieve and Manipulate Policies:
// Implement methods to:
// Retrieve a policy by its number.
// List all policies expiring within the next 30 days.
// List all policies for a specific policyholder.
// Remove policies that are expired.





import java.time.LocalDate;
import java.util.*;

class Policy {
    String policyNumber;
    String policyHolder;
    LocalDate expiryDate;

    public Policy(String policyNumber, String policyHolder, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyHolder = policyHolder;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "{PolicyNumber=" + policyNumber + ", Holder=" + policyHolder + ", Expiry=" + expiryDate + "}";
    }
}

class InsurancePolicyManager {
    private Map<String, Policy> policyMap = new HashMap<>();
    private Map<String, Policy> insertionOrderPolicies = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<Policy>> sortedByExpiry = new TreeMap<>();

    public void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        insertionOrderPolicies.put(policy.policyNumber, policy);

        sortedByExpiry.putIfAbsent(policy.expiryDate, new ArrayList<>());
        sortedByExpiry.get(policy.expiryDate).add(policy);
    }

    public Policy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public List<Policy> getPoliciesExpiringWithin30Days() {
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(30);
        List<Policy> expiringSoon = new ArrayList<>();

        for (Map.Entry<LocalDate, List<Policy>> entry : sortedByExpiry.entrySet()) {
            if (entry.getKey().isAfter(today) && entry.getKey().isBefore(threshold)) {
                expiringSoon.addAll(entry.getValue());
            }
        }
        return expiringSoon;
    }

    public List<Policy> getPoliciesByHolder(String policyHolder) {
        List<Policy> policies = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.policyHolder.equals(policyHolder)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<LocalDate, List<Policy>>> iterator = sortedByExpiry.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<LocalDate, List<Policy>> entry = iterator.next();
            if (entry.getKey().isBefore(today)) {
                for (Policy policy : entry.getValue()) {
                    policyMap.remove(policy.policyNumber);
                    insertionOrderPolicies.remove(policy.policyNumber);
                }
                iterator.remove();
            }
        }
    }

    public void listAllPolicies() {
        for (Policy policy : insertionOrderPolicies.values()) {
            System.out.println(policy);
        }
    }
}

public class InsuranceSystem {
    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        manager.addPolicy(new Policy("P1001", "Alice", LocalDate.of(2025, 1, 10)));
        manager.addPolicy(new Policy("P1002", "Bob", LocalDate.of(2024, 3, 5)));
        manager.addPolicy(new Policy("P1003", "Alice", LocalDate.of(2024, 2, 25)));
        manager.addPolicy(new Policy("P1004", "Charlie", LocalDate.of(2024, 4, 15)));

        System.out.println("\nAll Policies:");
        manager.listAllPolicies();

        System.out.println("\nPolicy by Number (P1002): " + manager.getPolicyByNumber("P1002"));

        System.out.println("\nPolicies expiring within 30 days: " + manager.getPoliciesExpiringWithin30Days());

        System.out.println("\nPolicies for Alice: " + manager.getPoliciesByHolder("Alice"));

        manager.removeExpiredPolicies();
        System.out.println("\nAfter removing expired policies:");
        manager.listAllPolicies();
    }
}

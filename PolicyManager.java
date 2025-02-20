// Each policy has the following attributes:
// ● Policy Number (unique identifier)
// ● Policyholder Name
// ● Expiry Date
// ● Coverage Type (e.g., Health, Auto, Home)
// ● Premium Amount

// Requirements:
// 1. Store Unique Policies: Implement methods to store policies using different
// types of sets (HashSet, LinkedHashSet, TreeSet), each serving different
// purposes:
//  HashSet for quick lookups.
//  LinkedHashSet to maintain the order of insertion.
//  TreeSet to maintain policies sorted by expiry date.




import java.util.*;

class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "Policy{" +
                "Policy Number='" + policyNumber + '\'' +
                ", Policyholder='" + policyholderName + '\'' +
                ", Expiry Date=" + expiryDate +
                ", Coverage='" + coverageType + '\'' +
                ", Premium=$" + premiumAmount +
                '}';
    }
}

public class PolicyManager {
    private Set<Policy> hashSet;
    private Set<Policy> linkedHashSet;
    private Set<Policy> treeSet;

    public PolicyManager() {
        hashSet = new HashSet<>();
        linkedHashSet = new LinkedHashSet<>();
        treeSet = new TreeSet<>();
    }

    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    public void displayPolicies() {
        System.out.println("HashSet (Unordered, Fast Lookup):");
        for (Policy p : hashSet) {
            System.out.println(p);
        }

        System.out.println("\nLinkedHashSet (Insertion Order):");
        for (Policy p : linkedHashSet) {
            System.out.println(p);
        }

        System.out.println("\nTreeSet (Sorted by Expiry Date):");
        for (Policy p : treeSet) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        manager.addPolicy(new Policy("P1001", "Alice Brown", new GregorianCalendar(2025, Calendar.JUNE, 15).getTime(), "Health", 500.0));
        manager.addPolicy(new Policy("P1002", "Bob Smith", new GregorianCalendar(2024, Calendar.DECEMBER, 10).getTime(), "Auto", 750.0));
        manager.addPolicy(new Policy("P1003", "Charlie Davis", new GregorianCalendar(2026, Calendar.MARCH, 20).getTime(), "Home", 1200.0));

        manager.displayPolicies();
    }

    public void displayPoliciesByCoverageType(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayPoliciesByCoverageType'");
    }
}

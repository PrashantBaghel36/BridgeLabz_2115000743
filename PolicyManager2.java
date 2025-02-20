// Retrieve Policies: Implement methods to retrieve and display policies based on
// certain criteria:
//  All unique policies.
//  Policies expiring soon (within the next 30 days
//  Policies with a specific coverage type.
//  Duplicate policies based on policy numbers.


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

    public String getCoverageType() {
        return coverageType;
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

public class PolicyManager2 {
    private Set<Policy> hashSet;
    private Set<Policy> linkedHashSet;
    private Set<Policy> treeSet;

    public PolicyManager2() {
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

    public void displayAllUniquePolicies() {
        System.out.println("\nAll Unique Policies:");
        for (Policy p : hashSet) {
            System.out.println(p);
        }
    }

    public void displayPoliciesExpiringSoon() {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInsatance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        Date thresholdDate = calendar.getTime();

        System.out.println("\nPolicies Expiring Soon (within 30 days):");
        for (Policy p : treeSet) {
            if (p.getExpiryDate().before(thresholdDate)) {
                System.out.println(p);
            }
        }
    }

    public void displayPoliciesByCoverageType(String coverageType) {
        System.out.println("\nPolicies with Coverage Type: " + coverageType);
        for (Policy p : hashSet) {
            if (p.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(p);
            }
        }
    }

    public void displayDuplicatePolicies() {
        Map<String, Integer> policyCount = new HashMap<>();
        for (Policy p : hashSet) {
            policyCount.put(p.getPolicyNumber(), policyCount.getOrDefault(p.getPolicyNumber(), 0) + 1);
        }

        System.out.println("\nDuplicate Policies (Based on Policy Number):");
        for (Map.Entry<String, Integer> entry : policyCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Policy Number: " + entry.getKey() + " appears " + entry.getValue() + " times.");
            }
        }
    }

    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        manager.addPolicy(new Policy("P1001", "Alice Brown", new GregorianCalendar(2025, Calendar.JUNE, 15).getTime(), "Health", 500.0));
        manager.addPolicy(new Policy("P1002", "Bob Smith", new GregorianCalendar(2024, Calendar.DECEMBER, 10).getTime(), "Auto", 750.0));
        manager.addPolicy(new Policy("P1003", "Charlie Davis", new GregorianCalendar(2026, Calendar.MARCH, 20).getTime(), "Home", 1200.0));
        manager.addPolicy(new Policy("P1002", "David Johnson", new GregorianCalendar(2024, Calendar.DECEMBER, 10).getTime(), "Auto", 800.0));

        manager.displayPolicies();
        manager.displayAllUniquePolicies();
        manager.displayPoliciesExpiringSoon();
        manager.displayPoliciesByCoverageType("Auto");
        manager.displayDuplicatePolicies();
    }
}

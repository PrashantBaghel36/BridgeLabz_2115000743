abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private Patient next;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract double calculateBill();

    public String getPatientDetails() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }

    public Patient getNext() {
        return next;
    }

    public void setNext(Patient next) {
        this.next = next;
    }
}

interface MedicalRecord {
    void addRecord(String record);

    String[] viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private double dailyCharge;
    private int numberOfDays;
    private String[] records;
    private int recordCount;

    public InPatient(String patientId, String name, int age, double dailyCharge, int numberOfDays) {
        super(patientId, name, age);
        this.dailyCharge = dailyCharge;
        this.numberOfDays = numberOfDays;
        this.records = new String[10];
        this.recordCount = 0;
    }

    @Override
    public double calculateBill() {
        return dailyCharge * numberOfDays;
    }

    @Override
    public void addRecord(String record) {
        if (recordCount < records.length) {
            records[recordCount++] = record;
        }
    }

    @Override
    public String[] viewRecords() {
        String[] result = new String[recordCount];
        System.arraycopy(records, 0, result, 0, recordCount);
        return result;
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String[] records;
    private int recordCount;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.records = new String[10];
        this.recordCount = 0;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        if (recordCount < records.length) {
            records[recordCount++] = record;
        }
    }

    @Override
    public String[] viewRecords() {
        String[] result = new String[recordCount];
        System.arraycopy(records, 0, result, 0, recordCount);
        return result;
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        InPatient inPatient = new InPatient("P001", "John Doe", 45, 2000, 5);
        OutPatient outPatient = new OutPatient("P002", "Jane Smith", 30, 500);

        inPatient.addRecord("Admitted for surgery");
        outPatient.addRecord("Routine check-up");

        inPatient.setNext(outPatient);


        Patient current = inPatient;
        while (current != null) {
            System.out.println(current.getPatientDetails());
            System.out.println("Total Bill: " + current.calculateBill());

            if (current instanceof MedicalRecord) {
                MedicalRecord medicalRecord = (MedicalRecord) current;
                String[] recs = medicalRecord.viewRecords();
                System.out.print("Medical Records: [");
                for(int i = 0; i < recs.length; i++){
                    System.out.print(recs[i]);
                    if(i < recs.length -1){
                        System.out.print(", ");
                    }
                }
                System.out.println("]");

            }
            System.out.println("----------------------------");
            current = current.getNext();
        }
    }
}

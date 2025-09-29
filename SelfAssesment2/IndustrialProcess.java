package SelfAssesment2;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;

public class IndustrialProcess {
    private String ID;
    private ArrayList<IOperation> operations = new ArrayList<>();

    public IndustrialProcess(String ID) {
        this.ID = ID;
    }

    public Time ProcessDuration() {
        long totalMinutes = operations.stream()
                .mapToLong(op -> op.getNominalTime().getTime() / 60000) // convert ms to min
                .sum();
        return new Time(totalMinutes * 60000); // convert back to Time
    }

   public int ProcessResourcess(){

        int maxRequiredAgvs = 0;

        for (IOperation op : operations) {

            maxRequiredAgvs = op.getAssignedAgvs().size() + maxRequiredAgvs;

        }

        return maxRequiredAgvs;
 }

    public String getID() { return ID; }
    public ArrayList<IOperation> getOperations() { return operations; }

    public void setIOperations() 
    { 
        
        Random random = new Random();
        int min = 150_000_000;
        int max = 450_000_000;

        this.operations.add(new IOperation("OP1", "Operation 1", new Time(random.nextInt((max - min) + 1) + min))); 
        this.operations.add(new IOperation("OP2", "Operation 2", new Time(random.nextInt((max - min) + 1) + min)));
        this.operations.add(new IOperation("OP3", "Operation 3", new Time(random.nextInt((max - min) + 1) + min)));
    }

}
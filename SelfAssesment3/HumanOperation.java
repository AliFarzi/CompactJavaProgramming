package SelfAssesment3;
import java.sql.Time;

public class HumanOperation extends IOperation {

    protected double costRate; // euro per hour
    
    public HumanOperation(String ID, String Description, Time NominalTime) {
        super(ID, Description, NominalTime);
        this.costRate = Math.random() * (50 - 20) + 20; // Random rate between 20 and 50 euro
    }

    @Override
    public void performOperation() {

        //Time converted to hours
        double hours = super.getNominalTime().getTime() / 3600000;

        // total cost calculation
        double totalCost = costRate * hours;
        super.setCost(totalCost);

        // Implementation of the human operation
        System.out.printf(
            "Performing human operation using: %s%nDuration: %.2f hours%nTotal cost of %s: %.2f Euro %n %n",
            super.getDescription(), hours,   super.getDescription(), super.getCost()
        );
    }

}

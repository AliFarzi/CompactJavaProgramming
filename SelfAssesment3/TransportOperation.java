package SelfAssesment3;
import java.sql.Time;

public class TransportOperation extends IOperation {

    protected double consumptionRate; // kWh per hour

    public TransportOperation(String ID, String Description, Time NominalTime) {
        super(ID, Description, NominalTime);
        this.consumptionRate = Math.random() * (30 - 10) + 10; // Random rate between 10 and 30 kWh
    }

    @Override
    public void performOperation() {

        //Time converted to hours
        double hours = super.getNominalTime().getTime() / 3600000;

        // total consumption calculation 
        double totalConsumption = consumptionRate * hours;

        // Set the consumption using the setter method from the superclass
        super.setConsumption(totalConsumption); 

        
       // Print operation details
        System.out.printf(
             "Performing transport operation using: %s%nDuration: %.2f hours%nTotal consumption of %s: %.2f kWh%n %n",
             super.getDescription(), hours, super.getDescription(), totalConsumption
        );

        
    }

}

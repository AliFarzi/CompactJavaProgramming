package SelfAssesment3;

public class HardwareResources extends NonHumanResources {

    public HardwareResources(String ID, String Description) {
        super(ID, Description);
        
    }

    @Override
    public void allocateResource() {
        int amount = (int)(Math.random() * (50 - 5) + 5); // Random amount of hardware resources between 5 and 50
        super.setAmount(amount);

        double cost = amount * Math.random() * (500 - 200) + 200; // Random cost between 200 and 500 euro
        super.setCost(cost);

        System.out.printf(
            "Allocating hardware resources: %s%nAmount allocated: %d%nTotal cost of %s: %.2f Euro%n %n",
            super.getDescription(), super.getAmount(), super.getDescription(), super.getCost()
        );
        
    }
    
}
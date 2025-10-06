package SelfAssesment3;

public class SoftwareResources extends NonHumanResources {

    public SoftwareResources(String ID, String Description) {
        super(ID, Description);
        
    }

    @Override
    public void allocateResource() {

        int amount = (int)(Math.random() * (100 - 10) + 10); // Random amount of software resources between 10 and 100
        super.setAmount(amount);
        double cost = amount * Math.random() * (300 - 100) + 100; // Random cost between 100 and 300 euro
        super.setCost(cost);
        System.out.printf(
            "Allocating software resources: %s%nAmount allocated: %d%nTotal cost of %s: %.2f Euro%n %n",
            super.getDescription(), super.getAmount(), super.getDescription(), super.getCost()
        );
        
        
    }
    
}
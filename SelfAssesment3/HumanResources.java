package SelfAssesment3;

public class HumanResources extends Resources {

    public HumanResources(String ID, String Description) {
        super(ID, Description);
        
    }

    @Override
    public void allocateResource() {

        int amount = (int)(Math.random() * (25 - 1) + 1); // Random amount of human resources between 1 and 25
        super.setAmount(amount);

        double cost = amount * Math.random() * (100 - 60) + 60; // Random cost between 60 and 100 euro
        super.setCost(cost);

        System.out.printf(
            "Allocating human resources: %s%nAmount allocated: %d%nTotal cost of %s: %.2f Euro%n %n",
            super.getDescription(), super.getAmount(), super.getDescription(), super.getCost()
        );
    }
    
}

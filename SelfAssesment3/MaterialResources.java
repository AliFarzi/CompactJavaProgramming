package SelfAssesment3;

public class MaterialResources extends NonHumanResources {

    public MaterialResources(String ID, String Description) {
        super(ID, Description);
        
    }

    @Override
    public void allocateResource() {
        int amount = (int)(Math.random() * (30 - 5) + 5); // Random amount of material resources between 5 and 30
        super.setAmount(amount);

        double cost = amount * Math.random() * (150 - 50) + 50; // Random cost between 50 and 150 euro
        super.setCost(cost);

        System.out.printf(
            "Allocating material resources: %s%nAmount allocated: %d%nTotal cost of %s: %.2f Euro%n %n",
            super.getDescription(), super.getAmount(), super.getDescription(), super.getCost()
        );

    }
}
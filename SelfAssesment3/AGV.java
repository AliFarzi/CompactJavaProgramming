package SelfAssesment3;

import java.sql.Time;

public class AGV extends HardwareResources {

   
    private final double batteryLoad;
    private final double consumption;
    private final Time chargingTime;
    private final double position;
    private final float maxSpeed;
    private final float actSpeed;

    public AGV(String ID, String Description, double batteryLoad, Time chargingTime, double consumption, double position, float maxSpeed, float actSpeed) {
        super(ID, Description);

        this.batteryLoad = batteryLoad;
        this.chargingTime = chargingTime;
        this.consumption = consumption;
        this.position = position;
        this.maxSpeed = maxSpeed;
        this.actSpeed = actSpeed;
        
    }

    @Override
    public void allocateResource() {
        int amount = (int)(Math.random() * (20 - 1) + 1); // Random amount of AGVs between 1 and 20
        super.setAmount(amount);

        double cost = amount * Math.random() * (100000 - 50000) + 50000; // Random cost between 50000 and 100000 euro
        super.setCost(cost);

        System.out.printf(
            "Allocating AGV resources: %s%nAmount allocated: %d%nTotal cost of %s: %.2f Euro%n %n",
            super.getDescription(), super.getAmount(), super.getDescription(), super.getCost()
        );
        
    }
    
}

package SelfAssesment2;

import java.sql.Time;


public class AGV {
    private final String id;
    private final double batteryLoad;
    private final double consumption;
    private final Time chargingTime;
    private final double position;
    private final float maxSpeed;
    private final float actspeed;

    public AGV(String id, double batteryLoad, Time chargingTime, double consumption, double position, float maxSpeed, float actspeed) {
        this.id = id;
        this.batteryLoad = batteryLoad;
        this.chargingTime = chargingTime;
        this.consumption = consumption;
        this.position = position;
        this.maxSpeed = maxSpeed;
        this.actspeed = actspeed;
    }
    
    /** getters */
    public String getId() { return id; }
    public double getBatteryLoad() { return batteryLoad; }
    public Time getChargingTime() { return chargingTime; }
    public double getConsumption() { return consumption; }
    public double getPosition() { return position; }
    public float getMaxSpeed() { return maxSpeed; }
    public float getActspeed() { return actspeed; }

}


package SelfAssesment2;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;


public class IOperation {
    protected  String ID;
    protected  String Description;
    protected  Time NominalTime;
    protected ArrayList<AGV> assignedAgvs = new ArrayList<>();
    protected double consumption = 0.0;

    public IOperation(String ID, String Description, Time NominalTime) {
        this.ID = ID;
        this.Description = Description;
        this.NominalTime = NominalTime;
        setAssignedAgvs();
    }


    /** getters */
    public String getID() { return ID; }
    public String getDescription() { return Description; }
    public Time getNominalTime() { return NominalTime; }
    public ArrayList<AGV> getAssignedAgvs() { return assignedAgvs; }

    public double getConsumption() {
        double sumConsumption = 0;
        for (AGV agv : assignedAgvs) {
            sumConsumption += agv.getConsumption();
        }
        return sumConsumption * getNominalTime().getTime() / 3600000; // consumption per hour
    }

    /** setters */
    public void setID(String ID) { this.ID = ID; }
    public void setDescription(String Description) { this.Description = Description; }
    public void setNominalTime(Time NominalTime) { this.NominalTime = NominalTime; }

    // Example method to assign AGVs (you can modify as needed)
    public void setAssignedAgvs() { 
        
        Random random = new Random();
        int min = 10;
        int max = 150;

        this.assignedAgvs.add(new AGV("AGV1", 80.0 , new Time(60_000_000), random.nextInt((max - min) + 1) + min, 10.5, 1.5f, 1.0f));
        this.assignedAgvs.add(new AGV("AGV2", 60.0 , new Time(120_000_000), random.nextInt((max - min) + 1) + min, 12.0, 1.2f, 1.0f));
        this.assignedAgvs.add(new AGV("AGV3", 90.0 , new Time(240_000_000), random.nextInt((max - min) + 1) + min, 15.3, 1.8f, 1.5f));

    }


    

}

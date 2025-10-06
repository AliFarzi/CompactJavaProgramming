package SelfAssesment3;

import java.sql.Time;


public abstract class IOperation {
    protected  String ID;
    protected  String Description;
    protected  Time NominalTime;
    protected double consumption = 0.0;
    protected double cost = 0.0;

    public IOperation(String ID, String Description, Time NominalTime) {
        this.ID = ID;
        this.Description = Description;
        this.NominalTime = NominalTime;
    }

    /** Abstract method to be implemented by subclasses */
    public abstract void performOperation();


    /** getters */
    public String getID() { return ID; }
    public String getDescription() { return Description; }
    public Time getNominalTime() { return NominalTime; }
    public double getConsumption() { return consumption; } 
    public double getCost() { return cost; }


    /** setters */
    public void setID(String ID) { this.ID = ID; }
    public void setDescription(String Description) { this.Description = Description; }
    public void setNominalTime(Time NominalTime) { this.NominalTime = NominalTime; }
    public void setConsumption(double consumption) { this.consumption = consumption; }
    public void setCost(double cost) { this.cost = cost; }


    

}

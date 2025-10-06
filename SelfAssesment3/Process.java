package SelfAssesment3;

public abstract class Process {
    protected String ID;
    protected double totalCost = 0.0;
    protected double totalConsumption = 0.0;

    public Process(String ID, String Description) {
        this.ID = ID;
    }

    /** getters */
    public String getID() { return ID; }
    public double getTotalCost() { return totalCost; }
    public double getTotalConsumption() { return totalConsumption; }
   

    /** setters */
    public void setID(String ID) { this.ID = ID; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }
    public void setTotalConsumption(double totalConsumption) { this.totalConsumption = totalConsumption; }

    public abstract void execute();
    
}

package SelfAssesment3;

public abstract  class Resources {

    protected String ID;
    protected String Description;
    protected double cost; // Euro
    protected int amount; // number of resources available

    public Resources(String ID, String Description) {
        this.ID = ID;
        this.Description = Description;
    }
    
    /** getters */
    public String getID() { return ID; }
    public String getDescription() { return Description; }
    public double getCost() { return cost; }
    public int getAmount() { return amount; }

    /** setters */
    public void setID(String ID) { this.ID = ID; }
    public void setDescription(String Description) { this.Description = Description; }
    public void setCost(double cost) { this.cost = cost; }
    public void setAmount(int amount) { this.amount = amount; }

    /** abstract methods */
    public abstract void allocateResource();
}

package SelfAssesment3;

public class IndustrialProcess extends Process {

    private IOperation[] operations;
    private Resources[] resources;
    private double totalDuration;
    private double totalResourceAmount;

    public IndustrialProcess(String ID, String Description, IOperation[] operations, Resources[] resources) {
        super(ID, Description);
        this.operations = operations;
        this.resources = resources;
    }

    @Override
    public void execute() {

        System.out.println("--------------------------------------------------\n" );

        // Implementation of the industrial process execution
        System.out.println("Executing Industrial Process: " + ID);

        for (IOperation operation : operations) {
            operation.performOperation();
            setTotalCost(getTotalCost() + operation.getCost());
            setTotalConsumption(getTotalConsumption() + operation.getConsumption());
        }

        for (Resources resource : resources) {
            resource.allocateResource();
            setTotalCost(getTotalCost() + resource.getCost());
        }


        System.out.printf("Total cost for Industrial Process ID %s: %.2f Euro%n", ID, getTotalCost());

        System.out.printf("Total consumption for Industrial Process ID %s: %.2f kWh%n", ID, getTotalConsumption());

        ProcessDuration();
        System.out.printf("Total duration for Industrial Process ID %s: %.2f hours%n", ID, totalDuration);

        ProcessResources();
        System.out.printf("Total resources allocated for Industrial Process ID %s: %.2f %n", ID, totalResourceAmount);


        System.out.println("--------------------------------------------------\n" );
    }
    
    public void ProcessDuration() {

        this.totalDuration = 0.0;
        for (IOperation operation : operations) {
            this.totalDuration += operation.getNominalTime().getTime() / 3600000.0; // Convert milliseconds to hours
        }
    }   

    public void ProcessResources(){

        this.totalResourceAmount = 0.0;

        for (Resources resource : resources) {
            this.totalResourceAmount += resource.getAmount();
        }

    }

    /** getters */
    public IOperation[] getOperations() { return operations; }


    /** setters */
    public void setOperations(IOperation[] operations) { this.operations = operations; }


}

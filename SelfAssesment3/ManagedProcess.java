package SelfAssesment3;

public class ManagedProcess extends Process {
    private IOperation[] operations;

    public ManagedProcess(String ID, String Description, IOperation[] operations) {
        super(ID, Description);
        this.operations = operations;
    }


    @Override
    public void execute() {
    
       

        System.out.println("Executing Managed Process ID: " + ID);
        for (IOperation operation : operations) {
            operation.performOperation();
            setTotalCost(getTotalCost() + operation.getCost());
            setTotalConsumption(getTotalConsumption() + operation.getConsumption());
        }

        System.out.printf("Total cost for Managed Process ID %s: %.2f Euro%n", ID, getTotalCost());
        System.out.printf("Total consumption for Managed Process ID %s: %.2f units%n", ID, getTotalConsumption());
        System.out.println("--------------------------------------------------\n" );
    }

    /** getters */
    public IOperation[] getOperations() { return operations; }

    /** setters */
    public void setOperations(IOperation[] operations) { this.operations = operations; }
    
}

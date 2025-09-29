package SelfAssesment2;

public class app {
    
    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            IndustrialProcess process = new IndustrialProcess("Process" + (i + 1));
            process.setIOperations();
            double totalConsumption = 0.0;
            for (IOperation op : process.getOperations()) {
                totalConsumption += op.getConsumption();
            }
            System.out.println("Process ID: " + process.getID());
            System.out.println("Total Process Duration (hour): " + process.ProcessDuration().getTime()/(3600000));
            System.out.println("Total Required AGVs: " + process.ProcessResourcess());
            System.out.printf("Total Energy Consumption (kWh): %.2f%n", totalConsumption);
        }
        

    }
}
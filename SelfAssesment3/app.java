package SelfAssesment3;

import java.sql.Time;

public class app {
    public static void main(String[] args) {


        /* This parts initializes the operations */

        // Initialize random hours between 1 and 5 for human operation
        int hours = (int)(Math.random() * (5 - 1) + 1);

        IOperation humanOp = new HumanOperation("Hopt1", "Human Operation 1", new Time(hours*3600000));
        //humanOp.performOperation();

        // Initialize random hours between 1 and 8 for transport operation
        hours = (int)(Math.random() * (8 - 1) + 1);

        IOperation transportOp = new TransportOperation("Topt1", "Transport Operation 1", new Time(hours*3600000));
        //transportOp.performOperation();

        //------------------------------------------------------------------------------------------------------------------------

        /* This parts initializes the resources */

        Resources res = new HumanResources("Hres2", "Human Resource 2");
        //res.allocateResource();

        Resources res2 = new HardwareResources("Hres3", "Hardware Resource 3");
        //res2.allocateResource();

        Resources res3 = new AGV("AGV1", "Automated Guided Vehicle 1", 100.0, new Time(1*3600000), 10.0, 0.0, 5.0f, 0.0f);
        //res3.allocateResource();    

        Resources res4 = new MaterialResources("Mres1", "Material Resource 1");
        //res4.allocateResource();

        Resources res5 = new SoftwareResources("Sres1", "Software Resource 1");
        //res5.allocateResource();

        //------------------------------------------------------------------------------------------------------------------------

        /* This part initializes the industrial process */
        IOperation[] operations = {humanOp, transportOp};
        Resources[] resources = {res, res2, res3, res4, res5};
        IndustrialProcess process = new IndustrialProcess("IP1", "Industrial Process 1", operations, resources);

        // Execute the industrial process
        process.execute();

        


    }


    /* output of the program:

     *  Executing Industrial Process: IP1
        Performing human operation using: Human Operation 1
        Duration: 2.00 hours
        Total cost of Human Operation 1: 53.76 Euro

        Performing transport operation using: Transport Operation 1
        Duration: 3.00 hours
        Total consumption of Transport Operation 1: 39.27 kWh

        Allocating human resources: Human Resource 2
        Amount allocated: 8
        Total cost of Human Resource 2: 110.75 Euro

        Allocating hardware resources: Hardware Resource 3
        Amount allocated: 29
        Total cost of Hardware Resource 3: 3484.50 Euro

        Allocating AGV resources: Automated Guided Vehicle 1
        Amount allocated: 1
        Total cost of Automated Guided Vehicle 1: 85579.06 Euro

        Allocating material resources: Material Resource 1
        Amount allocated: 12
        Total cost of Material Resource 1: 275.06 Euro

        Allocating software resources: Software Resource 1
        Amount allocated: 42
        Total cost of Software Resource 1: 8148.71 Euro

        Total cost for Industrial Process ID IP1: 97651.84 Euro
        Total consumption for Industrial Process ID IP1: 39.27 kWh
        Total duration for Industrial Process ID IP1: 5.00 hours
        Total resources allocated for Industrial Process ID IP1: 92.00
--------------------------------------------------
      End of the output  */
}

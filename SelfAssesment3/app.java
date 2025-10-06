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
}

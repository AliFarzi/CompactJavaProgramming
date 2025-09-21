package SelfAssesment1;

public class Problem1
{
    public static void main(String[] args){

        //declare variables
        double sunDiameter = 865000.0;
        double earthDiamter= 7600.0;
        double sunVolume = 0.0;
        double earthVolume = 0.0;
        double ratio = 0.0;

        //calculate volumes and ratio
        sunVolume = volumeOfSphere(sunDiameter/2);
        earthVolume = volumeOfSphere(earthDiamter/2);
        ratio = sunVolume/earthVolume;

        //output results with formatting for readability
        System.out.println("The volume of the Earth is " + String.format("%,.0f", earthVolume) + " cubic miles\nThe volume of the Sun is " 
        + String.format("%,.0f", sunVolume) + " cubic miles, and \nthe ratio of the volume of the Sun to the volume of the Earth is " 
        + String.format("%,.2f", ratio));
    }

    //method to calculate the volume of a sphere given its radius
    public static double volumeOfSphere(double radius){
        return (4.0/3.0) * Math.PI * Math.pow(radius, 3);
    }
}

 
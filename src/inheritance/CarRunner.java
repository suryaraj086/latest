package inheritance;

import java.util.Scanner;

public class CarRunner {
    Scanner scan=new Scanner(System.in);

    private void instanceMethod(Object input) {

        if(input instanceof Swift)
        {
            System.out.println("Hatch");
        }
        if(input instanceof XUV)
        {
            System.out.println("SUV");
        }
        if(input instanceof SCross)
        {
            System.out.println("Sedan");
        }
    }

    private void carMethod(Car objSwift) {

        System.out.println("This is car method");
    }

    private void objMethod(Swift objSwift) {

        System.out.println("This is swift object");
    }

    private void swiftMethod() throws Exception{
        Swift swift=new Swift();
        System.out.println("Enter the number of seats");
        int seat=scan.nextInt();
        swift.setSeats(seat);
        System.out.println("The number of seats in swift is "+swift.getSeats());
        System.out.println("Enter the number of airbags");
        int bags=scan.nextInt();
        swift.setAirBags(bags);
        scan.nextLine();
        System.out.println("The number of airbags in swift is "+swift.getAirBags());
        System.out.println("Enter the model");
        String model=scan.nextLine();
        swift.setModel(model);
        System.out.println("The model is "+swift.getModel());
        System.out.println("Enter the color");
        String colorString=scan.nextLine();
        swift.setColor(colorString);
        System.out.println("The color is "+swift.getColor());

    }
    private void sCrossMethod() throws Exception
    {
        SCross scross=new SCross();
        System.out.println("Enter the number of seats");
        int seat=scan.nextInt();
        scross.setSeats(seat);
        System.out.println("The number of seats in scross is "+scross.getSeats());
        System.out.println("Enter the number of airbags");
        int bags=scan.nextInt();
        scan.nextLine();
        scross.setAirBags(bags);
        System.out.println("The number of airbags in scross is "+scross.getAirBags());
        System.out.println("Enter the model");
        String model=scan.nextLine();
        scross.setModel(model);
        System.out.println("The model is "+scross.getModel());
        System.out.println("Enter the color");
        String colorString=scan.nextLine();
        scross.setColor(colorString);
        System.out.println("The color is "+scross.getColor());
        System.out.println("Enter the year");
        int year=scan.nextInt();
        scan.nextLine();
        scross.setYearOfMake(year);
        System.out.println("The model is "+scross.getYearOfMake());
        System.out.println("Enter the engine number");
        String engNum=scan.nextLine();
        scross.setEngineNumber(engNum);
        System.out.println("The model is "+scross.getEngineNumber());

    }


    public static void main(String[] args) {
        CarRunner runner=new CarRunner();
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the task number");
        int choice=0;
        try
        {
            choice=scan.nextInt();
        }
        catch (Exception e)
        {
            System.out.println("Enter numbers only in choice");
        }

        switch (choice) {
            case 1: {
                try {
                    runner.swiftMethod();
                }
                catch (Exception e) {
                    System.out.println("Enter only numbers for seats and airbags");
                    //e.printStackTrace();
                }
                break;
            }

            case 2:
            {
                try {
                    runner.sCrossMethod();
                }
                catch (Exception e) {
                    System.out.println("Enter only numbers for seats, airbags and year");
                    //e.printStackTrace();
                }
                break;

            }

            case 3:
            {
                Swift swiftObj = new Swift();
                //XUV xuvObj=new XUV();
                //Car obj = new Swift();
                runner.carMethod(swiftObj);
                break;
            }

            case 4:
            {
                Swift obj = new Swift();
                //XUV xuvObj=new XUV();
                runner.instanceMethod(obj);
                break;
            }

            case 5:
            {
                Swift swiftObj = new Swift();
                //XUV xuvObj=new XUV();
//                Car obj = new Swift();
                runner.objMethod(swiftObj);
                break;
            }

            case 6:
            {
                Swift swiftObj = new Swift();
                System.out.println(swiftObj.maintenance());
                //XUV xuvObj=new XUV();
                //scross
                SCross sObjCross=new SCross();
                System.out.println(sObjCross.maintenance());
                //car obj
                Car obj=new Car();
                System.out.println(obj.maintenance());
                //car with scross obj
                Car csObj = new SCross();
                System.out.println(csObj.maintenance());
                break;
            }

            case 7:
            {
                XUV xuvObj=new XUV();
                //	XUV xuvObj1=new XUV("surya");
                break;
            }
            
            case 8:
            {
            	//BirdAbstract obj=new BirdAbstract();
            	ParrotMod objMod=new ParrotMod();
            	System.out.println(objMod.fly());  	
            	System.out.println(objMod.speak());  
            	break;	
            }
            
            case 9:
            {
            Duck objDuck=new Duck();
    		System.out.println(objDuck.speak());
    		objDuck.fly();
    		break;
            }
            
            default:{
                System.out.println("Enter value between 1 to 7");
            }
        }
        scan.close();
    }
}

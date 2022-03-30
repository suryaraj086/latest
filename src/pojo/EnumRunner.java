package pojo;
import java.util.*;


enum Color {VIOLET, INDIGO, BLUE, GREEN, YELLOW, ORANGE, RED;

 

    public int getValue() {
  
       return ordinal()+1;
    }

};

public class EnumRunner {
	
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the Color");
        String inputColor=scan.nextLine().toUpperCase();
        switch (inputColor) {
            case "GREEN": {
                System.out.println(Color.GREEN+"  the value is "+Color.GREEN.getValue());
                break;
            }
            case "VIOLET": {
               System.out.println(Color.VIOLET+"  the value is "+Color.VIOLET.getValue());
                break;
            }
            case "INDIGO": {
                System.out.println(Color.INDIGO+"  the value is "+Color.INDIGO.getValue());
                break;
            }
            case "BLUE": {
                System.out.println(Color.BLUE+"  the value is "+Color.BLUE.getValue());
                break;
            }
            case "YELLOW": {
                System.out.println(Color.YELLOW+"  the value is "+Color.YELLOW.getValue());
                break;
            }
            case "ORANGE": {
                System.out.println(Color.ORANGE+"  the value is "+Color.ORANGE.getValue());
                break;
            }
            case "RED": {
                System.out.println(Color.RED+"  the value is "+Color.RED.getValue());
                break;
            }
            default:
            {
                System.out.println("Enter the colors of rainbow only");

            }
            
        }
        scan.close();
    }
}
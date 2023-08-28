import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Project 3
 * Main.java
 * 
 * Main class of the project. Tests Building, Auto, Food, objects.
 * Using a polymorphic arraylist of type CarbonFootPrint, storing the above objects.
 * 
 * @author Adam Prusiecki
 * @version 1.0
 * @since 2023/07/30
 */

public class Main 
{
    public static void main(String[] args)
    {
        ArrayList<CarbonFootPrint> objList = new ArrayList<CarbonFootPrint>();

        String filename = "Carbon.csv"; // Arbitrary file with input data
        File file = new File(filename); // File object

        if(file.exists()) // IF the file exists
        {
            try
            {
                Scanner scnr = new Scanner(file);
                String line;
                String[] lineArr;
                while(scnr.hasNextLine()) // While there are lines in the file
                {
                    line = scnr.nextLine();
                    lineArr = line.split(",");
                    
                    if(lineArr[0].equals("Building")) // If the line is a building
                    {
                        objList.add(new Building(Integer.parseInt(lineArr[1])));
                    }
                    else if(lineArr[0].equals("Auto")) // If the line is an auto
                    {
                        objList.add(new Auto(Integer.parseInt(lineArr[1])));
                    }
                    else if (lineArr[0].equals("Food")) // If the line is an food
                    {
                        objList.add(new Food(lineArr[1],Integer.parseInt(lineArr[2])));
                    }
                    else
                    {
                        System.out.println(lineArr[0] + " is not a valid class type"); // If the line is not a valid class type
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println("Failed with exception:\n" + e); // Exception catch
            }
        }
        else
        {
            System.out.println("File: " + filename + " does not exist!"); // IF file does not exist
        }

        for(CarbonFootPrint obj : objList) // For each object in the list
        {
            if(obj instanceof Building) // If the object is a building
            {
                // Print how many kilowatt hours of electricity was used in the building, and the carbon footprint of the building
                System.out.println("A building using " 
                                + ((Building) obj).getKilowattHours() + " kilowatt hours of electricity, kWh/year" 
                                + " at an emission factor of " + ((Building) obj).getEf()
                                + " kg CO2e/kWh, has a carbon footprint of "
                                + String.format("%.2f", obj.getCarbonFootprint())
                                + " lbs, per year");
            }
            else if(obj instanceof Auto) // If the object is an auto
            {
                // Print how many kilometers was traveled, and the carbon footprint
                System.out.println("A car driving a distance of " 
                                + ((Auto) obj).getDistance() + " km/year" 
                                + " at an emission factor of " + ((Auto) obj).getEf()
                                + " kg CO2e/litre, has a carbon footprint of "
                                + String.format("%.2f", obj.getCarbonFootprint())
                                + " lbs, per year");
            }
            else if(obj instanceof Food) // If the object is an food
            {
                // Print how many calories were consumed, and the carbon footprint
                System.out.println("Eating " 
                                + ((Food) obj).getFoodName() + ", at a consumption rate of "
                                + ((Food) obj).getCalorieConsumption() + " kg/Kcal"
                                + " at an emission factor of " + ((Food) obj).getEf()
                                + " kg CO2e/kCal, has a carbon footprint of "
                                + String.format("%.2f", obj.getCarbonFootprint())
                                + " lbs, per year");
            }
            else
            {
                System.out.println("Error: " + obj.getClass().getName() + " is not a valid class type"); // If the object is not a valid class type
            }
        }
    }
}

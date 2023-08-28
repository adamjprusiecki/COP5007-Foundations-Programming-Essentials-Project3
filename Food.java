import java.util.Dictionary;
import java.util.Hashtable;

/*
 * Project 3
 * Food.java
 * 
 * Food class, implmenting CarbonFootPrint interface
 * Calculates the carbon footprint of the yearly consumption of types of food, by using daily consumption * ef(varies by food type)
 * 
 * @author Adam Prusiecki
 * @version 1.0
 * @since 2023/07/30
 */

public class Food implements CarbonFootPrint
{
    // Class variables
    private Dictionary<String, Double> dict = new Hashtable<>();
    private String foodName;
    private double ef;
    private int calorieConsumption;

    // Constructor
    public Food(String foodName, int calorieConsumption)
    {
        this.setDict();
        this.foodName = foodName;
        this.ef = setEf(this.foodName);
        this.calorieConsumption = calorieConsumption;
    }

    // EF Setter
    private double setEf(String foodName)
    {
        return this.dict.get(foodName);
    }

    // Set the class dictionary, with all the corresponding values for food types.
    private void setDict()
    {
        dict.put("Red meat", 27.0);
        dict.put("White meat", 6.9);
        dict.put("Dairy", 1.9);
        dict.put("Cereals", 2.5);
        dict.put("Vegetables", 2.0);
        dict.put("Fruit", 1.1);
        dict.put("Snacks", 2.0);
        dict.put("Drinks", 1.0);
    }

    // Getters
    public String getFoodName()
    {
        return this.foodName;
    }

    public double getEf()
    {
        return this.ef;
    }

    public int getCalorieConsumption()
    {
        return this.calorieConsumption;
    }

    // Inherited method from CarbonFootPrint
    @Override
    public double getCarbonFootprint()
    {
        return this.calorieConsumption * 365 * this.ef;
    }
}

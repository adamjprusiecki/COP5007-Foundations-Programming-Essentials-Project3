/*
 * Project 3
 * Auto.java
 * 
 * Auto class, implmenting CarbonFootPrint interface
 * Calculates the carbon footprint of a car, by using distance(kilometers) * ef(2.32)
 * 
 * @author Adam Prusiecki
 * @version 1.0
 * @since 2023/07/30
 */

public class Auto implements CarbonFootPrint
{
    // Class variables
    private double ef;
    private int distance;
    
    // Constructor
    public Auto(int distance)
    {
        this.ef = 2.32;
        this.distance = distance;
    }

    // Getters
    public double getEf()
    {
        return this.ef;
    }

    public int getDistance()
    {
        return this.distance;
    }

    // Inherited method from CarbonFootPrint
    @Override
    public double getCarbonFootprint()
    {
        return this.distance * this.ef;
    }
}

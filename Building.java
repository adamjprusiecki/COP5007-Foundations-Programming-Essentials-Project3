/*
 * Project 3
 * Building.java
 * 
 * Building class, implmenting CarbonFootPrint interface
 * Calculates the carbon footprint of a building, by using kilowatt hours * ef(0.7)
 * 
 * @author Adam Prusiecki
 * @version 1.0
 * @since 2023/07/30
 */

public class Building implements CarbonFootPrint
{
    // Class variables
    private double ef;
    private int kilowattHours;

    // Constructor
    public Building(int kilowattHours)
    {
        this.ef = 0.7;
        this.kilowattHours = kilowattHours;
    }

    // Getters
    public double getEf()
    {
        return this.ef;
    }

    public int getKilowattHours()
    {
        return this.kilowattHours;
    }

    // Inherited method from CarbonFootPrint
    @Override
    public double getCarbonFootprint()
    {
        return this.kilowattHours * this.ef;
    }
}
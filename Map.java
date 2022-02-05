
/**
 * Write a description of class Inventory here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;

public class Map
{
    private int price;
    private String color;
    private String name;
    private boolean[] level;
    private boolean goSpot;
    private boolean isMortgaged;
    private boolean isProperty;
    private boolean isUtility;
    private boolean isJail;
    private boolean sentJail;
    private boolean isTrain;
    private boolean isChance;
    private boolean isChest;
    private boolean isTax;
    private boolean collectTax;
    private boolean hasOwner;
    private int houses;
    private int hotels;
    private int rent;
    private int housePrice;
    private int [] houseRent;
    private int hotelRent;
    private int hotelPrice;
    private int mortgage;
    private int unMortgage;
    private int tax;
    private int position;
    private int jailPrice;
    private String owner;

    public Map()
    {
        level = new boolean [5];   
        houseRent = new int [4];

        goSpot = false;
        isMortgaged = false;
        isProperty = false;
        isUtility = false;
        isJail = false;
        sentJail = false;
        isTrain = false;
        isChance = false;
        isChest = false;
        isTax = false;
        collectTax = false;
        hasOwner = false;

        owner = null;
        name = null;
        color = null;
        mortgage = 0;
        rent = 0;
        hotelPrice = 0;
        housePrice = 0;
        unMortgage = 0;
        price = 0;
        tax = 0;
        position = 0;
        jailPrice = 0;
        houses = 0;
        hotels = 0;

        for(int x = 0; x < 5; x++)
        {
            level[x] = false;
        }
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public int getPrice()
    {
        return price;
    }

    public void setHouse(int housePrice)
    {
        this.housePrice = housePrice;
    }

    public int getHouses()
    {
        return houses;
    }
    
    public void addHouses()
    {
        houses++;
    }

    public void setHotel(int hotelPrice)
    {
        this.hotelPrice = hotelPrice;
    }

    public int getHotel()
    {
        return hotels;
    }
    
    public void addHotels()
    {
        hotels++;
    }

    public void setHouseRent(int [] houseRent)
    {
        this.houseRent = houseRent;
    }
    
    public int getHouseRent()
    {
        return houseRent[getHouses()-1];
    }

    public void setHotelRent(int hotelRent)
    {
        this.hotelRent = hotelRent;
    }
    
    public int getHotelRent()
    {
        return hotelRent;
    }

    public void setOwner(String x)
    {
        owner = x;
        hasOwner = true;
    }

    public String getOwner()
    {
        return owner;
    }    
    
    public boolean ownerStatus()
    {
        return hasOwner;
    }

    public boolean checkHouse()
    {
        for (int x = 0; x < 4; x++)
        {
            if (level[x] = false)
            {
                return false;
            }
        }
        return true;
    }

    public boolean checkHotel()
    {
        if (level[4])
        {
            return true;
        }
        return false;
    }

    public void setRent(int x)
    {
        rent = x;
    }

    public int getRent()
    {
        int house = 0;
        int hotel = 0;
        for (int x = 0; x < 5; x++)
        {
            if (level[x] && x != 4)
            {
                house++;
            }
            if (x == 4 && level[x])
            {
                hotel++;
            }
        }

        if (house != 0 && hotel == 0)
        {
            return houseRent[house-1];
        }
        else if (hotel > 0)
        {
            return hotelRent;
        }
        else
        {
            return rent;
        }
    }

    public void collectTax(int x)
    {
        tax += x;
    }

    public int returnTax()
    {
        return tax;
    }

    public void resetTax()
    {
        tax = 0;
    }

    public void tax(boolean x)
    {
        isTax = x;
    }
    
    public boolean taxStatus()
    {
        return isTax;
    }

    public void taxReturn(boolean x)
    {
        collectTax = x;
    }
    
    public boolean taxReturnStatus()
    {
        return collectTax;
    }

    public void goSpot(boolean x)
    {
        goSpot = x;
    }
    
    public boolean goSpotStatus() //
    {
        return goSpot;
    }

    public int setMortgage(int price)
    {
        mortgage = price/2;
        isMortgaged = true;
        return mortgage;
    }

    public int setUnMortgage()
    {
        unMortgage = (int)(mortgage * 1.1);
        return unMortgage;
    }

    public boolean payMortgage(int x)
    {
        if (x == unMortgage && isMortgaged == true)
        {
            isMortgaged = false;
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean mortgageStatus()
    {
        return isMortgaged;
    }

    public void jail(boolean x) //
    {
        isJail = x;
    }

    public void setJailPrice()
    {
        jailPrice = 8;
    }

    public void Property(boolean x)
    {
        isProperty = x;
    }
    
    public boolean propertyStatus()
    {
        return isProperty;
    }

    public void train(boolean x)
    {
        isTrain = x;
    }
    
    public boolean trainStatus()
    {
        return isTrain;
    }

    public void utility(boolean x)
    {
        isUtility = x;
    }
    
    public boolean utilityStatus()
    {
        return isUtility;
    }

    public void chance(boolean x) //
    {
        isChance = x;
    }
    
    public boolean chanceStatus() 
    {
        return isChance;
    }

    public void chest(boolean x)
    {
        isChest = x;
    }
    
    public boolean chestStatus() //
    {
        return isChest;
    }

    public void setPosition(int x)
    {
        position = x;
    }
}

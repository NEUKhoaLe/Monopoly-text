
/**
 * Write a description of class Players here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;

public class Players
{
    private String name;
    private int diamond;
    private int position;
    private boolean getOutOfJailFree;
    private boolean inJail;
    private ArrayList<Map> property = new ArrayList<>();
    private ArrayList<Map> mortgagedProperty = new ArrayList<>();
    private int brown;
    private int lightBlue;
    private int pink;
    private int orange;
    private int red;
    private int yellow;
    private int green;
    private int blue;
    private int iniRoll;

    public Players(int diamond)
    {
        this.diamond = diamond;
        position = 0;
        brown = 0;
        lightBlue = 0;
        pink = 0;
        orange = 0;
        red = 0;
        yellow = 0;
        green = 0;
        blue = 0;
        iniRoll = 0;

        getOutOfJailFree = false;
        inJail = false;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void takeDiamond(int price)
    {
        diamond = diamond - price;
    }

    public void giveDiamond(int price)
    {
        diamond = diamond + price;
    }

    public int getDiamond()
    {
        return diamond;
    }

    public void addProperty(Map property)
    {
        this.property.add(property);
    }
    
    public ArrayList<Map> getProperty()
    {
        return property;
    }
    
    public ArrayList<Map> getMortgaged()
    {
        return mortgagedProperty;
    }

    public void removeProperty(Map property)
    {
        int x = 0;

        while (x < this.property.size())
        {
            if(this.property.get(x).getName().equals(property.getName()))
            {
                this.property.remove(x);
                x = this.property.size();
            }
            else
            {
            }
        }
    }

    public void setOrder()
    {
        iniRoll = (int)(Math.random()*6+1);
    }

    public int getOrder()
    {
        return iniRoll;
    }

    public int getTotalHouse()
    {
        int x = 0;
        int z = 0;
        while (x < property.size())
        {
            z += property.get(x).getHouses();               
        }
        return z;
    }

    public int getTotalHotel()
    {
        int x = 0;
        int z = 0;
        while (x < property.size())
        {
            z += property.get(x).getHotel();               
        }

        return z;
    }

    public ArrayList<String> ownedColors()
    {
        brown = 0;
        lightBlue = 0;
        pink = 0;
        orange = 0;
        red = 0;
        yellow = 0;
        green = 0;
        blue = 0;

        for (int x = 0; x < property.size(); x++)
        {
            if (property.get(x).getColor().equalsIgnoreCase("Brown"))
            {
                brown++;
            }
            else if (property.get(x).getColor().equalsIgnoreCase("Light Blue"))
            {
                lightBlue++;
            }
            else if (property.get(x).getColor().equalsIgnoreCase("pink"))
            {
                pink++;
            }
            else if (property.get(x).getColor().equalsIgnoreCase("orange"))
            {
                orange++;
            }
            else if (property.get(x).getColor().equalsIgnoreCase("red"))
            {
                red++;
            }
            else if (property.get(x).getColor().equalsIgnoreCase("yellow"))
            {
                yellow++;
            }
            else if (property.get(x).getColor().equalsIgnoreCase("green"))
            {
                green++;
            }
            else if (property.get(x).getColor().equalsIgnoreCase("blue"))
            {
                blue++;
            }
        }

        ArrayList<String> ownedColor = new ArrayList<>();

        if (brown == 2)
        {
            ownedColor.add("Brown");
        }
        if (lightBlue == 3)
        {
            ownedColor.add("Light Blue");
        }
        if (pink == 3)
        {
            ownedColor.add("Pink");
        }
        if (orange == 3)
        {
            ownedColor.add("Orange");
        }
        if (red == 3)
        {
            ownedColor.add("Red");
        }
        if (yellow == 3)
        {
            ownedColor.add("Yellow");
        }
        if (green == 3)
        {
            ownedColor.add("Green");
        }
        if(blue == 2)
        {
            ownedColor.add("Blue");
        }

        return ownedColor;
    }

    public boolean checkColor (String color)
    {
        int x = 0;

        while (x < property.size())
        {
            if (property.get(x).getColor().equals(color))
            {
                return true;
            }
        }
        return false;
    }

    public void mortgage(Map property)
    {
        mortgagedProperty.add(property);
        int index = 0;
        for (int x = 0; x < this.property.size(); x++)
        {
            if (this.property.get(x) == property)
            {
                index = x;
            }
        }

        this.property.remove(index);
        giveDiamond(property.setMortgage(property.getPrice()));
    }
    
    public void unMortgage(Map property)
    {
        this.property.add(property);
        int index = 0;
        for (int x = 0; x < this.mortgagedProperty.size(); x++)
        {
            if (this.mortgagedProperty.get(x) == property)
            {
                index = x;
            }
        }

        this.mortgagedProperty.remove(index);
        takeDiamond((int)(property.setMortgage(property.getPrice())*1.1));
    }
    
    public int noTrains()
    {
        int number = 0;
        
        for (int x = 0; x < property.size(); x++)
        {
            if (property.get(x).trainStatus())
            {
                number++;
            }
        }
        
        return number;
    }

    public void getOutOfJail()
    {
        getOutOfJailFree = true;
    }
    
    public boolean cardStatus()
    {
        return getOutOfJailFree;
    }

    public void cardUsed()
    {
        getOutOfJailFree = false;
    }

    public void setPlayerPosition(int x)
    {
        position = x;
    }

    public int getPlayerPosition()
    {
        return position;
    }

    public void setJail(boolean x)
    {
        inJail = x;
    }

    public boolean getJail()
    {
        return inJail;
    }
}


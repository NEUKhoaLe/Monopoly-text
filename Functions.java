import java.util.*;
public class Functions
{
    private Map [] map = new Map [40];
    private setUpProperties function = new setUpProperties();
    
    public Functions()
    {
        map = function.setUp();
    }

    public void Intro()
    {
        sopln("This is a minecraft-themed game of monopoly.");
        sopln("To read the rules, type 'rules'.");
        sopln("To start the game, type 'start'.");
        sopln("To quit the game, type 'quit'.");
    }

    public void Instruction()
    {
        sopln("This game can have 2-4 players. The objective of the game is to get 15 stacks(64 per stacks) of diamond, or to bankrupt other players. \n");

        sopln("You can earn resources in several different ways:");
        sopln("                                        1) A chance or chest card that will give you resources.");
        sopln("                                        2) Passing your spawn point will give you the equivalent value of 32 diamonds.");
        sopln("                                        3) Trading resources with other players.");
        sopln("                                        4) If you own a particular property, and other players land on that property, they will pay a fee.");
        sopln("                                        5) Renting your property for resources. You can, however, get back the property at a lower price than the original.");

        sopln("You start with 240 pieces of diamond.");
        sopln("Players will roll one dice to determine order of start. \n");

        sopln("You have to roll 2 6-sided dice. Everytime you roll a double, ex. 1-1, you can roll again.");
        sopln("However, if you do it 3 times in a roll, you will automatically teleport to jail.");
        sopln("You will not receive 'Spawn' Money when you are teleported to jail, which can happen with chance cards. \n");

        sopln("To get out of jail, you either have to roll a double on your turn, wait for 3 turns to past, or pay 8 diamonds. \n");

        sopln("On the board, there will be two spots for chance cards, and two spots for chest cards. These can be good or bad. \n");

        sopln("When you land on spots where you have to pay taxes to villagers, the money will go into a treasurer.");

        sopln("There will be a spot on the board called 'Collect resource', where you will collect money from the treasurer.\n");  

        sopln("Whenever a player past the spawn, the player will receive 32 diamonds. \n");

        sopln("You can trade properties. The initiator can do it at the beginning of their turn.");
        sopln("Both players have to agree to the trade for it to past.");
        sopln("You can trade even if you are in the jail.");

        sopln("When you mortgage, you will sell your properties at half the purchase price.");
        sopln("You can re-buy the property at a 10% interest.");
        sopln("You can also trade mortgaged properties. The player receiving the mortgaged property have to immediately pay the mortgage,");
        sopln(" or pay the 10% interest without the rest. They will repeate this process until they pay off the whole thing. \n");   
        sopln("Decimal numbers will be rounded down.\n");

        sopln("Properties are color sorted into 8 colors, 4 nether portals, and 2 utilities.");
        sopln("Each property has different price points.");
        sopln("Each nether portal are priced at 32 diamonds. The price of rent will be 8 times the number of railroad owned.");
        sopln("Utilities are different. The price of rent is 4 times the number rolled by the two dice.");
    }

    public int [] rollDice()
    {
        int dice1 = (int)(Math.random()*6+1);
        int dice2 = (int)(Math.random()*6+1);
        
        int [] dice = {dice1, dice2};
        
        return dice;
    }
    
    public boolean doubleDice(int[] dice)
    {
        if (dice[0] == dice[1])
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public int diceValue(int [] dice)
    {
        return dice[1] + dice[0];
    }
    
    public ArrayList<Players> orderingPlayers(ArrayList <Players> player)
    {   
        int num = player.size();
        int max = 0;
        
        for (int x = 0; x < num; x++)
        {
            player.get(x).setOrder();
        }
        
        for (int x = 0; x < num-1; x++)
        {
            for (int y = 0; y < num-1; y++)
            {
                if ( player.get(x).getOrder() < player.get(x+1).getOrder())
                {
                    player.set(x,player.get(x+1));
                    player.remove(x+1);
                }
            }
        }
        
        return player;
    }
   
    public void sop(String x)
    {
        System.out.print(x);
    }

    public void sopln(String x)
    {
        System.out.println(x);
    }
}


/**
 * Write a description of class Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;

public class Driver
{
    public static void main (String [] args)
    {
        Functions function = new Functions();
        Properties [] property = new Properties[28];
        ChanceAndChest cards = new ChanceAndChest();

        int [] chest = new int [16];
        int [] chance = new int [16];

        Scanner scan = new Scanner(System.in);

        setUpProperties Property = new setUpProperties();

        Map []  map = Property.setUp();

        String input = null;
        int inputNumber = 0;
        int jailDays = 0;
        String tradeOffer = null;

        boolean start = true;
        boolean game = true;
        boolean preRoll = true;
        boolean postRoll = true;
        boolean tradingAgreement = false;
        boolean mortgageAgreement = false;

        while (start)
        {
            function.Intro();
            input = scan.nextLine();

            if (input.equalsIgnoreCase("rules"))
            {
                function.Instruction();
            }
            else if (input.equalsIgnoreCase("start"))
            {
                sopln("How many people will be playing?");
                inputNumber = scan.nextInt();
                scan.nextLine();

                ArrayList <Players> players = new ArrayList<Players>();
                ArrayList <Integer> doubleDice = new ArrayList<>();
                ArrayList <Integer> repeats = new ArrayList<>();

                boolean [] bankrupt = new boolean [inputNumber];

                int chanceMaker = 0;
                int randIndex = 0;
                int numBankrupt = 0;
                boolean repeat;
                int repeatCount;

                for (int x = 0; x < 16; x++)
                {
                    chance[x] = x;
                    chest[x] = x;
                }

                for (int x = 0; x < inputNumber; x++)
                {
                    sopln("Enter the player's name.");
                    input = scan.nextLine();

                    players.add(new Players(240));
                    players.get(x).setName(input);
                    doubleDice.add(0);
                    bankrupt[x] = false;
                }

                sopln("We will roll the dice to see who start first.");

                players = function.orderingPlayers(players);
                int turn = 0;
                int [] dice;
                boolean reTurn = false;
                int doubleCounter = 0;
                int distance;
                while (game == true)
                {
                    if (turn + 1 > players.size())
                    {
                        turn = 0;
                    }

                    if (players.get(turn).getJail() == true)
                    {
                        sopln("You are in jail. You can choose to pay 8 diamonds to be able to go next turn. You will be in jail for 3 turns. Type 'pay' if you want to pay.");
                        sopln("You can also try to roll a double. If you do, you will be able to go next turn. Type 'roll'.");
                        sopln("You can also use your get out of jail free 'card' if you have one. ");

                        input = scan.nextLine();

                        if (input.equalsIgnoreCase("Pay"))
                        {
                            players.get(turn).takeDiamond(8);
                            players.get(turn).setJail(false);
                            preRoll = false;
                            postRoll = false;
                            turn++;
                        }
                        else if (input.equalsIgnoreCase("roll"))
                        {
                            dice = function.rollDice();
                            if( function.doubleDice(dice))
                            {
                                sopln("You rolled a double! You are free!");
                                players.get(turn).setJail(false);
                                turn++;
                                preRoll = false;
                                postRoll = false;
                            }

                        }
                        else if (input.equalsIgnoreCase("card"))
                        {
                            players.get(turn).cardUsed();
                            turn++;
                            preRoll = false;
                            postRoll = false;
                        }
                        else
                        {
                            turn++;
                            jailDays++;
                            preRoll = false;
                            postRoll = false;
                        }
                    }

                    sopln("It is " + players.get(turn).getName() + "'s turn.");

                    while (preRoll)
                    {
                        sopln("Before you roll the dice, you can do a few things. 'trade' to trade properties or diamonds with other players.");
                        sopln("'mortgage' to mortgage any properties."); 
                        sopln("You can check your 'diamonds', 'properties', or 'mortgaged' property. Or you can start to roll the dice by typing 'roll'.");
                        sopln("You can also check how many houses or hotels on each of your properties by pressing 'check'.");
                        input = scan.nextLine();

                        if (input.equalsIgnoreCase("diamonds"))
                        {
                            sopln("You have " + players.get(turn).getDiamond() + " diamonds!");
                        }
                        else if (input.equalsIgnoreCase("properties"))
                        {
                            sopln("You have:");

                            ArrayList <Map> temp = players.get(turn).getProperty();

                            for (int x = 0; x < temp.size(); x++)
                            {
                                sopln(temp.get(x).getName());
                            }
                        }
                        else if (input.equalsIgnoreCase("mortgaged"))
                        {
                            sopln("These properties are mortgaged:");

                            ArrayList <Map> temp = players.get(turn).getMortgaged();

                            for (int x = 0; x < temp.size(); x++)
                            {
                                sopln(temp.get(x).getName());
                            }
                        }
                        else if (input.equalsIgnoreCase("check"))
                        {
                            sopln("Enter the index of the property you want to check.");
                            int index = scan.nextInt();
                            scan.nextLine();

                            sopln("You have " + map[index].getHouses() + " houses and " + map[index].getHotel() + " hotels.");
                        }
                        else if (input.equalsIgnoreCase("trade"))
                        {
                            while (tradingAgreement == false)
                            {
                                sopln("In a trade you can offer a combination of 3 things.");
                                sopln("Diamonds, free jail cards, or properties.");
                                sopln("The person initiating the trade can offer whatever he wants, but the trade offer has to be accepted.");

                                sopln(players.get(turn).getName() + ", who do you want to trade with?");
                                sopln("The list of players are:");

                                for (int x  = 0; x < players.size(); x++)
                                {
                                    if (x != turn)
                                    {
                                        sopln((x+1) + ": " + players.get(x).getName());
                                    }
                                }

                                sopln("Enter the number of the person you want to trade with.");
                                int index = scan.nextInt();
                                scan.nextLine();

                                sopln(players.get(index).getName() + " has " + players.get(index).getDiamond() + " diamonds.");

                                if (players.get(index).cardStatus())
                                {
                                    sopln(players.get(index).getName() + " also have a get out of jail free card.");
                                }

                                sopln(players.get(index).getName() + " also has these properties:");

                                ArrayList <Map> temp = players.get(index).getProperty();

                                for (int x = 0; x < temp.size(); x++)
                                {
                                    sopln((x+1) + ": " + temp.get(x).getName());
                                }

                                sopln("If you want to trade for properties, type '1'. For properties and card, type '2'. For card, type '3'.");

                                ArrayList <Map> propertyOffered = new ArrayList<>();
                                ArrayList <Map> propertyFor = new ArrayList<>();

                                int diamondOffered = 0;
                                int diamondFor = 0;

                                boolean cardOffered;
                                boolean cardFor;

                                int choice = scan.nextInt();
                                scan.nextLine();

                                if (choice == 1)
                                {
                                    sopln("These are the properties:");

                                    ArrayList <Map> currentProperty = players.get(index).getProperty();

                                    for (int x = 0; x < temp.size(); x++)
                                    {
                                        sopln((x+1) + ": " + temp.get(x).getName());
                                    }

                                    sopln("Type in the properties you want to trade for.");

                                    boolean propertyOffers = false;
                                    while (propertyOffers == false)
                                    {
                                        choice = scan.nextInt();
                                        scan.nextLine();

                                        propertyFor.add(currentProperty.get(choice-1));

                                        sopln("Are you done?");
                                        input = scan.nextLine();

                                        if (input.equalsIgnoreCase("yes"))
                                        {
                                            propertyOffers = true;
                                        }
                                        else
                                        {
                                        }
                                    }
                                    propertyOffers = true;
                                }
                                else if (choice == 2)
                                {
                                }
                                else if (choice == 3)
                                {
                                }

                                sopln("If you want to offer properties, type '1'.");
                                sopln("If you want to offer diamonds, type '2'.");
                                sopln("If you want to offer card, type '3'.");
                                sopln("If you want to offer properties and diamonds, type '4'.");
                                sopln("If you want to offer properties and card, type '5'.");
                                sopln("If you want to offer diamonds and card, type '6'.");
                                sopln("If you want to offer properties, card and diamonds, type '6'.");

                                choice = scan.nextInt();
                                scan.nextLine();

                                if (choice == 1)
                                {
                                    sopln("These are your properties:");

                                    ArrayList <Map> currentProperty = players.get(turn).getProperty();

                                    for (int x = 0; x < temp.size(); x++)
                                    {
                                        sopln((x+1) + ": " + temp.get(x).getName());
                                    }

                                    sopln("enter the number beside each property to offer that property.");
                                    boolean propertyOffers = false;
                                    while (propertyOffers == false)
                                    {
                                        choice = scan.nextInt();
                                        scan.nextLine();

                                        propertyOffered.add(currentProperty.get(choice-1));

                                        sopln("Are you done offering property?");
                                        input = scan.nextLine();

                                        if (input.equalsIgnoreCase("yes"))
                                        {
                                            propertyOffers = true;
                                        }
                                        else
                                        {
                                        }
                                    }
                                    propertyOffers = true;

                                }
                                else if (choice == 2)
                                {
                                }
                                else if (choice == 3)
                                {
                                }
                                else if (choice == 4)
                                {
                                    sopln("These are properties:");

                                    ArrayList <Map> currentProperty = players.get(turn).getProperty();

                                    for (int x = 0; x < temp.size(); x++)
                                    {
                                        sopln((x+1) + ": " + temp.get(x).getName());
                                    }

                                    sopln("enter the number beside each property to offer that property.");
                                    boolean propertyOffers = false;
                                    while (propertyOffers == false)
                                    {
                                        choice = scan.nextInt();
                                        scan.nextLine();

                                        propertyOffered.add(currentProperty.get(choice-1));

                                        sopln("Are you done offering property?");
                                        input = scan.nextLine();

                                        if (input.equalsIgnoreCase("yes"))
                                        {
                                            propertyOffers = true;
                                        }
                                        else
                                        {
                                        }
                                    }
                                    propertyOffers = true;
                                }
                                else if (choice == 5)
                                {
                                    sopln("These are properties:");

                                    ArrayList <Map> currentProperty = players.get(turn).getProperty();

                                    for (int x = 0; x < temp.size(); x++)
                                    {
                                        sopln((x+1) + ": " + temp.get(x).getName());
                                    }

                                    sopln("enter the number beside each property to offer that property.");
                                    boolean propertyOffers = false;
                                    while (propertyOffers == false)
                                    {
                                        choice = scan.nextInt();
                                        scan.nextLine();

                                        propertyOffered.add(currentProperty.get(choice-1));

                                        sopln("Are you done offering property?");
                                        input = scan.nextLine();

                                        if (input.equalsIgnoreCase("yes"))
                                        {
                                            propertyOffers = true;
                                        }
                                        else
                                        {
                                        }
                                    }
                                    propertyOffers = true;
                                }
                                else if (choice == 6)
                                {
                                    sopln("These are properties:");

                                    ArrayList <Map> currentProperty = players.get(turn).getProperty();

                                    for (int x = 0; x < temp.size(); x++)
                                    {
                                        sopln((x+1) + ": " + temp.get(x).getName());
                                    }

                                    sopln("enter the number beside each property to offer that property.");
                                    boolean propertyOffers = false;
                                    while (propertyOffers == false)
                                    {
                                        choice = scan.nextInt();
                                        scan.nextLine();

                                        propertyOffered.add(currentProperty.get(choice-1));

                                        sopln("Are you done offering property?");
                                        input = scan.nextLine();

                                        if (input.equalsIgnoreCase("yes"))
                                        {
                                            propertyOffers = true;
                                        }
                                        else
                                        {
                                        }
                                    }
                                    propertyOffers = true;
                                }

                            }
                        }
                        else if (input.equalsIgnoreCase("mortgage"))
                        {
                            while (mortgageAgreement == false)
                            {
                                sopln("What property do you want to mortgage? Type the index of that property. You can end the mortgage procedure by typing 'end'.");

                                int index = scan.nextInt();
                                scan.nextLine();

                                players.get(turn).mortgage(map[index]);

                                sopln("Do you want to end the mortgage?");

                                input = scan.nextLine();

                                if (!input.equalsIgnoreCase("yes"))
                                {
                                    mortgageAgreement = true;
                                }
                            }
                            mortgageAgreement = false;
                        }
                        else if (input.equalsIgnoreCase("roll"))
                        {
                            sopln("Beginning to roll.");
                            preRoll = false;
                        }        
                    }

                    preRoll = true;

                    if (players.get(turn).getMortgaged().size() != 0)
                    {
                        ArrayList<Map> temp = new ArrayList<>();
                        for (int x = 0; x < temp.size(); x++)
                        {
                            sopln("You either have to pay " + temp.get(x).getName() + "'s mortgage now, or pay the 10% interest and still have the property mortgaged.");
                            sopln("Type 'interest' if you are paying the interest, and type 'full' if you are paying the full price.");

                            input = scan.nextLine();

                            if (input.equalsIgnoreCase("full"))
                            {
                                players.get(turn).unMortgage(temp.get(x));
                            }
                            else
                            {
                                players.get(turn).takeDiamond((int)(temp.get(x).getPrice()*.5*.1));
                            }
                        }
                    }

                    if (bankrupt[turn])
                    {
                        turn++;
                        bankrupt[turn] = true;
                    }

                    else if (jailDays == 3)
                    {
                        jailDays = 0;
                        players.get(turn).setJail(false);
                    }

                    else if (players.get(turn).getJail() == false)
                    {
                        sopln("It is " + players.get(turn).getName() + "'s turn.");
                        sopln("Roll the dice.");

                        dice = function.rollDice();

                        if (function.doubleDice(dice))
                        {
                            sopln("You rolled a double!");
                            reTurn = true;
                            doubleCounter++;
                        }

                        if (doubleCounter == 3)
                        {
                            players.get(turn).setJail(true);
                            players.get(turn).setPlayerPosition(10);
                            reTurn = false;
                            doubleCounter = 0;
                        }                    
                        else
                        {
                            sopln("You rolled a " + function.diceValue(dice));
                            distance = players.get(turn).getPlayerPosition() + function.diceValue(dice);

                            if (distance > 40)
                            {
                                players.get(turn).setPlayerPosition(distance-40);
                                if (map[players.get(turn).getPlayerPosition()].propertyStatus() ||
                                map[players.get(turn).getPlayerPosition()].trainStatus() ||
                                map[players.get(turn).getPlayerPosition()].utilityStatus())
                                {
                                    sopln("You landed on " + map[players.get(turn).getPlayerPosition()].getName());
                                    if (map[players.get(turn).getPlayerPosition()].ownerStatus())
                                    {
                                        int index = 0;

                                        for (int x = 0; x < players.size(); x++)
                                        {
                                            if (players.get(x).getName().equalsIgnoreCase(map[players.get(turn).getPlayerPosition()].getName()))
                                            {
                                                index = x;
                                            }
                                        }

                                        sopln("This property is owned by " + players.get(index).getName());

                                        if (map[players.get(turn).getPlayerPosition()].propertyStatus())
                                        {
                                            if (players.get(index).checkColor(map[players.get(turn).getPlayerPosition()].getColor()) )
                                            {
                                                if (map[players.get(turn).getPlayerPosition()].getHouses() > 0 || map[players.get(turn).getPlayerPosition()].getHotel() > 0)
                                                {
                                                    if (map[players.get(turn).getPlayerPosition()].getHotel() > 0)
                                                    {
                                                        sopln(players.get(index).getName() + " has a hotel. LOL");
                                                        players.get(turn).takeDiamond(map[players.get(turn).getPlayerPosition()].getHotelRent());
                                                        players.get(index).giveDiamond(map[players.get(turn).getPlayerPosition()].getHotelRent());

                                                        sopln(players.get(turn).getName() + " now have " + players.get(turn).getDiamond() + " diamonds.");
                                                        sopln(players.get(index).getName() + " now have " + players.get(index).getDiamond() + " diamonds.");
                                                    }
                                                    else if (map[players.get(turn).getPlayerPosition()].getHouses() > 0)
                                                    {
                                                        sopln(players.get(index).getName() + " has " + map[players.get(turn).getPlayerPosition()].getHouses() + " houses. LOL");
                                                        players.get(turn).takeDiamond(map[players.get(turn).getPlayerPosition()].getHouseRent());
                                                        players.get(index).giveDiamond(map[players.get(turn).getPlayerPosition()].getHouseRent());

                                                        sopln(players.get(turn).getName() + " now have " + players.get(turn).getDiamond() + " diamonds.");
                                                        sopln(players.get(index).getName() + " now have " + players.get(index).getDiamond() + " diamonds.");
                                                    }
                                                }
                                                else
                                                {
                                                    sopln(players.get(index).getName() + " have this set. LOL");
                                                    players.get(turn).takeDiamond(map[players.get(turn).getPlayerPosition()].getRent()*2);
                                                    players.get(index).giveDiamond(map[players.get(turn).getPlayerPosition()].getRent()*2);

                                                    sopln(players.get(turn).getName() + " now have " + players.get(turn).getDiamond() + " diamonds.");
                                                    sopln(players.get(index).getName() + " now have " + players.get(index).getDiamond() + " diamonds.");
                                                }
                                            }
                                            else
                                            {
                                                sopln(players.get(index).getName() + " owns this property. LOL");
                                                players.get(turn).takeDiamond(map[players.get(turn).getPlayerPosition()].getRent());
                                                players.get(index).giveDiamond(map[players.get(turn).getPlayerPosition()].getRent());

                                                sopln(players.get(turn).getName() + " now have " + players.get(turn).getDiamond() + " diamonds.");
                                                sopln(players.get(index).getName() + " now have " + players.get(index).getDiamond() + " diamonds.");
                                            }
                                        }
                                        else if (map[players.get(turn).getPlayerPosition()].trainStatus())
                                        {
                                            sopln(players.get(index).getName() + " owns this property. LOL");
                                            players.get(turn).takeDiamond(map[players.get(turn).getPlayerPosition()].getRent()*players.get(index).noTrains());
                                            players.get(index).giveDiamond(map[players.get(turn).getPlayerPosition()].getRent()*players.get(index).noTrains());

                                            sopln(players.get(turn).getName() + " now have " + players.get(turn).getDiamond() + " diamonds.");
                                            sopln(players.get(index).getName() + " now have " + players.get(index).getDiamond() + " diamonds.");
                                        }
                                        else
                                        {
                                            sopln("You landed on a Utility. LOL");
                                            players.get(turn).takeDiamond(map[players.get(turn).getPlayerPosition()].getRent());
                                            players.get(index).giveDiamond(map[players.get(turn).getPlayerPosition()].getRent());

                                            sopln(players.get(turn).getName() + " now have " + players.get(turn).getDiamond() + " diamonds.");
                                            sopln(players.get(index).getName() + " now have " + players.get(index).getDiamond() + " diamonds.");
                                        }
                                    }
                                    else
                                    {
                                        sopln("Do you want to buy this property? Enter 'yes' or 'no.");
                                        input = scan.nextLine();

                                        if (input.equalsIgnoreCase("Yes"))
                                        {
                                            sopln("You have to pay" + map[players.get(turn).getPlayerPosition()].getPrice() + " diamonds.");
                                            players.get(turn).takeDiamond(map[players.get(turn).getPlayerPosition()].getPrice());
                                            players.get(turn).addProperty(map[players.get(turn).getPlayerPosition()]);
                                            map[players.get(turn).getPlayerPosition()].setOwner(players.get(turn).getName());     

                                            sopln(players.get(turn).getName() + " now have " + players.get(turn).getDiamond() + " diamonds.");
                                        }
                                        else
                                        {
                                        }
                                    }
                                }
                                else if (map[players.get(turn).getPlayerPosition()].goSpotStatus() )
                                {
                                    sopln("You landed on Go!");
                                    players.get(turn).giveDiamond(32);

                                    sopln(players.get(turn).getName() + " now have " + players.get(turn).getDiamond() + " diamonds.");
                                }
                                else if (map[players.get(turn).getPlayerPosition()].chestStatus() )
                                {
                                    sopln("You landed on a chest spot!");
                                    cards.chestAction(chest[(int)(Math.random()*16)], players, players.get(turn));

                                    if (players.get(turn).getJail() == true)
                                    {
                                        turn++;
                                        postRoll = false;
                                    }

                                    int temp = chest[(int)(Math.random()*16)];

                                    for( int x = 15; x > (int)(Math.random()*16); x--)
                                    {                                       
                                        chest[x-1] = chest[x];
                                    }
                                    chest[15] = temp;

                                    sopln(players.get(turn).getName() + " now have " + players.get(turn).getDiamond() + " diamonds.");
                                }
                                else if (map[players.get(turn).getPlayerPosition()].chanceStatus() )
                                {
                                    sopln("You landed on chance spot!");
                                    cards.chanceAction(chance[(int)(Math.random()*16)], players, players.get(turn));

                                    if (players.get(turn).getJail() == true)
                                    {
                                        turn++;
                                        postRoll = false;
                                    }
                                    int temp = chance[(int)(Math.random()*16)];

                                    for( int x = 15; x > (int)(Math.random()*16); x--)
                                    {                                       
                                        chance[x-1] = chance[x];
                                    }
                                    chance[15] = temp;

                                    sopln(players.get(turn).getName() + " now have " + players.get(turn).getDiamond() + " diamonds.");
                                }
                                else if (map[players.get(turn).getPlayerPosition()].taxStatus())
                                {
                                    sopln("You have to pay taxes.");
                                    players.get(turn).takeDiamond(map[players.get(turn).getPlayerPosition()].getPrice());
                                    map[players.get(turn).getPlayerPosition()].collectTax(map[players.get(turn).getPlayerPosition()].getPrice());
                                    sopln(players.get(turn).getName() + " now have " + players.get(turn).getDiamond() + " diamonds.");
                                }
                                else if (map[players.get(turn).getPlayerPosition()].taxReturnStatus())
                                {
                                    sopln("You can collect taxes!");
                                    players.get(turn).giveDiamond(map[players.get(turn).getPlayerPosition()].returnTax());
                                    map[players.get(turn).getPlayerPosition()].resetTax();
                                    sopln(players.get(turn).getName() + " now have " + players.get(turn).getDiamond() + " diamonds.");
                                }
                                else if (players.get(turn).getPlayerPosition() == 30)
                                {
                                    players.get(turn).setJail(true);
                                    turn++;
                                    postRoll = false;
                                    players.get(turn).setPlayerPosition(10);
                                }                               
                            }
                            else
                            {
                                players.get(turn).setPlayerPosition(distance);
                                if (map[players.get(turn).getPlayerPosition()].propertyStatus() ||
                                map[players.get(turn).getPlayerPosition()].trainStatus() ||
                                map[players.get(turn).getPlayerPosition()].utilityStatus())
                                {
                                    sopln("You landed on " + map[players.get(turn).getPlayerPosition()].getName());
                                    if (map[players.get(turn).getPlayerPosition()].ownerStatus())
                                    {
                                        int index = 0;

                                        for (int x = 0; x < players.size(); x++)
                                        {
                                            if (players.get(x).getName().equalsIgnoreCase(map[players.get(turn).getPlayerPosition()].getName()))
                                            {
                                                index = x;
                                            }
                                        }

                                        sopln("This property is owned by " + players.get(index).getName());

                                        if (map[players.get(turn).getPlayerPosition()].propertyStatus())
                                        {
                                            if (players.get(index).checkColor(map[players.get(turn).getPlayerPosition()].getColor()) )
                                            {
                                                if (map[players.get(turn).getPlayerPosition()].getHouses() > 0 || map[players.get(turn).getPlayerPosition()].getHotel() > 0)
                                                {
                                                    if (map[players.get(turn).getPlayerPosition()].getHotel() > 0)
                                                    {
                                                        sopln(players.get(index).getName() + " has a hotel. LOL");
                                                        players.get(turn).takeDiamond(map[players.get(turn).getPlayerPosition()].getHotelRent());
                                                        players.get(index).giveDiamond(map[players.get(turn).getPlayerPosition()].getHotelRent());

                                                        sopln(players.get(turn).getName() + " now have " + players.get(turn).getDiamond() + " diamonds.");
                                                        sopln(players.get(index).getName() + " now have " + players.get(index).getDiamond() + " diamonds.");
                                                    }
                                                    else if (map[players.get(turn).getPlayerPosition()].getHouses() > 0)
                                                    {
                                                        sopln(players.get(index).getName() + " has " + map[players.get(turn).getPlayerPosition()].getHouses() + " houses. LOL");
                                                        players.get(turn).takeDiamond(map[players.get(turn).getPlayerPosition()].getHouseRent());
                                                        players.get(index).giveDiamond(map[players.get(turn).getPlayerPosition()].getHouseRent());

                                                        sopln(players.get(turn).getName() + " now have " + players.get(turn).getDiamond() + " diamonds.");
                                                        sopln(players.get(index).getName() + " now have " + players.get(index).getDiamond() + " diamonds.");
                                                    }
                                                }
                                                else
                                                {
                                                    sopln(players.get(index).getName() + " have this set. LOL");
                                                    players.get(turn).takeDiamond(map[players.get(turn).getPlayerPosition()].getRent()*2);
                                                    players.get(index).giveDiamond(map[players.get(turn).getPlayerPosition()].getRent()*2);

                                                    sopln(players.get(turn).getName() + " now have " + players.get(turn).getDiamond() + " diamonds.");
                                                    sopln(players.get(index).getName() + " now have " + players.get(index).getDiamond() + " diamonds.");
                                                }
                                            }
                                            else
                                            {
                                                sopln(players.get(index).getName() + " owns this property. LOL");
                                                players.get(turn).takeDiamond(map[players.get(turn).getPlayerPosition()].getRent());
                                                players.get(index).giveDiamond(map[players.get(turn).getPlayerPosition()].getRent());

                                                sopln(players.get(turn).getName() + " now have " + players.get(turn).getDiamond() + " diamonds.");
                                                sopln(players.get(index).getName() + " now have " + players.get(index).getDiamond() + " diamonds.");
                                            }
                                        }
                                        else if (map[players.get(turn).getPlayerPosition()].trainStatus())
                                        {
                                            sopln(players.get(index).getName() + " owns this property. LOL");
                                            players.get(turn).takeDiamond(map[players.get(turn).getPlayerPosition()].getRent()*players.get(index).noTrains());
                                            players.get(index).giveDiamond(map[players.get(turn).getPlayerPosition()].getRent()*players.get(index).noTrains());

                                            sopln(players.get(turn).getName() + " now have " + players.get(turn).getDiamond() + " diamonds.");
                                            sopln(players.get(index).getName() + " now have " + players.get(index).getDiamond() + " diamonds.");
                                        }
                                        else
                                        {
                                            sopln("You landed on a Utility. LOL");
                                            players.get(turn).takeDiamond(map[players.get(turn).getPlayerPosition()].getRent());
                                            players.get(index).giveDiamond(map[players.get(turn).getPlayerPosition()].getRent());

                                            sopln(players.get(turn).getName() + " now have " + players.get(turn).getDiamond() + " diamonds.");
                                            sopln(players.get(index).getName() + " now have " + players.get(index).getDiamond() + " diamonds.");
                                        }
                                    }
                                    else
                                    {
                                        sopln("Do you want to buy this property? Enter 'yes' or 'no.");
                                        input = scan.nextLine();

                                        if (input.equalsIgnoreCase("Yes"))
                                        {
                                            sopln("You have to pay " + map[players.get(turn).getPlayerPosition()].getPrice() + " diamonds.");
                                            players.get(turn).takeDiamond(map[players.get(turn).getPlayerPosition()].getPrice());
                                            players.get(turn).addProperty(map[players.get(turn).getPlayerPosition()]);
                                            map[players.get(turn).getPlayerPosition()].setOwner(players.get(turn).getName());                  

                                            sopln(players.get(turn).getName() + " now have " + players.get(turn).getDiamond() + " diamonds.");
                                        }
                                        else
                                        {
                                        }
                                    }
                                }
                                else if (map[players.get(turn).getPlayerPosition()].goSpotStatus() )
                                {
                                    sopln("You landed on Go!");
                                    players.get(turn).giveDiamond(32);

                                    sopln(players.get(turn).getName() + " now have " + players.get(turn).getDiamond() + " diamonds.");
                                }
                                else if (map[players.get(turn).getPlayerPosition()].chestStatus() )
                                {
                                    sopln("You landed on a chest spot!");
                                    cards.chestAction(chest[0], players, players.get(turn));

                                    if (players.get(turn).getJail() == true)
                                    {
                                        turn++;
                                        postRoll = false;
                                    }

                                    int temp = chest[0];

                                    for( int x = 15; x > 0; x--)
                                    {                                       
                                        chest[x-1] = chest[x];
                                    }
                                    chest[15] = temp;

                                    sopln(players.get(turn).getName() + " now have " + players.get(turn).getDiamond() + " diamonds.");
                                }
                                else if (map[players.get(turn).getPlayerPosition()].chanceStatus() )
                                {
                                    sopln("You landed on chance spot!");
                                    cards.chanceAction(chance[0], players, players.get(turn));

                                    if (players.get(turn).getJail() == true)
                                    {
                                        turn++;
                                        postRoll = false;
                                    }

                                    int temp = chance[0];

                                    for( int x = 15; x > 0; x--)
                                    {                                       
                                        chance[x-1] = chance[x];
                                    }
                                    chance[15] = temp;

                                    sopln(players.get(turn).getName() + " now have " + players.get(turn).getDiamond() + " diamonds.");
                                }
                                else if (map[players.get(turn).getPlayerPosition()].taxStatus())
                                {
                                    sopln("You landed on a tax spot. You will have to pay.");
                                    players.get(turn).takeDiamond(map[players.get(turn).getPlayerPosition()].getPrice());
                                    map[players.get(turn).getPlayerPosition()].collectTax(map[players.get(turn).getPlayerPosition()].getPrice());
                                    sopln(players.get(turn).getName() + " now have " + players.get(turn).getDiamond() + " diamonds.");
                                }
                                else if (map[players.get(turn).getPlayerPosition()].taxReturnStatus())
                                {
                                    sopln("You can collect taxes!");
                                    players.get(turn).giveDiamond(map[players.get(turn).getPlayerPosition()].returnTax());
                                    map[players.get(turn).getPlayerPosition()].resetTax();
                                    sopln(players.get(turn).getName() + " now have " + players.get(turn).getDiamond() + " diamonds.");
                                }
                                else if (players.get(turn).getPlayerPosition() == 30)
                                {
                                    players.get(turn).setJail(true);
                                    turn++;
                                    postRoll = false;
                                    players.get(turn).setPlayerPosition(10);
                                } 
                            }

                            if (players.get(turn).getDiamond() == 0)
                            {
                                bankrupt[turn] = true;
                                numBankrupt++;
                            }                        

                            if (numBankrupt + 1 == players.size())
                            {
                                for (int x = 0; x < bankrupt.length; x++)
                                {
                                    if (bankrupt[x] == false)
                                    {
                                        sopln("Player " + players.get(x).getName() + " won!");
                                        postRoll = false;
                                        game = false;
                                    }
                                }
                            }

                            while (postRoll)
                            {
                                sopln("Your turn is almost ended. You can check your 'diamonds', 'properties', or 'mortgaged'. You can end turn by typing 'end'.");
                                sopln("You can also check how many houses or hotels on each of your properties by pressing 'check'.");
                                input = scan.nextLine();

                                if (input.equalsIgnoreCase("diamonds"))
                                {
                                    sopln("You have " + players.get(turn).getDiamond());
                                }
                                else if (input.equalsIgnoreCase("properties"))
                                {
                                    sopln("You have:");

                                    ArrayList <Map> temp = players.get(turn).getProperty();

                                    for (int x = 0; x < temp.size(); x++)
                                    {
                                        sopln(temp.get(x).getName());
                                    }
                                }
                                else if (input.equalsIgnoreCase("mortgaged"))
                                {
                                    sopln("These properties are mortgaged:");

                                    ArrayList <Map> temp = players.get(turn).getMortgaged();

                                    for (int x = 0; x < temp.size(); x++)
                                    {
                                        sopln(temp.get(x).getName());
                                    }
                                }
                                else if (input.equalsIgnoreCase("check"))
                                {
                                    sopln("Enter the index of the property you want to check.");
                                    int index = scan.nextInt();
                                    scan.nextLine();

                                    sopln("You have " + map[index].getHouses() + " houses and " + map[index].getHotel() + " hotels.");
                                }
                                else if (input.equalsIgnoreCase("end"))
                                {
                                    sopln("Turn ended.");
                                    turn++;
                                    postRoll = false;
                                }
                            }
                            postRoll = true;
                        }                        
                    }
                }                              
            }
            else if (input.equalsIgnoreCase("quit"))
            {
                start = false;
            }
        }

    }

    public static void sop(String x)
    {
        System.out.print(x);

    }

    public static void sopln(String x)
    {
        System.out.println(x);
    }
}
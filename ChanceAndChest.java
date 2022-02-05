
import java.util.*;
public class ChanceAndChest
{
    private Chests chest = new Chests();
    private Chance chance = new Chance();

    public ChanceAndChest()
    {
    }

    public void chestAction(int card, ArrayList <Players> player, Players currentPlayer)
    {
        if (card == 0)
        {
            sopln("You are transported to 'Go'. Free 32 diamonds!");
            chest.toGo(currentPlayer);
        }

        else if (card == 1)
        {
            sopln("There is a bank error. Free 32 diamonds!");
            chest.bankError(currentPlayer);
        }
        else if (card == 2)
        {
            sopln("You visit the doctor. Pay 8 diamonds!");
            chest.doctorFee(currentPlayer);
        }
        else if (card == 3)
        {
            sopln("You received a get out of jail free card. Use it carefully!");
            chest.getOutOfJail(currentPlayer);
        }
        else if (card == 4)
        {
            sopln("You are sent to jail. Use a card, roll a double, or pay 8 diamonds.");
            chest.goToJail(currentPlayer);
        }
        else if (card == 5)
        {
            sopln("You receive 8 diamonds from each player for an opera night.");
            chest.operaNight(player,currentPlayer);
        }
        else if (card == 6)
        {
            sopln("You get a Christmas gift. Receive 16 diamonds!");
            chest.Christmas(currentPlayer);
        }
        else if (card == 7)
        {
            sopln("You get a tax refund. Get 4 diamonds!");
            chest.taxRefund(currentPlayer);
        }
        else if (card == 8)
        {
            sopln("It is your birthday! Receive 2 diamonds from each player!");
            chest.birthday(player,currentPlayer);
        }

        else if (card == 9)
        {
            sopln("Life insurance improved. You get 16 diamonds!");
            chest.lifeInsurance(currentPlayer);
        }
        else if (card == 10)
        {
            sopln("You visit the hospital. Pay 4 diamonds.");
            chest.hospitalFee(currentPlayer);
        }
        else if (card == 11)
        {
            sopln("School asked for donations. Pay 4 diamonds!");
            chest.birthday(player,currentPlayer);
        }
        else if (card == 12)
        {
            sopln("People consult you for farming advice. Receive 2 diamonds!");
            chest.consultantPay(currentPlayer);
        }
        else if (card == 13)
        {
            sopln("You have to pay for street Repairs. 7 diamonds per house and 17 diamonds per hotel.");
            chest.streetRepair(currentPlayer);
        }
        else if (card == 14)
        {
            sopln("You get 2nd in a pig beauty contest. Earn 2 diamonds!");
            chest.beautyContestPay(currentPlayer);
        }
        else
        {
            sopln("You inherited 16 diamonds!");
            chest.inheritancePay(currentPlayer);
        }
    }
    
    public void chanceAction(int card, ArrayList <Players> player, Players currentPlayer)
    {
        if (card == 0)
        {
            sopln("You are transported to 'Go'. Free 32 diamonds!");
            chance.toGo(currentPlayer);
        }

        else if (card == 1)
        {
            sopln("You are sent to St. Charles!");
            chance.toCharles(currentPlayer);
        }
        else if (card == 2)
        {
            sopln("You are sent to Illinois!");
            chance.toIllinois(currentPlayer);
        }
        else if (card == 3)
        {
            sopln("You are sent to the closest Utility. If someone owns that utility, pay double the rent. If not, pay 10 times the roll price.");
            chance.toUtility(currentPlayer);
            
        }
        else if (card == 4)
        {
            sopln("You are sent to jail. Use a card, roll a double, or pay 8 diamonds.");
            chance.goToJail(currentPlayer);
        }
        else if (card == 5)
        {
            sopln("You receive 8 diamonds from each player for an opera night.");
            chest.operaNight(player,currentPlayer);
        }
        else if (card == 6)
        {
            sopln("You get a Christmas gift. Receive 16 diamonds!");
            chest.Christmas(currentPlayer);
        }
        else if (card == 7)
        {
            sopln("You get a tax refund. Get 4 diamonds!");
            chest.taxRefund(currentPlayer);
        }
        else if (card == 8)
        {
            sopln("It is your birthday! Receive 2 diamonds from each player!");
            chest.birthday(player,currentPlayer);
        }

        else if (card == 9)
        {
            sopln("Life insurance improved. You get 16 diamonds!");
            chest.lifeInsurance(currentPlayer);
        }
        else if (card == 10)
        {
            sopln("You visit the hospital. Pay 4 diamonds.");
            chest.hospitalFee(currentPlayer);
        }
        else if (card == 11)
        {
            sopln("School asked for donations. Pay 4 diamonds!");
            chest.birthday(player,currentPlayer);
        }
        else if (card == 12)
        {
            sopln("People consult you for farming advice. Receive 2 diamonds!");
            chest.consultantPay(currentPlayer);
        }
        else if (card == 13)
        {
            sopln("You have to pay for street Repairs. 7 diamonds per house and 17 diamonds per hotel.");
            chest.streetRepair(currentPlayer);
        }
        else if (card == 14)
        {
            sopln("You get 2nd in a pig beauty contest. Earn 2 diamonds!");
            chest.beautyContestPay(currentPlayer);
        }
        else
        {
            sopln("You inherited 16 diamonds!");
            chest.inheritancePay(currentPlayer);
        }
    }

    public void sopln(String x)
    {
        System.out.println(x);
    }
}

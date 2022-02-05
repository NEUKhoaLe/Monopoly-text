
/**
 * Write a description of class Chests here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;
public class Chests
{      
    public Chests()
    {

    }
    
    public void toGo(Players player)
    {
        player.giveDiamond(32);
        player.setPlayerPosition(0);
    }
    
    public void bankError(Players player)
    {
        player.giveDiamond(32);
    }
    
    public void doctorFee(Players player)
    {
        player.takeDiamond(8);
    }
    
    public void getOutOfJail(Players player)
    {
        player.getOutOfJail();
    }
    
    public void goToJail(Players player)
    {
        player.setPlayerPosition(10);
        player.setJail(true);
    }
    
    public void operaNight(ArrayList<Players> player, Players currentPlayer)
    {
        int x = 0;
        int count = 0;
        
        while (x < player.size())
        {
            if (player.get(x).getName().equals(currentPlayer.getName()))
            {
                x++;
            }
            else
            {
                count++;
                x++;
            }
        }
        
        currentPlayer.giveDiamond(count*8);
    }
    
    public void Christmas(Players currentPlayer)
    {
        currentPlayer.giveDiamond(16);
    }
    
    public void taxRefund(Players player)
    {
        player.giveDiamond(4);
    }
    
    public void birthday(ArrayList<Players> player, Players currentPlayer)
    {
        int x = 0;
        int count = 0;
        
        while (x < player.size())
        {
            if (player.get(x).getName().equals(currentPlayer.getName()))
            {
                x++;
            }
            else
            {
                count++;
                x++;
            }
        }
        
        currentPlayer.giveDiamond(count*2);
    }
    
    public void lifeInsurance(Players player)
    {
        player.giveDiamond(16);
    }
    
    public void hospitalFee(Players player)
    {
        player.takeDiamond(4);
    }
    
    public void schoolFee(Players player)
    {
        player.takeDiamond(4);
    }
    
    public void consultantPay(Players player)
    {
        player.giveDiamond(2);
    }

    public void streetRepair(Players player)
    {
        int pay = player.getTotalHouse()*7 + player.getTotalHotel()*17;
        player.takeDiamond(pay);
    }
    
    public void beautyContestPay(Players player)
    {
        player.giveDiamond(2);
    }
    
    public void inheritancePay(Players player)
    {
        player.giveDiamond(16);
    }
}


import java.util.*;
public class Chance
{

    public Chance()
    {
    }

    public void toGo(Players player)
    {
        player.giveDiamond(32);
        player.setPlayerPosition(0);
    }

    public void toCharles(Players player)
    {
        if (player.getPlayerPosition() > 11)
        {
            player.giveDiamond(32);
            player.setPlayerPosition(11);
        }
        else
        {
            player.setPlayerPosition(11);
        }
    }

    public void toIllinois(Players player)
    {
        if (player.getPlayerPosition() > 24)
        {
            player.giveDiamond(32);
            player.setPlayerPosition(24);
        }
        else
        {
            player.setPlayerPosition(24);
        }
    }

    public void toUtility(Players player)
    {
        //12 28
        int distance1 = Math.abs(player.getPlayerPosition()-12);
        int distance2 = Math.abs(player.getPlayerPosition()-28);

        if (distance1 < distance2 || distance1 == distance2)
        {
            if (player.getPlayerPosition() > 12)
            {
                player.giveDiamond(32);
                player.setPlayerPosition(12);
            }
            else
            {
                player.setPlayerPosition(12);
            }
        }
        else
        {
            if (player.getPlayerPosition() > 28)
            {
                player.giveDiamond(32);
                player.setPlayerPosition(28);
            }
            else
            {
                player.setPlayerPosition(28);
            }
        }
    }

    public void dividends(Players player)
    {
        player.giveDiamond(8);
    }

    public void getOutOfJail(Players player)
    {
        player.getOutOfJail();
    }

    public void back3(Players player)
    {
        if (player.getPlayerPosition() - 3 < 0)
        {
            int difference = 3 - player.getPlayerPosition();
            player.setPlayerPosition(40-difference);
        }
        else
        {
            player.setPlayerPosition(player.getPlayerPosition()-3);
        }
    }

    public void goToJail(Players player)
    {
        player.setPlayerPosition(10);
        player.setJail(true);
    }

    public void generalRepair(Players player)
    {
        int pay = player.getTotalHouse()*4 + player.getTotalHotel()*16;
        player.takeDiamond(pay);
    }
    
    public void poorTax(Players player)
    {
        player.takeDiamond(3);
    }
    
    public void toReading(Players player)
    {
        if (player.getPlayerPosition() > 5)
        {
            player.giveDiamond(32);
            player.setPlayerPosition(5);
        }
        else
        {
            player.setPlayerPosition(5);
        }
    }
    
    public void toBoardwalk(Players player)
    {
        player.setPlayerPosition(39);
    }
    
    public void Chairman(ArrayList<Players> player, Players currentPlayer)
    {
        int x = 0;
        int z = 0;
        
        while (x < player.size())
        {
            if (currentPlayer.getName().equals(player.get(x).getName()))
            {
                x++;
            }
            else
            {
                z++;
            }
        }
        
        currentPlayer.takeDiamond(z*8);
    }
    
    public void matureBuildings(Players player)
    {
        player.giveDiamond(40);
    }
    
    public void crossword(Players player)
    {
        player.giveDiamond(16);
    }
}

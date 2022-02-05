
import java.util.*;
public class setUpProperties
{
    private Map[] map = new Map [40];
    public setUpProperties()
    {
        for (int x = 0; x < 40; x++)
        {
            map[x] = new Map();
        }
    }

    public Map[] setUp()
    {
        map[0].goSpot(true);
        map[0].setName("Go Spot! Earn 32 diamonds!!");
        map[0].setPosition(0);

        map[1].Property(true);
        map[1].setName("Mediterranean Farm");
        map[1].setColor("Brown");
        map[1].setPrice(10);
        map[1].setHouse(8);
        map[1].setHotel(8);
        map[1].setRent(1);        
        int [] spot = {5,9,15,21};
        map[1].setHouseRent(spot);
        map[1].setHotelRent(40);
        map[1].setPosition(1);

        map[2].chest(true);
        map[2].setName("Chest! May the odds be ever in your favor!");
        map[2].setPosition(2);

        map[3].Property(true);
        map[3].setName("Baltic Farm");
        map[3].setColor("Brown");
        map[3].setPrice(12);
        map[3].setHouse(8);
        map[3].setHotel(8);
        map[3].setRent(1);        
        int [] spot3 = {6,10,17,49};
        map[3].setHouseRent(spot);
        map[3].setHotelRent(72);
        map[3].setPosition(3);

        map[4].tax(true);
        map[4].setName("Tax. Pay Up!");
        map[4].setPrice(32);
        map[4].setPosition(4);

        map[5].train(true);
        map[5].setName("Reading Nether Portal");
        map[5].setPrice(32);
        map[5].setPosition(5);

        map[6].Property(true);
        map[6].setName("Oriental Village");
        map[6].setColor("Light Blue");
        map[6].setPrice(16);
        map[6].setHouse(8);
        map[6].setHotel(8);
        map[6].setRent(2);        
        int [] spot6 = {6,15,41,72};
        map[6].setHouseRent(spot);
        map[6].setHotelRent(90);
        map[6].setPosition(6);

        map[7].chance(true);
        map[7].setName("Chance! May the odds be ever in your favor!");
        map[7].setPosition(7);

        map[8].Property(true);
        map[8].setName("Vermont Village");
        map[8].setColor("Light Blue");
        map[8].setPrice(16);
        map[8].setHouse(8);
        map[8].setHotel(8);
        map[8].setRent(2);        
        int [] spot8 = {6,15,41,72};
        map[8].setHouseRent(spot);
        map[8].setHotelRent(90);
        map[8].setPosition(8);

        map[9].Property(true);
        map[9].setName("Vermont Village");
        map[9].setColor("Light Blue");
        map[9].setPrice(19);
        map[9].setHouse(8);
        map[9].setHotel(8);
        map[9].setRent(2);        
        int [] spot9 = {7,16,48,80};
        map[9].setHouseRent(spot);
        map[9].setHotelRent(96);
        map[9].setPosition(9);

        map[10].setName("Visiting the Jail.");
        map[10].setPosition(10);

        map[11].Property(true);
        map[11].setName("St. Charles Mine");
        map[11].setColor("Pink");
        map[11].setPrice(20);
        map[11].setHouse(16);
        map[11].setHotel(16);
        map[11].setRent(3);        
        int [] spot11 = {8,24,88,100};
        map[11].setHouseRent(spot);
        map[11].setHotelRent(120);
        map[11].setPosition(11);

        map[12].utility(true);
        map[12].setName("Redstone workers demand money. Pay up!");
        map[12].setPrice(24);
        map[12].setPosition(12);

        map[13].Property(true);
        map[13].setName("States Mine");
        map[13].setColor("Pink");
        map[13].setPrice(20);
        map[13].setHouse(16);
        map[13].setHotel(16);
        map[13].setRent(3);        
        int [] spot13 = {8,24,72,100};
        map[13].setHouseRent(spot);
        map[13].setHotelRent(120);
        map[13].setPosition(13);

        map[14].Property(true);
        map[14].setName("Virginia Mine");
        map[14].setColor("Pink");
        map[14].setPrice(20);
        map[14].setHouse(16);
        map[14].setHotel(16);
        map[14].setRent(4);        
        int [] spot14 = {9,28,80,112};
        map[14].setHouseRent(spot);
        map[14].setHotelRent(144);
        map[14].setPosition(14);

        map[15].train(true);
        map[15].setName("Pennsylvania Nether Portal");
        map[15].setPrice(32);
        map[15].setPosition(15);

        map[16].Property(true);
        map[16].setName("St. James Ravine");
        map[16].setColor("Orange");
        map[16].setPrice(28);
        map[16].setHouse(16);
        map[16].setHotel(16);
        map[16].setRent(5);        
        int [] spot16 = {10,32,84,116};
        map[16].setHouseRent(spot);
        map[16].setHotelRent(144);
        map[16].setPosition(16);

        map[17].chest(true);
        map[17].setName("Chest! May the odds be ever in your favor!");
        map[17].setPosition(17);

        map[18].Property(true);
        map[18].setName("Tennessee Ravine");
        map[18].setColor("Orange");
        map[18].setPrice(28);
        map[18].setHouse(16);
        map[18].setHotel(16);
        map[18].setRent(5);        
        int [] spot18 = {10,32,84,116};
        map[18].setHouseRent(spot);
        map[18].setHotelRent(144);
        map[18].setPosition(18);

        map[19].Property(true);
        map[19].setName("New York Ravine");
        map[19].setColor("Orange");
        map[19].setPrice(32);
        map[19].setHouse(16);
        map[19].setHotel(16);
        map[19].setRent(6);        
        int [] spot19 = {14,36,96,128};
        map[19].setHouseRent(spot);
        map[19].setHotelRent(160);
        map[19].setPosition(19);

        map[20].taxReturn(true);
        map[20].setName("Income Tax! Free diamonds!");
        map[20].setPosition(20);

        map[21].Property(true);
        map[21].setName("Kentucky Skyblock");
        map[21].setColor("Red");
        map[21].setPrice(36);
        map[21].setHouse(20);
        map[21].setHotel(20);
        map[21].setRent(6);        
        int [] spot21 = {15,40,112,140};
        map[21].setHouseRent(spot);
        map[21].setHotelRent(168);
        map[21].setPosition(21);

        map[22].chance(true);
        map[22].setName("Chance! May the odds be ever in your favor!");
        map[22].setPosition(22);

        map[23].Property(true);
        map[23].setName("Indiana Skyblock");
        map[23].setColor("Red");
        map[23].setPrice(36);
        map[23].setHouse(20);
        map[23].setHotel(20);
        map[23].setRent(6);        
        int [] spot23 = {15,40,112,140};
        map[23].setHouseRent(spot);
        map[23].setHotelRent(168);
        map[23].setPosition(23);

        map[24].Property(true);
        map[24].setName("Illinois Skyblock");
        map[24].setColor("Red");
        map[24].setPrice(37);
        map[24].setHouse(24);
        map[24].setHotel(24);
        map[24].setRent(8);        
        int [] spot24 = {16,48,120,152};
        map[24].setHouseRent(spot);
        map[24].setHotelRent(176);
        map[24].setPosition(24);

        map[25].train(true);
        map[25].setName("Brooklyn Nether Portal");
        map[25].setPrice(32);
        map[25].setPosition(25);

        map[26].Property(true);
        map[26].setName("Atlantic Iron farm");
        map[26].setColor("Yellow");
        map[26].setPrice(41);
        map[26].setHouse(24);
        map[26].setHotel(24);
        map[26].setRent(9);        
        int [] spot26 = {17,51,128,155};
        map[26].setHouseRent(spot);
        map[26].setHotelRent(184);
        map[26].setPosition(26);

        map[27].Property(true);
        map[27].setName("Ventnor Iron farm");
        map[27].setColor("Yellow");
        map[27].setPrice(41);
        map[27].setHouse(24);
        map[27].setHotel(24);
        map[27].setRent(9);        
        int [] spot27 = {17,51,128,155};
        map[27].setHouseRent(spot);
        map[27].setHotelRent(184);
        map[27].setPosition(27);

        map[28].utility(true);
        map[28].setName("Water workers demand money. Pay up!");
        map[28].setPrice(24);
        map[28].setPosition(28);

        map[29].Property(true);
        map[29].setName("Marvin Iron farm");
        map[29].setColor("Yellow");
        map[29].setPrice(41);
        map[29].setHouse(24);
        map[29].setHotel(24);
        map[29].setRent(10);        
        int [] spot29 = {18,58,136,162};
        map[29].setHouseRent(spot);
        map[29].setHotelRent(192);
        map[29].setPosition(29);

        map[30].jail(true);
        map[30].setName("Go to Jail. Pay 8 diamonds to skip punishment, or roll a double.");
        map[30].setJailPrice();
        map[30].setPosition(30);

        map[31].Property(true);
        map[31].setName("Pacific Slime farm");
        map[31].setColor("Green");
        map[31].setPrice(48);
        map[31].setHouse(32);
        map[31].setHotel(32);
        map[31].setRent(11);        
        int [] spot31 = {19,62,144,176};
        map[31].setHouseRent(spot);
        map[31].setHotelRent(206);
        map[31].setPosition(31);   

        map[32].Property(true);
        map[32].setName("North Carolina Slime farm");
        map[32].setColor("Green");
        map[32].setPrice(48);
        map[32].setHouse(32);
        map[32].setHotel(32);
        map[32].setRent(11);        
        int [] spot32 = {19,62,144,176};
        map[32].setHouseRent(spot);
        map[32].setHotelRent(206);
        map[32].setPosition(33);
        
        map[33].chest(true);
        map[33].setName("Chest! May the odds be ever in your favor!");
        map[33].setPosition(33);
        
        map[34].Property(true);
        map[34].setName("Pennsylvania Slime farm");
        map[34].setColor("Green");
        map[34].setPrice(50);
        map[34].setHouse(32);
        map[34].setHotel(32);
        map[34].setRent(12);        
        int [] spot34 = {24,72,160,192};
        map[34].setHouseRent(spot);
        map[34].setHotelRent(224);
        map[34].setPosition(34); 
        
        map[35].train(true);
        map[35].setName("Short Nether Portal");
        map[35].setPrice(32);
        map[35].setPosition(35);

        map[36].chance(true);
        map[36].setName("Chance! May the odds be ever in your favor!");
        map[36].setPosition(36);
        
        map[37].Property(true);
        map[37].setName("Park Ender Pearls farm");
        map[37].setColor("Blue");
        map[37].setPrice(56);
        map[37].setHouse(32);
        map[37].setHotel(32);
        map[37].setRent(14);        
        int [] spot37 = {28,80,176,208};
        map[37].setHouseRent(spot);
        map[37].setHotelRent(240);
        map[37].setPosition(37); 
        
        map[38].tax(true);
        map[38].setName("Luxury Tax. Pay Up!");
        map[38].setPrice(16);
        map[38].setPosition(38);
        
        map[39].Property(true);
        map[39].setName("Park Ender Pearls farm");
        map[39].setColor("Blue");
        map[39].setPrice(56);
        map[39].setHouse(32);
        map[39].setHotel(32);
        map[39].setRent(16);        
        int [] spot39 = {32,96,224,272};
        map[39].setHouseRent(spot);
        map[39].setHotelRent(320);
        map[39].setPosition(39); 
        
        return map;

    }
}

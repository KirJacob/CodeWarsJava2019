package cw5_alone_house;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataTest {

    @Test
    public void ex1() {
        char[][] house = {
                "  o                o        #######".toCharArray(),
                "###############             #     #".toCharArray(),
                "#             #        o    #     #".toCharArray(),
                "#  X          ###############     #".toCharArray(),
                "#                                 #".toCharArray(),
                "###################################".toCharArray()
        };
        assertEquals(true, Dinglemouse.allAlone(house));
    }

    @Test
    public void ex2() {
        char[][] house = {
                "#################             ".toCharArray(),
                "#     o         #   o         ".toCharArray(),
                "#          ######        o    ".toCharArray(),
                "####       #                  ".toCharArray(),
                "   #       ###################".toCharArray(),
                "   #                         #".toCharArray(),
                "   #                  X      #".toCharArray(),
                "   ###########################".toCharArray()
        };
        assertEquals(false, Dinglemouse.allAlone(house));
    }
}


package ca.sheridancollege.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rishabh
 */
public class MainCardTest {

    public MainCardTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of checkTotalPlayers method, of class MainCard.
     */
    @Test
    public void testTotalPlayersGood() {
        System.out.println("testTotalPlayersGood");
        int players = 4;
        boolean expResult = true;
        boolean result = MainCard.checkTotalPlayers(players);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    @Test
    public void testTotalPlayersBad() {
        System.out.println("testTotalPlayersBad");
        int players = 10;
        boolean expResult = false;
        boolean result = MainCard.checkTotalPlayers(players);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    @Test
    public void testTotalPlayersBoundary() {
        System.out.println("testTotalPlayersBoundary");
        int players = 7;
        boolean expResult = true;
        boolean result = MainCard.checkTotalPlayers(players);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of CheckGroupOfCards method, of class MainCard.
     */
    @Test
    public void testGroupOfCardsGood() {
        System.out.println("testGroupOfCardsGood");
        int groups = 5;
        boolean expResult = true;
        boolean result = MainCard.checkGroupOfCards(groups);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    @Test
    public void testGroupOfCardsBad() {
        System.out.println("testGroupOfCardsBad");
        int groups = 10;
        boolean expResult = false;
        boolean result = MainCard.checkGroupOfCards(groups);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    @Test
    public void testGroupOfCardsBoundary() {
        System.out.println("testGroupOfCardsBoundary");
        int groups = 7;
        boolean expResult = true;
        boolean result = MainCard.checkGroupOfCards(groups);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of CheckGameOver method, of class MainCard.
     */
    @Test
    public void testGameOverGood() {
        System.out.println("testGameOverGood");
        int size = 0;
        boolean expResult = true;
        boolean result = MainCard.checkGameOver(size);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    @Test
    public void testGameOverBad() {
        System.out.println("testGameOverBad");
        int size = 10;
        boolean expResult = false;
        boolean result = MainCard.checkGameOver(size);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    @Test
    public void testGameOverBoundary() {
        System.out.println("testGameOverBoundary");
        int size = 0;
        boolean expResult = true;
        boolean result = MainCard.checkGameOver(size);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testCheckStringInputGood() {
        System.out.println("checkStringInputGood");
        String Playernumber = "333";
        boolean expResult = true;
        boolean result = MainCard.checkStringInput(Playernumber);
        assertEquals(expResult, result);

    }
    @Test
    public void testCheckStringInputBad() {
        System.out.println("checkStringInputBad");
        String Playernumber = "1a2";
        boolean expResult = false;
        boolean result = MainCard.checkStringInput(Playernumber);
        assertEquals(expResult, result);

    }
    @Test
    public void testCheckStringInputBoundary() {
        System.out.println("checkStringInputBoundary");
        String Playernumber = "1";
        boolean expResult = true;
        boolean result = MainCard.checkStringInput(Playernumber);
        assertEquals(expResult, result);

    }
}

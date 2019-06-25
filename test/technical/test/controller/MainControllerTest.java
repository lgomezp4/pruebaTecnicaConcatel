package technical.test.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * MainController unit test
 *
 * @author Luis Gómez
 */
public class MainControllerTest {

    public MainControllerTest() {
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
     * Test of register method, of class MainController.
     */
    @Test
    public void testRegister() throws Exception {
        System.out.println("register");
        String name = "Rebel name";
        String planet = "Planet name";
        MainController instance = new MainController();
        boolean expResult = true;
        boolean result = instance.register(name, planet);
        assertEquals(expResult, result);
        if (result != expResult) {
            fail("The answer was not the desired");
        }
    }

}

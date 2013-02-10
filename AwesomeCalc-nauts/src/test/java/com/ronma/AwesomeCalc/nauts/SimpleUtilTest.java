package com.ronma.AwesomeCalc.nauts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.ronma.AwesomeCalc.nauts.util.SimpleUtil;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SimpleUtilTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SimpleUtilTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SimpleUtilTest.class );
    }

    /**
     * Some basics :-)
     * @throws ParseException 
     * @throws IOException 
     * @throws FileNotFoundException 
     * @throws URISyntaxException 
     */
    public void testApp()
    {
        assertNotNull(new Naut());
        
        SimpleUtil su = new SimpleUtil();
        
        List<Naut> nauts = su.getNautsSimple();
        assertNotNull("Naut list null", nauts);
        assertFalse("Naut list empty", nauts.isEmpty());
        
        for(Naut naut : nauts) {
        	assertNotNull("Naut null", naut);
        	System.out.println("Naut: " + naut);
        	
        	List<Ability> abilities = naut.getAbilities();
        	assertNotNull("Ability list null", abilities);
        	assertFalse("Ability list empty", abilities.isEmpty());
        	
        	for (Ability ability : abilities) {
        		assertNotNull("Ability null", ability);
        		System.out.println("Ability: " + ability);
        		
        		List<Upgrade> upgrades = ability.getUpgrades();
        		assertNotNull("Upgrade list null", upgrades);
            	assertFalse("Upgrade list empty", upgrades.isEmpty());
            	
            	for (Upgrade upgrade : upgrades) {
            		assertNotNull("Upgrade null", upgrade);
            		System.out.println("Upgrade: " + upgrade);
				}
			}
        	
		}
    }
}

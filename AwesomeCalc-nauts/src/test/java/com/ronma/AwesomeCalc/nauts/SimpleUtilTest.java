package com.ronma.AwesomeCalc.nauts;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
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
        
        jsonTest();
    }
    
    /**
     * test the json read in {@link SimpleUtil}
     */
    private void jsonTest(){
    	//read the json
        BufferedReader jsonReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/naut.json")));
        
        SimpleUtil su = new SimpleUtil();
        List<Naut> nauts = su.getNautsFromJSON(jsonReader);
        assertNotNull("Naut list null", nauts);
        
        for(Naut naut : nauts) {
        	assertNotNull("Naut null", naut);
        	System.out.print("naut: " + naut + ": ");
        	
        	List<Ability> abilities = naut.getAbilities();
        	assertNotNull("Ability list null", abilities);
        	assertFalse("Ability list empty", abilities.isEmpty());
        	
        	for (Ability ability : abilities) {
        		assertNotNull("Ability null", ability);
        		System.out.print(ability + "(");
        		
        		List<Upgrade> upgrades = ability.getUpgrades();
        		assertNotNull("Upgrade list null", upgrades);
            	assertFalse("Upgrade list empty", upgrades.isEmpty());
            	
            	for (Upgrade upgrade : upgrades) {
            		assertNotNull("Upgrade null", upgrade);
            		System.out.print(upgrade + ",");
				}
            	System.out.print(")");
			}
        	System.out.println();
		}
        
        assertFalse("Naut list empty", nauts.isEmpty());
    }
}

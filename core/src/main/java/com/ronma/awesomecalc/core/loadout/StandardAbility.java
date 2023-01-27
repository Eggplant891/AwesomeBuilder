/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ronma.awesomecalc.core.loadout;

/**
 *
 * @author Jason
 */
public class StandardAbility extends Ability {
    public AbilityStats Stats;
    
    public StandardAbility(String name, AbilityStats stats) {
        _name = name;
        Stats = stats;
    }
}

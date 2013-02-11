package com.ronma.awesomecalc.core.loadout.abilities;

public class AutoAttack extends Ability {
    protected int _damage;
    protected float _attackSpeed;
    protected float _range;
    protected int _numShots;
    
    protected float _critChance;
    protected int _critDamage;
    
    protected AutoAttack() {}
    
    public static AutoAttack Create(String name, int dmg, float attackSpd, float range, int numShots) {       
        return CreateWithCrits(name, dmg, attackSpd, range, numShots, 0, 0);
    }
    
    public static AutoAttack CreateWithCrits(String name, int dmg, float attackSpd, float range, int numShots, float critChance, int critDmg) {
        AutoAttack a = new AutoAttack(); 
        
        a._name = name;
        a._damage = dmg;
        a._attackSpeed = attackSpd;
        a._range = range;
        a._numShots = numShots;
        a._critChance = critChance;
        a._critDamage = critDmg;
        
        return a;
    }
}

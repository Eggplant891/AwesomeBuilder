/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ronma.awesomecalc.core.loadout;

/**
 *
 * @author Jason
 */
public class AbilityStats {
    public int _startDamage = 0;
    public int _startDamageToSelf = 0;
    public int _startHealing = 0;
    public float _startRange = 0;
    
    public int _endDamage = 0;
    public int _endDamageToSelf = 0;
    public int _endHealing = 0;
    public float _endRange = 0;
    
    public int _dotDamage = 0;
    public int _hotHealing = 0;
    public float _dotTime = 0;
    
    // Attack values for duration of attack
    public float _durationTime = 0;
    public float _cooldownTime = 0;
    
    public int _healing = 0;
    public int _healingToSelf = 0;
    public float _healingSpeed = 0;
    public float _healingRange = 0;
    public int _shotsPerHeal = 0;
    
    public int _damage = 0; // Healing is negative values    
    public int _damageToSelf = 0;
    public int _shotsPerAttack = 0;
    public float _attackSpeed = 0;
    public float _attackRange = 0;
    
    public int _numEntities = 1; // E.g. weeds, drones. Will apply start/end damage burst to these too i.e. Drone explosion.
    
    public String ToString() {
        String dispString = "";
        dispString += "Cooldown: " + _cooldownTime + "s\n";
        if (_durationTime > 0)
            dispString += "Duration: " + _durationTime + "s\n";
        if (_damage > 0) {
            dispString += "Damage: " + _damage + "\n";
            dispString += "Attack Speed: " + _attackSpeed + "\n";
            dispString += "DPS: " + GetDPS() + "\n";
        }
        
        if (_healing > 0) {
            dispString += "Healing: " + _damage + "\n";
            dispString += "Healing Attack Speed: " + _healingSpeed + "\n";
            dispString += "HPS: " + GetHPS() + "\n";
        }
        
        if (_shotsPerAttack > 1)
            dispString += "Shots: " + _shotsPerAttack + "\n";
        if (_shotsPerHeal > 1)
            dispString += "Healing Shots: " + _shotsPerHeal + "\n";
        if (_numEntities > 1)
            dispString += "Entities: " + _numEntities + "\n";
        
        if (_startDamage > 0)
            dispString += "Start Damage: " + _startDamage + "\n";
        if (_startHealing > 0)
            dispString += "Burst Heal: " + _startHealing + "\n";
        if (_healingToSelf > 0)
            dispString += "Lifesteal: " + _healingToSelf + "\n";
        if (_endDamageToSelf > 0)
            dispString += "Damage to Self: " + _endDamageToSelf + "\n";
        if (_endDamage > 0)
            dispString += "End Damage: " + _endDamage + "\n";
        if (_endHealing > 0)
            dispString += "End Burst Heal: " + _endHealing + "\n";
        if (_dotDamage > 0)
            dispString += "Damage over Time: " + _dotDamage + "\n";
        if (_hotHealing > 0)
            dispString += "Heal over Time: " + _hotHealing + "\n";
        if (_dotTime > 0)
            dispString += "Dot/Hot Duration: " + _dotTime + "\n";
        
        dispString += "TOTAL DAMAGE: " + GetTotalDamage() + "\n";
        int h;
        if ((h = GetTotalHealing()) > 0)
            dispString += "TOTAL HEALING: " + h + "\n";
        return dispString;
    }
    
    public float GetDPS() {
        float dotDPS = 0;
        if (_dotDamage > 0) {
            if (_dotTime > 0) dotDPS = (_dotDamage / _dotTime);
            else dotDPS = _dotDamage;
        }
        if (_damage != 0 && _attackSpeed != 0) {
            return ((_damage * (_attackSpeed / 60.0f)) * _shotsPerAttack) * _numEntities + dotDPS;
        }
        
        return 0f;
    }
    
    public float GetHPS() {
        float dotDPS = 0;
        if (_hotHealing > 0) {
            if (_dotTime > 0) dotDPS = (_hotHealing / _dotTime);
            else dotDPS = _dotDamage;
        }
        if (_healing != 0 && _healingSpeed != 0) {
            return ((_healing * (_healingSpeed / 60.0f)) * _shotsPerHeal) * _numEntities + dotDPS;
        }
        
        return 0f;
    }
    
    public int GetTotalDamage() {
        int totalDamage = 0;
        
        if (_damage != 0 && _attackSpeed != 0) {
            float numAttacks = ((_attackSpeed / 60.0f) * _durationTime);
            numAttacks = (int)Math.ceil(numAttacks);
            totalDamage += ((_damage * _shotsPerAttack) * _numEntities) * (int)numAttacks;
        }
        
        totalDamage += _dotDamage + ((_startDamage + _endDamage) * _numEntities);
        return totalDamage;
    }
    
    public int GetTotalHealing() {
        int totalDamage = 0;
        
        if (_healing != 0 && _healingSpeed != 0) {
            float numAttacks = ((_healingSpeed / 60.0f) * _durationTime);
            numAttacks = (int)Math.ceil(numAttacks);
            totalDamage += ((_healing * _shotsPerHeal) * _numEntities) * (int)numAttacks;
        }
        
        totalDamage += _hotHealing + ((_startHealing + _endHealing) * _numEntities);
        return totalDamage;
    }
}

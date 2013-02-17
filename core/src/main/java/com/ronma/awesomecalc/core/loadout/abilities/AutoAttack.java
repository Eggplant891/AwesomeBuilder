package com.ronma.awesomecalc.core.loadout.abilities;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class AutoAttack extends Ability {
    protected int _damage;
    protected float _attackSpeed;
    protected float _range;
    protected int _numShots;
    
    protected Map<Integer, AAShot> _shots;
    
    protected AutoAttack() {
        _shots = new HashMap<Integer, AAShot>();
        _numShots = 0;
        _name = "Undefined";
    }
    
    public static AutoAttack Create(String name, int dmg, float attackSpd, float range, float speed) {       
        return CreateWithCrits(name, dmg, attackSpd, range, speed, 0, 0);
    }
    
    public static AutoAttack CreateWithCrits(String name, int dmg, float attackSpd, float range, float speed, float critChance, int critDmg) {
        AutoAttack a = new AutoAttack(); 
        
        a._name = name;
        a._attackSpeed = attackSpd;   
        a.AddShot(0, dmg, range, speed, critChance, critDmg, attackSpd);
        
        return a;
    }
    
    public void UpgradeDamage(int slotNumber, int dmgUp) {
        AAShot s = _shots.get(slotNumber);
        if (s != null) {
            s.UpgradeDamage(dmgUp);
        }
    }
    
    public void UpgradeAttackSpeed(int slotNumber, float attckSpdUp) {
        AAShot s = _shots.get(slotNumber);
        if (s != null) {
            s.UpgradeAttackSpeed(attckSpdUp);
        }
    }
    
    public AABullet GetShotBullet(int slotNumber) {
        AAShot shot = _shots.get(slotNumber);
        if (shot != null) {
            return shot.GetBullet(0);
        }
        
        return null;
    }
    
    public void AddShot(int slotNumber, int dmg, float range, float speed, float critChance, int critDmg, float attackSpd) {
        AABullet s = new AABullet(dmg, range, speed, critChance, critDmg);
        AAShot shot;
        int i = 0;
        while (true) { 
            shot = _shots.get(i);
            if (i == slotNumber) {
                if (shot == null) {
                    shot = new AAShot(attackSpd);
                    _shots.put(i, shot);
                }
                shot.AddBullet(s);
                break;
            }
            else if (i < slotNumber) {
                if (shot == null) {
                    AABullet as = _shots.get(0).GetBullet(i);
                    shot = new AAShot(attackSpd);
                    shot.AddBullet(as);
                    _shots.put(i, shot);
                }
            }
            i++;
        }
    }
    
    public String ShotsToString() {
        String s = "";
        int i = 1;
        int j = 1;
        s += "***"+_name + "***\n\n";
        s += "DPS: " + GetDPS() + "\n";
        for (AAShot list : _shots.values()) {
            s += "---Shot " + i + "---\n";
            s += "Attack Speed: " + list.GetAttackSpeed() + "\n";
            s += "Damage: " + list.GetShotDamage() + "\n";
            for (AABullet shot : list._bullets) {
                s += "Bullet " + j + " Dmg: " + shot.GetDamage() + "\n";
            }
            s+= "------------\n\n";
            i++;
        }
        
        return s;
    }
    int fiveMinsMS = 1000 * 60 * 10;
    int fiveMins = 60 * 10;
    public float GetDPS() {
        // Get total time for full attack sequence
        float attackTime = 0;
        int seqDamage = 0;
        float totalDamage = 0;
        float DPS = 0;
        float numAttacks = 0;
        for (AAShot l : _shots.values()) {
            attackTime += l.GetTimeToAttack();
            seqDamage += l.GetShotDamage();
        }
        
        // Calculate how many times this full sequence can be done over 5 minutes
        numAttacks = fiveMinsMS / attackTime;
        // Calculate total damage over that time
        totalDamage = seqDamage * numAttacks;
        // Calculate sampled DPS
        DPS = totalDamage / fiveMins;
        
        //System.out.println("AttackTime: " + attackTime + "ms\nseqDamage: " + seqDamage + "\nnumattacks (5 mins): " + numAttacks + "\ntotalDamage (5 mins): " + totalDamage + "\nPrelim DPS: " + DPS);
        
        return DPS;
    }
    
    private class AAShot {
        public ArrayList<AABullet> _bullets;
        private float _attackSpeed;
        private float _baseAttackSpeed;
        public AAShot(float attackSpd) {
            _bullets = new ArrayList<AABullet>();
            _attackSpeed = attackSpd;
            _baseAttackSpeed = _attackSpeed;
        }
        
        public void UpgradeDamage(int dmgUp) {
            _bullets.get(0)._damage += dmgUp;
        }
        
        public void UpgradeAttackSpeed(float upgrade) {
            _attackSpeed += (_baseAttackSpeed * upgrade) - _baseAttackSpeed;
        }
        
        public void AddBullet(AABullet a) {
            _bullets.add(a);
        }
        
        public AABullet GetBullet(int i) {
            return _bullets.get(i);
        }
        
        public float GetAttackSpeed() {
            return _attackSpeed;
        }
        // Returns in ms
        public float GetTimeToAttack() {
            return 1000 / (_attackSpeed / 60);
        }
        
        public int GetShotDamage() {
            int total = 0;
            for (AABullet a : _bullets) {
                total += a.GetDamage();
            }
            
            return total;
        }
        
        public int GetShotDamageWithCrit() {
            int total = 0;
            for (AABullet a : _bullets) {
                total += a.GetDamage() + a.GetCritDamage();
            }
            return total;
        }
    }
    
    private class AABullet {
        private int _damage;
        private float _range;
        private float _speed;
        private float _critChance;
        private int _critDamage;
        
        public AABullet (AABullet a) {
            _damage = a._damage;
            _range = a._range;
            _speed = a._speed;
            _critChance = a._critChance;
            _critDamage = a._critDamage;
        }
        
        public AABullet(int dmg, float range, float speed, float critChance, int critDmg) {
            _damage = dmg;
            _range = range;
            _speed = speed;
            _critChance = critChance;
            _critDamage = critDmg;
        }
        
        public int GetCritDamage() {
            return _critDamage;
        }
        
        public float GetCritChance() {
            return _critChance;
        }

        public int GetDamage() {
            return _damage;
        }
        
        public float GetRange() {
            return _range;
        }
        
        public float GetSpeed() {
            return _speed;
        }
    }
}

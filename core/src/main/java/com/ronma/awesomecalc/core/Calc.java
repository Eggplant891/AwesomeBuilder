package com.ronma.awesomecalc.core;

public class Calc {
	// Conversions
	public static float Convert_AttackSpdToSPS(float attackSpd) {
		return (attackSpd / 60.0f);
	}
	
	public static float Convert_SPSToAttackSpd(float shotsPS) {
		return (shotsPS * 60.0f);
	}
	
	public static float Convert_DPSToDPM(float dps) {
		return (dps * 60.0f);
	}
	
	public static float Convert_DPMToDPS(float dpm) {
		return (dpm / 60.0f);
	}
	
	// Getters/Calculations
	
	public static float Get_DamageTotalPerMinuteWithCrits(float attackSpd, int damage, float critChance, int critDamage) {
		return (Get_DamagePerMinute(attackSpd, damage)
				+ Get_CritDamagePerMinute(attackSpd, critChance, critDamage));
	}
	
	public static float Get_CritsPerMinute(float attackSpd, float critChance) {
		return (attackSpd * critChance);
	}
	
	public static float Get_CritDamagePerMinute(float attackSpd, float critChance, float critDamage) {
		return (Get_CritsPerMinute(attackSpd, critChance) * critDamage);
	}
	
	public static float Get_DamagePerSecond(float attackSpd, int damage) {
		return (Convert_AttackSpdToSPS(attackSpd) * damage);
	}
	
	public static float Get_DamagePerMinute(float attackSpd, int damage) {
		return (attackSpd * damage);
	}
	
	// Upgrade application
	public static float Get_UpgradedAttackSpeed(float baseAttackSpd, float upgradeStep, int numTiers) {
		return (baseAttackSpd * (upgradeStep * numTiers));
	}
}

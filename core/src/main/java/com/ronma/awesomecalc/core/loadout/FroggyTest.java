package com.ronma.awesomecalc.core.loadout;

import com.ronma.awesomecalc.core.Global;

public class FroggyTest {
    public NautResources res;
    private String [] _ability1 = new String[] {
            "spr_froggyG_splashDash.png",
            "spr_froggyG_splashDash_hydroSplash.png",
            "spr_froggyG_splashDash_iceCubes.png",
            "spr_froggyG_splashDash_goldenWatch.png",
            "spr_froggyG_splashDash_hammerPants.png",
            "spr_froggyG_splashDash_clockNecklace.png",
            "spr_froggyG_splashDash_hydroSmash.png"
        };;    
    private String [] _autoAttack = new String[] {
            "spr_froggyG_autoAttack.png",
            "spr_froggyG_autoAttack_swirlingOctopusCartridges.png",
            "spr_froggyG_autoAttack_piranhaCartridges.png",
            "spr_froggyG_autoAttack_mutantWorms.png",
            "spr_froggyG_autoAttack_viridianEelCartridges.png",
            "spr_froggyG_autoAttack_mutantWormsLimitedNinjaEdition.png",
            "spr_froggyG_autoAttack_thornFish.png"
        };
    
    public FroggyTest() {
        res = new NautResources();        
    }
    
    public void LoadResources() {
        for (int i = 0; i < 7; i ++) {
            res.AddAbility1Slot(Global.m_assetManager.getImage("images/" + _ability1[i]));
            res.AddAutoAttackSlot(Global.m_assetManager.getImage("images/" + _autoAttack[i]));
        }
    }
}

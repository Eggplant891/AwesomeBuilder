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
        };
    private String [] _ability2 = new String[] {
            "spr_froggyG_tornado.png",
            "spr_froggyG_tornado_boomBox.png",
            "spr_froggyG_tornado_turboTape.png",
            "spr_froggyG_tornado_cantTouchThis.png",
            "spr_froggyG_tornado_bioFuelCells.png",
            "spr_froggyG_tornado_twistedTweeters.png",
            "spr_froggyG_tornado_rightBackAtYa.png"
        }; 
    
    private String [] _autoAttack = new String[] {
            "spr_froggyG_autoAttack.png",
            "spr_froggyG_autoAttack_swirlingOctopusCartridges.png",
            "spr_froggyG_autoAttack_piranhaCartridges.png",
            "spr_froggyG_autoAttack_mutantWorms.png",
            "spr_froggyG_autoAttack_viridianEelCartridges.png",
            "spr_froggyG_autoAttack_mutantWormsLimitedNinjaEdition.png",
            "spr_froggyG_autoAttack_thornFish.png"
        };
    
    private String [] _utility = new String[] {
            "spr_froggyG_utility.png",
            "spr_froggyG_utility_powerPillsLight.png",
            "spr_froggyG_utility_medICan.png",
            "spr_froggyG_utility_spaceAirMax.png",
            "spr_froggyG_utility_solarTree.png",
            "spr_froggyG_utility_piggyBank.png",
            "spr_froggyG_utility_powerPills.png"
        }; 
    private String _fullPortrait = new String("spr_froggyG_fullPortrait.png");
    
    public FroggyTest() {
        res = new NautResources();        
    }
    
    public void LoadResources() {
        res.SetPortrait(Global.m_assetManager.getImage("images/" + _fullPortrait));
        for (int i = 0; i < 7; i ++) {
            if (i == 0) {
                res.SetAbility1Icon(Global.m_assetManager.getImage("images/" + _ability1[i]));
                res.SetAbility2Icon(Global.m_assetManager.getImage("images/" + _ability2[i]));
                res.SetAutoAttackIcon(Global.m_assetManager.getImage("images/" + _autoAttack[i]));
                res.SetUtilityIcon(Global.m_assetManager.getImage("images/" + _utility[i]));
            }
            else {
                res.AddAbility1Slot(Global.m_assetManager.getImage("images/" + _ability1[i]));
                res.AddAbility2Slot(Global.m_assetManager.getImage("images/" + _ability2[i]));                
                res.AddAutoAttackSlot(Global.m_assetManager.getImage("images/" + _autoAttack[i]));
                res.AddUtilitySlot(Global.m_assetManager.getImage("images/" + _utility[i]));
            }
        }
    }
}

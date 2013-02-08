package com.ronma.awesomecalc.core.loadout;

import com.ronma.awesomecalc.core.Global;

public class FroggyTest extends NautResDefinitions {    
    
    public FroggyTest() {
        super();
        
        _nautNameCode = "froggyG";
        
        _fullPortrait = "spr_froggyG_fullPortrait.png";
        _iconPortrait = "spr_froggyG_iconPortrait.png";
        
        _ability1Icon = "spr_froggyG_splashDash.png";
        _ability1 = new String[] {
            "spr_froggyG_splashDash_hydroSplash.png",
            "spr_froggyG_splashDash_iceCubes.png",
            "spr_froggyG_splashDash_goldenWatch.png",
            "spr_froggyG_splashDash_hammerPants.png",
            "spr_froggyG_splashDash_clockNecklace.png",
            "spr_froggyG_splashDash_hydroSmash.png"
        };
        
        _ability2Icon = "spr_froggyG_tornado.png";
        _ability2 = new String[] {
            "spr_froggyG_tornado_boomBox.png",
            "spr_froggyG_tornado_turboTape.png",
            "spr_froggyG_tornado_cantTouchThis.png",
            "spr_froggyG_tornado_bioFuelCells.png",
            "spr_froggyG_tornado_twistedTweeters.png",
            "spr_froggyG_tornado_rightBackAtYa.png"
        }; 
        
        _autoAttackIcon = "spr_froggyG_autoAttack.png";
        _autoAttack = new String[] {
            "spr_froggyG_autoAttack_swirlingOctopusCartridges.png",
            "spr_froggyG_autoAttack_piranhaCartridges.png",
            "spr_froggyG_autoAttack_mutantWorms.png",
            "spr_froggyG_autoAttack_viridianEelCartridges.png",
            "spr_froggyG_autoAttack_mutantWormsLimitedNinjaEdition.png",
            "spr_froggyG_autoAttack_thornFish.png"
        };
        
        _utilityIcon = "spr_froggyG_utility.png";
        _utility = new String[] {
            "spr_froggyG_utility_powerPillsLight.png",
            "spr_froggyG_utility_medICan.png",
            "spr_froggyG_utility_spaceAirMax.png",
            "spr_froggyG_utility_solarTree.png",
            "spr_froggyG_utility_piggyBank.png",
            "spr_froggyG_utility_powerPills.png"
        }; 
    }
}

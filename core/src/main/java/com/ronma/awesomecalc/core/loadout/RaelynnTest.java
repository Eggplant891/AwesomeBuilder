package com.ronma.awesomecalc.core.loadout;

import com.ronma.awesomecalc.core.Global;

public class RaelynnTest extends NautResDefinitions {    
    
    public RaelynnTest() {
        super();
        
        _nautNameCode = "raelynn";
        _nautFullName = "Raelynn";
        
        _fullPortrait = "spr_froggyG_fullPortrait.png";
        _iconPortrait = "spr_raelynn_iconPortrait.png";
        
        _ability1Icon = "spr_raelynn_timeRift.png";
        _ability1 = new LoadoutItemDefinition[] {
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_splashDash_hydroSplash.png", "Hydro Splash", "---Hydro Splash Desc---"),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_splashDash_iceCubes.png", "Ice Cubes", "---Ice Cubes---"),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_splashDash_goldenWatch.png", "Golden Watch", "---Golden Watch---"),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_splashDash_hammerPants.png", "Hammer Pants", "---Hammer Pants---"),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_splashDash_clockNecklace.png", "Clock Necklace", "---Clock Necklace---"),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_splashDash_hydroSmash.png", "Hydro Smash", "---Hydro Smash---")
        };
        
        _ability2Icon = "spr_raelynn_snipe.png";
        _ability2 = new LoadoutItemDefinition[] {
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_snipe_pumpRifle.png", "Boom Box", "---Boom Box---"),
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_snipe_cassetteDeckMagazine.png", "Turbo Tape", "---Turbo Tape---"),
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_snipe_laserpointer.png", "Can't Touch This", "---Can't Touch This---"),
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_snipe_flashyGlasses.png", "Bio Fuel Cells", "---Bio Fuel Cells---"),
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_snipe_grycLubricator.png", "Twisted Tweeters", "---Twisted Tweeters---"),
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_snipe_ironRifle.png", "Right Back at ya", "---Right Back At Ya---")
        }; 
        
        _autoAttackIcon = "spr_raelynn_autoAttack.png";
        _autoAttack = new LoadoutItemDefinition[] {
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_autoAttack_skullBracelet.png", "Skull Bracelet", "---Skull Bracelet---"),
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_autoAttack_unknownAlienHand.png", "Pirhana Cartridges", "---Pirhana Cartridges---"),
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_autoAttack_monkeyHand.png", "Mutant Worms", "---Mutant Worms---"),
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_autoAttack_luckyCatAirFreshener.png", "Viridian Eel Cartridges", "---Piercing Bullets---"),
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_autoAttack_joeDoll.png", "Mutant Worms: Limited Ninja Edition", "---Ninja Worms---"),
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_autoAttack_recedingPonytail.png", "Thorn Fish", "---Thorn Fish---")
        };
        
        _utilityIcon = "spr_raelynn_utility.png";
        _utility = new LoadoutItemDefinition[] {
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_utility_powerPillsLight.png", "Power Pills Light", "+30hp x 2"),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_utility_medICan.png", "Med-I Can", "+120 regen rate"),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_utility_spaceAirMax.png", "Space Air Max", "Boots lol"),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_utility_solarTree.png", "Solar Tree", "+30 solar gain per minute"),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_utility_piggyBank.png", "Piggy Bank", "+150 solar"),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_utility_powerPills.png", "Power Pills", "Free +40hp")
        }; 
    }
}
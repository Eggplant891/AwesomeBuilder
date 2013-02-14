package com.ronma.awesomecalc.core.loadout;

import com.ronma.awesomecalc.core.Global;

public class FroggyTest extends NautResDefinitions {    
    
    public FroggyTest() {
        super();
        
        _nautNameCode = "froggyG";
        _nautFullName = "Froggy G";
        _fullPortrait = "images/froggyG/spr_froggyG_fullPortrait.png";
        _iconPortrait = "images/froggyG/spr_froggyG_iconPortrait.png";
        
        _ability1Icon = "images/froggyG/spr_froggyG_splashDash.png";
        _ability1 = new LoadoutItemDefinition[] {
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_splashDash_hydroSplash.png", "Hydro Splash", "---Hydro Splash Desc---"),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_splashDash_iceCubes.png", "Ice Cubes", "---Ice Cubes---"),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_splashDash_goldenWatch.png", "Golden Watch", "---Golden Watch---"),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_splashDash_hammerPants.png", "Hammer Pants", "---Hammer Pants---"),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_splashDash_clockNecklace.png", "Clock Necklace", "---Clock Necklace---"),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_splashDash_hydroSmash.png", "Hydro Smash", "---Hydro Smash---")
        };
        
        _ability2Icon = "images/froggyG/spr_froggyG_tornado.png";
        _ability2 = new LoadoutItemDefinition[] {
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_tornado_boomBox.png", "Boom Box", "---Boom Box---"),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_tornado_turboTape.png", "Turbo Tape", "---Turbo Tape---"),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_tornado_cantTouchThis.png", "Can't Touch This", "---Can't Touch This---"),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_tornado_bioFuelCells.png", "Bio Fuel Cells", "---Bio Fuel Cells---"),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_tornado_twistedTweeters.png", "Twisted Tweeters", "---Twisted Tweeters---"),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_tornado_rightBackAtYa.png", "Right Back at ya", "---Right Back At Ya---")
        }; 
        
        _autoAttackIcon = "images/froggyG/spr_froggyG_autoAttack.png";
        _autoAttack = new LoadoutItemDefinition[] {
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_autoAttack_swirlingOctopusCartridges.png", "Swirling Octopus Cartridges", "---Swirling Octopus Cartridges"),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_autoAttack_piranhaCartridges.png", "Pirhana Cartridges", "---Pirhana Cartridges---"),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_autoAttack_mutantWorms.png", "Mutant Worms", "---Mutant Worms---"),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_autoAttack_viridianEelCartridges.png", "Viridian Eel Cartridges", "---Piercing Bullets---"),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_autoAttack_mutantWormsLimitedNinjaEdition.png", "Mutant Worms: Limited Ninja Edition", "---Ninja Worms---"),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_autoAttack_thornFish.png", "Thorn Fish", "---Thorn Fish---")
        };
        
        _utilityIcon = "images/froggyG/spr_froggyG_utility.png";
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

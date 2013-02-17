package com.ronma.awesomecalc.core.loadout;

import com.ronma.awesomecalc.core.Global;

public class FroggyTest extends NautResDefinitions {    
    
    public FroggyTest() {
        super();
        
        _nautNameCode = "froggyG";
        _nautFullName = "Froggy G";
        _fullPortrait = "images/froggyG/spr_froggyG_fullPortrait.png";
        _iconPortrait = "images/froggyG/spr_froggyG_iconPortrait.png";
        
        _ability1Icon = new LoadoutItemDefinition("images/froggyG/spr_froggyG_splashDash.png", "Splash Dash", "25 damage dash. Invulnerable during dash", 135, 1);
        _ability1 = new LoadoutItemDefinition[] {
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_splashDash_hydroSplash.png", "Hydro Splash", "---Hydro Splash Desc---", 140, 3),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_splashDash_iceCubes.png", "Ice Cubes", "---Ice Cubes---", 160, 2),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_splashDash_goldenWatch.png", "Golden Watch", "---Golden Watch---", 120, 2),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_splashDash_hammerPants.png", "Hammer Pants", "---Hammer Pants---", 220, 1),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_splashDash_clockNecklace.png", "Clock Necklace", "---Clock Necklace---", 190, 1),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_splashDash_hydroSmash.png", "Hydro Smash", "---Hydro Smash---", 315, 1)
        };
        
        _ability2Icon = new LoadoutItemDefinition("images/froggyG/spr_froggyG_tornado.png", "Tornado Move", "16 damage x 4 over 2 seconds.", 135, 1);
        _ability2 = new LoadoutItemDefinition[] {
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_tornado_boomBox.png", "Boom Box", "---Boom Box---", 220, 2),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_tornado_turboTape.png", "Turbo Tape", "---Turbo Tape---", 140, 2),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_tornado_cantTouchThis.png", "Can't Touch This", "---Can't Touch This---", 220, 1),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_tornado_bioFuelCells.png", "Bio Fuel Cells", "---Bio Fuel Cells---", 150, 2),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_tornado_twistedTweeters.png", "Twisted Tweeters", "---Twisted Tweeters---", 150, 2),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_tornado_rightBackAtYa.png", "Right Back at ya", "---Right Back At Ya---", 290, 1)
        }; 
        
        _autoAttackIcon = "images/froggyG/spr_froggyG_autoAttack.png";
        _autoAttack = new LoadoutItemDefinition[] {
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_autoAttack_swirlingOctopusCartridges.png", "Swirling Octopus Cartridges", "---Swirling Octopus Cartridges", 145, 1),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_autoAttack_piranhaCartridges.png", "Pirhana Cartridges", "---Pirhana Cartridges---", 200, 2),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_autoAttack_mutantWorms.png", "Mutant Worms", "---Mutant Worms---", 110, 3),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_autoAttack_viridianEelCartridges.png", "Viridian Eel Cartridges", "---Piercing Bullets---", 225, 1),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_autoAttack_mutantWormsLimitedNinjaEdition.png", "Mutant Worms: Limited Ninja Edition", "---Ninja Worms---", 110, 1),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_autoAttack_thornFish.png", "Thorn Fish", "---Thorn Fish---", 340, 1)
        };
        
        _utilityIcon = "images/froggyG/spr_froggyG_utility.png";
        _utility = new LoadoutItemDefinition[] {
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_utility_powerPillsLight.png", "Power Pills Light", "+30hp x 2", 125, 2),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_utility_medICan.png", "Med-I Can", "+120 regen rate", 120, 2),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_utility_spaceAirMax.png", "Space Air Max", "Boots lol", 135, 1),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_utility_solarTree.png", "Solar Tree", "+30 solar gain per minute", 100, 1),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_utility_piggyBank.png", "Piggy Bank", "+150 solar", 0, 1),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_utility_powerPills.png", "Power Pills", "Free +40hp", 0, 1)
        }; 
    }
}

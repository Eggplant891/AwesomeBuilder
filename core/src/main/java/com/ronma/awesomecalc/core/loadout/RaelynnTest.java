package com.ronma.awesomecalc.core.loadout;

import com.ronma.awesomecalc.core.Global;

public class RaelynnTest extends NautResDefinitions {    
    
    public RaelynnTest() {
        super();
        
        _nautNameCode = "raelynn";
        _nautFullName = "Raelynn";
        
        _fullPortrait = "images/raelynn/spr_raelynn_fullPortrait.png";
        _iconPortrait = "images/raelynn/spr_raelynn_iconPortrait.png";
        
        _ability1Icon = "images/raelynn/spr_raelynn_timeRift.png";
        _ability1 = new LoadoutItemDefinition[] {
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_timeRift_higgsGrenade.png", "Higgs Grenade", "---Higgs Desc---", 2),
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_timeRift_nuclearWarhead.png", "Nuclear Warhead", "---Nuke---", 3),
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_timeRift_retroSpaceship.png", "Retro Spaceship", "---Slow thing---", 2),
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_timeRift_t800Dome.png", "T-800 Dome", "---Dome~---", 2),
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_timeRift_hcBomb.png", "HC-Bomb", "---pew pew---", 1),
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_timeRift_121GigawattBattery.png", "1.21 Gigawatt Battery", "---batteries---", 1)
        };
        
        _ability2Icon = "images/raelynn/spr_raelynn_snipe.png";
        _ability2 = new LoadoutItemDefinition[] {
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_snipe_pumpRifle.png", "Pump Rifle", "---+10 dmg---", 3),
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_snipe_cassetteDeckMagazine.png", "Cassette Deck Magazine", "---Cooldown reduction---", 2),
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_snipe_laserpointer.png", "Laser Pointer", "Blind effect", 1),
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_snipe_flashyGlasses.png", "Flashy Glasses", "Solar gain per hit", 1),
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_snipe_grycLubricator.png", "Gryc Lubricator", "+Range", 2),
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_snipe_ironRifle.png", "Iron Rifle", "+15 dmg", 1)
        }; 
        
        _autoAttackIcon = "images/raelynn/spr_raelynn_autoAttack.png";
        _autoAttack = new LoadoutItemDefinition[] {
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_autoAttack_skullBracelet.png", "Skull Bracelet", "---Skull Bracelet---", 3),
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_autoAttack_unknownAlienHand.png", "Unknown Alient Hand", "---Pirhana Cartridges---", 1),
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_autoAttack_monkeyHand.png", "Monkey Hand", "---Mutant Worms---", 1),
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_autoAttack_luckyCatAirFreshener.png", "Lucky Cat Air Freshener", "---Piercing Bullets---", 2),
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_autoAttack_joeDoll.png", "Joe Doll", "---Ninja Worms---", 2),
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_autoAttack_recedingPonytail.png", "Receding Ponytail", "---Thorn Fish---", 1)
        };
        
        _utilityIcon = "images/raelynn/spr_raelynn_utility.png";
        _utility = new LoadoutItemDefinition[] {
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_utility_powerPillsTurbo.png", "Power Pills Turbo", "+30hp x 3", 3),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_utility_medICan.png", "Med-I Can", "+120 regen rate", 2),
            new LoadoutItemDefinition("images/raelynn/spr_raelynn_utility_dennysBoots.png", "Denny's Boots", "Boots lol", 1),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_utility_solarTree.png", "Solar Tree", "+30 solar gain per minute", 1),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_utility_piggyBank.png", "Piggy Bank", "+150 solar", 1),
            new LoadoutItemDefinition("images/froggyG/spr_froggyG_utility_powerPills.png", "Power Pills", "Free +40hp", 1)
        }; 
    }
}

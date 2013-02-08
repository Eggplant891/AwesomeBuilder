package com.ronma.awesomecalc.core.loadout;

import playn.core.Image;
import com.ronma.awesomecalc.core.loadout.NautResources;
import playn.core.Surface;

public class LoadoutRow {
    private LoadoutToggleButton [] btns;
    private Image rowIcon;
    private int itemsSelected;
    private LoadoutRowType _type;
    
    public static Image rowBG;
    
    private final int xOffset = 16;
    private final int yOffset = 90 + 16;
    private final int xSpacing = 4;
    private final int ySpacing = 16;
    
    private final int iconPadding = 8;
    
    public LoadoutRow(LoadoutRowType type, NautResources res) {
        itemsSelected = 0;
        btns = new LoadoutToggleButton[NautResources.NumSlotsPerAbility];
        rowIcon = res.GetAbilityIcon(type);
        _type = type;
        for (int i = 0; i < NautResources.NumSlotsPerAbility; i++) {
            btns[i] = new LoadoutToggleButton(res.GetSlot(type, i),
                    xOffset + iconPadding + 64 + (i * (64 + xSpacing)),
                    yOffset + (type.ordinal() * (64 + ySpacing)), false) {
                @Override
                public void Clicked() {
                    if (itemsSelected < 3 && IsSwitchedOff()) {
                        Toggle();
                        itemsSelected++;
                    }
                    else if (IsSwitchedOn()) {
                        Toggle();
                        if (itemsSelected > 0) itemsSelected--;
                    }
                }
            };
        }
    }
    
    public void Update(float delta) {
        for (int i = 0; i < NautResources.NumSlotsPerAbility; i++) {
            btns[i].Update(delta);
        }
    }
    
    public void Paint(Surface g) {
        g.drawImage(rowBG, xOffset - 4, yOffset + (_type.ordinal() * (64 + ySpacing)) - 3);
        g.drawImage(rowIcon, xOffset, yOffset + (_type.ordinal() * (64 + ySpacing)));
        for (int i = 0; i < NautResources.NumSlotsPerAbility; i++) {
            btns[i].Paint(g);
        }
    }
}

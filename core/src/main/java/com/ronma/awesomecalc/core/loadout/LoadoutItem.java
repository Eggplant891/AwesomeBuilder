package com.ronma.awesomecalc.core.loadout;
import com.ronma.awesomecalc.core.*;
import playn.core.Image;
import playn.core.Surface;

public class LoadoutItem extends LoadoutToggleButton {
    Image _itemIcon;
    String _itemName;
    String _itemDescription;
    
    public LoadoutItem(int id, LoadoutItemDefinition l, int x, int y) {
        super(l.GetImage(), id, x, y, false);
        _itemName = l.GetItemName();
        _itemDescription = l.GetItemDescription();
    }
    
    @Override
    public void Update(float delta) {
        super.Update(delta);
    }
    
    @Override
    public void Paint(Surface g) {
        super.Paint(g);
    }
    
}
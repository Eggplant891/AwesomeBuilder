package com.ronma.awesomecalc.core.loadout;
import com.ronma.awesomecalc.core.*;
import playn.core.Image;
import playn.core.Surface;

public class LoadoutItem extends LoadoutToggleButton {
    Image _itemIcon;
    String _itemName;
    String _itemDescription;
    LoadoutItemDefinition _def;
    public LoadoutItem(int id, LoadoutItemDefinition l, int x, int y) {
        super(l.GetImage(), id, x, y, false);
        _def = l;
        _itemName = _def.GetItemName();
        _itemDescription = _def.GetItemDescription();
    }
    
    public LoadoutItemDefinition GetItemDefinition() {
        return _def;
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
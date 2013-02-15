package com.ronma.awesomecalc.core.loadout;
import com.ronma.awesomecalc.core.*;
import playn.core.Image;
import playn.core.Surface;

public class LoadoutItem extends LoadoutToggleButton {
    Image _itemIcon;
    String _itemName;
    String _itemDescription;
    LoadoutItemDefinition _def;
    Rectangle _partialRect;
    int _numStages;
    int _stagesSelected;
    
    public LoadoutItem(int id, LoadoutItemDefinition l, int x, int y) {
        super(l.GetImage(), id, x, y, false);
        _def = l;
        _itemName = _def.GetItemName();
        _itemDescription = _def.GetItemDescription();
        _numStages = _def.GetTotalStages();
        _stagesSelected = 0;
        _partialRect = new Rectangle(0,0,_sprite.GetFrameWidth(),0);
    }
    
    public LoadoutItemDefinition GetItemDefinition() {
        return _def;
    }
    
    public void UpdatePartialRect() {
        int rectHeight = (int)((_sprite.GetFrameHeight() / _numStages) * _stagesSelected);
        _partialRect.SetSize(_partialRect.GetWidth(), rectHeight);
        _partialRect.SetPosition(0, _sprite.GetFrameHeight() - rectHeight);
    }
    
    @Override
    public void Toggle() {
        if (_stagesSelected == 0) {
            _state = true;
            _stagesSelected++;
        }
        else {
            if (_stagesSelected >= _numStages) {
                _stagesSelected = 0;
                _state = false;
            }
            else _stagesSelected++;
        }
        UpdatePartialRect();
    }
    
    @Override
    public void Update(float delta) {
        super.Update(delta);
    }
    
    @Override
    public void Paint(Surface g) {
        //super.Paint(g);
        _sprite.SetCurrentFrame(1);
        _sprite.Draw(g, _x, _y, 1.0f, 1.0f);
        _sprite.SetCurrentFrame(0);
        _sprite.DrawPartial(g, _partialRect, _x, _y, 1.0f, 1.0f);
        
    }
    
}
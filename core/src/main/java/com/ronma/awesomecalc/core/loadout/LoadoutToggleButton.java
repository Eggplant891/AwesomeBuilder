package com.ronma.awesomecalc.core.loadout;
import com.ronma.awesomecalc.core.GameObject;
import com.ronma.awesomecalc.core.Sprite;
import playn.core.Image;
import playn.core.Surface;
public class LoadoutToggleButton extends GameObject {
    private boolean _state = false;
    private int _id;
    
    public LoadoutToggleButton(Image img, int id, int x, int y, boolean startsOn) {
        super(Sprite.CreateAnimatedSprite(img, 2, 1, 0, 2, 0), x, y);
        _state = startsOn;
    }
    
    public int GetSlotID() {
        return _id;
    }
    
    public void Toggle() {
        _state = !_state;
    }
    
    public boolean IsSwitchedOff() {
        return !_state;
    }
    
    public boolean IsSwitchedOn() {
        return _state;
    }
    
    public void Clicked() {
        Toggle();
    }
    
    @Override
    public void Update(float delta) {
        super.Update(delta);
        
        if (_mouse.IsInBounds(_collisionBox)) {
            if (_mouse.IsLeftButtonPressed()) {
                Clicked();
            }
        }
        
        if (_state) _sprite.SetCurrentFrame(0);
        else _sprite.SetCurrentFrame(1);
    }
    
    @Override
    public void Paint(Surface s) {
        super.Paint(s);
    }
}

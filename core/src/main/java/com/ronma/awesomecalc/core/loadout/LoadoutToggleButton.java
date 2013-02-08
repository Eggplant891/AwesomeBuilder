package com.ronma.awesomecalc.core;
import playn.core.Image;
import playn.core.Surface;
public class LoadoutToggleButton extends GameObject {
    private boolean _state = false;
    
    public LoadoutToggleButton(Image img, int x, int y, boolean startsOn) {
        super(Sprite.CreateAnimatedSprite(img, 2, 1, 0, 2, 0), x, y);
        _state = startsOn;
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
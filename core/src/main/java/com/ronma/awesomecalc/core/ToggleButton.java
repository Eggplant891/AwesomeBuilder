package com.ronma.awesomecalc.core;
import playn.core.Image;
import playn.core.Surface;
public class ToggleButton extends GameObject {
    private boolean _state = false;
    
    public ToggleButton(Image img, int x, int y, boolean startsOn) {
        super(Sprite.CreateAnimatedSprite(img, 5, 1, 0, 5, 0), x, y);
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
            if (_mouse.IsLeftButtonReleased()) {
                Clicked();
            }
            
            if (_mouse.IsLeftButtonHeld()) {
                _sprite.SetCurrentFrame(2);
            }
            else {
                if (_state) _sprite.SetCurrentFrame(4);
                else _sprite.SetCurrentFrame(1);
            }
        }
        else {
            if (_state) _sprite.SetCurrentFrame(3);
            else _sprite.SetCurrentFrame(0);
        }
    }
    
    @Override
    public void Paint(Surface s) {
        super.Paint(s);
    }
}

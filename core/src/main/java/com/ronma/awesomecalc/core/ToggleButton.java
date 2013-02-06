package com.ronma.awesomecalc.core;

import com.ronma.awesomecalc.core.input.MouseInput;
import com.ronma.awesomecalc.core.input.MouseState;
import com.sun.org.omg.SendingContext._CodeBaseImplBase;
import playn.core.Image;
import playn.core.Surface;
public class ToggleButton extends GameObject {
    private MouseState _mouse;
    private MouseInput mInput = MouseInput.GetInstance();
    private boolean _state = false;
    
    public ToggleButton(Image img, int x, int y, boolean startsOn) {
        super(Sprite.CreateAnimatedSprite(img, 5, 1, 0, 5, 0), x, y);
        _state = startsOn;
    }
    
    public void Toggle() {
        _state = !_state;
    }
    
    public boolean IsSwitchedOn() {
        return _state;
    }
    
    @Override
    public void Update(float delta) {
        super.Update(delta);
        _mouse = mInput.CurrentInput();
        
        if (_collisionBox.IntersectsWithPoint(_mouse.GetX(), _mouse.GetY())) {
            if (_mouse.IsLeftButtonReleased()) {
                Toggle();
            }
            else if (_mouse.IsLeftButtonHeld()) {
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

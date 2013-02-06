package com.ronma.awesomecalc.core;

import com.ronma.awesomecalc.core.input.MouseInput;
import com.ronma.awesomecalc.core.input.MouseState;
import com.sun.org.omg.SendingContext._CodeBaseImplBase;
import playn.core.Image;
import playn.core.Surface;
public class Button extends GameObject {
    
    public Button(Image img, int x, int y) {
        super(Sprite.CreateAnimatedSprite(img, 3, 1, 0, 3, 0), x, y);
    }
    
    public void Clicked() {
        
    }
    
    @Override
    public void Update(float delta) {
        super.Update(delta);
        
        if (_mouse.IsInBounds(_collisionBox)) {
            if (_mouse.IsLeftButtonReleased())
                Clicked();
            
            if (_mouse.IsLeftButtonHeld())
                _sprite.SetCurrentFrame(2);
            else
                _sprite.SetCurrentFrame(1);
        }
        else _sprite.SetCurrentFrame(0);
    }
    
    @Override
    public void Paint(Surface s) {
        super.Paint(s);
    }
}

package com.ronma.awesomecalc.core;

import com.ronma.awesomecalc.core.input.MouseInput;
import com.ronma.awesomecalc.core.input.MouseState;
import playn.core.Surface;
import playn.core.Image;

public class GameObject {
    protected int _x, _y;
    protected Sprite _sprite;
    protected Rectangle _collisionBox, _spriteBox;
    protected MouseState _mouse;
    protected MouseInput mInput = MouseInput.GetInstance();
    
    protected GameObject(Sprite spr, int x, int y) {
        _sprite = spr;
        _x = x;
        _y = y;
        _spriteBox = _sprite.GetCollisionRectangle();
        _collisionBox = new Rectangle(0, 0,_spriteBox.GetWidth(), _spriteBox.GetHeight());
        _collisionBox.SetPosition(_x + _spriteBox.GetX(), _y + _spriteBox.GetY());
    }
    
    public void Update(float delta) {
        _mouse = mInput.CurrentInput();        
        if (_mouse.IsInBounds(_collisionBox)) {
            MouseHover();
            if (_mouse.IsLeftButtonPressed()) MousePressed();
            if (_mouse.IsLeftButtonHeld()) MouseHeld();
            if (_mouse.IsLeftButtonReleased()) MouseReleased();
        }
        
        _sprite.Step();
    }
    
    protected void MouseHover() {
        
    }
    protected void MousePressed() {
        
    }
    protected void MouseHeld() {
        
    }
    protected void MouseReleased() {
        
    }
    
    public void Paint(Surface g) {
        //g.drawImage(AwesomeCalc.bgImage, _collisionBox.GetX(), _collisionBox.GetY(), _collisionBox.GetWidth(), _collisionBox.GetHeight());
        _sprite.Draw(g, _x, _y, 1.0f, 1.0f);
    }
    
    public void SetPosition(int x, int y) {
        _x = x;
        _y = y;
        _collisionBox.SetPosition(_x + _spriteBox.GetX(), _y + _spriteBox.GetY());
    }
    
    public int GetX() {
        return _x;
    }
    
    public int GetY() {
        return _y;
    }
}

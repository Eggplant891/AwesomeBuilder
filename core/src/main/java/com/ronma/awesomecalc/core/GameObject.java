package com.ronma.awesomecalc.core;

import playn.core.Surface;

public class GameObject {
    private int _x, _y;
    private Sprite _sprite;
    
    public GameObject(int x, int y) {
        
    }
    
    public void Update(float delta) {
        
    }
    
    public void Paint(Surface g) {
        g.drawImage(_sprite.spriteImage, _x, _y);
    }
    
    public void SetPosition(int x, int y) {
        
    }
}

package com.ronma.awesomecalc.core;

import playn.core.Surface;
import playn.core.Image;

public class GameObject {
    private int _x, _y;
    private Sprite _sprite;
    private Rectangle _collisionBox, _spriteDst;
    
    public GameObject(Sprite spr, int x, int y) {
        _sprite = spr;
        _x = x;
        _y = y;
    }
    
    public void Update(float delta) {
        _sprite.Step();
    }
    
    public void Paint(Surface g) {
        _sprite.Draw(g, _x, _y, 1.0f, 1.0f);
    }
    
    public void SetPosition(int x, int y) {
        _x = x;
        _y = y;
    }
}

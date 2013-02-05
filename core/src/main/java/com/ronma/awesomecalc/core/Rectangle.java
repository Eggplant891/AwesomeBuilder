package com.ronma.awesomecalc.core;

public class Rectangle {
    private int _left, _top, _right, _bottom;
    
    public Rectangle(int left, int top, int right, int bottom) {
        _left = left;
        _top = top;
        _right = right;
        _bottom = bottom;
    }
    
    public Rectangle(Rectangle r) {
        _left = r._left;
        _top = r._top;
        _right = r._right;
        _bottom = r._bottom;
    }
    
    public void SetPosition(int x, int y) {
        _right = x + (_right - _left);
        _bottom = y + (_bottom - _top);
        _left = x;
        _top = y;
    }
    
    public void SetSize(int width, int height) {
        _right = _left + width;
        _bottom = _top + height;
    }
    
    public int GetX() { return _left; }
    public int GetY() { return _top; }
    public int GetRight() { return _right; }
    public int GetBottom() { return _bottom; }
    public int GetWidth() { return _right - _left; }
    public int GetHeight() { return _bottom - _top; }
    
    public boolean IntersectsWith(Rectangle r) {
        return Func.CollisionRectangle(this, r);
    }
}

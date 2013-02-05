package com.ronma.awesomecalc.core.input;

import playn.core.Events;
import playn.core.Mouse;

public class MouseInput implements Mouse.Listener {
	// Singleton Stuff
	private static MouseInput me = null;
	public static MouseInput GetInstance() {
		if (me == null) me = new MouseInput();
		return me;
	}
	
	public final int MOUSE_LEFT = 0;
	public final int MOUSE_RIGHT = 1;
	public final int MOUSE_MIDDLE = 2;
	
	private int _mouseX, _mouseY;
	private InputButton[] buttons;
	
	private MouseInput() {
		buttons = new InputButton[3];
		buttons[MOUSE_LEFT] = new InputButton();
		buttons[MOUSE_RIGHT] = new InputButton();
		buttons[MOUSE_MIDDLE] = new InputButton();
	}
	
	private void UpdateMouseCoords(Events.Position e) {
		_mouseX = (int)e.x();
		_mouseY = (int)e.y();
	}
	
	public synchronized int GetX() { return _mouseX; }
	public synchronized int GetY() { return _mouseY; }
	
	public synchronized MouseState PollInput() {
		return new MouseState(
				buttons[MOUSE_LEFT].PollInput(),
				buttons[MOUSE_MIDDLE].PollInput(),
				buttons[MOUSE_RIGHT].PollInput(),
				GetX(),
				GetY()
				);
	}
	@Override
	public void onMouseDown(Mouse.ButtonEvent e) {
		if (e.button() == Mouse.BUTTON_LEFT) {
			buttons[MOUSE_LEFT].ButtonPress();
		}
                
                if (e.button() == Mouse.BUTTON_RIGHT) {
                    buttons[MOUSE_RIGHT].ButtonPress();
                }
		UpdateMouseCoords(e);
	}
        @Override
	public void onMouseUp(Mouse.ButtonEvent e) {
		if (e.button() == Mouse.BUTTON_LEFT) {
			buttons[MOUSE_LEFT].ButtonRelease();
		}
                
                if (e.button() == Mouse.BUTTON_RIGHT) {
                    buttons[MOUSE_RIGHT].ButtonRelease();
                }
		UpdateMouseCoords(e);
	}
        
	@Override
	public void onMouseMove(Mouse.MotionEvent e) {
		UpdateMouseCoords(e);
	}
        
        @Override
        public void onMouseWheelScroll(Mouse.WheelEvent e) { }
}
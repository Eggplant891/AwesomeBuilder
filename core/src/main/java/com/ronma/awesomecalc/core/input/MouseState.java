package com.ronma.awesomecalc.core.input;

public class MouseState {
	private InputState _leftButton = InputState.BUTTON_INACTIVE;
	private InputState _rightButton = InputState.BUTTON_INACTIVE;
	private InputState _middleButton = InputState.BUTTON_INACTIVE;
	
	private int _x, _y;
	
	public MouseState(InputState l, InputState m, InputState r, int x, int y) {
		_leftButton = l;
		_middleButton = m;
		_rightButton = r;
		_x = x;
		_y = y;
	};
	
	public int GetX() { return _x; }
	public int GetY() { return _y; }
	
	// LEFT
	public boolean IsLeftButtonPressed() {
		return (_leftButton == InputState.BUTTON_PRESSED);
	}
	
	public boolean IsLeftButtonHeld() {
		return (_leftButton == InputState.BUTTON_HELD || _leftButton == InputState.BUTTON_PRESSED);
	}
	
	public boolean IsLeftButtonReleased() {
		return (_leftButton == InputState.BUTTON_RELEASED);
	}
	
	// RIGHT
	public boolean IsRightButtonPressed() {
		return (_rightButton == InputState.BUTTON_PRESSED);
	}
	
	public boolean IsRightButtonHeld() {
		return (_rightButton == InputState.BUTTON_HELD || _rightButton == InputState.BUTTON_PRESSED);
	}
	
	public boolean IsRightButtonReleased() {
		return (_rightButton == InputState.BUTTON_RELEASED);
	}
	
	// MIDDLE
	public boolean IsMiddleButtonPressed() {
		return (_middleButton == InputState.BUTTON_PRESSED);
	}
	
	public boolean IsMiddleButtonHeld() {
		return (_middleButton == InputState.BUTTON_HELD || _rightButton == InputState.BUTTON_PRESSED);
	}
	
	public boolean IsMiddleButtonReleased() {
		return (_middleButton == InputState.BUTTON_RELEASED);
	}
	
}
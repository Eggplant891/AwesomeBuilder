package com.ronma.awesomecalc.core.input;

public class InputButton {
	private InputState _buttonState;
	private InputState _previousState;
	private boolean _unchangedState;
	public InputButton() {
		_buttonState = InputState.BUTTON_INACTIVE;
		_previousState = _buttonState;
		_unchangedState = true;
	}
	
	public void ButtonPress() {
		_buttonState = InputState.BUTTON_PRESSED;
	}
	
	public void ButtonRelease() {
		_buttonState = InputState.BUTTON_RELEASED;
	}
	
	public InputState PollInput() {
		InputState returnable = _buttonState;
		_unchangedState = (_buttonState == _previousState);
		
		if (_buttonState == InputState.BUTTON_PRESSED) {
			if (_unchangedState) returnable = InputState.BUTTON_HELD;
		}
		
		if (_buttonState == InputState.BUTTON_RELEASED) {
			if (_unchangedState) returnable = InputState.BUTTON_INACTIVE;
		}
		_previousState = _buttonState;
		_buttonState = returnable;
		return _buttonState;
	}
}

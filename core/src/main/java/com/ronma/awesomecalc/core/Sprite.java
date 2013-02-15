package com.ronma.awesomecalc.core;

import playn.core.ImageLayer;
import playn.core.Image;
import playn.core.Surface;
/**
 *
 * @author Jason
 */
public class Sprite {
	private Image _spriteSource; // Bitmap used for sprite. This may be a single frame or strip.
	private float _currentFrame = 0f; // 0-based index for the current frame.
	private int _startFrame = 0; // Start frames, used with _numFrames to specify a specific range of images on a sprite sheet.
	private int _numFrames = 1; // Total number of frames
	private float _frameRate = 0f; // In frames per second. This may be more than 60 and less than 1.
	private float _frameDelta = 0f; // Delta value used for applying specified frame rate.
	
	
	private int _frameWidth, _frameHeight;
	
	private int _numColumns = 1; // Total number of columns
	private int _numRows = 1;	 // and rows in sprite sheet.
	
	private int _originX, _originY;
	
	private Rectangle _currentFrameRect; // Rectangle used for animation frame tracking.
	private Rectangle _canvasRect; // Rectangle used for drawing sprite onto canvas.
	
	private boolean _isAnimated = true; // Bool used to determine if the sprite is animated. Used to avoid redundant processing of animation-related code. 
	
	private Sprite(Image sourceImg) {
		_spriteSource = sourceImg;
		_frameWidth = _spriteSource.width();
		_frameHeight = _spriteSource.height();
		
		_currentFrameRect = new Rectangle(0,0,_frameWidth, _frameHeight);
		_canvasRect = new Rectangle(_currentFrameRect);
	}
	
	// Methods for creating sprites ///////////////////
	// Creates a simple sprite that uses a full bitmap
	public static Sprite CreateStaticSprite(Image sourceImg) {
		return new Sprite(sourceImg);
	}
	
	// Creates a sprite that uses a single frame of a bitmap
	public static Sprite CreateStaticSpritePartial(Image sourceImg, int numColumns, int numRows,  int targetFrame) {
		Sprite newSprite = new Sprite(sourceImg);
		newSprite.SetCurrentFrameRectPos(targetFrame);
		return newSprite;
	}
	// Creates an animated sprite that animates from startFrame for numFrames at frameRate in a grid of numColumns and numRows.
	public static Sprite CreateAnimatedSprite(Image sourceImg, int numColumns, int numRows, int startFrame, int numFrames, float frameRate) {
		Sprite newSprite = new Sprite(sourceImg);
		newSprite._startFrame = startFrame;
		newSprite._currentFrame = (float)startFrame;
		newSprite.SetFrameRate(frameRate);
		newSprite._numColumns = numColumns;
		newSprite._numRows = numRows;
		newSprite._numFrames = numFrames;
		newSprite._isAnimated = true;
		newSprite.SetFrameSize();
		newSprite.SetCurrentFrameRectPos(startFrame);
		
		return newSprite;
	}
	
	public void SetOrigin(int x, int y) {
		_originX = x;
		_originY = y;
	}
	public int GetXOrigin() { return _originX; }
	public int GetYOrigin() { return _originY; }
        
        public Rectangle GetCollisionRectangle() {
            return new Rectangle(-_originX, -_originY, _frameWidth -_originX, _frameHeight -_originY);
        }
	
	public void SetOriginToCentre() {
                SetOrigin((int)(_frameWidth/2.0), (int)(_frameHeight/2.0));
	}
	
	//Calculates the frame delta to meet the frame rate specified
	public static float CalculateFrameDelta(float frameRate) {
		return (float)(frameRate / (1000 / AwesomeCalc.UpdateRate));
	}
	
	private void SetFrameSize() {
		_frameWidth = (int)(_spriteSource.width() / _numColumns);
		_frameHeight = (int)(_spriteSource.height() / _numRows);
	}
	
	// Sets the new position of the internal rectangle to display a new frame
	private void SetCurrentFrameRectPos(int frameNumber) {
		_currentFrameRect.SetPosition((frameNumber % _numColumns) * _frameWidth,
                                            ((int)(frameNumber / _numColumns) % _numRows) * _frameHeight);
		_currentFrameRect.SetSize(_frameWidth, _frameHeight);
	}
	
	public void Step() {
		if (_isAnimated) {
			//Log.i("Step", "Stepping on frame: " + _currentFrame + " at " + _frameDelta + " with " + _numFrames + " frames.");
			_currentFrame = (_currentFrame + _frameDelta) % _numFrames;
			SetCurrentFrameRectPos((int)_currentFrame);
		}
	}
	
	public int GetFrameWidth() { return _frameWidth; }
	public int GetFrameHeight() { return _frameHeight; }
	public Image GetSpriteImage() { return _spriteSource; }
	
	// Methods to pause/resume the sprite animation.
	public void ResetAnimation() { _currentFrame = _startFrame; }
	public void PauseAnimation() { _isAnimated = false; }
	public void ResumeAnimation() { _isAnimated = true; }
	// Sets the frame rate of the animation by calculating the new frame rate delta.
	public void SetFrameRate(float frameRate) {
		_frameRate = frameRate;
		_frameDelta = CalculateFrameDelta(frameRate);
	}
        
        public void SetCurrentFrame(int frame) {
            _currentFrame = frame;
            _frameDelta = 0;
            SetCurrentFrameRectPos(frame);
        }

	public void Draw(Surface s, int x, int y, float xScale, float yScale) {
		// Update drawing rectangle to fit new position and scale parameters.
		_canvasRect.SetPosition(x - (int)(_originX * xScale),
                                        y - (int)(_originY * yScale));
		_canvasRect.SetSize((int)(_frameWidth * xScale),
                                            (int)(_frameHeight * yScale));
		Func.DrawImageRect(s, _spriteSource, _currentFrameRect, _canvasRect);
	}
        
        public void DrawPartial(Surface s, Rectangle framePortion, int x, int y, float xScale, float yScale) {
		_canvasRect.SetPosition((x + framePortion.GetX()) - (int)(_originX * xScale),
                                        (y + framePortion.GetY()) - (int)(_originY * yScale));
		_canvasRect.SetSize((int)(framePortion.GetWidth() * xScale),
                                            (int)(framePortion.GetHeight() * yScale));
                framePortion.SetPosition(framePortion.GetX() + _currentFrameRect.GetX(), framePortion.GetY() + _currentFrameRect.GetY());
		Func.DrawImageRect(s, _spriteSource, framePortion, _canvasRect);
	}
}

package com.ronma.awesomecalc.core;

import com.ronma.awesomecalc.core.input.MouseInput;
import com.ronma.awesomecalc.core.input.MouseState;
import playn.core.Game;
import playn.core.Image;
import static playn.core.PlayN.*;
import playn.core.Surface;
import playn.core.SurfaceLayer;
public class AwesomeCalc implements Game {
  Image bgImage;
  SurfaceLayer bgLayer;
  Surface bgSurface;
  
  @Override
  public void init() {
    bgImage = assetManager().getImage("images/bg.png");
    bgLayer = graphics().createSurfaceLayer(640,480);
    bgSurface = bgLayer.surface();
    graphics().rootLayer().add(bgLayer);
    mouse().setListener(MouseInput.GetInstance());
    
    x = 0;
  }

  @Override
  public void paint(float alpha) {
      bgSurface.clear();
      bgSurface.fillRect(0, 0, bgLayer.width(), bgLayer.height());
      bgSurface.drawImage(bgImage, x, y);
  }
  int x, y;
  @Override
  public void update(float delta) {
      MouseState m = MouseInput.GetInstance().PollInput();
      if (m.IsLeftButtonPressed()) x += 10;
      if (m.IsLeftButtonReleased()) y += 10;
      if (m.IsRightButtonHeld()) {
        x = m.GetX();
        y = m.GetY();
      }
  }

  @Override
  public int updateRate() {
    return 16;
  }
}

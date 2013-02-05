package com.ronma.awesomecalc.core;

import static playn.core.PlayN.*;

import playn.core.Game;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.CanvasImage;
import playn.core.SurfaceLayer;
import playn.core.Surface;

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
    x = 0;
  }

  @Override
  public void paint(float alpha) {
      bgSurface.fillRect(0, 0, bgLayer.width(), bgLayer.height());
      bgSurface.drawImage(bgImage, x, x);
  }
  int x;
  @Override
  public void update(float delta) {
      x++;
  }

  @Override
  public int updateRate() {
    return 25;
  }
}

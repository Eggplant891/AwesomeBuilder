package com.ronma.awesomecalc.core;

import com.ronma.awesomecalc.core.input.MouseInput;
import com.ronma.awesomecalc.core.input.MouseState;
import playn.core.Game;
import playn.core.Image;
import static playn.core.PlayN.*;
import playn.core.Surface;
import playn.core.SurfaceLayer;
import playn.core.AssetWatcher;

public class AwesomeCalc implements Game {
  public static Image bgImage, rocket, button;
  SurfaceLayer bgLayer;
  Surface bgSurface;
  public static int UpdateRate = 16;
  AssetWatcher watcher;
  GameObject test;
  ToggleButton testBtn;
  public boolean watcherFinished;
  
  @Override
  public void init() {
    bgImage = assetManager().getImage("images/bg.png");
    bgLayer = graphics().createSurfaceLayer(640,480);
    bgSurface = bgLayer.surface();
    graphics().rootLayer().add(bgLayer);
    mouse().setListener(MouseInput.GetInstance());
    rocket = assetManager().getImage("images/spr_normal_rocket.png");
    button = assetManager().getImage("images/buttonTest.png");
    watcherFinished = false;
    watcher = new AssetWatcher(new AssetWatcher.Listener() {

            @Override
            public void done() {
                InitApp();
                watcherFinished = true;
            }

            @Override
            public void error(Throwable e) {
                System.out.println("Failed to load all assets. ;(");
            }
        });
    
    watcher.add(bgImage);
    watcher.add(rocket);
    watcher.add(button);
    watcher.start();
  }
  
  public void InitApp() {
    test = new GameObject(Sprite.CreateAnimatedSprite(rocket, 4, 1, 0, 4, 10), 32, 32);
    testBtn = new ToggleButton(button, 50, 50, false);
    x = 0;
  }

  @Override
  public void paint(float alpha) {
      if (!watcherFinished) return;
      bgSurface.clear();
      bgSurface.fillRect(0, 0, bgLayer.width(), bgLayer.height());
      bgSurface.drawImage(bgImage, 0, 0);
      test.Paint(bgSurface);
      testBtn.Paint(bgSurface);
  }
  int x, y;
  @Override
  public void update(float delta) {
      if (!watcherFinished) return;
      MouseState m = MouseInput.GetInstance().PollInput();
      if (m.IsLeftButtonPressed()) x += 10;
      if (m.IsLeftButtonReleased()) y += 10;
      if (m.IsRightButtonHeld()) {
        x = m.GetX();
        y = m.GetY();
      }
      
      test.SetPosition(x, y);
      
      test.Update(delta);
      testBtn.Update(delta);
  }

  @Override
  public int updateRate() {
    return UpdateRate;
  }
}

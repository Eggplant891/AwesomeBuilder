package com.ronma.awesomecalc.core;

//import java.util.ArrayList;
import playn.core.Game;
import playn.core.Image;
import static playn.core.PlayN.*;
import playn.core.Surface;
import playn.core.SurfaceLayer;
import playn.core.AssetWatcher;
import playn.core.AssetManager;

import java.util.ArrayList;

import com.ronma.awesomecalc.core.input.MouseInput;
import com.ronma.awesomecalc.core.input.MouseState;
import com.ronma.awesomecalc.core.loadout.FroggyTest;

public class AwesomeCalc implements Game {
  public static Image bgImage, button;
  SurfaceLayer bgLayer;
  Surface bgSurface;
  public static int UpdateRate = 16;
  AssetWatcher watcher;
  GameObject test;
  LoadoutToggleButton [] btnRow;
  public boolean watcherFinished;
  
  public FroggyTest f_test; 
  
  @Override
  public void init() {
    Global.m_assetManager = assetManager();
    bgImage = Global.m_assetManager.getImage("images/bg.png");
    bgLayer = graphics().createSurfaceLayer(640,480);
    bgSurface = bgLayer.surface();
    graphics().rootLayer().add(bgLayer);
    mouse().setListener(MouseInput.GetInstance());
    button = Global.m_assetManager.getImage("images/spr_froggyG_autoAttack_piranhaCartridges.png");
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
    f_test = new FroggyTest();
    f_test.LoadResources();
    ArrayList<Image> fTestImages = f_test.res.GetFullResourceList();
    
    for (Image img : fTestImages) {
        watcher.add(img);
    }    
    watcher.add(bgImage);
    watcher.add(button);
    watcher.start();
  }
  public int numSelected = 0;
  public void InitApp() {
    btnRow = new LoadoutToggleButton[6];
    for (int i = 0; i < 6; i++) {
        LoadoutToggleButton testBtn = new LoadoutToggleButton(f_test.res.GetAutoAttackSlot(i+1), 69 + i * 64, 50, false) {
            @Override
            public void Clicked() {
                if (numSelected < 3 && IsSwitchedOff()) {
                    Toggle();
                    numSelected++;
                }
                else if (IsSwitchedOn()) {
                    Toggle();
                    if (numSelected > 0) numSelected--;
                }
            }
        };
        btnRow[i] = testBtn;
    }
    x = 0;
  }

@Override
public void paint(float alpha) {
    if (!watcherFinished) return;
    bgSurface.clear();
    bgSurface.fillRect(0, 0, bgLayer.width(), bgLayer.height());
    bgSurface.drawImage(bgImage, 0, 0);
    Image img = f_test.res.GetAutoAttackSlot(0);
    if (img != null) {
        bgSurface.drawImage(img, 5, 50);
    }
    for (int i = 0; i < 6; i++) {
        btnRow[i].Paint(bgSurface);
    }
    for (int i = 0; i < 8; i++) {
        img = f_test.res.GetAbility1Slot(i);
        if (img != null) {
        //bgSurface.drawImage(img, i * 64, i * 64);
        }
        img = f_test.res.GetAutoAttackSlot(i);
        if (img != null) {
            //bgSurface.drawImage(img, i * 64, i * 64 + 64);
        }
    }
}

int x, y;
  @Override
  public void update(float delta) {
      if (!watcherFinished) return;
      MouseState m = MouseInput.GetInstance().PollInput();
      if (m.IsLeftButtonHeld()) {
        x = m.GetX();
        y = m.GetY();
      }
      
      //test.SetPosition(x, y);
      
      //test.Update(delta);
      for (int i = 0; i < 6; i++) {
        btnRow[i].Update(delta);
      }
  }

  @Override
  public int updateRate() {
    return UpdateRate;
  }
}

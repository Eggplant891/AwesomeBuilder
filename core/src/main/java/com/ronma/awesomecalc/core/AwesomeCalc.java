package com.ronma.awesomecalc.core;

//import java.util.ArrayList;
import com.ronma.awesomecalc.core.loadout.LoadoutToggleButton;
import com.ronma.awesomecalc.core.loadout.*;

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
  public boolean watcherFinished;
  
  public ArrayList<LoadoutRow> l_row;
  
  public FroggyTest f_test; 
  
  @Override
  public void init() {
    Global.m_assetManager = assetManager();
    bgImage = Global.m_assetManager.getImage("images/bg.png");
    
    graphics().setSize(800, 600);
    bgLayer = graphics().createSurfaceLayer(800,600);
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
        l_row = new ArrayList<LoadoutRow>();
        l_row.add(new LoadoutRow(LoadoutRowType.ABILITY1, f_test.res));
        l_row.add(new LoadoutRow(LoadoutRowType.ABILITY2, f_test.res));
        l_row.add(new LoadoutRow(LoadoutRowType.AUTO_ATTACK, f_test.res));
        l_row.add(new LoadoutRow(LoadoutRowType.UTILITY, f_test.res));
    }

@Override
public void paint(float alpha) {
    if (!watcherFinished) return;
    bgSurface.clear();
    bgSurface.fillRect(0, 0, bgLayer.width(), bgLayer.height());
    bgSurface.drawImage(bgImage, 0, 0);
    
    if (f_test.res.GetPortrait() != null) bgSurface.drawImage(f_test.res.GetPortrait(), 0, 0);
    
    for (LoadoutRow l : l_row) {
        l.Paint(bgSurface);
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
      
      for (LoadoutRow l : l_row) {
        l.Update(delta);
    }
  }

  @Override
  public int updateRate() {
    return UpdateRate;
  }
}

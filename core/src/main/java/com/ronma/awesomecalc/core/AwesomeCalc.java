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
import playn.core.Font;

public class AwesomeCalc implements Game {
  public static Image bgImage, button;
  SurfaceLayer bgLayer;
  Surface bgSurface;
  public static int UpdateRate = 16;
  AssetWatcher watcher;
  public boolean watcherFinished;
  
  public ArrayList<LoadoutRow> l_row;
  
  public LoadoutScreen froggyScreen;
  public LoadoutScreen raelynnScreen;
  public Screen currentScreen;
  
  @Override
  public void init() {
    Global.m_assetManager = assetManager();
    Global.m_graphics = graphics();
    Fnt.Init();
    
    bgImage = Global.m_assetManager.getImage("images/bg.png");
    LoadoutRow.rowBG = Global.m_assetManager.getImage("images/spr_loadoutRowBG.png");
    Global.m_graphics.setSize(800, 600);
    bgLayer = graphics().createSurfaceLayer(800,600);
    bgSurface = bgLayer.surface();
    Global.m_graphics.rootLayer().add(bgLayer);
    mouse().setListener(MouseInput.GetInstance());
    
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
    watcher.start();
    }
    public int numSelected = 0;
    public void InitApp() {
        raelynnScreen = new LoadoutScreen(new RaelynnTest());
        currentScreen = raelynnScreen;
        /*l_row = new ArrayList<LoadoutRow>();
        l_row.add(new LoadoutRow(LoadoutRowType.ABILITY1, f_test.res));
        l_row.add(new LoadoutRow(LoadoutRowType.ABILITY2, f_test.res));
        l_row.add(new LoadoutRow(LoadoutRowType.AUTO_ATTACK, f_test.res));
        l_row.add(new LoadoutRow(LoadoutRowType.UTILITY, f_test.res));*/
    }

@Override
public void paint(float alpha) {
    if (!watcherFinished) return;
    bgSurface.clear();
    bgSurface.fillRect(0, 0, bgLayer.width(), bgLayer.height());
    bgSurface.drawImage(bgImage, 0, 0);
    
    currentScreen.Paint(bgSurface);
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
        
        if (m.IsRightButtonPressed()) {
            if (currentScreen == froggyScreen) {
                if (raelynnScreen == null) raelynnScreen = new LoadoutScreen(new RaelynnTest());
                currentScreen = raelynnScreen;
            }
            else {
                if (froggyScreen == null) froggyScreen = new LoadoutScreen(new FroggyTest());
                currentScreen = froggyScreen;
            }
        }
        
        currentScreen.Update(delta);
    }

    @Override
    public int updateRate() {
        return UpdateRate;
    }
}

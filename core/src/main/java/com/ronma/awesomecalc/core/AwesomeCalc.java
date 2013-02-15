package com.ronma.awesomecalc.core;

//import java.util.ArrayList;
import com.ronma.awesomecalc.core.loadout.LoadoutScreen;
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
import com.ronma.awesomecalc.nauts.Naut;
import com.ronma.awesomecalc.nauts.util.NautsUtil;

import playn.core.Font;

public class AwesomeCalc implements Game {
  public static Image bgImage, button;
  SurfaceLayer bgLayer;
  Surface bgSurface;
  public static int UpdateRate = 33;
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
    Global.m_screenHandler = new ScreenHandler();
    Fnt.Init();
    
    //bgImage = Global.m_assetManager.getImage("images/bg.png");
    LoadoutRow.rowBG = Global.m_assetManager.getImage("images/spr_loadoutRowBG.png");
    LoadoutRow.rowClosedBG = Global.m_assetManager.getImage("images/spr_loadoutRowBGUnpurchased.png");
    Global.m_graphics.setSize(Global.ScreenWidth, Global.ScreenHeight);
    bgLayer = graphics().createSurfaceLayer(Global.ScreenWidth, Global.ScreenHeight);
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
    //watcher.add(bgImage);
    watcher.start();
    }
    public int numSelected = 0;
    public void InitApp() {
        //raelynnScreen = new LoadoutScreen(new RaelynnTest());
        Global.m_screenHandler.ChangeScreen(ScreenName.NAUT_SELECTION);
        //currentScreen = raelynnScreen;
    }

    @Override
    public void paint(float alpha) {
        if (watcherFinished) {
            bgSurface.clear();
            bgSurface.setFillColor(0xFF001E3D);
            bgSurface.fillRect(0, 0, bgLayer.width(), bgLayer.height());
            //bgSurface.drawImage(bgImage, -1, -1);
        }
        Global.m_screenHandler.Paint(bgSurface);
        Fnt.DrawString(bgSurface, Fnt.Fnt_Standard, Global.m_version, 0, Global.ScreenHeight - 16);
    }

    int x, y;
    @Override
    public void update(float delta) {
        MouseState m = MouseInput.GetInstance().PollInput();
        if (watcherFinished) {
            if (m.IsLeftButtonHeld()) {
                x = m.GetX();
                y = m.GetY();
            }

            if (m.IsRightButtonPressed()) {
                if (Global.m_screenHandler.GetCurrentScreenName() == ScreenName.LOADOUT_FROGGYG) {
                    Global.m_screenHandler.ChangeScreen(ScreenName.LOADOUT_RAELYNN);
                }
                else {
                    Global.m_screenHandler.ChangeScreen(ScreenName.LOADOUT_FROGGYG);
                }
            }
        }
        Global.m_screenHandler.Update(delta);
    }

    @Override
    public int updateRate() {
        return UpdateRate;
    }
}

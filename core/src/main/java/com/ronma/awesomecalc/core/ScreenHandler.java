package com.ronma.awesomecalc.core;
import java.awt.Color;
import playn.core.Surface;
import playn.core.TextLayout;
import com.ronma.awesomecalc.core.loadout.*;
public class ScreenHandler {
    private Screen _currentScreen;
    private ScreenName _currentScreenName;
    private LoadingScreen _loadingScreen;
    private Screen _screens[];
    
    public ScreenHandler() {
        _loadingScreen = new LoadingScreen();
        _currentScreen = _loadingScreen;
        _screens = new Screen[ScreenName.values().length];
        ChangeScreen(ScreenName.TARGETLESS);
    }
    
    public void Update(float delta) {
        if (_currentScreen != null) _currentScreen.Update(delta);
        _loadingScreen.Update(delta);
    }
    
    public void Paint(Surface g) {
        if (_currentScreen != null) _currentScreen.Paint(g);
        if (_loadingScreen.IsVisible) _loadingScreen.Paint(g);
    }
    
    public Screen GetScreenInstance(ScreenName s) {
        switch (s) {
            case NAUT_SELECTION:
                if (_screens[s.ordinal()] == null) _screens[s.ordinal()] = new NautSelectionScreen();
                return _screens[s.ordinal()];
                
            case LOADOUT_FROGGYG:
                if (_screens[s.ordinal()] == null) _screens[s.ordinal()] = new LoadoutScreen(new FroggyTest());
                return _screens[s.ordinal()];
                
            case LOADOUT_RAELYNN:
                if (_screens[s.ordinal()] == null) _screens[s.ordinal()] = new LoadoutScreen(new RaelynnTest());
                return _screens[s.ordinal()];
        }
        
        return null;
    }
    
    public void ChangeScreen(ScreenName newScreen) {
        _loadingScreen.WaitForScreen(newScreen);
    }
    protected void ChangeScreenDirectly(ScreenName s) {
        _currentScreen = GetScreenInstance(s);
        _currentScreenName = s;
    }
    
    public Screen GetCurrentScreen() {
        return _currentScreen;
    }
    
    public ScreenName GetCurrentScreenName() {
        return _currentScreenName;
    }
    
    public boolean IsTheCurrentScreen(Screen s) {
        return (s == _currentScreen);
    }
    
////// INNER LOADING SCREEN CLASS //////////////////////////////////////////////
    protected class LoadingScreen extends Screen {
        private Screen _targetScreen = null;
        private ScreenName _targetScreenName;
        protected boolean IsVisible = false;
        private String LoadingStrings [] = {
            "Loading",
            "Loading.",
            "Loading..",
            "Loading..."
        };
        private int loadStringCounter = 0;
        private int abritraryLoadingTimer = 0;
        private TextLayout msgLayout;
        
        public LoadingScreen() {
            super();
            watcherFinished = true;
            msgLayout = Fnt.GetTextLayout(Fnt.Fnt_MildHeading, LoadingStrings[3]);
            System.out.println("Size: " + msgLayout.width() + ", " + msgLayout.height());
        }

        @Override
        public void InitScreen() {
            
        }

        public void WaitForScreen(ScreenName s) {
            if (s != null) {
                _targetScreen = GetScreenInstance(s);
            }
            _targetScreenName = s;
            // Apply abritrary loading time to test the loading screen.
            //if (!_targetScreen.watcherFinished) {
                IsVisible = true;
                //abritraryLoadingTimer = 60;
            //}
        }

        @Override
        protected void ScreenUpdate(float delta) {
            if (_targetScreen != null) {
                if (_targetScreen.watcher.isDone()) {
                    abritraryLoadingTimer--;
                    ChangeScreenDirectly(_targetScreenName);
                    if (abritraryLoadingTimer <= 0) {
                        IsVisible = false;
                    }
                }
            }
            loadStringCounter++;
            loadStringCounter %= 32;
        }

        @Override
        protected void ScreenPaint(Surface g) {
            if (_targetScreen == null && _targetScreenName != ScreenName.TARGETLESS) Fnt.DrawString(g, Fnt.Fnt_MildHeading, "A screen change error has occured.", 10, 10);
            else {
                g.setFillColor(0xFF8844AA);
                g.fillRect(Global.ScreenWidth/2 - 80, Global.ScreenHeight/2 - 32, 160, 64);
                Fnt.DrawString(g, Fnt.Fnt_MildHeading, LoadingStrings[(int)(loadStringCounter/8)], Global.ScreenWidth/2 - 64, Global.ScreenHeight/2-12);
            }
        }
    }
}

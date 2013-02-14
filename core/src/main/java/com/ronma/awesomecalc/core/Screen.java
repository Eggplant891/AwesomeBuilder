package com.ronma.awesomecalc.core;

import java.util.List;
import playn.core.AssetWatcher;
import playn.core.Image;
import playn.core.Surface;

public abstract class Screen {
    protected AssetWatcher watcher;
    protected boolean watcherFinished;
    
    public Screen() {
        watcherFinished = false;
        watcher = new AssetWatcher(new AssetWatcher.Listener() {

            @Override
            public void done() {
                InitScreen();
                watcherFinished = true;
            }

            @Override
            public void error(Throwable e) {
                System.out.println("Failed to load all assets. ;(");
                Global.m_screenHandler.ChangeScreen(null);
            }
        });
    }
    
    public abstract void InitScreen();
    public void Update(float delta) {
        if (!watcherFinished) return;
        ScreenUpdate(delta);
        
    }
    protected abstract void ScreenUpdate(float delta);
    public void Paint(Surface g) {
        if (!watcherFinished) return;
        ScreenPaint(g);
    }
    protected abstract void ScreenPaint(Surface g);
    
    public void PushImageAssets(List<Image> _images) {
        for (Image s : _images) {
            watcher.add(s);
        }
    }
    
    public void WaitForAssets() {
        watcher.start();
    }
}

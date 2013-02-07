package com.ronma.awesomecalc.core;

import java.util.List;
import playn.core.AssetWatcher;
import playn.core.Image;
import playn.core.Surface;

public class Screen {
    AssetWatcher watcher;
    boolean watcherFinished = false;
    
    public Screen() {
        watcher = new AssetWatcher(new AssetWatcher.Listener() {

            @Override
            public void done() {
                InitScreen();
                watcherFinished = true;
            }

            @Override
            public void error(Throwable e) {
                System.out.println("Failed to load all assets. ;(");
            }
        });
    }
    
    public void InitScreen() {}
    public void Update(float delta) { } 
    public void Paint(Surface g) {
        if (!watcherFinished) {
            
        }
    }
    
    public void PushImageAssets(List<Image> _images) {
        for (Image s : _images) {
            watcher.add(s);
        }
    }
    
    public void WaitForAssets() {
        watcher.start();
    }
}

package com.ronma.awesomecalc.core.loadout;

import com.ronma.awesomecalc.core.Screen;
import playn.core.Surface;
import playn.core.Image;
import java.util.ArrayList;

public class LoadoutScreen extends Screen {
    NautResDefinitions m_res;
    ArrayList<LoadoutRow> l_row;
    public LoadoutScreen(NautResDefinitions resDefs) {
        super();
        resDefs.LoadResources();
        m_res = resDefs;
        for (Image img : resDefs.res.GetFullResourceList()) {
            watcher.add(img);
        }
        watcher.start();
    }
    
    @Override
    public void InitScreen() {
        System.out.println("Screen init");
        l_row = new ArrayList<LoadoutRow>();
        l_row.add(new LoadoutRow(LoadoutRowType.ABILITY1, m_res.res));
        l_row.add(new LoadoutRow(LoadoutRowType.ABILITY2, m_res.res));
        l_row.add(new LoadoutRow(LoadoutRowType.AUTO_ATTACK, m_res.res));
        l_row.add(new LoadoutRow(LoadoutRowType.UTILITY, m_res.res));
    }
    
    @Override
    public void Update(float delta) {
        if (!watcherFinished) return;
        for (LoadoutRow r : l_row) {
            r.Update(delta);
        }
    }
    
    @Override
    public void Paint(Surface g) {
        if (!watcherFinished) return;
        g.drawImage(m_res.res.GetPortraitIcon(), 10, 10);
        for (LoadoutRow r : l_row) {
            r.Paint(g);
        }
    }
    
}

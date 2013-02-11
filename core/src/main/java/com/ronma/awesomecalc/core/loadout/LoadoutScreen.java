package com.ronma.awesomecalc.core.loadout;

import com.ronma.awesomecalc.core.Fnt;
import com.ronma.awesomecalc.core.Global;
import com.ronma.awesomecalc.core.Screen;
import com.ronma.awesomecalc.core.Sprite;
import playn.core.Surface;
import playn.core.Image;
import java.util.ArrayList;

public class LoadoutScreen extends Screen {
    NautResDefinitions m_res;
    ArrayList<LoadoutRow> l_row;
    static Image selectionBracket;
    Sprite spr_selectionBracket;
    LoadoutItem selectedButton = null;
    
    public LoadoutScreen(NautResDefinitions resDefs) {
        super();
        resDefs.LoadResources();
        if (selectionBracket == null)
            selectionBracket = Global.m_assetManager.getImage("images/selectionBracket.png");
        m_res = resDefs;
        for (Image img : resDefs.res.GetFullResourceList()) {
            watcher.add(img);
        }
        watcher.add(selectionBracket);
        watcher.start();
    }
    
    @Override
    public void InitScreen() {
        System.out.println("Screen init");
        l_row = new ArrayList<LoadoutRow>();
        l_row.add(new LoadoutRow(LoadoutRowType.ABILITY1, m_res));
        l_row.add(new LoadoutRow(LoadoutRowType.ABILITY2, m_res));
        l_row.add(new LoadoutRow(LoadoutRowType.AUTO_ATTACK, m_res));
        l_row.add(new LoadoutRow(LoadoutRowType.UTILITY, m_res));
        
        spr_selectionBracket = Sprite.CreateAnimatedSprite(selectionBracket, 4, 1, 0, 4, 15);
    }
    
    @Override
    public void Update(float delta) {
        //selectedButton = null;
        if (!watcherFinished) return;
        for (LoadoutRow r : l_row) {
            r.Update(delta);
            if (r.GetSelectedItem() != null) {
                selectedButton = r.GetSelectedItem();
            }
        }
        spr_selectionBracket.Step();
    }
    
    @Override
    public void Paint(Surface g) {
        if (!watcherFinished) return;
        g.drawImage(m_res.res.GetPortraitIcon(), 10, 10);
        for (LoadoutRow r : l_row) {
            r.Paint(g);
        }
        Fnt.DrawString(g, Fnt.Fnt_BigHeading, m_res.GetNautName(), 100, 40);
        if (selectedButton != null) {
            spr_selectionBracket.Draw(g, selectedButton.GetX() - 7, selectedButton.GetY() - 7, 1f, 1f);
            Fnt.DrawString(g, Fnt.Fnt_BigHeading, selectedButton._itemName, 300, 50);
        }
    }
    
}

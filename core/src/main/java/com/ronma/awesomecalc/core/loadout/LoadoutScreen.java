package com.ronma.awesomecalc.core.loadout;

import com.ronma.awesomecalc.core.*;
import playn.core.Surface;
import playn.core.Image;
import java.util.ArrayList;

public class LoadoutScreen extends Screen {
    NautResDefinitions m_res;
    ArrayList<LoadoutRow> l_row;
    public static Image selectionBracket, selectionDenied, img_backButton;
    Sprite spr_selectionBracket, spr_selectionDenied;
    LoadoutItem selectedButton = null;
    Button backButton;
    
    public LoadoutScreen(NautResDefinitions resDefs) {
        super();
        resDefs.LoadResources();
        if (selectionBracket == null)
            selectionBracket = Global.m_assetManager.getImage("images/selectionBracket.png");
        if (selectionDenied == null)
            selectionDenied = Global.m_assetManager.getImage("images/spr_selectionDenied.png");
        if (img_backButton == null)
            img_backButton = Global.m_assetManager.getImage("images/spr_backButton.png");
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
        //int yOff = LoadoutRow.yOffset + (4 * (64 + LoadoutRow.ySpacing));
        backButton = new Button(img_backButton, 10, 10) {
            @Override
            public void Clicked() {
                Global.m_screenHandler.ChangeScreen(ScreenName.NAUT_SELECTION);
            }
        };
        //spr_selectionDenied = Sprite.CreateStaticSprite(selectionDenied);
    }
    
    public int GetTotalCost() {
        int total = 0;
        for (LoadoutRow r : l_row) {
            total += r.GetTotalCost();
        }
        
        return total;
    }
    
    @Override
    protected void ScreenUpdate(float delta) {
        for (LoadoutRow r : l_row) {
            r.Update(delta);
            if (r.GetSelectedItem() != null) {
                selectedButton = r.GetSelectedItem();
            }
        }
        backButton.Update(delta);
        spr_selectionBracket.Step();
    }
    
    @Override
    protected void ScreenPaint(Surface g) {
        g.setFillColor(0xFFFFFFFF);
        g.fillRect(9, 9, 82, 82);
        g.drawImage(m_res.res.GetPortraitIcon(), 10, 10);
        for (LoadoutRow r : l_row) {
            r.Paint(g);
        }
        backButton.Paint(g);
        Fnt.DrawString(g, Fnt.Fnt_BigHeading, m_res.GetNautName(), 100, 40);
        if (selectedButton != null) {
            spr_selectionBracket.Draw(g, selectedButton.GetX() - 7, selectedButton.GetY() - 7, 1f, 1f);
            Fnt.DrawString(g, Fnt.Fnt_MildHeading, selectedButton.GetItemName(), 524, 100);
            Fnt.DrawString(g, Fnt.Fnt_Standard, selectedButton.GetItemDescription(), 524, 132);
        }
        
        Fnt.DrawString(g, Fnt.Fnt_MildHeading, "TOTAL COST: " + GetTotalCost() + " solar", 524, 380);
    }
    
}

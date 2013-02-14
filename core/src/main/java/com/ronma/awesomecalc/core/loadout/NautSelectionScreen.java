package com.ronma.awesomecalc.core.loadout;
import com.ronma.awesomecalc.core.*;
import playn.core.Surface;
import playn.core.Image;

public class NautSelectionScreen extends Screen {
    private String nautIcons [] = {
        "images/clunk/spr_clunk_iconPortrait_button.png",
        "images/derpl/spr_derpl_iconPortrait_button.png",
        "images/froggyG/spr_froggyG_iconPortrait_button.png",
        "images/gnaw/spr_gnaw_iconPortrait_button.png",
        "images/leon/spr_leon_iconPortrait_button.png",
        "images/lonestar/spr_lonestar_iconPortrait_button.png",
        "images/raelynn/spr_raelynn_iconPortrait_button.png ",  
        "images/skolldir/spr_skolldir_iconPortrait_button.png",
        "images/vinny/spr_vinny_iconPortrait_button.png",
        "images/voltar/spr_voltar_iconPortrait_button.png",
        "images/yuri/spr_yuri_iconPortrait_button.png"
    };
    
    private int i;
    
    private ScreenName buttonTargets[] = {
        ScreenName.NAUT_SELECTION,
        ScreenName.NAUT_SELECTION,
        ScreenName.LOADOUT_FROGGYG,
        ScreenName.NAUT_SELECTION,
        ScreenName.NAUT_SELECTION,
        ScreenName.NAUT_SELECTION,
        ScreenName.LOADOUT_RAELYNN,
        ScreenName.NAUT_SELECTION,
        ScreenName.NAUT_SELECTION,
        ScreenName.NAUT_SELECTION,
        ScreenName.NAUT_SELECTION,
    };
    
    private Image nautImages [];
    
    private Button nautButtons [];
    
    public NautSelectionScreen() {
        nautImages = new Image[Global.NumNauts];
        nautButtons = new Button[Global.NumNauts];
        for (int i = 0; i < Global.NumNauts; i++) {
            nautImages[i] = Global.m_assetManager.getImage(nautIcons[i]);
            watcher.add(nautImages[i]);
        }
        watcher.start();
    }
    
    @Override
    public void InitScreen() {
        for (i = 0; i < Global.NumNauts; i++) {
            nautButtons[i] = new Button(nautImages[i], 20 + (i % 8) * 80, 20 + ((int)(i / 8))*80) {
                @Override
                public void Clicked() {
                    Global.m_screenHandler.ChangeScreen(buttonTargets[i]);
                }
            };
        }
    }
    
    @Override
    protected void ScreenUpdate(float delta) {
        for (i = 0; i < Global.NumNauts; i++) {
            nautButtons[i].Update(delta);
        }
    }
    
    @Override
    protected void ScreenPaint(Surface g) {
        for (i = 0; i < Global.NumNauts; i++) {
            nautButtons[i].Paint(g);
        }
    }
}

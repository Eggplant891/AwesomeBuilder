package com.ronma.awesomecalc.core;

import playn.core.*;

public class Fnt {
    public static Font Fnt_BigHeading, Fnt_Standard, Fnt_MildHeading;
    
    public static void Init() {
        Fnt_BigHeading = Global.m_graphics.createFont("Courier New", Font.Style.BOLD, 32);
        Fnt_Standard = Global.m_graphics.createFont("Courier New", Font.Style.BOLD, 12);
        Fnt_MildHeading = Global.m_graphics.createFont("Courier New", Font.Style.BOLD, 24);
    }
    public static void DrawString(Surface g, Font f, String text, int x, int y) {
        TextFormat format = new TextFormat().withFont(f).withTextColor(0xFFFFFFFF);
        TextLayout layout = Global.m_graphics.layoutText(text, format);
        DrawString(g, layout, x, y);
    }
    
    public static void DrawString(Surface g, TextLayout layout, int x, int y) {
        CanvasImage c = Global.m_graphics.createImage((int)Math.ceil(layout.width()), (int)Math.ceil(layout.height()));
        Canvas gc = c.canvas();
        gc.drawText(layout, 0, 0);
        g.drawImage(c, x, y);
    }
    
    public static TextLayout GetTextLayout(Font f, String text) {
        TextFormat format = new TextFormat().withFont(f);
        TextLayout layout = Global.m_graphics.layoutText(text, format);
        
        return layout;
    }
}

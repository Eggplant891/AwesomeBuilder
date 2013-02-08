package com.ronma.awesomecalc.core;

import playn.core.*;

public class Fnt {
    public static Font Fnt_BigHeading, Fnt_Standard;
    
    public static void Init() {
        Fnt_BigHeading = Global.m_graphics.createFont("Courier New", Font.Style.BOLD, 32);
        Fnt_Standard = Global.m_graphics.createFont("Courier New", Font.Style.BOLD, 12);
    }
    public static void DrawString(Surface g, Font f, String text, int x, int y) {
        TextFormat format = new TextFormat().withFont(f);
        TextLayout layout = Global.m_graphics.layoutText(text, format);
        CanvasImage c = Global.m_graphics.createImage((int)Math.ceil(layout.width()), (int)Math.ceil(layout.height()));
        Canvas gc = c.canvas();
        gc.drawText(layout, 0, 0);
        g.drawImage(c, x, y);
    }
}

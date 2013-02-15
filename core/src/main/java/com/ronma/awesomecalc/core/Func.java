package com.ronma.awesomecalc.core;

import playn.core.Image;
import playn.core.Surface;

public class Func {    
    public static float LengthDirX(float distance, float direction) {
        return (float)(Math.sin(DegToRad((double)direction)) * distance);
    }
    public static float LengthDirY(float distance, float direction) {
        return -((float)Math.cos(DegToRad((double)direction)) * distance);
    }

    public static double DegToRad(double degrees) {
        return (degrees/180.0) * Math.PI;
    }

    public static double RadToDeg(double radians) {
        return (radians/Math.PI) * 180.0;
    }

    public static double PointDirection(int x1, int y1, int x2, int y2) {
        //Log.i("New Rocket Angle", "Val: " + RadToDeg(Math.atan2(y2 - y1, x2 - x1)));
        double returnable = RadToDeg(Math.atan2(y2 - y1, x2 - x1)) + 90;
        if (returnable < 0) returnable += 360;
        else returnable %= 360;
        return returnable;
    }

    public static double PointDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));
    }

    public static boolean CollisionRectangle(Rectangle rect1, Rectangle rect2)
    {
        if ((((rect1.GetX()) < rect2.GetRight())
        && (rect1.GetRight() >= rect2.GetX()))
        && ((rect1.GetY() < rect2.GetBottom())
        && (rect1.GetBottom() >= rect2.GetY())))
        {
            return true;
        }

        return false;
    }
    
    public static boolean CollisionPointRectangle(int x, int y, Rectangle rect) {
        if ((x >= rect.GetX() && x < rect.GetRight())
        && (y >= rect.GetY()) && (y < rect.GetBottom())) {
            return true;
        }
        
        return false;
    }
    
    public static void DrawImageRect(Surface s, Image img, Rectangle src, Rectangle dst) {
        // Special clause to fix issue with Opera Web Browser refusing to continue
        // drawing after encountering a source or destination rectangle definition with width or height of 0.
        if (src.GetWidth() == 0 || src.GetHeight() == 0 || dst.GetWidth() == 0 || dst.GetHeight() == 0) return;
        s.drawImage(img, dst.GetX(), dst.GetY(), dst.GetWidth(), dst.GetHeight(), src.GetX(), src.GetY(), src.GetWidth(), src.GetHeight());
    }
}

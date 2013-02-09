package com.ronma.awesomecalc.core.loadout;

import com.ronma.awesomecalc.core.Global;
import playn.core.Image;

public class LoadoutItemDefinition {
    String _imagePath;
    Image _image;
    String _itemName;
    String _itemDescription;
    
    public LoadoutItemDefinition(String imgPath, String name, String desc) {
        _imagePath = imgPath;
        _itemName = name;
        _itemDescription = desc;
    }
    
    public String GetImagePath   () {
        return _imagePath;
    }
    
    public String GetItemName() {
        return _itemName;
    }
    
    public Image LoadImage() {
        _image = Global.m_assetManager.getImage(_imagePath);
        return _image;
    }
    
    public Image GetImage() {
        return _image;
    }
    
    public String GetItemDescription() {
        return _itemDescription;
    }
}
package com.ronma.awesomecalc.core.loadout;

import com.ronma.awesomecalc.core.Global;
import playn.core.Image;

public class LoadoutItemDefinition {
    String _imagePath;
    Image _image;
    String _itemName;
    String _itemDescription;
    int _stages;
    int _cost;
    
    public LoadoutItemDefinition(String imgPath, String name, String desc, int costPerStage, int stages) {
        _imagePath = imgPath;
        _itemName = name;
        _itemDescription = desc;
        _stages = stages;
        _cost = costPerStage;
    }
    
    public String GetImagePath   () {
        return _imagePath;
    }
    
    public String GetItemName() {
        return _itemName;
    }
    
    public int GetCostPerStage() {
        return _cost;
    }
    
    public int GetTotalCost() {
        return _cost * _stages;
    }
    
    public Image LoadImage() {
        _image = Global.m_assetManager.getImage(_imagePath);
        return _image;
    }
    
    public Image GetImage() {
        return _image;
    }
    
    public int GetTotalStages() {
        return _stages;
    }
    
    public String GetItemDescription() {
        return _itemDescription;
    }
}
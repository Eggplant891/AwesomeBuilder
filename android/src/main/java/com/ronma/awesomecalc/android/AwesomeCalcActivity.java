package com.ronma.awesomecalc.android;

import playn.android.GameActivity;
import playn.core.PlayN;

import com.ronma.awesomecalc.core.AwesomeCalc;

public class AwesomeCalcActivity extends GameActivity {

  @Override
  public void main(){
    platform().assetManager().setPathPrefix("com/ronma/awesomecalc/resources");
    PlayN.run(new AwesomeCalc());
  }
}

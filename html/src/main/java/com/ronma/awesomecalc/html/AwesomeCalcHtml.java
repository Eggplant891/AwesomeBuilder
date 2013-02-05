package com.ronma.awesomecalc.html;

import playn.core.PlayN;
import playn.html.HtmlGame;
import playn.html.HtmlPlatform;

import com.ronma.awesomecalc.core.AwesomeCalc;

public class AwesomeCalcHtml extends HtmlGame {

  @Override
  public void start() {
    HtmlPlatform platform = HtmlPlatform.register();
    platform.assetManager().setPathPrefix("AwesomeCalc/");
    PlayN.run(new AwesomeCalc());
  }
}

package com.ronma.awesomecalc.java;

import playn.core.PlayN;
import playn.java.JavaPlatform;

import com.ronma.awesomecalc.core.AwesomeCalc;

public class AwesomeCalcJava {

  public static void main(String[] args) {
    JavaPlatform platform = JavaPlatform.register();
    platform.assetManager().setPathPrefix("src/main/resources");
    PlayN.run(new AwesomeCalc());
  }
}

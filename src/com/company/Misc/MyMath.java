package com.company.Misc;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MyMath {
    public static double round(double v, int places){
        BigDecimal bd = new BigDecimal(v);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static double round(double v){
        return round(v,4);
    }
}

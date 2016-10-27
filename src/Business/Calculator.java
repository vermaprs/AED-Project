/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 * @author pacif_000
 */
public class Calculator {
    
    
    private double a;
    private double c;
    private double d;
    
    private static int R = 3911; //earth-radius 6371km, 3963.106 is in miles;
    
    public double calculateDistance(double lat1, double lon1, double lat2, double lon2){
    
        DecimalFormat df = new DecimalFormat("###.##");
        df.setRoundingMode(RoundingMode.CEILING);
        
        double dlon= Math.PI*(lon2-lon1)/180;
        double dlat = Math.PI*(lat2-lat1)/180;
        lat1 =Math.PI*(lat1)/180;
        lat2= Math.PI*(lat2)/180;
        
        a= (Math.sin(dlat/2.0)*Math.sin(dlat/2.0))+(Math.cos(lat1)*Math.cos(lat2)*Math.sin(dlon/2.0)*Math.sin(dlon/2.0));
        c= (Math.atan2(Math.sqrt(a),(Math.sqrt(1-a))))*2;
        d=c*R;
        double e = Double.parseDouble(df.format(d));   
//        double f =Math.round(Math.sqrt(((dlon)*(dlon))+((dlat)*(dlat))))/1000;
        
        return e;
    }
    
}

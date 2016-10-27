/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital;

import java.util.ArrayList;

/**
 *
 * @author pacif_000
 */
public class LocationDirectory {
    
    private ArrayList<Location> locationList;

    public LocationDirectory() {
    
        locationList= new ArrayList<>();
    }

    public ArrayList<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(ArrayList<Location> locationList) {
        this.locationList = locationList;
    }
    
    public ArrayList<Location> addLocation(double lat, double lon, String name){
    
        Location location= new Location();
        location.addLocationDetails(lat, lon, name);
        locationList.add(location);
        
        return locationList;
    }
    
    
    
}

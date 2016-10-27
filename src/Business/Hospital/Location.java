/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital;

/**
 *
 * @author pacif_000
 */
public class Location {
    
    
    private LocationDetails locDetails;

    public LocationDetails getLocDetails() {
        return locDetails;
    }

    public void setDetails(LocationDetails locDetails) {
        this.locDetails = locDetails;
    }

    public LocationDetails addLocationDetails(double lat,double lon, String locName){
    
        locDetails = new LocationDetails();
        locDetails.setLatitude(lat);
        locDetails.setLongitude(lon);
        locDetails.setLocationName(locName);
        return locDetails;
    }
    
    
    
}

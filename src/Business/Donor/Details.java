/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Donor;

/**
 *
 * @author pacif_000
 */
public class Details {
    
    private double latitude;
    private double longitude;
    private double distance;
    private Donor donor;
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

//    public double calculateDistance(double latitude, double longitude, double lat1, double long1){
//        
//        return lat1;
//    
//    }    
    
    @Override
    public String toString() {
        return location;
    }

    
    
    
}

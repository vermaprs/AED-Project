/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Hospital.Location;
import Business.Role.HospitalRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author pacif_000
 */
public class HospitalOrganization extends Organization {
    
    private Location hospital;
    
    public HospitalOrganization() {
        super(Organization.Type.Hospital.getValue());
    }

    public Location getHospital() {
        return hospital;
    }

    public void setDonor(Location hospital) {
        this.hospital = hospital;
    }

    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new HospitalRole());
        return roles;
    }
    
}

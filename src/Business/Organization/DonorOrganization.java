/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Donor.Details;
import Business.Donor.Donor;
import Business.Role.DonorRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author pacif_000
 */
public class DonorOrganization extends Organization {
    private Donor donor;
    
    public DonorOrganization() {
        super(Organization.Type.Donor.getValue());
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new DonorRole());
        return roles;
    }
    
}

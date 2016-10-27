/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Hospital.LocationDirectory;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;

/**
 *
 * @author raunak
 */
public abstract class Enterprise extends Organization{

    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;
    private LocationDirectory locationDirectory; 

    
    public Enterprise(String name, EnterpriseType type) {
        super(name);
        this.enterpriseType = type;
        organizationDirectory = new OrganizationDirectory();
//        locationDirectory= new LocationDirectory();
    }
    
    public enum EnterpriseType{
        Hospital("Hospital");
        
        private String value;

        private EnterpriseType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public LocationDirectory getLocationDirectory() {
        return locationDirectory;
    }

    public void setLocationDirectory(LocationDirectory locationDirectory) {
        this.locationDirectory = locationDirectory;
    }
    
    
}

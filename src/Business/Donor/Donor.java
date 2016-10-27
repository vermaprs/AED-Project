/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Donor;

import Business.Employee.Employee;
import Business.WorkQueue.LabTestWorkRequest;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author pacif_000
 */
public class Donor extends Employee{
    
    private ArrayList<BloodDetails> list;
    private BloodDetails bloodDetails;
    private Details details;
    private ArrayList<ContactDetails> contactList;

    

    public Donor() {
        
        list= new ArrayList();
        contactList= new ArrayList();
       
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public BloodDetails getBloodDetails() {
        return bloodDetails;
    }

    public void setBloodDetails(BloodDetails bloodDetails) {
        this.bloodDetails = bloodDetails;
    }

    
    
    
    public ArrayList<BloodDetails> getList() {
        return list;
    }

    public void setList(ArrayList<BloodDetails> list) {
        this.list = list;
    }
    
    public ArrayList<ContactDetails> getContactList() {
        return contactList;
    }

    public void setContactList(ArrayList<ContactDetails> contactList) {
        this.contactList = contactList;
    }
    
public BloodDetails addBloodDetails(String bloodType)
    {
        bloodDetails = new BloodDetails();
//        d.setBarCode(barCode);
        bloodDetails.setBloodType(bloodType);
//        list.add(d);
        return bloodDetails;
    }

    public BloodDetails addBloodDetails(String bloodType, String barcode)
    {
        bloodDetails = new BloodDetails();
        bloodDetails.setBarCode(barcode);
        bloodDetails.setBloodType(bloodType);
        list.add(bloodDetails);
        return bloodDetails;
    }

    public Details addDetails(double latitude, double longitude, String locationName)
    {
        details = new Details();
        details.setLatitude(latitude);
        details.setLongitude(longitude);
        details.setLocation(locationName);
//        list1.add(dt);
        return details;
    }
    
    public ContactDetails addContactDetails(String relation1, long number1){
    
        ContactDetails c = new ContactDetails();
        c.setRelation(relation1);
        c.setNumber(number1);
        contactList.add(c);
        return c;
    
    
    }

    
}

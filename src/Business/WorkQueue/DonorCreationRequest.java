/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.Date;

/**
 *
 * @author pacif_000
 */
public class DonorCreationRequest extends WorkRequest{
    
    private String name;
    private String username;
    private String password;
    private Date date;
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    

    public DonorCreationRequest() {
        date = new Date();
        
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPasssword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return name;
    }

    
    
    
    
}

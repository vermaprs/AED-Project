/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author pacif_000
 */
public class DonorQueue {
    
        private ArrayList<DonorCreationRequest> donorCreationList;

    public DonorQueue() {
        donorCreationList = new ArrayList<>();
    }

    public ArrayList<DonorCreationRequest> getDonorCreationList() {
        return donorCreationList;
    }
    
}

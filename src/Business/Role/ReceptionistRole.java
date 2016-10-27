/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.ReceptionistOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.ReceptionistRole.ReceptionistWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author pacif_000
 */
public class ReceptionistRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new ReceptionistWorkAreaJPanel(userProcessContainer,account,(ReceptionistOrganization)organization,enterprise); 
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DonorRole;

import Business.Donor.Donor;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.AdminOrganization;
import Business.Organization.DonorOrganization;
import Business.Organization.LabOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DonorCreationRequest;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JPanel;


/**
 *
 * @author pacif_000
 */
public class RegisterDonor extends javax.swing.JPanel {
    private Enterprise e;
    private Organization o;
    private JPanel container;
    /**
     * Creates new form RegisterDonor
     */
    public RegisterDonor(Organization o,Enterprise e, JPanel container) {
        initComponents();
        this.o = o;
        this.e=e;
        this.container=container;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        userNameJTextField = new javax.swing.JTextField();
        registerJButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        backJButton = new javax.swing.JButton();

        jLabel1.setText("Register Donor");

        jLabel2.setText("Name");

        jLabel3.setText("Password");

        jLabel4.setText("Username");

        registerJButton.setText("Register Donor");
        registerJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerJButtonActionPerformed(evt);
            }
        });

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(registerJButton)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nameJTextField)
                                    .addComponent(userNameJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                    .addComponent(passwordField)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(backJButton)))
                .addContainerGap(198, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(userNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(registerJButton)
                .addGap(74, 74, 74)
                .addComponent(backJButton)
                .addContainerGap(76, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void registerJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerJButtonActionPerformed

        String userName = userNameJTextField.getText();
        // Get Password
        char[] passwordCharArray = passwordField.getPassword();
        String password = String.valueOf(passwordCharArray);
        String name= nameJTextField.getText();
        Date date = new Date(); 
        
        DonorCreationRequest req = new DonorCreationRequest();
        req.setName(name);
        req.setUsername(userName);
        req.setPasssword(password);
        req.setStatus("To be created");
        req.setRequestDate(date);
        AdminOrganization org;
//        Organization org = null;
        for (Organization organization : e.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof DonorOrganization){
                Donor d= new Donor();
                d.setName(name);
                organization.getEmployeeDirectory().getEmployeeList().add(d);
//                organization.getDonorQueue().getDonorCreationList().add(req);
//                break;
            }
        }
        for (Organization organization : e.getOrganizationDirectory().getOrganizationList()){
        if (organization instanceof AdminOrganization ){
            org=(AdminOrganization)organization;    
            org.getWorkQueue().getWorkRequestList().add(req);
//           userAccount.getWorkQueue().getWorkRequestList().add(req);
        }
        }
        
        
//        Organization org = null;
//        
//        for(Network network: system.getNetworkList()){
//        
//            for(Enterprise e: network.getEnterpriseDirectory().getEnterpriseList()){
//            
//        for (Organization organization : e.getOrganizationDirectory().getOrganizationList()){
//            if (organization instanceof DonorOrganization){
//                organization.getDonorQueue().getDonorCreationList().add(req);
//                
//            }
//        }
//        if (org!=null){
//            
//            
//            .guserAccount.getWorkQueue().getWorkRequestList().add(request);
//                        }
//        
//            }
//        
//        }
        
    }//GEN-LAST:event_registerJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        container.remove(this);
        CardLayout layout = (CardLayout)container.getLayout();
        layout.previous(container);
        
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton registerJButton;
    private javax.swing.JTextField userNameJTextField;
    // End of variables declaration//GEN-END:variables
}

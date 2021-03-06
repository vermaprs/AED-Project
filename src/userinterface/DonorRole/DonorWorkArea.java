/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DonorRole;

import Business.Donor.ContactDetails;
import Business.Donor.Details;
import Business.Donor.Donor;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.DonorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import static java.awt.Component.TOP_ALIGNMENT;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pacif_000
 */
public class DonorWorkArea extends javax.swing.JPanel {

    private JPanel container;
    private Organization org;
    private UserAccount account;
    private Donor donor;
    private Enterprise ent;
    /**
     * Creates new form DonorWorkArea
     */
    public DonorWorkArea(JPanel container, Organization org, UserAccount account, Donor donor, Enterprise ent) {
        initComponents();
        this.container=container;
        this.org=org;
        this.account=account;
        this.donor=donor;
        this.ent=ent;
        populateContactsTable();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        contactsJTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        searchHospitalsJButton = new javax.swing.JButton();
        searchDonorsJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Donor Work Area");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        contactsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Relation", "Mobile Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(contactsJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 230, 90));

        jButton1.setText("Send Message");
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        searchHospitalsJButton.setText("Search Hospitals>>");
        searchHospitalsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchHospitalsJButtonActionPerformed(evt);
            }
        });
        add(searchHospitalsJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, -1, -1));

        searchDonorsJButton.setText("Search Donors>>");
        searchDonorsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDonorsJButtonActionPerformed(evt);
            }
        });
        add(searchDonorsJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, -1, -1));

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    public void populateContactsTable(){
    
        DefaultTableModel model = (DefaultTableModel) contactsJTable.getModel();
//        for(UserAccount acct :org.getUserAccountDirectory().getUserAccountList()){
//                account=acct;
//        }
        model.setRowCount(0);
//        for(Organization o: ent.getOrganizationDirectory().getOrganizationList()){
////        Organization o=(DonorOrganization) org;
//        if(o instanceof DonorOrganization){
//           DonorOrganization or=(DonorOrganization) o;
//           for(UserAccount acct :org.getUserAccountDirectory().getUserAccountList()){
//                account=acct;
        for (ContactDetails c : donor.getContactList()){
            Object[] row = new Object[2];
            row[0] = c.getRelation();
            row[1] = c.getNumber();
            model.addRow(row);
            
        
           }
//        }
//    
    
    
    }
    
    private void searchDonorsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDonorsJButtonActionPerformed

        CardLayout layout = (CardLayout) container.getLayout();
        container.add("Search Donors",new SearchDonorsJPanel(container,org,account,donor,ent));
        layout.next(container);
        
        
        
    }//GEN-LAST:event_searchDonorsJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
     
        container.remove(this);
        CardLayout layout = (CardLayout)container.getLayout();
        layout.previous(container);
        
    }//GEN-LAST:event_backJButtonActionPerformed

    private void searchHospitalsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchHospitalsJButtonActionPerformed

        CardLayout layout = (CardLayout) container.getLayout();
        container.add("Search Hospitals",new SearchHospitalJPanel(container,org,account,donor,ent));
        layout.next(container);
        
        
    }//GEN-LAST:event_searchHospitalsJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JTable contactsJTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchDonorsJButton;
    private javax.swing.JButton searchHospitalsJButton;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DonorRole;



import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import Business.Calculator;
import Business.Donor.Details;
import Business.Donor.Donor;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.DonorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author pacif_000
 */
public class SearchDonorsJPanel extends javax.swing.JPanel {

    private JPanel container;
    private Organization org;
    private Donor donor;
    private Enterprise ent;
    private UserAccount account;
    public double lat1;
    public double lon1;
    public String bloodType;
    
    
    /**
     * Creates new form searchDonorsJPanel
     */
    public SearchDonorsJPanel(JPanel container, Organization org,UserAccount account, Donor donor, Enterprise ent) {
        initComponents();
        this.container=container;
        this.org=org;
        this.donor=donor;
        this.ent=ent;
        this.account=account;
        getPatient();
        populateDonorsJTable();
        
    }
    
    public void getPatient(){
    
        for(Organization o: ent.getOrganizationDirectory().getOrganizationList()){
//        Organization o=(DonorOrganization) org;
        if(o instanceof DonorOrganization){
           DonorOrganization or=(DonorOrganization) o;
//           for(UserAccount acct :org.getUserAccountDirectory().getUserAccountList()){
//                account=acct;
        for (Employee e : or.getEmployeeDirectory().getEmployeeList()){
            
            
            
                
                Object[] em = new Object[1];
                em[0]=e.getName();
                if(em[0].equals(account.getUsername())){
                donor = (Donor)e;
                    lat1=donor.getDetails().getLatitude();
                    lon1=donor.getDetails().getLongitude();
                    bloodType=donor.getBloodDetails().getBloodType();
                
                }
        }
            
            }
            
        }
        
    }

    public void populateDonorsJTable(){
         
//        SpinnerNumberModel model1 = new SpinnerNumberModel(1, 0, 50, 1);  
//        JSpinner distanceJSpinner = new JSpinner(model1);
        
//        double distance = Double.parseDouble(String.valueOf(distanceJSpinner.getValue()));
        
        
        Calculator c = new Calculator();
        DefaultTableModel model = (DefaultTableModel) donorsJTable.getModel();
        donorsJTable.setAutoCreateRowSorter(true);
        model.setRowCount(0);
        
        for(Organization o: ent.getOrganizationDirectory().getOrganizationList()){
//        Organization o=(DonorOrganization) org;
        if(o instanceof DonorOrganization){
           DonorOrganization or=(DonorOrganization) o;
//           for(UserAccount acct :org.getUserAccountDirectory().getUserAccountList()){
//                account=acct;
        for (Employee e : or.getEmployeeDirectory().getEmployeeList()){
           
                Object[] em = new Object[1];
                em[0]=e.getName();
                
                
                if(!em[0].equals(account.getUsername())){
                    
             donor = (Donor)e;
             if(donor.getBloodDetails().getBloodType().equals(bloodType)){
//                 if(distance>c.calculateDistance(lat1,lon1,donor.getDetails().getLatitude(),donor.getDetails().getLongitude())){
             Object[] row = new Object[8];
            row[0] = e.getName();
            row[1]= account.getUsername();
            row[2] = c.calculateDistance(lat1,lon1,donor.getDetails().getLatitude(),donor.getDetails().getLongitude());
            row[3] = donor.getDetails().getLatitude();
            row[4] = donor.getDetails().getLongitude();
            row[5]=lat1;
            row[6]=lon1;
            row[7]=donor.getDetails().getLocation();
            model.addRow(row);
//                 }
             }
           }
            
              
                
        }
            
            }
            
        }
        
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
        donorsJTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        viewMapJButton = new javax.swing.JButton();
        viewAllJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        distanceJTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        searchJButton = new javax.swing.JButton();
        barChartJButton = new javax.swing.JButton();

        jLabel1.setText("Search Donors ");

        donorsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Contact Number", "Air Distance (in Miles)", "Latitude1", "Longitude1", "Latitude2", "Longitude2", "Location Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(donorsJTable);

        jButton1.setText("Send Mail");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        viewMapJButton.setText("View Individually");
        viewMapJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewMapJButtonActionPerformed(evt);
            }
        });

        viewAllJButton.setText("View All Donors");
        viewAllJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllJButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Search within");

        distanceJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distanceJTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("miles");

        searchJButton.setText("Search");
        searchJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchJButtonActionPerformed(evt);
            }
        });

        barChartJButton.setText("Bar Chart");
        barChartJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barChartJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(jLabel1)
                                .addGap(158, 158, 158)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(distanceJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(searchJButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(backJButton)))
                        .addGap(0, 287, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(viewMapJButton)
                .addGap(160, 160, 160))
            .addGroup(layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(viewAllJButton)
                .addGap(91, 91, 91)
                .addComponent(barChartJButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(distanceJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(searchJButton))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(viewMapJButton))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewAllJButton)
                    .addComponent(barChartJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(backJButton)
                .addGap(48, 48, 48))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        container.remove(this);
        CardLayout layout = (CardLayout)container.getLayout();
        layout.previous(container);
        
    }//GEN-LAST:event_backJButtonActionPerformed

    private void viewMapJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewMapJButtonActionPerformed
        
        int selectedRow = donorsJTable.getSelectedRow();
        if(selectedRow>=0){
        final Browser browser = new Browser();
        BrowserView browserView = new BrowserView(browser);

        double destinationlat=(Double) (donorsJTable.getValueAt(selectedRow,3 ));
        double destinationlon=(Double) (donorsJTable.getValueAt(selectedRow,4 ));
        
        final JTextField addressBar = new JTextField("http://www.google.com/maps?saddr="+lat1+","+lon1+"&daddr="+destinationlat+","+destinationlon);
        addressBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                browser.loadURL(addressBar.getText());
            }
        });

//        JPanel addressPane = new JPanel(new BorderLayout());
//        addressPane.add(new JLabel(" URL: "), BorderLayout.WEST);
//        addressPane.add(addressBar, BorderLayout.CENTER);

        JFrame frame = new JFrame("JxBrowser");
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.add(addressPane, BorderLayout.NORTH);
        frame.add(browserView, BorderLayout.CENTER);
        frame.setSize(1100, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        browser.loadURL(addressBar.getText());
        
        
        }
        
    }//GEN-LAST:event_viewMapJButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void distanceJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distanceJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_distanceJTextFieldActionPerformed

    private void searchJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchJButtonActionPerformed

        double distance = Double.parseDouble(String.valueOf(distanceJTextField.getText()));
        
        Calculator c = new Calculator();
        DefaultTableModel model = (DefaultTableModel) donorsJTable.getModel();
        donorsJTable.setAutoCreateRowSorter(true);
        model.setRowCount(0);
        
        for(Organization o: ent.getOrganizationDirectory().getOrganizationList()){
//        Organization o=(DonorOrganization) org;
        if(o instanceof DonorOrganization){
           DonorOrganization or=(DonorOrganization) o;
//           for(UserAccount acct :org.getUserAccountDirectory().getUserAccountList()){
//                account=acct;
        for (Employee e : or.getEmployeeDirectory().getEmployeeList()){
           
                Object[] em = new Object[1];
                em[0]=e.getName();
                
                
                if(!em[0].equals(account.getUsername())){
                    
             donor = (Donor)e;
             if(donor.getBloodDetails().getBloodType().equals(bloodType)){
                 if(distance>c.calculateDistance(lat1,lon1,donor.getDetails().getLatitude(),donor.getDetails().getLongitude())){
             Object[] row = new Object[8];
            row[0] = e.getName();
            row[1]= account.getUsername();
            row[2] = c.calculateDistance(lat1,lon1,donor.getDetails().getLatitude(),donor.getDetails().getLongitude());
            row[3] = donor.getDetails().getLatitude();
            row[4] = donor.getDetails().getLongitude();
            row[5]=lat1;
            row[6]=lon1;
            row[7]=donor.getDetails().getLocation();
            model.addRow(row);
                 }
             }
           }
            
              
                
        }
            
            }
            
        }
        
    }//GEN-LAST:event_searchJButtonActionPerformed

    private void barChartJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barChartJButtonActionPerformed
        
        DefaultCategoryDataset dataset  = new DefaultCategoryDataset();
        Calculator c = new Calculator();
        
        for(Organization o: ent.getOrganizationDirectory().getOrganizationList()){
//        Organization o=(DonorOrganization) org;
        if(o instanceof DonorOrganization){
           DonorOrganization or=(DonorOrganization) o;
//           for(UserAccount acct :org.getUserAccountDirectory().getUserAccountList()){
//                account=acct;
        for (Employee e : or.getEmployeeDirectory().getEmployeeList()){
           
                Object[] em = new Object[1];
                em[0]=e.getName();
                
                
                if(!em[0].equals(account.getUsername())){
                    
             donor = (Donor)e;
             if(donor.getBloodDetails().getBloodType().equals(bloodType)){
//                 if(distance>c.calculateDistance(lat1,lon1,donor.getDetails().getLatitude(),donor.getDetails().getLongitude())){
             
            dataset.setValue(c.calculateDistance(lat1,lon1,donor.getDetails().getLatitude(),donor.getDetails().getLongitude()),"Distance",e.getName());
            

//                 }
             }
           }
            
              
                
        }
            
            }
            
        }
        
        
        
        JFreeChart chart = ChartFactory.createBarChart("Donor Distance", "Donor Name", "Distance", dataset, PlotOrientation.VERTICAL,false, true, false);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.ORANGE);
        ChartFrame barframe= new ChartFrame("Bar Chart for Students",chart);
        barframe.setVisible(true);
        barframe.setSize(450, 350);
        
       
        
        
    }//GEN-LAST:event_barChartJButtonActionPerformed

    private void viewAllJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllJButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewAllJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton barChartJButton;
    private javax.swing.JTextField distanceJTextField;
    private javax.swing.JTable donorsJTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchJButton;
    private javax.swing.JButton viewAllJButton;
    private javax.swing.JButton viewMapJButton;
    // End of variables declaration//GEN-END:variables
}

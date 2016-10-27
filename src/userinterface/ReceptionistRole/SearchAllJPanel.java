/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ReceptionistRole;

import Business.Calculator;
import Business.Donor.Donor;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.DonorOrganization;
import Business.Organization.Organization;
import Business.Organization.ReceptionistOrganization;
import Business.UserAccount.UserAccount;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author pacif_000
 */
public class SearchAllJPanel extends javax.swing.JPanel {

    private JPanel container;
    private Organization org;
    private Donor donor;
    private Enterprise ent;
    private UserAccount account;
    public double lat1;
    public double lon1;
    public String bloodType;
    
    
    /**
     * Creates new form SearchAllJPanel
     */
    public SearchAllJPanel(JPanel container, Organization org,UserAccount account, Enterprise ent) {
        initComponents();
        this.container=container;
        this.org=org;
        this.donor=donor;
        this.ent=ent;
        this.account=account;
        getEmployeeLocation();
        populateDonorsJTable();
    }

    
    public void getEmployeeLocation(){
    
        for(Organization o: ent.getOrganizationDirectory().getOrganizationList()){
//        Organization o=(DonorOrganization) org;
        if(o instanceof ReceptionistOrganization){
           ReceptionistOrganization or=(ReceptionistOrganization) o;
//           for(UserAccount acct :org.getUserAccountDirectory().getUserAccountList()){
//                account=acct;
        for (Employee e : or.getEmployeeDirectory().getEmployeeList()){
            
            
            
                
                Object[] em = new Object[1];
                em[0]=e.getName();
                if(em[0].equals(account.getUsername())){
                
                    lat1=e.getLatitude();
                    lon1=e.getLongitude();
                }
                }
            }
            
        }
        
    }

    public void populateDonorsJTable(){
         
//        SpinnerNumberModel model1 = new SpinnerNumberModel(1, 0, 50, 1);  
//        JSpinner distanceJSpinner = new JSpinner(model1);
        
//        double distance = Double.parseDouble(String.valueOf(distanceJSpinner.getValue()));
//        double distance = Double.parseDouble(distanceJTextField.getText());
        
        Calculator c = new Calculator();
        DefaultTableModel model = (DefaultTableModel) allDonorsJTable.getModel();
        allDonorsJTable.setAutoCreateRowSorter(true);
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
                
                
//                if(!em[0].equals(account.getUsername())){
                    
             donor = (Donor)e;
//             if(donor.getBloodDetails().getBloodType().equals(bloodType)){
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
//             }
//           }
            
              
                
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

        jScrollPane1 = new javax.swing.JScrollPane();
        allDonorsJTable = new javax.swing.JTable();
        sendMailJButton = new javax.swing.JButton();
        viewAllJButton = new javax.swing.JButton();
        barChartJButton = new javax.swing.JButton();
        viewMapJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        distanceJTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        searchJButton = new javax.swing.JButton();
        bloodTypeJTextField = new javax.swing.JTextField();
        searchDonorsWithTypeJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        allDonorsJTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(allDonorsJTable);

        sendMailJButton.setText("Send Mail");
        sendMailJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMailJButtonActionPerformed(evt);
            }
        });

        viewAllJButton.setText("View All Donors");
        viewAllJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllJButtonActionPerformed(evt);
            }
        });

        barChartJButton.setText("Bar Chart");
        barChartJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barChartJButtonActionPerformed(evt);
            }
        });

        viewMapJButton.setText("View Individually");
        viewMapJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewMapJButtonActionPerformed(evt);
            }
        });

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Search Donors ");

        jLabel2.setText("Search Donors within");

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

        bloodTypeJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bloodTypeJTextFieldActionPerformed(evt);
            }
        });

        searchDonorsWithTypeJButton.setText("Search");
        searchDonorsWithTypeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDonorsWithTypeJButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Search Donors with Blood Type");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sendMailJButton)
                                .addGap(109, 109, 109)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(viewAllJButton)
                                        .addGap(91, 91, 91)
                                        .addComponent(barChartJButton)
                                        .addGap(132, 132, 132))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(296, 296, 296)
                                        .addComponent(viewMapJButton))))
                            .addComponent(backJButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(distanceJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bloodTypeJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchDonorsWithTypeJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchJButton))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(distanceJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(searchJButton))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bloodTypeJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchDonorsWithTypeJButton)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewMapJButton)
                    .addComponent(sendMailJButton))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewAllJButton)
                    .addComponent(barChartJButton))
                .addGap(44, 44, 44)
                .addComponent(backJButton)
                .addGap(52, 52, 52))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sendMailJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendMailJButtonActionPerformed

    }//GEN-LAST:event_sendMailJButtonActionPerformed

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

//                        if(!em[0].equals(account.getUsername())){

                            donor = (Donor)e;
                            if(donor.getBloodDetails().getBloodType().equals(bloodType)){
                                //                 if(distance>c.calculateDistance(lat1,lon1,donor.getDetails().getLatitude(),donor.getDetails().getLongitude())){

                                    dataset.setValue(c.calculateDistance(lat1,lon1,donor.getDetails().getLatitude(),donor.getDetails().getLongitude()),"Distance",e.getName());

                                    //                 }
                            }
//                        }

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

    private void viewMapJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewMapJButtonActionPerformed

        int selectedRow = allDonorsJTable.getSelectedRow();
        if(selectedRow>=0){
            final Browser browser = new Browser();
            BrowserView browserView = new BrowserView(browser);

            double destinationlat=(Double) (allDonorsJTable.getValueAt(selectedRow,3 ));
            double destinationlon=(Double) (allDonorsJTable.getValueAt(selectedRow,4 ));

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

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        container.remove(this);
        CardLayout layout = (CardLayout)container.getLayout();
        layout.previous(container);

    }//GEN-LAST:event_backJButtonActionPerformed

    private void distanceJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distanceJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_distanceJTextFieldActionPerformed

    private void searchJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchJButtonActionPerformed

        populateDonorsJTable();

    }//GEN-LAST:event_searchJButtonActionPerformed

    private void viewAllJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllJButtonActionPerformed

        
        
    }//GEN-LAST:event_viewAllJButtonActionPerformed

    private void bloodTypeJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bloodTypeJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bloodTypeJTextFieldActionPerformed

    private void searchDonorsWithTypeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDonorsWithTypeJButtonActionPerformed

        String bloodType=bloodTypeJTextField.getText();
        
        Calculator c = new Calculator();
        DefaultTableModel model = (DefaultTableModel) allDonorsJTable.getModel();
        allDonorsJTable.setAutoCreateRowSorter(true);
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
                
                
//                if(!em[0].equals(account.getUsername())){
                    
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
//           }
            
              
                
        }
            
            }
            
        }
        
       
        
    }//GEN-LAST:event_searchDonorsWithTypeJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable allDonorsJTable;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton barChartJButton;
    private javax.swing.JTextField bloodTypeJTextField;
    private javax.swing.JTextField distanceJTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchDonorsWithTypeJButton;
    private javax.swing.JButton searchJButton;
    private javax.swing.JButton sendMailJButton;
    private javax.swing.JButton viewAllJButton;
    private javax.swing.JButton viewMapJButton;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.logging.Level;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author Mohsin
 */
public class Advance_manage extends javax.swing.JInternalFrame {
     dbclass dbd=new dbclass();
          String url=   dbd.server();
      String id=dbd.serverid();
      String pass=dbd.serverpass();
public void reset(){try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
        String query="SELECT `emp_id` as 'Employee ID', `name` as 'Name', `date` as 'Date', `advancepay` as 'Advance Amount', `remark` as 'Remarks' FROM `advance`";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rst2=pst.executeQuery();
        table.setModel (DbUtils.resultSetToTableModel(rst2));}
        
     catch(Exception E){}}
    /**
     * Creates new form Loan_manage
     */
    public Advance_manage() {
        initComponents();
         try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
        String query="SELECT `emp_id` as 'Employee ID', `name` as 'Name', `date` as 'Date', `advancepay` as 'Advance Amount', `remark` as 'Remarks' FROM `advance`";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rst2=pst.executeQuery();
        table.setModel (DbUtils.resultSetToTableModel(rst2));}
        
     catch(Exception E){}
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
PreparedStatement  pst=conn.prepareStatement("SELECT Department_Name FROM `department_list`");
           
            ResultSet rst1=pst.executeQuery();
            
           while(rst1.next()){
               
              department1.addItem(rst1.getString("Department_Name"));
           }
     
                    }
        catch(Exception ex){
        
   
       }//finally{try {pst.close();} catch (SQLException ex) {Logger.getLogger(shift.class.getName()).log(Level.SEVERE, null, ex);}}
        String dep1=department1.getSelectedItem().toString();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
           
if(dep1 == "All"){
             PreparedStatement pst2=conn.prepareStatement("SELECT Name FROM `emp_list`");
            ResultSet rst1=pst2.executeQuery();
             DefaultComboBoxModel lqwer = new DefaultComboBoxModel();
       lqwer.insertElementAt("All",0);
            while(rst1.next()){ lqwer.addElement(rst1.getString("Name"));
        employee1.setModel(lqwer); 
                       
             
             
             }}else{
           PreparedStatement pst3=conn.prepareStatement("SELECT Name FROM `emp_list` where Department='"+dep1+"'");
            ResultSet rst1=pst3.executeQuery();
     
           while(rst1.next()){
              employee1.addItem(rst1.getString("Name"));
               }
            
}}
        catch(Exception ex){
        
        } //finally{try {pst.close();} catch (SQLException ex) {Logger.getLogger(shift.class.getName()).log(Level.SEVERE, null, ex);}}
           try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst=conn.prepareStatement("SELECT ID FROM `emp_list` where Department='"+dep1+"'");
           if(dep1 == "All"){
             PreparedStatement pst2=conn.prepareStatement("SELECT ID FROM `emp_list`");
            ResultSet rst1=pst2.executeQuery();
             DefaultComboBoxModel lqwer = new DefaultComboBoxModel();
       lqwer.insertElementAt("All",0);
            while(rst1.next()){ lqwer.addElement(rst1.getString("ID"));
        employeeid1.setModel(lqwer); 
                       
             
             
             }}
            ResultSet rst1=pst.executeQuery();
           while(rst1.next()){
            employeeid1.addItem(rst1.getString("ID"));
          
          
           }
     
                    }
        catch(Exception ex){
        
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

        jPanel1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        department1 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        employeeid1 = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        employee1 = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        date1 = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        lamount = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        remark = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Advance Management");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/mainlogo.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Employees"));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Department");

        department1.setEditable(true);
        department1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        department1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        department1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                department1ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Employee ID");

        employeeid1.setEditable(true);
        employeeid1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        employeeid1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeid1ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Employee Name");

        employee1.setEditable(true);
        employee1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        employee1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employee1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(employee1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(department1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(employeeid1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(department1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(employeeid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(employee1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21))
        );

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(252, 126, 1));
        jLabel37.setText("Advance Management");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Date:");

        date1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                date1MouseClicked(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("Loan Amount:");

        lamount.setText("0");
        lamount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lamountMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lamountMousePressed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setText("Remarks:");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Employee ID", "Employee Name", " Date", "Amount"
            }
        ));
        jScrollPane1.setViewportView(table);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 51, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add-ic.png"))); // NOI18N
        jButton4.setText("Add");
        jButton4.setBorder(null);
        jButton4.setPreferredSize(new java.awt.Dimension(95, 30));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton11.setForeground(new java.awt.Color(0, 51, 0));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete-ic.png"))); // NOI18N
        jButton11.setText("Delete");
        jButton11.setBorder(null);
        jButton11.setPreferredSize(new java.awt.Dimension(95, 30));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel-btn-icon-20.png"))); // NOI18N
        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel26)
                            .addComponent(jLabel22))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(remark, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lamount, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel37)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel37)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel22))
                    .addComponent(date1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(lamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(remark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void department1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_department1ActionPerformed
        String dep=department1.getSelectedItem().toString();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement            pst=conn.prepareStatement("SELECT Name FROM `emp_list` where Department='"+dep+"'");
            if(dep == "All"){
                PreparedStatement pst2=conn.prepareStatement("SELECT Name FROM `emp_list`");
                ResultSet rst1=pst2.executeQuery();
                DefaultComboBoxModel lqwer = new DefaultComboBoxModel();
                lqwer.insertElementAt("All",0);
                while(rst1.next()){ lqwer.addElement(rst1.getString("Name"));
                    employee1.setModel(lqwer);

                }}

                ResultSet rst1=pst.executeQuery();
                DefaultComboBoxModel listModel = new DefaultComboBoxModel();

                listModel.insertElementAt("All",0);
                while(rst1.next()){
                    listModel.addElement(rst1.getString("Name"));
                    employee1.setModel(listModel);
                }
            }catch(Exception E){
                JOptionPane.showMessageDialog(null, "Error combo"+E);}//finally{try {pst.close();} catch (SQLException ex) {Logger.getLogger(shift.class.getName()).log(Level.SEVERE, null, ex);}}
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(url,id,pass);
                PreparedStatement pst=conn.prepareStatement("SELECT ID FROM `emp_list` where Department='"+dep+"'");
                if(dep == "All"){
                    PreparedStatement pst2=conn.prepareStatement("SELECT ID FROM `emp_list`");
                    ResultSet rst1=pst2.executeQuery();
                    DefaultComboBoxModel lqwer = new DefaultComboBoxModel();
                    lqwer.insertElementAt("All",0);
                    while(rst1.next()){ lqwer.addElement(rst1.getString("ID"));
                        employeeid1.setModel(lqwer);

                    }}
                    ResultSet rst1=pst.executeQuery();
                    DefaultComboBoxModel lqwer = new DefaultComboBoxModel();
                    lqwer.insertElementAt("All",0);

                    while(rst1.next()){

                        lqwer.addElement(rst1.getString("ID"));

                        employeeid1.setModel(lqwer);

                    }

                }
                catch(Exception ex){
                    
                }
    }//GEN-LAST:event_department1ActionPerformed

    private void employeeid1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeid1ActionPerformed
        String s12=employeeid1.getSelectedItem().toString();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst2=conn.prepareStatement("SELECT name FROM `emp_list` where ID='"+s12+"'");
            if(s12 == "All"){
                employee1.setSelectedItem("All");
            }
            else{           ResultSet rst1=pst2.executeQuery();

                while(rst1.next()){

                    employee1.setSelectedItem(rst1.getString("Name"));

                }

            }   }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error combo"+ex);
            }
    }//GEN-LAST:event_employeeid1ActionPerformed

    private void employee1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employee1ActionPerformed
        String s122=employee1.getSelectedItem().toString();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement   pst2=conn.prepareStatement("SELECT ID FROM `emp_list` where Name='"+s122+"'");
            if(s122 == "All"){
                employeeid1.setSelectedItem("All");
            }

            else{ResultSet rst1=pst2.executeQuery();

                while(rst1.next()){

                    employeeid1.setSelectedItem(rst1.getString("ID"));

                }

            }   }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error combo"+ex);
            }
    }//GEN-LAST:event_employee1ActionPerformed

    private void date1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_date1MouseClicked
        java.util.Date a=date1.getDate();
        java.sql.Date abc=new java.sql.Date(a.getTime());

        int pop=abc.getDate();
        int pop2=abc.getMonth();
        int pop3=abc.getYear();
        JOptionPane.showMessageDialog(null, pop+"-"+pop2+"-"+"-"+pop3);
    }//GEN-LAST:event_date1MouseClicked

    private void lamountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lamountMouseExited

    }//GEN-LAST:event_lamountMouseExited

    private void lamountMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lamountMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lamountMousePressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
  
        try
        {Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class
            Connection con = DriverManager.getConnection(url,id,pass);

            int empid=Integer.parseInt(employeeid1.getSelectedItem().toString());
            String empname=employee1.getSelectedItem().toString();
            java.util.Date ae=date1.getDate();
            java.sql.Date dat=new java.sql.Date(ae.getTime());
            String query ="Replace INTO `advance` VALUES ('"+empid+"','"+empname+"','"+dat+"','"+lamount.getText()+"','"+remark.getText()+"')";       // Create query string to insert name into tale

            PreparedStatement pst= con.prepareStatement(query);                             // Create statement
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Advance Successfull Apply");
        }

        catch(Exception ex)
        {
        }reset();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        int a444=Integer.parseInt(employeeid1.getSelectedItem().toString());java.util.Date ae=date1.getDate();
        java.sql.Date dat=new java.sql.Date(ae.getTime());
        try
        {

            String query2="DELETE FROM `advance` WHERE emp_id='"+a444+"' and date ='"+dat+"'";
            Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

            Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

            PreparedStatement pst2= con.prepareStatement(query2);                             // Create statement
            pst2.executeUpdate();
            JOptionPane.showMessageDialog(null,"Advance Removed ");
            reset();
        }
        catch(Exception e)
        { JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser date1;
    private javax.swing.JComboBox<String> department1;
    private javax.swing.JComboBox<String> employee1;
    private javax.swing.JComboBox<String> employeeid1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lamount;
    private javax.swing.JTextField remark;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}


import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mohsin
 */
public class financialyear extends javax.swing.JFrame {
     dbclass dbd=new dbclass();
          String url=   dbd.server();
      String id=dbd.serverid();
      String pass=dbd.serverpass();
public void reset(){
            
 try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
        String query="SELECT `c_id` as 'Year ID', `cstartyear` as 'Start Year', `cendyear` as 'End Year' from company_details";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rst1=pst.executeQuery();
        table.setModel (DbUtils.resultSetToTableModel(rst1));
          }
     catch(Exception E){}
 
    try{ 
        String dep=department2.getSelectedItem().toString();
        // table123.getTableHeader().setFont( new Font( "Tahoma" , Font.BOLD, 14 ));

        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
if(dep == "All"){PreparedStatement pst2=con.prepareStatement("SELECT  `ID`, `Name`, `Department` FROM `emp_list`");
            ResultSet rst2=pst2.executeQuery();
            
        employeesss.setModel (DbUtils.resultSetToTableModel(rst2)); }
else{String query="SELECT  `ID`, `Name`, `Department` from emp_list where Department='"+dep+"'";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rst1=pst.executeQuery();employeesss.setModel (DbUtils.resultSetToTableModel(rst1));}}catch(Exception E){}
    }


    /**
     * Creates new form financialyear
     */
    public financialyear() {
        initComponents();
        
 try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
        String query="SELECT `c_id` as 'Year ID', `cstartyear` as 'Start Year', `cendyear` as 'End Year' from company_details";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rst1=pst.executeQuery();
        table.setModel (DbUtils.resultSetToTableModel(rst1));
        String query1="SELECT leave_name from leavemanage";
        PreparedStatement pst1=con.prepareStatement(query1);
        ResultSet rst11=pst1.executeQuery();
        while(rst11.next()){leaname.addItem(rst11.getString("leave_name"));}
        String query2="SELECT ID,Name,Department from emp_list";
        PreparedStatement pst2=con.prepareStatement(query2);
        ResultSet rst12=pst2.executeQuery();
        employeesss.setModel (DbUtils.resultSetToTableModel(rst12));
       
        PreparedStatement pst3=con.prepareStatement("SELECT Department_Name FROM `department_list`");
            ResultSet rst3=pst3.executeQuery();
           while(rst3.next()){
            department2.addItem(rst3.getString("Department_Name"));
           }
        
          }
        
     catch(Exception E){}
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
        jLabel1 = new javax.swing.JLabel();
        aid = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        start = new com.toedter.calendar.JDateChooser();
        leave = new javax.swing.JComboBox<>();
        end = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        leaname = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table21 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        employeesss = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        department2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(252, 126, 1));
        jLabel1.setText("Financial Year");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        jPanel1.add(aid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 180, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Schedule ID:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Start year:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("End year:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Leave Forward:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 51, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add-ic.png"))); // NOI18N
        jButton3.setText("Change");
        jButton3.setBorder(null);
        jButton3.setPreferredSize(new java.awt.Dimension(95, 30));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 29));

        jButton11.setBackground(new java.awt.Color(255, 255, 255));
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
        jPanel1.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, -1, 29));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 181, -1, -1));
        jPanel1.add(start, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 180, -1));

        leave.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Forward Available Leaves into Fiscal year", "Encashment Available leaves" }));
        jPanel1.add(leave, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 180, -1));
        jPanel1.add(end, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 180, -1));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Year ID", "Start Year", "End Year"
            }
        ));
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 800, 200));

        jPanel1.add(leaname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 180, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Leave Name:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        table21.setAutoCreateRowSorter(true);
        table21.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table21.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        table21.setCellSelectionEnabled(true);
        jScrollPane2.setViewportView(table21);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 160, 320));

        jButton4.setText("<<");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 50, -1));

        jButton5.setText("<");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, 50, -1));

        employeesss.setAutoCreateRowSorter(true);
        employeesss.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Employee ID", "Name", "Department"
            }
        ));
        employeesss.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jScrollPane3.setViewportView(employeesss);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 220, 320));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(252, 126, 1));
        jLabel2.setText("Selected Employees");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, -1, 21));

        department2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        department2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                department2ActionPerformed(evt);
            }
        });
        jPanel1.add(department2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 110, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(252, 126, 1));
        jLabel3.setText("Select Employees");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, -1, 21));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        DefaultTableModel model = (DefaultTableModel)employeesss.getModel();
        DefaultTableModel model2 = (DefaultTableModel)table21.getModel();

        // get the selected row index
        int selectedRowIndex = employeesss.getSelectedRow();

        // set the selected row data into jtextfields
        String id=(model.getValueAt(selectedRowIndex, 0).toString());
        String name=(model.getValueAt(selectedRowIndex, 1).toString());
        model2.addRow(new Object[]{id,name});
       
        model.removeRow(selectedRowIndex);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        int a444=Integer.parseInt(aid.getText());
        try
        {            String query2="DELETE FROM `company_details` WHERE c_id='"+a444+"'";
            Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class
            Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials
            PreparedStatement pst2= con.prepareStatement(query2);                             // Create statement
            pst2.executeUpdate();
            JOptionPane.showMessageDialog(null, "Delete successfull");
            reset();}
        catch(Exception e){}
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         ArrayList<String> abz = new ArrayList<String>();
        for(int q=0; q < table21.getRowCount(); q++)
        abz.add(table21.getValueAt(q, 0).toString());

        String abzx="";
        Iterator a10;
        a10=abz.iterator();
      

        while ( a10.hasNext())
        {abzx=a10.next().toString(); 
            String empid=abzx;
        
        try
        {            Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class
            Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials


           
        
int leaveencash=0;
String tleave;
            tleave = "";
            String cleave = "";
int aleave=0;
        int id=Integer.parseInt(aid.getText());
        java.util.Date Da=start.getDate();
        java.sql.Date st=new java.sql.Date(Da.getTime());
        java.util.Date Da2=end.getDate();
        java.sql.Date et=new java.sql.Date(Da2.getTime());
        System.out.println(et);
        // int ye=Integer.parseInt(et.toString().subSequence(0, 4).toString())+1;
        //String yera=ye+et.toString().subSequence(5, 10).toString();
        String pyear="",lname=leaname.getSelectedItem().toString(),total="",sy="",se="";
        
try{
            String query ="Replace INTO `company_details` (`c_id`, `cstartyear`, `cendyear`) VALUES ('"+id+"','"+st+"','"+et+"')";             // Create query string to insert name into table
            PreparedStatement pst= con.prepareStatement(query);                             // Create statement
            pst.executeUpdate();
            PreparedStatement state=con.prepareStatement("select * from yearly_calculation where emp_id='"+empid+"'");
            ResultSet rst=state.executeQuery();
            while(rst.next()){
                pyear=rst.getString("year");
                lname=rst.getString("leave_name");
                total=rst.getString("Total_leave"); }}catch(Exception e){}
            //-------------------------------------------------------------------------------------------------------------------
try{
            PreparedStatement state2=con.prepareStatement("select  max(`cstartyear`), max(`cendyear`) from company_details");
            ResultSet rst2=state2.executeQuery();
            while(rst2.next()){ sy=rst2.getString("max(`cstartyear`)");
                se=rst2.getString("max(`cendyear`)");     }}catch(Exception e){}
            //--------------------------------------------------------------------------------------------------------------------------------
            int previous=Integer.parseInt(st.toString().subSequence(0, 4).toString())-1;
            String sd=previous+sy.subSequence(4, 10).toString();
            String ed=st.toString().subSequence(0, 4).toString()+se.subSequence(4, 10).toString();System.out.println(sd +" "+ed);
            
try{
            String query20="select count(leave_name) from leave_employee where date between '"+sd+"' and '"+ed+"' and emp_id='"+empid+"' and leave_name='"+lname+"' ";
            String query1="select Total_leave from yearly_calculation where emp_id='"+empid+"' and year between '"+sd+"' and '"+ed+"' and  leave_name='"+lname+"' ";
            PreparedStatement pst20=con.prepareStatement(query20);
            System.out.println(sd+"  "+ed);
            ResultSet rst20=pst20.executeQuery();
            PreparedStatement pst1=con.prepareStatement(query1);
            ResultSet rst4=pst1.executeQuery();
            if(rst4.next()){ tleave=rst4.getString("Total_Leave");}
            if(rst20.next()){
                cleave=(rst20.getString("count(leave_name)"));}}catch(Exception e){}
try{
            String query5 ="select quantity from leavemanage where leave_name='"+lname+"'";       // Create query string to insert name into tabl
            PreparedStatement pst5= con.prepareStatement(query5);                             // Create statement
            ResultSet rst21=pst5.executeQuery(query5);
            String leavequantity="";
            if(rst21.next()){leavequantity=rst21.getString("quantity");}
            aleave=Integer.parseInt(tleave)-Integer.parseInt(cleave);
            int totall=0;
            if(leave.getSelectedIndex()==0){totall=aleave+Integer.parseInt(leavequantity);}
            if(leave.getSelectedIndex()==1){totall=Integer.parseInt(leavequantity); leaveencash=aleave;}
System.out.println(totall);
            String query4 ="Replace INTO `yearly_calculation`(`emp_id`, `year`, `leave_name`, `Total_leave`) VALUES ('"+empid+"','"+st.toString().subSequence(0, 4).toString()+"','"+lname+"','"+totall+"')";       // Create query string to insert name into tabl
            PreparedStatement pst4= con.prepareStatement(query4);                             // Create statement
            pst4.executeUpdate(query4);


}catch(Exception e){}
            //-------------------------------------------------Tax Yearly Calculation--------------------------------------------
          String taxe="0",nsalry="0";
           Double netpay;
           try{
            String query6 ="SELECT Sum(`Tax`), Sum(`Net_Salary`) FROM `report` WHERE ID='"+empid+"' and Date between '"+sd+"' and '"+ed+"' ";       // Create query string to insert name into tabl
            PreparedStatement pst6= con.prepareStatement(query6);                             // Create statement
            ResultSet rst22=pst6.executeQuery(query6);
            
            if(rst22.next()){
                taxe=rst22.getString("Sum(`Tax`)");
                nsalry=rst22.getString("Sum(`Net_Salary`)");
            }}catch(Exception e){}
            try{
                if(taxe==null || nsalry==null){netpay=0.0; }else{
            int a= (Integer.parseInt(nsalry)+Integer.parseInt(taxe));
            double s=0.0;
            String salr="0";
            if(a > 400000 && a < 500000 ){s=(((a-400000)/100)*2);   }
            salr=(Double.toString(s));

            if(a > 500000 && a < 750000 ){s=((((a-500000)/100)*5)+2000);   }
            salr=(Double.toString(s));

            if(a > 750000 && a < 1400000 ){s=((((a-750000)/100)*10)+14500);   }//2572.4-330
            salr=(Double.toString(s));

            if(a > 1400000 && a < 1500000 ){s=((((a-1400000)/100)*12.5)+79500);   }
            salr=(Double.toString(s));

            if(a > 1500000 && a < 1800000 ){s=((((a-1500000)/100)*15)+92000);   }
            salr=(Double.toString(s));

            if(a > 1800000 && a < 2500000 ){s=((((a-1800000)/100)*17.5)+137000);   }
            salr=(Double.toString(s));

            if(a > 2500000 && a < 3000000 ){s=((((a-2500000)/100)*20)+259500);   }
            salr=(Double.toString(s));

            if(a > 3000000 && a < 3500000 ){s=((((a-3000000)/100)*22.5)+359500);   }
            salr=(Double.toString(s));

            if(a > 3500000 && a < 4000000 ){s=((((a-3500000)/100)*25)+472000);   }
            salr=(Double.toString(s));

            if(a > 4000000 && a < 7000000 ){s=(((((a-4000000)/100)*27.5)+597000));   }
            salr=(Double.toString(s));

            if(a > 7000000){s=((((a-7000000)/100)*30)+1450000);   }
            salr=(Double.toString(s));
            netpay= Double.parseDouble(salr)-Double.parseDouble(taxe);
            String dat=ed.subSequence(0,8).toString()+"01";
            String query7 ="Replace INTO `yealrypayment`(`ID`,`date`,`taxpay`,leavepay) VALUES ('"+empid+"','"+dat+"','"+netpay+"','"+leaveencash+"')";       // Create query string to insert name into tabl
            PreparedStatement pst7= con.prepareStatement(query7);                             // Create statement
            pst7.executeUpdate(query7);
                }String dat=ed.subSequence(0,8).toString()+"01";
            String query7 ="Replace INTO `yealrypayment`(`ID`,`date`,`taxpay`,leavepay) VALUES ('"+empid+"','"+dat+"','"+netpay+"','"+leaveencash+"')";       // Create query string to insert name into tabl
            PreparedStatement pst7= con.prepareStatement(query7);                             // Create statement
            pst7.executeUpdate(query7);}catch(Exception e){JOptionPane.showMessageDialog(null, e+"12");}
            JOptionPane.showMessageDialog(null,"Financial Year Change Successfull");
            reset();
        }
        catch(Exception e)
        {}}
        reset();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void department2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_department2ActionPerformed
        reset();
        //finally{try {pst.close();} catch (SQLException ex) {Logger.getLogger(shift.class.getName()).log(Level.SEVERE, null, ex);}}
    }//GEN-LAST:event_department2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
try{ 
        String dep=department2.getSelectedItem().toString();
        // table123.getTableHeader().setFont( new Font( "Tahoma" , Font.BOLD, 14 ));

        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
if(dep == "All"){PreparedStatement pst2=con.prepareStatement("SELECT  `ID`, `Name`, `Department` FROM `emp_list`");
            ResultSet rst2=pst2.executeQuery();
            
        table21.setModel (DbUtils.resultSetToTableModel(rst2)); }
else{String query="SELECT  `ID`, `Name`, `Department` from emp_list where Department='"+dep+"'";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rst1=pst.executeQuery();table21.setModel (DbUtils.resultSetToTableModel(rst1));}}catch(Exception E){}
            // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(financialyear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(financialyear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(financialyear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(financialyear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new financialyear().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aid;
    private javax.swing.JComboBox<String> department2;
    private javax.swing.JTable employeesss;
    private com.toedter.calendar.JDateChooser end;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> leaname;
    private javax.swing.JComboBox<String> leave;
    private com.toedter.calendar.JDateChooser start;
    private javax.swing.JTable table;
    private javax.swing.JTable table21;
    // End of variables declaration//GEN-END:variables
}

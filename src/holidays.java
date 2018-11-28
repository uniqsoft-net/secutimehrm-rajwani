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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mohsi
 */
public class holidays extends javax.swing.JInternalFrame {
 dbclass dbd=new dbclass();
          String url=   dbd.server();
      String id=dbd.serverid();
      String pass=dbd.serverpass(); String quan="";
    public void SetData(Object obj, int row_index, int col_index){
  table5.getModel().setValueAt(obj,row_index,col_index);
  }
   public Object GetData(JTable table, int row_index, int col_index){
  return table.getModel().getValueAt(row_index, col_index); }
public void reset(){
 try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
        String query="Select ID, Name, Department from emp_list";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rst2=pst.executeQuery();
        table10.setModel (DbUtils.resultSetToTableModel(rst2));
        }
     catch(Exception E){eror.setText("Error 402");}
 try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
        String query="SELECT id as 'Holiday ID', holiday_name as 'Holiday Name', reason as 'Description' from holiday";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rst1=pst.executeQuery();
        table5.setModel (DbUtils.resultSetToTableModel(rst1));
          }
    catch(Exception E){eror.setText(" Data Error");}
}
    public holidays() {
        initComponents();  
 try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
        String query="Select ID, Name, Department from emp_list";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rst2=pst.executeQuery();
        table10.setModel (DbUtils.resultSetToTableModel(rst2));
        }
     catch(Exception E){}
 try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
        String query="SELECT id as 'Holiday ID', holiday_name as 'Holiday Name', reason as 'Description' from holiday";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rst1=pst.executeQuery();
        table5.setModel (DbUtils.resultSetToTableModel(rst1));
          }
    catch(Exception E){eror.setText(" Data Error");}
 try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
PreparedStatement  pst=conn.prepareStatement("SELECT Department_Name FROM `department_list`");
           
            ResultSet rst1=pst.executeQuery();
            
           while(rst1.next()){
               
              department2.addItem(rst1.getString("Department_Name"));
           }
     
                    }
        catch(Exception ex){
        
   
       }//finally{try {pst.close();} catch (SQLException ex) {Logger.getLogger(shift.class.getName()).log(Level.SEVERE, null, ex);}}
        String dep1=department2.getSelectedItem().toString();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
           
if(dep1 == "All"){
             PreparedStatement pst2=conn.prepareStatement("SELECT Name FROM `emp_list`");
            ResultSet rst1=pst2.executeQuery();
             DefaultComboBoxModel lqwer = new DefaultComboBoxModel();
       lqwer.insertElementAt("All",0);
            while(rst1.next()){ lqwer.addElement(rst1.getString("Name"));
        employee2.setModel(lqwer); 
                       
             
             
             }}else{
           PreparedStatement pst3=conn.prepareStatement("SELECT Name FROM `emp_list` where Department='"+dep1+"'");
            ResultSet rst1=pst3.executeQuery();
     
           while(rst1.next()){
              employee2.addItem(rst1.getString("Name"));
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
        employeeid2.setModel(lqwer); 
                       
             
             
             }}
            ResultSet rst1=pst.executeQuery();
           while(rst1.next()){employeeid2.addItem(rst1.getString("id"));}}
        catch(Exception ex){}
 try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
PreparedStatement pst=conn.prepareStatement("select id,holiday_name,reason from holiday ");
            //PreparedStatement pst2=conn.prepareStatement("SELECT distinct year(Date) FROM leave_employee");
            ResultSet rst1=pst.executeQuery();
            //ResultSet rst2=pst2.executeQuery();
           while(rst1.next()){
               shiftid2.addItem(rst1.getString("id"));
               shiftname.addItem(rst1.getString("holiday_name"));
               reasone.setText(rst1.getString("reason"));
           } }
        catch(Exception ex){}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table5 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        aid = new javax.swing.JTextField();
        aname = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        eror = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        reas = new javax.swing.JTextField();
        jButton16 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        shiftname = new javax.swing.JComboBox<>();
        jButton9 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        startdate = new com.toedter.calendar.JDateChooser();
        shiftid2 = new javax.swing.JComboBox<>();
        enddate = new com.toedter.calendar.JDateChooser();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        eror5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        reasone = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jButton15 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        department2 = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        employeeid2 = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        employee2 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table10 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Holiday Management");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/mainlogo.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setMaximumSize(new java.awt.Dimension(800, 32767));
        jPanel6.setPreferredSize(new java.awt.Dimension(800, 616));

        table5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table5.setRowHeight(20);
        table5.setSelectionBackground(new java.awt.Color(252, 126, 2));
        table5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table5MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table5);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Holiday ID:");

        aname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anameActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Holiday Name:");

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 51, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add-ic.png"))); // NOI18N
        jButton3.setText("Add");
        jButton3.setBorder(null);
        jButton3.setPreferredSize(new java.awt.Dimension(95, 30));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        eror.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

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

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Description:");

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel-btn-icon-20.png"))); // NOI18N
        jButton16.setText("Close");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(eror, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(reas)
                            .addComponent(aname)
                            .addComponent(aid, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap(596, Short.MAX_VALUE)
                        .addComponent(eror, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(aid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(reas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton16)))
                .addGap(0, 0, 0))
        );

        jTabbedPane1.addTab("Holiday Type", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel32.setText("End Date:");
        jPanel11.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        shiftname.setEditable(true);
        shiftname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shiftnameActionPerformed(evt);
            }
        });
        jPanel11.add(shiftname, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, -1, -1));

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add-ic.png"))); // NOI18N
        jButton9.setText("Save");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 95, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Employee Leave ID:");
        jPanel11.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        startdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startdateMouseClicked(evt);
            }
        });
        jPanel11.add(startdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 123, -1));

        shiftid2.setEditable(true);
        shiftid2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shiftid2ActionPerformed(evt);
            }
        });
        jPanel11.add(shiftid2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, -1, -1));
        jPanel11.add(enddate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 123, -1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel33.setText("Start Date:");
        jPanel11.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setText("Employee Leave Name:");
        jPanel11.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        eror5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        eror5.setForeground(new java.awt.Color(255, 0, 0));
        jPanel11.add(eror5, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 351, 148, 26));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete-ic.png"))); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, -1, -1));

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel38.setText("Description:");
        jPanel11.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));
        jPanel11.add(reasone, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 306, 36));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(252, 126, 1));
        jLabel36.setText("Employee Leave");
        jPanel11.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, -1, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(252, 126, 1));
        jLabel37.setText("Employees List");
        jPanel11.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "Employee Name", "Department", "Shift NO", "Shift Start Date", "Shift End Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(table3);

        jPanel11.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 792, 150));

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "emp", "emp2", "emp3", "emp4"
            }
        ));
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table2);

        jPanel11.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -427, 60, -1));

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel-btn-icon-20.png"))); // NOI18N
        jButton15.setText("Close");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 510, -1, -1));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Employees"));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Department");

        department2.setEditable(true);
        department2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        department2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        department2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                department2ActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("Employee ID");

        employeeid2.setEditable(true);
        employeeid2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        employeeid2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        employeeid2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeid2ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setText("Employee Name");

        employee2.setEditable(true);
        employee2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        employee2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        employee2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employee2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(employeeid2, javax.swing.GroupLayout.Alignment.TRAILING, 0, 127, Short.MAX_VALUE)
                    .addComponent(department2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employee2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(department2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(employeeid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employee2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)))
        );

        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 320, -1));

        table10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table10MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table10);

        jPanel11.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 420, 320));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jTabbedPane1.addTab("Approved Holidays", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst2=conn.prepareStatement("SELECT id,holiday_name FROM holiday");
            ResultSet rst2=pst2.executeQuery();
            DefaultComboBoxModel listModel = new DefaultComboBoxModel();
            DefaultComboBoxModel listModel2 = new DefaultComboBoxModel();

            //  while(rst2.next()){
                //    listModel.addElement(rst2.getString("id"));
                //  listModel2.addElement(rst2.getString("leave_name"));
                //shiftid2.setModel(listModel);
                //shiftname.setModel(listModel2);}
        }
        /* ResultSet rst1=pst.executeQuery();
        DefaultComboBoxModel listModel = new DefaultComboBoxModel();

        listModel.insertElementAt("All",0);
        while(rst1.next()){
            listModel.addElement(rst1.getString("Name"));
            employee.setModel(listModel);
        }*/
        catch(Exception ex){eror.setText("JOptionPane.showMessageDialog(null,7");
        }
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
       this.dispose();     // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked
        DefaultTableModel model = (DefaultTableModel)table2.getModel();

        // get the selected row index
        int selectedRowIndex = table2.getSelectedRow();

        // set the selected row data into jtextfields

        employeeid2.setSelectedItem(model.getValueAt(selectedRowIndex, 0).toString());
    }//GEN-LAST:event_table2MouseClicked

    private void table3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table3MouseClicked

    }//GEN-LAST:event_table3MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int a444=Integer.parseInt(employeeid2.getSelectedItem().toString());
        int a445=Integer.parseInt(shiftid2.getSelectedItem().toString());
        java.util.Date a=startdate.getDate();
        java.sql.Date abc=new java.sql.Date(a.getTime());
        java.util.Date b=enddate.getDate();
        java.sql.Date ab=new java.sql.Date(b.getTime());
        String l="hh:mm:ss";
        try
        {
            String query4="DELETE FROM `holiday_employee` WHERE emp_id='"+a444+"' and holiday_id='"+a445+"' and date between '"+abc+"' and '"+ab+"'  ";
            Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class
            Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials
            PreparedStatement pst4= con.prepareStatement(query4);                             // Create statement
            pst4.executeUpdate();
            JOptionPane.showMessageDialog(this, "delete successfull");//setText("delete successfull");
          // reset();
            try{String query="SELECT  `emp_id`, `emp_name`, `holiday_id`, `holiday_name`, `date`, `description` FROM `holiday_employee` where `emp_id` = '"+a444+"' ";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst2=conn.prepareStatement(query);
            ResultSet rst2=pst2.executeQuery();
            table3.setModel(DbUtils.resultSetToTableModel(rst2));

}catch(Exception e){}
            //                                    Execute Query
            //pst.setString(1,str1)            //          pst.setString(2,p);
            // Close the open connection
        }
        catch(Exception e)
        {eror5.setText(" Data Error");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void shiftid2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shiftid2ActionPerformed

    }//GEN-LAST:event_shiftid2ActionPerformed

    private void startdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startdateMouseClicked
        java.util.Date a=startdate.getDate();
        java.sql.Date abc=new java.sql.Date(a.getTime());

        int pop=abc.getDate();
        int pop2=abc.getMonth();
        int pop3=abc.getYear();
        JOptionPane.showMessageDialog(null, pop+"-"+pop2+"-"+"-"+pop3);
    }//GEN-LAST:event_startdateMouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
      
            String incDate="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();

        java.util.Date a=startdate.getDate();
        java.sql.Date abc=new java.sql.Date(a.getTime());
        java.util.Date b=enddate.getDate();
        java.sql.Date ab=new java.sql.Date(b.getTime());
         
        try{Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url,id,pass);
            LocalDate startDate=LocalDate.parse(abc.toString());
        
            LocalDate endDate=LocalDate.parse(ab.toString());
            String qwe=abc.toString();
            c.setTime(sdf.parse(abc.toString()));
            final long days = ChronoUnit.DAYS.between(startDate,endDate);

            //String a1=empid.getSelectedItem().toString();
            String a2=shiftid2.getSelectedItem().toString();
            String a3=employee2.getSelectedItem().toString();
            String a4=shiftname.getSelectedItem().toString();
            String a6=reasone.getText();
            if(0 <= days-1){
       

            
                   if(employeeid2.getSelectedItem() == "All"){
                ArrayList ar=new ArrayList();ArrayList ar1=new ArrayList();
                for(int p=1;p < employeeid2.getItemCount();p++){

ar.add(employeeid2.getItemAt(p));}
                
    Iterator ae; String uti;Iterator ae1; 
    ae=ar.iterator();
    while ( ae.hasNext() )
        {uti=ae.next().toString(); 
PreparedStatement pst2=con.prepareStatement("SELECT Name FROM `emp_list` where ID='"+uti+"'");
                     ResultSet rst1=pst2.executeQuery();
String empname="";
                while(rst1.next()){

                    empname=rst1.getString("Name");

                }
            String query ="replace INTO `holiday_employee`  VALUES ('"+uti+"','"+empname+"','"+a2+"','"+a4+"','"+startDate+"','"+a6+"')";       // Create query string to insert name into table
            
            // Connect to Database using credentials
            Statement ps= con.createStatement();                             // Create statement
            int t=ps.executeUpdate(query);}
                   }       else{
            int empid2=Integer.parseInt(employeeid2.getSelectedItem().toString());
            String query ="replace INTO `holiday_employee`  VALUES ('"+empid2+"','"+a3+"','"+a2+"','"+a4+"','"+startDate+"','"+a6+"')";       // Create query string to insert name into table
            ;  // Connect to Database using credentials
         PreparedStatement pst= con.prepareStatement(query);                             // Create statement
            pst.executeUpdate();  
                 reset();  
                   }
                if(2 <=days){
                        for(int co=0; co<=days-1 ; co++){
                            c.add(Calendar.DATE, 1);
                            incDate = sdf.format(c.getTime());

                   if(employeeid2.getSelectedItem() == "All"){
                ArrayList ar=new ArrayList();ArrayList ar1=new ArrayList();
                for(int p=1;p < employeeid2.getItemCount();p++){

ar.add(employeeid2.getItemAt(p));}
                
    Iterator ae; String uti;
    ae=ar.iterator();
    while ( ae.hasNext() )
        {uti=ae.next().toString();

PreparedStatement pst2=con.prepareStatement("SELECT Name FROM `emp_list` where ID='"+uti+"'");
                     ResultSet rst1=pst2.executeQuery();
String empname="";
                while(rst1.next()){

                    empname=rst1.getString("Name");

                }
            String query ="replace INTO `holiday_employee`  VALUES ('"+uti+"','"+empname+"','"+a2+"','"+a4+"','"+incDate+"','"+a6+"')";       // Create query string to insert name into table
     
            // Connect to Database using credentials
            Statement ps= con.createStatement();                             // Create statement
            int t=ps.executeUpdate(query);}
                   }       else{
            int empid2=Integer.parseInt(employeeid2.getSelectedItem().toString());
            String query ="replace INTO `holiday_employee`  VALUES ('"+empid2+"','"+a3+"','"+a2+"','"+a4+"','"+incDate+"','"+a6+"')";       // Create query string to insert name into table
           // Connect to Database using credentials
         PreparedStatement pst= con.prepareStatement(query);                             // Create statement
            pst.executeUpdate();  
                 reset();  }
                        }}    
                   JOptionPane.showMessageDialog(null,"Holiday Successfull Apply");
            } else{JOptionPane.showMessageDialog(null,"Reverse Date Not Allowed");}       }
        catch
        (Exception ex)
        {
        }reset();   

// "replace INTO `holiday_employee`  VALUES ('"+uti+"','"+a3+"','"+a2+"','"+a4+"','"+incDate+"','"+a6+"')"
    }//GEN-LAST:event_jButton9ActionPerformed

    private void shiftnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shiftnameActionPerformed
        String s12=shiftname.getSelectedItem().toString();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst=conn.prepareStatement("SELECT id ,reason FROM `holiday` where holiday_name='"+s12+"'");
            ResultSet rst1=pst.executeQuery();

            while(rst1.next()){
                shiftid2.setSelectedItem(rst1.getString("id"));
                reasone.setText(rst1.getString("reason"));}
        }
        catch(Exception ex){
        }
    }//GEN-LAST:event_shiftnameActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
this.dispose();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        int a444=Integer.parseInt(aid.getText());
        try
        {

            String query2="DELETE FROM `holiday` WHERE id='"+a444+"'";
            Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

            Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

            PreparedStatement pst2= con.prepareStatement(query2);                             // Create statement
            pst2.executeUpdate();
            eror.setText("delete successfull");
           reset();
        }
        catch(Exception e)
        {eror.setText("JOptionPane.showMessageDialog(null,14");
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int idd=Integer.parseInt(aid.getText());
        String named=aname.getText();
      
        String Rea=reas.getText();
        //        String y1=year1.getText();
        try
        {

            String query ="replace INTO `holiday` VALUES ('"+idd+"','"+named+"','"+Rea+"')";             // Create query string to insert name into table
            Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class
            Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials
            PreparedStatement pst= con.prepareStatement(query);                             // Create statement
            pst.executeUpdate();
            eror.setText("Insert Successfull");
            reset();
            
        }
        catch(Exception e)
        {eror.setText("JOptionPane.showMessageDialog(null,15"+e);}
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void anameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anameActionPerformed

    private void table5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table5MouseClicked
        DefaultTableModel model = (DefaultTableModel)table5.getModel();

        // get the selected row index
        int selectedRowIndex = table5.getSelectedRow();

        // set the selected row data into jtextfields
        aid.setText(model.getValueAt(selectedRowIndex, 0).toString());
        aname.setText(model.getValueAt(selectedRowIndex, 1).toString());
    }//GEN-LAST:event_table5MouseClicked

    private void department2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_department2ActionPerformed
    String dep=department2.getSelectedItem().toString();
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
                    employee2.setModel(lqwer);

                }}

                ResultSet rst1=pst.executeQuery();
                DefaultComboBoxModel listModel = new DefaultComboBoxModel();

                listModel.insertElementAt("All",0);
                while(rst1.next()){
                    listModel.addElement(rst1.getString("Name"));
                    employee2.setModel(listModel);
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
                        employeeid2.setModel(lqwer);

                    }}
                    ResultSet rst1=pst.executeQuery();
                    DefaultComboBoxModel lqwer = new DefaultComboBoxModel();
                    lqwer.insertElementAt("All",0);

                    while(rst1.next()){

                        lqwer.addElement(rst1.getString("ID"));

                        employeeid2.setModel(lqwer);

                    }

                }
                catch(Exception ex){
                    
                }
    }//GEN-LAST:event_department2ActionPerformed

    private void employeeid2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeid2ActionPerformed
        String s12=employeeid2.getSelectedItem().toString();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst2=conn.prepareStatement("SELECT name FROM `emp_list` where ID='"+s12+"'");
            if(s12 == "All"){
                employee2.setSelectedItem("All");
            }
            else{           ResultSet rst1=pst2.executeQuery();

                while(rst1.next()){

                    employee2.setSelectedItem(rst1.getString("Name"));

                }

            }   }
            catch(Exception ex){
               // JOptionPane.showMessageDialog(null, "Error combo"+ex);
            }
        //reset1();
         try{String query="SELECT  `emp_id`, `emp_name`, `holiday_id`, `holiday_name`, `date`, `description` FROM `holiday_employee` where `emp_id` = '"+s12+"' ";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst2=conn.prepareStatement(query);
            ResultSet rst2=pst2.executeQuery();
            table3.setModel(DbUtils.resultSetToTableModel(rst2));

}catch(Exception e){}
        
    }//GEN-LAST:event_employeeid2ActionPerformed

    private void employee2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employee2ActionPerformed
            String s12=employeeid2.getSelectedItem().toString();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst2=conn.prepareStatement("SELECT name FROM `emp_list` where ID='"+s12+"'");
            if(s12 == "All"){
                employee2.setSelectedItem("All");
            }
            else{           ResultSet rst1=pst2.executeQuery();

                while(rst1.next()){

                    employee2.setSelectedItem(rst1.getString("Name"));

                }

            }   }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error combo"+ex);
            }
    }//GEN-LAST:event_employee2ActionPerformed

    private void table10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table10MouseClicked
        DefaultTableModel model = (DefaultTableModel)table10.getModel();

        // get the selected row index
        int selectedRowIndex = table10.getSelectedRow();

        // set the selected row data into jtextfields

        employeeid2.setSelectedItem(model.getValueAt(selectedRowIndex, 0).toString());
        
        
        
    }//GEN-LAST:event_table10MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aid;
    private javax.swing.JTextField aname;
    private javax.swing.JComboBox<String> department2;
    private javax.swing.JComboBox<String> employee2;
    private javax.swing.JComboBox<String> employeeid2;
    private com.toedter.calendar.JDateChooser enddate;
    private javax.swing.JLabel eror;
    private javax.swing.JLabel eror5;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField reas;
    private javax.swing.JTextField reasone;
    private javax.swing.JComboBox<String> shiftid2;
    private javax.swing.JComboBox<String> shiftname;
    private com.toedter.calendar.JDateChooser startdate;
    private javax.swing.JTable table10;
    public javax.swing.JTable table2;
    public javax.swing.JTable table3;
    public static javax.swing.JTable table5;
    // End of variables declaration//GEN-END:variables
}

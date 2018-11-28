
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.print.PrinterException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
//import static mondrian.olap.fun.vba.Vba.month;
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
public class ColumnChooser extends javax.swing.JFrame {
     dbclass dbd=new dbclass();
          String url=   dbd.server();
      String id=dbd.serverid();
      String pass=dbd.serverpass();
PreparedStatement pst=null;
    /**
     * Creates new form ColumnChooser
     */
public class ExcelExporter {
    ExcelExporter(){}
    public void exportTable(JTable jTable1,File file) throws IOException{
      TableModel model=jTable1.getModel();
      FileWriter out=new FileWriter(file);
      BufferedWriter bw=new BufferedWriter(out);
      for (int i=0;i<model.getColumnCount();i++){
        bw.write(model.getColumnName(i)+"\t");
      }
      bw.write("\n");
      for (int i=0;i<model.getRowCount();i++){
        for (int j=0;j<model.getColumnCount();j++){
          bw.write(model.getValueAt(i,j).toString()+"\t");
        }
        bw.write("\n");
      }
      bw.close();
      JOptionPane.showMessageDialog(null,"Export File to "+file );
   
    }

}  
    public ColumnChooser() {
        initComponents();
         this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources_7jan\\src\\mainlogo.png"));
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
             pst=conn.prepareStatement("SELECT Department_Name FROM `department_list`");
           
            ResultSet rst1=pst.executeQuery();
            
           while(rst1.next()){
               
              department.addItem(rst1.getString("Department_Name"));
           }
     
                    }
        catch(Exception ex){
        
   
       }//finally{try {pst.close();} catch (SQLException ex) {Logger.getLogger(shift.class.getName()).log(Level.SEVERE, null, ex);}}
        String dep=department.getSelectedItem().toString();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
           
if(dep == "All"){
             PreparedStatement pst2=conn.prepareStatement("SELECT Name FROM `emp_list`");
            ResultSet rst1=pst2.executeQuery();
             DefaultComboBoxModel lqwer = new DefaultComboBoxModel();
       lqwer.insertElementAt("All",0);
            while(rst1.next()){ lqwer.addElement(rst1.getString("Name"));
        employee.setModel(lqwer); 
                       
             
             
             }}else{
           PreparedStatement pst3=conn.prepareStatement("SELECT Name FROM `emp_list` where Department='"+dep+"'");
            ResultSet rst1=pst3.executeQuery();
     
           while(rst1.next()){
              employee.addItem(rst1.getString("Name"));
               }
            
}}
        catch(Exception ex){
        
        } //finally{try {pst.close();} catch (SQLException ex) {Logger.getLogger(shift.class.getName()).log(Level.SEVERE, null, ex);}}
           try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
             pst=conn.prepareStatement("SELECT ID FROM `emp_list` where Department='"+dep+"'");
           if(dep == "All"){
             PreparedStatement pst2=conn.prepareStatement("SELECT ID FROM `emp_list`");
            ResultSet rst1=pst2.executeQuery();
             DefaultComboBoxModel lqwer = new DefaultComboBoxModel();
       lqwer.insertElementAt("All",0);
            while(rst1.next()){ lqwer.addElement(rst1.getString("ID"));
        employeeid.setModel(lqwer); 
                       
             
             
             }}
            ResultSet rst1=pst.executeQuery();
           while(rst1.next()){
            employeeid.addItem(rst1.getString("ID"));
          }}
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

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        from123 = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        to123 = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        ot = new javax.swing.JCheckBox();
        earlyd = new javax.swing.JCheckBox();
        lated = new javax.swing.JCheckBox();
        latehd = new javax.swing.JCheckBox();
        earlyhd = new javax.swing.JCheckBox();
        tax = new javax.swing.JCheckBox();
        leave = new javax.swing.JCheckBox();
        net = new javax.swing.JCheckBox();
        absent = new javax.swing.JCheckBox();
        late = new javax.swing.JCheckBox();
        early = new javax.swing.JCheckBox();
        latehour = new javax.swing.JCheckBox();
        earlyhour = new javax.swing.JCheckBox();
        over = new javax.swing.JCheckBox();
        inover = new javax.swing.JCheckBox();
        salary = new javax.swing.JCheckBox();
        medical = new javax.swing.JCheckBox();
        house = new javax.swing.JCheckBox();
        name = new javax.swing.JCheckBox();
        depart = new javax.swing.JCheckBox();
        desig = new javax.swing.JCheckBox();
        bank = new javax.swing.JCheckBox();
        shift = new javax.swing.JCheckBox();
        date = new javax.swing.JCheckBox();
        days = new javax.swing.JCheckBox();
        present = new javax.swing.JCheckBox();
        dearness = new javax.swing.JCheckBox();
        convence = new javax.swing.JCheckBox();
        yearlyT = new javax.swing.JCheckBox();
        leaveE = new javax.swing.JCheckBox();
        Loan = new javax.swing.JCheckBox();
        Advance = new javax.swing.JCheckBox();
        Holiday = new javax.swing.JCheckBox();
        EOBI = new javax.swing.JCheckBox();
        SESSI = new javax.swing.JCheckBox();
        jLabel25 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        department = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        employeeid = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        employee = new javax.swing.JComboBox<>();

        setType(java.awt.Window.Type.POPUP);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Month Criteria"));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Export");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Select Month");

        to123.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel18.setText("Select End Date");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Generate");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton5.setText("Print");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton5.setBorderPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(from123, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(to123, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(from123, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(to123, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        table.setAutoCreateRowSorter(true);
        table.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ", "Name", "Department", "Salary"
            }
        ));
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        table.setCellSelectionEnabled(true);
        table.setEnabled(false);
        jScrollPane1.setViewportView(table);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Choose Columns"));

        ot.setSelected(true);
        ot.setText("OT Allowance");

        earlyd.setSelected(true);
        earlyd.setText("Early Deduction");
        earlyd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                earlydActionPerformed(evt);
            }
        });

        lated.setSelected(true);
        lated.setText("Late Deduction");
        lated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                latedActionPerformed(evt);
            }
        });

        latehd.setSelected(true);
        latehd.setText("Late Hour Deduction");
        latehd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                latehdActionPerformed(evt);
            }
        });

        earlyhd.setSelected(true);
        earlyhd.setText("Early Hour Deduction");
        earlyhd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                earlyhdActionPerformed(evt);
            }
        });

        tax.setSelected(true);
        tax.setText("Tax");

        leave.setSelected(true);
        leave.setText("Leave");

        net.setSelected(true);
        net.setText("Net Salary");
        net.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                netActionPerformed(evt);
            }
        });

        absent.setSelected(true);
        absent.setText("Absent Day");

        late.setSelected(true);
        late.setText("late Days");

        early.setSelected(true);
        early.setText("Early Days");

        latehour.setSelected(true);
        latehour.setText("Late hour");
        latehour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                latehourActionPerformed(evt);
            }
        });

        earlyhour.setSelected(true);
        earlyhour.setText("Early Hour");

        over.setSelected(true);
        over.setText("Over Time");

        inover.setSelected(true);
        inover.setText("In Overtime");

        salary.setSelected(true);
        salary.setText("Salary");

        medical.setSelected(true);
        medical.setText("Medical");

        house.setSelected(true);
        house.setText("house Rent");
        house.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                houseActionPerformed(evt);
            }
        });

        name.setSelected(true);
        name.setText("Name");

        depart.setSelected(true);
        depart.setText("Department");

        desig.setSelected(true);
        desig.setText("Designation");

        bank.setSelected(true);
        bank.setText("Date Of Joining");
        bank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bankActionPerformed(evt);
            }
        });

        shift.setSelected(true);
        shift.setText("Shift");

        date.setSelected(true);
        date.setText("Date");

        days.setSelected(true);
        days.setText("Days");

        present.setSelected(true);
        present.setText("Present Day");

        dearness.setSelected(true);
        dearness.setText("Dearness");

        convence.setSelected(true);
        convence.setText("Convence");

        yearlyT.setSelected(true);
        yearlyT.setText("yearly Tax");

        leaveE.setSelected(true);
        leaveE.setText("Leave Encash");

        Loan.setSelected(true);
        Loan.setText("Loan");

        Advance.setSelected(true);
        Advance.setText("Advance");

        Holiday.setSelected(true);
        Holiday.setText("Holiday");

        EOBI.setSelected(true);
        EOBI.setText("EOBI");

        SESSI.setSelected(true);
        SESSI.setText("SESSi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tax)
                                .addComponent(net))
                            .addGap(48, 48, 48))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(latehd)
                            .addComponent(salary)
                            .addComponent(house)
                            .addComponent(convence)
                            .addComponent(lated)
                            .addComponent(late)
                            .addComponent(latehour)
                            .addComponent(over)
                            .addComponent(present)
                            .addComponent(bank)
                            .addComponent(depart)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(date)
                            .addComponent(yearlyT)
                            .addComponent(Loan)
                            .addComponent(Holiday))
                        .addGap(42, 42, 42)))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(name, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(absent)
                                    .addComponent(days)))
                            .addComponent(shift)
                            .addComponent(desig))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EOBI)
                            .addComponent(Advance)
                            .addComponent(leaveE)
                            .addComponent(inover)
                            .addComponent(earlyhour)
                            .addComponent(early)
                            .addComponent(ot)
                            .addComponent(dearness)
                            .addComponent(medical)
                            .addComponent(earlyd)
                            .addComponent(leave)
                            .addComponent(earlyhd))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(SESSI)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(depart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bank)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(present)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(late)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(latehour)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(over)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salary)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(house)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(convence)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lated)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(latehd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tax)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(net))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(desig)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(shift)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(days)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(absent)
                        .addGap(3, 3, 3)
                        .addComponent(early)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(earlyhour)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(medical)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dearness)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ot)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(earlyd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(earlyhd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(leave)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearlyT)
                    .addComponent(leaveE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Loan)
                    .addComponent(Advance))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Holiday)
                    .addComponent(EOBI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SESSI)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(252, 126, 1));
        jLabel25.setText("Customise Print");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Employees"));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Department");

        department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Employee ID");

        employeeid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        employeeid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeidActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Employee Name");

        employee.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        employee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(department, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeid, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(10, 10, 10)
                .addComponent(employee, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(employeeid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))))
                    .addComponent(jLabel25))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bankActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bankActionPerformed

    private void latehourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_latehourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_latehourActionPerformed

    private void houseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_houseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_houseActionPerformed

    private void earlydActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_earlydActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_earlydActionPerformed

    private void latedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_latedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_latedActionPerformed

    private void latehdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_latehdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_latehdActionPerformed

    private void earlyhdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_earlyhdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_earlyhdActionPerformed

    private void netActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_netActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_netActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String a1 = "",a2="",a3="",a4="",a5="",a6="",a7="",a8="",a9="",a10="",a12="",a13="",a14="",a15="",a16="",a17="",a18="",a19="",a20="",a21="",a22="",a23="",a24="",a25="",a26="",a27="",a28="",a29="",a30="",a31="",a32="",a33="",a34="",a35="",a36="";
        if(name.isSelected()){a1=",`Name`"; }
        if(depart.isSelected()){a2=",department"; }
        if(desig.isSelected()){a3=",designation"; }if(bank.isSelected()){a4=",bank as 'Date of Joining'"; }if(shift.isSelected()){a5=",Shift"; }
        if(date.isSelected()){a6=",Date"; }if(days.isSelected()){a7=",Days"; }if(present.isSelected()){a8=",PresentDay"; }
        if(absent.isSelected()){a9=",AbsentDay"; }if(late.isSelected()){a10=",LateDay"; }if(early.isSelected()){a12=",EarlyDay"; }
        if(latehour.isSelected()){a13=",late_hour as 'Late Hours'"; }if(earlyhour.isSelected()){a13=",early_hour as 'Early Hours'"; }if(over.isSelected()){a14=",OverTime"; }
        if(inover.isSelected()){a15=",InOverTime"; }if(salary.isSelected()){a16=",salary"; }if(medical.isSelected()){a17=",Medical"; }
        if(house.isSelected()){a18=",HouseRent"; }if(convence.isSelected()){a19=",Convence"; }if(dearness.isSelected()){a20=",Dearness"; }
        if(ot.isSelected()){a21=",OT"; }if(lated.isSelected()){a22=",Late"; }if(earlyd.isSelected()){a23=",Early"; }
        if(latehd.isSelected()){a24=",Late_h as 'LateHours Deduction'"; }if(earlyhd.isSelected()){a25=",early_h as 'EarlyHours Deduction'"; }if(tax.isSelected()){a26=",Tax"; }
        if(leave.isSelected()){a27=", `leave` as 'Leave Allowance'"; }if(net.isSelected()){a28=",Net_Salary "; }
        
           if(yearlyT.isSelected()){a29=",yearly_tax"; }if(leaveE.isSelected()){a30=",leave_encash"; }if(Loan.isSelected()){a31=",loan"; }
        if(Advance.isSelected()){a32=",advance"; }if(Holiday.isSelected()){a33=",holiday"; }if(EOBI.isSelected()){a34=",Eobi"; }
        if(SESSI.isSelected()){a35=", Sessi"; }
    String wer=a1+a2+a3+a4+a5+a6+a7+a8+a9+a10+a12+a13+a14+a15+a16+a17+a18+a19+a20+a21+a22+a23+a24+a25+a26+a27+a29+a30+a31+a32+a33+a34+a35+a28;
        
        
       // String query="Select id'"+a1+"''"+a2+"''"+a3+"''"+a4+"''"+a5+"''"+a6+"''"+a7+"''"+a8+"''"+a9+"''"+a10+"''"+a12+"''"+a13+"''"+a14+"''"+a15+"''"+a16+"''"+a17+"''"+a18+"''"+a19+"''"+a20+"''"+a21+"''"+a22+"''"+a23+"''"+a24+"''"+a25+"''"+a26+"''"+a27+"''"+a28+"' from report";
        
        
table.getTableHeader().setFont( new Font( "Tahoma" , Font.BOLD, 10 ));

        java.util.Date sdate=from123.getDate();
        java.sql.Date fromsql=new java.sql.Date(sdate.getTime());

        
                java.util.Date sdate2=to123.getDate();
        java.sql.Date tosql=new java.sql.Date(sdate2.getTime());
       System.out.println(fromsql+" "+tosql );
        int mont=fromsql.getMonth();

        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,id,pass);

            if(employeeid.getSelectedItem() == "All"){
                ArrayList ar=new ArrayList();
                for(int p=1;p < employeeid.getItemCount();p++){

ar.add("or id="+employeeid.getItemAt(p));}
    String formattedString = ar.toString()
    .replace(",", "")  //remove the commas
    .replace("[", "")  //remove the right bracket
    .replace("]", "") ;    
 
 
    String query2="select id "+wer+"  from report where Date between '"+fromsql+"' and '"+tosql+"' and (id=0 "+formattedString+") ";
    PreparedStatement pst2=con.prepareStatement(query2);
            ResultSet rst2=pst2.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rst2));
   
}else{
        int empid=Integer.parseInt(employeeid.getSelectedItem().toString());


            
            String query="SELECT  id "+wer+"  FROM `report` WHERE (ID='"+empid+"') and Date between '"+fromsql+"' and '"+tosql+"'";
            pst=con.prepareStatement(query);
            ResultSet rst1=pst.executeQuery();
            table.setModel (DbUtils.resultSetToTableModel(rst1));
            }        }

        catch(Exception ex)
        {JOptionPane.showMessageDialog(null,ex.getMessage());}finally{try {pst.close();} catch (SQLException ex) {Logger.getLogger(shift.class.getName()).log(Level.SEVERE, null, ex);}}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void departmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentActionPerformed

        String dep=department.getSelectedItem().toString();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            pst=conn.prepareStatement("SELECT Name FROM `emp_list` where Department='"+dep+"'");
            if(dep == "All"){
                PreparedStatement pst2=conn.prepareStatement("SELECT Name FROM `emp_list`");
                ResultSet rst1=pst2.executeQuery();
                DefaultComboBoxModel lqwer = new DefaultComboBoxModel();
                lqwer.insertElementAt("All",0);
                while(rst1.next()){ lqwer.addElement(rst1.getString("Name"));
                    employee.setModel(lqwer);

                }}

                ResultSet rst1=pst.executeQuery();
                DefaultComboBoxModel listModel = new DefaultComboBoxModel();

                listModel.insertElementAt("All",0);
                while(rst1.next()){
                    listModel.addElement(rst1.getString("Name"));
                    employee.setModel(listModel);
                }
            }catch(Exception E){
                JOptionPane.showMessageDialog(null, "Error combo"+E);}//finally{try {pst.close();} catch (SQLException ex) {Logger.getLogger(shift.class.getName()).log(Level.SEVERE, null, ex);}}
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(url,id,pass);
                pst=conn.prepareStatement("SELECT ID FROM `emp_list` where Department='"+dep+"'");
                if(dep == "All"){
                    PreparedStatement pst2=conn.prepareStatement("SELECT ID FROM `emp_list`");
                    ResultSet rst1=pst2.executeQuery();
                    DefaultComboBoxModel lqwer = new DefaultComboBoxModel();
                    lqwer.insertElementAt("All",0);
                    while(rst1.next()){ lqwer.addElement(rst1.getString("ID"));
                        employeeid.setModel(lqwer);

                    }}
                    ResultSet rst1=pst.executeQuery();
                    DefaultComboBoxModel lqwer = new DefaultComboBoxModel();
                    lqwer.insertElementAt("All",0);

                    while(rst1.next()){

                        lqwer.addElement(rst1.getString("ID"));

                        employeeid.setModel(lqwer);

                    }

                }
                catch(Exception ex){
                    
                }
                //finally{try {pst.close();} catch (SQLException ex) {Logger.getLogger(shift.class.getName()).log(Level.SEVERE, null, ex);}}
    }//GEN-LAST:event_departmentActionPerformed

    private void employeeidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeidActionPerformed
        String s12=employeeid.getSelectedItem().toString();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst2=conn.prepareStatement("SELECT name FROM `emp_list` where ID='"+s12+"'");
            if(s12 == "All"){
                employee.setSelectedItem("All");
            }
            else{           ResultSet rst1=pst2.executeQuery();

                while(rst1.next()){

                    employee.setSelectedItem(rst1.getString("Name"));

                }

            }   }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error combo"+ex);
            }//finally{try {pst.close();} catch (SQLException ex) {Logger.getLogger(shift.class.getName()).log(Level.SEVERE, null, ex);}}
    }//GEN-LAST:event_employeeidActionPerformed

    private void employeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeActionPerformed
        String s122=employee.getSelectedItem().toString();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement   pst2=conn.prepareStatement("SELECT ID FROM `emp_list` where Name='"+s122+"'");
            if(s122 == "All"){
                employeeid.setSelectedItem("All");
            }

            else{ResultSet rst1=pst2.executeQuery();

                while(rst1.next()){

                    employeeid.setSelectedItem(rst1.getString("ID"));

                }

            }   }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error combo"+ex);
            }//finally{try {pst.close();} catch (SQLException ex) {Logger.getLogger(shift.class.getName()).log(Level.SEVERE, null, ex);}}
    }//GEN-LAST:event_employeeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            JFileChooser fileChooser = new JFileChooser();
            int retval = fileChooser.showSaveDialog(jButton1);

            if (retval == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                if (file != null) {
                    if (!file.getName().toLowerCase().endsWith(".xls")) {
                        file = new File(file.getParentFile(), file.getName() + ".xls");

                    }

                    try {
                        ColumnChooser.ExcelExporter exp=new ColumnChooser.ExcelExporter();
                        exp.exportTable(table, file);

                        Desktop.getDesktop().open(file);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        System.out.println("not found");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }catch(Exception e){JOptionPane.showMessageDialog(null,"Error In Export:");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    try {
        table.print();
    } catch (PrinterException ex) {
        Logger.getLogger(ColumnChooser.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton5ActionPerformed
//`Name`, `Department`, `designation`, `bank`, `Shift`, `Date`, `Days`, `PresentDay`, `AbsentDay`, `LateDay`, `EarlyDay`
    //, `late_hour`, `early_hour`, `OverTime`, `InOverTime`, `Salary`, `Medical`, `HouseRent`, `Convence`, `Dearness`, `OT`, `Late`
    //, `Early`, `late_h`, `early_h`, `Tax`, `leave`, `Net_Salary`
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
            java.util.logging.Logger.getLogger(ColumnChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ColumnChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ColumnChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ColumnChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ColumnChooser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Advance;
    private javax.swing.JCheckBox EOBI;
    private javax.swing.JCheckBox Holiday;
    private javax.swing.JCheckBox Loan;
    private javax.swing.JCheckBox SESSI;
    private javax.swing.JCheckBox absent;
    private javax.swing.JCheckBox bank;
    private javax.swing.JCheckBox convence;
    private javax.swing.JCheckBox date;
    private javax.swing.JCheckBox days;
    private javax.swing.JCheckBox dearness;
    private javax.swing.JCheckBox depart;
    private javax.swing.JComboBox<String> department;
    private javax.swing.JCheckBox desig;
    private javax.swing.JCheckBox early;
    private javax.swing.JCheckBox earlyd;
    private javax.swing.JCheckBox earlyhd;
    private javax.swing.JCheckBox earlyhour;
    private javax.swing.JComboBox<String> employee;
    private javax.swing.JComboBox<String> employeeid;
    private com.toedter.calendar.JDateChooser from123;
    private javax.swing.JCheckBox house;
    private javax.swing.JCheckBox inover;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox late;
    private javax.swing.JCheckBox lated;
    private javax.swing.JCheckBox latehd;
    private javax.swing.JCheckBox latehour;
    private javax.swing.JCheckBox leave;
    private javax.swing.JCheckBox leaveE;
    private javax.swing.JCheckBox medical;
    private javax.swing.JCheckBox name;
    private javax.swing.JCheckBox net;
    private javax.swing.JCheckBox ot;
    private javax.swing.JCheckBox over;
    private javax.swing.JCheckBox present;
    private javax.swing.JCheckBox salary;
    private javax.swing.JCheckBox shift;
    private javax.swing.JTable table;
    private javax.swing.JCheckBox tax;
    private com.toedter.calendar.JDateChooser to123;
    private javax.swing.JCheckBox yearlyT;
    // End of variables declaration//GEN-END:variables
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import java.awt.Desktop;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperExportManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRCompiler;
import net.sf.jasperreports.engine.design.JRJdtCompiler;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

//import net.sf.jasperreports.compiler.groovy;


/**
 *
 * @author Mohsin
 */
public class payrollsheet2 extends javax.swing.JInternalFrame {
     dbclass dbd=new dbclass();
          String url=   dbd.server();
      String id=dbd.serverid();
      String pass=dbd.serverpass();
PreparedStatement pst;

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
    
public void SetData(Object obj, int row_index, int col_index){
  table.getModel().setValueAt(obj,row_index,col_index);
  }
   public Object GetData(JTable table, int row_index, int col_index){
  return table.getModel().getValueAt(row_index, col_index); }
    public void reset(){
         try{
      
        }
        
     catch(Exception ex)
     {JOptionPane.showMessageDialog(null,ex.getMessage());}
    finally{try {pst.close();} catch (SQLException ex) {Logger.getLogger(shift.class.getName()).log(Level.SEVERE, null, ex);}}
    }
    /**
     * Creates new form payrollsheet2
     */
    public payrollsheet2() {
        initComponents();



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

        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        from123 = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        to123 = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        department = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        employeeid = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        employee = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Payroll Report");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/mainlogo.png"))); // NOI18N
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel-btn-icon-20.png"))); // NOI18N
        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        table.setAutoCreateRowSorter(true);
        table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        table.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ", "Name", "Department", "Salary"
            }
        ));
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        table.setAutoscrolls(false);
        table.setCellSelectionEnabled(true);
        table.setEnabled(false);
        table.setRowHeight(25);
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 60, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel3);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Month Criteria"));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/export-icon.png"))); // NOI18N
        jButton2.setText("Export");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Select Month:");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calculate-icon.png"))); // NOI18N
        jButton1.setText("Generate");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        to123.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Select End Date:");

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payslip-icon.png"))); // NOI18N
        jButton4.setText("PaySlip");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loan-icon.png"))); // NOI18N
        jButton5.setText("Summary");
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(to123, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(from123, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {from123, to123});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(from123, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(to123, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Employees"));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Department");

        department.setEditable(true);
        department.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Employee ID");

        employeeid.setEditable(true);
        employeeid.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        employeeid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        employeeid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeidActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Employee Name");

        employee.setEditable(true);
        employee.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(252, 126, 1));
        jLabel2.setText("Payroll Report");

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/print-icon.png"))); // NOI18N
        jButton6.setText("Print Setup");
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 145, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

table.getTableHeader().setFont( new Font( "Tahoma" , Font.BOLD, 10 ));

        java.util.Date sdate=from123.getDate();
        java.sql.Date fromsql=new java.sql.Date(sdate.getTime());

        
                java.util.Date sdate2=to123.getDate();
        java.sql.Date tosql=new java.sql.Date(sdate2.getTime());
       System.out.println(fromsql+" "+tosql );
        /*int mont=fromsql.getMonth();
switch(mont){
    case 0:{month.setText("January"); break;}
    case 1:{month.setText("Febraury"); break;}
    case 2:{month.setText("March"); break;}
    case 3:{month.setText("April"); break;}
    case 4:{month.setText("May"); break;}
    case 5:{month.setText("June"); break;}
    case 6:{month.setText("July"); break;}
    case 7:{month.setText("August"); break;}
    case 8:{month.setText("September"); break;}
    case 9:{month.setText("October"); break;}
    case 10:{month.setText("November"); break;}
    case 11:{month.setText("December"); break;}

}*/
        
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
 
 
    String query2="select `ID`, `Name`, `Department`, `Shift`, `Date`, `Days`, `PresentDay`, `AbsentDay`, `LateDay`, `EarlyDay`, `OverTime`, `InOverTime`, `Salary`, `Medical`, `HouseRent`, `Convence`,`leave`, `Dearness`, `OT`, `Late`, `Early`, `Tax`, `yearly_tax` as 'Year Tax', `leave_encash` as 'Leave Encashment', `loan` as 'Loan', `advance` as 'Advance',Eobi,Sessi, `Net_Salary` as 'Net Salary' from report where Date between '"+fromsql+"' and '"+tosql+"' and (id=0 "+formattedString+") ";
    PreparedStatement pst2=con.prepareStatement(query2);
    LocalDate startDate=LocalDate.parse(fromsql.toString());
            LocalDate endDate=LocalDate.parse(tosql.toString());
            final long days = ChronoUnit.DAYS.between(startDate,endDate);
            if(0 <=days-1){
    ResultSet rst2=pst2.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rst2));
            }else{JOptionPane.showMessageDialog(null,"Error: End date is smaller than start date");}
}else{
        int empid=Integer.parseInt(employeeid.getSelectedItem().toString());


            
            String query="SELECT `ID`, `Name`, `Department`, `Shift`, `Date`, `Days`, `PresentDay`, `AbsentDay`, `LateDay`, `EarlyDay`, `OverTime`, `InOverTime`, `Salary`, `Medical`, `HouseRent`, `Convence`,`leave`, `Dearness`, `OT`, `Late`, `Early`, `Tax`, `yearly_tax` as 'Year Tax', `leave_encash` as 'Leave Encashment', `loan` as 'Loan', `advance` as 'Advance',Eobi,Sessi, `Net_Salary` as 'Net Salary' FROM `report` WHERE (ID='"+empid+"') and Date between '"+fromsql+"' and '"+tosql+"'";
            pst=con.prepareStatement(query);
            LocalDate startDate=LocalDate.parse(fromsql.toString());
            LocalDate endDate=LocalDate.parse(tosql.toString());
            final long days = ChronoUnit.DAYS.between(startDate,endDate);
            if(0 <=days-1){
            ResultSet rst1=pst.executeQuery();
            table.setModel (DbUtils.resultSetToTableModel(rst1));}else{JOptionPane.showMessageDialog(null,"Error: End date is smaller than start date");}
            }        }

        catch(Exception ex)
        {JOptionPane.showMessageDialog(null,ex.getMessage());}finally{try {pst.close();} catch (SQLException ex) {Logger.getLogger(shift.class.getName()).log(Level.SEVERE, null, ex);}}
        /*int rows= table.getRowCount();
        for(int i=0;i<rows;i++){
            double tday = Double.parseDouble(GetData(table, i, 5).toString());
            double pday = Double.parseDouble(GetData(table, i, 6).toString());
            double aday = Double.parseDouble(GetData(table, i, 7).toString());
            double lday = Double.parseDouble(GetData(table, i, 8).toString());
            double eday = Double.parseDouble(GetData(table, i, 9).toString());
            double othour = Double.parseDouble(GetData(table, i, 10).toString());
            double inot = Double.parseDouble(GetData(table, i,11).toString());
            double salary = Double.parseDouble(GetData(table, i, 12).toString());
            double medical = Double.parseDouble(GetData(table, i, 13).toString());
            double house = Double.parseDouble(GetData(table, i, 14).toString());
            double convance = Double.parseDouble(GetData(table, i, 15).toString());
            double dearness = Double.parseDouble(GetData(table, i, 16).toString());
            double late = Double.parseDouble(GetData(table, i, 17).toString());
            double  early= Double.parseDouble(GetData(table, i, 18).toString());
            double ot = Double.parseDouble(GetData(table, i, 19).toString());
            double  tax= Double.parseDouble(GetData(table, i, 20).toString());

            //Calculation
            double tot2=(othour+inot)*ot;
            double tot=salary+medical+house+convance+dearness+tot2-tax;

            double tot4=lday*late;
            double tot5=eday*early;
            double tot3=(tot/tday)*pday-tot4-tot5;
            int tot7=(int)tot3;
            table.setValueAt(tot7, i, 21);
            //calculation END 
    }*/

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
                        payrollsheet2.ExcelExporter exp=new payrollsheet2.ExcelExporter();
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
 String reportDest = "D:\\report1.pdf";
        try{    java.util.Date sdate=from123.getDate();
        java.sql.Date fromsql=new java.sql.Date(sdate.getTime());
java.util.Date sdate2=to123.getDate();
        java.sql.Date tosql=new java.sql.Date(sdate2.getTime());
        LocalDate startDate=LocalDate.parse(fromsql.toString());
            LocalDate endDate=LocalDate.parse(tosql.toString());
            final long days = ChronoUnit.DAYS.between(startDate,endDate);
            if(0 <=days-1){      
        
        if(employeeid.getSelectedItem() == "All"){
                ArrayList ar=new ArrayList();
                for(int p=1;p < employeeid.getItemCount();p++){

ar.add("or a.ID="+employeeid.getItemAt(p));}
    String formattedString = ar.toString()
    .replace(",", "")  //remove the commas
    .replace("[", "")  //remove the right bracket
    .replace("]", "") ;    

   InputStream is1 = getClass().getResourceAsStream("payslip.jrxml");
   
JasperDesign jd=JRXmlLoader.load(is1);

String sql="SELECT a.`ID`, a.`Name`, a.`Department`, a.`designation`, a.`bank`, a.`Shift`, a.`Date`, a.`Days`, a.`PresentDay`, a.`AbsentDay`, a.`LateDay`, a.`EarlyDay`, a.`late_hour`, a.`early_hour`, a.`OverTime`, a.`InOverTime`, a.`Salary`, a.`Medical`, a.`HouseRent`, a.`Convence`, a.`Dearness`, a.`OT`, a.`Late`, a.`Early`, a.`late_h`, a.`early_h`, a.`Tax`, a.`leave`, a.`yearly_tax`, a.`leave_encash`, a.`loan`, a.`advance`, a.`holiday`, a.`Eobi`, a.`Sessi`, a.`Net_Salary`,c.name as 'companyname',c.logo,c.address from report a,companyinfo c WHERE  a.Date between '"+fromsql+"' and '"+tosql+"' and (a.ID=0 "+formattedString+")";
JRDesignQuery newQuery=new JRDesignQuery();
newQuery.setText(sql);
jd.setQuery(newQuery);

JasperReport jr=JasperCompileManager.compileReport(jd);
        Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            JasperPrint jp=JasperFillManager.fillReport(jr,null,conn);
    //       JasperViewer.viewReport(jp,false);
//            File pdf = new File(reportDest);
  //          JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(pdf));
            JasperViewer jv = new JasperViewer( jp, false );
jv.viewReport( jp,false);
            
                }//C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources_7jan\\src\\payslip.jrxml
else{//java.net.URL url = new java.net.URL("D:/qw/payslip.jrxml"); 
                  InputStream  is2 = getClass().getResourceAsStream("payslip.jrxml");
                   
JasperDesign jd=JRXmlLoader.load(is2);
        int empid=Integer.parseInt(employeeid.getSelectedItem().toString());
String sql="SELECT a.`ID`, a.`Name`, a.`Department`, a.`designation`, a.`bank`, a.`Shift`, a.`Date`, a.`Days`, a.`PresentDay`, a.`AbsentDay`, a.`LateDay`, a.`EarlyDay`, a.`late_hour`, a.`early_hour`, a.`OverTime`, a.`InOverTime`, a.`Salary`, a.`Medical`, a.`HouseRent`, a.`Convence`, a.`Dearness`, a.`OT`, a.`Late`, a.`Early`, a.`late_h`, a.`early_h`, a.`Tax`, a.`leave`, a.`yearly_tax`, a.`leave_encash`, a.`loan`, a.`advance`, a.`holiday`, a.`Eobi`, a.`Sessi`, a.`Net_Salary`,c.name as 'companyname',c.logo,c.address from report a,companyinfo c WHERE (a.ID='"+empid+"') and a.Date between '"+fromsql+"' and '"+tosql+"'";
JRDesignQuery newQuery=new JRDesignQuery();
newQuery.setText(sql);
jd.setQuery(newQuery);  
            
//String report="C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources\\src\\report1.jrxml";       
JasperReport jr=JasperCompileManager.compileReport(jd);
        Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            JasperPrint jp=JasperFillManager.fillReport(jr,null,conn);
        //    File pdf = new File(reportDest);
//            JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(pdf));
  //         JasperViewer.viewReport(jp);
              JasperViewer jv = new JasperViewer( jp, false );
jv.viewReport( jp,false);
                }
            
            }else{JOptionPane.showMessageDialog(null,"Error: End date is smaller than start date");}
            
            
            
}catch(Exception e){JOptionPane.showMessageDialog(null, e);}
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
ColumnChooser w=new ColumnChooser();
w.setVisible(true);
    
        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    
     
    }//GEN-LAST:event_formMouseClicked

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
       
    }//GEN-LAST:event_formInternalFrameClosed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
table.getTableHeader().setFont( new Font( "Tahoma" , Font.BOLD, 10 ));

        java.util.Date sdate=from123.getDate();
        java.sql.Date fromsql=new java.sql.Date(sdate.getTime());

        
                java.util.Date sdate2=to123.getDate();
        java.sql.Date tosql=new java.sql.Date(sdate2.getTime());
       System.out.println(fromsql+" "+tosql );
        /*int mont=fromsql.getMonth();
switch(mont){
    case 0:{month.setText("January"); break;}
    case 1:{month.setText("Febraury"); break;}
    case 2:{month.setText("March"); break;}
    case 3:{month.setText("April"); break;}
    case 4:{month.setText("May"); break;}
    case 5:{month.setText("June"); break;}
    case 6:{month.setText("July"); break;}
    case 7:{month.setText("August"); break;}
    case 8:{month.setText("September"); break;}
    case 9:{month.setText("October"); break;}
    case 10:{month.setText("November"); break;}
    case 11:{month.setText("December"); break;}

}*/
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,id,pass);

            String query="SELECT `Department`, sum(`Salary`) as 'Gross Salary',sum(Net_Salary)-sum(`OverTime`*`OT`) as 'Salary Payable',sum(`OverTime`*`OT`) as 'OverTime',sum(`Dearness`) as 'Previous OT',sum(`Net_Salary`) as 'Net Payable' FROM `report` where Date ='"+fromsql+"' group by `Department` UNION SELECT 'Total', sum(`Salary`) as 'Gross Salary',sum(Net_Salary)-sum(`OverTime`*`OT`) as 'Salary Payable',sum(`OverTime`*`OT`) as 'OverTime',sum(`Dearness`) as 'Previous OT',sum(Net_Salary) as 'Net Payable' FROM `report` where Date ='"+fromsql+"' and Net_Salary > 0";
            pst=con.prepareStatement(query);
            LocalDate startDate=LocalDate.parse(fromsql.toString());
            LocalDate endDate=LocalDate.parse(tosql.toString());
            final long days = ChronoUnit.DAYS.between(startDate,endDate);
            if(0 <=days-1){
            ResultSet rst1=pst.executeQuery();
            table.setModel (DbUtils.resultSetToTableModel(rst1));}else{JOptionPane.showMessageDialog(null,"Error: End date is smaller than start date");}
            }        

        catch(Exception ex)
        {JOptionPane.showMessageDialog(null,ex.getMessage());}finally{try {pst.close();} catch (SQLException ex) {Logger.getLogger(shift.class.getName()).log(Level.SEVERE, null, ex);}}
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> department;
    private javax.swing.JComboBox<String> employee;
    private javax.swing.JComboBox<String> employeeid;
    private com.toedter.calendar.JDateChooser from123;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    private com.toedter.calendar.JDateChooser to123;
    // End of variables declaration//GEN-END:variables
}

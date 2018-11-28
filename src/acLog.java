 
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.util.Calendar;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
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
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRCompiler;
import net.sf.jasperreports.engine.design.JRJdtCompiler;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/*
/**
 *
 * @author Mohsin
 */
public class acLog extends javax.swing.JInternalFrame {
     dbclass dbd=new dbclass();
          String url=   dbd.server();
      String id=dbd.serverid();
      String pass=dbd.serverpass();
    public void SetData(Object obj, int row_index, int col_index){
  Report1.getModel().setValueAt(obj,row_index,col_index);
  }
   public Object GetData(JTable table, int row_index, int col_index){
  return table.getModel().getValueAt(row_index, col_index); }
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

}//PreparedStatement pst=null,pst2=null,pst3=null,pst4=null,pst5=null,pst6=null,pst7=null,pst8=null,pst9=null;
/**
     * Creates new form payroll
     */

    public acLog() {
        initComponents();
       
        try{
         
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
        String query="select ID,Name from emp_list";
       PreparedStatement pst=con.prepareStatement(query);
        ResultSet rst1=pst.executeQuery();
        table21.setModel (DbUtils.resultSetToTableModel(rst1));
       }
         catch(Exception ex)
         {JOptionPane.showMessageDialog(null,ex.getMessage());}//finally{try {pst.close();} catch (SQLException ex) {Logger.getLogger(shift.class.getName()).log(Level.SEVERE, null, ex);}}
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst=conn.prepareStatement("SELECT Department_Name FROM `department_list`");
           
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
           PreparedStatement pst=conn.prepareStatement("SELECT Name FROM `emp_list` where Department='"+dep+"'");
if(dep == "All"){
             PreparedStatement pst2=conn.prepareStatement("SELECT Name FROM `emp_list`");
            ResultSet rst1=pst2.executeQuery();
             DefaultComboBoxModel lqwer = new DefaultComboBoxModel();
       lqwer.insertElementAt("All",0);
            while(rst1.next()){ lqwer.addElement(rst1.getString("Name"));
        employee.setModel(lqwer); 
                       
             
             
             }}
           
            ResultSet rst1=pst.executeQuery();
     
           while(rst1.next()){
              employee.addItem(rst1.getString("Name"));
               }
            
                    }
        catch(Exception ex){
        
        } //finally{try {pst.close();} catch (SQLException ex) {Logger.getLogger(shift.class.getName()).log(Level.SEVERE, null, ex);}}
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
        employeeid.setModel(lqwer); 
                       
             
             
             }}
            ResultSet rst1=pst.executeQuery();
           while(rst1.next()){
            employeeid.addItem(rst1.getString("ID"));
          
          
           }
     
                    }
        catch(Exception ex){
        
        }  //finally{try {pst.close();} catch (SQLException ex) {Logger.getLogger(shift.class.getName()).log(Level.SEVERE, null, ex);}}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table21 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        department = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        employeeid = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        employee = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        from123 = new com.toedter.calendar.JDateChooser();
        generate1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        to123 = new com.toedter.calendar.JDateChooser();
        genReport = new javax.swing.JRadioButton();
        aLL = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Report1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Attendance Report");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/mainlogo.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        table21.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(table21);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel-btn-icon-20.png"))); // NOI18N
        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Employees"));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Department:");

        department.setEditable(true);
        department.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Employee ID:");

        employeeid.setEditable(true);
        employeeid.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        employeeid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        employeeid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeidActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Employee Name:");

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
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(employee, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(department, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(employeeid, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel4, jLabel5});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {department, employee, employeeid});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(employeeid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel3, jLabel4, jLabel5});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {department, employee, employeeid});

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Date Criteria"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Select Start Date:");

        from123.setBackground(new java.awt.Color(0, 0, 0));
        from123.setForeground(new java.awt.Color(255, 255, 255));

        generate1.setBackground(new java.awt.Color(255, 255, 255));
        generate1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        generate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calculate-icon.png"))); // NOI18N
        generate1.setText("Generate");
        generate1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                generate1MouseClicked(evt);
            }
        });
        generate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generate1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/export-icon.png"))); // NOI18N
        jButton1.setText("Export");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Select End Date:");

        to123.setBackground(new java.awt.Color(0, 0, 0));
        to123.setForeground(new java.awt.Color(255, 255, 255));

        buttonGroup1.add(genReport);
        genReport.setSelected(true);
        genReport.setText("Attendance Log");
        genReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genReportActionPerformed(evt);
            }
        });

        buttonGroup1.add(aLL);
        aLL.setText("Checkin & Out ");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel-btn-icon-20.png"))); // NOI18N
        jButton3.setText("Delete Record");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(generate1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(from123, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(to123, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(aLL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(genReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {from123, to123});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(from123, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(aLL))
                .addGap(8, 8, 8)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel18)
                        .addComponent(to123, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(genReport))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {from123, to123});

        jScrollPane2.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        Report1.setAutoCreateRowSorter(true);
        Report1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Report1.setEditingColumn(0);
        Report1.setEditingRow(0);
        Report1.setIntercellSpacing(new java.awt.Dimension(1, 2));
        Report1.setSelectionBackground(new java.awt.Color(252, 126, 1));
        jScrollPane1.setViewportView(Report1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 718, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 236, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel2);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(252, 126, 1));
        jLabel2.setText("Attendance Log");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(698, 698, 698)
                        .addComponent(jButton2)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 789, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void departmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentActionPerformed

        String dep=department.getSelectedItem().toString();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst=conn.prepareStatement("SELECT Name FROM `emp_list` where Department='"+dep+"'");
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
               PreparedStatement pst=conn.prepareStatement("SELECT ID FROM `emp_list` where Department='"+dep+"'");
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

    private void employeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeActionPerformed
        String s12=employee.getSelectedItem().toString();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
         PreparedStatement   pst=conn.prepareStatement("SELECT ID FROM `emp_list` where Name='"+s12+"'");
if(s12 == "All"){
employeeid.setSelectedItem("All");
}

else{ResultSet rst1=pst.executeQuery();

            while(rst1.next()){

                employeeid.setSelectedItem(rst1.getString("ID"));

            }

}   }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error combo"+ex);
        }//finally{try {pst.close();} catch (SQLException ex) {Logger.getLogger(shift.class.getName()).log(Level.SEVERE, null, ex);}}
    }//GEN-LAST:event_employeeActionPerformed

    private void employeeidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeidActionPerformed
        String s12=employeeid.getSelectedItem().toString();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
           PreparedStatement pst=conn.prepareStatement("SELECT name FROM `emp_list` where ID='"+s12+"'");
if(s12 == "All"){
employee.setSelectedItem("All");
}
else{           ResultSet rst1=pst.executeQuery();

            while(rst1.next()){

                employee.setSelectedItem(rst1.getString("Name"));

            }

}   }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error combo"+ex);
        }//finally{try {pst.close();} catch (SQLException ex) {Logger.getLogger(shift.class.getName()).log(Level.SEVERE, null, ex);}}
    }//GEN-LAST:event_employeeidActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
                        acLog.ExcelExporter exp=new acLog.ExcelExporter();
                        exp.exportTable(Report1, file);

                        java.awt.Desktop.getDesktop().open(file);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        System.out.println("File not found");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }catch(Exception e){JOptionPane.showMessageDialog(null,"Error In Export:");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void generate1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generate1MouseClicked

    }//GEN-LAST:event_generate1MouseClicked

    private void generate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generate1ActionPerformed
//select a.`ID`, a.`Name`, a.`Department`, a.`Shift`, a.`Date`, a.`Total_Day`, a.`PresentDay`, a.`AbsentDay`, a.`LateDay`, a.`EarlyDay`, a.`OT`, a.`InOT`, a.`TotalTime`, a.`TotalLate`, a.`TotalEarly`, a.`TotalOT`, a.`TotalinOT`, a.`NET_Salary`, a.`Late_Exceed`, a.`Early_Exceed`, a.`loanins`, a.`advance`, a.`leavey`, a.`taxy`, a.`totalShiftTime`,b.department as 'depart',b.designation,c.name as 'companyname',c.logo,c.address from attendancemonth a,emp_list b,companyinfo c  where a.id=b.id and (a.ID=0 "+formattedString+") and a.Date between '"+fromsql+"' and '"+tosql+"'  order by b.Department
  
if(genReport.isSelected()){
Report1.getTableHeader().setFont( new Font( "Time New Roman" , Font.BOLD, 14 ));


        java.util.Date sdate=from123.getDate();
        java.sql.Date fromsql=new java.sql.Date(sdate.getTime());
        
                java.util.Date sdate2=to123.getDate();
        java.sql.Date tosql=new java.sql.Date(sdate2.getTime());
       
        String emp=employee.getSelectedItem().toString();
        
        
        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,id,pass);
            if(employeeid.getSelectedItem() == "All"){
                ArrayList ar=new ArrayList();ArrayList bar=new ArrayList();
                for(int p=1;p < employeeid.getItemCount();p++){

ar.add("or a.id="+employeeid.getItemAt(p));bar.add("or emp_id="+employeeid.getItemAt(p));}
    String formattedString = ar.toString()
    .replace(",", "")  //remove the commas
    .replace("[", "")  //remove the right bracket
    .replace("]", "") ;    
    
    String formattedString2 = bar.toString()
    .replace(",", "")  //remove the commas
    .replace("[", "")  //remove the right bracket
    .replace("]", "") ;   
 
 
    String query2="select a.`ID`, b.`Name`,b.department as 'Depart',b.designation,a.date,a.time,a.manual_attendance from attendance a,emp_list b  where a.id=b.id and (a.ID=0 "+formattedString+") and a.Date between '"+fromsql+"' and '"+tosql+"' " ;
    PreparedStatement pst2=con.prepareStatement(query2);
            ResultSet rst2=pst2.executeQuery();
            Report1.setModel(DbUtils.resultSetToTableModel(rst2));
   
}else{
        int empid=Integer.parseInt(employeeid.getSelectedItem().toString());
            String query="select a.`ID`, b.`Name`,b.department as 'Depart',b.designation,a.date,a.time,a.manual_attendance from attendance a,emp_list b  where a.id=b.id and a.ID='"+empid+"' and a.Date between '"+fromsql+"' and '"+tosql+"' " ;
            PreparedStatement pst=con.prepareStatement(query);
            ResultSet rst1=pst.executeQuery();
            Report1.setModel (DbUtils.resultSetToTableModel(rst1));
                    
            }
        }catch(Exception e ){}

}  



if(aLL.isSelected()){


Report1.getTableHeader().setFont( new Font( "Time New Roman" , Font.BOLD, 14 ));


        java.util.Date sdate=from123.getDate();
        java.sql.Date fromsql=new java.sql.Date(sdate.getTime());
        
                java.util.Date sdate2=to123.getDate();
        java.sql.Date tosql=new java.sql.Date(sdate2.getTime());
       
        String emp=employee.getSelectedItem().toString();
        
        
        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,id,pass);
            if(employeeid.getSelectedItem() == "All"){
                ArrayList ar=new ArrayList();ArrayList bar=new ArrayList();ArrayList bart=new ArrayList();
                for(int p=1;p < employeeid.getItemCount();p++){

ar.add("or id="+employeeid.getItemAt(p));bar.add("or emp_id="+employeeid.getItemAt(p));bart.add("or User_ID="+employeeid.getItemAt(p));}
    String formattedString = ar.toString()
    .replace(",", "")  //remove the commas
    .replace("[", "")  //remove the right bracket
    .replace("]", "") ;    
    
    String formattedString2 = bar.toString()
    .replace(",", "")  //remove the commas
    .replace("[", "")  //remove the right bracket
    .replace("]", "") ;   
   String formattedString3 = bart.toString()
    .replace(",", "")  //remove the commas
    .replace("[", "")  //remove the right bracket
    .replace("]", "") ;   
 
    String query2="SELECT `ID` , `Name` , Concat(`Shift`,'-', `InTime`,' to ', `OutTime`) as 'Shift Timings' , `Date` , `checkintime` , `checkouttime`  from calculation  where (Date between '"+fromsql+"' and '"+tosql+"') and (ID=0 "+formattedString+") ";
    PreparedStatement pst2=con.prepareStatement(query2);
            ResultSet rst2=pst2.executeQuery();
            Report1.setModel(DbUtils.resultSetToTableModel(rst2));
   
}else{
        int empid=Integer.parseInt(employeeid.getSelectedItem().toString());
            String query="SELECT `ID` , `Name` , Concat(`Shift`,'-', `InTime`,' to ', `OutTime`) as 'Shift Timings' , `Date` , `checkintime` , `checkouttime`  from calculation  WHERE (Date between '"+fromsql+"' and '"+tosql+"') and (ID='"+empid+"')";
            PreparedStatement pst=con.prepareStatement(query);
            ResultSet rst1=pst.executeQuery();
            Report1.setModel (DbUtils.resultSetToTableModel(rst1));
                    
            }
                    
         
//int k=st2.executeUpdate("Replace into statistic _report(id,name,date,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31) values ()");
       
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);}}
    }//GEN-LAST:event_generate1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
 DefaultTableModel model = (DefaultTableModel)Report1.getModel();

        // get the selected row index
        int selectedRowIndex = Report1.getSelectedRow();

        // set the selected row data into jtextfields
        String idd=(model.getValueAt(selectedRowIndex, 0).toString());
        String name=(model.getValueAt(selectedRowIndex, 1).toString());
        String date=(model.getValueAt(selectedRowIndex, 4).toString());
        String timei=(model.getValueAt(selectedRowIndex, 5).toString());
   //  String timeo=(model.getValueAt(selectedRowIndex, 5).toString());
             try
        {

            String query ="DELETE FROM `calculation` WHERE id='"+idd+"' and name ='"+name+"' and date ='"+date+"' and checkintime='"+timei+"' or checkouttime='"+timei+"' ";
            String query2 ="DELETE FROM `attendance` WHERE id='"+idd+"' and Date ='"+date+"' and time='"+timei+"'  ";
             
            Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

            Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

            PreparedStatement pst= con.prepareStatement(query);                             // Create statement
            pst.executeUpdate();
            PreparedStatement pst2= con.prepareStatement(query2);                             // Create statement
            pst2.executeUpdate();
            
         JOptionPane.showMessageDialog(null,"delete successfull");
        }catch(Exception e){}

    }//GEN-LAST:event_jButton3ActionPerformed

    private void genReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genReportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genReportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Report1;
    private javax.swing.JRadioButton aLL;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> department;
    private javax.swing.JComboBox<String> employee;
    private javax.swing.JComboBox<String> employeeid;
    private com.toedter.calendar.JDateChooser from123;
    private javax.swing.JRadioButton genReport;
    private javax.swing.JButton generate1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable table21;
    private com.toedter.calendar.JDateChooser to123;
    // End of variables declaration//GEN-END:variables
}

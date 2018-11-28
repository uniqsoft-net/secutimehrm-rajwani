 
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
public class payroll extends javax.swing.JInternalFrame {
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

    public payroll() {
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
        jButton3 = new javax.swing.JButton();
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
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Report1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        laT = new javax.swing.JRadioButton();
        eaR = new javax.swing.JRadioButton();
        oT = new javax.swing.JRadioButton();
        inOT = new javax.swing.JRadioButton();
        aBS = new javax.swing.JRadioButton();
        hOL = new javax.swing.JRadioButton();
        lEA = new javax.swing.JRadioButton();
        aLL = new javax.swing.JRadioButton();
        genReport = new javax.swing.JRadioButton();

        jButton3.setText("jButton3");

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
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Criteria"));

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
        jButton1.setText("Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Select End Date:");

        to123.setBackground(new java.awt.Color(0, 0, 0));
        to123.setForeground(new java.awt.Color(255, 255, 255));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payslip-icon.png"))); // NOI18N
        jButton4.setText("Muster");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payslip-icon.png"))); // NOI18N
        jButton5.setText("Report");
        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/manual-attnd.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leave-mgm.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(from123, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(to123, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(generate1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(from123, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18)
                            .addComponent(to123, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton6)
                            .addComponent(jButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generate1)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1503, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 220, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel2);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(252, 126, 1));
        jLabel2.setText("Attendance Report");

        buttonGroup1.add(laT);
        laT.setText("Late");

        buttonGroup1.add(eaR);
        eaR.setText("Early");

        buttonGroup1.add(oT);
        oT.setText("OverTime");
        oT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oTActionPerformed(evt);
            }
        });

        buttonGroup1.add(inOT);
        inOT.setText("In overtime");

        buttonGroup1.add(aBS);
        aBS.setText("Absents");

        buttonGroup1.add(hOL);
        hOL.setText("Holidays");

        buttonGroup1.add(lEA);
        lEA.setText("Leave");

        buttonGroup1.add(aLL);
        aLL.setSelected(true);
        aLL.setText("All");

        buttonGroup1.add(genReport);
        genReport.setText("General Report");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(aLL)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(genReport))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(136, 136, 136)
                                        .addComponent(laT)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(eaR)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(oT)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(inOT, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(aBS)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(hOL)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lEA)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(698, 698, 698)
                                .addComponent(jButton2)))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 477, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(laT)
                            .addComponent(eaR)
                            .addComponent(oT)
                            .addComponent(inOT)
                            .addComponent(aBS)
                            .addComponent(hOL)
                            .addComponent(lEA)
                            .addComponent(aLL)
                            .addComponent(genReport))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 789, Short.MAX_VALUE)
                .addGap(0, 0, 0))
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
                        payroll.ExcelExporter exp=new payroll.ExcelExporter();
                        exp.exportTable(Report1, file);

                        java.awt.Desktop.getDesktop().open(file);
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

    }//GEN-LAST:event_jButton1ActionPerformed

    private void generate1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generate1MouseClicked

    }//GEN-LAST:event_generate1MouseClicked

    private void generate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generate1ActionPerformed
//select a.`ID`, a.`Name`, a.`Department`, a.`Shift`, a.`Date`, a.`Total_Day`, a.`PresentDay`, a.`AbsentDay`, a.`LateDay`, a.`EarlyDay`, a.`OT`, a.`InOT`, a.`TotalTime`, a.`TotalLate`, a.`TotalEarly`, a.`TotalOT`, a.`TotalinOT`, a.`NET_Salary`, a.`Late_Exceed`, a.`Early_Exceed`, a.`loanins`, a.`advance`, a.`leavey`, a.`taxy`, a.`totalShiftTime`,b.department as 'depart',b.designation,c.name as 'companyname',c.logo,c.address from attendancemonth a,emp_list b,companyinfo c  where a.id=b.id and (a.ID=0 "+formattedString+") and a.Date between '"+fromsql+"' and '"+tosql+"'  order by b.Department
   if(lEA.isSelected()){
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

ar.add("or a.emp_ID="+employeeid.getItemAt(p));bar.add("or emp_id="+employeeid.getItemAt(p));}
    String formattedString = ar.toString()
    .replace(",", "")  //remove the commas
    .replace("[", "")  //remove the right bracket
    .replace("]", "") ;    
    
    String formattedString2 = bar.toString()
    .replace(",", "")  //remove the commas
    .replace("[", "")  //remove the right bracket
    .replace("]", "") ;   
 
 
    String query2="SELECT c.emp_ID as 'ID',d.Name,d.Department,d.Designation,c.date as 'Date',c.leave_name as 'Leave Name',c.Reason\n" +
" FROM companyinfo v,emp_list d, leave_employee c where (c.emp_ID=0 "+formattedString+") and c.Date between '"+fromsql+"' and '"+tosql+"' and  c.emp_ID=d.ID" ;
    PreparedStatement pst2=con.prepareStatement(query2);
            ResultSet rst2=pst2.executeQuery();
            Report1.setModel(DbUtils.resultSetToTableModel(rst2));
   
}else{
        int empid=Integer.parseInt(employeeid.getSelectedItem().toString());
            String query="SELECT c.emp_ID as 'ID',d.Name,d.Department,d.Designation,c.date as 'Date',c.leave_name  as 'Leave Name',c.Reason\n" +
" FROM companyinfo v,emp_list d, leave_employee c where d.id=c.emp_id and c.emp_ID='"+empid+"' and c.Date between '"+fromsql+"' and '"+tosql+"'  " ;
            PreparedStatement pst=con.prepareStatement(query);
            ResultSet rst1=pst.executeQuery();
            Report1.setModel (DbUtils.resultSetToTableModel(rst1));
                    
            }
        }catch(Exception e ){}

}  

if(hOL.isSelected()){
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
 
 
    String query2="SELECT c.emp_ID as 'ID',d.Name,d.Department,d.Designation,c.date as 'Date',c.holiday_name  as 'Holiday Name',c.description\n" +
" FROM companyinfo v,emp_list d, holiday_employee c where (c.emp_ID=0 "+formattedString2+") and c.Date between '"+fromsql+"' and '"+tosql+"' and  c.emp_ID=d.ID" ;
    PreparedStatement pst2=con.prepareStatement(query2);
            ResultSet rst2=pst2.executeQuery();
            Report1.setModel(DbUtils.resultSetToTableModel(rst2));
   
}else{
        int empid=Integer.parseInt(employeeid.getSelectedItem().toString());
            String query="SELECT c.emp_ID as 'ID',d.Name,d.Department,d.Designation,c.date as 'Date',c.holiday_name  as 'Holiday Name',c.description\n" +
" FROM companyinfo v,emp_list d, holiday_employee c where c.emp_ID='"+empid+"' and c.Date between '"+fromsql+"' and '"+tosql+"' and  c.emp_ID=d.ID" ;
            PreparedStatement pst=con.prepareStatement(query);
            ResultSet rst1=pst.executeQuery();
            Report1.setModel (DbUtils.resultSetToTableModel(rst1));
                    
            }
        }catch(Exception e ){}

}  

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
 
 
    String query2="select a.`ID`, a.`Name`,b.department as 'Depart',b.designation, a.`Shift`, a.`Date`, a.`Total_Day`, a.`PresentDay`, a.`AbsentDay`, a.`Department` as 'Leave', a.`LateDay`, a.`EarlyDay`, a.`OT`, a.`InOT`, a.`totalShiftTime`, a.`TotalTime`, a.`TotalLate`, a.`TotalEarly`, a.`TotalOT`, a.`TotalinOT`, a.`NET_Salary` as 'Holiday', a.`Late_Exceed`, a.`Early_Exceed`,  a.`leavey` from attendancemonth a,emp_list b  where a.id=b.id and (a.ID=0 "+formattedString+") and a.Date between '"+fromsql+"' and '"+tosql+"'  order by b.Department" ;
    PreparedStatement pst2=con.prepareStatement(query2);
            ResultSet rst2=pst2.executeQuery();
            Report1.setModel(DbUtils.resultSetToTableModel(rst2));
   
}else{
        int empid=Integer.parseInt(employeeid.getSelectedItem().toString());
            String query="select a.`ID`, a.`Name`,b.department as 'Depart',b.designation, a.`Shift`, a.`Date`, a.`Total_Day`, a.`PresentDay`, a.`AbsentDay`, a.`Department` as 'Leave', a.`LateDay`, a.`EarlyDay`, a.`OT`, a.`InOT`, a.`totalShiftTime`, a.`TotalTime`, a.`TotalLate`, a.`TotalEarly`, a.`TotalOT`, a.`TotalinOT`, a.`NET_Salary` as 'Holiday', a.`Late_Exceed`, a.`Early_Exceed`,  a.`leavey` from attendancemonth a,emp_list b  where a.id=b.id and a.ID='"+empid+"' and a.Date between '"+fromsql+"' and '"+tosql+"'  order by b.Department" ;
            PreparedStatement pst=con.prepareStatement(query);
            ResultSet rst1=pst.executeQuery();
            Report1.setModel (DbUtils.resultSetToTableModel(rst1));
                    
            }
        }catch(Exception e ){}

}  


if(laT.isSelected()){
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
 
 
    String query2="SELECT a.`ID` , a.`Name` ,b.Department,b.Designation, Concat(a.`Shift`,'-', a.`InTime`,' to ', a.`OutTime`) as 'Shift Timings' ,a.`Date` , a.`checkintime` , a.`checkouttime` , a.`Total` , a.`Late` , a.`Early` , a.`OT` , a.`InOT` , a.`Late_Exceed` , a.`Early_Exceed`,'Status','Symbol' from calculation a,emp_list b  where (a.Date between '"+fromsql+"' and '"+tosql+"') and (a.ID=0 "+formattedString+") and a.`Late` > '00:00:00' and a.ID= b.ID  order by date";
    PreparedStatement pst2=con.prepareStatement(query2);
            ResultSet rst2=pst2.executeQuery();
            Report1.setModel(DbUtils.resultSetToTableModel(rst2));
   
}else{
        int empid=Integer.parseInt(employeeid.getSelectedItem().toString());
            String query="SELECT a.`ID` , a.`Name` ,b.Department,b.Designation, Concat(a.`Shift`,'-', a.`InTime`,' to ', a.`OutTime`) as 'Shift Timings' ,a.`Date` , a.`checkintime` , a.`checkouttime` , a.`Total` , a.`Late` , a.`Early` , a.`OT` , a.`InOT` , a.`Late_Exceed` , a.`Early_Exceed`,'Status','Symbol' from calculation a,emp_list b  where (a.Date between '"+fromsql+"' and '"+tosql+"') and a.ID= "+empid+" and a.`Late` > '00:00:00' and a.ID= b.ID  order by date";
            PreparedStatement pst=con.prepareStatement(query);
            ResultSet rst1=pst.executeQuery();
            Report1.setModel (DbUtils.resultSetToTableModel(rst1));
                    
            }
        }catch(Exception e ){}

}
if(eaR.isSelected()){
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
 
 
    String query2="SELECT a.`ID` , a.`Name` ,b.Department,b.Designation, Concat(a.`Shift`,'-', a.`InTime`,' to ', a.`OutTime`) as 'Shift Timings' ,a.`Date` , a.`checkintime` , a.`checkouttime` , a.`Total` , a.`Late` , a.`Early` , a.`OT` , a.`InOT` , a.`Late_Exceed` , a.`Early_Exceed`,'Status','Symbol' from calculation a,emp_list b  where (a.Date between '"+fromsql+"' and '"+tosql+"') and (a.ID=0 "+formattedString+") and a.`Early` > '00:00:00' and a.ID= b.ID";
    PreparedStatement pst2=con.prepareStatement(query2);
            ResultSet rst2=pst2.executeQuery();
            Report1.setModel(DbUtils.resultSetToTableModel(rst2));
   
}else{
        int empid=Integer.parseInt(employeeid.getSelectedItem().toString());
            String query="SELECT a.`ID` , a.`Name` ,b.Department,b.Designation, Concat(a.`Shift`,'-', a.`InTime`,' to ', a.`OutTime`) as 'Shift Timings' ,a.`Date` , a.`checkintime` , a.`checkouttime` , a.`Total` , a.`Late` , a.`Early` , a.`OT` , a.`InOT` , a.`Late_Exceed` , a.`Early_Exceed`,'Status','Symbol' from calculation a,emp_list b  where (a.Date between '"+fromsql+"' and '"+tosql+"') and a.ID="+empid+" and a.`Early` > '00:00:00' and a.ID= b.ID";
            PreparedStatement pst=con.prepareStatement(query);
            ResultSet rst1=pst.executeQuery();
            Report1.setModel (DbUtils.resultSetToTableModel(rst1));
                    
            }
        }catch(Exception e ){}



}
if(oT.isSelected()){
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
 
 
    String query2="SELECT a.`ID` , a.`Name` ,b.Department,b.Designation, Concat(a.`Shift`,'-', a.`InTime`,' to ', a.`OutTime`) as 'Shift Timings' ,a.`Date` , a.`checkintime` , a.`checkouttime` , a.`Total` , a.`Late` , a.`Early` , a.`OT` , a.`InOT` , a.`Late_Exceed` , a.`Early_Exceed`,'Status','Symbol' from calculation a,emp_list b  where (a.Date between '"+fromsql+"' and '"+tosql+"') and (a.ID=0 "+formattedString+") and a.`OT` > '00:00:00' and a.ID= b.ID  order by date";
    PreparedStatement pst2=con.prepareStatement(query2);
            ResultSet rst2=pst2.executeQuery();
            Report1.setModel(DbUtils.resultSetToTableModel(rst2));
   
}else{
        int empid=Integer.parseInt(employeeid.getSelectedItem().toString());
            String query="SELECT a.`ID` , a.`Name` ,b.Department,b.Designation, Concat(a.`Shift`,'-', a.`InTime`,' to ', a.`OutTime`) as 'Shift Timings' ,a.`Date` , a.`checkintime` , a.`checkouttime` , a.`Total` , a.`Late` , a.`Early` , a.`OT` , a.`InOT` , a.`Late_Exceed` , a.`Early_Exceed`,'Status','Symbol' from calculation a,emp_list b  where (a.Date between '"+fromsql+"' and '"+tosql+"') and (a.ID="+empid+") and a.`OT` > '00:00:00' and a.ID= b.ID  order by date";
            PreparedStatement pst=con.prepareStatement(query);
            ResultSet rst1=pst.executeQuery();
            Report1.setModel (DbUtils.resultSetToTableModel(rst1));
                    
            }
        }catch(Exception e ){}

}
if(inOT.isSelected()){
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
 
 
    String query2="SELECT a.`ID` , a.`Name` ,b.Department,b.Designation, Concat(a.`Shift`,'-', a.`InTime`,' to ', a.`OutTime`) as 'Shift Timings' ,a.`Date` , a.`checkintime` , a.`checkouttime` , a.`Total` , a.`Late` , a.`Early` , a.`OT` , a.`InOT` , a.`Late_Exceed` , a.`Early_Exceed`,'Status','Symbol' from calculation a,emp_list b  where (a.Date between '"+fromsql+"' and '"+tosql+"') and (a.ID=0 "+formattedString+") and a.`InOT` > '00:00:00' and a.ID= b.ID  order by date";
    PreparedStatement pst2=con.prepareStatement(query2);
            ResultSet rst2=pst2.executeQuery();
            Report1.setModel(DbUtils.resultSetToTableModel(rst2));
   
}else{
        int empid=Integer.parseInt(employeeid.getSelectedItem().toString());
            String query="SELECT a.`ID` , a.`Name` ,b.Department,b.Designation, Concat(a.`Shift`,'-', a.`InTime`,' to ', a.`OutTime`) as 'Shift Timings' ,a.`Date` , a.`checkintime` , a.`checkouttime` , a.`Total` , a.`Late` , a.`Early` , a.`OT` , a.`InOT` , a.`Late_Exceed` , a.`Early_Exceed`,'Status','Symbol' from calculation a,emp_list b  where (a.Date between '"+fromsql+"' and '"+tosql+"') and a.ID="+empid+" and a.`InOT` > '00:00:00' and a.ID= b.ID  order by date";
            PreparedStatement pst=con.prepareStatement(query);
            ResultSet rst1=pst.executeQuery();
            Report1.setModel (DbUtils.resultSetToTableModel(rst1));
                    
            }
        }catch(Exception e ){}

}
if(aBS.isSelected()){
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

ar.add("or User_ID="+employeeid.getItemAt(p));bar.add("or emp_id="+employeeid.getItemAt(p));}
    String formattedString = ar.toString()
    .replace(",", "")  //remove the commas
    .replace("[", "")  //remove the right bracket
    .replace("]", "") ;    
    
    String formattedString2 = bar.toString()
    .replace(",", "")  //remove the commas
    .replace("[", "")  //remove the right bracket
    .replace("]", "") ;   
 
 //SELECT User_ID as 'ID', Start_Date as 'Date', shiftname as 'Shift Name' ,'Absent' FROM user_of_run2 c LEFT JOIN calculation c1 ON c.Start_Date = c1.Date and c.User_ID = c1.ID WHERE c1.Date IS NULL and c.Start_Date BETWEEN '2018-07-01' and '2018-07-31' and User_ID='1001'
    String query2="SELECT User_ID as 'ID',d.Name,d.Department,d.Designation, Start_Date as 'Date', shiftname as 'Shift Name' ,'Absent','No Checkin','No Checkout','No Overtime' FROM emp_list d,user_of_run2 c WHERE c.Start_Date NOT IN( SELECT calculation.Date FROM calculation WHERE c.User_ID=calculation.ID )and c.Start_Date NOT IN( SELECT holiday_employee.date FROM holiday_employee WHERE holiday_employee.emp_id=c.User_ID ) AND c.Start_Date NOT IN( SELECT leave_employee.Date FROM leave_employee WHERE leave_employee.emp_id=c.User_ID ) AND  (c.Start_Date BETWEEN '"+fromsql+"' and '"+tosql+"') and (User_ID=0 "+formattedString+") and d.ID=c.User_ID  order by date ";
    PreparedStatement pst2=con.prepareStatement(query2);
            ResultSet rst2=pst2.executeQuery();
            Report1.setModel(DbUtils.resultSetToTableModel(rst2));
   
}else{
        int empid=Integer.parseInt(employeeid.getSelectedItem().toString());
String query="SELECT User_ID as 'ID',d.Name,d.Department,d.Designation, Start_Date as 'Date', shiftname as 'Shift Name' ,'Absent','No Checkin','No Checkout','No Overtime' FROM emp_list d,user_of_run2 c WHERE c.Start_Date NOT IN( SELECT calculation.Date FROM calculation WHERE c.User_ID=calculation.ID )and c.Start_Date NOT IN( SELECT holiday_employee.date FROM holiday_employee WHERE holiday_employee.emp_id=c.User_ID ) AND c.Start_Date NOT IN( SELECT leave_employee.Date FROM leave_employee WHERE leave_employee.emp_id=c.User_ID ) AND c.Start_Date BETWEEN '"+fromsql+"' and '"+tosql+"' and User_ID='"+empid+"'  and d.ID=c.User_ID  order by date ";
            PreparedStatement pst=con.prepareStatement(query);
            ResultSet rst1=pst.executeQuery();
            Report1.setModel (DbUtils.resultSetToTableModel(rst1));
                    
            }
        }catch(Exception e ){JOptionPane.showMessageDialog(null,e);}

}
if(hOL.isSelected()){}
if(lEA.isSelected()){}
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
 
    String query2="Select * from (SELECT `ID` , `Name` , Concat(`Shift`,'-', `InTime`,' to ', `OutTime`) as 'Shift Timings' , `Date` , `checkintime` , `checkouttime` , `Total` , `Late` , `Early` , `OT` , `InOT` , `Late_Exceed` , `Early_Exceed`,'Status','Symbol' from calculation  where (Date between '"+fromsql+"' and '"+tosql+"') and (ID=0 "+formattedString+") union select emp_id,emp_name,leave_name,Date,Reason,Reason,Reason,Reason,Reason,Reason,Reason,Reason,Reason,Reason,'Symbol' from leave_employee  where (Date between '"+fromsql+"' and '"+tosql+"')  and (emp_id=0 "+formattedString2+")" +
" UNION " +
"SELECT emp_id,emp_name,holiday_name,date,description,description,description,description,description,description,description,description,description,description,'Symbol' from holiday_employee  where (Date between '"+fromsql+"' and '"+tosql+"') and (emp_id=0 "+formattedString2+") "
            + " union\n" +
"SELECT User_ID as 'ID',d.Name, shiftname, Start_Date as 'Date' ,'No Check-In','No Check-Out',\n" +
"'Absent','-','-','-','-','-','-','Absent','A' FROM emp_list d,user_of_run2 c \n" +
"WHERE \n" +
"c.Start_Date NOT IN( SELECT calculation.Date FROM calculation WHERE c.User_ID=calculation.ID ) and \n" +
"c.Start_Date NOT IN( SELECT holiday_employee.date FROM holiday_employee WHERE holiday_employee.emp_id=c.User_ID ) AND \n" +
"c.Start_Date NOT IN( SELECT leave_employee.Date FROM leave_employee WHERE leave_employee.emp_id=c.User_ID ) AND \n" +
"c.Start_Date BETWEEN '"+fromsql+"' and '"+tosql+"' and (User_ID=0 "+formattedString3+")  and d.ID=c.User_ID  order by date\n" +
"  ) a order by id,Date ASC  ";
    PreparedStatement pst2=con.prepareStatement(query2);
            ResultSet rst2=pst2.executeQuery();
            Report1.setModel(DbUtils.resultSetToTableModel(rst2));
   
}else{
        int empid=Integer.parseInt(employeeid.getSelectedItem().toString());
            String query="SELECT `ID` , `Name` , Concat(`Shift`,'-', `InTime`,' to ', `OutTime`) as 'Shift Timings' , `Date` , `checkintime` , `checkouttime` , `Total` , `Late` , `Early` , `OT` , `InOT` , `Late_Exceed` , `Early_Exceed`,'Status','Symbol' from calculation  WHERE (Date between '"+fromsql+"' and '"+tosql+"') and (ID='"+empid+"') union select emp_id,emp_name,leave_name,Date,Reason,Reason,Reason,Reason,Reason,Reason,Reason,Reason,Reason,Reason,'Symbol' from leave_employee  WHERE (Date between '"+fromsql+"' and '"+tosql+"') and (emp_id='"+empid+"')" +
" UNION " +
"SELECT emp_id,emp_name,holiday_name,date,description,description,description,description,description,description,description,description,description,description,'Symbol' from holiday_employee  WHERE (Date between '"+fromsql+"' and '"+tosql+"') and (emp_id='"+empid+"') "
            + " union\n" +
"SELECT User_ID as 'ID',d.Name, shiftname, Start_Date as 'Date' ,'No Check-In','No Check-Out',\n" +
"'Absent','-','-','-','-','-','-','Absent','A' FROM emp_list d,user_of_run2 c \n" +
"WHERE \n" +
"c.Start_Date NOT IN( SELECT calculation.Date FROM calculation WHERE c.User_ID=calculation.ID ) and \n" +
"c.Start_Date NOT IN( SELECT holiday_employee.date FROM holiday_employee WHERE holiday_employee.emp_id=c.User_ID ) AND \n" +
"c.Start_Date NOT IN( SELECT leave_employee.Date FROM leave_employee WHERE leave_employee.emp_id=c.User_ID ) AND \n" +
"c.Start_Date BETWEEN '"+fromsql+"' and '"+tosql+"' and User_ID='"+empid+"'  and d.ID=c.User_ID  \n" +
"";
            PreparedStatement pst=con.prepareStatement(query);
            ResultSet rst1=pst.executeQuery();
            Report1.setModel (DbUtils.resultSetToTableModel(rst1));
                    
            }
                 int rows= Report1.getRowCount();String stat=null;
        for(int i=0;i<rows;i++){String days1 = GetData(Report1, i, 8).toString();String tot7="";String tot8="";
         String late = GetData(Report1, i, 7).toString();
          if(late.equalsIgnoreCase("00:00:00"))  {} else{tot7=tot7+" Late"; tot8=tot8+"L"; }Report1.setValueAt(tot7, i, 13); Report1.setValueAt(tot8, i, 14);  
        
    String in = GetData(Report1, i, 4).toString();String out = GetData(Report1, i, 5).toString();
          if(in.equalsIgnoreCase(out))  {tot7=tot7+" Half-Day";tot8=tot8+"H";} else{tot7=tot7+" Present";tot8=tot8+"P"; }Report1.setValueAt(tot7, i, 13); Report1.setValueAt(tot8, i, 14);     
    
          if(days1.equals("00:00:00"))  {} else{tot7=tot7+" Early"; tot8=tot8+"E";}
           Report1.setValueAt(tot7, i, 13); Report1.setValueAt(tot8, i, 14);
        
         String ot = GetData(Report1, i, 9).toString();
          if(ot.equalsIgnoreCase("00:00:00")) {} else{tot7=tot7+" O.T"; tot8=tot8+"O";}Report1.setValueAt(tot7, i, 13); Report1.setValueAt(tot8, i, 14);
         
         String inot = GetData(Report1, i, 10).toString();
          if(inot.equalsIgnoreCase("00:00:00"))  {} else{tot7=tot7+" IN O.T"; tot8=tot8+"O";}Report1.setValueAt(tot7, i, 13); Report1.setValueAt(tot8, i, 14);
          if(late.equalsIgnoreCase("-"))  {tot7="Absent"; tot8="A"; } else{}Report1.setValueAt(tot7, i, 13); Report1.setValueAt(tot8, i, 14);  
          String leavename = GetData(Report1, i, 2).toString();
         PreparedStatement   pst2=con.prepareStatement("SELECT id FROM `leavemanage` where `leave_name` = '"+leavename+"'");
            ResultSet rst12=pst2.executeQuery();

      
            while(rst12.next()){
Report1.setValueAt("Leave", i, 13); Report1.setValueAt("LV", i, 14);
            }
                String Holidayname = GetData(Report1, i, 2).toString();
         PreparedStatement   pst3=con.prepareStatement("SELECT id FROM `holiday` where `holiday_name` = '"+Holidayname+"'");
            ResultSet rst3=pst3.executeQuery();

            while(rst3.next()){
Report1.setValueAt("Holiday", i, 13); Report1.setValueAt("HD", i, 14);
            }
           String id = GetData(Report1, i, 0).toString(); String name = GetData(Report1, i, 1).toString();      
          String dd = GetData(Report1, i, 3).toString();String stats = GetData(Report1, i, 14).toString();
         int DD=Integer.parseInt(dd.subSequence(8, 10).toString());
          Statement st2=con.createStatement();  
           String month=dd.subSequence(0, 8).toString()+"01";
           System.out.println(DD);
            switch(DD){
                case 1: 
         
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `1`) values ('"+id+"','"+name+"','"+month+"','"+stats+"') ON DUPLICATE KEY UPDATE    \n" +
" `1`='"+stats+"'");  
                    break; 
                case 2: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `2`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `2`='"+stats+"'");  
                    break; 
                case 3: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `3`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `3`='"+stats+"'");  
                    break; 
                        case 4: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `4`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `4`='"+stats+"'");  
                    break;
                    
                            case 5: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `5`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `5`='"+stats+"'");  
                    break; 
         case 6: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `6`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `6`='"+stats+"'");  
                    break;
                             case 7: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `7`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `7`='"+stats+"'");  
                    break;
                             case 8: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `8`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `8`='"+stats+"'");  
                    break; 
                             case 9: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `9`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `9`='"+stats+"'");  
                    break;
                             case 10: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `10`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `10`='"+stats+"'");  
                    break; 
                      case 11: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `11`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `11`='"+stats+"'");  
                    break; 
                      case 12: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `12`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `12`='"+stats+"'");  
                    break; 
                      case 13: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `13`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `13`='"+stats+"'");  
                    break; 
                      case 14: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `14`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `14`='"+stats+"'");  
                    break; 
                      case 15: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `15`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `15`='"+stats+"'");  
                    break; 
                      case 16: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `16`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `16`='"+stats+"'");  
                    break; 
                      case 17: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `17`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `17`='"+stats+"'");  
                    break; 
                      case 18: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `18`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `18`='"+stats+"'");  
                    break; 
                      case 19: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `19`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `19`='"+stats+"'");  
                    break; 
                      case 20: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `20`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `20`='"+stats+"'");  
                    break; 
                      case 21: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `21`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `21`='"+stats+"'");  
                    break; 
                      case 22: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `22`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `22`='"+stats+"'");  
                    break; 
                      case 23: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `23`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `23`='"+stats+"'");  
                    break; 
                      case 24: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `24`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `24`='"+stats+"'");  
                    break; 
                      case 25: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `25`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `25`='"+stats+"'");  
                    break; 
                      case 26: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `26`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `26`='"+stats+"'");  
                    break; 
                      case 27: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `27`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `27`='"+stats+"'");  
                    break; 
                      case 28: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `28`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `28`='"+stats+"'");  
                    break; 
                      case 29: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `29`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `29`='"+stats+"'");  
                    break; 
                      case 30: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `30`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `30`='"+stats+"'");  
                    break; 
                      case 31: 
          st2.executeUpdate("insert INTO `statistic_report`(`id`, `name`, `date`, `31`) values ('"+id+"','"+name+"','"+month+"','"+stats+"')  ON DUPLICATE KEY UPDATE    \n" +
" `31`='"+stats+"'");  
                    break; 
                    
            }
         // int k=st2.executeUpdate("insert into statistic _report(id,name,date,1) values ('"+id+"','"+name+"','"+dd+"','"+stats+"')");         
         
        // String latex = GetData(Report1, i, 11).toString();
          //if(latex.equalsIgnoreCase("00:00:00"))  {} else{tot7=tot7+"LateEx";}Report1.setValueAt(tot7, i, 13);
         
        // String earlyx = GetData(Report1, i, 12).toString();
         // if(earlyx.equalsIgnoreCase("00:00:00"))  {} else{tot7=tot7+"EarlyEx";}Report1.setValueAt(tot7, i, 13);}
        }        
         
//int k=st2.executeUpdate("Replace into statistic _report(id,name,date,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31) values ()");
       
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);}}
    }//GEN-LAST:event_generate1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         String reportDest = "C:\\xampp\\Att.pdf";
        try{    java.util.Date sdate=from123.getDate();
            java.sql.Date fromsql=new java.sql.Date(sdate.getTime());
            java.util.Date sdate2=to123.getDate();
            java.sql.Date tosql=new java.sql.Date(sdate2.getTime());
            if(employeeid.getSelectedItem() == "All"){
                ArrayList ar=new ArrayList();
                for(int p=1;p < employeeid.getItemCount();p++){

                    ar.add("or id="+employeeid.getItemAt(p));}
                String formattedString = ar.toString()
                .replace(",", "")  //remove the commas
                .replace("[", "")  //remove the right bracket
                .replace("]", "") ;

                InputStream is1 = getClass().getResourceAsStream("emplist_2_1.jrxml");

                JasperDesign jd=JRXmlLoader.load(is1);

                String sql="select * from statistic_report where Date between '"+fromsql+"' and '"+tosql+"' and (id=0 "+formattedString+")";
                JRDesignQuery newQuery=new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);

                JasperReport jr=JasperCompileManager.compileReport(jd);
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(url,id,pass);
                JasperPrint jp=JasperFillManager.fillReport(jr,null,conn);
                JasperViewer.viewReport(jp,false);
                File pdf = new File(reportDest);
                JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(pdf));
                JasperViewer jv = new JasperViewer( jp, false );
                jv.viewReport( jp,false);

            }//C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources_7jan\\src\\payslip.jrxml
            else{//java.net.URL url = new java.net.URL("D:/qw/payslip.jrxml");
                InputStream  is2 = getClass().getResourceAsStream("emplist_2_1.jrxml");

                JasperDesign jd=JRXmlLoader.load(is2);
                int empid=Integer.parseInt(employeeid.getSelectedItem().toString());
                String sql="SELECT * FROM `statistic_report` WHERE (ID='"+empid+"') and Date between '"+fromsql+"' and '"+tosql+"'";
                JRDesignQuery newQuery=new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);

                //String report="C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources\\src\\report1.jrxml";
                JasperReport jr=JasperCompileManager.compileReport(jd);
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(url,id,pass);
                JasperPrint jp=JasperFillManager.fillReport(jr,null,conn);
                File pdf = new File(reportDest);
                JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(pdf));
                //JasperViewer.viewReport(jp);
                JasperViewer jv = new JasperViewer( jp, false );
                jv.viewReport( jp,false);
            }

        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
  if(lEA.isSelected()){             String reportDest = "D:\\Leave-Report.pdf";
        try{    java.util.Date sdate=from123.getDate();
            java.sql.Date fromsql=new java.sql.Date(sdate.getTime());
            java.util.Date sdate2=to123.getDate();
            java.sql.Date tosql=new java.sql.Date(sdate2.getTime());
            if(employeeid.getSelectedItem() == "All"){
                ArrayList ar=new ArrayList();
                for(int p=1;p < employeeid.getItemCount();p++){

                    ar.add("or c.emp_ID="+employeeid.getItemAt(p));}
                String formattedString = ar.toString()
                .replace(",", "")  //remove the commas
                .replace("[", "")  //remove the right bracket
                .replace("]", "") ;

                InputStream is1 = getClass().getResourceAsStream("leaveReport.jrxml");

                JasperDesign jd=JRXmlLoader.load(is1);

                String sql="SELECT c.emp_ID as 'ID',c.date as 'Date',c.leave_name,c.Reason,\n" +
"d.Name,\n" +
"d.Department,\n" +
"d.Designation,\n" +
"v.name as 'companyName'\n" +
" FROM companyinfo v,emp_list d, leave_employee c where (c.emp_ID=0 "+formattedString+") and c.Date between '"+fromsql+"' and '"+tosql+"' and  c.emp_ID=d.ID";
                JRDesignQuery newQuery=new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);

                JasperReport jr=JasperCompileManager.compileReport(jd);
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(url,id,pass);
                JasperPrint jp=JasperFillManager.fillReport(jr,null,conn);
                JasperViewer.viewReport(jp,false);
  File pdf = new File(reportDest);
                JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(pdf));
              

            }//C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources_7jan\\src\\payslip.jrxml
            else{//java.net.URL url = new java.net.URL("D:/qw/payslip.jrxml");
                InputStream  is2 = getClass().getResourceAsStream("leaveReport.jrxml");

                JasperDesign jd=JRXmlLoader.load(is2);
                int empid=Integer.parseInt(employeeid.getSelectedItem().toString());
                String sql="SELECT c.emp_ID as 'ID',c.date,c.leave_name,c.Reason,\n" +
"d.Name,\n" +
"d.Department,\n" +
"d.Designation,\n" +
"v.name as 'companyName'\n" +
" FROM companyinfo v,emp_list d, leave_employee c where  (c.emp_ID='"+empid+"') and c.date between '"+fromsql+"' and '"+tosql+"' and  c.emp_ID=d.ID";
                JRDesignQuery newQuery=new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);

                //String report="C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources\\src\\report1.jrxml";
                JasperReport jr=JasperCompileManager.compileReport(jd);
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(url,id,pass);
                JasperPrint jp=JasperFillManager.fillReport(jr,null,conn);
                File pdf = new File(reportDest);
                JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(pdf));
                //JasperViewer.viewReport(jp);
                JasperViewer jv = new JasperViewer( jp, false );
                jv.viewReport( jp,false);
            }

        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}}

        if(hOL.isSelected()){             String reportDest = "D:\\Holiday-Report.pdf";
        try{    java.util.Date sdate=from123.getDate();
            java.sql.Date fromsql=new java.sql.Date(sdate.getTime());
            java.util.Date sdate2=to123.getDate();
            java.sql.Date tosql=new java.sql.Date(sdate2.getTime());
            if(employeeid.getSelectedItem() == "All"){
                ArrayList ar=new ArrayList();
                for(int p=1;p < employeeid.getItemCount();p++){

                    ar.add("or c.emp_ID="+employeeid.getItemAt(p));}
                String formattedString = ar.toString()
                .replace(",", "")  //remove the commas
                .replace("[", "")  //remove the right bracket
                .replace("]", "") ;

                InputStream is1 = getClass().getResourceAsStream("holidayReport.jrxml");

                JasperDesign jd=JRXmlLoader.load(is1);

                String sql="SELECT c.emp_ID as 'ID',c.date as 'Date',c.holiday_name,c.description,\n" +
"d.Name,\n" +
"d.Department,\n" +
"d.Designation,\n" +
"v.name as 'companyName'\n" +
" FROM companyinfo v,emp_list d, holiday_employee c where (c.emp_ID=0 "+formattedString+") and c.Date between '"+fromsql+"' and '"+tosql+"' and  c.emp_ID=d.ID";
                JRDesignQuery newQuery=new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);

                JasperReport jr=JasperCompileManager.compileReport(jd);
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(url,id,pass);
                JasperPrint jp=JasperFillManager.fillReport(jr,null,conn);
                JasperViewer.viewReport(jp,false);
  File pdf = new File(reportDest);
                JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(pdf));
              

            }//C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources_7jan\\src\\payslip.jrxml
            else{//java.net.URL url = new java.net.URL("D:/qw/payslip.jrxml");
                InputStream  is2 = getClass().getResourceAsStream("holidayReport.jrxml");

                JasperDesign jd=JRXmlLoader.load(is2);
                int empid=Integer.parseInt(employeeid.getSelectedItem().toString());
                String sql="SELECT c.emp_ID as 'ID',c.date,c.holiday_name,c.description,\n" +
"d.Name,\n" +
"d.Department,\n" +
"d.Designation,\n" +
"v.name as 'companyName'\n" +
" FROM companyinfo v,emp_list d, holiday_employee c where  (c.emp_ID='"+empid+"') and c.date between '"+fromsql+"' and '"+tosql+"' and  c.emp_ID=d.ID";
                JRDesignQuery newQuery=new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);

                //String report="C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources\\src\\report1.jrxml";
                JasperReport jr=JasperCompileManager.compileReport(jd);
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(url,id,pass);
                JasperPrint jp=JasperFillManager.fillReport(jr,null,conn);
                File pdf = new File(reportDest);
                JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(pdf));
                //JasperViewer.viewReport(jp);
                JasperViewer jv = new JasperViewer( jp, false );
                jv.viewReport( jp,false);
            }

        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}}

        
        if(aBS.isSelected()){             String reportDest = "D:\\Absent_Rpt.pdf";
        try{    java.util.Date sdate=from123.getDate();
            java.sql.Date fromsql=new java.sql.Date(sdate.getTime());
            java.util.Date sdate2=to123.getDate();
            java.sql.Date tosql=new java.sql.Date(sdate2.getTime());
            if(employeeid.getSelectedItem() == "All"){
                ArrayList ar=new ArrayList();
                for(int p=1;p < employeeid.getItemCount();p++){

                    ar.add("or c.User_ID="+employeeid.getItemAt(p));}
                String formattedString = ar.toString()
                .replace(",", "")  //remove the commas
                .replace("[", "")  //remove the right bracket
                .replace("]", "") ;

                InputStream is1 = getClass().getResourceAsStream("absentReport.jrxml");

                JasperDesign jd=JRXmlLoader.load(is1);

                String sql="SELECT c.User_ID as 'ID',d.Name,d.Department,d.Designation, c.Start_Date as 'Date',shiftname as 'Shift Name' ,'Absent','No Checkin','No Checkout','No Overtime',v.name as 'companyName' FROM companyinfo v, emp_list d,user_of_run2 c WHERE c.Start_Date NOT IN( SELECT calculation.Date FROM calculation WHERE c.User_ID=calculation.ID )and c.Start_Date NOT IN( SELECT holiday_employee.date FROM holiday_employee WHERE holiday_employee.emp_id=c.User_ID ) AND c.Start_Date NOT IN( SELECT leave_employee.Date FROM leave_employee WHERE leave_employee.emp_id=c.User_ID ) and (c.User_ID=0 "+formattedString+") and c.Start_Date between '"+fromsql+"' and '"+tosql+"' and  c.User_ID=d.ID";
                JRDesignQuery newQuery=new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);

                JasperReport jr=JasperCompileManager.compileReport(jd);
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(url,id,pass);
                JasperPrint jp=JasperFillManager.fillReport(jr,null,conn);
                JasperViewer.viewReport(jp,false);
  File pdf = new File(reportDest);
                JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(pdf));
              

            }//C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources_7jan\\src\\payslip.jrxml
            else{//java.net.URL url = new java.net.URL("D:/qw/payslip.jrxml");
                InputStream  is2 = getClass().getResourceAsStream("absentReport.jrxml");

                JasperDesign jd=JRXmlLoader.load(is2);
                int empid=Integer.parseInt(employeeid.getSelectedItem().toString());
                String sql="SELECT User_ID as 'ID',d.Name,d.Department,d.Designation, Start_Date as 'Date', shiftname as 'Shift Name' ,'Absent','No Checkin','No Checkout','No Overtime',v.name as 'companyname' FROM companyinfo v, emp_list d,user_of_run2 c WHERE c.Start_Date NOT IN( SELECT calculation.Date FROM calculation WHERE c.User_ID=calculation.ID )and c.Start_Date NOT IN( SELECT holiday_employee.date FROM holiday_employee WHERE holiday_employee.emp_id=c.User_ID ) AND c.Start_Date NOT IN( SELECT leave_employee.Date FROM leave_employee WHERE leave_employee.emp_id=c.User_ID ) and (c.User_ID='"+empid+"') and c.Start_Date between '"+fromsql+"' and '"+tosql+"' and  c.User_ID=d.ID";
                JRDesignQuery newQuery=new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);

                //String report="C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources\\src\\report1.jrxml";
                JasperReport jr=JasperCompileManager.compileReport(jd);
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(url,id,pass);
                JasperPrint jp=JasperFillManager.fillReport(jr,null,conn);
                File pdf = new File(reportDest);
                JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(pdf));
                //JasperViewer.viewReport(jp);
                JasperViewer jv = new JasperViewer( jp, false );
                jv.viewReport( jp,false);
            }

        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
        
        
        if(genReport.isSelected()){             String reportDest = "D:\\General_Report.pdf";
        try{    java.util.Date sdate=from123.getDate();
            java.sql.Date fromsql=new java.sql.Date(sdate.getTime());
            java.util.Date sdate2=to123.getDate();
            java.sql.Date tosql=new java.sql.Date(sdate2.getTime());
            if(employeeid.getSelectedItem() == "All"){
                ArrayList ar=new ArrayList();
                for(int p=1;p < employeeid.getItemCount();p++){

                    ar.add("or a.ID="+employeeid.getItemAt(p));}
                String formattedString = ar.toString()
                .replace(",", "")  //remove the commas
                .replace("[", "")  //remove the right bracket
                .replace("]", "") ;

                InputStream is1 = getClass().getResourceAsStream("generalReport.jrxml");

                JasperDesign jd=JRXmlLoader.load(is1);

                String sql="select a.`ID`, a.`Name`, a.`Department`, a.`Shift`, a.`Date`, a.`Total_Day`, a.`PresentDay`, a.`AbsentDay`, a.`LateDay`, a.`EarlyDay`, a.`OT`, a.`InOT`, a.`TotalTime`, a.`TotalLate`, a.`TotalEarly`, a.`TotalOT`, a.`TotalinOT`, a.`NET_Salary`, a.`Late_Exceed`, a.`Early_Exceed`, a.`loanins`, a.`advance`, a.`leavey`, a.`taxy`, a.`totalShiftTime`,b.department as 'depart',b.designation,c.name as 'companyname',c.logo,c.address from attendancemonth a,emp_list b,companyinfo c  where a.id=b.id and (a.ID=0 "+formattedString+") and a.Date between '"+fromsql+"' and '"+tosql+"'  order by a.Department";
                JRDesignQuery newQuery=new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);

                JasperReport jr=JasperCompileManager.compileReport(jd);
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(url,id,pass);
                JasperPrint jp=JasperFillManager.fillReport(jr,null,conn);
                JasperViewer.viewReport(jp,false);
  File pdf = new File(reportDest);
                JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(pdf));
              

            }//C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources_7jan\\src\\payslip.jrxml
            else{//java.net.URL url = new java.net.URL("D:/qw/payslip.jrxml");
                InputStream  is2 = getClass().getResourceAsStream("generalReport.jrxml");

                JasperDesign jd=JRXmlLoader.load(is2);
                int empid=Integer.parseInt(employeeid.getSelectedItem().toString());
                String sql="select a.`ID`, a.`Name`, a.`Department`, a.`Shift`, a.`Date`, a.`Total_Day`, a.`PresentDay`, a.`AbsentDay`, a.`LateDay`, a.`EarlyDay`, a.`OT`, a.`InOT`, a.`TotalTime`, a.`TotalLate`, a.`TotalEarly`, a.`TotalOT`, a.`TotalinOT`, a.`NET_Salary`, a.`Late_Exceed`, a.`Early_Exceed`, a.`loanins`, a.`advance`, a.`leavey`, a.`taxy`, a.`totalShiftTime`,b.department as 'depart',b.designation,c.name as 'companyname',c.logo,c.address from attendancemonth a,emp_list b,companyinfo c  where a.id=b.id and (a.ID='"+empid+"') and a.Date between '"+fromsql+"' and '"+tosql+"'  order by  a.Department ";
                JRDesignQuery newQuery=new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);

                //String report="C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources\\src\\report1.jrxml";
                JasperReport jr=JasperCompileManager.compileReport(jd);
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(url,id,pass);
                JasperPrint jp=JasperFillManager.fillReport(jr,null,conn);
                File pdf = new File(reportDest);
                JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(pdf));
                //JasperViewer.viewReport(jp);
                JasperViewer jv = new JasperViewer( jp, false );
                jv.viewReport( jp,false);
            }

        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
        if(aLL.isSelected()){             String reportDest = "D:\\Attendance.pdf";
        try{    java.util.Date sdate=from123.getDate();
            java.sql.Date fromsql=new java.sql.Date(sdate.getTime());
            java.util.Date sdate2=to123.getDate();
            java.sql.Date tosql=new java.sql.Date(sdate2.getTime());
            if(employeeid.getSelectedItem() == "All"){
                ArrayList ar=new ArrayList();ArrayList ar1=new ArrayList();ArrayList ar2=new ArrayList();ArrayList ar3=new ArrayList();
                for(int p=1;p < employeeid.getItemCount();p++){

                    ar.add("or calculation.ID='"+employeeid.getItemAt(p)+"'");ar1.add("or emp_id='"+employeeid.getItemAt(p)+"'");ar2.add("or emp_id='"+employeeid.getItemAt(p)+"'");
                ar3.add("or c.User_ID="+employeeid.getItemAt(p));
                }
                String calculation = ar.toString().replace(",", "").replace("[", "").replace("]", "") ;
                String leave = ar1.toString().replace(",", "").replace("[", "").replace("]", "") ;
                String holiday = ar2.toString().replace(",", "").replace("[", "").replace("]", "") ;
                 String absent = ar3.toString().replace(",", "").replace("[", "").replace("]", "") ;

                InputStream is1 = getClass().getResourceAsStream("attend_1.jrxml");

                JasperDesign jd=JRXmlLoader.load(is1);

                String sql="SELECT\n" +
"     calculation.`ID` AS ID,\n" +
"     calculation.`Name` AS Name,\n" +
"emp_list.Department,emp_list.Designation,\n" +
"     calculation.`Date` AS Date,\n" +
"     calculation.`checkintime` AS checkintime,\n" +
"     calculation.`checkouttime` AS  checkouttime,\n" +
"     calculation.`Total` AS  Total,\n" +
"     TIME_TO_SEC(calculation.`OT`) / 60 AS  OT,\n" +
"     TIME_TO_SEC(calculation.`InOT`) / 60 AS InOT,\n" +
"     TIME_TO_SEC(calculation.`Late`) / 60 AS  Late_Exceed,\n" +
"     TIME_TO_SEC(calculation.`Early`) / 60 AS  Early_Exceed\n" +
",c.name as 'companyname',c.logo,c.address,'P' as 'Status'\n" +
"FROM\n" +
"     calculation, emp_list,companyinfo c  where calculation.ID=emp_list.ID and (calculation.ID='0' "+calculation+") and calculation.Date between '"+fromsql+"' and '"+tosql+"'  union\n" +
"SELECT emp_id,emp_name,emp_list.department,emp_list.designation,date,'00:00','00:00','00:00','0','0','0','0','-','-','-','H' as 'Status' from holiday_employee,emp_list where  (emp_id='0' "+holiday+") and holiday_employee.emp_id=emp_list.ID and holiday_employee.Date between '"+fromsql+"' and '"+tosql+"' union\n" +
"select emp_id,emp_name,emp_list.department,emp_list.designation,Date,'00:00','00:00','00:00','0','0','0','0','-','-','-','L' as 'Status' from leave_employee,emp_list where  (emp_id='0' "+leave+") and leave_employee.emp_id=emp_list.ID and leave_employee.Date between '"+fromsql+"' and '"+tosql+"' union\n" +
"\n" +
"SELECT User_ID as 'ID',d.Name,d.Department,d.Designation,  Start_Date as 'Date' \n" +
",'00:00','00:00','00:00','0','0','0','0','-','-','-','A' as 'Status' FROM emp_list d,user_of_run2 c \n" +
"WHERE \n" +
"c.Start_Date NOT IN( SELECT calculation.Date FROM calculation WHERE c.User_ID=calculation.ID ) and \n" +
"c.Start_Date NOT IN( SELECT holiday_employee.date FROM holiday_employee WHERE holiday_employee.emp_id=c.User_ID ) AND \n" +
"c.Start_Date NOT IN( SELECT leave_employee.Date FROM leave_employee WHERE leave_employee.emp_id=c.User_ID ) AND d.ID=c.User_ID and  (c.User_ID='0' "+absent+") and c.Start_date between '"+fromsql+"' and '"+tosql+"' order by department,date";
                JRDesignQuery newQuery=new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);

                JasperReport jr=JasperCompileManager.compileReport(jd);
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(url,id,pass);
                JasperPrint jp=JasperFillManager.fillReport(jr,null,conn);
                JasperViewer.viewReport(jp,false);
  File pdf = new File(reportDest);
                JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(pdf));
                JasperViewer jv = new JasperViewer( jp, false );
                jv.viewReport( jp,false);

            }//C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources_7jan\\src\\payslip.jrxml
            else{//java.net.URL url = new java.net.URL("D:/qw/payslip.jrxml");
                int empid=Integer.parseInt(employeeid.getSelectedItem().toString());
                  InputStream is1 = getClass().getResourceAsStream("attend_1.jrxml");

                JasperDesign jd=JRXmlLoader.load(is1);

                String sql="SELECT\n" +
"     calculation.`ID` AS ID,\n" +
"     calculation.`Name` AS Name,\n" +
"emp_list.Department,emp_list.Designation,\n" +
"     calculation.`Date` AS Date,\n" +
"     calculation.`checkintime` AS checkintime,\n" +
"     calculation.`checkouttime` AS  checkouttime,\n" +
"     calculation.`Total` AS  Total,\n" +
"     TIME_TO_SEC(calculation.`OT`) / 60 AS  OT,\n" +
"     TIME_TO_SEC(calculation.`InOT`) / 60 AS InOT,\n" +
"     TIME_TO_SEC(calculation.`Late`) / 60 AS  Late_Exceed,\n" +
"     TIME_TO_SEC(calculation.`Early`) / 60 AS  Early_Exceed\n" +
",c.name as 'companyname',c.logo,c.address,'P' as 'Status'\n" +
"FROM\n" +
"     calculation, emp_list,companyinfo c  where calculation.ID=emp_list.ID and calculation.ID='"+empid+"' and calculation.Date between '"+fromsql+"' and '"+tosql+"'  union\n" +
"SELECT emp_id,emp_name,emp_list.department,emp_list.designation,date,'00:00','00:00','00:00','0','0','0','0','-','-','-','H' as 'Status' from holiday_employee,emp_list where  emp_id='"+empid+"' and holiday_employee.emp_id=emp_list.ID and holiday_employee.Date between '"+fromsql+"' and '"+tosql+"' union\n" +
"select emp_id,emp_name,emp_list.department,emp_list.designation,Date,'00:00','00:00','00:00','0','0','0','0','-','-','-','L' as 'Status' from leave_employee,emp_list where  emp_id='"+empid+"' and leave_employee.emp_id=emp_list.ID and leave_employee.Date between '"+fromsql+"' and '"+tosql+"' union\n" +
"\n" +
"SELECT User_ID as 'ID',d.Name,d.Department,d.Designation,  Start_Date as 'Date' \n" +
",'00:00','00:00','00:00','0','0','0','0','-','-','-','A' as 'Status' FROM emp_list d,user_of_run2 c \n" +
"WHERE \n" +
"c.Start_Date NOT IN( SELECT calculation.Date FROM calculation WHERE c.User_ID=calculation.ID ) and \n" +
"c.Start_Date NOT IN( SELECT holiday_employee.date FROM holiday_employee WHERE holiday_employee.emp_id=c.User_ID ) AND \n" +
"c.Start_Date NOT IN( SELECT leave_employee.Date FROM leave_employee WHERE leave_employee.emp_id=c.User_ID ) AND d.ID=c.User_ID and  User_id='"+empid+"' and c.Start_date between '"+fromsql+"' and '"+tosql+"' order by department,date";
                JRDesignQuery newQuery=new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);

                JasperReport jr=JasperCompileManager.compileReport(jd);
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(url,id,pass);
                JasperPrint jp=JasperFillManager.fillReport(jr,null,conn);
                JasperViewer.viewReport(jp,false);
  File pdf = new File(reportDest);
                JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(pdf));
                JasperViewer jv = new JasperViewer( jp, false );
                jv.viewReport( jp,false);
            }

        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
        if(laT.isSelected()){             String reportDest = "D:\\LatAttendance.pdf";
        try{    java.util.Date sdate=from123.getDate();
            java.sql.Date fromsql=new java.sql.Date(sdate.getTime());
            java.util.Date sdate2=to123.getDate();
            java.sql.Date tosql=new java.sql.Date(sdate2.getTime());
            if(employeeid.getSelectedItem() == "All"){
                ArrayList ar=new ArrayList();
                for(int p=1;p < employeeid.getItemCount();p++){

                    ar.add("or a.ID="+employeeid.getItemAt(p));}
                String formattedString = ar.toString()
                .replace(",", "")  //remove the commas
                .replace("[", "")  //remove the right bracket
                .replace("]", "") ;

                InputStream is1 = getClass().getResourceAsStream("lateReport.jrxml");

                JasperDesign jd=JRXmlLoader.load(is1);

                String sql="SELECT a.`ID` , a.`Name` ,b.Department,b.Designation, Concat(a.`Shift`,' ',a.`InTime`,'-', a.`OutTime`) as 'Shift Timings' ,a.`Date` , a.`checkintime` , a.`checkouttime` , a.`Total` , a.`Late` , a.`Early` , a.`OT` , a.`InOT` , a.`Late_Exceed` , a.`Early_Exceed`,'Status','Symbol',v.name as 'companyname' from calculation a,emp_list b,companyinfo v  where a.ID=b.ID and (a.ID=0 "+formattedString+") and a.`Late` > '00:00:00' and a.Date between '"+fromsql+"' and '"+tosql+"' group by a.id  order by b.Department";
                JRDesignQuery newQuery=new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);

                JasperReport jr=JasperCompileManager.compileReport(jd);
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(url,id,pass);
                JasperPrint jp=JasperFillManager.fillReport(jr,null,conn);
                JasperViewer.viewReport(jp,false);
  File pdf = new File(reportDest);
                JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(pdf));
                JasperViewer jv = new JasperViewer( jp, false );
                jv.viewReport( jp,false);

            }//C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources_7jan\\src\\payslip.jrxml
            else{//java.net.URL url = new java.net.URL("D:/qw/payslip.jrxml");
                InputStream  is2 = getClass().getResourceAsStream("lateReport.jrxml");

                JasperDesign jd=JRXmlLoader.load(is2);
                int empid=Integer.parseInt(employeeid.getSelectedItem().toString());
                String sql="SELECT a.`ID` , a.`Name` ,b.Department,b.Designation, Concat(a.`Shift`,' ', a.`InTime`,'-', a.`OutTime`) as 'Shift Timings' ,a.`Date` , a.`checkintime` , a.`checkouttime` , a.`Total` , a.`Late` , a.`Early` , a.`OT` , a.`InOT` , a.`Late_Exceed` , a.`Early_Exceed`,'Status','Symbol',v.name as 'companyname' from calculation a,emp_list b,companyinfo v   where a.ID=b.ID and (a.ID='"+empid+"')  and a.`Late` > '00:00:00' and a.Date between '"+fromsql+"' and '"+tosql+"'  order by b.Department";
                JRDesignQuery newQuery=new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);

                //String report="C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources\\src\\report1.jrxml";
                JasperReport jr=JasperCompileManager.compileReport(jd);
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(url,id,pass);
                JasperPrint jp=JasperFillManager.fillReport(jr,null,conn);
                File pdf = new File(reportDest);
                JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(pdf));
                //JasperViewer.viewReport(jp);
                JasperViewer jv = new JasperViewer( jp, false );
                jv.viewReport( jp,false);
            }

        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
         if(eaR.isSelected()){             String reportDest = "D:\\EarlyAttendance.pdf";
        try{    java.util.Date sdate=from123.getDate();
            java.sql.Date fromsql=new java.sql.Date(sdate.getTime());
            java.util.Date sdate2=to123.getDate();
            java.sql.Date tosql=new java.sql.Date(sdate2.getTime());
            if(employeeid.getSelectedItem() == "All"){
                ArrayList ar=new ArrayList();
                for(int p=1;p < employeeid.getItemCount();p++){

                    ar.add("or a.ID="+employeeid.getItemAt(p));}
                String formattedString = ar.toString()
                .replace(",", "")  //remove the commas
                .replace("[", "")  //remove the right bracket
                .replace("]", "") ;

                InputStream is1 = getClass().getResourceAsStream("earlyReport.jrxml");

                JasperDesign jd=JRXmlLoader.load(is1);

                String sql="SELECT a.`ID` , a.`Name` ,b.Department,b.Designation, Concat(a.`Shift`,' ',a.`InTime`,'-', a.`OutTime`) as 'Shift Timings' ,a.`Date` , a.`checkintime` , a.`checkouttime` , a.`Total` , a.`Late` , a.`Early` , a.`OT` , a.`InOT` , a.`Late_Exceed` , a.`Early_Exceed`,'Status','Symbol',v.name as 'companyname' from calculation a,emp_list b,companyinfo v  where a.ID=b.ID and (a.ID=0 "+formattedString+") and a.`Early` > '00:00:00' and a.Date between '"+fromsql+"' and '"+tosql+"' group by a.id  order by b.Department";
                JRDesignQuery newQuery=new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);

                JasperReport jr=JasperCompileManager.compileReport(jd);
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(url,id,pass);
                JasperPrint jp=JasperFillManager.fillReport(jr,null,conn);
                JasperViewer.viewReport(jp,false);
  File pdf = new File(reportDest);
                JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(pdf));
                JasperViewer jv = new JasperViewer( jp, false );
                jv.viewReport( jp,false);

            }//C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources_7jan\\src\\payslip.jrxml
            else{//java.net.URL url = new java.net.URL("D:/qw/payslip.jrxml");
                InputStream  is2 = getClass().getResourceAsStream("earlyReport.jrxml");

                JasperDesign jd=JRXmlLoader.load(is2);
                int empid=Integer.parseInt(employeeid.getSelectedItem().toString());
                String sql="SELECT a.`ID` , a.`Name` ,b.Department,b.Designation, Concat(a.`Shift`,' ', a.`InTime`,'-', a.`OutTime`) as 'Shift Timings' ,a.`Date` , a.`checkintime` , a.`checkouttime` , a.`Total` , a.`Late` , a.`Early` , a.`OT` , a.`InOT` , a.`Late_Exceed` , a.`Early_Exceed`,'Status','Symbol',c.name as 'companyname' from calculation a,emp_list b,companyinfo c   where a.ID=b.ID and (a.ID='"+empid+"')  and a.`Early` > '00:00:00' and a.Date between '"+fromsql+"' and '"+tosql+"'  order by date";
                JRDesignQuery newQuery=new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);

                //String report="C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources\\src\\report1.jrxml";
                JasperReport jr=JasperCompileManager.compileReport(jd);
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(url,id,pass);
                JasperPrint jp=JasperFillManager.fillReport(jr,null,conn);
                File pdf = new File(reportDest);
                JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(pdf));
                //JasperViewer.viewReport(jp);
                JasperViewer jv = new JasperViewer( jp, false );
                jv.viewReport( jp,false);
            }

        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
         
         if(oT.isSelected()){             String reportDest = "D:\\OverTime-RPT.pdf";
        try{    java.util.Date sdate=from123.getDate();
            java.sql.Date fromsql=new java.sql.Date(sdate.getTime());
            java.util.Date sdate2=to123.getDate();
            java.sql.Date tosql=new java.sql.Date(sdate2.getTime());
            if(employeeid.getSelectedItem() == "All"){
                ArrayList ar=new ArrayList();
                for(int p=1;p < employeeid.getItemCount();p++){

                    ar.add("or a.ID="+employeeid.getItemAt(p));}
                String formattedString = ar.toString()
                .replace(",", "")  //remove the commas
                .replace("[", "")  //remove the right bracket
                .replace("]", "") ;

                InputStream is1 = getClass().getResourceAsStream("otReport.jrxml");

                JasperDesign jd=JRXmlLoader.load(is1);

                String sql="SELECT a.`ID` , a.`Name` ,b.Department,b.Designation, Concat(a.`Shift`,' ',a.`InTime`,'-', a.`OutTime`) as 'Shift Timings' ,a.`Date` , a.`checkintime` , a.`checkouttime` , a.`Total` , IFNUll(a.`Late`,0) as 'Late' , IFNUll(a.`Early`,0) as 'Early' , IFNUll(a.`OT`,0) as 'OT' , IFNUll(a.`InOT`,0) as 'InOT', IFNUll(a.`Late_Exceed`,0) as 'Late_Exceed' , IFNUll(a.`Early_Exceed`,0) as 'Early_Exceed','Status','Symbol',c.name as 'companyname',IFNUll(b.OT,0) as 'valueOT',IFNUll(TIME_TO_SEC(a.OT)/60/60,0) as 'hours'  from calculation a,emp_list b,companyinfo c  where a.ID=b.ID and (a.ID=0 "+formattedString+") and a.`OT` > '00:00:00' and a.Date between '"+fromsql+"' and '"+tosql+"'  order by b.Department";
                JRDesignQuery newQuery=new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);

                JasperReport jr=JasperCompileManager.compileReport(jd);
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(url,id,pass);
                JasperPrint jp=JasperFillManager.fillReport(jr,null,conn);
                JasperViewer.viewReport(jp,false);
                File pdf = new File(reportDest);
                JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(pdf));
                JasperViewer jv = new JasperViewer( jp, false );
                jv.viewReport( jp,false);

            }//C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources_7jan\\src\\payslip.jrxml
            else{//java.net.URL url = new java.net.URL("D:/qw/payslip.jrxml");
                InputStream  is2 = getClass().getResourceAsStream("otReport.jrxml");

                JasperDesign jd=JRXmlLoader.load(is2);
                int empid=Integer.parseInt(employeeid.getSelectedItem().toString());
                String sql="SELECT a.`ID` , a.`Name` ,b.Department,b.Designation, Concat(a.`Shift`,' ', a.`InTime`,'-', a.`OutTime`) as 'Shift Timings' ,a.`Date` , a.`checkintime` , a.`checkouttime` , a.`Total` , a.`Late` , a.`Early` , a.`OT` , a.`InOT` , a.`Late_Exceed` , a.`Early_Exceed`,'Status','Symbol',c.name as 'companyname',b.OT as 'valueOT',TIME_TO_SEC(a.OT)/60/60 as 'hours' from calculation a,emp_list b,companyinfo c   where a.ID=b.ID and (a.ID='"+empid+"')  and a.`OT` > '00:00:00' and a.Date between '"+fromsql+"' and '"+tosql+"'  order by b.Department";
                JRDesignQuery newQuery=new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);

                //String report="C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources\\src\\report1.jrxml";
                JasperReport jr=JasperCompileManager.compileReport(jd);
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(url,id,pass);
                JasperPrint jp=JasperFillManager.fillReport(jr,null,conn);
                File pdf = new File(reportDest);
                JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(pdf));
                //JasperViewer.viewReport(jp);
                JasperViewer jv = new JasperViewer( jp, false );
                jv.viewReport( jp,false);
            }

        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
         if(inOT.isSelected()){             String reportDest = "D:\\InOTAttendance.pdf";
        try{    java.util.Date sdate=from123.getDate();
            java.sql.Date fromsql=new java.sql.Date(sdate.getTime());
            java.util.Date sdate2=to123.getDate();
            java.sql.Date tosql=new java.sql.Date(sdate2.getTime());
            if(employeeid.getSelectedItem() == "All"){
                ArrayList ar=new ArrayList();
                for(int p=1;p < employeeid.getItemCount();p++){

                    ar.add("or a.ID="+employeeid.getItemAt(p));}
                String formattedString = ar.toString()
                .replace(",", "")  //remove the commas
                .replace("[", "")  //remove the right bracket
                .replace("]", "") ;

                InputStream is1 = getClass().getResourceAsStream("inOT.jrxml");

                JasperDesign jd=JRXmlLoader.load(is1);

                String sql="SELECT a.`ID` , a.`Name` ,b.Department,b.Designation, Concat(a.`Shift`,' ',a.`InTime`,'-', a.`OutTime`) as 'Shift Timings' ,a.`Date` , a.`checkintime` , a.`checkouttime` , a.`Total` , a.`Late` , a.`Early` , a.`OT` , a.`InOT` , a.`Late_Exceed` , a.`Early_Exceed`,'Status','Symbol',c.name as 'companyname' from calculation a,emp_list b,companyinfo c  where a.ID=b.ID and (a.ID=0 "+formattedString+") and a.`InOT` > '00:00:00' and a.Date between '"+fromsql+"' and '"+tosql+"' group by a.id  order by date";
                JRDesignQuery newQuery=new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);

                JasperReport jr=JasperCompileManager.compileReport(jd);
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(url,id,pass);
                JasperPrint jp=JasperFillManager.fillReport(jr,null,conn);
                JasperViewer.viewReport(jp,false);
  File pdf = new File(reportDest);
                JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(pdf));
                JasperViewer jv = new JasperViewer( jp, false );
                jv.viewReport( jp,false);

            }//C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources_7jan\\src\\payslip.jrxml
            else{//java.net.URL url = new java.net.URL("D:/qw/payslip.jrxml");
                InputStream  is2 = getClass().getResourceAsStream("inOT.jrxml");

                JasperDesign jd=JRXmlLoader.load(is2);
                int empid=Integer.parseInt(employeeid.getSelectedItem().toString());
                String sql="SELECT a.`ID` , a.`Name` ,b.Department,b.Designation, Concat(a.`Shift`,' ', a.`InTime`,'-', a.`OutTime`) as 'Shift Timings' ,a.`Date` , a.`checkintime` , a.`checkouttime` , a.`Total` , a.`Late` , a.`Early` , a.`OT` , a.`InOT` , a.`Late_Exceed` , a.`Early_Exceed`,'Status','Symbol',c.name as 'companyname' from calculation a,emp_list b,companyinfo c   where a.ID=b.ID and (a.ID='"+empid+"')  and a.`InOT` > '00:00:00' and a.Date between '"+fromsql+"' and '"+tosql+"'  order by date";
                JRDesignQuery newQuery=new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);

                //String report="C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources\\src\\report1.jrxml";
                JasperReport jr=JasperCompileManager.compileReport(jd);
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(url,id,pass);
                JasperPrint jp=JasperFillManager.fillReport(jr,null,conn);
                File pdf = new File(reportDest);
                JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(pdf));
                //JasperViewer.viewReport(jp);
                JasperViewer jv = new JasperViewer( jp, false );
                jv.viewReport( jp,false);
            }

        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void oTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oTActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
      DefaultTableModel model = (DefaultTableModel)Report1.getModel();
        int selectedRowIndex = Report1.getSelectedRow();

        // set the selected row data into jtextfields
        String idd=(model.getValueAt(selectedRowIndex, 0).toString());
        String date=(model.getValueAt(selectedRowIndex, 4).toString());
           leavemanage a=new leavemanage();
  a.setVisible(true);
       this.getDesktopPane().add(a);
       a.jTabbedPane1.setSelectedIndex(3);
      try{
a.setSelected(true);}catch(Exception e){} 
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       DefaultTableModel model = (DefaultTableModel)Report1.getModel();
        int selectedRowIndex = Report1.getSelectedRow();

        // set the selected row data into jtextfields
        String idd=(model.getValueAt(selectedRowIndex, 0).toString());
        String date=(model.getValueAt(selectedRowIndex, 4).toString());
      manualatt a=new manualatt();
  a.setVisible(true);
       this.getDesktopPane().add(a);
      try{
a.setSelected(true);}catch(Exception e){} 
        
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Report1;
    private javax.swing.JRadioButton aBS;
    private javax.swing.JRadioButton aLL;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> department;
    private javax.swing.JRadioButton eaR;
    private javax.swing.JComboBox<String> employee;
    private javax.swing.JComboBox<String> employeeid;
    private com.toedter.calendar.JDateChooser from123;
    private javax.swing.JRadioButton genReport;
    private javax.swing.JButton generate1;
    private javax.swing.JRadioButton hOL;
    private javax.swing.JRadioButton inOT;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
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
    private javax.swing.JRadioButton lEA;
    private javax.swing.JRadioButton laT;
    private javax.swing.JRadioButton oT;
    private javax.swing.JTable table21;
    private com.toedter.calendar.JDateChooser to123;
    // End of variables declaration//GEN-END:variables
}

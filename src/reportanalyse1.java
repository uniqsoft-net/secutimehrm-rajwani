import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import net.proteanit.sql.DbUtils;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.sql.CallableStatement;

public class reportanalyse1 extends javax.swing.JInternalFrame {
 dbclass dbd=new dbclass();
          String url=   dbd.server();
      String id=dbd.serverid();
      String pass=dbd.serverpass();
public void reset(){
    try{ 
        String dep=department2.getSelectedItem().toString();
         table21.getTableHeader().setFont( new Font( "Tahoma" , Font.BOLD, 12 ));

        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
if(dep == "All"){PreparedStatement pst2=con.prepareStatement("SELECT  `ID`, `Name`,stype FROM `emp_list`");
            ResultSet rst2=pst2.executeQuery();
            
        table21.setModel (DbUtils.resultSetToTableModel(rst2)); }
else{String query="SELECT  `ID`, `Name`,stype from emp_list where Department='"+dep+"'";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rst1=pst.executeQuery();table21.setModel (DbUtils.resultSetToTableModel(rst1));}}catch(Exception E){}}
    
    
 
 
public void SetData(Object obj, int row_index, int col_index){
  table22.getModel().setValueAt(obj,row_index,col_index);
  }
   public Object GetData(JTable table, int row_index, int col_index){
  return table.getModel().getValueAt(row_index, col_index); }

   public reportanalyse1() {
 
                  
               
        initComponents();
        //finally{try {pst.close();} catch (SQLException ex) {Logger.getLogger(shift.class.getName()).log(Level.SEVERE, null, ex);}}
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst=conn.prepareStatement("SELECT Department_Name FROM `department_list`");
           
            ResultSet rst1=pst.executeQuery();
            
           while(rst1.next()){
               
              department2.addItem(rst1.getString("Department_Name"));
           }}catch(Exception ex){}
    
     try{ 
         table21.getTableHeader().setFont( new Font( "Tahoma" , Font.BOLD, 12 ));

        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
       
             PreparedStatement pst2=con.prepareStatement("SELECT `ID`, `Name`,stype FROM `emp_list`");
            ResultSet rst2=pst2.executeQuery();
        table21.setModel (DbUtils.resultSetToTableModel(rst2)); }

        
     catch(Exception E){}
      
   }
   
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table22 = new javax.swing.JTable();
        night = new javax.swing.JButton();
        from123 = new com.toedter.calendar.JDateChooser();
        department2 = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        status123 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tinovertime = new javax.swing.JLabel();
        tlate = new javax.swing.JLabel();
        ttime = new javax.swing.JLabel();
        tearly = new javax.swing.JLabel();
        tovertime = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tday = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        pday = new javax.swing.JLabel();
        aday = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        eday = new javax.swing.JLabel();
        lday = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        sname123 = new javax.swing.JLabel();
        otday = new javax.swing.JLabel();
        inotday = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LEE = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        EEE = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        halfD = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Report1 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablen1 = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        mutipleQuery = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        otStFrm = new javax.swing.JTextField();
        inotStFrm = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        hdOT = new javax.swing.JCheckBox();
        jScrollPane10 = new javax.swing.JScrollPane();
        weekendH = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        table21 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablen = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablen2 = new javax.swing.JTable();
        generate = new javax.swing.JButton();
        night1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Calculate Reports");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/mainlogo.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(252, 126, 1));
        jLabel1.setText("Calculate Reports");

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel-btn-icon-20.png"))); // NOI18N
        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane7.setToolTipText("");
        jScrollPane7.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        table22.setAutoCreateRowSorter(true);
        table22.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        table22.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "ID No", "Department", "Desigation", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14", "Title 15", "Title 16", "Title 17"
            }
        ));
        table22.setMinimumSize(new java.awt.Dimension(1400, 100));
        table22.setNextFocusableComponent(night);
        table22.setPreferredSize(new java.awt.Dimension(1400, 100));
        table22.setRowHeight(25);
        table22.setSelectionBackground(new java.awt.Color(252, 126, 1));
        jScrollPane2.setViewportView(table22);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 2146, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 521, Short.MAX_VALUE))
        );

        jScrollPane7.setViewportView(jPanel4);

        night.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        night.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calculate-icon.png"))); // NOI18N
        night.setText("Calculate");
        night.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nightMousePressed(evt);
            }
        });
        night.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nightActionPerformed(evt);
            }
        });

        from123.setBackground(new java.awt.Color(0, 0, 0));
        from123.setForeground(new java.awt.Color(255, 255, 255));

        department2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        department2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                department2ActionPerformed(evt);
            }
        });

        jLabel36.setText("Select Month 1st Day:");

        jLabel37.setText("Select Department Criteria:");

        status123.setEditable(false);
        status123.setColumns(20);
        status123.setForeground(new java.awt.Color(252, 151, 1));
        status123.setRows(5);
        status123.setBorder(null);
        jScrollPane8.setViewportView(status123);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("Total Time");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("Total Late");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setText("Total Early");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setText("Total Over Time");

        tinovertime.setText("0");

        tlate.setText("0");

        ttime.setText("0");

        tearly.setText("0");

        tovertime.setText("0");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel9.setText("Total In Over Time");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setText("Total Days");

        tday.setText("0");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setText("Present Days");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel12.setText("Absent Days");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel13.setText("Late Days");

        pday.setText("0");

        aday.setText("0");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel14.setText("Early Days");

        eday.setText("0");

        lday.setText("0");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        sname123.setText("0");

        otday.setText("0");

        inotday.setText("0");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel17.setText("Shift Name");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel15.setText("OT Days");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel16.setText("In OT Days");

        jLabel3.setText("Late Exceed");

        LEE.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addGap(28, 28, 28)
                .addComponent(sname123, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel15)
                .addGap(34, 34, 34)
                .addComponent(otday, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(inotday, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(LEE, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LEE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sname123, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inotday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(otday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel4.setText("Early Exceed");

        EEE.setText("0");

        jLabel5.setText("0");

        halfD.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tday, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(31, 31, 31)
                                .addComponent(ttime, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(pday, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jLabel12))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tlate, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(aday, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel13))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tearly, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lday, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(jLabel14))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tovertime, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel9)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(EEE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tinovertime, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(halfD))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(eday, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11)
                                .addComponent(pday, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12)
                                .addComponent(aday, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13)
                                .addComponent(jLabel14)
                                .addComponent(eday, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lday, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(6, 6, 6))
                        .addComponent(tday, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(ttime, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(tearly, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tovertime, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tinovertime, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6)
                        .addComponent(tlate, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(EEE, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(halfD, javax.swing.GroupLayout.Alignment.LEADING)))
        );

        Report1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Report1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        Report1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Shift", "Date"
            }
        ));
        Report1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(Report1);

        tablen1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tablen1);

        mutipleQuery.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID:", "Name:", "Department:", "Designation:"
            }
        ));
        jScrollPane9.setViewportView(mutipleQuery);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Overtime Setting"));

        otStFrm.setText("45");

        inotStFrm.setText("45");

        jLabel19.setText("In OT Start From:");

        jLabel18.setText("OT Start From:");

        hdOT.setBackground(new java.awt.Color(255, 255, 255));
        hdOT.setText("Holiday count as OT");
        hdOT.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(otStFrm)
                            .addComponent(inotStFrm, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addComponent(hdOT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(otStFrm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inotStFrm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hdOT))
        );

        weekendH.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane10.setViewportView(weekendH);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reset-icon.png"))); // NOI18N
        jButton1.setText("Reset Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel37)
                                            .addComponent(jLabel36)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(department2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(from123, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(night, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton2))))
                                    .addComponent(jLabel1))
                                .addGap(207, 207, 207)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel37)
                                .addGap(0, 0, 0)
                                .addComponent(department2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(jLabel36)
                                .addGap(0, 0, 0)
                                .addComponent(from123, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(night)
                            .addComponent(jButton2)
                            .addComponent(jButton1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(533, 533, 533)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(170, 170, 170))
        );

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

        tablen.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tablen);

        tablen2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(tablen2);

        generate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        generate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calculate-icon.png"))); // NOI18N
        generate.setText("Calculate only day");
        generate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                generateMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                generateMousePressed(evt);
            }
        });
        generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateActionPerformed(evt);
            }
        });

        night1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        night1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calculate-icon.png"))); // NOI18N
        night1.setText("Calculate By Hours");
        night1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                night1MousePressed(evt);
            }
        });
        night1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                night1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(generate)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addComponent(night1)))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1051, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(506, 506, 506)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(290, 290, 290)
                .addComponent(night1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(generate)
                        .addGap(53, 53, 53))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(35, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generateMouseClicked

    }//GEN-LAST:event_generateMouseClicked

    private void generateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateActionPerformed
//jp_progress.setVisible(true);

        ArrayList<String> abz = new ArrayList<String>();
        for(int q=0; q < table21.getRowCount();q++ )
        abz.add(table21.getValueAt(q, 0).toString());
        
        ArrayList<String> abz2 = new ArrayList<String>();
        for(int q=0; q < table21.getRowCount();q++ )
        abz2.add(table21.getValueAt(q, 1).toString());
        String abzx="",abzx2="";
        Iterator a10,a11;
        a10=abz.iterator();
        a11=abz2.iterator();
        
        while ( a10.hasNext() && a11.hasNext())
        {abzx=a10.next().toString(); abzx2=a11.next().toString();
            String empid=abzx;
            String emp=abzx2;


            java.util.Date sdate=from123.getDate();
            java.sql.Date fromsql=new java.sql.Date(sdate.getTime());
            String Sdate="01";
            String month=Integer.toString(sdate.getMonth()+1);
            String year1=Integer.toString(sdate.getYear());
            String year2="20"+year1.subSequence(1, 3);
            int year=Integer.parseInt(year2);
            int day=sdate.getMonth()+1;
            String MonthOfName="unknown";
            switch (day) {
                case 1:
                MonthOfName = "January";
                day = 31;
                break;
                case 2:
                MonthOfName = "February";
                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                    day = 29;
                } else {
                    day = 28;
                }
                break;
                case 3:
                MonthOfName = "March";
                day = 31;
                break;
                case 4:
                MonthOfName = "April";
                day = 30;
                break;
                case 5:
                MonthOfName = "May";
                day = 31;
                break;
                case 6:
                MonthOfName = "June";
                day = 30;
                break;
                case 7:
                MonthOfName = "July";
                day = 31;
                break;
                case 8:
                MonthOfName = "August";
                day = 31;
                break;
                case 9:
                MonthOfName = "September";
                day = 30;
                break;
                case 10:
                MonthOfName = "October";
                day = 31;
                break;
                case 11:
                MonthOfName = "November";
                day = 30;
                break;
                case 12:
                MonthOfName = "December";
                day = 31;} 
            String day3=Integer.toString(day);
           
            //String emp=employee.getSelectedItem().toString();
            //int empid=1055;
            String t1="";String t2="";String t3="";String t4="";String t5="";String t6="";String t7="";String t8="";String t21="";String t22="";String t23="";String t24="";String t25="";String t26="";String t27="";
            String sh="";
            String lea="0";
            
            try{Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection(url,id,pass);
String taxy="0",leavey="0";
            String loan="0",advance="0";
                try{String query="SELECT `taxpay`, `leavepay` FROM `yealrypayment` WHERE `ID` = '"+empid+"' AND `date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"'";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rst2=pst.executeQuery();
        while (rst2.next()){taxy=rst2.getString("taxpay"); leavey=rst2.getString("leavepay");if(taxy==null){taxy="0";}if(leavey==null){leavey="0";}}}catch(Exception e){if(taxy.isEmpty()){taxy="0";}if(leavey==null){leavey="0";}}
                try{String query="SELECT  SUM(`advancepay`) FROM `advance` WHERE `emp_id` = '"+empid+"' AND `date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"'";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rst2=pst.executeQuery();
        while (rst2.next()){advance=rst2.getString("Sum(`advancepay`)");if(advance==null){advance="0";}}}catch(Exception e){if(advance==null){advance="0";}  }
                try{String query="SELECT  `installment_pay` FROM `loan_manage` WHERE `emp_id` = '"+empid+"' AND `date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"'";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rst2=pst.executeQuery();
        while (rst2.next()){loan=rst2.getString("installment_pay");if(loan==null){loan="0";}}}catch(Exception e){ if(loan==null){loan="0";}}
         
                 System.out.println(loan+" "+ advance+" "+leavey+" "+taxy);
           
                String query="SELECT a.User_ID as 'Employee ID', b.Name as 'Employee Name', c.Num_Run_name as 'Shift Name', TIME(c.Start_Time) as 'IN Time', TIME(c.End_Time) as 'OUT Time', if(TIMEDIFF(TIME(c.End_Time),TIME(c.Start_Time))< 0,0,TIMEDIFF(TIME(c.End_Time),TIME(c.Start_Time))) as 'Total Shift Time' ,d.Date as 'Date',MIN(d.time) as 'Checkin Time',MAX(d.time) as 'Checkout Time',TIMEDIFF(MAX(d.time),MIN(d.time)) as 'Total Time',if(TIMEDIFF(MIN(d.time),TIME(c.Late_Exceed))< 0,0,TIMEDIFF(MIN(d.time),TIME(c.Late_Exceed))) as 'Late',if(TIMEDIFF(TIME(c.Early_Exceed),Max(d.time))< 0,0,TIMEDIFF(TIME(c.Early_Exceed),Max(d.time))) as 'Early',if(TIMEDIFF(Max(d.time),TIME(c.Over_Time))< 0,0,TIMEDIFF(Max(d.time),TIME(c.Over_Time))) as 'Over Time',if(TIMEDIFF(TIME(c.In_OT_Exceed),Min(d.time))< 0,0,TIMEDIFF(TIME(c.In_OT_Exceed),Min(d.time))) as 'Coming OT',if(TIMEDIFF(MIN(d.time),TIME(c.late_after))< 0,0,TIMEDIFF(MIN(d.time),TIME(c.late_after))) as 'Late Exceed',if(TIMEDIFF(TIME(c.early_before),Max(d.time))< 0,0,TIMEDIFF(TIME(c.early_before),Max(d.time))) as 'Early_Exceed' FROM emp_list b,num_run_days c,attendance d,user_of_run2 a WHERE a.User_ID='"+empid+"' and Name='"+emp+"' and a.User_ID=d.id  and d.Date between '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' AND a.Num_of_run=c.Num_RunID AND c.s_Days=DAYOFWEEK(d.Date) group by d.Date";
               
                PreparedStatement pst=con.prepareStatement(query);
                ResultSet rst1=pst.executeQuery();
                Report1.setModel (DbUtils.resultSetToTableModel(rst1));
              
                ArrayList<String> totaltime = new ArrayList<String>();
                ArrayList<String> date = new ArrayList<String>();
                ArrayList<String> totallate = new ArrayList<String>();
                ArrayList<String> totalearly = new ArrayList<String>();
                ArrayList<String> totalovertime = new ArrayList<String>();
                ArrayList<String> id = new ArrayList<String>();
                ArrayList<String> name = new ArrayList<String>();
                ArrayList<String> inovertime = new ArrayList<String>();
                ArrayList<String> lateexceed = new ArrayList<String>();
                ArrayList<String> earlyexceed = new ArrayList<String>();
                ArrayList<String> shift = new ArrayList<String>();
                ArrayList<String> intime = new ArrayList<String>();
                ArrayList<String> outtime = new ArrayList<String>(); 
                ArrayList<String> checkin = new ArrayList<String>(); 
                ArrayList<String> checkout = new ArrayList<String>(); 
                sname123.setText(Report1.getValueAt(0, 2).toString());
                for(int q=0; q < Report1.getRowCount() ;q++ ){
                totaltime.add(Report1.getValueAt(q, 9).toString());
                   date.add(Report1.getValueAt(q, 6).toString());
                totallate.add(Report1.getValueAt(q, 10).toString());

                totalearly.add(Report1.getValueAt(q, 11).toString());

                totalovertime.add(Report1.getValueAt(q, 12).toString());

                id.add(Report1.getValueAt(q, 0).toString());

                name.add(Report1.getValueAt(q, 1).toString());

                inovertime.add(Report1.getValueAt(q, 13).toString());
                
                lateexceed.add(Report1.getValueAt(q, 14).toString());
              
                earlyexceed.add(Report1.getValueAt(q, 15).toString());
                    
                shift.add(Report1.getValueAt(q, 2).toString());
                
                intime.add(Report1.getValueAt(q, 3).toString());
                outtime.add(Report1.getValueAt(q, 4).toString());
                checkin.add(Report1.getValueAt(q, 7).toString());
                checkout.add(Report1.getValueAt(q, 8).toString());//JOptionPane.showMessageDialog(null, "4");
                }
                Iterator a1,a2,a3,a4,a5,a6,a7,a8,a21,a22,a23,a24,a25,a26,a27; {
                    a1=totaltime.iterator();
                    a2=totallate.iterator();
                    a3=totalearly.iterator();
                    a4=totalovertime.iterator();
                    a5=id.iterator();
                    a6=name.iterator();
                    a7=date.iterator();
                    a8=inovertime.iterator();
                     a21=shift.iterator();
                    a22=intime.iterator();
                    a23=outtime.iterator();
                    a24=checkin.iterator();
                    a25=checkout.iterator();
                    a26=lateexceed.iterator();
                    a27=earlyexceed.iterator();
                    while ( a1.hasNext() && a2.hasNext() && a3.hasNext() && a4.hasNext() && a5.hasNext() && a6.hasNext() && a7.hasNext() && a8.hasNext() && a21.hasNext() && a22.hasNext() && a23.hasNext() && a24.hasNext() && a25.hasNext() && a26.hasNext() && a27.hasNext() ){
                        t1=a1.next().toString();
                        t2=a2.next().toString();
                        t3=a3.next().toString();
                        t4=a4.next().toString();
                        t5=a5.next().toString();
                        t6=a6.next().toString();
                        t7=a7.next().toString();
                        t8=a8.next().toString();
                        t21=a21.next().toString();
                        t22=a22.next().toString();
                        t23=a23.next().toString();
                        t24=a24.next().toString();
                        t25=a25.next().toString();
                        t26=a26.next().toString();
                        t27=a27.next().toString();//JOptionPane.showMessageDialog(null, "3");
                        //JOptionPane.showMessageDialog(null,lea);
                         Statement st=con.createStatement();
int k=st.executeUpdate("replace into calculation (`ID`,Name,Shift,InTime,OutTime,Date,checkintime,checkouttime,Total,Late,Early,OT,InOT,Late_Exceed,Early_Exceed) values('"+t5+"','"+t6+"','"+t21+"','"+t22+"','"+t23+"','"+t7+"','"+t24+"','"+t25+"','"+t1+"','"+t2+"','"+t3+"','"+t4+"','"+t8+"','"+t26+"','"+t27+"') ");
                    }    } 
                    String query2="SELECT SUM(TIME_TO_SEC(Total)/60/60),SUM(TIME_TO_SEC(Late)/60/60),SUM(TIME_TO_SEC(Early)/60/60),SUM(TIME_TO_SEC(OT)/60/60),SUM(TIME_TO_SEC(InOT)/60/60),SUM(TIME_TO_SEC(Late_Exceed)/60/60),SUM(TIME_TO_SEC(Early_Exceed)/60/60) FROM calculation where id='"+empid+"' and Date between '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"'  order by Date" ;
                    PreparedStatement pst2=con.prepareStatement(query2);
                    ResultSet rst2=pst2.executeQuery();
                    if(rst2.next()){
                        ttime.setText(rst2.getString("SUM(TIME_TO_SEC(Total)/60/60)"));
                        tlate.setText(rst2.getString("SUM(TIME_TO_SEC(Late)/60/60)"));
                        tearly.setText(rst2.getString("SUM(TIME_TO_SEC(Early)/60/60)"));
                        tovertime.setText(rst2.getString("SUM(TIME_TO_SEC(OT)/60/60)"));
                        tinovertime.setText(rst2.getString("SUM(TIME_TO_SEC(InOT)/60/60)"));
                        pday.setText(Integer.toString(Report1.getRowCount())); 
                        LEE.setText(rst2.getString("SUM(TIME_TO_SEC(Late_Exceed)/60/60)"));
                        EEE.setText(rst2.getString("SUM(TIME_TO_SEC(Early_Exceed)/60/60)"));}
                        String query3="select COUNT(a.Start_Date) FROM user_of_run2 a,num_run_days b WHERE Dayofweek(a.Start_Date)=b.s_Days AND a.Num_of_run = b.Num_RunID AND a.Start_Date BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' AND a.User_ID='"+empid+"'";
                    PreparedStatement pst3=con.prepareStatement(query3);
                 //JOptionPane.showMessageDialog(null, "2");       
                    ResultSet rst3=pst3.executeQuery();
                    if(rst3.next()){
                        tday.setText(rst3.getString("COUNT(a.Start_Date)"));//(rst3.getString("COUNT(Start_Date)"));
                    aday.setText(Integer.toString(Integer.parseInt(tday.getText())-Integer.parseInt(pday.getText())));}
                    String query4="SELECT COUNT(Late) FROM `calculation` WHERE `ID` = '"+empid+"' AND `Date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' AND `Late` > '00:00:00'";
                    PreparedStatement pst4=con.prepareStatement(query4);
                    ResultSet rst4=pst4.executeQuery(); 
                    if(rst4.next()){
                        lday.setText(rst4.getString("COUNT(Late)"));}
                    String query5="SELECT COUNT(Early) FROM `calculation` WHERE `ID` = '"+empid+"' AND `Date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' AND `Early` > '00:00:00'";
                    PreparedStatement pst5=con.prepareStatement(query5);
                    ResultSet rst5=pst5.executeQuery();
                    if(rst5.next()){
                        eday.setText(rst5.getString("Count(Early)"));}
                    String query6="SELECT COUNT(OT) FROM `calculation` WHERE `ID` = '"+empid+"' AND `Date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' AND `OT` > '00:00:00'";
                    PreparedStatement pst6=con.prepareStatement(query6);
                    ResultSet rst6=pst6.executeQuery();
                    if(rst6.next()){
                        otday.setText(rst6.getString("Count(OT)"));}
                    String query7="SELECT COUNT(InOT) FROM `calculation` WHERE `ID` = '"+empid+"' AND `Date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' AND `InOT` > '00:00:00'";
                    PreparedStatement pst7=con.prepareStatement(query7);
                    ResultSet rst7=pst7.executeQuery();
                    if(rst7.next()){
                        inotday.setText(rst7.getString("Count(InOT)"));
                    }
                    String z1,z2,z3,z4,z5,z13; int z6,z7,z8,z9,z10,z11,z12,z14,z15;
                    z1=tday.getText();
                    z2=pday.getText();
                    z3=aday.getText();
                    z4=lday.getText();
                    z5=eday.getText();
                    z6=(int) Double.parseDouble(tovertime.getText());
                    z7=(int) Double.parseDouble(tinovertime.getText());
                    z8=(int) Double.parseDouble(ttime.getText());
                    z9=(int) Double.parseDouble(tlate.getText());
                    z10=(int) Double.parseDouble(tearly.getText());
                    z11=(int) Double.parseDouble(otday.getText());
                    z12=(int) Double.parseDouble(inotday.getText());
                    z13=sname123.getText();
                    z14= (int) Double.parseDouble(LEE.getText());
                    z15= (int) Double.parseDouble(EEE.getText());
                // JOptionPane.showMessageDialog(null, "1");
                    System.out.println(z14 +"\n"+ z15);
                  String query23="select count(leave_name) from leave_employee where Date between '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' and emp_id='"+empid+"'";
                    PreparedStatement pst23=con.prepareStatement(query23);
            ResultSet rst23=pst23.executeQuery();
            if(rst23.next()){
            lea=rst23.getString("count(leave_name)");}
            String query24="select count(holiday_name) from holiday_employee where Date between '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' and emp_id='"+empid+"'";
                    PreparedStatement pst24=con.prepareStatement(query24);
            ResultSet rst24=pst24.executeQuery();String holid="0";
            if(rst24.next()){
            holid=rst24.getString("count(holiday_name)");}
            
                    //JOptionPane.showMessageDialog(null, "2");
                    Statement st=con.createStatement();//  ,'1','"+z14+"','"+z15+"'
                    int k=st.executeUpdate("Replace INTO `"
                            + "attendancemonth`(`ID`, `Name`, `Department`, `Shift`,`Date`,`Total_Day`, `PresentDay`, `AbsentDay`, `LateDay`, `EarlyDay`, `OT`, `InOT`, `TotalTime`, `TotalLate`, `TotalEarly`, `TotalOT`, `TotalinOT`,`NET_Salary`,`Late_Exceed`,`Early_Exceed`, `loanins`, `advance`, `leavey`, `taxy`) VALUES ('"+empid+"','"+emp+"','"+lea+"','"+z13+"','"+year2+"-"+month+"-"+Sdate+"','"+z1+"','"+z2+"','"+z3+"','"+z4+"','"+z5+"','"+z6+"','"+z7+"','"+z8+"','"+z9+"','"+z10+"','"+z11+"','"+z12+"','"+holid+"','"+z14+"','"+z15+"','"+loan+"','"+advance+"','"+leavey+"','"+taxy+"')");
                }catch(Exception e){JOptionPane.showMessageDialog(null,e+"1");}}
                System.out.println("qw1");
          try{java.util.Date sdate=from123.getDate();
            java.sql.Date fromsql=new java.sql.Date(sdate.getTime());        
              Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection(url,id,pass);
String query22="select a.`ID`, a.`Name`, b.`Department`, a.`Shift`, a.`Date`, a.`Total_Day` as 'Total Days', a.`PresentDay`, a.`AbsentDay`, a.`LateDay`, a.`EarlyDay`, a.`OT`, a.`InOT`, b.`Salary`, b.`Medical`, b.`HouseRent`, b.`Convence`, b.`Dearness`, b.`OT`,b.Late,b.Early, b.`Tax`,a.TotalLate,a.TotalEarly, a.`NET_Salary`,a.Late_Exceed,a.Early_Exceed,b.Late_Exceed,b.Early_Exceed,b.designation,b.bank,a.Department, a.loanins, a.advance, a.leavey, a.taxy,b.eobi,b.sessi  from attendancemonth a,emp_list b where a.ID=b.ID and a.Date='"+fromsql+"'";
           PreparedStatement pst22=con.prepareStatement(query22);
            ResultSet rst22=pst22.executeQuery();
            table22.setModel (DbUtils.resultSetToTableModel(rst22));
        System.out.println("qw2");
        int rows= table22.getRowCount();
        for(int i=0;i<rows;i++){
            
            int idd = Integer.parseInt(GetData(table22, i, 0).toString());
            String namee = GetData(table22, i, 1).toString();
            String departt = GetData(table22, i, 2).toString();
            String shiftt = GetData(table22, i, 3).toString();
            String datee = GetData(table22, i, 4).toString();
            double today = Double.parseDouble(GetData(table22, i, 5).toString());
            double poday = Double.parseDouble(GetData(table22, i, 6).toString());
            double aoday = Double.parseDouble(GetData(table22, i, 7).toString());
            double loday = Double.parseDouble(GetData(table22, i, 8).toString());
            double eoday = Double.parseDouble(GetData(table22, i, 9).toString());
            double oothour = Double.parseDouble(GetData(table22, i, 10).toString());
            double ionot = Double.parseDouble(GetData(table22, i,11).toString());
            double soalary = Double.parseDouble(GetData(table22, i, 12).toString());
            double moedical = Double.parseDouble(GetData(table22, i, 13).toString());
            double hoouse = Double.parseDouble(GetData(table22, i, 14).toString());
            double coonvance = Double.parseDouble(GetData(table22, i, 15).toString());
            double doearness = Double.parseDouble(GetData(table22, i, 16).toString());
            double oot = Double.parseDouble(GetData(table22, i, 17).toString());
            double  loate= Double.parseDouble(GetData(table22, i, 18).toString());
            double eoarly = Double.parseDouble(GetData(table22, i, 19).toString());
            double  toax= Double.parseDouble(GetData(table22, i, 20).toString());
            //  double  latehour= Double.parseDouble(GetData(table22, i, 21).toString());
            // double  earlyhour= Double.parseDouble(GetData(table22, i, 22).toString());     
            double  latehourexceed= Double.parseDouble(GetData(table22, i, 24).toString());
            double  earlyhourexceed= Double.parseDouble(GetData(table22, i, 25).toString()); 
            double  latehourdeduct= Double.parseDouble(GetData(table22, i, 26).toString());
            double  earlyhourdeduct= Double.parseDouble(GetData(table22, i, 27).toString()); 
            String desig = GetData(table22, i, 28).toString();
            String bank = GetData(table22, i, 29).toString();            
            double  leve= Double.parseDouble(GetData(table22, i, 30).toString());
            String loan=GetData(table22, i, 31).toString(); 
           String advance=GetData(table22, i, 32).toString();
            String leavey=GetData(table22, i, 33).toString(),taxy=GetData(table22, i, 34).toString();
            Double eobi=Double.parseDouble(GetData(table22, i, 35).toString()), sessi=Double.parseDouble(GetData(table22, i, 36).toString());
            Double holida=Double.parseDouble(GetData(table22, i, 23).toString());
            int wer=(int)loday;
            
            int late=0;int early=0;
            
            if(loate <= loday  && loate*2 >= loday ){late=1;}
            if(loate*2 <= loday && loate*3 >= loday ){late=2;}
            if(loate*3 <= loday && loate*4 >= loday ){late=3;}
            if(loate*4 <= loday && loate*5 >= loday ){late=4;}
           if(loate*5 <= loday && loate*6 >= loday ){late=5;}
           if(loate*6 <= loday && loate*7 >= loday ){late=6;}
           if(loate*7 <= loday && loate*8 >= loday ){late=7;}
           if(loate*8 <= loday && loate*9 >= loday ){late=8;}
           if(loate*9 <= loday  && loate*10 >= loday ){late=9;}
            if(loate*10 <= loday && loate*11 >= loday ){late=10;}
            if(loate*11 <= loday && loate*12 >= loday ){late=11;}
            if(loate*12 <= loday && loate*13 >= loday ){late=12;}
           if(loate*13 <= loday && loate*14 >= loday ){late=13;}
           if(loate*14 <= loday && loate*15 >= loday ){late=14;}
           if(loate*15 <= loday && loate*16 >= loday ){late=15;}
           if(loate*16 <= loday && loate*17 >= loday ){late=16;}
              if(loate*17 <= loday && loate*18 >= loday ){late=17;}
            if(loate*18 <= loday && loate*19 >= loday ){late=18;}
            if(loate*19 <= loday && loate*20 >= loday ){late=19;}
           if(loate*20 <= loday && loate*21 >= loday ){late=20;}
           if(loate*21 <= loday && loate*22 >= loday ){late=21;}
           if(loate*22 <= loday && loate*23 >= loday ){late=22;}
           if(loate*23 <= loday && loate*24 >= loday ){late=23;}
           if(loate*24 <= loday  && loate*25 >= loday ){late=24;}
            if(loate*25 <= loday && loate*26 >= loday ){late=25;}
            if(loate*26 <= loday && loate*27 >= loday ){late=26;}
            if(loate*27 <= loday && loate*28 >= loday ){late=27;}
           if(loate*28 <= loday && loate*29 >= loday ){late=28;}
           if(loate*29 <= loday && loate*30 >= loday ){late=29;}
           if(loate*30 <= loday && loate*31 >= loday ){late=30;}
          // if(loate*31 <= loday ){late=31;}
           
            if(eoarly <= eoday  && eoarly*2 >= eoday ){early=1;}
            if(eoarly*2 <= eoday && eoarly*3 >= eoday ){early=2;}
            if(eoarly*3 <= eoday && eoarly*4 >= eoday ){early=3;}
            if(eoarly*4 <= eoday && eoarly*5 >= eoday ){early=4;}
           if(eoarly*5 <= eoday && eoarly*6 >= eoday ){early=5;}
           if(eoarly*6 <= eoday && eoarly*7 >= eoday ){early=6;}
           if(eoarly*7 <= eoday && eoarly*8 >= eoday ){early=7;}
           if(eoarly*8 <= eoday && eoarly*9 >= eoday ){early=8;}
           if(eoarly*9 <= eoday  && eoarly*10 >= eoday ){early=9;}
            if(eoarly*10 <= eoday && eoarly*11 >= eoday ){early=10;}
            if(eoarly*11 <= eoday && eoarly*12 >= eoday ){early=11;}
            if(eoarly*12 <= eoday && eoarly*13 >= eoday ){early=12;}
           if(eoarly*13 <= eoday && eoarly*14 >= eoday ){early=13;}
           if(eoarly*14 <= eoday && eoarly*15 >= eoday ){early=14;}
           if(eoarly*15 <= eoday && eoarly*16 >= eoday ){early=15;}
           if(eoarly*16 <= eoday && eoarly*17 >= eoday ){early=16;}
              if(eoarly*17 <= eoday && eoarly*18 >= eoday ){early=17;}
            if(eoarly*18 <= eoday && eoarly*19 >= eoday ){early=18;}
            if(eoarly*19 <= eoday && eoarly*20 >= eoday ){early=19;}
           if(eoarly*20 <= eoday && eoarly*21 >= eoday ){early=20;}
           if(eoarly*21 <= eoday && eoarly*22 >= eoday ){early=21;}
           if(eoarly*22 <= eoday && eoarly*23 >= eoday ){early=22;}
           if(eoarly*23 <= eoday && eoarly*24 >= eoday ){early=23;}
           if(eoarly*24 <= eoday  && eoarly*25 >= eoday ){early=24;}
            if(eoarly*25 <= eoday && eoarly*26 >= eoday ){early=25;}
            if(eoarly*26 <= eoday && eoarly*27 >= eoday ){early=26;}
            if(eoarly*27 <= eoday && eoarly*28 >= eoday ){early=27;}
           if(eoarly*28 <= eoday && eoarly*29 >= eoday ){early=28;}
           if(eoarly*29 <= eoday && eoarly*30 >= eoday ){early=29;}
           if(eoarly*30 <= eoday && eoarly*31 >= eoday ){early=30;}
           if(eoarly*31 <= eoday ){early=31;}
           
           double abse=aoday;          
            //Calculation
            double tot2=(oothour+ionot)*oot;
            double tot=soalary;
           //deductions
            double lhd=latehourexceed*latehourdeduct;
            double ehd=earlyhourexceed*earlyhourdeduct;
            double tot4=(tot/today)*late;
            double tot5=(tot/today)*early;
            if(loan.isEmpty()){loan="0";} if(taxy.isEmpty()){taxy="0";}if(leavey.isEmpty()){leavey="0";}if(advance.isEmpty()){advance="0";}
        int loana=Integer.parseInt(loan);int taxaa=Integer.parseInt(taxy);int leaveyy=Integer.parseInt(leavey);int advanced=Integer.parseInt(advance);
            //int leave=0;
            //if(aoday>0) {leave = 1;} if(aoday > 1){leave = 2;}
            //double lew=(tot/today)*leave;
           // double absent=((tot/today)*aoday);
            //double tot13=(((tot)-((tot4+tot5+lhd+ehd-absent)))-toax)+(moedical+hoouse+coonvance+doearness+tot2);
            double tot3=((((tot/today)*(poday+leve+leaveyy+holida))-((tot4+tot5+lhd+ehd+taxaa+loana+advanced+eobi+sessi)))-toax)+(moedical+hoouse+coonvance+doearness+tot2);
            int tot7=(int)tot3;
            table22.setValueAt(tot7, i, 23);
            double  salary= Double.parseDouble(GetData(table22, i, 23).toString());            
 

    Statement st2=con.createStatement();  
int k=st2.executeUpdate("Replace INTO `report`(`ID`, `Name`, `Department`,`designation`,`bank`, `Shift`, `Date`, `Days`, `PresentDay`, `AbsentDay`, `LateDay`, `EarlyDay`,late_hour,early_hour, `OverTime`, `InOverTime`, `Salary`, `Medical`, `HouseRent`, `Convence`, `Dearness`, `OT`, `Late`, `Early`,late_h,early_h, `Tax`,`leave`, `yearly_tax`, `leave_encash`, `loan`, `advance`,`holiday`,Eobi,Sessi, `Net_Salary`) VALUES ('"+idd+"','"+namee+"','"+departt+"','"+desig+"','"+bank+"','"+shiftt+"','"+datee+"','"+today+"','"+poday+"','"+abse+"','"+loday+"','"+eoday+"','"+latehourexceed+"','"+earlyhourexceed+"','"+oothour+"','"+ionot+"','"+soalary+"','"+moedical+"','"+hoouse+"','"+coonvance+"','"+doearness+"','"+oot+"','"+late+"','"+early+"','"+latehourdeduct+"','"+earlyhourdeduct+"','"+toax+"','"+leve+"','"+taxaa+"','"+leaveyy+"','"+loana+"','"+advanced+"','"+holida+"','"+eobi+"','"+sessi+"','"+salary+"')");

//       jp_progress.UpdateProgress(100);
        }}
           catch(Exception e){JOptionPane.showMessageDialog(null,e+"2");}
        
    }//GEN-LAST:event_generateActionPerformed

 
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void generateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generateMousePressed

    }//GEN-LAST:event_generateMousePressed

    private void department2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_department2ActionPerformed
        reset();
        //finally{try {pst.close();} catch (SQLException ex) {Logger.getLogger(shift.class.getName()).log(Level.SEVERE, null, ex);}}
    }//GEN-LAST:event_department2ActionPerformed

    private void nightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nightActionPerformed
        status123.setText("Processing");
        
            java.util.Date sdate=from123.getDate();
          
            String Sdate="01";
            String month=Integer.toString(sdate.getMonth()+1);
            String year1=Integer.toString(sdate.getYear());
            String year2="20"+year1.subSequence(1, 3);
            int year=Integer.parseInt(year2);
            int day=sdate.getMonth()+1;
          // String MonthOfName="unknown";
            switch (day) {
                case 1:day = 31;break;
                case 2:if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                    day = 29;
                } else {
                    day = 28;}break;
                case 3:day = 31;break;
                case 4:day = 30;break;
                case 5:day = 31;break;
                case 6:day = 30;break;
                case 7:day = 31;break;
                case 8:day = 31;break;
                case 9:day = 30;break;
                case 10:day = 31; break;
                case 11:day = 30;break;
                case 12:day = 31;
            } 
            String day3=Integer.toString(day);
 


         new Thread (new Runnable(){
          @Override
          public void run(){
       try{
       Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection(url,id,pass);                 
     //   try{Thread.sleep(500);}catch(Exception e){}
                    
           
           
              for(int q=0; q < table21.getRowCount();q++ ){
        String empid=   (table21.getValueAt(q, 0).toString());
        String emp=     (table21.getValueAt(q, 1).toString());
        int stype=     Integer.parseInt(table21.getValueAt(q, 2).toString());
        if(stype == 0){
       
 CallableStatement cStmt1 = con.prepareCall(" CALL `get_out`(?, ?, ?);");     
 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
Calendar c1 = Calendar.getInstance();
c1.setTime(sdf1.parse(year2+"-"+month+"-"+day3));
c1.add(Calendar.DATE, 1);  // number of days to add
String date1 = sdf1.format(c1.getTime()); 
 cStmt1.setInt(1, Integer.parseInt(empid));cStmt1.setString(2,year2+"-"+month+"-"+Sdate );cStmt1.setString(3, date1);   
System.out.println(date1);
//   ResultSet rst41=pst41.executeQuery(); //collect In
  ResultSet rs1;
         rs1 = cStmt1.executeQuery();                 
                //collect out
            tablen1.setModel (DbUtils.resultSetToTableModel(rs1));System.out.println("solve2");  
            
            int rows= tablen1.getRowCount();
       for(int i=0;i<rows;i++){
            String stat = GetData(tablen1, i, 4).toString();
         if(stat.equalsIgnoreCase("true"))  {
              String date = GetData(tablen1, i, 3).toString();
      
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
Calendar c = Calendar.getInstance();
c.setTime(sdf.parse(date));
c.add(Calendar.DATE, -1);  // number of days to add
date = sdf.format(c.getTime()); 
tablen1.setValueAt(date, i, 3);//Date Decrement if night true
             } 
       }
            
            
               for(int u=0; u < tablen1.getRowCount();u++ )
                {   String t549=(tablen1.getValueAt(u, 0).toString()); 
                    String t550=(tablen1.getValueAt(u, 1).toString());
                    String t551=(tablen1.getValueAt(u, 2).toString()); 
                    String t552=(tablen1.getValueAt(u, 3).toString()); 
                     Statement st43=con.createStatement();
                int k43=st43.executeUpdate("replace into night1 values('"+t549+"','"+t552+"','"+t550+" "+t551+"','"+t550+" "+t551+"')");System.out.println("solve4");
  Statement st3=con.createStatement();
  int k3=st3.executeUpdate("insert into nighttime(`id`, `date`, `timein`, `timeout`) values('"+t549+"','"+t552+"','"+t550+" "+t551+"','"+t550+" "+t551+"') ON DUPLICATE KEY UPDATE timeout='"+t550+" "+t551+"' ");                  
                   
                       
                       
                }  
            
             String lea="0";
                String taxy="0",leavey="0", loan="0",advance="0";
                CallableStatement cStmt = con.prepareCall(" CALL `get_in`(?, ?, ?);");       
 cStmt.setInt(1, Integer.parseInt(empid));cStmt.setString(2,year2+"-"+month+"-"+Sdate );cStmt.setString(3, year2+"-"+month+"-"+day3);   

//   ResultSet rst41=pst41.executeQuery(); //collect In
  ResultSet rs = cStmt.executeQuery();
tablen.setModel (DbUtils.resultSetToTableModel(rs)); 
 
  System.out.println("solve");           
 
                for(int u=0; u < tablen.getRowCount();u++ )
                {String t41=(tablen.getValueAt(u, 0).toString()); 
                String t42=(tablen.getValueAt(u, 1).toString());
               String t43=(tablen.getValueAt(u, 2).toString());
                String t44=(tablen.getValueAt(u, 3).toString());
               
       Statement st41=con.createStatement();
  int k41=st41.executeUpdate("replace into night values('"+t41+"','"+t42+"','"+t42+" "+t43+"')");System.out.println("solve3"); 
                
 Statement st42=con.createStatement();
  int k42=st42.executeUpdate("insert into nighttime(`id`, `date`, `timein`, `timeout`) values('"+t41+"','"+t42+"','"+t42+" "+t43+"','"+t42+" "+t44+"') ON DUPLICATE KEY UPDATE timein='"+t42+" "+t43+"'");              
                status123.setText(status123.getText()+".");
                }
               
 try{
            String query44="SELECT a.id, a.date , a.timein, b.timeout FROM night a,night1 b, user_of_run2 d WHERE a.id='"+empid+"' and d.Start_Date between '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' and a.id=b.id and a.date=b.date group by date";
            PreparedStatement pst43=con.prepareStatement(query44);
            ResultSet rst43=pst43.executeQuery();
            tablen2.setModel (DbUtils.resultSetToTableModel(rst43));                    
             System.out.println("slove");
//ArrayList<String> id4 = new ArrayList<String>();ArrayList<String> date4 = new ArrayList<String>();ArrayList<String> timein = new ArrayList<String>();ArrayList<String> timeout = new ArrayList<String>(); 
                
for(int u=0; u < tablen2.getRowCount();u++ )
                {String t60=(tablen2.getValueAt(u, 0).toString()); 
                String t61=(tablen2.getValueAt(u, 1).toString());
               String t62=(tablen2.getValueAt(u, 2).toString());
               String t63=(tablen2.getValueAt(u, 3).toString());
                  Statement st44=con.createStatement();
  int k44=st44.executeUpdate("replace into nighttime values('"+t60+"','"+t61+"','"+t62+"','"+t63+"')");
System.out.println("solve5");status123.setText(status123.getText()+".");
                } }catch(Exception f){JOptionPane.showMessageDialog(null, f+"s1");}
               // try{
 String query45="SELECT a.User_ID , b.Name , a.shiftname, a.starttime, a.endtime,TIMEDIFF(a.endtime,a.starttime) as 'Total Shift Time' ,d.Date as 'Date',d.timein as 'Checkin Time',d.timeout as 'Checkout Time',TIMEDIFF(d.timeout,d.timein) as 'Total Time',if(TIMEDIFF(d.timein,a.late)< 0,0,TIMEDIFF(d.timein,a.late)) as 'Late',if(TIMEDIFF(a.early,d.timeout)< 0,0,TIMEDIFF(a.early,d.timeout)) as 'Early',if(TIMEDIFF(d.timeout,a.ot) < 0,0,TIMEDIFF(d.timeout,a.ot)) as 'Over Time',if(TIMEDIFF(a.inot,d.timein)< 0,0,TIMEDIFF(a.inot,d.timein)) as 'Coming OT',if(TIMEDIFF(d.timein,a.lateexceed)< 0,0,TIMEDIFF(d.timein,a.lateexceed)) as 'Late Exceed',if(TIMEDIFF(a.earlyexceed,d.timeout)< 0,0,TIMEDIFF(a.earlyexceed,d.timeout)) as 'Early_Exceed' FROM emp_list b,nighttime d,user_of_run2 a WHERE a.User_ID='"+empid+"' and b.Name='"+emp+"' and a.User_ID=d.id and a.Start_Date=d.date and a.Start_Date between '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' group by d.Date";
          timeTOminute t2m=new timeTOminute();
                PreparedStatement pst=con.prepareStatement(query45);//SELECT a.User_ID as 'Employee ID', b.Name as 'Employee Name', c.Num_Run_name as 'Shift Name', c.Start_Time as 'IN Time', c.End_Time as 'OUT Time',TIMEDIFF(c.End_Time,c.Start_Time) as 'Total Shift Time' ,d.Date as 'Date',d.timein as 'Checkin Time',d.timeout as 'Checkout Time',TIMEDIFF(d.timeout,d.timein) as 'Total Time',if(TIMEDIFF(d.timein,(d.date' '(time(c.Late_Exceed))))< 0,0,TIMEDIFF(d.timein,(d.date' '(time(c.Late_Exceed))))) as 'Late',if(TIMEDIFF(c.Early_Exceed,d.timeout)< 0,0,TIMEDIFF(c.Early_Exceed,d.timeout)) as 'Early',if(TIMEDIFF(d.timeout,c.Over_Time)< 0,0,TIMEDIFF(d.timeout,c.Over_Time)) as 'Over Time',if(TIMEDIFF(c.In_OT_Exceed,d.timein)< 0,0,TIMEDIFF(c.In_OT_Exceed,d.timein)) as 'Coming OT',if(TIMEDIFF(d.timein,c.late_after)< 0,0,TIMEDIFF(d.timein,c.late_after)) as 'Late Exceed',if(TIMEDIFF(c.early_before,d.timeout)< 0,0,TIMEDIFF(c.early_before,d.timeout)) as 'Early_Exceed' FROM emp_list b,num_run_days c,nighttime d,user_of_run2 a WHERE a.User_ID='"+empid+"' and Name='"+emp+"' and a.User_ID=d.id  and d.date between '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' AND a.Num_of_run=c.Num_RunID AND c.s_Days=DAYOFWEEK(d.Date) group by d.Date";
                ResultSet rst1=pst.executeQuery();//SELECT a.User_ID as 'Employee ID', b.Name as 'Employee Name', c.Num_Run_name as 'Shift Name', c.Start_Time as 'IN Time', c.End_Time as 'OUT Time',TIMEDIFF(c.End_Time,c.Start_Time) as 'Total Shift Time' ,d.Date as 'Date',d.timein as 'Checkin Time',d.timeout as 'Checkout Time',TIMEDIFF(d.timeout,d.timein) as 'Total Time',if(TIMEDIFF(time(d.timein),time(c.Late_Exceed))< 0,0,TIMEDIFF(time(d.timein),time(c.Late_Exceed))) as 'Late',if(TIMEDIFF(time(c.Early_Exceed),time(d.timeout))< 0,0,TIMEDIFF(time(c.Early_Exceed),time(d.timeout))) as 'Early',if(TIMEDIFF(time(d.timeout),time(c.Over_Time))< 0,0,TIMEDIFF(time(d.timeout),time(c.Over_Time))) as 'Over Time',if(TIMEDIFF(time(c.In_OT_Exceed),time(d.timein))< 0,0,TIMEDIFF(time(c.In_OT_Exceed),time(d.timein))) as 'Coming OT',if(TIMEDIFF(time(d.timein),time(c.late_after))< 0,0,TIMEDIFF(time(d.timein),time(c.late_after))) as 'Late Exceed',if(TIMEDIFF(time(c.early_before),time(d.timeout))< 0,0,TIMEDIFF(time(c.early_before),time(d.timeout))) as 'Early_Exceed' FROM emp_list b,num_run_days c,nighttime d,user_of_run2 a WHERE a.User_ID='"+empid+"' and Name='"+emp+"' and a.User_ID=d.id  and d.date between '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' AND a.Num_of_run=c.Num_RunID AND c.s_Days=DAYOFWEEK(d.Date) group by d.Date
                Report1.setModel (DbUtils.resultSetToTableModel(rst1));
                for(int w=0; w < Report1.getRowCount();w++ ){
                String t1=Report1.getValueAt(w, 9).toString();
                String t7=Report1.getValueAt(w, 6).toString();
                String t2=Report1.getValueAt(w, 10).toString();
                String t3=Report1.getValueAt(w, 11).toString();
 String t4   =Report1.getValueAt(w, 12).toString();// Overtime
  Double otMins=t2m.parseTimeToMinutes(t4);
  if(otMins < Double.parseDouble(otStFrm.getText()))  {Report1.setValueAt("0", w, 12); } else{}  
  t4=Report1.getValueAt(w, 12).toString();
 sname123.setText(Report1.getValueAt(0, 2).toString());

               String t5= Report1.getValueAt(w, 0).toString();

               String  t6=Report1.getValueAt(w, 1).toString();

               String t8= Report1.getValueAt(w, 13).toString();//Inovertime
              Double inotMins=t2m.parseTimeToMinutes(t8);
  if(inotMins < Double.parseDouble(inotStFrm.getText()))  {Report1.setValueAt("0", w, 13); } else{}   
 t8= Report1.getValueAt(w, 13).toString();//
                String t26 =Report1.getValueAt(w, 14).toString();
                
                String t27=Report1.getValueAt(w, 15).toString();
                    
               String t21 =Report1.getValueAt(w, 2).toString();
                
               String t22 =Report1.getValueAt(w, 3).toString();
                
               String t23 =Report1.getValueAt(w, 4).toString();
                
             String t24   =Report1.getValueAt(w, 7).toString();
                
              String t25= Report1.getValueAt(w, 8).toString();
              String t90= Report1.getValueAt(w, 5).toString();
               
                
                         Statement st=con.createStatement();
               int k=st.executeUpdate("replace into calculation (`ID`,Name,Shift,InTime,OutTime,totalTime,Date,checkintime,checkouttime,Total,Late,Early,OT,InOT,Late_Exceed,Early_Exceed) values('"+t5+"','"+t6+"','"+t21+"','"+t22+"','"+t23+"','"+t90+"','"+t7+"','"+t24+"','"+t25+"','"+t1+"','"+t2+"','"+t3+"','"+t4+"','"+t8+"','"+t26+"','"+t27+"') ");
     status123.setText(status123.getText()+".");                }
         if(hdOT.isSelected()){       
     try{           //}catch(Exception e){JOptionPane.showMessageDialog(null, e+" s2");}
       String querya451="SELECT `ID`,Name,calculation.Date,Total FROM `calculation` join holiday_employee on calculation.Date=holiday_employee.date where ID='"+empid+"' and calculation.Date BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' and ID=emp_id";
                PreparedStatement apst1=con.prepareStatement(querya451);          ResultSet arst11=apst1.executeQuery();
                weekendH.setModel (DbUtils.resultSetToTableModel(arst11));
                for(int a=0; a< weekendH.getRowCount();a++){
 Statement st=con.createStatement();
               int k=st.executeUpdate("update calculation Set OT='"+weekendH.getValueAt(a, 3)+"',Early='0',Late='0',Late_Exceed='0',Early_Exceed='0' where id='"+empid+"' and date='"+weekendH.getValueAt(a, 2)+"'");
        }}catch(Exception e){System.out.println(e);}}else {}
                String holid="0";String totalShiftTime="0";
            try{    String query2="SELECT IFNULL(SUM(TIME_TO_SEC(Total)/60/60),0),IFNULL(SUM(TIME_TO_SEC(Late)/60/60),0),IFNULL(SUM(TIME_TO_SEC(Early)/60/60),0),IFNULL(SUM(TIME_TO_SEC(OT)/60/60),0),IFNULL(SUM(TIME_TO_SEC(InOT)/60/60),0),IFNULL(SUM(TIME_TO_SEC(Late_Exceed)/60/60),0),IFNULL(SUM(TIME_TO_SEC(Early_Exceed)/60/60),0) FROM calculation where id='"+empid+"' and Date between '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"'  order by Date" ;
                    PreparedStatement pst2=con.prepareStatement(query2);
                    ResultSet rst2=pst2.executeQuery();
                    if(rst2.next()){
                        ttime.setText(rst2.getString("IFNULL(SUM(TIME_TO_SEC(Total)/60/60),0)"));
                        tlate.setText(rst2.getString("IFNULL(SUM(TIME_TO_SEC(Late)/60/60),0)"));
                        tearly.setText(rst2.getString("IFNULL(SUM(TIME_TO_SEC(Early)/60/60),0)"));
                        tovertime.setText(rst2.getString("IFNULL(SUM(TIME_TO_SEC(OT)/60/60),0)"));
                        tinovertime.setText(rst2.getString("IFNULL(SUM(TIME_TO_SEC(InOT)/60/60),0)"));
                        pday.setText(Integer.toString(Report1.getRowCount())); 
                        LEE.setText(rst2.getString("IFNULL(SUM(TIME_TO_SEC(Late_Exceed)/60/60),0)"));
                        EEE.setText(rst2.getString("IFNULL(SUM(TIME_TO_SEC(Early_Exceed)/60/60),0)"));
                  
                    
                    }// 
 String querya45="select IFNULL(SUM(TIME_TO_SEC(TIMEDIFF(b.endtime,b.starttime))/60/60),0) as 'total Shift time',IFNULL(COUNT(B.Start_Date),0) FROM user_of_run2 b WHERE B.Start_Date BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' AND B.User_ID='"+empid+"' UNION\n" +
"SELECT 'Late',IFNULL(COUNT(Late),0) FROM `calculation` WHERE `ID` = '"+empid+"' AND `Date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' AND `Late` > '00:00:00' UNION\n" +
"SELECT 'Early',IFNULL(COUNT(Early),0) FROM `calculation` WHERE `ID` = '"+empid+"' AND `Date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' AND `Early` > '00:00:00' UNION\n" +
"SELECT 'OT',IFNULL(COUNT(OT),0) FROM `calculation` WHERE `ID` = '"+empid+"' AND `Date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' AND `OT` > '00:00:00' UNION\n" +
"SELECT 'InOT',IFNULL(COUNT(InOT),0) FROM `calculation` WHERE `ID` = '"+empid+"' AND `Date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' AND `InOT` > '00:00:00' UNION\n" +
"SELECT  'loan Installment',IFNULL(sum(`installment_pay`),0) FROM `loan_manage` WHERE `emp_id` = '"+empid+"' AND `Date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' union\n" +
"SELECT  'Advance payment',IFNULL(SUM(`advancepay`),0) FROM `advance`  WHERE `emp_id` = '"+empid+"' AND `Date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' union\n" +
"SELECT IFNULL(sum(`taxpay`),0), IFNULL(sum(`leavepay`),0) FROM `yealrypayment` WHERE `ID` = '"+empid+"' AND `Date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' union\n" +
"select 'Leave',IFNULL(count(leave_name),0) from leave_employee WHERE `emp_id` = '"+empid+"' AND `Date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' union\n" +
"select 'Holiday',IFNULL(count(holiday_name),0) from holiday_employee WHERE `emp_id` = '"+empid+"' AND `Date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"'";
         
                PreparedStatement apst=con.prepareStatement(querya45);          ResultSet arst1=apst.executeQuery();
                
                
                
                mutipleQuery.setModel (DbUtils.resultSetToTableModel(arst1));
            
                
                tday.setText(mutipleQuery.getValueAt(0, 1).toString());
                      totalShiftTime=Integer.toString((int) Double.parseDouble(mutipleQuery.getValueAt(0, 0).toString()));
                      aday.setText(Integer.toString(Integer.parseInt(tday.getText())-Integer.parseInt(pday.getText())));
                    lday.setText(mutipleQuery.getValueAt(1, 1).toString());
                    eday.setText(mutipleQuery.getValueAt(2, 1).toString());
                    otday.setText(mutipleQuery.getValueAt(3, 1).toString());
                    inotday.setText(mutipleQuery.getValueAt(4, 1).toString());
                    loan=mutipleQuery.getValueAt(5, 1).toString();
                    advance=mutipleQuery.getValueAt(6, 1).toString();
                    taxy=mutipleQuery.getValueAt(7, 0).toString();
                    leavey=mutipleQuery.getValueAt(7, 1).toString();
                    lea=mutipleQuery.getValueAt(8, 1).toString();
                   holid=mutipleQuery.getValueAt(9, 1).toString();
                     aday.setText(Integer.toString(Integer.parseInt(aday.getText())-Integer.parseInt(holid)-Integer.parseInt(lea)));
                 pday.setText(Integer.toString(Integer.parseInt(pday.getText())-weekendH.getRowCount()));     
                    //     Report1.getRowCount();
                aday.setText(Integer.toString(Integer.parseInt(aday.getText())+weekendH.getRowCount()));
               }catch(Exception e){JOptionPane.showMessageDialog(null,e);} 
           
                    String z1,z2,z3,z4,z5,z13; int z6,z7,z8,z9,z10,z11,z12,z14,z15;
                    z1=tday.getText();
                    z2=pday.getText();
                    z3=aday.getText();
                    z4=lday.getText();
                    z5=eday.getText();
                    z6=(int) Double.parseDouble(tovertime.getText());
                    z7=(int) Double.parseDouble(tinovertime.getText());
                    z8=(int) Double.parseDouble(ttime.getText());
                    z9=(int) Double.parseDouble(tlate.getText());
                    z10=(int) Double.parseDouble(tearly.getText());
                    z11=(int) Double.parseDouble(otday.getText());
                    z12=(int) Double.parseDouble(inotday.getText());
                    z13=sname123.getText();
                    z14= (int) Double.parseDouble(LEE.getText());
                    z15= (int) Double.parseDouble(EEE.getText());
                // JOptionPane.showMessageDialog(null, "1");
                    System.out.println(z14 +"\n"+ z15);
                    //JOptionPane.showMessageDialog(null, "2");
                    Statement st=con.createStatement();//  ,'1','"+z14+"','"+z15+"'
                    int k=st.executeUpdate("Replace INTO `attendancemonth`(`ID`, `Name`, `Department`, `Shift`,`Date`,`Total_Day`, `PresentDay`, `AbsentDay`, `LateDay`, `EarlyDay`, `OT`, `InOT`, `TotalTime`, `TotalLate`, `TotalEarly`, `TotalOT`, `TotalinOT`,`NET_Salary`,`Late_Exceed`,`Early_Exceed`, `loanins`, `advance`, `leavey`, `taxy`,`totalShiftTime`) VALUES ('"+empid+"','"+emp+"','"+lea+"','"+z13+"','"+year2+"-"+month+"-"+Sdate+"','"+z1+"','"+z2+"','"+z3+"','"+z4+"','"+z5+"','"+z6+"','"+z7+"','"+z8+"','"+z9+"','"+z10+"','"+z11+"','"+z12+"','"+holid+"','"+z14+"','"+z15+"','"+loan+"','"+advance+"','"+leavey+"','"+taxy+"','"+totalShiftTime+"')");
            status123.setText(status123.getText()+".");
                System.out.println("qw1");
          java.util.Date sdate=from123.getDate();
            java.sql.Date fromsql=new java.sql.Date(sdate.getTime());        
           //   Class.forName("com.mysql.jdbc.Driver");
             //   Connection con=DriverManager.getConnection(url,id,pass);
String query22="select a.`ID`, a.`Name`, b.`Department`, a.`Shift`, a.`Date`, a.`Total_Day` as 'Total Days', a.`PresentDay`, a.`AbsentDay`, a.`LateDay`, a.`EarlyDay`, a.`OT`, a.`InOT`, b.`Salary`, b.`Medical`, b.`HouseRent`, b.`Convence`, b.`Dearness`, b.`OT`,b.Late,b.Early, b.`Tax`,a.TotalLate,a.TotalEarly, a.`NET_Salary`,a.Late_Exceed,a.Early_Exceed,b.Late_Exceed,b.Early_Exceed,b.designation,b.bank,a.Department, a.loanins, a.advance, a.leavey, a.taxy,b.eobi,b.sessi  from attendancemonth a,emp_list b where a.ID=b.ID and a.ID='"+empid+"' and a.Date='"+fromsql+"'";
           PreparedStatement pst22=con.prepareStatement(query22);
            ResultSet rst22=pst22.executeQuery();
            table22.setModel (DbUtils.resultSetToTableModel(rst22));
        System.out.println("qw2");
        //int rows= table22.getRowCount();
        int i=0;
            
            int idd = Integer.parseInt(GetData(table22, i, 0).toString());
            String namee = GetData(table22, i, 1).toString();
            String departt = GetData(table22, i, 2).toString();
            String shiftt = GetData(table22, i, 3).toString();
            String datee = GetData(table22, i, 4).toString();
            double today = Double.parseDouble(GetData(table22, i, 5).toString());
            double poday = Double.parseDouble(GetData(table22, i, 6).toString());
            double aoday = Double.parseDouble(GetData(table22, i, 7).toString());
            double loday = Double.parseDouble(GetData(table22, i, 8).toString());
            double eoday = Double.parseDouble(GetData(table22, i, 9).toString());
            double oothour = Double.parseDouble(GetData(table22, i, 10).toString());
            double ionot = Double.parseDouble(GetData(table22, i,11).toString());
            double soalary = Double.parseDouble(GetData(table22, i, 12).toString());
            double moedical = Double.parseDouble(GetData(table22, i, 13).toString());
            double hoouse = Double.parseDouble(GetData(table22, i, 14).toString());
            double coonvance = Double.parseDouble(GetData(table22, i, 15).toString());
            double doearness = Double.parseDouble(GetData(table22, i, 16).toString());
            double oot = Double.parseDouble(GetData(table22, i, 17).toString());
            double  loate= Double.parseDouble(GetData(table22, i, 18).toString());
            double eoarly = Double.parseDouble(GetData(table22, i, 19).toString());
            double  toax= Double.parseDouble(GetData(table22, i, 20).toString());
            //  double  latehour= Double.parseDouble(GetData(table22, i, 21).toString());
            // double  earlyhour= Double.parseDouble(GetData(table22, i, 22).toString());     
            double  latehourexceed= Double.parseDouble(GetData(table22, i, 24).toString());
            double  earlyhourexceed= Double.parseDouble(GetData(table22, i, 25).toString()); 
            double  latehourdeduct= Double.parseDouble(GetData(table22, i, 26).toString());
            double  earlyhourdeduct= Double.parseDouble(GetData(table22, i, 27).toString()); 
            String desig = GetData(table22, i, 28).toString();
            String bank = GetData(table22, i, 29).toString();            
            double  leve= Double.parseDouble(GetData(table22, i, 30).toString());
          //  String loanu=GetData(table22, i, 31).toString(); 
         //  String advanceu=GetData(table22, i, 32).toString();
           // String leaveyu=GetData(table22, i, 33).toString(),
            //        taxyu=GetData(table22, i, 34).toString();
            Double eobi=Double.parseDouble(GetData(table22, i, 35).toString()), sessi=Double.parseDouble(GetData(table22, i, 36).toString());
            Double holida=Double.parseDouble(GetData(table22, i, 23).toString());
            int wer=(int)loday;
            
            int late=0;int early=0;
            
            if(loate <= loday  && loate*2 >= loday ){late=1;}
            if(loate*2 <= loday && loate*3 >= loday ){late=2;}
            if(loate*3 <= loday && loate*4 >= loday ){late=3;}
            if(loate*4 <= loday && loate*5 >= loday ){late=4;}
           if(loate*5 <= loday && loate*6 >= loday ){late=5;}
           if(loate*6 <= loday && loate*7 >= loday ){late=6;}
           if(loate*7 <= loday && loate*8 >= loday ){late=7;}
           if(loate*8 <= loday && loate*9 >= loday ){late=8;}
           if(loate*9 <= loday  && loate*10 >= loday ){late=9;}
            if(loate*10 <= loday && loate*11 >= loday ){late=10;}
            if(loate*11 <= loday && loate*12 >= loday ){late=11;}
            if(loate*12 <= loday && loate*13 >= loday ){late=12;}
           if(loate*13 <= loday && loate*14 >= loday ){late=13;}
           if(loate*14 <= loday && loate*15 >= loday ){late=14;}
           if(loate*15 <= loday && loate*16 >= loday ){late=15;}
           if(loate*16 <= loday && loate*17 >= loday ){late=16;}
              if(loate*17 <= loday && loate*18 >= loday ){late=17;}
            if(loate*18 <= loday && loate*19 >= loday ){late=18;}
            if(loate*19 <= loday && loate*20 >= loday ){late=19;}
           if(loate*20 <= loday && loate*21 >= loday ){late=20;}
           if(loate*21 <= loday && loate*22 >= loday ){late=21;}
           if(loate*22 <= loday && loate*23 >= loday ){late=22;}
           if(loate*23 <= loday && loate*24 >= loday ){late=23;}
           if(loate*24 <= loday  && loate*25 >= loday ){late=24;}
            if(loate*25 <= loday && loate*26 >= loday ){late=25;}
            if(loate*26 <= loday && loate*27 >= loday ){late=26;}
            if(loate*27 <= loday && loate*28 >= loday ){late=27;}
           if(loate*28 <= loday && loate*29 >= loday ){late=28;}
           if(loate*29 <= loday && loate*30 >= loday ){late=29;}
           if(loate*30 <= loday && loate*31 >= loday ){late=30;}
          // if(loate*31 <= loday ){late=31;}
           
            if(eoarly <= eoday  && eoarly*2 >= eoday ){early=1;}
            if(eoarly*2 <= eoday && eoarly*3 >= eoday ){early=2;}
            if(eoarly*3 <= eoday && eoarly*4 >= eoday ){early=3;}
            if(eoarly*4 <= eoday && eoarly*5 >= eoday ){early=4;}
           if(eoarly*5 <= eoday && eoarly*6 >= eoday ){early=5;}
           if(eoarly*6 <= eoday && eoarly*7 >= eoday ){early=6;}
           if(eoarly*7 <= eoday && eoarly*8 >= eoday ){early=7;}
           if(eoarly*8 <= eoday && eoarly*9 >= eoday ){early=8;}
           if(eoarly*9 <= eoday  && eoarly*10 >= eoday ){early=9;}
            if(eoarly*10 <= eoday && eoarly*11 >= eoday ){early=10;}
            if(eoarly*11 <= eoday && eoarly*12 >= eoday ){early=11;}
            if(eoarly*12 <= eoday && eoarly*13 >= eoday ){early=12;}
           if(eoarly*13 <= eoday && eoarly*14 >= eoday ){early=13;}
           if(eoarly*14 <= eoday && eoarly*15 >= eoday ){early=14;}
           if(eoarly*15 <= eoday && eoarly*16 >= eoday ){early=15;}
           if(eoarly*16 <= eoday && eoarly*17 >= eoday ){early=16;}
              if(eoarly*17 <= eoday && eoarly*18 >= eoday ){early=17;}
            if(eoarly*18 <= eoday && eoarly*19 >= eoday ){early=18;}
            if(eoarly*19 <= eoday && eoarly*20 >= eoday ){early=19;}
           if(eoarly*20 <= eoday && eoarly*21 >= eoday ){early=20;}
           if(eoarly*21 <= eoday && eoarly*22 >= eoday ){early=21;}
           if(eoarly*22 <= eoday && eoarly*23 >= eoday ){early=22;}
           if(eoarly*23 <= eoday && eoarly*24 >= eoday ){early=23;}
           if(eoarly*24 <= eoday  && eoarly*25 >= eoday ){early=24;}
            if(eoarly*25 <= eoday && eoarly*26 >= eoday ){early=25;}
            if(eoarly*26 <= eoday && eoarly*27 >= eoday ){early=26;}
            if(eoarly*27 <= eoday && eoarly*28 >= eoday ){early=27;}
           if(eoarly*28 <= eoday && eoarly*29 >= eoday ){early=28;}
           if(eoarly*29 <= eoday && eoarly*30 >= eoday ){early=29;}
           if(eoarly*30 <= eoday && eoarly*31 >= eoday ){early=30;}
           if(eoarly*31 <= eoday ){early=31;}
           
           double abse=aoday;          
            //Calculation
            double tot2=(oothour+ionot)*oot;
            double tot=soalary;
           //deductions
            double lhd=latehourexceed*latehourdeduct;
            double ehd=earlyhourexceed*earlyhourdeduct;
            double tot4=((moedical+hoouse+coonvance+tot)/today)*late;
            double tot5=((moedical+hoouse+coonvance+tot)/today)*early;
            if(loan.isEmpty()){loan="0";} if(taxy.isEmpty()){taxy="0";}if(leavey.isEmpty()){leavey="0";}if(advance.isEmpty()){advance="0";}
        int loana=Integer.parseInt(loan);int taxaa=Integer.parseInt(taxy);int leaveyy=Integer.parseInt(leavey);int advanced=Integer.parseInt(advance);
            //int leave=0;
            //if(aoday>0) {leave = 1;} if(aoday > 1){leave = 2;}
            //double lew=(tot/today)*leave;
           // double absent=((tot/today)*aoday);
            //double tot13=(((tot)-((tot4+tot5+lhd+ehd-absent)))-toax)+(moedical+hoouse+coonvance+doearness+tot2);
            double tot3=(((((moedical+hoouse+coonvance+tot)/today)*(poday+leve+leaveyy+holida))-((tot4+tot5+lhd+ehd+taxaa+loana+advanced+eobi+sessi)))-toax)+(moedical+hoouse+coonvance+doearness+tot2);
            int tot7=(int)tot3;
            table22.setValueAt(tot7, i, 23);
            double  salary= Double.parseDouble(GetData(table22, i, 23).toString());            
 

    Statement st2=con.createStatement();  
int l=st2.executeUpdate("Replace INTO `report`(`ID`, `Name`, `Department`,`designation`,`bank`, `Shift`, `Date`, `Days`, `PresentDay`, `AbsentDay`, `LateDay`, `EarlyDay`,late_hour,early_hour, `OverTime`, `InOverTime`, `Salary`, `Medical`, `HouseRent`, `Convence`, `Dearness`, `OT`, `Late`, `Early`,late_h,early_h, `Tax`,`leave`, `yearly_tax`, `leave_encash`, `loan`, `advance`,`holiday`,Eobi,Sessi, `Net_Salary`) VALUES ('"+idd+"','"+namee+"','"+departt+"','"+desig+"','"+bank+"','"+shiftt+"','"+datee+"','"+today+"','"+poday+"','"+abse+"','"+loday+"','"+eoday+"','"+latehourexceed+"','"+earlyhourexceed+"','"+oothour+"','"+ionot+"','"+soalary+"','"+moedical+"','"+hoouse+"','"+coonvance+"','"+doearness+"','"+oot+"','"+late+"','"+early+"','"+latehourdeduct+"','"+earlyhourdeduct+"','"+toax+"','"+leve+"','"+taxaa+"','"+leaveyy+"','"+loana+"','"+advanced+"','"+holida+"','"+eobi+"','"+sessi+"','"+salary+"')");
status123.setText(status123.getText()+"\n"+idd+" Complete"); 



//       jp_progress.UpdateProgress(100);
          }
        else{
              CallableStatement cStmt1 = con.prepareCall(" CALL `get_out`(?, ?, ?);");       
 cStmt1.setInt(1, Integer.parseInt(empid));cStmt1.setString(2,year2+"-"+month+"-"+Sdate );cStmt1.setString(3, year2+"-"+month+"-"+day3);   

//   ResultSet rst41=pst41.executeQuery(); //collect In
  ResultSet rs1;
         rs1 = cStmt1.executeQuery();                 
                //collect out
            tablen1.setModel (DbUtils.resultSetToTableModel(rs1));System.out.println("solve2");  
            
            int rows= tablen1.getRowCount();
       for(int i=0;i<rows;i++){
            String stat = GetData(tablen1, i, 4).toString();
         if(stat.equalsIgnoreCase("true"))  {
              String date = GetData(tablen1, i, 3).toString();
      
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
Calendar c = Calendar.getInstance();
c.setTime(sdf.parse(date));
c.add(Calendar.DATE, -1);  // number of days to add
date = sdf.format(c.getTime()); 
tablen1.setValueAt(date, i, 3);//Date Decrement if night true
             } 
       }
            
            
               for(int u=0; u < tablen1.getRowCount();u++ )
                {   String t549=(tablen1.getValueAt(u, 0).toString()); 
                    String t550=(tablen1.getValueAt(u, 1).toString());
                    String t551=(tablen1.getValueAt(u, 2).toString()); 
                    String t552=(tablen1.getValueAt(u, 3).toString()); 
                     Statement st43=con.createStatement();
                int k43=st43.executeUpdate("replace into night1 values('"+t549+"','"+t552+"','"+t550+" "+t551+"','"+t550+" "+t551+"')");System.out.println("solve4");
  Statement st3=con.createStatement();
  int k3=st3.executeUpdate("insert into nighttime(`id`, `date`, `timein`, `timeout`) values('"+t549+"','"+t552+"','"+t550+" "+t551+"','"+t550+" "+t551+"') ON DUPLICATE KEY UPDATE timeout='"+t550+" "+t551+"' ");                  
                   
                       
                       
                }  
            
             String lea="0";
                String taxy="0",leavey="0", loan="0",advance="0";
                CallableStatement cStmt = con.prepareCall(" CALL `get_in`(?, ?, ?);");       
 cStmt.setInt(1, Integer.parseInt(empid));cStmt.setString(2,year2+"-"+month+"-"+Sdate );cStmt.setString(3, year2+"-"+month+"-"+day3);   

//   ResultSet rst41=pst41.executeQuery(); //collect In
  ResultSet rs = cStmt.executeQuery();
tablen.setModel (DbUtils.resultSetToTableModel(rs)); 
 
  System.out.println("solve");           
 
                for(int u=0; u < tablen.getRowCount();u++ )
                {String t41=(tablen.getValueAt(u, 0).toString()); 
                String t42=(tablen.getValueAt(u, 1).toString());
               String t43=(tablen.getValueAt(u, 2).toString());
                String t44=(tablen.getValueAt(u, 3).toString());
               
       Statement st41=con.createStatement();
  int k41=st41.executeUpdate("replace into night values('"+t41+"','"+t42+"','"+t42+" "+t43+"')");System.out.println("solve3"); 
                
 Statement st42=con.createStatement();
  int k42=st42.executeUpdate("insert into nighttime(`id`, `date`, `timein`, `timeout`) values('"+t41+"','"+t42+"','"+t42+" "+t43+"','"+t42+" "+t44+"') ON DUPLICATE KEY UPDATE timein='"+t42+" "+t43+"'");              
                status123.setText(status123.getText()+".");
                }
                
                
                 System.out.println(loan+" "+ advance+" "+leavey+" "+taxy);
 try{
            String query44="SELECT a.id, a.date , a.timein, b.timeout FROM night a,night1 b, user_of_run2 d WHERE a.id='"+empid+"' and d.Start_Date between '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' and a.id=b.id and a.date=b.date group by date";
            PreparedStatement pst43=con.prepareStatement(query44);
            ResultSet rst43=pst43.executeQuery();
            tablen2.setModel (DbUtils.resultSetToTableModel(rst43));                    
             System.out.println("slove");
//ArrayList<String> id4 = new ArrayList<String>();ArrayList<String> date4 = new ArrayList<String>();ArrayList<String> timein = new ArrayList<String>();ArrayList<String> timeout = new ArrayList<String>(); 
                
for(int u=0; u < tablen2.getRowCount();u++ )
                {String t60=(tablen2.getValueAt(u, 0).toString()); 
                String t61=(tablen2.getValueAt(u, 1).toString());
               String t62=(tablen2.getValueAt(u, 2).toString());
               String t63=(tablen2.getValueAt(u, 3).toString());
                  Statement st44=con.createStatement();
  int k44=st44.executeUpdate("replace into nighttime values('"+t60+"','"+t61+"','"+t62+"','"+t63+"')");
System.out.println("solve5");status123.setText(status123.getText()+".");
                } }catch(Exception f){JOptionPane.showMessageDialog(null, f+"s1");}
               // try{
 //String query45="SELECT a.User_ID , b.Name , a.shiftname, a.starttime, a.endtime,TIMEDIFF(a.endtime,a.starttime) as 'Total Shift Time' ,d.Date as 'Date',d.timein as 'Checkin Time',d.timeout as 'Checkout Time',TIMEDIFF(d.timeout,d.timein) as 'Total Time',if(TIMEDIFF(d.timein,a.late)< 0,0,TIMEDIFF(d.timein,a.late)) as 'Late',if(TIMEDIFF(a.early,d.timeout)< 0,0,TIMEDIFF(a.early,d.timeout)) as 'Early',if(TIMEDIFF(d.timeout,a.ot)< 0,0,TIMEDIFF(d.timeout,a.ot)) as 'Over Time',if(TIMEDIFF(a.inot,d.timein)< 0,0,TIMEDIFF(a.inot,d.timein)) as 'Coming OT',if(TIMEDIFF(d.timein,a.lateexceed)< 0,0,TIMEDIFF(d.timein,a.lateexceed)) as 'Late Exceed',if(TIMEDIFF(a.earlyexceed,d.timeout)< 0,0,TIMEDIFF(a.earlyexceed,d.timeout)) as 'Early_Exceed' FROM emp_list b,nighttime d,user_of_run2 a WHERE a.User_ID='"+empid+"' and b.Name='"+emp+"' and a.User_ID=d.id and a.Start_Date=d.date and a.Start_Date between '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' group by d.Date";
        

 //String query45="SELECT a.User_ID as 'Employee ID', b.Name as 'Employee Name', c.Num_Run_name as 'Shift Name', c.Start_Time as 'IN Time', c.End_Time as 'OUT Time',TIMEDIFF(c.End_Time,c.Start_Time) as 'Total Shift Time' ,d.Date as 'Date',d.timein as 'Checkin Time',d.timeout as 'Checkout Time',TIMEDIFF(d.timeout,d.timein) as 'Total Time',if(TIMEDIFF(time(d.timein),time(c.Late_Exceed))< 0,0,TIMEDIFF(time(d.timein),time(c.Late_Exceed))) as 'Late',if(TIMEDIFF(time(c.Early_Exceed),time(d.timeout))< 0,0,TIMEDIFF(time(c.Early_Exceed),time(d.timeout))) as 'Early',if(TIMEDIFF(time(d.timeout),time(c.Over_Time))< 0,0,TIMEDIFF(time(d.timeout),time(c.Over_Time))) as 'Over Time',if(TIMEDIFF(time(c.In_OT_Exceed),time(d.timein))< 0,0,TIMEDIFF(time(c.In_OT_Exceed),time(d.timein))) as 'Coming OT',if(TIMEDIFF(time(d.timein),time(c.late_after))< 0,0,TIMEDIFF(time(d.timein),time(c.late_after))) as 'Late Exceed',if(TIMEDIFF(time(c.early_before),time(d.timeout))< 0,0,TIMEDIFF(time(c.early_before),time(d.timeout))) as 'Early_Exceed' FROM emp_list b,num_run_days c,nighttime d,user_of_run2 a WHERE a.User_ID='"+empid+"' and Name='"+emp+"' and a.User_ID=d.id  and d.date between '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' AND a.Num_of_run=c.Num_RunID AND c.s_Days=DAYOFWEEK(d.Date) group by d.Date";
   //             PreparedStatement pst=con.prepareStatement(query45);
     //      pst.executeQuery();
 //        String att="SELECT a.User_ID as 'Employee ID', b.Name as 'Employee Name', c.Num_Run_name as 'Shift Name', c.Start_Time as 'IN Time', c.End_Time as 'OUT Time',TIMEDIFF(c.End_Time,c.Start_Time) as 'Total Shift Time' ,d.Date as 'Date',d.timein as 'Checkin Time',d.timeout as 'Checkout Time',TIMEDIFF(d.timeout,d.timein) as 'Total Time',if(TIMEDIFF(time(d.timein),time(c.Late_Exceed))< 0,0,TIMEDIFF(time(d.timein),time(c.Late_Exceed))) as 'Late',if(TIMEDIFF(time(c.Early_Exceed),time(d.timeout))< 0,0,TIMEDIFF(time(c.Early_Exceed),time(d.timeout))) as 'Early',if(TIMEDIFF(time(d.timeout),time(c.Over_Time))< 0,0,TIMEDIFF(time(d.timeout),time(c.Over_Time))) as 'Over Time',if(TIMEDIFF(time(c.In_OT_Exceed),time(d.timein))< 0,0,TIMEDIFF(time(c.In_OT_Exceed),time(d.timein))) as 'Coming OT',if(TIMEDIFF(time(d.timein),time(c.late_after))< 0,0,TIMEDIFF(time(d.timein),time(c.late_after))) as 'Late Exceed',if(TIMEDIFF(time(c.early_before),time(d.timeout))< 0,0,TIMEDIFF(time(c.early_before),time(d.timeout))) as 'Early_Exceed','Status' FROM emp_list b,num_run_days c,nighttime d,user_of_run2 a WHERE a.User_ID='"+empid+"' and Name='"+emp+"' and a.User_ID=d.id  and d.date between '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' AND a.Num_of_run=c.Num_RunID AND c.s_Days=DAYOFWEEK(d.Date) group by d.Date";
      try{    String att="SELECT a.User_ID as 'Employee ID', b.Name as 'Employee Name', a.shiftname,a.starttime, a.endtime,TIME_TO_SEC( TIMEDIFF(a.endtime,a.starttime))/60 as 'Total Shift Time' ,d.Date as 'Date',d.timein as 'Checkin Time',d.timeout as 'Checkout Time',TIME_TO_SEC(TIMEDIFF(d.timeout,d.timein))/60 as 'Total Time','Status',TIMEDIFF(a.endtime,a.starttime) as 'shft hourtime',TIMEDIFF(d.timeout,d.timein) as 'working hour','0','0' FROM emp_list b,nighttime d,user_of_run2 a WHERE a.User_ID='"+empid+"' and b.Name='"+emp+"' and a.User_ID=d.id and a.Start_Date=d.date and a.Start_Date between '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' group by d.Date";                    
            PreparedStatement pst200=con.prepareStatement(att);
                                ResultSet rst100=pst200.executeQuery();
                              Report1.setModel (DbUtils.resultSetToTableModel(rst100));
         int rowss= Report1.getRowCount();
        for(int i=0;i<rowss;i++){
            Double ttime2 = Double.parseDouble(GetData(Report1, i, 9).toString()); Double tShiftTime = Double.parseDouble(GetData(Report1, i, 5).toString());
        if(ttime2 >= tShiftTime){Report1.setValueAt("P", i, 10);Report1.setValueAt((ttime2.intValue()-tShiftTime.intValue())/60+":"+((ttime2.intValue()-tShiftTime.intValue())-(((ttime2.intValue()-tShiftTime.intValue())/60)*60)), i, 14); }                                                       
        if(ttime2 < tShiftTime){Report1.setValueAt("L", i, 10);Report1.setValueAt((tShiftTime.intValue()-ttime2.intValue())/60+":"+((tShiftTime.intValue()-ttime2.intValue())-(((tShiftTime.intValue()-ttime2.intValue())/60)*60)), i, 13);} // late= Integer.toString(Integer.parseInt(Double.toString(tShiftTime - ttime2))/60)+":"+ Integer.toString(Integer.parseInt(Double.toString(tShiftTime - ttime2))%60);}   
        
        if(ttime2 < 1){Report1.setValueAt("H", i, 10);}
    String c0 = GetData(Report1, i, 0).toString();String c1 = GetData(Report1, i, 1).toString();String c2 = GetData(Report1, i, 2).toString();   sname123.setText(c2);
    String c3 = GetData(Report1, i, 3).toString();String c4 = GetData(Report1, i, 4).toString();
    String c6 = GetData(Report1, i, 6).toString();String c7 = GetData(Report1, i, 7).toString();String c8 = GetData(Report1, i, 8).toString();
    String c10 = GetData(Report1, i, 10).toString();
    
    String ShftTime=GetData(Report1, i, 11).toString();
    String totalTime=GetData(Report1, i, 12).toString();
     String lateTim = GetData(Report1, i, 13).toString();
    
    String otTim=GetData(Report1, i, 14).toString();
    //String halfTim=GetData(Report1, i, 15).toString();
    //String c11 = GetData(Report1, i, 11).toString();
    //String c12 = GetData(Report1, i, 12).toString(); String c13 = GetData(Report1, i, 13).toString(); String c14 = GetData(Report1, i, 14).toString();
   // String c15 = GetData(Report1, i, 15).toString(); String c16 = GetData(Report1, i, 16).toString();
    String att2="replace into calculation (`ID`, `Name`, `Shift`, `InTime`, `OutTime`, `totalTime`, `Date`, `checkintime`, `checkouttime`, `Total`, `status`, `Late`, `Early`, `OT`, `InOT`, `Late_Exceed`, `Early_Exceed`) values('"+c0+"','"+c1+"','"+c2+"','"+c3+"','"+c4+"','"+ShftTime+"','"+c6+"','"+c7+"','"+c8+"','"+totalTime+"','"+c10+"','"+lateTim+"','0','"+otTim+"','0','0','0') ";
                   PreparedStatement pst=con.prepareStatement(att2);
           pst.executeQuery();status123.setText(status123.getText()+".");
        System.out.println("solve6");
        }}catch(Exception e){JOptionPane.showMessageDialog(null, e);}
                
        
        
        
        
        Double OT=0.0; Double pTotal=0.0;
                    
                 
                    
                 
                   String holid="0";String totalShiftTime="0";
            try{    String querya2="SELECT IFNULL(SUM(TIME_TO_SEC(totalTime)/60/60),0), IFNULL(SUM(TIME_TO_SEC(Total)/60/60),0),IFNULL(SUM(TIME_TO_SEC(Late)/60/60),0),IFNULL(SUM(TIME_TO_SEC(Early)/60/60),0),IFNULL(SUM(TIME_TO_SEC(OT)/60/60),0),IFNULL(SUM(TIME_TO_SEC(InOT)/60/60),0),IFNULL(SUM(TIME_TO_SEC(Late_Exceed)/60/60),0),IFNULL(SUM(TIME_TO_SEC(Early_Exceed)/60/60),0) FROM calculation where id='"+empid+"' and Date between '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"'  order by Date" ;
     //       SELECT IFNULL(SUM(TIME_TO_SEC(totalTime)/60/60),0),IFNULL(SUM(TIME_TO_SEC(Total)/60/60),0)        
            PreparedStatement psta2=con.prepareStatement(querya2);
                    ResultSet rsta2=psta2.executeQuery();
                    if(rsta2.next()){
                        jLabel5.setText(rsta2.getString("IFNULL(SUM(TIME_TO_SEC(totalTime)/60/60),0)"));
                        ttime.setText(rsta2.getString("IFNULL(SUM(TIME_TO_SEC(Total)/60/60),0)"));
                        tlate.setText(rsta2.getString("IFNULL(SUM(TIME_TO_SEC(Late)/60/60),0)"));
                        tearly.setText(rsta2.getString("IFNULL(SUM(TIME_TO_SEC(Early)/60/60),0)"));
                        tovertime.setText(rsta2.getString("IFNULL(SUM(TIME_TO_SEC(OT)/60/60),0)"));
                       // tinovertime.setText(rsta2.getString("IFNULL(SUM(TIME_TO_SEC(InOT)/60/60),0)"));
                        pday.setText(Integer.toString(Report1.getRowCount())); 
                        //LEE.setText(rsta2.getString("IFNULL(SUM(TIME_TO_SEC(Late_Exceed)/60/60),0)"));
                        EEE.setText(rsta2.getString("IFNULL(SUM(TIME_TO_SEC(Early_Exceed)/60/60),0)"));
                
                    
                    }// 
 String querya45="select IFNULL(SUM(TIME_TO_SEC(TIMEDIFF(b.endtime,b.starttime))/60/60),0) as 'total Shift time',IFNULL(COUNT(B.Start_Date),0) FROM user_of_run2 b WHERE B.Start_Date BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' AND B.User_ID='"+empid+"' UNION\n" +
"SELECT 'Late',IFNULL(COUNT(Late),0) FROM `calculation` WHERE status='L' and `ID` = '"+empid+"' AND `Date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' AND `Late` > '00:00:00' UNION\n" +
"SELECT 'Early',IFNULL(COUNT(Early),0) FROM `calculation` WHERE status='H'  and `ID` = '"+empid+"' AND `Date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"'  UNION\n" +
"SELECT 'OT',IFNULL(COUNT(OT),0) FROM `calculation` WHERE status='P' and `ID` = '"+empid+"' AND `Date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"'  UNION\n" +
"SELECT 'InOT',IFNULL(COUNT(InOT),0) FROM `calculation` WHERE  `ID` = '"+empid+"' AND `Date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' AND `InOT` > '00:00:00' UNION\n" +
"SELECT  'loan Installment',IFNULL(sum(`installment_pay`),0) FROM `loan_manage` WHERE `emp_id` = '"+empid+"' AND `Date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' union\n" +
"SELECT  'Advance payment',IFNULL(SUM(`advancepay`),0) FROM `advance`  WHERE `emp_id` = '"+empid+"' AND `Date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' union\n" +
"SELECT IFNULL(sum(`taxpay`),0), IFNULL(sum(`leavepay`),0) FROM `yealrypayment` WHERE `ID` = '"+empid+"' AND `Date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' union\n" +
"select 'Leave',IFNULL(count(leave_name),0) from leave_employee WHERE `emp_id` = '"+empid+"' AND `Date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' union\n" +
"select 'Holiday',IFNULL(count(holiday_name),0) from holiday_employee WHERE `emp_id` = '"+empid+"' AND `Date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"'";
         
                PreparedStatement apst=con.prepareStatement(querya45);          ResultSet arst1=apst.executeQuery();
                mutipleQuery.setModel (DbUtils.resultSetToTableModel(arst1));
                      tday.setText(mutipleQuery.getValueAt(0, 1).toString());
                      totalShiftTime=Integer.toString((int) Double.parseDouble(mutipleQuery.getValueAt(0, 0).toString()));
                      aday.setText(Integer.toString(Integer.parseInt(tday.getText())-Integer.parseInt(pday.getText())));
                    lday.setText(mutipleQuery.getValueAt(1, 1).toString());
                    halfD.setText(mutipleQuery.getValueAt(2, 1).toString());
                    otday.setText(mutipleQuery.getValueAt(3, 1).toString());
                    inotday.setText(mutipleQuery.getValueAt(4, 1).toString());
                    loan=mutipleQuery.getValueAt(5, 1).toString();
                    advance=mutipleQuery.getValueAt(6, 1).toString();
                    taxy=mutipleQuery.getValueAt(7, 0).toString();
                    leavey=mutipleQuery.getValueAt(7, 1).toString();
                    lea=mutipleQuery.getValueAt(8, 1).toString();
                   holid=mutipleQuery.getValueAt(9, 1).toString();
   aday.setText(Integer.toString(Integer.parseInt(aday.getText())-Integer.parseInt(holid)-Integer.parseInt(lea)));
        
               }catch(Exception e){JOptionPane.showMessageDialog(null,e);} 
                    
                    
                    String z1,z2,z3,z4,z13; int z5,z6,z7,z8,z9,z10,z11,z12,z14,z15,z16;
                    z1=tday.getText();
                    z2=pday.getText();
                    z3=aday.getText();
                    z4=lday.getText();
                    z5=(int) Double.parseDouble(halfD.getText());
                    z6= (int) Double.parseDouble(tovertime.getText());
                    z7= 0;
                    z8= (int) Double.parseDouble(ttime.getText());
                    z9= (int) Double.parseDouble(tlate.getText());
                    z10=0;
                    z11=0;
                    z12=0;
                    z13=sname123.getText();
                    z14= 0;
                    z15=(int) Double.parseDouble(halfD.getText());
                    z16= (int) Double.parseDouble(jLabel5.getText());
                // JOptionPane.showMessageDialog(null, "1");
                    System.out.println(z8 +"\n"+ z16);
                    
                    //JOptionPane.showMessageDialog(null, "2");
                    Statement st=con.createStatement();//  ,'1','"+z14+"','"+z15+"'
                    int k=st.executeUpdate("Replace INTO `attendancemonth`(`ID`, `Name`, `Department`, `Shift`,`Date`,`Total_Day`, `PresentDay`, `AbsentDay`, `LateDay`, `EarlyDay`, `OT`, `InOT`, `TotalTime`, `TotalLate`, `TotalEarly`, `TotalOT`, `TotalinOT`,`NET_Salary`,`Late_Exceed`,`Early_Exceed`, `loanins`, `advance`, `leavey`, `taxy`,`totalShiftTime`) VALUES ('"+empid+"','"+emp+"','"+lea+"','"+z13+"','"+year2+"-"+month+"-"+Sdate+"','"+z1+"','"+z2+"','"+z3+"','"+z4+"','"+z5+"','"+z6+"','"+z7+"','"+z8+"','"+z9+"','"+z10+"','"+z11+"','"+z12+"','"+holid+"','"+z14+"','"+z15+"','"+loan+"','"+advance+"','"+leavey+"','"+taxy+"','"+z16+"')");
               status123.setText(status123.getText()+".");
                System.out.println("qw1");
          java.util.Date sdate=from123.getDate();
            java.sql.Date fromsql=new java.sql.Date(sdate.getTime());        
              //Class.forName("com.mysql.jdbc.Driver");
                //Connection con=DriverManager.getConnection(url,id,pass);
String query22="select a.`ID`, a.`Name`, b.`Department`, a.`Shift`, a.`Date`, a.`Total_Day` as 'Total Days', a.`PresentDay`, a.`AbsentDay`, a.`LateDay`, a.`EarlyDay`, a.`OT`, a.`InOT`, b.`Salary`, b.`Medical`, b.`HouseRent`, b.`Convence`, b.`Dearness`, b.`OT`,b.Late,b.Early, b.`Tax`,a.TotalLate,a.TotalEarly, a.`NET_Salary`,a.Late_Exceed,a.Early_Exceed,b.Late_Exceed,b.Early_Exceed,b.designation,b.bank,a.Department, a.loanins, a.advance, a.leavey, a.taxy,b.eobi,b.sessi,a.totalShiftTime,a.TotalTime  from attendancemonth a,emp_list b where a.ID=b.ID and a.ID='"+empid+"' and a.Date='"+fromsql+"'";
           PreparedStatement pst22=con.prepareStatement(query22);
            ResultSet rst22=pst22.executeQuery();
            table22.setModel (DbUtils.resultSetToTableModel(rst22));
        System.out.println("qw2");
        //int rows= table22.getRowCount();
        int i=0;
            
            int idd = Integer.parseInt(GetData(table22, i, 0).toString());
            String namee = GetData(table22, i, 1).toString();
            String departt = GetData(table22, i, 2).toString();
            String shiftt = GetData(table22, i, 3).toString();
            String datee = GetData(table22, i, 4).toString();
            double today = Double.parseDouble(GetData(table22, i, 5).toString());
            double poday = Double.parseDouble(GetData(table22, i, 6).toString());
            double aoday = Double.parseDouble(GetData(table22, i, 7).toString());
            double loday = Double.parseDouble(GetData(table22, i, 8).toString());
            double eoday = Double.parseDouble(GetData(table22, i, 9).toString());
            double oothour = Double.parseDouble(GetData(table22, i, 10).toString());
            double ionot = Double.parseDouble(GetData(table22, i,11).toString());
            double soalary = Double.parseDouble(GetData(table22, i, 12).toString());
            double moedical = Double.parseDouble(GetData(table22, i, 13).toString());
            double hoouse = Double.parseDouble(GetData(table22, i, 14).toString());
            double coonvance = Double.parseDouble(GetData(table22, i, 15).toString());
            double doearness = Double.parseDouble(GetData(table22, i, 16).toString());
            double oot = Double.parseDouble(GetData(table22, i, 17).toString());
            double  loate= Double.parseDouble(GetData(table22, i, 18).toString());
            double eoarly = Double.parseDouble(GetData(table22, i, 19).toString());
            double  toax= Double.parseDouble(GetData(table22, i, 20).toString());
            //  double  latehour= Double.parseDouble(GetData(table22, i, 21).toString());
            // double  earlyhour= Double.parseDouble(GetData(table22, i, 22).toString());     
            double  latehourexceed= Double.parseDouble(GetData(table22, i, 24).toString());
            double  earlyhourexceed= Double.parseDouble(GetData(table22, i, 25).toString()); 
            double  latehourdeduct= Double.parseDouble(GetData(table22, i, 26).toString());
            double  earlyhourdeduct= Double.parseDouble(GetData(table22, i, 27).toString()); 
            String desig = GetData(table22, i, 28).toString();
            String bank = GetData(table22, i, 29).toString();            
            double  leve= Double.parseDouble(GetData(table22, i, 30).toString());
           loan=GetData(table22, i, 31).toString(); 
            advance=GetData(table22, i, 32).toString();
             leavey=GetData(table22, i, 33).toString();
             taxy=GetData(table22, i, 34).toString();
            Double eobi=Double.parseDouble(GetData(table22, i, 35).toString()), sessi=Double.parseDouble(GetData(table22, i, 36).toString());
            Double shTime=Double.parseDouble(GetData(table22, i, 37).toString());Double tTime=Double.parseDouble(GetData(table22, i, 38).toString());
            Double holida=Double.parseDouble(GetData(table22, i, 23).toString());
            int wer=(int)loday;
             System.out.println("qw3");
            int late=0;int early=0;
            
            if(loate <= loday  && loate*2 >= loday ){late=1;}
            if(loate*2 <= loday && loate*3 >= loday ){late=2;}
            if(loate*3 <= loday && loate*4 >= loday ){late=3;}
            if(loate*4 <= loday && loate*5 >= loday ){late=4;}
           if(loate*5 <= loday && loate*6 >= loday ){late=5;}
           if(loate*6 <= loday && loate*7 >= loday ){late=6;}
           if(loate*7 <= loday && loate*8 >= loday ){late=7;}
           if(loate*8 <= loday && loate*9 >= loday ){late=8;}
           if(loate*9 <= loday  && loate*10 >= loday ){late=9;}
            if(loate*10 <= loday && loate*11 >= loday ){late=10;}
            if(loate*11 <= loday && loate*12 >= loday ){late=11;}
            if(loate*12 <= loday && loate*13 >= loday ){late=12;}
           if(loate*13 <= loday && loate*14 >= loday ){late=13;}
           if(loate*14 <= loday && loate*15 >= loday ){late=14;}
           if(loate*15 <= loday && loate*16 >= loday ){late=15;}
           if(loate*16 <= loday && loate*17 >= loday ){late=16;}
              if(loate*17 <= loday && loate*18 >= loday ){late=17;}
            if(loate*18 <= loday && loate*19 >= loday ){late=18;}
            if(loate*19 <= loday && loate*20 >= loday ){late=19;}
           if(loate*20 <= loday && loate*21 >= loday ){late=20;}
           if(loate*21 <= loday && loate*22 >= loday ){late=21;}
           if(loate*22 <= loday && loate*23 >= loday ){late=22;}
           if(loate*23 <= loday && loate*24 >= loday ){late=23;}
           if(loate*24 <= loday  && loate*25 >= loday ){late=24;}
            if(loate*25 <= loday && loate*26 >= loday ){late=25;}
            if(loate*26 <= loday && loate*27 >= loday ){late=26;}
            if(loate*27 <= loday && loate*28 >= loday ){late=27;}
           if(loate*28 <= loday && loate*29 >= loday ){late=28;}
           if(loate*29 <= loday && loate*30 >= loday ){late=29;}
           if(loate*30 <= loday && loate*31 >= loday ){late=30;}
         
// if(loate*31 <= loday ){late=31;}
           
            if(eoarly <= eoday  && eoarly*2 >= eoday ){early=1;}
            if(eoarly*2 <= eoday && eoarly*3 >= eoday ){early=2;}
            if(eoarly*3 <= eoday && eoarly*4 >= eoday ){early=3;}
            if(eoarly*4 <= eoday && eoarly*5 >= eoday ){early=4;}
           if(eoarly*5 <= eoday && eoarly*6 >= eoday ){early=5;}
           if(eoarly*6 <= eoday && eoarly*7 >= eoday ){early=6;}
           if(eoarly*7 <= eoday && eoarly*8 >= eoday ){early=7;}
           if(eoarly*8 <= eoday && eoarly*9 >= eoday ){early=8;}
           if(eoarly*9 <= eoday  && eoarly*10 >= eoday ){early=9;}
            if(eoarly*10 <= eoday && eoarly*11 >= eoday ){early=10;}
            if(eoarly*11 <= eoday && eoarly*12 >= eoday ){early=11;}
            if(eoarly*12 <= eoday && eoarly*13 >= eoday ){early=12;}
           if(eoarly*13 <= eoday && eoarly*14 >= eoday ){early=13;}
           if(eoarly*14 <= eoday && eoarly*15 >= eoday ){early=14;}
           if(eoarly*15 <= eoday && eoarly*16 >= eoday ){early=15;}
           if(eoarly*16 <= eoday && eoarly*17 >= eoday ){early=16;}
              if(eoarly*17 <= eoday && eoarly*18 >= eoday ){early=17;}
            if(eoarly*18 <= eoday && eoarly*19 >= eoday ){early=18;}
            if(eoarly*19 <= eoday && eoarly*20 >= eoday ){early=19;}
           if(eoarly*20 <= eoday && eoarly*21 >= eoday ){early=20;}
           if(eoarly*21 <= eoday && eoarly*22 >= eoday ){early=21;}
           if(eoarly*22 <= eoday && eoarly*23 >= eoday ){early=22;}
           if(eoarly*23 <= eoday && eoarly*24 >= eoday ){early=23;}
           if(eoarly*24 <= eoday  && eoarly*25 >= eoday ){early=24;}
            if(eoarly*25 <= eoday && eoarly*26 >= eoday ){early=25;}
            if(eoarly*26 <= eoday && eoarly*27 >= eoday ){early=26;}
            if(eoarly*27 <= eoday && eoarly*28 >= eoday ){early=27;}
           if(eoarly*28 <= eoday && eoarly*29 >= eoday ){early=28;}
           if(eoarly*29 <= eoday && eoarly*30 >= eoday ){early=29;}
           if(eoarly*30 <= eoday && eoarly*31 >= eoday ){early=30;}
           if(eoarly*31 <= eoday ){early=31;}
            System.out.println("qw4");
           double abse=aoday;          
            //Calculation
            double tot2=(oothour+ionot)*oot;
            double tot=soalary;
           //deductions
            double lhd=latehourexceed*latehourdeduct;
            double ehd=earlyhourexceed*earlyhourdeduct;
            double tot4=((moedical+hoouse+coonvance+tot)/today)*late;
            double tot5=((moedical+hoouse+coonvance+tot)/today)*early;
        //   poday=  poday+loday+earlyhourexceed;
     
        int loana=Integer.parseInt(loan);int taxaa=Integer.parseInt(taxy);int leaveyy=Integer.parseInt(leavey);int advanced=Integer.parseInt(advance);
          
          double tot3=(((((moedical+hoouse+coonvance+tot)/today)*(poday+leve+leaveyy+holida))-((tot4+tot5+lhd+ehd+taxaa+loana+advanced+eobi+sessi)))-toax)+(doearness+tot2);
           
         //double tot3=((((tot/shTime)*(tTime+((leve+leaveyy+holida)*8)+(earlyhourdeduct*4)))-((taxaa+loana+advanced+eobi+sessi)))-toax)+(moedical+hoouse+coonvance+doearness+tot2);
            int tot7=(int)tot3;
            table22.setValueAt(tot7, i, 23);
            double  salary= Double.parseDouble(GetData(table22, i, 23).toString());            
  System.out.println("qw5");

    Statement st2=con.createStatement();  
int l=st2.executeUpdate("Replace INTO `report`(`ID`, `Name`, `Department`,`designation`,`bank`, `Shift`, `Date`, `Days`, `PresentDay`, `AbsentDay`, `LateDay`, `EarlyDay`,late_hour,early_hour, `OverTime`, `InOverTime`, `Salary`, `Medical`, `HouseRent`, `Convence`, `Dearness`, `OT`, `Late`, `Early`,late_h,early_h, `Tax`,`leave`, `yearly_tax`, `leave_encash`, `loan`, `advance`,`holiday`,Eobi,Sessi, `Net_Salary`) VALUES ('"+idd+"','"+namee+"','"+departt+"','"+desig+"','"+bank+"','"+shiftt+"','"+datee+"','"+today+"','"+poday+"','"+abse+"','"+loday+"','"+eoday+"','"+latehourexceed+"','"+earlyhourexceed+"','"+oothour+"','"+ionot+"','"+soalary+"','"+moedical+"','"+hoouse+"','"+coonvance+"','"+doearness+"','"+oot+"','"+late+"','"+early+"','"+latehourdeduct+"','"+earlyhourdeduct+"','"+toax+"','"+leve+"','"+taxaa+"','"+leaveyy+"','"+loana+"','"+advanced+"','"+holida+"','"+eobi+"','"+sessi+"','"+salary+"')");
 System.out.println("qw6");
       status123.setText(status123.getText()+"\n"+idd+" Complete"); 
        } }
       
                          
                PreparedStatement pst16=con.prepareStatement("TRUNCATE `night`");
                PreparedStatement pst17=con.prepareStatement("TRUNCATE `night1`");
                PreparedStatement pst18=con.prepareStatement("TRUNCATE `nighttime`");
                pst16.executeUpdate();pst17.executeUpdate();pst18.executeUpdate();   
                
       
       
       }catch(Exception e){try{
               Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection(url,id,pass);                 
     //   try{Thread.sleep(500);}catch(Exception e){}
           Statement st42=con.createStatement();
  int k42=st42.executeUpdate("insert into errors(`errors`) values('"+e+"')");              
       }catch(Exception ea){}
              /* try{      Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection(url,id,pass);
                PreparedStatement pst16=con.prepareStatement("TRUNCATE `night`");
                PreparedStatement pst17=con.prepareStatement("TRUNCATE `night1`");
                PreparedStatement pst18=con.prepareStatement("TRUNCATE `nighttime`");
                pst16.executeUpdate();pst17.executeUpdate();pst18.executeUpdate();   
                JOptionPane.showMessageDialog(null,// "Please check shift status timings "
                        e);
               }catch(Exception f ){ }
       */
      
       }
          }}).start(); // 
        
                
    }//GEN-LAST:event_nightActionPerformed

    private void nightMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nightMousePressed


        // TODO add your handling code here:
    }//GEN-LAST:event_nightMousePressed

    private void night1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_night1MousePressed
 
    }//GEN-LAST:event_night1MousePressed

    private void night1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_night1ActionPerformed

java.util.Date sdate=from123.getDate();
          
            String Sdate="01";
            String month=Integer.toString(sdate.getMonth()+1);
            String year1=Integer.toString(sdate.getYear());
            String year2="20"+year1.subSequence(1, 3);
            int year=Integer.parseInt(year2);
            int day=sdate.getMonth()+1;
          // String MonthOfName="unknown";
            switch (day) {
                case 1:day = 31;break;
                case 2:if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                    day = 29;
                } else {
                    day = 28;}break;
                case 3:day = 31;break;
                case 4:day = 30;break;
                case 5:day = 31;break;
                case 6:day = 30;break;
                case 7:day = 31;break;
                case 8:day = 31;break;
                case 9:day = 30;break;
                case 10:day = 31; break;
                case 11:day = 30;break;
                case 12:day = 31;
            } 
            String day3=Integer.toString(day);
          

 
new Thread (new Runnable(){ //checking  out attendance
          @Override
          public void run(){
                 try{    Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection(url,id,pass);      
                     
                       for(int q=0; q < table21.getRowCount();q++ ){
        String empid=   (table21.getValueAt(q, 0).toString());
         
                
CallableStatement cStmt = con.prepareCall(" CALL `get_out`(?, ?, ?);");       
 cStmt.setInt(1, Integer.parseInt(empid));cStmt.setString(2,year2+"-"+month+"-"+Sdate );cStmt.setString(3, year2+"-"+month+"-"+day3);   

//   ResultSet rst41=pst41.executeQuery(); //collect In
  ResultSet rs;
         rs = cStmt.executeQuery();                 
                //collect out
            tablen1.setModel (DbUtils.resultSetToTableModel(rs));System.out.println("solve2");
            String Dated="2017-01-01";
            int rows= tablen1.getRowCount();
        for(int i=0;i<rows;i++){
       
            String stat = GetData(tablen1, i, 4).toString();
          if(stat.equalsIgnoreCase("true"))  {
              String date = GetData(tablen1, i, 3).toString();
        
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
Calendar c = Calendar.getInstance();
c.setTime(sdf.parse(date));
c.add(Calendar.DATE, -1);  // number of days to add
date = sdf.format(c.getTime()); 
tablen1.setValueAt(date, i, 3);//Date Decrement if night true
             } else{}//Report1.setValueAt(tot8, i, 14);  
       }               
                
                for(int u=0; u < tablen1.getRowCount();u++ )
                {   String t549=(tablen1.getValueAt(u, 0).toString()); 
                    String t550=(tablen1.getValueAt(u, 1).toString());
                    String t551=(tablen1.getValueAt(u, 2).toString()); 
                    String t552=(tablen1.getValueAt(u, 3).toString()); 
                     Statement st43=con.createStatement();
                int k43=st43.executeUpdate("replace into night1 values('"+t549+"','"+t552+"','"+t550+" "+t551+"')");System.out.println("solve4");
  Statement st3=con.createStatement();
  int k3=st3.executeUpdate("insert into nighttime(`id`, `date`, `timein`, `timeout`) values('"+t549+"','"+t552+"','"+t550+" "+t551+"','"+t550+" "+t551+"') ON DUPLICATE KEY UPDATE timeout='"+t550+" "+t551+"' ");                  
                       
                       
                       
                }                }}  catch(Exception e){}}}).start(); 
         new Thread (new Runnable(){
          @Override
          public void run(){
 try{ Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection(url,id,pass);
              
              
              for(int q=0; q < table21.getRowCount();q++ ){
        String empid=   (table21.getValueAt(q, 0).toString());
        String emp=     (table21.getValueAt(q, 1).toString());
     //   try{Thread.sleep(500);}catch(Exception e){}
                    
            String lea="0";String taxy="0",leavey="0", loan="0",advance="0";
                CallableStatement cStmt = con.prepareCall(" CALL `get_in`(?, ?, ?);");       
 cStmt.setInt(1, Integer.parseInt(empid));cStmt.setString(2,year2+"-"+month+"-"+Sdate );cStmt.setString(3, year2+"-"+month+"-"+day3);   

//   ResultSet rst41=pst41.executeQuery(); //collect In
  ResultSet rs = cStmt.executeQuery();
tablen.setModel (DbUtils.resultSetToTableModel(rs)); 
 
  System.out.println("solve");           
 
                for(int u=0; u < tablen.getRowCount();u++ )
                {String t41=(tablen.getValueAt(u, 0).toString()); 
                String t42=(tablen.getValueAt(u, 1).toString());
               String t43=(tablen.getValueAt(u, 2).toString()); 
       Statement st41=con.createStatement();
  int k41=st41.executeUpdate("replace into night values('"+t41+"','"+t42+"','"+t42+" "+t43+"')");System.out.println("solve3"); 
                
 Statement st42=con.createStatement();
  int k42=st42.executeUpdate("insert into nighttime(`id`, `date`, `timein`, `timeout`) values('"+t41+"','"+t42+"','"+t42+" "+t43+"','"+t42+" "+t43+"') ON DUPLICATE KEY UPDATE timein='"+t42+" "+t43+"'");              
                
                }
                
                try{String query="SELECT IFNULL(`taxpay`,0), IFNULL(`leavepay`,0) FROM `yealrypayment` WHERE `ID` = '"+empid+"' AND `date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"'";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rst2=pst.executeQuery();
        if (rst2.next()){taxy=rst2.getString("IFNULL(`taxpay`,0)"); leavey=rst2.getString("IFNULL(`leavepay`,0)");if(taxy==null){taxy="0";}if(leavey==null){leavey="0";}}
                
        String query1="SELECT  IFNULL(SUM(`advancepay`),0) FROM `advance` WHERE `emp_id` = '"+empid+"' AND `date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"'";
        PreparedStatement pst1=con.prepareStatement(query1);
        ResultSet rst21=pst1.executeQuery();
        if (rst21.next()){advance=rst21.getString("IFNULL(SUM(`advancepay`),0)");if(advance==null){advance="0";}}
        
        String query2="SELECT  IFNULL(`installment_pay`,0) FROM `loan_manage` WHERE `emp_id` = '"+empid+"' AND `date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"'";
        PreparedStatement pst2=con.prepareStatement(query2);
        ResultSet rst22=pst2.executeQuery();
        if (rst22.next()){loan=rst22.getString("IFNULL(`installment_pay`,0)");}}catch(Exception e){}
         
                 System.out.println(loan+" "+ advance+" "+leavey+" "+taxy);
 
            String query44="SELECT a.id, a.date , a.timein, b.timeout FROM `night` a,night1 b, num_run_days c,user_of_run2 d WHERE a.id=b.id and a.date=b.date AND d.Num_of_run=c.Num_RunID and c.s_Days=DAYOFWEEK(a.Date) group by date";
            PreparedStatement pst43=con.prepareStatement(query44);
            ResultSet rst43=pst43.executeQuery();
            tablen2.setModel (DbUtils.resultSetToTableModel(rst43));                      
//ArrayList<String> id4 = new ArrayList<String>();ArrayList<String> date4 = new ArrayList<String>();ArrayList<String> timein = new ArrayList<String>();ArrayList<String> timeout = new ArrayList<String>(); 
                
for(int u=0; u < tablen2.getRowCount();u++ )
                {String t60=(tablen2.getValueAt(u, 0).toString()); 
                String t61=(tablen2.getValueAt(u, 1).toString());
               String t62=(tablen2.getValueAt(u, 2).toString());
               String t63=(tablen2.getValueAt(u, 3).toString());
                  Statement st44=con.createStatement();
  int k44=st44.executeUpdate("replace into nighttime values('"+t60+"','"+t61+"','"+t62+"','"+t63+"')");
System.out.println("solve5");
                
                }

 //String query45="SELECT a.User_ID as 'Employee ID', b.Name as 'Employee Name', c.Num_Run_name as 'Shift Name', c.Start_Time as 'IN Time', c.End_Time as 'OUT Time',TIMEDIFF(c.End_Time,c.Start_Time) as 'Total Shift Time' ,d.Date as 'Date',d.timein as 'Checkin Time',d.timeout as 'Checkout Time',TIMEDIFF(d.timeout,d.timein) as 'Total Time',if(TIMEDIFF(time(d.timein),time(c.Late_Exceed))< 0,0,TIMEDIFF(time(d.timein),time(c.Late_Exceed))) as 'Late',if(TIMEDIFF(time(c.Early_Exceed),time(d.timeout))< 0,0,TIMEDIFF(time(c.Early_Exceed),time(d.timeout))) as 'Early',if(TIMEDIFF(time(d.timeout),time(c.Over_Time))< 0,0,TIMEDIFF(time(d.timeout),time(c.Over_Time))) as 'Over Time',if(TIMEDIFF(time(c.In_OT_Exceed),time(d.timein))< 0,0,TIMEDIFF(time(c.In_OT_Exceed),time(d.timein))) as 'Coming OT',if(TIMEDIFF(time(d.timein),time(c.late_after))< 0,0,TIMEDIFF(time(d.timein),time(c.late_after))) as 'Late Exceed',if(TIMEDIFF(time(c.early_before),time(d.timeout))< 0,0,TIMEDIFF(time(c.early_before),time(d.timeout))) as 'Early_Exceed' FROM emp_list b,num_run_days c,nighttime d,user_of_run2 a WHERE a.User_ID='"+empid+"' and Name='"+emp+"' and a.User_ID=d.id  and d.date between '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' AND a.Num_of_run=c.Num_RunID AND c.s_Days=DAYOFWEEK(d.Date) group by d.Date";
   //             PreparedStatement pst=con.prepareStatement(query45);
     //      pst.executeQuery();
         String att="SELECT a.User_ID as 'Employee ID', b.Name as 'Employee Name', c.Num_Run_name as 'Shift Name', c.Start_Time as 'IN Time', c.End_Time as 'OUT Time',TIMEDIFF(c.End_Time,c.Start_Time) as 'Total Shift Time' ,d.Date as 'Date',d.timein as 'Checkin Time',d.timeout as 'Checkout Time',TIMEDIFF(d.timeout,d.timein) as 'Total Time',if(TIMEDIFF(time(d.timein),time(c.Late_Exceed))< 0,0,TIMEDIFF(time(d.timein),time(c.Late_Exceed))) as 'Late',if(TIMEDIFF(time(c.Early_Exceed),time(d.timeout))< 0,0,TIMEDIFF(time(c.Early_Exceed),time(d.timeout))) as 'Early',if(TIMEDIFF(time(d.timeout),time(c.Over_Time))< 0,0,TIMEDIFF(time(d.timeout),time(c.Over_Time))) as 'Over Time',if(TIMEDIFF(time(c.In_OT_Exceed),time(d.timein))< 0,0,TIMEDIFF(time(c.In_OT_Exceed),time(d.timein))) as 'Coming OT',if(TIMEDIFF(time(d.timein),time(c.late_after))< 0,0,TIMEDIFF(time(d.timein),time(c.late_after))) as 'Late Exceed',if(TIMEDIFF(time(c.early_before),time(d.timeout))< 0,0,TIMEDIFF(time(c.early_before),time(d.timeout))) as 'Early_Exceed','Status' FROM emp_list b,num_run_days c,nighttime d,user_of_run2 a WHERE a.User_ID='"+empid+"' and Name='"+emp+"' and a.User_ID=d.id  and d.date between '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' AND a.Num_of_run=c.Num_RunID AND c.s_Days=DAYOFWEEK(d.Date) group by d.Date";
                              PreparedStatement pst200=con.prepareStatement(att);
                                ResultSet rst100=pst200.executeQuery();
                              Report1.setModel (DbUtils.resultSetToTableModel(rst100));
      int rows= Report1.getRowCount();
        for(int i=0;i<rows;i++){int ttime2 = Integer.parseInt(GetData(Report1, i, 9).toString().subSequence(0, 2).toString());
        if(ttime2 >= 8){Report1.setValueAt("P", i, 16);}                                                        
        if(ttime2 < 8){Report1.setValueAt("L", i, 16);}      if(ttime2 < 1){Report1.setValueAt("H", i, 16);}
    String c0 = GetData(Report1, i, 0).toString();String c1 = GetData(Report1, i, 1).toString();String c2 = GetData(Report1, i, 2).toString();   sname123.setText(c2);
    String c3 = GetData(Report1, i, 3).toString();String c4 = GetData(Report1, i, 4).toString();String c5 = GetData(Report1, i, 5).toString();
    String c6 = GetData(Report1, i, 6).toString();String c7 = GetData(Report1, i, 7).toString();String c8 = GetData(Report1, i, 8).toString();
    String c9 = GetData(Report1, i, 9).toString();String c10 = GetData(Report1, i, 10).toString();String c11 = GetData(Report1, i, 11).toString();
    String c12 = GetData(Report1, i, 12).toString(); String c13 = GetData(Report1, i, 13).toString(); String c14 = GetData(Report1, i, 14).toString();
    String c15 = GetData(Report1, i, 15).toString(); String c16 = GetData(Report1, i, 16).toString();
    String att2="replace into calculation (`ID`, `Name`, `Shift`, `InTime`, `OutTime`, `totalTime`, `Date`, `checkintime`, `checkouttime`, `Total`, `Late`, `Early`, `OT`, `InOT`, `Late_Exceed`, `Early_Exceed`, `status`) values('"+c0+"','"+c1+"','"+c2+"','"+c3+"','"+c4+"','"+c5+"','"+c6+"','"+c7+"','"+c8+"','"+c9+"','"+c10+"','"+c11+"','"+c12+"','"+c13+"','"+c14+"','"+c15+"','"+c16+"') ";
                   PreparedStatement pst=con.prepareStatement(att2);
           pst.executeQuery();
        System.out.println("solve6");
        }
                 Double OT=0.0; Double pTotal=0.0;
                    String query2="SELECT IFNULL(SUM(TIME_TO_SEC(totalTime)/60/60),0),IFNULL(SUM(TIME_TO_SEC(Total)/60/60),0) FROM calculation where id='"+empid+"' and Date between '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"'  order by Date" ;
                    PreparedStatement pst2=con.prepareStatement(query2);
                    ResultSet rst2=pst2.executeQuery();
                    if(rst2.next()){
                        jLabel5.setText(rst2.getString("IFNULL(SUM(TIME_TO_SEC(totalTime)/60/60),0)"));//shifttime
                        ttime.setText(rst2.getString("IFNULL(SUM(TIME_TO_SEC(Total)/60/60),0)"));//atttime
                     }
                        String query3="select IFNULL(COUNT(a.Start_Date),0) FROM user_of_run2 a,num_run_days b WHERE Dayofweek(a.Start_Date)=b.s_Days AND a.Num_of_run = b.Num_RunID AND a.Start_Date BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' AND a.User_ID='"+empid+"'";
                    PreparedStatement pst3=con.prepareStatement(query3);
                 //JOptionPane.showMessageDialog(null, "2");       
                    ResultSet rst3=pst3.executeQuery();
                    if(rst3.next()){
                        tday.setText(rst3.getString("IFNULL(COUNT(a.Start_Date),0)"));//(rst3.getString("COUNT(Start_Date)"));
                                 }
                    String query4="SELECT IFNULL(Count(Total),0) FROM `calculation` WHERE status='L' and `ID` = '"+empid+"' AND `Date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' ";
                    PreparedStatement pst4=con.prepareStatement(query4);
                    ResultSet rst4=pst4.executeQuery(); 
                    if(rst4.next()){lday.setText(rst4.getString("IFNULL(COUNT(Total),0)"));
                    }
                    
                     String query5="SELECT IFNULL(Count(Total),0),IFNULL(SUM(TIME_TO_SEC(Total)/60/60),0) FROM `calculation` WHERE status='P' and `ID` = '"+empid+"' AND `Date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' ";
                    PreparedStatement pst5=con.prepareStatement(query5);
                    ResultSet rst5=pst5.executeQuery(); 
                    if(rst5.next()){pday.setText(rst5.getString("IFNULL(COUNT(Total),0)"));
                    pTotal=Double.parseDouble(rst5.getString("IFNULL(SUM(TIME_TO_SEC(Total)/60/60),0)"));
                   // (Double.parseDouble(jLabel5.getText())/Double.parseDouble(tday.getText()))
                    OT=(pTotal-(8*Double.parseDouble(pday.getText())));//ot
                        if(OT <= 0){OT=OT;}else{//OT=Math.abs(OT);}
                        }
                    }
                    
                    String query7="SELECT IFNULL(COUNT(Total),0) FROM `calculation` WHERE status='H' and `ID` = '"+empid+"' AND `Date` BETWEEN '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' ";
                    PreparedStatement pst7=con.prepareStatement(query7);
                    ResultSet rst7=pst7.executeQuery();
                    if(rst7.next()){halfD.setText(rst7.getString("IFNULL(Count(Total),0)"));}
                    aday.setText((Integer.toString(Integer.parseInt(tday.getText())-(Integer.parseInt(halfD.getText())+Integer.parseInt(lday.getText())+Integer.parseInt(pday.getText())) )));
                    System.out.println(lday.getText() +" "+ halfD.getText()+" "+pday.getText());
                    String z1,z2,z3,z4,z5,z13; int z6,z7,z8,z9,z10,z11,z12,z14,z15,z16;
                    z1=tday.getText();
                    z2=pday.getText();
                    z3=aday.getText();
                    z4=lday.getText();
                    z5="0";
                    z6= (int) Double.parseDouble(OT.toString());
                    z7= 0;
                    z8= (int) Double.parseDouble(ttime.getText());
                    z9= (int) Double.parseDouble(tlate.getText());
                    z10=(int) Double.parseDouble(tearly.getText());
                    z11=0;
                    z12=0;
                    z13=sname123.getText();
                    z14= 0;
                    z15=(int) Double.parseDouble(halfD.getText());
                    z16= (int) Double.parseDouble(jLabel5.getText());
                // JOptionPane.showMessageDialog(null, "1");
                    System.out.println(z8 +"\n"+ z16);
                  String query23="select IFNULL(count(leave_name),0) from leave_employee where Date between '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' and emp_id='"+empid+"'";
                    PreparedStatement pst23=con.prepareStatement(query23);
            ResultSet rst23=pst23.executeQuery();
            if(rst23.next()){
            lea=rst23.getString("IFNULL(count(leave_name),0)");}
            String query24="select IFNULL(count(holiday_name),0) from holiday_employee where Date between '"+year2+"-"+month+"-"+Sdate+"' AND '"+year2+"-"+month+"-"+day3+"' and emp_id='"+empid+"'";
                    PreparedStatement pst24=con.prepareStatement(query24);
            ResultSet rst24=pst24.executeQuery();String holid="0";
            if(rst24.next()){
            holid=rst24.getString("IFNULL(count(holiday_name),0)");}
            
                    //JOptionPane.showMessageDialog(null, "2");
                    Statement st=con.createStatement();//  ,'1','"+z14+"','"+z15+"'
                    int k=st.executeUpdate("Replace INTO `attendancemonth`(`ID`, `Name`, `Department`, `Shift`,`Date`,`Total_Day`, `PresentDay`, `AbsentDay`, `LateDay`, `EarlyDay`, `OT`, `InOT`, `TotalTime`, `TotalLate`, `TotalEarly`, `TotalOT`, `TotalinOT`,`NET_Salary`,`Late_Exceed`,`Early_Exceed`, `loanins`, `advance`, `leavey`, `taxy`,`totalShiftTime`) VALUES ('"+empid+"','"+emp+"','"+lea+"','"+z13+"','"+year2+"-"+month+"-"+Sdate+"','"+z1+"','"+z2+"','"+z3+"','"+z4+"','"+z5+"','"+z6+"','"+z7+"','"+z8+"','"+z9+"','"+z10+"','"+z11+"','"+z12+"','"+holid+"','"+z14+"','"+z15+"','"+loan+"','"+advance+"','"+leavey+"','"+taxy+"','"+z16+"')");
               
                System.out.println("qw1");
          java.util.Date sdate=from123.getDate();
            java.sql.Date fromsql=new java.sql.Date(sdate.getTime());        
              //Class.forName("com.mysql.jdbc.Driver");
                //Connection con=DriverManager.getConnection(url,id,pass);
String query22="select a.`ID`, a.`Name`, IFNULL(b.`Department`,0), IFNULL(a.`Shift`,0), IFNULL(a.`Date`,0), IFNULL(a.`Total_Day`,0) as 'Total Days', IFNULL(a.`PresentDay`,0), IFNULL(a.`AbsentDay`,0), IFNULL(a.`LateDay`,0), IFNULL(a.`EarlyDay`,0), IFNULL(a.`OT`,0), IFNULL(a.`InOT`,0), IFNULL(b.`Salary`,0), IFNULL(b.`Medical`,0), IFNULL(b.`HouseRent`,0), IFNULL(b.`Convence`,0), IFNULL(b.`Dearness`,0), IFNULL(b.`OT`,0),IFNULL(b.Late,0),IFNULL(b.Early,0), IFNULL(b.`Tax`,0),IFNULL(a.TotalLate,0),IFNULL(a.TotalEarly,0), IFNULL(a.`NET_Salary`,0),IFNULL(a.Late_Exceed,0),IFNULL(a.Early_Exceed,0),IFNULL(b.Late_Exceed,0),IFNULL(b.Early_Exceed,0),IFNULL(b.designation,0),IFNULL(b.bank,0),IFNULL(a.Department,0), IFNULL(a.loanins,0), IFNULL(a.advance,0), IFNULL(a.leavey,0), IFNULL(a.taxy,0),IFNULL(b.eobi,0),IFNULL(b.sessi,0),IFNULL(a.totalShiftTime,0),IFNULL(a.TotalTime,0)  from attendancemonth a,emp_list b where a.ID=b.ID and a.Date='"+fromsql+"'";
           PreparedStatement pst22=con.prepareStatement(query22);
            ResultSet rst22=pst22.executeQuery();
            table22.setModel (DbUtils.resultSetToTableModel(rst22));
        System.out.println("qw2");
        //int rows= table22.getRowCount();
        int i=0;
            
            int idd = Integer.parseInt(GetData(table22, i, 0).toString());
            String namee = GetData(table22, i, 1).toString();
            String departt = GetData(table22, i, 2).toString();
            String shiftt = GetData(table22, i, 3).toString();
            String datee = GetData(table22, i, 4).toString();
            double today = Double.parseDouble(GetData(table22, i, 5).toString());
            double poday = Double.parseDouble(GetData(table22, i, 6).toString());
            double aoday = Double.parseDouble(GetData(table22, i, 7).toString());
            double loday = Double.parseDouble(GetData(table22, i, 8).toString());
            double eoday = Double.parseDouble(GetData(table22, i, 9).toString());
            double oothour = Double.parseDouble(GetData(table22, i, 10).toString());
            double ionot = Double.parseDouble(GetData(table22, i,11).toString());
            double soalary = Double.parseDouble(GetData(table22, i, 12).toString());
            double moedical = Double.parseDouble(GetData(table22, i, 13).toString());
            double hoouse = Double.parseDouble(GetData(table22, i, 14).toString());
            double coonvance = Double.parseDouble(GetData(table22, i, 15).toString());
            double doearness = Double.parseDouble(GetData(table22, i, 16).toString());
            double oot = Double.parseDouble(GetData(table22, i, 17).toString());
            double  loate= Double.parseDouble(GetData(table22, i, 18).toString());
            double eoarly = Double.parseDouble(GetData(table22, i, 19).toString());
            double  toax= Double.parseDouble(GetData(table22, i, 20).toString());
            //  double  latehour= Double.parseDouble(GetData(table22, i, 21).toString());
            // double  earlyhour= Double.parseDouble(GetData(table22, i, 22).toString());     
            double  latehourexceed= Double.parseDouble(GetData(table22, i, 24).toString());
            double  earlyhourexceed= Double.parseDouble(GetData(table22, i, 25).toString()); 
            double  latehourdeduct= Double.parseDouble(GetData(table22, i, 26).toString());
            double  earlyhourdeduct= Double.parseDouble(GetData(table22, i, 27).toString()); 
            String desig = GetData(table22, i, 28).toString();
            String bank = GetData(table22, i, 29).toString();            
            double  leve= Double.parseDouble(GetData(table22, i, 30).toString());
//            String loan=GetData(table22, i, 31).toString(); 
  //         String advance=GetData(table22, i, 32).toString();
  //          String leavey=GetData(table22, i, 33).toString();
  //String taxy=GetData(table22, i, 34).toString();
            Double eobi=Double.parseDouble(GetData(table22, i, 35).toString()), sessi=Double.parseDouble(GetData(table22, i, 36).toString());
            Double shTime=Double.parseDouble(GetData(table22, i, 37).toString());Double tTime=Double.parseDouble(GetData(table22, i, 38).toString());
            Double holida=Double.parseDouble(GetData(table22, i, 23).toString());
            int wer=(int)loday;
             System.out.println("qw4");
            int late=0;int early=0;
            
            if(loate <= loday  && loate*2 >= loday ){late=1;}
            if(loate*2 <= loday && loate*3 >= loday ){late=2;}
            if(loate*3 <= loday && loate*4 >= loday ){late=3;}
            if(loate*4 <= loday && loate*5 >= loday ){late=4;}
           if(loate*5 <= loday && loate*6 >= loday ){late=5;}
           if(loate*6 <= loday && loate*7 >= loday ){late=6;}
           if(loate*7 <= loday && loate*8 >= loday ){late=7;}
           if(loate*8 <= loday && loate*9 >= loday ){late=8;}
           if(loate*9 <= loday  && loate*10 >= loday ){late=9;}
            if(loate*10 <= loday && loate*11 >= loday ){late=10;}
            if(loate*11 <= loday && loate*12 >= loday ){late=11;}
            if(loate*12 <= loday && loate*13 >= loday ){late=12;}
           if(loate*13 <= loday && loate*14 >= loday ){late=13;}
           if(loate*14 <= loday && loate*15 >= loday ){late=14;}
           if(loate*15 <= loday && loate*16 >= loday ){late=15;}
           if(loate*16 <= loday && loate*17 >= loday ){late=16;}
              if(loate*17 <= loday && loate*18 >= loday ){late=17;}
            if(loate*18 <= loday && loate*19 >= loday ){late=18;}
            if(loate*19 <= loday && loate*20 >= loday ){late=19;}
           if(loate*20 <= loday && loate*21 >= loday ){late=20;}
           if(loate*21 <= loday && loate*22 >= loday ){late=21;}
           if(loate*22 <= loday && loate*23 >= loday ){late=22;}
           if(loate*23 <= loday && loate*24 >= loday ){late=23;}
           if(loate*24 <= loday  && loate*25 >= loday ){late=24;}
            if(loate*25 <= loday && loate*26 >= loday ){late=25;}
            if(loate*26 <= loday && loate*27 >= loday ){late=26;}
            if(loate*27 <= loday && loate*28 >= loday ){late=27;}
           if(loate*28 <= loday && loate*29 >= loday ){late=28;}
           if(loate*29 <= loday && loate*30 >= loday ){late=29;}
           if(loate*30 <= loday && loate*31 >= loday ){late=30;}
         
// if(loate*31 <= loday ){late=31;}
           
            if(eoarly <= eoday  && eoarly*2 >= eoday ){early=1;}
            if(eoarly*2 <= eoday && eoarly*3 >= eoday ){early=2;}
            if(eoarly*3 <= eoday && eoarly*4 >= eoday ){early=3;}
            if(eoarly*4 <= eoday && eoarly*5 >= eoday ){early=4;}
           if(eoarly*5 <= eoday && eoarly*6 >= eoday ){early=5;}
           if(eoarly*6 <= eoday && eoarly*7 >= eoday ){early=6;}
           if(eoarly*7 <= eoday && eoarly*8 >= eoday ){early=7;}
           if(eoarly*8 <= eoday && eoarly*9 >= eoday ){early=8;}
           if(eoarly*9 <= eoday  && eoarly*10 >= eoday ){early=9;}
            if(eoarly*10 <= eoday && eoarly*11 >= eoday ){early=10;}
            if(eoarly*11 <= eoday && eoarly*12 >= eoday ){early=11;}
            if(eoarly*12 <= eoday && eoarly*13 >= eoday ){early=12;}
           if(eoarly*13 <= eoday && eoarly*14 >= eoday ){early=13;}
           if(eoarly*14 <= eoday && eoarly*15 >= eoday ){early=14;}
           if(eoarly*15 <= eoday && eoarly*16 >= eoday ){early=15;}
           if(eoarly*16 <= eoday && eoarly*17 >= eoday ){early=16;}
              if(eoarly*17 <= eoday && eoarly*18 >= eoday ){early=17;}
            if(eoarly*18 <= eoday && eoarly*19 >= eoday ){early=18;}
            if(eoarly*19 <= eoday && eoarly*20 >= eoday ){early=19;}
           if(eoarly*20 <= eoday && eoarly*21 >= eoday ){early=20;}
           if(eoarly*21 <= eoday && eoarly*22 >= eoday ){early=21;}
           if(eoarly*22 <= eoday && eoarly*23 >= eoday ){early=22;}
           if(eoarly*23 <= eoday && eoarly*24 >= eoday ){early=23;}
           if(eoarly*24 <= eoday  && eoarly*25 >= eoday ){early=24;}
            if(eoarly*25 <= eoday && eoarly*26 >= eoday ){early=25;}
            if(eoarly*26 <= eoday && eoarly*27 >= eoday ){early=26;}
            if(eoarly*27 <= eoday && eoarly*28 >= eoday ){early=27;}
           if(eoarly*28 <= eoday && eoarly*29 >= eoday ){early=28;}
           if(eoarly*29 <= eoday && eoarly*30 >= eoday ){early=29;}
           if(eoarly*30 <= eoday && eoarly*31 >= eoday ){early=30;}
           if(eoarly*31 <= eoday ){early=31;}
           
           double abse=aoday;          
            //Calculation
            double tot2=(oothour+ionot)*oot;
            double tot=soalary;
           //deductions
            double lhd=latehourexceed*latehourdeduct;
            double ehd=earlyhourexceed*earlyhourdeduct;
            double tot4=(tot/today)*late;
            double tot5=(tot/today)*early;
           poday=  poday+loday+earlyhourexceed;
        int loana=Integer.parseInt(loan);int taxaa=Integer.parseInt(taxy);int leaveyy=Integer.parseInt(leavey);int advanced=Integer.parseInt(advance);
            //int leave=0;
            //if(aoday>0) {leave = 1;} if(aoday > 1){leave = 2;}
            //double lew=(tot/today)*leave;
           // double absent=((tot/today)*aoday);
            //double tot13=(((tot)-((tot4+tot5+lhd+ehd-absent)))-toax)+(moedical+hoouse+coonvance+doearness+tot2);
          double tot3=((((tot/today)*(poday+leve+leaveyy+holida))-((tot4+tot5+lhd+ehd+taxaa+loana+advanced+eobi+sessi)))-toax)+(moedical+hoouse+coonvance+doearness+tot2);
           
         //double tot3=((((tot/shTime)*(tTime+((leve+leaveyy+holida)*8)+(earlyhourdeduct*4)))-((taxaa+loana+advanced+eobi+sessi)))-toax)+(moedical+hoouse+coonvance+doearness+tot2);
            int tot7=(int)tot3;
            table22.setValueAt(tot7, i, 23);
            double  salary= Double.parseDouble(GetData(table22, i, 23).toString());            
 

    Statement st2=con.createStatement();  
int l=st2.executeUpdate("Replace INTO `report`(`ID`, `Name`, `Department`,`designation`,`bank`, `Shift`, `Date`, `Days`, `PresentDay`, `AbsentDay`, `LateDay`, `EarlyDay`,late_hour,early_hour, `OverTime`, `InOverTime`, `Salary`, `Medical`, `HouseRent`, `Convence`, `Dearness`, `OT`, `Late`, `Early`,late_h,early_h, `Tax`,`leave`, `yearly_tax`, `leave_encash`, `loan`, `advance`,`holiday`,Eobi,Sessi, `Net_Salary`) VALUES ('"+idd+"','"+namee+"','"+departt+"','"+desig+"','"+bank+"','"+shiftt+"','"+datee+"','"+today+"','"+poday+"','"+abse+"','"+loday+"','"+eoday+"','"+latehourexceed+"','"+earlyhourexceed+"','"+oothour+"','"+ionot+"','"+soalary+"','"+moedical+"','"+hoouse+"','"+coonvance+"','"+doearness+"','"+oot+"','"+late+"','"+early+"','"+latehourdeduct+"','"+earlyhourdeduct+"','"+toax+"','"+leve+"','"+taxaa+"','"+leaveyy+"','"+loana+"','"+advanced+"','"+holida+"','"+eobi+"','"+sessi+"','"+salary+"')");
//as.setVisible(false);
//       jp_progress.UpdateProgress(100);
 System.out.println("qw3");
        }}
           catch(Exception e){JOptionPane.showMessageDialog(null,e+"2");}
          }}).start(); // check payroll
    }//GEN-LAST:event_night1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
try{
       Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection(url,id,pass);                                
  PreparedStatement pst18=con.prepareStatement("TRUNCATE `report`");
               pst18.executeUpdate();   
        JOptionPane.showMessageDialog(null, "All Payroll Data Erase");
}catch(Exception e){}
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EEE;
    private javax.swing.JLabel LEE;
    private javax.swing.JTable Report1;
    private javax.swing.JLabel aday;
    private javax.swing.JComboBox<String> department2;
    private javax.swing.JLabel eday;
    private com.toedter.calendar.JDateChooser from123;
    private javax.swing.JButton generate;
    private javax.swing.JLabel halfD;
    private javax.swing.JCheckBox hdOT;
    private javax.swing.JTextField inotStFrm;
    private javax.swing.JLabel inotday;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lday;
    private javax.swing.JTable mutipleQuery;
    private javax.swing.JButton night;
    private javax.swing.JButton night1;
    private javax.swing.JTextField otStFrm;
    private javax.swing.JLabel otday;
    private javax.swing.JLabel pday;
    private javax.swing.JLabel sname123;
    private javax.swing.JTextArea status123;
    private javax.swing.JTable table21;
    private javax.swing.JTable table22;
    private javax.swing.JTable tablen;
    private javax.swing.JTable tablen1;
    private javax.swing.JTable tablen2;
    private javax.swing.JLabel tday;
    private javax.swing.JLabel tearly;
    private javax.swing.JLabel tinovertime;
    private javax.swing.JLabel tlate;
    private javax.swing.JLabel tovertime;
    private javax.swing.JLabel ttime;
    private javax.swing.JTable weekendH;
    // End of variables declaration//GEN-END:variables
}

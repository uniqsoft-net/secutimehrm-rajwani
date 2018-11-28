import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
public class shift extends javax.swing.JInternalFrame {
        String shiftNamedd="",inTimedd="",outTimedd="",otdd="",inotdd="",latedd="",earlydd="",lateExceeddd="",earlyExceeddd="",lunchIndd="",lunchOutdd="",startIndd="",startOutdd="",endIndd="",endOutdd="",statusdd="";
 dbclass dbd=new dbclass();
          String url=   dbd.server();
      String id=dbd.serverid();
      String pass=dbd.serverpass();
        String d1=""; String d2="";int stat=0;
    public void SetData(Object obj, int row_index, int col_index){
  table5.getModel().setValueAt(obj,row_index,col_index);
  }
   public Object GetData(JTable table, int row_index, int col_index){
  return table.getModel().getValueAt(row_index, col_index); }

public void reset4(){
            
    try{ 
        String dep=department2.getSelectedItem().toString();
        // table123.getTableHeader().setFont( new Font( "Tahoma" , Font.BOLD, 14 ));

        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
if(dep == "All"){PreparedStatement pst2=con.prepareStatement("SELECT  `ID`, `Name`, `Department` FROM `emp_list`");
            ResultSet rst2=pst2.executeQuery();
            
        table2.setModel (DbUtils.resultSetToTableModel(rst2)); }
else{String query="SELECT  `ID`, `Name`, `Department` from emp_list where Department='"+dep+"'";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rst1=pst.executeQuery();table2.setModel (DbUtils.resultSetToTableModel(rst1));}}catch(Exception E){}
}
        



        public void reset(){
         try{
         
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
        String query="select Sch_ID as 'Shift ID',Name as 'Shift Name',timein as 'Start Time',timeout 'End Time' from shift";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rst1=pst.executeQuery();
        table.setModel (DbUtils.resultSetToTableModel(rst1));
           String query3="select `Num_RunID` as 'Shift ID', `Name` as 'Shift Name', `Start_Date` as 'Start Date', `End_Date` as 'End Date', `Cycle` as 'Week Cycle', `Unit` as 'Month Cycle' from num_run";
        PreparedStatement pst3=con.prepareStatement(query3);
        ResultSet rst3=pst3.executeQuery();
        table9211.setModel (DbUtils.resultSetToTableModel(rst3));
         
        
    con.close();
         }
        
     catch(Exception ex)
     {JOptionPane.showMessageDialog(null,"");}
    }
        public void reset3(){
            try{
            Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
            String query2="select num_run_days.Num_RunID as 'Schedule ID', num_run_days.Num_Run_name as 'Schedule Name', time(`Start_Time`) as 'Start Time', time(`End_Time`) as 'End Time',time(`Over_Time`) as 'O.T', time(`In_OT_Exceed`) as 'IN O.T', time(`Late_Exceed`) as 'Late', time(`Early_Exceed`) as 'Exceed', time(`late_after`) as 'Late Hours Start', time(`early_before`) as 'Early Hours Start', `s_Days` as 'Shift Days' ,`Sch_ID` as 'Shift ID', `Sch_name` as 'Shift Name', time(`Over_Time`) as 'OT', time(`In_OT_Exceed`) as 'IN OT', time(`Late_Exceed`) as 'Late', time(`Early_Exceed`) as 'Early', time(`late_after`) as 'Late by Hour', time(`early_before`) as 'Early by Hour', time(`lunchin`) as 'Lunch IN', time(`lunchout`) as 'Lunch OUT', `status`, `startin`, `startout`, `endin`, `endout` from num_run_days left join num_run on num_run_days.Num_RunID=num_run.Num_RunID";
        PreparedStatement pst2=con.prepareStatement(query2);
        ResultSet rst2=pst2.executeQuery();
        table5.setModel (DbUtils.resultSetToTableModel(rst2));
                int rows= table5.getRowCount();
        for(int i=0;i<rows;i++){
            
            int days1 = Integer.parseInt(GetData(table5, i, 10).toString());
           String tot7="";
           switch(days1){
               case 1: {tot7="Sunday"; break;} case 2: {tot7="Monday"; break;} case 3: {tot7="Tuesday"; break;} case 4: {tot7="Wednesday"; break;} 
               case 5: {tot7="Thursday"; break;} case 6: {tot7="Friday"; break;} case 7: {tot7="Saturday"; break;} 
           
           }
            
            table5.setValueAt(tot7, i, 10);
        }}catch(Exception e){}
        }
        public void reset1(){
         try{
             int idd1=Integer.parseInt(empid.getSelectedItem().toString());
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
        String query="SELECT `User_ID` as 'Employee ID', `Num_of_run` as 'Shift ID',num_run.Name as 'Shift Name', user_of_run2.Start_Date FROM `user_of_run2` JOIN num_run on user_of_run2.Num_of_run=num_run.Num_RunID WHERE `User_ID`='"+idd1+"' GROUP by Start_Date";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rst1=pst.executeQuery();
        table3.setModel (DbUtils.resultSetToTableModel(rst1));
        }
        
     catch(Exception ex)
     {JOptionPane.showMessageDialog(null,ex.getMessage());}
        }
    /**
     * Creates new form shift
     */
    public shift() {
        initComponents();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst=conn.prepareStatement("SELECT name FROM `shift`");
            ResultSet rst1=pst.executeQuery();
           while(rst1.next()){
               shift1.addItem(rst1.getString("name"));
               reset();
               
           }
            
                    }
        catch(Exception ex){
        
        }
try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst=conn.prepareStatement("SELECT name FROM `num_run`");
           
            ResultSet rst1=pst.executeQuery();
            
           while(rst1.next()){
               schedule1.addItem(rst1.getString("name"));
               
           }
            
                    }
        catch(Exception ex){
        
        }
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
        String query="select Sch_ID as 'SHIFT ID',Name as 'SHIFT Name',timein as 'Start Time',timeout 'End Time' from shift";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rst1=pst.executeQuery();
        table.setModel (DbUtils.resultSetToTableModel(rst1));
        }
        
     catch(Exception E){JOptionPane.showMessageDialog(null,"");}
     try{
         
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
        String query="select num_run_days.Num_RunID as 'Schedule ID', num_run_days.Num_Run_name as 'Schedule Name', time(`Start_Time`) as 'Start Time', time(`End_Time`) as 'End Time',time(`Over_Time`) as 'O.T', time(`In_OT_Exceed`) as 'IN O.T', time(`Late_Exceed`) as 'Late', time(`Early_Exceed`) as 'Exceed', time(`late_after`) as 'Late Hours Start', time(`early_before`) as 'Early Hours Start', `s_Days` as 'Shift Days' ,`Sch_ID` as 'Shift ID', `Sch_name` as 'Shift Name', time(`Over_Time`) as 'OT', time(`In_OT_Exceed`) as 'IN OT', time(`Late_Exceed`) as 'Late', time(`Early_Exceed`) as 'Early', time(`late_after`) as 'Late by Hour', time(`early_before`) as 'Early by Hour', time(`lunchin`) as 'Lunch IN', time(`lunchout`) as 'Lunch OUT', `status`, `startin`, `startout`, `endin`, `endout` from num_run_days left join num_run on num_run_days.Num_RunID=num_run.Num_RunID";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rst1=pst.executeQuery();
        table5.setModel (DbUtils.resultSetToTableModel(rst1));
         int rows= table5.getRowCount();
        for(int i=0;i<rows;i++){
            
            int days1 = Integer.parseInt(GetData(table5, i, 10).toString());
           String tot7="";
           switch(days1){
               case 1: {tot7="Sunday"; break;} case 2: {tot7="Monday"; break;} case 3: {tot7="Tuesday"; break;} case 4: {tot7="Wednesday"; break;} 
               case 5: {tot7="Thursday"; break;} case 6: {tot7="Friday"; break;} case 7: {tot7="Saturday"; break;} 
           
           }
            
            table5.setValueAt(tot7, i, 10);}
        }
        
     catch(Exception ex)
     {JOptionPane.showMessageDialog(null,"");}
 
 try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
        String query="Select ID, Name, Department from emp_list";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rst1=pst.executeQuery();
        table2.setModel (DbUtils.resultSetToTableModel(rst1));
        }
        
     catch(Exception E){JOptionPane.showMessageDialog(null,"");}
    
    try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst=conn.prepareStatement("SELECT ID,Name,Department FROM emp_list");
            PreparedStatement pst2=conn.prepareStatement("SELECT Num_RunID,Name FROM num_run");
            ResultSet rst1=pst.executeQuery();
            ResultSet rst2=pst2.executeQuery();
           while(rst1.next()){
               empid.addItem(rst1.getString("ID"));
               empname.addItem(rst1.getString("Name"));}
           while(rst2.next()){
               shiftid2.addItem(rst2.getString("Num_RunID"));
               shiftname.addItem(rst2.getString("Name"));}
        
                    }
        catch(Exception ex){JOptionPane.showMessageDialog(null,"");
        }
     int iddd=Integer.parseInt(empid.getSelectedItem().toString());
 try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
        String query="SELECT `User_ID` as 'Employee ID', `Num_of_run` as 'Shift ID',num_run.Name as 'Shift Name', user_of_run2.Start_Date FROM `user_of_run2` JOIN num_run on user_of_run2.Num_of_run=num_run.Num_RunID WHERE `User_ID`='"+iddd+"' GROUP by Start_Date";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rst1=pst.executeQuery();
        table3.setModel (DbUtils.resultSetToTableModel(rst1));
        
          }
        
     catch(Exception E){JOptionPane.showMessageDialog(null,"");}

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel12 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        idd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        checkin = new lu.tudor.santec.jtimechooser.JTimeChooser();
        checkout = new lu.tudor.santec.jtimechooser.JTimeChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        eror2 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        aid = new javax.swing.JTextField();
        aname = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        astartdate = new com.toedter.calendar.JDateChooser();
        aenddate = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        acycle = new javax.swing.JTextField();
        aunit = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        eror = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        table9211 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        shift1 = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        mon = new javax.swing.JCheckBox();
        tues = new javax.swing.JCheckBox();
        wed = new javax.swing.JCheckBox();
        jLabel17 = new javax.swing.JLabel();
        thurs = new javax.swing.JCheckBox();
        schedule1 = new javax.swing.JComboBox<>();
        fri = new javax.swing.JCheckBox();
        sat = new javax.swing.JCheckBox();
        sun = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        overtime = new lu.tudor.santec.jtimechooser.JTimeChooser();
        jLabel24 = new javax.swing.JLabel();
        IOT = new lu.tudor.santec.jtimechooser.JTimeChooser();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        LE = new lu.tudor.santec.jtimechooser.JTimeChooser();
        EE = new lu.tudor.santec.jtimechooser.JTimeChooser();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        EA = new lu.tudor.santec.jtimechooser.JTimeChooser();
        EB = new lu.tudor.santec.jtimechooser.JTimeChooser();
        jButton17 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lunchin = new lu.tudor.santec.jtimechooser.JTimeChooser();
        lunchout = new lu.tudor.santec.jtimechooser.JTimeChooser();
        scheduleid = new javax.swing.JLabel();
        shiftid = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table5 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        startin = new lu.tudor.santec.jtimechooser.JTimeChooser();
        jLabel31 = new javax.swing.JLabel();
        startout = new lu.tudor.santec.jtimechooser.JTimeChooser();
        jLabel22 = new javax.swing.JLabel();
        endin = new lu.tudor.santec.jtimechooser.JTimeChooser();
        jLabel30 = new javax.swing.JLabel();
        endout = new lu.tudor.santec.jtimechooser.JTimeChooser();
        jLabel29 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        nights = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        empname = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        shiftname = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        startdate = new com.toedter.calendar.JDateChooser();
        shiftid2 = new javax.swing.JComboBox<>();
        enddate = new com.toedter.calendar.JDateChooser();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        empid = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        jLabel36 = new javax.swing.JLabel();
        eror5 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        selectedEmployee = new javax.swing.JTable();
        jButton13 = new javax.swing.JButton();
        department2 = new javax.swing.JComboBox<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        progressing = new javax.swing.JTextArea();
        jPanel10 = new javax.swing.JPanel();
        dayRotate = new javax.swing.JCheckBox();
        otRotate = new javax.swing.JCheckBox();
        earlyRotate = new javax.swing.JCheckBox();
        jButton9 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        sunWeek = new javax.swing.JCheckBox();
        satWeek = new javax.swing.JCheckBox();
        jButton19 = new javax.swing.JButton();
        sstarttime = new lu.tudor.santec.jtimechooser.JTimeChooser();
        sendtime = new lu.tudor.santec.jtimechooser.JTimeChooser();
        jScrollPane9 = new javax.swing.JScrollPane();
        shifted = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Shift Management");
        setAutoscrolls(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/mainlogo.png"))); // NOI18N
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(jDesktopPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1148, 113, -1, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel-btn-icon-20.png"))); // NOI18N
        jButton5.setText("Close");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 530, 90, 30));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        idd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iddActionPerformed(evt);
            }
        });
        jPanel3.add(idd, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 140, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Shift Segment ID:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        jPanel3.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 140, -1));
        jPanel3.add(checkin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 140, -1));
        jPanel3.add(checkout, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 140, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Shift Segment Name:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Start Time:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("End Time:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        eror2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel3.add(eror2, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 128, 163, 31));

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete-ic.png"))); // NOI18N
        jButton8.setText("Delete");
        jButton8.setToolTipText("");
        jButton8.setPreferredSize(new java.awt.Dimension(90, 30));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 100, -1));

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add-ic.png"))); // NOI18N
        jButton6.setText("Add");
        jButton6.setPreferredSize(new java.awt.Dimension(95, 30));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update-ic.png"))); // NOI18N
        jButton10.setText("Update");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 350, 190));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.setGridColor(new java.awt.Color(255, 255, 255));
        table.setPreferredSize(new java.awt.Dimension(300, 9999));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 810, 300));

        jTabbedPane1.addTab("Create Shift Segment", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Shift ID:");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));
        jPanel6.add(aid, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 140, -1));
        jPanel6.add(aname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 140, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Shift Name:");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Start Date:");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));
        jPanel6.add(astartdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 140, -1));
        jPanel6.add(aenddate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 140, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("End Date:");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Week Cycle:");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        acycle.setText("4");
        jPanel6.add(acycle, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 140, -1));

        aunit.setText("1");
        jPanel6.add(aunit, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 140, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Month Cycle:");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 51, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add-ic.png"))); // NOI18N
        jButton3.setText("Add");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 95, 31));

        eror.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel6.add(eror, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 347, 193, 22));

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton11.setForeground(new java.awt.Color(0, 51, 0));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete-ic.png"))); // NOI18N
        jButton11.setText("Delete");
        jButton11.setBorder(null);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 94, 31));

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel-btn-icon-20.png"))); // NOI18N
        jButton16.setText("Close");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 510, 90, 30));

        table9211.setModel(new javax.swing.table.DefaultTableModel(
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
        table9211.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table9211MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(table9211);

        jPanel6.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 790, 250));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update-ic.png"))); // NOI18N
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, -1, 30));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 550));

        jTabbedPane1.addTab("Create Shift", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Select Shift Segment:");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 20));

        shift1.setEditable(true);
        shift1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        shift1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Shift Selected" }));
        shift1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shift1ActionPerformed(evt);
            }
        });
        jPanel5.add(shift1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 150, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Select Working Days:");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 130, 20));

        mon.setBackground(new java.awt.Color(255, 255, 255));
        mon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mon.setSelected(true);
        mon.setText("Monday");
        mon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monActionPerformed(evt);
            }
        });
        jPanel5.add(mon, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, -1));

        tues.setBackground(new java.awt.Color(255, 255, 255));
        tues.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tues.setSelected(true);
        tues.setText("Tuesday");
        tues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuesActionPerformed(evt);
            }
        });
        jPanel5.add(tues, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, -1, -1));

        wed.setBackground(new java.awt.Color(255, 255, 255));
        wed.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        wed.setSelected(true);
        wed.setText("Wednesday");
        jPanel5.add(wed, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Select Shift:");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 120, 20));

        thurs.setBackground(new java.awt.Color(255, 255, 255));
        thurs.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        thurs.setSelected(true);
        thurs.setText("Thursday");
        jPanel5.add(thurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, -1, -1));

        schedule1.setEditable(true);
        schedule1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        schedule1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Shift Selected" }));
        schedule1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schedule1ActionPerformed(evt);
            }
        });
        jPanel5.add(schedule1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 150, -1));

        fri.setBackground(new java.awt.Color(255, 255, 255));
        fri.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fri.setSelected(true);
        fri.setText("Friday");
        jPanel5.add(fri, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, -1, -1));

        sat.setBackground(new java.awt.Color(255, 255, 255));
        sat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sat.setSelected(true);
        sat.setText("Saturday");
        jPanel5.add(sat, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, -1, -1));

        sun.setBackground(new java.awt.Color(255, 255, 255));
        sun.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sun.setSelected(true);
        sun.setText("Sunday");
        jPanel5.add(sun, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Late Going Over Time:");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add-ic.png"))); // NOI18N
        jButton4.setText("Add");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 90, 30));

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete-ic.png"))); // NOI18N
        jButton7.setText("Delete");
        jButton7.setBorder(null);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 100, 30));

        overtime.setShowSeconds(false);
        jPanel5.add(overtime, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setText("Early Coming Over Time:");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, -1));

        IOT.setShowSeconds(false);
        jPanel5.add(IOT, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setText("Late Grace Time:");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setText("Early Grace Time:");
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        LE.setShowSeconds(false);
        jPanel5.add(LE, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));

        EE.setShowSeconds(false);
        jPanel5.add(EE, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setText("If Late Exceed After :");
        jPanel5.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setText("If Early Exceed Before:");
        jPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        EA.setShowSeconds(false);
        jPanel5.add(EA, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, -1, -1));

        EB.setShowSeconds(false);
        jPanel5.add(EB, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, -1));

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel-btn-icon-20.png"))); // NOI18N
        jButton17.setText("Close");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 570, 100, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Break Time In:");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Break Time Out:");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, -1));

        lunchin.setShowSeconds(false);
        jPanel5.add(lunchin, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, -1, -1));

        lunchout.setShowSeconds(false);
        jPanel5.add(lunchout, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, -1, -1));
        jPanel5.add(scheduleid, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 20, 20));
        jPanel5.add(shiftid, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 20, 20));

        jButton12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update-ic.png"))); // NOI18N
        jButton12.setText("Update");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 100, 30));

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
        table5.setSelectionBackground(new java.awt.Color(252, 126, 2));
        table5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table5MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1230, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
        );

        jScrollPane6.setViewportView(jPanel1);

        jPanel5.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 790, 240));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Status Criteria"));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        startin.setShowSeconds(false);
        jPanel8.add(startin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 40, 20));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel31.setText("Checkin Start:");
        jPanel8.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        startout.setShowSeconds(false);
        jPanel8.add(startout, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 40, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Checkin End:");
        jPanel8.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 20));

        endin.setShowSeconds(false);
        jPanel8.add(endin, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 40, 20));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel30.setText("Checkout Start:");
        jPanel8.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 90, 20));

        endout.setShowSeconds(false);
        jPanel8.add(endout, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 40, 20));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setText("Checkout End:");
        jPanel8.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, 25));

        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 300, 70));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("If checkout status after 23:59"));

        nights.setBackground(new java.awt.Color(255, 255, 255));
        nights.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nights.setText("Night Shift");
        nights.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        nights.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nightsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(nights)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(nights)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 180, 50));

        jTabbedPane1.addTab("Arrange Shift", jPanel5);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel-btn-icon-20.png"))); // NOI18N
        jButton15.setText("Close");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 590, 98, -1));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        empname.setEditable(true);
        empname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empnameActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Employee ID:");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel32.setText("End Date:");

        shiftname.setEditable(true);
        shiftname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shiftnameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Shift ID:");

        startdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startdateMouseClicked(evt);
            }
        });

        shiftid2.setEditable(true);
        shiftid2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shiftid2ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel33.setText("Start Date:");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel34.setText("Employee Name:");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setText("Shift Name:");

        empid.setEditable(true);
        empid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empidActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(47, 47, 47)
                        .addComponent(empid, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(75, 75, 75)
                            .addComponent(shiftid2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addComponent(jLabel32)
                            .addGap(65, 65, 65)
                            .addComponent(enddate, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel35)
                                .addComponent(jLabel33))
                            .addGap(56, 56, 56)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(shiftname, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(startdate, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                            .addComponent(jLabel34)
                            .addGap(28, 28, 28)
                            .addComponent(empname, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(empid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(empname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shiftid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(4, 4, 4)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shiftname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(startdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(enddate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addGap(0, 0, 0))
        );

        jPanel7.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 150));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(252, 156, 1));
        jLabel37.setText("Selected Employee List:");
        jPanel7.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 150, -1));

        table2.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Emp ID", "Emp Name", "Title 3", "Title 4"
            }
        ));
        table2.setSelectionBackground(new java.awt.Color(252, 156, 1));
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table2);

        jPanel7.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 260, 320));

        table3.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
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
        table3.setSelectionBackground(new java.awt.Color(252, 156, 1));
        table3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(table3);

        jPanel7.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 810, 210));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(252, 156, 1));
        jLabel36.setText("Employee Applied Shift");
        jPanel7.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        eror5.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        eror5.setForeground(new java.awt.Color(255, 0, 0));
        jPanel7.add(eror5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 330, 26));

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(252, 156, 1));
        jLabel38.setText("Employee List:");
        jPanel7.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, -1, -1));

        selectedEmployee.setAutoCreateRowSorter(true);
        selectedEmployee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        selectedEmployee.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        selectedEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Emp ID", "Emp Name", "Department"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        selectedEmployee.setSelectionBackground(new java.awt.Color(255, 152, 1));
        selectedEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectedEmployeeMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(selectedEmployee);

        jPanel7.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 210, 320));

        jButton13.setForeground(new java.awt.Color(252, 156, 1));
        jButton13.setText("<<");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 50, -1));

        department2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        department2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                department2ActionPerformed(evt);
            }
        });
        jPanel7.add(department2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 110, -1));

        progressing.setColumns(20);
        progressing.setRows(5);
        jScrollPane8.setViewportView(progressing);

        jPanel7.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 260, 60));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Night Shift Rotation"));

        dayRotate.setBackground(new java.awt.Color(255, 255, 255));
        dayRotate.setText("Day Rotate");

        otRotate.setBackground(new java.awt.Color(255, 255, 255));
        otRotate.setText("OT Rotate");

        earlyRotate.setBackground(new java.awt.Color(255, 255, 255));
        earlyRotate.setText("Early Rotate");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dayRotate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(otRotate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(earlyRotate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dayRotate)
                    .addComponent(otRotate)
                    .addComponent(earlyRotate))
                .addContainerGap())
        );

        jPanel7.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 260, 50));

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add-ic.png"))); // NOI18N
        jButton9.setText("Apply");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 92, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete-ic.png"))); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, 30));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("WeekEnds Holiday"));

        sunWeek.setBackground(new java.awt.Color(255, 255, 255));
        sunWeek.setText("Sunday");
        sunWeek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sunWeekActionPerformed(evt);
            }
        });

        satWeek.setBackground(new java.awt.Color(255, 255, 255));
        satWeek.setText("Saturday");
        satWeek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satWeekActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(sunWeek, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(satWeek))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sunWeek)
                    .addComponent(satWeek)))
        );

        jPanel7.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 260, -1));

        jButton19.setForeground(new java.awt.Color(252, 156, 1));
        jButton19.setText("<");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 50, -1));

        jTabbedPane1.addTab("Schedule Employees", jPanel7);

        shifted.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(shifted);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sstarttime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendtime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 698, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(sstarttime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(sendtime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        int a444=Integer.parseInt(idd.getText());
       
        String l="hh:mm:ss";
        try
        {

            String query ="DELETE FROM `shift` WHERE sch_ID='"+a444+"'";
             String query2="DELETE FROM `num_run_days` WHERE sch_ID='"+a444+"'";
             String query3="DELETE FROM `num_run` WHERE Num_RunID='"+a444+"'";
             String query4="DELETE FROM `user_of_run2` WHERE Num_of_run='"+a444+"'";
            Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

            Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

            PreparedStatement pst= con.prepareStatement(query);                             // Create statement
            pst.executeUpdate();
            PreparedStatement pst2= con.prepareStatement(query2);                             // Create statement
            pst2.executeUpdate();
            PreparedStatement pst3= con.prepareStatement(query3);                             // Create statement
            pst3.executeUpdate();
             PreparedStatement pst4= con.prepareStatement(query4);                             // Create statement
            pst4.executeUpdate();
            JOptionPane.showMessageDialog(null,"delete successfull");
            reset();
            //                                    Execute Query
            //pst.setString(1,str1)            //          pst.setString(2,p);
            // Close the open connection
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null,"");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String named=name.getText();
        int a1=checkin.getHours();
        int a2=checkin.getMinutes();
        int a3=checkin.getSeconds();
        int a4=Integer.parseInt(idd.getText());
        int a5=checkout.getHours();
        int a6=checkout.getMinutes();
        int a7=checkout.getSeconds();
if(named.isEmpty() || a1 == 00 && a2 == 00 && a3 == 00 || a4 == 0 || a5 == 00 && a6 == 00 && a7 == 00 )
{JOptionPane.showMessageDialog(null,"Please Fill Complete Details");}else{
        try
        {

            String query = "INSERT INTO `shift` (`sch_ID`,name, `timein`, `timeout`)"
            + " VALUES ('"+a4+"','"+named+"','"+a1+":"+a2+":"+a3+"','"+a5+":"+a6+":"+a7+"')";             // Create query string to insert name into table

            Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

            Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

            PreparedStatement pst= con.prepareStatement(query);                             // Create statement
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Insert successfull");
            reset();
            //                                    Execute Query
            //pst.setString(1,str1);
            //          pst.setString(2,p);
            // Close the open connection
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null," Data Error");}}
    }//GEN-LAST:event_jButton6ActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void iddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iddActionPerformed
        Function f = new Function();
        ResultSet rs = null;

        rs = f.find(idd.getText());
        try{
            if(rs.next()){
                name.setText(rs.getString("name"));
                checkin.setTime(rs.getTime("timein"));
                checkout.setTime(rs.getTime("timeout"));

                reset();
            }  else{JOptionPane.showMessageDialog(null,"");            }
        }catch(Exception ex){JOptionPane.showMessageDialog(null,"");
        }
        }
        public class Function{
            Connection con = null;
            ResultSet rs = null;
            PreparedStatement ps = null;
            public ResultSet find(String s){
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection(url,id,pass);
                    ps = con.prepareStatement("select * from shift where id=?");
                    ps.setString(1,s);
                    rs = ps.executeQuery();
                    reset();
                }catch(Exception ex){JOptionPane.showMessageDialog(null,"");
                }
                return rs;}
    }//GEN-LAST:event_iddActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
    this.dispose();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void shiftnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shiftnameActionPerformed
        String s12=shiftname.getSelectedItem().toString();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst=conn.prepareStatement("SELECT Num_RunID FROM `num_run` where Name='"+s12+"'");
            ResultSet rst1=pst.executeQuery();

            while(rst1.next()){
                shiftid2.setSelectedItem(rst1.getString("Num_RunID"));}

        }
        catch(Exception ex){JOptionPane.showMessageDialog(null,"");
        }
    }//GEN-LAST:event_shiftnameActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        progressing.setText("Progressing");
        new Thread (new Runnable(){
          @Override
          public void run(){   
              progressing.setText(progressing.getText()+"."); 
        try{
            String[] sun={"","","","","","","","","","","","","","","",""}, mon={"","","","","","","","","","","","","","","",""}, tues={"","","","","","","","","","","","","","","",""},
                    wed={"","","","","","","","","","","","","","","",""}, thurs={"","","","","","","","","","","","","","","",""},fri={"","","","","","","","","","","","","","","",""},sat={"","","","","","","","","","","","","","","",""};
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
           
            PreparedStatement pst2=conn.prepareStatement("SELECT `Num_Run_name`, TIME(`Start_Time`), time(`End_Time`), time(`Over_Time`), time(`In_OT_Exceed`), time(`Late_Exceed`), time(`Early_Exceed`), time(`late_after`), time(`early_before`), time(`lunchin`), time(`lunchout`),  `startin`, `startout`, `endin`, `endout`,status FROM num_run_days where Sch_ID='"+shiftid2.getSelectedItem().toString()+"' and s_Days= '1'");
         ResultSet rst2=pst2.executeQuery();
         if(rst2.next())
         {
         sun[0]=rst2.getString("Num_Run_name");sun[1]=rst2.getString("TIME(`Start_Time`)");sun[2]=rst2.getString("time(`End_Time`)");sun[3]=rst2.getString("time(`Over_Time`)");
         sun[4]=rst2.getString("time(`In_OT_Exceed`)");sun[5]=rst2.getString("time(`Late_Exceed`)");sun[6]=rst2.getString("time(`Early_Exceed`)");sun[7]=rst2.getString("time(`late_after`)");
         sun[8]=rst2.getString("time(`Early_before`)");sun[9]=rst2.getString("time(`lunchin`)");sun[10]=rst2.getString("time(`lunchout`)");sun[11]=rst2.getString("startin");
         sun[12]=rst2.getString("startout");sun[13]=rst2.getString("endin");sun[14]=rst2.getString("endout");sun[15]=rst2.getString("status");
      } PreparedStatement pst3=conn.prepareStatement("SELECT `Num_Run_name`, TIME(`Start_Time`), time(`End_Time`), time(`Over_Time`), time(`In_OT_Exceed`), time(`Late_Exceed`), time(`Early_Exceed`), time(`late_after`), time(`early_before`), time(`lunchin`), time(`lunchout`),  `startin`, `startout`, `endin`, `endout`,status FROM num_run_days where Sch_ID='"+shiftid2.getSelectedItem().toString()+"' and s_Days= '2'");
         ResultSet rst3=pst3.executeQuery();
         if(rst3.next())
         {
         mon[0]=rst3.getString("Num_Run_name");mon[1]=rst3.getString("TIME(`Start_Time`)");mon[2]=rst3.getString("time(`End_Time`)");mon[3]=rst3.getString("time(`Over_Time`)");
         mon[4]=rst3.getString("time(`In_OT_Exceed`)");mon[5]=rst3.getString("time(`Late_Exceed`)");mon[6]=rst3.getString("time(`Early_Exceed`)");mon[7]=rst3.getString("time(`late_after`)");
         mon[8]=rst3.getString("time(`Early_before`)");mon[9]=rst3.getString("time(`lunchin`)");mon[10]=rst3.getString("time(`lunchout`)");mon[11]=rst3.getString("startin");
         mon[12]=rst3.getString("startout");mon[13]=rst3.getString("endin");mon[14]=rst3.getString("endout");mon[15]=rst3.getString("status");
      } 
         PreparedStatement pst4=conn.prepareStatement("SELECT `Num_Run_name`, TIME(`Start_Time`), time(`End_Time`), time(`Over_Time`), time(`In_OT_Exceed`), time(`Late_Exceed`), time(`Early_Exceed`), time(`late_after`), time(`early_before`), time(`lunchin`), time(`lunchout`),  `startin`, `startout`, `endin`, `endout`,status FROM num_run_days where Sch_ID='"+shiftid2.getSelectedItem().toString()+"' and s_Days= '3'");
         ResultSet rst4=pst4.executeQuery();
         if(rst4.next())
         {
         tues[0]=rst4.getString("Num_Run_name");tues[1]=rst4.getString("time(`Start_Time`)");tues[2]=rst4.getString("time(`End_Time`)");tues[3]=rst4.getString("time(`Over_Time`)");
         tues[4]=rst4.getString("time(`In_OT_Exceed`)");tues[5]=rst4.getString("time(`Late_Exceed`)");tues[6]=rst4.getString("time(`Early_Exceed`)");tues[7]=rst4.getString("time(`late_after`)");
         tues[8]=rst4.getString("time(`Early_before`)");tues[9]=rst4.getString("time(`lunchin`)");tues[10]=rst4.getString("time(`lunchout`)");tues[11]=rst4.getString("startin");
         tues[12]=rst4.getString("startout");tues[13]=rst4.getString("endin");tues[14]=rst4.getString("endout");tues[15]=rst4.getString("status");
      } PreparedStatement pst5=conn.prepareStatement("SELECT `Num_Run_name`, time(`Start_Time`), time(`End_Time`), time(`Over_Time`), time(`In_OT_Exceed`), time(`Late_Exceed`), time(`Early_Exceed`), time(`late_after`), time(`early_before`), time(`lunchin`), time(`lunchout`), `startin`, `startout`, `endin`, `endout`,status FROM num_run_days where Sch_ID='"+shiftid2.getSelectedItem().toString()+"' and s_Days= '4'");
         ResultSet rst5=pst5.executeQuery();
         
         if(rst5.next())
         {
         wed[0]=rst5.getString("Num_Run_name");wed[1]=rst5.getString("time(`Start_Time`)");wed[2]=rst5.getString("time(`End_Time`)");wed[3]=rst5.getString("time(`Over_Time`)");
         wed[4]=rst5.getString("time(`In_OT_Exceed`)");wed[5]=rst5.getString("time(`Late_Exceed`)");wed[6]=rst5.getString("time(`Early_Exceed`)");wed[7]=rst5.getString("time(`late_after`)");
         wed[8]=rst5.getString("time(`Early_before`)");wed[9]=rst5.getString("time(`lunchin`)");wed[10]=rst5.getString("time(`lunchout`)");wed[11]=rst5.getString("startin");
         wed[12]=rst5.getString("startout");wed[13]=rst5.getString("endin");wed[14]=rst5.getString("endout");wed[15]=rst5.getString("status");
      } 
         PreparedStatement pst6=conn.prepareStatement("SELECT `Num_Run_name`, time(`Start_Time`), time(`End_Time`), time(`Over_Time`), time(`In_OT_Exceed`), time(`Late_Exceed`), time(`Early_Exceed`), time(`late_after`), time(`early_before`), time(`lunchin`), time(`lunchout`),  `startin`, `startout`, `endin`, `endout`,status FROM num_run_days where Sch_ID='"+shiftid2.getSelectedItem().toString()+"' and s_Days= '5'");
         ResultSet rst6=pst6.executeQuery();
         if(rst6.next())
         {
         thurs[0]=rst6.getString("Num_Run_name");thurs[1]=rst6.getString("time(`Start_Time`)");thurs[2]=rst6.getString("time(`End_Time`)");thurs[3]=rst6.getString("time(`Over_Time`)");
         thurs[4]=rst6.getString("time(`In_OT_Exceed`)");thurs[5]=rst6.getString("time(`Late_Exceed`)");thurs[6]=rst6.getString("time(`Early_Exceed`)");thurs[7]=rst6.getString("time(`late_after`)");
        thurs[8]=rst6.getString("time(`Early_before`)");thurs[9]=rst6.getString("time(`lunchin`)");thurs[10]=rst6.getString("time(`lunchout`)");thurs[11]=rst6.getString("startin");
         thurs[12]=rst6.getString("startout");thurs[13]=rst6.getString("endin");thurs[14]=rst6.getString("endout");thurs[15]=rst6.getString("status");
      } PreparedStatement pst7=conn.prepareStatement("SELECT `Num_Run_name`, time(`Start_Time`), time(`End_Time`), time(`Over_Time`), time(`In_OT_Exceed`), time(`Late_Exceed`), time(`Early_Exceed`), time(`late_after`), time(`early_before`), time(`lunchin`), time(`lunchout`),  `startin`, `startout`, `endin`, `endout`,status FROM num_run_days where Sch_ID='"+shiftid2.getSelectedItem().toString()+"' and s_Days= '6'");
         ResultSet rst7=pst7.executeQuery();
         
         if(rst7.next())
         {
         fri[0]=rst7.getString("Num_Run_name");fri[1]=rst7.getString("time(`Start_Time`)");fri[2]=rst7.getString("time(`End_Time`)");fri[3]=rst7.getString("time(`Over_Time`)");
         fri[4]=rst7.getString("time(`In_OT_Exceed`)");fri[5]=rst7.getString("time(`Late_Exceed`)");fri[6]=rst7.getString("time(`Early_Exceed`)");fri[7]=rst7.getString("time(`late_after`)");
         fri[8]=rst7.getString("time(`Early_before`)");fri[9]=rst7.getString("time(`lunchin`)");fri[10]=rst7.getString("time(`lunchout`)");fri[11]=rst7.getString("startin");
         fri[12]=rst7.getString("startout");fri[13]=rst7.getString("endin");fri[14]=rst7.getString("endout");fri[15]=rst7.getString("status");
      }PreparedStatement pst8=conn.prepareStatement("SELECT `Num_Run_name`, time(`Start_Time`), time(`End_Time`), time(`Over_Time`), time(`In_OT_Exceed`), time(`Late_Exceed`), time(`Early_Exceed`), time(`late_after`), time(`early_before`), time(`lunchin`), time(`lunchout`),  `startin`, `startout`, `endin`, `endout`,status FROM num_run_days where Sch_ID='"+shiftid2.getSelectedItem().toString()+"' and s_Days= '7'");
         ResultSet rst8=pst8.executeQuery();
      if(rst8.next())
         {
         sat[0]=rst8.getString("Num_Run_name");sat[1]=rst8.getString("time(`Start_Time`)");sat[2]=rst8.getString("time(`End_Time`)");sat[3]=rst8.getString("time(`Over_Time`)");
         sat[4]=rst8.getString("time(`In_OT_Exceed`)");sat[5]=rst8.getString("time(`Late_Exceed`)");sat[6]=rst8.getString("time(`Early_Exceed`)");sat[7]=rst8.getString("time(`late_after`)");
         sat[8]=rst8.getString("time(`Early_before`)");sat[9]=rst8.getString("time(`lunchin`)");sat[10]=rst8.getString("time(`lunchout`)");sat[11]=rst8.getString("startin");
         sat[12]=rst8.getString("startout");sat[13]=rst8.getString("endin");sat[14]=rst8.getString("endout");sat[15]=rst8.getString("status");
      }
         progressing.setText(progressing.getText()+" Shift Analyse Complete"); 
            for(int q=0; q < selectedEmployee.getRowCount(); q++){
        //   shifted.setModel (DbUtils.resultSetToTableModel(rst2));
            String incDate="";String dayRotation="";String otRotation="";String earlyRotation=""; String incDate2="";String incDate3="";String incDate4="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
         Calendar d = Calendar.getInstance();
         Calendar e = Calendar.getInstance();
         Calendar f = Calendar.getInstance();

        java.util.Date a=startdate.getDate();
        java.sql.Date abc=new java.sql.Date(a.getTime());
        java.util.Date b=enddate.getDate();
        java.sql.Date ab=new java.sql.Date(b.getTime());
       LocalDate startDate=LocalDate.parse(abc.toString());
            LocalDate endDate=LocalDate.parse(ab.toString());
            String qwe=abc.toString();
            c.setTime(sdf.parse(abc.toString()));
            d.setTime(sdf.parse(abc.toString()));e.setTime(sdf.parse(abc.toString()));f.setTime(sdf.parse(abc.toString()));
            final long days = ChronoUnit.DAYS.between(startDate,endDate);
progressing.setText(progressing.getText()+".");
     //       String a1=empid.getSelectedItem().toString();
            String a2=shiftid2.getSelectedItem().toString();
    
      //     ArrayList<String> abz = new ArrayList<String>();
      if(0 <= days-1){//day check
           
             if(0 <= days){
                   
                       String as1=(selectedEmployee.getValueAt(q, 0).toString());progressing.setText(progressing.getText()+"\n"+as1);
           String as11=(selectedEmployee.getValueAt(q, 1).toString());
                       
                       d.add(Calendar.DATE, 1);e.add(Calendar.DATE, 1);f.add(Calendar.DATE, 1);
                       for(int co=0; co<=days-1 ; co++){
             c.add(Calendar.DATE, 1);d.add(Calendar.DATE, 1);e.add(Calendar.DATE, 1);f.add(Calendar.DATE, 1);
             
          
        System.out.println();
        incDate2 = sdf.format(c.getTime());incDate3 = sdf.format(c.getTime());incDate4 = sdf.format(c.getTime());
                    incDate = sdf.format(c.getTime()); dayRotation = sdf.format(d.getTime()); otRotation = sdf.format(e.getTime()); earlyRotation = sdf.format(f.getTime());  
                    if(dayRotate.isSelected()){incDate2=dayRotation;}else{incDate2=incDate;}
                    if(otRotate.isSelected()){incDate3=otRotation;}else{incDate3=incDate;}
                    if(earlyRotate.isSelected()){incDate4=earlyRotation;}else{incDate4=incDate;}
SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
         java.util.Date a12=sdf1.parse(incDate);
        java.sql.Date abcd2=new java.sql.Date(a12.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(abcd2);
    
        
                  int asd=calendar.get(Calendar.DAY_OF_WEEK); 
                  System.out.println(incDate+" "+asd  );
                     
      
        
                  if(asd==1){
                      if(sunWeek.isSelected()){
                       String query = "replace INTO `holiday_employee`(`emp_id`, `emp_name`, `holiday_id`, `holiday_name`, `date`, `description`) VALUES ('"+as1+"','"+as11+"','1','WeekEnd','"+incDate+"','Sunday')";             // Create query string to insert name into table
                    Statement st=conn.createStatement();
                    int k=st.executeUpdate(query);System.out.println(sun[1]+ "sun");
                     String query1 = "replace INTO `user_of_run2` (`User_ID`,Num_of_run, Start_Date, `shiftname`, `starttime`, `endtime`, `ot`, `inot`, `late`, `early`, `lateexceed`, `earlyexceed`, `lunchin`, `lunchout`, `startin`, `endin`, `startout`, `endout`,status) VALUES ('"+as1+"','"+a2+"','"+incDate+"','"+sun[0]+"','"+incDate+" "+sun[1]+"','"+incDate2+" "+sun[2]+"','"+incDate3+" "+sun[3]+"','"+incDate+" "+sun[4]+"','"+incDate+" "+sun[5]+"','"+incDate4+" "+sun[6]+"','"+incDate+" "+sun[7]+"','"+incDate+" "+sun[8]+"','"+incDate+" "+sun[9]+"','"+incDate+" "+sun[10]+"','"+sun[11]+"','"+sun[12]+"','"+sun[13]+"','"+sun[14]+"','"+sun[15]+"')";             // Create query string to insert name into table
                    Statement st1=conn.createStatement();
                    int k1=st1.executeUpdate(query1);System.out.println(sun[1]+ "sun");
   
                      }else{
                  String query = "replace INTO `user_of_run2` (`User_ID`,Num_of_run, Start_Date, `shiftname`, `starttime`, `endtime`, `ot`, `inot`, `late`, `early`, `lateexceed`, `earlyexceed`, `lunchin`, `lunchout`, `startin`, `endin`, `startout`, `endout`,status) VALUES ('"+as1+"','"+a2+"','"+incDate+"','"+sun[0]+"','"+incDate+" "+sun[1]+"','"+incDate2+" "+sun[2]+"','"+incDate3+" "+sun[3]+"','"+incDate+" "+sun[4]+"','"+incDate+" "+sun[5]+"','"+incDate4+" "+sun[6]+"','"+incDate+" "+sun[7]+"','"+incDate+" "+sun[8]+"','"+incDate+" "+sun[9]+"','"+incDate+" "+sun[10]+"','"+sun[11]+"','"+sun[12]+"','"+sun[13]+"','"+sun[14]+"','"+sun[15]+"')";             // Create query string to insert name into table
                    Statement st=conn.createStatement();
                    int k=st.executeUpdate(query);System.out.println(sun[1]+ "sun");
                  }}
                  if(asd==2){
                  String query = "replace INTO `user_of_run2` (`User_ID`,Num_of_run, Start_Date, `shiftname`, `starttime`, `endtime`, `ot`, `inot`, `late`, `early`, `lateexceed`, `earlyexceed`, `lunchin`, `lunchout`, `startin`, `endin`, `startout`, `endout`,status) VALUES ('"+as1+"','"+a2+"','"+incDate+"','"+mon[0]+"','"+incDate+" "+mon[1]+"','"+incDate2+" "+mon[2]+"','"+incDate3+" "+mon[3]+"','"+incDate+" "+mon[4]+"','"+incDate+" "+mon[5]+"','"+incDate4+" "+mon[6]+"','"+incDate+" "+mon[7]+"','"+incDate+" "+mon[8]+"','"+incDate+" "+mon[9]+"','"+incDate+" "+mon[10]+"','"+mon[11]+"','"+mon[12]+"','"+mon[13]+"','"+mon[14]+"','"+mon[15]+"')";             // Create query string to insert name into table
                    Statement st=conn.createStatement();
                    int k=st.executeUpdate(query);System.out.println(mon[1]+ "mon");
                  }
                  if(asd==3){
                  String query = "replace INTO `user_of_run2` (`User_ID`,Num_of_run, Start_Date, `shiftname`, `starttime`, `endtime`, `ot`, `inot`, `late`, `early`, `lateexceed`, `earlyexceed`, `lunchin`, `lunchout`, `startin`, `endin`, `startout`, `endout`,status) VALUES ('"+as1+"','"+a2+"','"+incDate+"','"+tues[0]+"','"+incDate+" "+tues[1]+"','"+incDate2+" "+tues[2]+"','"+incDate3+" "+tues[3]+"','"+incDate+" "+tues[4]+"','"+incDate+" "+tues[5]+"','"+incDate4+" "+tues[6]+"','"+incDate+" "+tues[7]+"','"+incDate+" "+tues[8]+"','"+incDate+" "+tues[9]+"','"+incDate+" "+tues[10]+"','"+tues[11]+"','"+tues[12]+"','"+tues[13]+"','"+tues[14]+"','"+tues[15]+"')";             // Create query string to insert name into table
                    Statement st=conn.createStatement();
                    int k=st.executeUpdate(query);System.out.println(tues[1]+ "tues");
                  }
                  if(asd==4){
                  String query = "replace INTO `user_of_run2` (`User_ID`,Num_of_run, Start_Date, `shiftname`, `starttime`, `endtime`, `ot`, `inot`, `late`, `early`, `lateexceed`, `earlyexceed`, `lunchin`, `lunchout`, `startin`, `endin`, `startout`, `endout`,status) VALUES ('"+as1+"','"+a2+"','"+incDate+"','"+wed[0]+"','"+incDate+" "+wed[1]+"','"+incDate2+" "+wed[2]+"','"+incDate3+" "+wed[3]+"','"+incDate+" "+wed[4]+"','"+incDate+" "+wed[5]+"','"+incDate4+" "+wed[6]+"','"+incDate+" "+wed[7]+"','"+incDate+" "+wed[8]+"','"+incDate+" "+wed[9]+"','"+incDate+" "+wed[10]+"','"+wed[11]+"','"+wed[12]+"','"+wed[13]+"','"+wed[14]+"','"+wed[15]+"')";             // Create query string to insert name into table
                    Statement st=conn.createStatement();
                    int k=st.executeUpdate(query);System.out.println(wed[1]+ "wed");
                  }
                  if(asd==5){
                  String query = "replace INTO `user_of_run2` (`User_ID`,Num_of_run, Start_Date, `shiftname`, `starttime`, `endtime`, `ot`, `inot`, `late`, `early`, `lateexceed`, `earlyexceed`, `lunchin`, `lunchout`, `startin`, `endin`, `startout`, `endout`,status) VALUES ('"+as1+"','"+a2+"','"+incDate+"','"+thurs[0]+"','"+incDate+" "+thurs[1]+"','"+incDate2+" "+thurs[2]+"','"+incDate3+" "+thurs[3]+"','"+incDate+" "+thurs[4]+"','"+incDate+" "+thurs[5]+"','"+incDate4+" "+thurs[6]+"','"+incDate+" "+thurs[7]+"','"+incDate+" "+thurs[8]+"','"+incDate+" "+thurs[9]+"','"+incDate+" "+thurs[10]+"','"+thurs[11]+"','"+thurs[12]+"','"+thurs[13]+"','"+thurs[14]+"','"+thurs[15]+"')";             // Create query string to insert name into table
                    Statement st=conn.createStatement();
                    int k=st.executeUpdate(query); System.out.println(thurs[1]+ "thurs");
                  }
                  if(asd==6){
                  String query = "replace INTO `user_of_run2` (`User_ID`,Num_of_run, Start_Date, `shiftname`, `starttime`, `endtime`, `ot`, `inot`, `late`, `early`, `lateexceed`, `earlyexceed`, `lunchin`, `lunchout`, `startin`, `endin`, `startout`, `endout`,status) VALUES ('"+as1+"','"+a2+"','"+incDate+"','"+fri[0]+"','"+incDate+" "+fri[1]+"','"+incDate2+" "+fri[2]+"','"+incDate3+" "+fri[3]+"','"+incDate+" "+fri[4]+"','"+incDate+" "+fri[5]+"','"+incDate4+" "+fri[6]+"','"+incDate+" "+fri[7]+"','"+incDate+" "+fri[8]+"','"+incDate+" "+fri[9]+"','"+incDate+" "+fri[10]+"','"+fri[11]+"','"+fri[12]+"','"+fri[13]+"','"+fri[14]+"','"+fri[15]+"')";             // Create query string to insert name into table
                    Statement st=conn.createStatement();
                    int k=st.executeUpdate(query);System.out.println(fri[1]+ "fri");
                  }
                  if(asd==7){
                       if(satWeek.isSelected()){
                       String query = "replace INTO `holiday_employee`(`emp_id`, `emp_name`, `holiday_id`, `holiday_name`, `date`, `description`) VALUES ('"+as1+"','"+as11+"','1','WeekEnd','"+incDate+"','Saturday')";             // Create query string to insert name into table
                    Statement st=conn.createStatement();
                    int k=st.executeUpdate(query);}
                  String query = "replace INTO `user_of_run2` (`User_ID`,Num_of_run, Start_Date, `shiftname`, `starttime`, `endtime`, `ot`, `inot`, `late`, `early`, `lateexceed`, `earlyexceed`, `lunchin`, `lunchout`, `startin`, `endin`, `startout`, `endout`,status) VALUES ('"+as1+"','"+a2+"','"+incDate+"','"+sat[0]+"','"+incDate+" "+sat[1]+"','"+incDate2+" "+sat[2]+"','"+incDate3+" "+sat[3]+"','"+incDate+" "+sat[4]+"','"+incDate+" "+sat[5]+"','"+incDate4+" "+sat[6]+"','"+incDate+" "+sat[7]+"','"+incDate+" "+sat[8]+"','"+incDate+" "+sat[9]+"','"+incDate+" "+sat[10]+"','"+sat[11]+"','"+sat[12]+"','"+sat[13]+"','"+sat[14]+"','"+sat[15]+"')";             // Create query string to insert name into table
                    Statement st=conn.createStatement();
                    int k=st.executeUpdate(query);System.out.println(sat[1]+ "sat");
                  }
                
               }progressing.setText(progressing.getText()+" done ");
               
            //        System.out.println("Current day is : " + strDays[sdf.format(c.get(Calendar.DAY_OF_WEEK)-1)];  ;
        
//shifted.setValueAt(empid.getSelectedItem().toString(), co, 0);
//shifted.setValueAt(shiftid2.getSelectedItem().toString(), co, 1);
//shifted.setValueAt(asd, co, 1);

//shifted.setValueAt(incDate, co, 2);
//Date Decrement if night true
        }
             }}progressing.setText("Schedule Apply successful");
             
           
           
           
        
                    }
        catch(Exception ex){JOptionPane.showMessageDialog(null,"Selected shift missing something"+ex);
        }    
    //    System.out.println(shiftNamedd+" "+inTimedd+" "+outTimedd+" "+otdd+" "+inotdd+" "+latedd+" "+earlydd+" "+lateExceeddd+" "+earlyExceeddd+" "+lunchIndd+" "+lunchOutdd+" "+startIndd+" "+startOutdd+" "+endIndd+" "+endOutdd+" "+statusdd);
              
              
        /*      
         for(int q=0; q < selectedEmployee.getRowCount(); q++){         
      
       String as1=(selectedEmployee.getValueAt(q, 0).toString());progressing.setText(progressing.getText()+"\n"+as1);
       
              eror5.setText("");
        String incDate="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();

        java.util.Date a=startdate.getDate();
        java.sql.Date abc=new java.sql.Date(a.getTime());
        java.util.Date b=enddate.getDate();
        java.sql.Date ab=new java.sql.Date(b.getTime());
progressing.setText(progressing.getText()+".");     
        try
        {LocalDate startDate=LocalDate.parse(abc.toString());
            LocalDate endDate=LocalDate.parse(ab.toString());
            String qwe=abc.toString();
            c.setTime(sdf.parse(abc.toString()));
            final long days = ChronoUnit.DAYS.between(startDate,endDate);
progressing.setText(progressing.getText()+".");
     //       String a1=empid.getSelectedItem().toString();
            String a2=shiftid2.getSelectedItem().toString();
     //        while(pop < days){ c.add(Calendar.DATE, 1);
         
Class.forName("com.mysql.jdbc.Driver"); //connection mysql
                Connection con = DriverManager.getConnection(url,id,pass);
      //     ArrayList<String> abz = new ArrayList<String>();
      if(0 <=days-1){//day check
           
             if(2 <= days){
            for(int co=0; co<=days-1 ; co++){
             c.add(Calendar.DATE, 1);
                    incDate = sdf.format(c.getTime());       //all dates
             String query = "replace INTO `user_of_run2` (`User_ID`,Num_of_run, Start_Date, `shiftname`, `starttime`, `endtime`, `ot`, `inot`, `late`, `early`, `lateexceed`, `earlyexceed`, `lunchin`, `lunchout`, `startin`, `endin`, `startout`, `endout`) VALUES ('"+as1+"','"+a2+"','"+incDate+"','"+shiftNamedd+"','"+inTimedd+"','"+outTimedd+"','"+otdd+"','"+inotdd+"','"+latedd+"','"+earlydd+"','"+lateExceeddd+"','"+earlyExceeddd+"','"+lunchIndd+"','"+lunchOutdd+"','"+startIndd+"','"+startOutdd+"','"+endIndd+"','"+endOutdd+"')";             // Create query string to insert name into table
                    Statement st=con.createStatement();
                    int k=st.executeUpdate(query);
                   
            }
            }                                       //1st Date
 PreparedStatement pst2=con.prepareStatement("replace INTO `user_of_run2` (`User_ID`,Num_of_run, Start_Date, `shiftname`, `starttime`, `endtime`, `ot`, `inot`, `late`, `early`, `lateexceed`, `earlyexceed`, `lunchin`, `lunchout`, `startin`, `endin`, `startout`, `endout`) VALUES ('"+as1+"','"+a2+"','"+startDate+"','"+shiftNamedd+"','"+inTimedd+"','"+outTimedd+"','"+otdd+"','"+inotdd+"','"+latedd+"','"+earlydd+"','"+lateExceeddd+"','"+earlyExceeddd+"','"+lunchIndd+"','"+lunchOutdd+"','"+startIndd+"','"+startOutdd+"','"+endIndd+"','"+endOutdd+"')");

            pst2.executeUpdate();
            progressing.setText(progressing.getText()+". Done");
              
            }else{JOptionPane.showMessageDialog(null,"Error: End date is smaller than start date");}
         } 
        
        catch(Exception e)
        {

        } }*/
      }}).start();
         
   
    }//GEN-LAST:event_jButton9ActionPerformed

    private void shiftid2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shiftid2ActionPerformed
        String s12=shiftid2.getSelectedItem().toString();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst=conn.prepareStatement("SELECT Name FROM `num_run` where Num_RunID='"+s12+"'");
            ResultSet rst1=pst.executeQuery();

            while(rst1.next()){
                shiftname.setSelectedItem(rst1.getString("Name"));}

        }
        catch(Exception ex){JOptionPane.showMessageDialog(null,"");
        }
    }//GEN-LAST:event_shiftid2ActionPerformed

    private void table3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table3MouseClicked
        DefaultTableModel model = (DefaultTableModel)table.getModel();

        // get the selected row index
        int selectedRowIndex = table.getSelectedRow();

        // set the selected row data into jtextfields
        empid.setSelectedItem(model.getValueAt(selectedRowIndex, 0).toString());
        empname.setSelectedItem(model.getValueAt(selectedRowIndex, 1).toString());
        shiftid2.setSelectedItem(model.getValueAt(selectedRowIndex, 2).toString());
        shiftname.setSelectedItem(model.getValueAt(selectedRowIndex, 3).toString());

    }//GEN-LAST:event_table3MouseClicked

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked
 //       DefaultTableModel model = (DefaultTableModel)table2.getModel();

        // get the selected row index
   //     int selectedRowIndex = table2.getSelectedRow();

        // set the selected row data into jtextfields

     //   empid.setSelectedItem(model.getValueAt(selectedRowIndex, 0).toString());
 
    }//GEN-LAST:event_table2MouseClicked

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
this.dispose();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void startdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startdateMouseClicked
 java.util.Date a=startdate.getDate();
        java.sql.Date abc=new java.sql.Date(a.getTime());
       
        
        int pop=abc.getDate();
        int pop2=abc.getMonth();
        int pop3=abc.getYear();
        JOptionPane.showMessageDialog(null, pop+"-"+pop2+"-"+"-"+pop3);
    }//GEN-LAST:event_startdateMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//        Calendar clndr = Calendar.getInstance();
        int idd=Integer.parseInt(aid.getText());
        String named=aname.getText();
        java.util.Date sdate=astartdate.getDate();
        java.sql.Date ssqldate=new java.sql.Date(sdate.getTime());

        java.util.Date edate=aenddate.getDate();
        java.sql.Date esqldate=new java.sql.Date(edate.getTime());

        int cycle=Integer.parseInt(acycle.getText());  int unit=Integer.parseInt(aunit.getText());
        try
        {

            String query =
            "INSERT INTO `num_run` VALUES ('"+idd+"','"+named+"','"+ssqldate+"','"+esqldate+"','"+cycle+"','"+unit+"')";             // Create query string to insert name into table

            Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

            Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

            PreparedStatement pst= con.prepareStatement(query);                             // Create statement
            pst.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Shift Added");
            reset3();
            //                                    Execute Query
            //pst.setString(1,str1);
            //          pst.setString(2,p);
            // Close the open connection
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null,"");}
        reset();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
             int a444=Integer.parseInt(aid.getText());
       
        String l="hh:mm:ss";
        try
        {

            
             String query2="DELETE FROM `num_run_days` WHERE sch_ID='"+a444+"'";
             String query3="DELETE FROM `num_run` WHERE Num_RunID='"+a444+"'";
             String query4="DELETE FROM `user_of_run2` WHERE Num_of_run='"+a444+"'";
            Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

            Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

            
            PreparedStatement pst2= con.prepareStatement(query2);                             // Create statement
            pst2.executeUpdate();
            PreparedStatement pst3= con.prepareStatement(query3);                             // Create statement
            pst3.executeUpdate();
             PreparedStatement pst4= con.prepareStatement(query4);                             // Create statement
            pst4.executeUpdate();
            JOptionPane.showMessageDialog(null,"delete successfull");
            reset();reset3();
            //                                    Execute Query
            //pst.setString(1,str1)            //          pst.setString(2,p);
            // Close the open connection
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null,"");
        }

    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int a444=Integer.parseInt(empid.getSelectedItem().toString());
        int a445=Integer.parseInt(shiftid2.getSelectedItem().toString());
       java.util.Date a=startdate.getDate();
        java.sql.Date abc=new java.sql.Date(a.getTime());
        java.util.Date b=enddate.getDate();
        java.sql.Date ab=new java.sql.Date(b.getTime());
        String l="hh:mm:ss";
        try
        {
             String query4="DELETE FROM `user_of_run2` WHERE User_ID='"+a444+"' and Num_of_run='"+a445+"' and Start_Date between '"+abc+"' and '"+ab+"'  ";
            Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class
            Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials
             PreparedStatement pst4= con.prepareStatement(query4);                             // Create statement
            pst4.executeUpdate();
            eror5.setText("delete successfull");
            reset1();reset3();
            //                                    Execute Query
            //pst.setString(1,str1)            //          pst.setString(2,p);
            // Close the open connection
        }
        catch(Exception e)
        {eror5.setText("");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void table5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table5MouseClicked
        DefaultTableModel model = (DefaultTableModel)table5.getModel();
 //time(`Over_Time`) as 'OT', time(`In_OT_Exceed`) as 'IN OT', time(`Late_Exceed`) as 'Late', time(`Early_Exceed`) as 'Early', time(`late_after`) as 'Late by Hour', time(`early_before`) as 'Early by Hour', time(`lunchin`) as 'Lunch IN', time(`lunchout`) as 'Lunch OUT', `status`, `startin`, `startout`, `endin`, `endout` from num_run_days left join num_run on num_run_days.Num_RunID=num_run.Num_RunID
        // get the selected row index
        int selectedRowIndex = table5.getSelectedRow();
shift1.setSelectedItem(model.getValueAt(selectedRowIndex, 12).toString());
        schedule1.setSelectedItem(model.getValueAt(selectedRowIndex, 1).toString());
         LE.setTime((Date) model.getValueAt(selectedRowIndex, 6));
        EE.setTime((Date) model.getValueAt(selectedRowIndex, 7));
        IOT.setTime((Date) model.getValueAt(selectedRowIndex, 5));
        overtime.setTime((Date) model.getValueAt(selectedRowIndex, 4));
        EA.setTime((Date) model.getValueAt(selectedRowIndex, 8));
        EB.setTime((Date) model.getValueAt(selectedRowIndex, 9));
         lunchin.setTime((Date) model.getValueAt(selectedRowIndex, 19));
        lunchout.setTime((Date) model.getValueAt(selectedRowIndex, 20));
        startin.setTime((Date) model.getValueAt(selectedRowIndex, 22));
        startout.setTime((Date) model.getValueAt(selectedRowIndex, 23));
        endin.setTime((Date) model.getValueAt(selectedRowIndex, 24));
        endout.setTime((Date) model.getValueAt(selectedRowIndex, 25));
        
        String a=( model.getValueAt(selectedRowIndex, 10).toString());
       switch(a){
               case "Sunday": {sun.setSelected(true);
               mon.setSelected(false);tues.setSelected(false);wed.setSelected(false);thurs.setSelected(false);fri.setSelected(false);sat.setSelected(false);
               break;} 
               case "Monday": {mon.setSelected(true); 
               sun.setSelected(false);tues.setSelected(false);wed.setSelected(false);thurs.setSelected(false);fri.setSelected(false);sat.setSelected(false);
               break;} 
               
               case "Tuesday": {tues.setSelected(true); 
               mon.setSelected(false);sun.setSelected(false);wed.setSelected(false);thurs.setSelected(false);fri.setSelected(false);sat.setSelected(false);
               break;} 
               case "Wednesday": {wed.setSelected(true);
               mon.setSelected(false);tues.setSelected(false);sun.setSelected(false);thurs.setSelected(false);fri.setSelected(false);sat.setSelected(false);
               break;} 
               case "Thursday": {thurs.setSelected(true);
               mon.setSelected(false);tues.setSelected(false);wed.setSelected(false);sun.setSelected(false);fri.setSelected(false);sat.setSelected(false);
               break;} 
               case "Friday": {fri.setSelected(true);
               mon.setSelected(false);tues.setSelected(false);wed.setSelected(false);thurs.setSelected(false);sun.setSelected(false);sat.setSelected(false);
               break;} 
               case "Saturday": {sat.setSelected(true); 
               mon.setSelected(false);tues.setSelected(false);wed.setSelected(false);thurs.setSelected(false);fri.setSelected(false);sun.setSelected(false);
               break;} 
           
           }
//Num_RunID as 'Schedule ID', Num_Run_name as 'Schedule Name', `Start_Time`, `End_Time` ,`Over_Time` , `In_OT_Exceed`, `Late_Exceed`, `Early_Exceed`, `late_after`, `early_before`, `s_Days`  ,`Sch_ID` ,`Sch_name` 
        
    }//GEN-LAST:event_table5MouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
          try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst2=conn.prepareStatement("SELECT Num_RunID,Name FROM num_run");
            ResultSet rst2=pst2.executeQuery();
           DefaultComboBoxModel listModel = new DefaultComboBoxModel();
           DefaultComboBoxModel listModel2 = new DefaultComboBoxModel();
            
           while(rst2.next()){
               listModel.addElement(rst2.getString("Num_RunID"));
                listModel2.addElement(rst2.getString("Name"));
               shiftid2.setModel(listModel);
                shiftname.setModel(listModel2);}}
       /* ResultSet rst1=pst.executeQuery();
                DefaultComboBoxModel listModel = new DefaultComboBoxModel();

                listModel.insertElementAt("All",0);
                while(rst1.next()){
                    listModel.addElement(rst1.getString("Name"));
                    employee.setModel(listModel);
                    }*/
        catch(Exception ex){JOptionPane.showMessageDialog(null,"");
        }
          try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst=conn.prepareStatement("SELECT name FROM `shift`");
           
            ResultSet rst1=pst.executeQuery();
            DefaultComboBoxModel lqwer = new DefaultComboBoxModel();
         
           while(rst1.next()){ 
               lqwer.addElement(rst1.getString("name"));
         shift1.setModel(lqwer);
               
           }
            
                    }
        catch(Exception ex){
        
        }
try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst=conn.prepareStatement("SELECT name FROM `num_run`");
           
            ResultSet rst1=pst.executeQuery();
            DefaultComboBoxModel lqwer = new DefaultComboBoxModel();
           while(rst1.next()){
             
               lqwer.addElement(rst1.getString("name"));
         schedule1.setModel(lqwer);
               
           }
            
                    }
        catch(Exception ex){
        
        }
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
               DefaultTableModel model = (DefaultTableModel)table.getModel();

        // get the selected row index
        int selectedRowIndex = table.getSelectedRow();

        // set the selected row data into jtextfields
        idd.setText(model.getValueAt(selectedRowIndex, 0).toString());
        name.setText(model.getValueAt(selectedRowIndex, 1).toString());
        checkin.setTime((Date)model.getValueAt(selectedRowIndex, 2));
        checkout.setTime((Date)model.getValueAt(selectedRowIndex, 3));
        
    }//GEN-LAST:event_tableMouseClicked

    private void shift1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shift1ActionPerformed
        String s12=shift1.getSelectedItem().toString();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst=conn.prepareStatement("SELECT name,sch_ID,timein,timeout FROM `shift` where name='"+s12+"'");

            ResultSet rst1=pst.executeQuery();

            while(rst1.next()){
                //shiftid.addItem(rst1.getString("sch_ID"));
                shiftid.setText(rst1.getString("sch_ID"));
                sstarttime.setTime(rst1.getTime("timein"));
                sendtime.setTime(rst1.getTime("timeout"));
                IOT.setTime(rst1.getTime("timein"));
                overtime.setTime(rst1.getTime("timeout"));
                LE.setTime(rst1.getTime("timein"));
                EE.setTime(rst1.getTime("timeout"));
                EA.setTime(rst1.getTime("timein"));
                EB.setTime(rst1.getTime("timeout"));
            }

        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_shift1ActionPerformed

    private void monActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monActionPerformed

    }//GEN-LAST:event_monActionPerformed

    private void tuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tuesActionPerformed

    private void schedule1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schedule1ActionPerformed
       String s13=schedule1.getSelectedItem().toString();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst=conn.prepareStatement("SELECT Num_RunID,name FROM `num_run` where name='"+s13+"'");

            ResultSet rst1=pst.executeQuery();

            while(rst1.next()){
                //scheduleid.addItem(rst1.getString("Num_RunID"));
                scheduleid.setText(rst1.getString("Num_RunID"));

            }

        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error combo"+ex);
        }
    }//GEN-LAST:event_schedule1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(nights.isSelected())
        {            d1="2017-01-01"; d2="2017-01-02"; stat=1;} else {            d1="2017-01-01"; d2="2017-01-01";stat=0;}
        String b1=shift1.getSelectedItem().toString();

        String b2=shiftid.getText();

        String b3=schedule1.getSelectedItem().toString();

        String b4=scheduleid.getText();

        int b5=sstarttime.getHours();
        int b6=sstarttime.getMinutes();
        int b7=sstarttime.getSeconds();

        int b8=sendtime.getHours();
        int b9=sendtime.getMinutes();
        int b10=sendtime.getSeconds();

        int b11=overtime.getHours();
        int b12=overtime.getMinutes();
        int b13=overtime.getSeconds();

        int b14=IOT.getHours();
        int b15=IOT.getMinutes();
        int b16=IOT.getSeconds();

        int b17=LE.getHours();
        int b18=LE.getMinutes();
        int b19=LE.getSeconds();

        int b20=EE.getHours();
        int b21=EE.getMinutes();
        int b22=EE.getSeconds();

        int b23=EA.getHours();
        int b24=EA.getMinutes();
        int b25=EA.getSeconds();

        int b26=EB.getHours();
        int b27=EB.getMinutes();
        int b28=EB.getSeconds();
        
        int b29=lunchin.getHours();
        int b30=lunchin.getMinutes();
        int b31=lunchin.getSeconds();

        int b32=lunchout.getHours();
        int b33=lunchout.getMinutes();
        int b34=lunchout.getSeconds();
        
        int b35=startin.getHours();
        int b36=startin.getMinutes();
        int b37=startin.getSeconds();

        int b38=startout.getHours();
        int b39=startout.getMinutes();
        int b40=startout.getSeconds();
        
        int b41=endin.getHours();
        int b42=endin.getMinutes();
        int b43=endin.getSeconds();

        int b44=endout.getHours();
        int b45=endout.getMinutes();
        int b46=endout.getSeconds();
        if(b1.isEmpty() || b2.isEmpty() || b3.isEmpty() || b4.isEmpty() || b5 == 00 && b6 == 00 && b7 == 00 || b8 == 00 && b9 == 00 && b10 == 00 || b11 == 00 && b12 == 00 && b13 == 00 || b14 == 00 && b15 == 00 && b16 == 00 || b17 == 00 && b18 == 00 && b19 == 00 || b20 == 00 && b21 == 00 && b22 == 00 || b23 == 00 && b24 == 00 && b25 == 00 || b26 == 00 && b27 == 00 && b28 == 00 || b29 == 00 && b30 == 00 && b31 == 00 || b32 == 00 && b33 == 00 && b34 == 00 || b35 == 00 && b36 == 00 && b37 == 00 || b38 == 00 && b39 == 00 && b40 == 00 || b41 == 00 && b42 == 00 && b43 == 00 || b44 == 00 && b45 == 00 && b46 == 00)
        {JOptionPane.showMessageDialog(null,"Please Provide Complete Details");}else{
            if(mon.isSelected())

            {int mond=2;
                String a1=shift1.getSelectedItem().toString();

                String a2=shiftid.getText();

                String a3=schedule1.getSelectedItem().toString();

                String a4=scheduleid.getText();

                int a5=sstarttime.getHours();
                int a6=sstarttime.getMinutes();
                int a7=sstarttime.getSeconds();

                int a8=sendtime.getHours();
                int a9=sendtime.getMinutes();
                int a10=sendtime.getSeconds();

                int a11=overtime.getHours();
                int a12=overtime.getMinutes();
                int a13=overtime.getSeconds();

                int a14=IOT.getHours();
                int a15=IOT.getMinutes();
                int a16=IOT.getSeconds();

                int a17=LE.getHours();
                int a18=LE.getMinutes();
                int a19=LE.getSeconds();

                int a20=EE.getHours();
                int a21=EE.getMinutes();
                int a22=EE.getSeconds();

                int a23=EA.getHours();
                int a24=EA.getMinutes();
                int a25=EA.getSeconds();

                int a26=EB.getHours();
                int a27=EB.getMinutes();
                int a28=EB.getSeconds();
                int a29=lunchin.getHours();
        int a30=lunchin.getMinutes();
        int a31=lunchin.getSeconds();

        int a32=lunchout.getHours();
        int a33=lunchout.getMinutes();
        int a34=lunchout.getSeconds();
        int a35=startin.getHours();
        int a36=startin.getMinutes();
        int a37=startin.getSeconds();

        int a38=startout.getHours();
        int a39=startout.getMinutes();
        int a40=startout.getSeconds();
        
        int a41=endin.getHours();
        int a42=endin.getMinutes();
        int a43=endin.getSeconds();

        int a44=endout.getHours();
        int a45=endout.getMinutes();
        int a46=endout.getSeconds();
        try{

                    String query = "INSERT INTO `num_run_days` VALUES('"+a4+"','"+a3+"','"+d1+" "+a5+":"+a6+":"+a7+"','"+d2+" "+a8+":"+a9+":"+a10+"','"+mond+"','"+mond+"','"+a2+"','"+a1+"','"+d2+" "+a11+":"+a12+":"+a13+"','"+d1+" "+a14+":"+a15+":"+a16+"','"+d1+" "+a17+":"+a18+":"+a19+"','"+d2+" "+a20+":"+a21+":"+a22+"','"+d1+" "+a23+":"+a24+":"+a25+"','"+d2+" "+a26+":"+a27+":"+a28+"','"+d1+" "+a29+":"+a30+":"+a31+"','"+d1+" "+a32+":"+a33+":"+a34+"','"+stat+"','"+a35+":"+a36+":"+a37+"','"+a38+":"+a39+":"+a40+"','"+a41+":"+a42+":"+a43+"','"+a44+":"+a45+":"+a46+"')";             // Create query string to insert name into table
// String sift = "INSERT INTO `num_run_days` VALUES('100','nightdefault','2017-01-01 00:00:01','2017-01-01 23:59:59','"+mond+"','"+mond+"','100','nightdefault','2017-01-01 00:00:01','2017-01-01 00:00:01','2017-01-01 00:00:01','2017-01-01 00:00:01','2017-01-01 00:00:01','2017-01-01 00:00:01','2017-01-01 00:00:01','2017-01-01 00:00:01','0','2017-01-01 00:01:00','2017-01-01 23:59:59','2017-01-01 00:01:00','2017-01-01 23:59:59')";             // Create query string to insert name into table

                    Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

                    Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

                    PreparedStatement pst= con.prepareStatement(query);                             // Create statement
                    pst.executeUpdate();JOptionPane.showMessageDialog(null,"Monday Add Successfull");
                    reset3();
                    //                                    Execute Query
                    //pst.setString(1,str1);
                    //          pst.setString(2,p);
                    // Close the open connection
                }
                catch(Exception e)
                {JOptionPane.showMessageDialog(null,"Command Unsuccessfull");

                }}
                if(tues.isSelected())
                {int tuesd=3;
                    String a1=shift1.getSelectedItem().toString();

                    String a2=shiftid.getText();

                    String a3=schedule1.getSelectedItem().toString();

                    String a4=scheduleid.getText();

                    int a5=sstarttime.getHours();
                    int a6=sstarttime.getMinutes();
                    int a7=sstarttime.getSeconds();

                    int a8=sendtime.getHours();
                    int a9=sendtime.getMinutes();
                    int a10=sendtime.getSeconds();

                    int a11=overtime.getHours();
                    int a12=overtime.getMinutes();
                    int a13=overtime.getSeconds();

                    int a14=IOT.getHours();
                    int a15=IOT.getMinutes();
                    int a16=IOT.getSeconds();

                    int a17=LE.getHours();
                    int a18=LE.getMinutes();
                    int a19=LE.getSeconds();

                    int a20=EE.getHours();
                    int a21=EE.getMinutes();
                    int a22=EE.getSeconds();

                    int a23=EA.getHours();
                    int a24=EA.getMinutes();
                    int a25=EA.getSeconds();

                    int a26=EB.getHours();
                    int a27=EB.getMinutes();
                    int a28=EB.getSeconds();
                    int a29=lunchin.getHours();
        int a30=lunchin.getMinutes();
        int a31=lunchin.getSeconds();

        int a32=lunchout.getHours();
        int a33=lunchout.getMinutes();
        int a34=lunchout.getSeconds();
        int a35=startin.getHours();
        int a36=startin.getMinutes();
        int a37=startin.getSeconds();

        int a38=startout.getHours();
        int a39=startout.getMinutes();
        int a40=startout.getSeconds();
        
        int a41=endin.getHours();
        int a42=endin.getMinutes();
        int a43=endin.getSeconds();

        int a44=endout.getHours();
        int a45=endout.getMinutes();
        int a46=endout.getSeconds();
                    try
                    {

                        String query = "INSERT INTO `num_run_days` VALUES('"+a4+"','"+a3+"','"+d1+" "+a5+":"+a6+":"+a7+"','"+d2+" "+a8+":"+a9+":"+a10+"','"+tuesd+"','"+tuesd+"','"+a2+"','"+a1+"','"+d2+" "+a11+":"+a12+":"+a13+"','"+d1+" "+a14+":"+a15+":"+a16+"','"+d1+" "+a17+":"+a18+":"+a19+"','"+d2+" "+a20+":"+a21+":"+a22+"','"+d1+" "+a23+":"+a24+":"+a25+"','"+d2+" "+a26+":"+a27+":"+a28+"','"+d1+" "+a29+":"+a30+":"+a31+"','"+d1+" "+a32+":"+a33+":"+a34+"','"+stat+"','"+a35+":"+a36+":"+a37+"','"+a38+":"+a39+":"+a40+"','"+a41+":"+a42+":"+a43+"','"+a44+":"+a45+":"+a46+"')";             // Create query string to insert name into table

                        Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

                        Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

                        PreparedStatement pst= con.prepareStatement(query);                             // Create statement
                        pst.executeUpdate();reset3();
                        JOptionPane.showMessageDialog(null,"Tuesday Add Successfull");
                        //                                    Execute Query
                        //pst.setString(1,str1);
                        //          pst.setString(2,p);
                        // Close the open connection
                    }
                    catch(Exception e)
                    {JOptionPane.showMessageDialog(null,"Command Unsuccessfull");
                    }
                }
                if(wed.isSelected())
                {int wednesd=4;
                    String a1=shift1.getSelectedItem().toString();

                    String a2=shiftid.getText();

                    String a3=schedule1.getSelectedItem().toString();

                    String a4=scheduleid.getText();

                    int a5=sstarttime.getHours();
                    int a6=sstarttime.getMinutes();
                    int a7=sstarttime.getSeconds();

                    int a8=sendtime.getHours();
                    int a9=sendtime.getMinutes();
                    int a10=sendtime.getSeconds();

                    int a11=overtime.getHours();
                    int a12=overtime.getMinutes();
                    int a13=overtime.getSeconds();

                    int a14=IOT.getHours();
                    int a15=IOT.getMinutes();
                    int a16=IOT.getSeconds();

                    int a17=LE.getHours();
                    int a18=LE.getMinutes();
                    int a19=LE.getSeconds();

                    int a20=EE.getHours();
                    int a21=EE.getMinutes();
                    int a22=EE.getSeconds();

                    int a23=EA.getHours();
                    int a24=EA.getMinutes();
                    int a25=EA.getSeconds();

                    int a26=EB.getHours();
                    int a27=EB.getMinutes();
                    int a28=EB.getSeconds();
                    int a29=lunchin.getHours();
        int a30=lunchin.getMinutes();
        int a31=lunchin.getSeconds();

        int a32=lunchout.getHours();
        int a33=lunchout.getMinutes();
        int a34=lunchout.getSeconds();
        int a35=startin.getHours();
        int a36=startin.getMinutes();
        int a37=startin.getSeconds();

        int a38=startout.getHours();
        int a39=startout.getMinutes();
        int a40=startout.getSeconds();
        
        int a41=endin.getHours();
        int a42=endin.getMinutes();
        int a43=endin.getSeconds();

        int a44=endout.getHours();
        int a45=endout.getMinutes();
        int a46=endout.getSeconds();
                    try
                    {

                        String query = "INSERT INTO `num_run_days` VALUES('"+a4+"','"+a3+"','"+d1+" "+a5+":"+a6+":"+a7+"','"+d2+" "+a8+":"+a9+":"+a10+"','"+wednesd+"','"+wednesd+"','"+a2+"','"+a1+"','"+d2+" "+a11+":"+a12+":"+a13+"','"+d1+" "+a14+":"+a15+":"+a16+"','"+d1+" "+a17+":"+a18+":"+a19+"','"+d2+" "+a20+":"+a21+":"+a22+"','"+d1+" "+a23+":"+a24+":"+a25+"','"+d2+" "+a26+":"+a27+":"+a28+"','"+d1+" "+a29+":"+a30+":"+a31+"','"+d1+" "+a32+":"+a33+":"+a34+"','"+stat+"','"+a35+":"+a36+":"+a37+"','"+a38+":"+a39+":"+a40+"','"+a41+":"+a42+":"+a43+"','"+a44+":"+a45+":"+a46+"')";             // Create query string to insert name into table

                        Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

                        Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

                        PreparedStatement pst= con.prepareStatement(query);                             // Create statement
                        pst.executeUpdate();JOptionPane.showMessageDialog(null,"Command Successfull");reset3();
                        //                                    Execute Query
                        //pst.setString(1,str1);
                        //          pst.setString(2,p);
                        // Close the open connection
                    }
                    catch(Exception e)
                    {JOptionPane.showMessageDialog(null,"Command Unsuccessfull");
                    }

                }
                if(thurs.isSelected())
                {int thursd=5;
                    String a1=shift1.getSelectedItem().toString();

                    String a2=shiftid.getText();

                    String a3=schedule1.getSelectedItem().toString();

                    String a4=scheduleid.getText();

                    int a5=sstarttime.getHours();
                    int a6=sstarttime.getMinutes();
                    int a7=sstarttime.getSeconds();

                    int a8=sendtime.getHours();
                    int a9=sendtime.getMinutes();
                    int a10=sendtime.getSeconds();

                    int a11=overtime.getHours();
                    int a12=overtime.getMinutes();
                    int a13=overtime.getSeconds();

                    int a14=IOT.getHours();
                    int a15=IOT.getMinutes();
                    int a16=IOT.getSeconds();

                    int a17=LE.getHours();
                    int a18=LE.getMinutes();
                    int a19=LE.getSeconds();

                    int a20=EE.getHours();
                    int a21=EE.getMinutes();
                    int a22=EE.getSeconds();

                    int a23=EA.getHours();
                    int a24=EA.getMinutes();
                    int a25=EA.getSeconds();

                    int a26=EB.getHours();
                    int a27=EB.getMinutes();
                    int a28=EB.getSeconds();
                    int a29=lunchin.getHours();
        int a30=lunchin.getMinutes();
        int a31=lunchin.getSeconds();

        int a32=lunchout.getHours();
  int a33=lunchout.getMinutes();
        int a34=lunchout.getSeconds();
        int a35=startin.getHours();
        int a36=startin.getMinutes();
        int a37=startin.getSeconds();

        int a38=startout.getHours();
        int a39=startout.getMinutes();
        int a40=startout.getSeconds();
        
        int a41=endin.getHours();
        int a42=endin.getMinutes();
        int a43=endin.getSeconds();

        int a44=endout.getHours();
        int a45=endout.getMinutes();
        int a46=endout.getSeconds();
        try
                    {

                        String query = "INSERT INTO `num_run_days` VALUES('"+a4+"','"+a3+"','"+d1+" "+a5+":"+a6+":"+a7+"','"+d2+" "+a8+":"+a9+":"+a10+"','"+thursd+"','"+thursd+"','"+a2+"','"+a1+"','"+d2+" "+a11+":"+a12+":"+a13+"','"+d1+" "+a14+":"+a15+":"+a16+"','"+d1+" "+a17+":"+a18+":"+a19+"','"+d2+" "+a20+":"+a21+":"+a22+"','"+d1+" "+a23+":"+a24+":"+a25+"','"+d2+" "+a26+":"+a27+":"+a28+"','"+d1+" "+a29+":"+a30+":"+a31+"','"+d1+" "+a32+":"+a33+":"+a34+"','"+stat+"','"+a35+":"+a36+":"+a37+"','"+a38+":"+a39+":"+a40+"','"+a41+":"+a42+":"+a43+"','"+a44+":"+a45+":"+a46+"')";

                        Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

                        Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

                        PreparedStatement pst= con.prepareStatement(query);             
                        // Create statement
                        pst.executeUpdate();
                        reset3();
                        JOptionPane.showMessageDialog(null,"Command Successfull");
                        //                                    Execute Query
                        //pst.setString(1,str1);
                        //          pst.setString(2,p);
                        // Close the open connection
                    }
                    catch(Exception e)
                    {JOptionPane.showMessageDialog(null,"Command Unsuccessfull");
                    }
                }
                if(fri.isSelected())
                {int frid=6;
                    String a1=shift1.getSelectedItem().toString();

                    String a2=shiftid.getText();

                    String a3=schedule1.getSelectedItem().toString();

                    String a4=scheduleid.getText();

                    int a5=sstarttime.getHours();
                    int a6=sstarttime.getMinutes();
                    int a7=sstarttime.getSeconds();

                    int a8=sendtime.getHours();
                    int a9=sendtime.getMinutes();
                    int a10=sendtime.getSeconds();

                    int a11=overtime.getHours();
                    int a12=overtime.getMinutes();
                    int a13=overtime.getSeconds();

                    int a14=IOT.getHours();
                    int a15=IOT.getMinutes();
                    int a16=IOT.getSeconds();

                    int a17=LE.getHours();
                    int a18=LE.getMinutes();
                    int a19=LE.getSeconds();

                    int a20=EE.getHours();
                    int a21=EE.getMinutes();
                    int a22=EE.getSeconds();

                    int a23=EA.getHours();
                    int a24=EA.getMinutes();
                    int a25=EA.getSeconds();

                    int a26=EB.getHours();
                    int a27=EB.getMinutes();
                    int a28=EB.getSeconds();
                    int a29=lunchin.getHours();
        int a30=lunchin.getMinutes();
        int a31=lunchin.getSeconds();

        int a32=lunchout.getHours();
        int a33=lunchout.getMinutes();
        int a34=lunchout.getSeconds();
        int a35=startin.getHours();
        int a36=startin.getMinutes();
        int a37=startin.getSeconds();

        int a38=startout.getHours();
        int a39=startout.getMinutes();
        int a40=startout.getSeconds();
        
        int a41=endin.getHours();
        int a42=endin.getMinutes();
        int a43=endin.getSeconds();

        int a44=endout.getHours();
        int a45=endout.getMinutes();
        int a46=endout.getSeconds();
                    try
                    {

                        String query = "INSERT INTO `num_run_days` VALUES('"+a4+"','"+a3+"','"+d1+" "+a5+":"+a6+":"+a7+"','"+d2+" "+a8+":"+a9+":"+a10+"','"+frid+"','"+frid+"','"+a2+"','"+a1+"','"+d2+" "+a11+":"+a12+":"+a13+"','"+d1+" "+a14+":"+a15+":"+a16+"','"+d1+" "+a17+":"+a18+":"+a19+"','"+d2+" "+a20+":"+a21+":"+a22+"','"+d1+" "+a23+":"+a24+":"+a25+"','"+d2+" "+a26+":"+a27+":"+a28+"','"+d1+" "+a29+":"+a30+":"+a31+"','"+d1+" "+a32+":"+a33+":"+a34+"','"+stat+"','"+a35+":"+a36+":"+a37+"','"+a38+":"+a39+":"+a40+"','"+a41+":"+a42+":"+a43+"','"+a44+":"+a45+":"+a46+"')";             // Create query string to insert name into table

                        Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

                        Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

                        PreparedStatement pst= con.prepareStatement(query);                             // Create statement
                        pst.executeUpdate();
                        reset3();
                        JOptionPane.showMessageDialog(null,"Command Successfull");
                        //                                    Execute Query
                        //pst.setString(1,str1);
                        //          pst.setString(2,p);
                        // Close the open connection
                    }
                    catch(Exception e)
                    {JOptionPane.showMessageDialog(null,"Command Unsuccessfull");
                    }
                }
                if(sat.isSelected())
                {int saturd=7;
                    String a1=shift1.getSelectedItem().toString();

                    String a2=shiftid.getText();

                    String a3=schedule1.getSelectedItem().toString();

                    String a4=scheduleid.getText();

                    int a5=sstarttime.getHours();
                    int a6=sstarttime.getMinutes();
                    int a7=sstarttime.getSeconds();

                    int a8=sendtime.getHours();
                    int a9=sendtime.getMinutes();
                    int a10=sendtime.getSeconds();

                    int a11=overtime.getHours();
                    int a12=overtime.getMinutes();
                    int a13=overtime.getSeconds();

                    int a14=IOT.getHours();
                    int a15=IOT.getMinutes();
                    int a16=IOT.getSeconds();

                    int a17=LE.getHours();
                    int a18=LE.getMinutes();
                    int a19=LE.getSeconds();

                    int a20=EE.getHours();
                    int a21=EE.getMinutes();
                    int a22=EE.getSeconds();

                    int a23=EA.getHours();
                    int a24=EA.getMinutes();
                    int a25=EA.getSeconds();

                    int a26=EB.getHours();
                    int a27=EB.getMinutes();
                    int a28=EB.getSeconds();
                    int a29=lunchin.getHours();
        int a30=lunchin.getMinutes();
        int a31=lunchin.getSeconds();

        int a32=lunchout.getHours();
          int a33=lunchout.getMinutes();
        int a34=lunchout.getSeconds();
        int a35=startin.getHours();
        int a36=startin.getMinutes();
        int a37=startin.getSeconds();

        int a38=startout.getHours();
        int a39=startout.getMinutes();
        int a40=startout.getSeconds();
        
        int a41=endin.getHours();
        int a42=endin.getMinutes();
        int a43=endin.getSeconds();

        int a44=endout.getHours();
        int a45=endout.getMinutes();
        int a46=endout.getSeconds();
                    try
                    {

                        String query = "INSERT INTO `num_run_days` VALUES('"+a4+"','"+a3+"','"+d1+" "+a5+":"+a6+":"+a7+"','"+d2+" "+a8+":"+a9+":"+a10+"','"+saturd+"','"+saturd+"','"+a2+"','"+a1+"','"+d2+" "+a11+":"+a12+":"+a13+"','"+d1+" "+a14+":"+a15+":"+a16+"','"+d1+" "+a17+":"+a18+":"+a19+"','"+d2+" "+a20+":"+a21+":"+a22+"','"+d1+" "+a23+":"+a24+":"+a25+"','"+d2+" "+a26+":"+a27+":"+a28+"','"+d1+" "+a29+":"+a30+":"+a31+"','"+d1+" "+a32+":"+a33+":"+a34+"','"+stat+"','"+a35+":"+a36+":"+a37+"','"+a38+":"+a39+":"+a40+"','"+a41+":"+a42+":"+a43+"','"+a44+":"+a45+":"+a46+"')";             // Create query string to insert name into table

                        Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

                        Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

                        PreparedStatement pst= con.prepareStatement(query);                             // Create statement
                        pst.executeUpdate();
                        reset3();
                        JOptionPane.showMessageDialog(null,"Command Successfull");
                        //                                    Execute Query
                        //pst.setString(1,str1);
                        //          pst.setString(2,p);
                        // Close the open connection
                    }
                    catch(Exception e)
                    {JOptionPane.showMessageDialog(null,"Command Unsuccessfull");
                    }}
                    if(sun.isSelected())
                    {int sund=1;
                        String a1=shift1.getSelectedItem().toString();

                        String a2=shiftid.getText();

                        String a3=schedule1.getSelectedItem().toString();

                        String a4=scheduleid.getText();
                       
                        int a5=sstarttime.getHours();
                        int a6=sstarttime.getMinutes();
                        int a7=sstarttime.getSeconds();

                        int a8=sendtime.getHours();
                        int a9=sendtime.getMinutes();
                        int a10=sendtime.getSeconds();

                        int a11=overtime.getHours();
                        int a12=overtime.getMinutes();
                        int a13=overtime.getSeconds();

                        int a14=IOT.getHours();
                        int a15=IOT.getMinutes();
                        int a16=IOT.getSeconds();

                        int a17=LE.getHours();
                        int a18=LE.getMinutes();
                        int a19=LE.getSeconds();

                        int a20=EE.getHours();
                        int a21=EE.getMinutes();
                        int a22=EE.getSeconds();

                        int a23=EA.getHours();
                        int a24=EA.getMinutes();
                        int a25=EA.getSeconds();

                        int a26=EB.getHours();
                        int a27=EB.getMinutes();
                        int a28=EB.getSeconds();
                        int a29=lunchin.getHours();
        int a30=lunchin.getMinutes();
        int a31=lunchin.getSeconds();

        int a32=lunchout.getHours();
        int a33=lunchout.getMinutes();
        int a34=lunchout.getSeconds();
        int a35=startin.getHours();
        int a36=startin.getMinutes();
        int a37=startin.getSeconds();

        int a38=startout.getHours();
        int a39=startout.getMinutes();
        int a40=startout.getSeconds();
        
        int a41=endin.getHours();
        int a42=endin.getMinutes();
        int a43=endin.getSeconds();

        int a44=endout.getHours();
        int a45=endout.getMinutes();
        int a46=endout.getSeconds();
                        try
                        {

                            String query = "INSERT INTO `num_run_days` VALUES('"+a4+"','"+a3+"','"+d1+" "+a5+":"+a6+":"+a7+"','"+d2+" "+a8+":"+a9+":"+a10+"','"+sund+"','"+sund+"','"+a2+"','"+a1+"','"+d2+" "+a11+":"+a12+":"+a13+"','"+d1+" "+a14+":"+a15+":"+a16+"','"+d1+" "+a17+":"+a18+":"+a19+"','"+d2+" "+a20+":"+a21+":"+a22+"','"+d1+" "+a23+":"+a24+":"+a25+"','"+d2+" "+a26+":"+a27+":"+a28+"','"+d1+" "+a29+":"+a30+":"+a31+"','"+d1+" "+a32+":"+a33+":"+a34+"','"+stat+"','"+a35+":"+a36+":"+a37+"','"+a38+":"+a39+":"+a40+"','"+a41+":"+a42+":"+a43+"','"+a44+":"+a45+":"+a46+"')";             // Create query string to insert name into table

                            Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

                            Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

                            PreparedStatement pst= con.prepareStatement(query);                             // Create statement
                            pst.executeUpdate();
                            reset3();JOptionPane.showMessageDialog(null,"Command Successfull");
                            reset3();                        //                                    Execute Query
                            //pst.setString(1,str1);
                            //          pst.setString(2,p);
                            // Close the open connection
                        }
                        catch(Exception e)
                        {JOptionPane.showMessageDialog(null,"Command Unsuccessfull");
                        }}}
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        if(mon.isSelected())

        {int mond=2;
            String a1=shift1.getSelectedItem().toString();
            String a3=schedule1.getSelectedItem().toString();
            try
            { String query = "DELETE FROM `num_run_days` WHERE `Num_Run_Name`='"+a3+"' and `Sch_NAME`='"+a1+"' and `s_Days`='"+mond+"'";             // Create query string to insert name into table
                Class.forName("com.mysql.jdbc.Driver");                                                     // Load Driver class
                Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

                PreparedStatement pst= con.prepareStatement(query);                                       // Create statement
                pst.executeUpdate();
                reset3();
                JOptionPane.showMessageDialog(null,"Shift Deleted");
            }
            catch(Exception e)
            {JOptionPane.showMessageDialog(null,"Shift Deleted failed");

            }}
            if(tues.isSelected())
            {int tuesd=3;

                String a1=shift1.getSelectedItem().toString();
                String a3=schedule1.getSelectedItem().toString();
                try
                {

                    String query = "DELETE FROM `num_run_days` WHERE  Num_Run_Name='"+a3+"' and Sch_NAME='"+a1+"' and `s_Days`='"+tuesd+"'";
                    Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

                    Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

                    PreparedStatement pst= con.prepareStatement(query);                             // Create statement
                    pst.executeUpdate();
                    reset3();JOptionPane.showMessageDialog(null,"Shift Deleted");
                    //                                    Execute Query
                    //pst.setString(1,str1);
                    //          pst.setString(2,p);
                    // Close the open connection
                }
                catch(Exception e)
                {JOptionPane.showMessageDialog(null,"Shift Deleted failed");
                }
            }
            if(wed.isSelected())
            {int wednesd=4;

                String a1=shift1.getSelectedItem().toString();
                String a3=schedule1.getSelectedItem().toString();
                try
                {

                    String query = "DELETE FROM `num_run_days` WHERE Num_Run_Name='"+a3+"' and Sch_NAME='"+a1+"' and `s_Days`='"+wednesd+"'";
                    Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

                    Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

                    PreparedStatement pst= con.prepareStatement(query);                             // Create statement
                    pst.executeUpdate();
                    reset3();
                    JOptionPane.showMessageDialog(null,"Shift Deleted");
                    //                                    Execute Query
                    //pst.setString(1,str1);
                    //          pst.setString(2,p);
                    // Close the open connection
                }
                catch(Exception e)
                {JOptionPane.showMessageDialog(null,"Shift Deleted failed");
                }

            }
            if(thurs.isSelected())
            {int thursd=5;
                String a1=shift1.getSelectedItem().toString();
                String a3=schedule1.getSelectedItem().toString();
                try
                {

                    String query = "DELETE FROM `num_run_days` WHERE Num_Run_Name='"+a3+"' and Sch_NAME='"+a1+"' and  `s_Days`='"+thursd+"'";
                    Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

                    Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

                    PreparedStatement pst= con.prepareStatement(query);                             // Create statement
                    pst.executeUpdate();reset3();
                    JOptionPane.showMessageDialog(null,"Shift Deleted");
                    //                                    Execute Query
                    //pst.setString(1,str1);
                    //          pst.setString(2,p);
                    // Close the open connection
                }
                catch(Exception e)
                {JOptionPane.showMessageDialog(null,"Shift Deleted failed");
                }
            }
            if(fri.isSelected())
            {int frid=6;
                String a1=shift1.getSelectedItem().toString();
                String a3=schedule1.getSelectedItem().toString();
                try
                {

                    String query = "DELETE FROM `num_run_days` WHERE  Num_Run_Name='"+a3+"' and Sch_NAME='"+a1+"' and `s_Days`='"+frid+"'";
                    Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

                    Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

                    PreparedStatement pst= con.prepareStatement(query);                             // Create statement
                    pst.executeUpdate();
                    reset3();
                    JOptionPane.showMessageDialog(null,"Shift Deleted");
                    //                                    Execute Query
                    //pst.setString(1,str1);
                    //          pst.setString(2,p);
                    // Close the open connection
                }
                catch(Exception e)
                {JOptionPane.showMessageDialog(null,"Shift Deleted failed");
                }
            }
            if(sat.isSelected())
            {int saturd=7;
                String a1=shift1.getSelectedItem().toString();
                String a3=schedule1.getSelectedItem().toString();
                try
                {

                    String query = "DELETE FROM `num_run_days` WHERE Num_Run_Name='"+a3+"' and Sch_name='"+a1+"' and `s_Days`='"+saturd+"' ";
                    Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

                    Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

                    PreparedStatement pst= con.prepareStatement(query);                             // Create statement
                    pst.executeUpdate();reset3();
                   JOptionPane.showMessageDialog(null,"Shift Deleted");
                    //                                    Execute Query
                    //pst.setString(1,str1);
                    //          pst.setString(2,p);
                    // Close the open connection
                }
                catch(Exception e)
                {JOptionPane.showMessageDialog(null,"Shift Deleted failed");
                }}
                if(sun.isSelected())
                {int sund=1;
                    String a1=shift1.getSelectedItem().toString();
                    String a3=schedule1.getSelectedItem().toString();
                    try
                    {

                        String query ="DELETE FROM `num_run_days` WHERE Num_Run_Name='"+a3+"' and Sch_name='"+a1+"' and `s_Days`='"+sund+"'";
                        Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

                        Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

                        PreparedStatement pst= con.prepareStatement(query);                             // Create statement
                        pst.executeUpdate();
                        reset3();
                        JOptionPane.showMessageDialog(null,"Shift Deleted");
                        //                                    Execute Query
                        //pst.setString(1,str1);
                        //          pst.setString(2,p);
                        // Close the open connection
                        
                    }
                    catch(Exception e)
                    {JOptionPane.showMessageDialog(null,"Shift Deleted failed");}
                }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void nightsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nightsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nightsActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
this.dispose();     
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        int a1=checkin.getHours(); String named=name.getText();
        int a2=checkin.getMinutes();
        int a3=checkin.getSeconds();
        int a4=Integer.parseInt(idd.getText());
        int a5=checkout.getHours();
        int a6=checkout.getMinutes(); 
        int a7=checkout.getSeconds();
        // Default Password is empty string

        String l="hh:mm:ss";
        try
        {

            String query = "update `shift` set '"+named+"',`timein`='"+a1+":"+a2+":"+a3+"', `timeout`='"+a5+":"+a6+":"+a7+"' where `sch_ID`='"+a4+"'";           // Create query string to insert name into table

            Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

            Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

            PreparedStatement pst= con.prepareStatement(query);                             // Create statement
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"update successfull");
            reset3();
            //                                    Execute Query
            //pst.setString(1,str1);
            //          pst.setString(2,p);
            // Close the open connection
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null,"");
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int a1=Integer.parseInt(aid.getText());
        String a2=aname.getText();
       java.util.Date sdate=astartdate.getDate();
       java.sql.Date a3=new java.sql.Date(sdate.getTime());
       java.util.Date eddate=astartdate.getDate();
       java.sql.Date a4=new java.sql.Date(eddate.getTime());
        //int a4=Integer.parseInt(idd.getText());
        int a5=Integer.parseInt(acycle.getText());
        int a6=Integer.parseInt(aunit.getText());
        // Default Password is empty string

        String l="hh:mm:ss";
        try
        {

            String query = "update `num_run` set `Name`='"+a2+"',`Start_Date`='"+a3+"',`End_Date`='"+a4+"',`Cycle`='"+a5+"',`Unit`='"+a6+"' where `Num_RunID`='"+a1+"'";           // Create query string to insert name into table

            Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

            Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

            PreparedStatement pst= con.prepareStatement(query);                             // Create statement
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Updated successfully");
            reset3();
            //                                    Execute Query
            //pst.setString(1,str1);
            //          pst.setString(2,p);
            // Close the open connection
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null,"Update Failed");
        }       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if(nights.isSelected())
        {            d1="2017-01-01"; d2="2017-01-02";stat=1;} else {            d1="2017-01-01"; d2="2017-01-01";stat=0;}
        String b1=shift1.getSelectedItem().toString();

        String b2=shiftid.getText();

        String b3=schedule1.getSelectedItem().toString();

        String b4=scheduleid.getText();

        int b5=sstarttime.getHours();
        int b6=sstarttime.getMinutes();
        int b7=sstarttime.getSeconds();

        int b8=sendtime.getHours();
        int b9=sendtime.getMinutes();
        int b10=sendtime.getSeconds();

        int b11=overtime.getHours();
        int b12=overtime.getMinutes();
        int b13=overtime.getSeconds();

        int b14=IOT.getHours();
        int b15=IOT.getMinutes();
        int b16=IOT.getSeconds();

        int b17=LE.getHours();
        int b18=LE.getMinutes();
        int b19=LE.getSeconds();

        int b20=EE.getHours();
        int b21=EE.getMinutes();
        int b22=EE.getSeconds();

        int b23=EA.getHours();
        int b24=EA.getMinutes();
        int b25=EA.getSeconds();

        int b26=EB.getHours();
        int b27=EB.getMinutes();
        int b28=EB.getSeconds();
        int b29=lunchin.getHours();
        int b30=lunchin.getMinutes();
        int b31=lunchin.getSeconds();

        int b32=lunchout.getHours();
         int b33=lunchout.getMinutes();
        int b34=lunchout.getSeconds();
        int b35=startin.getHours();
        int b36=startin.getMinutes();
        int b37=startin.getSeconds();

        int b38=startout.getHours();
        int b39=startout.getMinutes();
        int b40=startout.getSeconds();
        
        int b41=endin.getHours();
        int b42=endin.getMinutes();
        int b43=endin.getSeconds();

        int b44=endout.getHours();
        int b45=endout.getMinutes();
        int b46=endout.getSeconds();
        if(b1.isEmpty() || b2.isEmpty() || b3.isEmpty() || b4.isEmpty() || b5 == 00 && b6 == 00 && b7 == 00 || b8 == 00 && b9 == 00 && b10 == 00 || b11 == 00 && b12 == 00 && b13 == 00 || b14 == 00 && b15 == 00 && b16 == 00 || b17 == 00 && b18 == 00 && b19 == 00 || b20 == 00 && b21 == 00 && b22 == 00 || b23 == 00 && b24 == 00 && b25 == 00 || b26 == 00 && b27 == 00 && b28 == 00 || b29 == 00 && b30 == 00 && b31 == 00 || b32 == 00 && b33 == 00 && b34 == 00)
        {JOptionPane.showMessageDialog(null,"Please Provide Complete Details");}else{
            if(mon.isSelected())

            {int mond=2;
                String a1=shift1.getSelectedItem().toString();

                String a2=shiftid.getText();

                String a3=schedule1.getSelectedItem().toString();

                String a4=scheduleid.getText();

                int a5=sstarttime.getHours();
                int a6=sstarttime.getMinutes();
                int a7=sstarttime.getSeconds();

                int a8=sendtime.getHours();
                int a9=sendtime.getMinutes();
                int a10=sendtime.getSeconds();

                int a11=overtime.getHours();
                int a12=overtime.getMinutes();
                int a13=overtime.getSeconds();

                int a14=IOT.getHours();
                int a15=IOT.getMinutes();
                int a16=IOT.getSeconds();

                int a17=LE.getHours();
                int a18=LE.getMinutes();
                int a19=LE.getSeconds();

                int a20=EE.getHours();
                int a21=EE.getMinutes();
                int a22=EE.getSeconds();

                int a23=EA.getHours();
                int a24=EA.getMinutes();
                int a25=EA.getSeconds();

                int a26=EB.getHours();
                int a27=EB.getMinutes();
                int a28=EB.getSeconds();
int a29=lunchin.getHours();
        int a30=lunchin.getMinutes();
        int a31=lunchin.getSeconds();

        int a32=lunchout.getHours();  int a33=lunchout.getMinutes();
        int a34=lunchout.getSeconds();
        int a35=startin.getHours();
        int a36=startin.getMinutes();
        int a37=startin.getSeconds();

        int a38=startout.getHours();
        int a39=startout.getMinutes();
        int a40=startout.getSeconds();
        
        int a41=endin.getHours();
        int a42=endin.getMinutes();
        int a43=endin.getSeconds();

        int a44=endout.getHours();
        int a45=endout.getMinutes();
        int a46=endout.getSeconds();
                try
                {//,`startin`='"+a35+":"+a36+":"+a37+"',`startout`='"+a38+":"+a39+":"+a40+"',`endin`='"+a41+":"+a42+":"+a43+"',`endout`='"+a44+":"+a45+":"+a46+"'
//,'"+a35+":"+a36+":"+a37+"','"+a38+":"+a39+":"+a40+"','"+a41+":"+a42+":"+a43+"','"+a44+":"+a45+":"+a46+"'
                    String query = "Update `num_run_days` set `Num_Run_name`='"+a3+"',`Start_Time`='"+d1+" "+a5+":"+a6+":"+a7+"',`End_Time`='"+d2+" "+a8+":"+a9+":"+a10+"',`e_Days`='"+mond+"',`Sch_ID`='"+a2+"',`Sch_name`='"+a1+"',`Over_Time`='"+d2+" "+a11+":"+a12+":"+a13+"',`In_OT_Exceed`='"+d1+" "+a14+":"+a15+":"+a16+"',`Late_Exceed`='"+d1+" "+a17+":"+a18+":"+a19+"',`Early_Exceed`='"+d2+" "+a20+":"+a21+":"+a22+"',`late_after`='"+d1+" "+a23+":"+a24+":"+a25+"',`early_before`='"+d2+" "+a26+":"+a27+":"+a28+"',`lunchin`='"+d1+" "+a29+":"+a30+":"+a31+"',`lunchout`='"+d1+" "+a32+":"+a33+":"+a34+"',`status`='"+stat+"',`startin`='"+a35+":"+a36+":"+a37+"',`startout`='"+a38+":"+a39+":"+a40+"',`endin`='"+a41+":"+a42+":"+a43+"',`endout`='"+a44+":"+a45+":"+a46+"' where Num_RunID='"+a4+"' and `s_Days`='"+mond+"'";             // Create query string to insert name into table

                    Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

                    Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

                    PreparedStatement pst= con.prepareStatement(query);                             // Create statement
                    pst.executeUpdate();JOptionPane.showMessageDialog(null,"Updated Successfully");
                    reset3();
                    //                                    Execute Query
                    //pst.setString(1,str1);
                    //          pst.setString(2,p);
                    // Close the open connection
                }
                catch(Exception e)
                {JOptionPane.showMessageDialog(null,"Monday Update failed!");

                }}
                if(tues.isSelected())
                {int tuesd=3;
                    String a1=shift1.getSelectedItem().toString();

                    String a2=shiftid.getText();

                    String a3=schedule1.getSelectedItem().toString();

                    String a4=scheduleid.getText();

                    int a5=sstarttime.getHours();
                    int a6=sstarttime.getMinutes();
                    int a7=sstarttime.getSeconds();

                    int a8=sendtime.getHours();
                    int a9=sendtime.getMinutes();
                    int a10=sendtime.getSeconds();

                    int a11=overtime.getHours();
                    int a12=overtime.getMinutes();
                    int a13=overtime.getSeconds();

                    int a14=IOT.getHours();
                    int a15=IOT.getMinutes();
                    int a16=IOT.getSeconds();

                    int a17=LE.getHours();
                    int a18=LE.getMinutes();
                    int a19=LE.getSeconds();

                    int a20=EE.getHours();
                    int a21=EE.getMinutes();
                    int a22=EE.getSeconds();

                    int a23=EA.getHours();
                    int a24=EA.getMinutes();
                    int a25=EA.getSeconds();

                    int a26=EB.getHours();
                    int a27=EB.getMinutes();
                    int a28=EB.getSeconds();
        int a29=lunchin.getHours();
        int a30=lunchin.getMinutes();
        int a31=lunchin.getSeconds();

        int a32=lunchout.getHours();  int a33=lunchout.getMinutes();
        int a34=lunchout.getSeconds();
        int a35=startin.getHours();
        int a36=startin.getMinutes();
        int a37=startin.getSeconds();

        int a38=startout.getHours();
        int a39=startout.getMinutes();
        int a40=startout.getSeconds();
        
        int a41=endin.getHours();
        int a42=endin.getMinutes();
        int a43=endin.getSeconds();

        int a44=endout.getHours();
        int a45=endout.getMinutes();
        int a46=endout.getSeconds();
                    try
                    {

String query = "Update `num_run_days` set `Num_Run_name`='"+a3+"',`Start_Time`='"+d1+" "+a5+":"+a6+":"+a7+"',`End_Time`='"+d2+" "+a8+":"+a9+":"+a10+"',`e_Days`='"+tuesd+"',`Sch_ID`='"+a2+"',`Sch_name`='"+a1+"',`Over_Time`='"+d2+" "+a11+":"+a12+":"+a13+"',`In_OT_Exceed`='"+d1+" "+a14+":"+a15+":"+a16+"',`Late_Exceed`='"+d1+" "+a17+":"+a18+":"+a19+"',`Early_Exceed`='"+d2+" "+a20+":"+a21+":"+a22+"',`late_after`='"+d1+" "+a23+":"+a24+":"+a25+"',`early_before`='"+d2+" "+a26+":"+a27+":"+a28+"' ,`lunchin`='"+d1+" "+a29+":"+a30+":"+a31+"',`lunchout`='"+d1+" "+a32+":"+a33+":"+a34+"',`status`='"+stat+"' ,`startin`='"+a35+":"+a36+":"+a37+"',`startout`='"+a38+":"+a39+":"+a40+"',`endin`='"+a41+":"+a42+":"+a43+"',`endout`='"+a44+":"+a45+":"+a46+"'   where Num_RunID='"+a4+"' and `s_Days`='"+tuesd+"'";

                        Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

                        Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

                        PreparedStatement pst= con.prepareStatement(query);                             // Create statement
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Command Successfull");
                        //                                    Execute Query
                        //pst.setString(1,str1);
                        //          pst.setString(2,p);
                        // Close the open connection
                    }
                    catch(Exception e)
                    {JOptionPane.showMessageDialog(null,"Command Unsuccessfull");
                    }
                }
                if(wed.isSelected())
                {int wednesd=4;
                    String a1=shift1.getSelectedItem().toString();

                    String a2=shiftid.getText();

                    String a3=schedule1.getSelectedItem().toString();

                    String a4=scheduleid.getText();

                    int a5=sstarttime.getHours();
                    int a6=sstarttime.getMinutes();
                    int a7=sstarttime.getSeconds();

                    int a8=sendtime.getHours();
                    int a9=sendtime.getMinutes();
                    int a10=sendtime.getSeconds();

                    int a11=overtime.getHours();
                    int a12=overtime.getMinutes();
                    int a13=overtime.getSeconds();

                    int a14=IOT.getHours();
                    int a15=IOT.getMinutes();
                    int a16=IOT.getSeconds();

                    int a17=LE.getHours();
                    int a18=LE.getMinutes();
                    int a19=LE.getSeconds();

                    int a20=EE.getHours();
                    int a21=EE.getMinutes();
                    int a22=EE.getSeconds();

                    int a23=EA.getHours();
                    int a24=EA.getMinutes();
                    int a25=EA.getSeconds();

                    int a26=EB.getHours();
                    int a27=EB.getMinutes();
                    int a28=EB.getSeconds();
                    int a29=lunchin.getHours();
        int a30=lunchin.getMinutes();
        int a31=lunchin.getSeconds();

        int a32=lunchout.getHours();  int a33=lunchout.getMinutes();
        int a34=lunchout.getSeconds();
        int a35=startin.getHours();
        int a36=startin.getMinutes();
        int a37=startin.getSeconds();

        int a38=startout.getHours();
        int a39=startout.getMinutes();
        int a40=startout.getSeconds();
        
        int a41=endin.getHours();
        int a42=endin.getMinutes();
        int a43=endin.getSeconds();

        int a44=endout.getHours();
        int a45=endout.getMinutes();
        int a46=endout.getSeconds();
                    try
                    {

                        String query = "Update `num_run_days` set `Num_Run_name`='"+a3+"',`Start_Time`='"+d1+" "+a5+":"+a6+":"+a7+"',`End_Time`='"+d2+" "+a8+":"+a9+":"+a10+"',`e_Days`='"+wednesd+"',`Sch_ID`='"+a2+"',`Sch_name`='"+a1+"',`Over_Time`='"+d2+" "+a11+":"+a12+":"+a13+"',`In_OT_Exceed`='"+d1+" "+a14+":"+a15+":"+a16+"',`Late_Exceed`='"+d1+" "+a17+":"+a18+":"+a19+"',`Early_Exceed`='"+d2+" "+a20+":"+a21+":"+a22+"',`late_after`='"+d1+" "+a23+":"+a24+":"+a25+"',`early_before`='"+d2+" "+a26+":"+a27+":"+a28+"' ,`lunchin`='"+d1+" "+a29+":"+a30+":"+a31+"',`lunchout`='"+d1+" "+a32+":"+a33+":"+a34+"',`status`='"+stat+"' ,`startin`='"+a35+":"+a36+":"+a37+"',`startout`='"+a38+":"+a39+":"+a40+"',`endin`='"+a41+":"+a42+":"+a43+"',`endout`='"+a44+":"+a45+":"+a46+"'   where Num_RunID='"+a4+"' and `s_Days`='"+wednesd+"'";

                        Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

                        Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

                        PreparedStatement pst= con.prepareStatement(query);                             // Create statement
                        pst.executeUpdate();JOptionPane.showMessageDialog(null,"Command Successfull");
                        //                                    Execute Query
                        //pst.setString(1,str1);
                        //          pst.setString(2,p);
                        // Close the open connection
                    }
                    catch(Exception e)
                    {JOptionPane.showMessageDialog(null,"Command Unsuccessfull");
                    }

                }
                if(thurs.isSelected())
                {int thursd=5;
                    String a1=shift1.getSelectedItem().toString();

                    String a2=shiftid.getText();

                    String a3=schedule1.getSelectedItem().toString();

                    String a4=scheduleid.getText();

                    int a5=sstarttime.getHours();
                    int a6=sstarttime.getMinutes();
                    int a7=sstarttime.getSeconds();

                    int a8=sendtime.getHours();
                    int a9=sendtime.getMinutes();
                    int a10=sendtime.getSeconds();

                    int a11=overtime.getHours();
                    int a12=overtime.getMinutes();
                    int a13=overtime.getSeconds();

                    int a14=IOT.getHours();
                    int a15=IOT.getMinutes();
                    int a16=IOT.getSeconds();

                    int a17=LE.getHours();
                    int a18=LE.getMinutes();
                    int a19=LE.getSeconds();

                    int a20=EE.getHours();
                    int a21=EE.getMinutes();
                    int a22=EE.getSeconds();

                    int a23=EA.getHours();
                    int a24=EA.getMinutes();
                    int a25=EA.getSeconds();

                    int a26=EB.getHours();
                    int a27=EB.getMinutes();
                    int a28=EB.getSeconds();
                    int a29=lunchin.getHours();
        int a30=lunchin.getMinutes();
        int a31=lunchin.getSeconds();

        int a32=lunchout.getHours();  int a33=lunchout.getMinutes();
        int a34=lunchout.getSeconds();
        int a35=startin.getHours();
        int a36=startin.getMinutes();
        int a37=startin.getSeconds();

        int a38=startout.getHours();
        int a39=startout.getMinutes();
        int a40=startout.getSeconds();
        
        int a41=endin.getHours();
        int a42=endin.getMinutes();
        int a43=endin.getSeconds();

        int a44=endout.getHours();
        int a45=endout.getMinutes();
        int a46=endout.getSeconds();
                    try
                    {

                        String query = "Update `num_run_days` set `Num_Run_name`='"+a3+"',`Start_Time`='"+d1+" "+a5+":"+a6+":"+a7+"',`End_Time`='"+d2+" "+a8+":"+a9+":"+a10+"',`e_Days`='"+thursd+"',`Sch_ID`='"+a2+"',`Sch_name`='"+a1+"',`Over_Time`='"+d2+" "+a11+":"+a12+":"+a13+"',`In_OT_Exceed`='"+d1+" "+a14+":"+a15+":"+a16+"',`Late_Exceed`='"+d1+" "+a17+":"+a18+":"+a19+"',`Early_Exceed`='"+d2+" "+a20+":"+a21+":"+a22+"',`late_after`='"+d1+" "+a23+":"+a24+":"+a25+"',`early_before`='"+d2+" "+a26+":"+a27+":"+a28+"',`lunchin`='"+d1+" "+a29+":"+a30+":"+a31+"',`lunchout`='"+d1+" "+a32+":"+a33+":"+a34+"',`status`='"+stat+"',`startin`='"+a35+":"+a36+":"+a37+"',`startout`='"+a38+":"+a39+":"+a40+"',`endin`='"+a41+":"+a42+":"+a43+"',`endout`='"+a44+":"+a45+":"+a46+"'  where Num_RunID='"+a4+"' and `s_Days`='"+thursd+"'";

                        Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

                        Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

                        PreparedStatement pst= con.prepareStatement(query);                             // Create statement
                        pst.executeUpdate();JOptionPane.showMessageDialog(null,"Command Successfull");
                        //                                    Execute Query
                        //pst.setString(1,str1);
                        //          pst.setString(2,p);
                        // Close the open connection
                    }
                    catch(Exception e)
                    {JOptionPane.showMessageDialog(null,"Command Unsuccessfull");
                    }
                }
                if(fri.isSelected())
                {int frid=6;
                    String a1=shift1.getSelectedItem().toString();

                    String a2=shiftid.getText();

                    String a3=schedule1.getSelectedItem().toString();

                    String a4=scheduleid.getText();

                    int a5=sstarttime.getHours();
                    int a6=sstarttime.getMinutes();
                    int a7=sstarttime.getSeconds();

                    int a8=sendtime.getHours();
                    int a9=sendtime.getMinutes();
                    int a10=sendtime.getSeconds();

                    int a11=overtime.getHours();
                    int a12=overtime.getMinutes();
                    int a13=overtime.getSeconds();

                    int a14=IOT.getHours();
                    int a15=IOT.getMinutes();
                    int a16=IOT.getSeconds();

                    int a17=LE.getHours();
                    int a18=LE.getMinutes();
                    int a19=LE.getSeconds();

                    int a20=EE.getHours();
                    int a21=EE.getMinutes();
                    int a22=EE.getSeconds();

                    int a23=EA.getHours();
                    int a24=EA.getMinutes();
                    int a25=EA.getSeconds();

                    int a26=EB.getHours();
                    int a27=EB.getMinutes();
                    int a28=EB.getSeconds();
                    int a29=lunchin.getHours();
        int a30=lunchin.getMinutes();
        int a31=lunchin.getSeconds();

        int a32=lunchout.getHours();  int a33=lunchout.getMinutes();
        int a34=lunchout.getSeconds();
        int a35=startin.getHours();
        int a36=startin.getMinutes();
        int a37=startin.getSeconds();

        int a38=startout.getHours();
        int a39=startout.getMinutes();
        int a40=startout.getSeconds();
        
        int a41=endin.getHours();
        int a42=endin.getMinutes();
        int a43=endin.getSeconds();

        int a44=endout.getHours();
        int a45=endout.getMinutes();
        int a46=endout.getSeconds();
                    try
                    {

                        String query = "Update `num_run_days` set `Num_Run_name`='"+a3+"',`Start_Time`='"+d1+" "+a5+":"+a6+":"+a7+"',`End_Time`='"+d2+" "+a8+":"+a9+":"+a10+"',`e_Days`='"+frid+"',`Sch_ID`='"+a2+"',`Sch_name`='"+a1+"',`Over_Time`='"+d2+" "+a11+":"+a12+":"+a13+"',`In_OT_Exceed`='"+d1+" "+a14+":"+a15+":"+a16+"',`Late_Exceed`='"+d1+" "+a17+":"+a18+":"+a19+"',`Early_Exceed`='"+d2+" "+a20+":"+a21+":"+a22+"',`late_after`='"+d1+" "+a23+":"+a24+":"+a25+"',`early_before`='"+d2+" "+a26+":"+a27+":"+a28+"',`lunchin`='"+d1+" "+a29+":"+a30+":"+a31+"',`lunchout`='"+d1+" "+a32+":"+a33+":"+a34+"',`status`='"+stat+"',`startin`='"+a35+":"+a36+":"+a37+"',`startout`='"+a38+":"+a39+":"+a40+"',`endin`='"+a41+":"+a42+":"+a43+"',`endout`='"+a44+":"+a45+":"+a46+"'   where Num_RunID='"+a4+"' and `s_Days`='"+frid+"'";

                        Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

                        Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

                        PreparedStatement pst= con.prepareStatement(query);                             // Create statement
                        pst.executeUpdate();JOptionPane.showMessageDialog(null,"Command Successfull");
                        //                                    Execute Query
                        //pst.setString(1,str1);
                        //          pst.setString(2,p);
                        // Close the open connection
                    }
                    catch(Exception e)
                    {JOptionPane.showMessageDialog(null,"Command Unsuccessfull");
                    }
                }
                if(sat.isSelected())
                {int saturd=7;
                    String a1=shift1.getSelectedItem().toString();

                    String a2=shiftid.getText();

                    String a3=schedule1.getSelectedItem().toString();

                    String a4=scheduleid.getText();

                    int a5=sstarttime.getHours();
                    int a6=sstarttime.getMinutes();
                    int a7=sstarttime.getSeconds();

                    int a8=sendtime.getHours();
                    int a9=sendtime.getMinutes();
                    int a10=sendtime.getSeconds();

                    int a11=overtime.getHours();
                    int a12=overtime.getMinutes();
                    int a13=overtime.getSeconds();

                    int a14=IOT.getHours();
                    int a15=IOT.getMinutes();
                    int a16=IOT.getSeconds();

                    int a17=LE.getHours();
                    int a18=LE.getMinutes();
                    int a19=LE.getSeconds();

                    int a20=EE.getHours();
                    int a21=EE.getMinutes();
                    int a22=EE.getSeconds();

                    int a23=EA.getHours();
                    int a24=EA.getMinutes();
                    int a25=EA.getSeconds();

                    int a26=EB.getHours();
                    int a27=EB.getMinutes();
                    int a28=EB.getSeconds();
                    int a29=lunchin.getHours();
        int a30=lunchin.getMinutes();
        int a31=lunchin.getSeconds();

        int a32=lunchout.getHours();  int a33=lunchout.getMinutes();
        int a34=lunchout.getSeconds();
        int a35=startin.getHours();
        int a36=startin.getMinutes();
        int a37=startin.getSeconds();

        int a38=startout.getHours();
        int a39=startout.getMinutes();
        int a40=startout.getSeconds();
        
        int a41=endin.getHours();
        int a42=endin.getMinutes();
        int a43=endin.getSeconds();

        int a44=endout.getHours();
        int a45=endout.getMinutes();
        int a46=endout.getSeconds();
                    try
                    {

                        String query = "Update `num_run_days` set `Num_Run_name`='"+a3+"',`Start_Time`='"+d1+" "+a5+":"+a6+":"+a7+"',`End_Time`='"+d2+" "+a8+":"+a9+":"+a10+"',`e_Days`='"+saturd+"',`Sch_ID`='"+a2+"',`Sch_name`='"+a1+"',`Over_Time`='"+d2+" "+a11+":"+a12+":"+a13+"',`In_OT_Exceed`='"+d1+" "+a14+":"+a15+":"+a16+"',`Late_Exceed`='"+d1+" "+a17+":"+a18+":"+a19+"',`Early_Exceed`='"+d2+" "+a20+":"+a21+":"+a22+"',`late_after`='"+d1+" "+a23+":"+a24+":"+a25+"',`early_before`='"+d2+" "+a26+":"+a27+":"+a28+"' ,`lunchin`='"+d1+" "+a29+":"+a30+":"+a31+"',`lunchout`='"+d1+" "+a32+":"+a33+":"+a34+"',`status`='"+stat+"',`startin`='"+a35+":"+a36+":"+a37+"',`startout`='"+a38+":"+a39+":"+a40+"',`endin`='"+a41+":"+a42+":"+a43+"',`endout`='"+a44+":"+a45+":"+a46+"'   where Num_RunID='"+a4+"' and `s_Days`='"+saturd+"'";

                        Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

                        Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

                        PreparedStatement pst= con.prepareStatement(query);                             // Create statement
                        pst.executeUpdate();JOptionPane.showMessageDialog(null,"Command Successfull");
                        //                                    Execute Query
                        //pst.setString(1,str1);
                        //          pst.setString(2,p);
                        // Close the open connection
                    }
                    catch(Exception e)
                    {JOptionPane.showMessageDialog(null,e);
                    }}
                    if(sun.isSelected())
                    {int sund=1;
                        String a1=shift1.getSelectedItem().toString();

                        String a2=shiftid.getText();

                        String a3=schedule1.getSelectedItem().toString();

                        String a4=scheduleid.getText();
                       
                        int a5=sstarttime.getHours();
                        int a6=sstarttime.getMinutes();
                        int a7=sstarttime.getSeconds();

                        int a8=sendtime.getHours();
                        int a9=sendtime.getMinutes();
                        int a10=sendtime.getSeconds();

                        int a11=overtime.getHours();
                        int a12=overtime.getMinutes();
                        int a13=overtime.getSeconds();

                        int a14=IOT.getHours();
                        int a15=IOT.getMinutes();
                        int a16=IOT.getSeconds();

                        int a17=LE.getHours();
                        int a18=LE.getMinutes();
                        int a19=LE.getSeconds();

                        int a20=EE.getHours();
                        int a21=EE.getMinutes();
                        int a22=EE.getSeconds();

                        int a23=EA.getHours();
                        int a24=EA.getMinutes();
                        int a25=EA.getSeconds();

                        int a26=EB.getHours();
                        int a27=EB.getMinutes();
                        int a28=EB.getSeconds();
                    int a29=lunchin.getHours();
        int a30=lunchin.getMinutes();
        int a31=lunchin.getSeconds();

        int a32=lunchout.getHours();  int a33=lunchout.getMinutes();
        int a34=lunchout.getSeconds();
        int a35=startin.getHours();
        int a36=startin.getMinutes();
        int a37=startin.getSeconds();

        int a38=startout.getHours();
        int a39=startout.getMinutes();
        int a40=startout.getSeconds();
        
        int a41=endin.getHours();
        int a42=endin.getMinutes();
        int a43=endin.getSeconds();

        int a44=endout.getHours();
        int a45=endout.getMinutes();
        int a46=endout.getSeconds();
                        try
                        {

                            String query = "Update `num_run_days` set `Num_Run_name`='"+a3+"',`Start_Time`='"+d1+" "+a5+":"+a6+":"+a7+"',`End_Time`='"+d2+" "+a8+":"+a9+":"+a10+"',`e_Days`='"+sund+"',`Sch_ID`='"+a2+"',`Sch_name`='"+a1+"',`Over_Time`='"+d2+" "+a11+":"+a12+":"+a13+"',`In_OT_Exceed`='"+d1+" "+a14+":"+a15+":"+a16+"',`Late_Exceed`='"+d1+" "+a17+":"+a18+":"+a19+"',`Early_Exceed`='"+d2+" "+a20+":"+a21+":"+a22+"',`late_after`='"+d1+" "+a23+":"+a24+":"+a25+"',`early_before`='"+d2+" "+a26+":"+a27+":"+a28+"',`lunchin`='"+d1+" "+a29+":"+a30+":"+a31+"',`lunchout`='"+d1+" "+a32+":"+a33+":"+a34+"',`status`='"+stat+"',`startin`='"+a35+":"+a36+":"+a37+"',`startout`='"+a38+":"+a39+":"+a40+"',`endin`='"+a41+":"+a42+":"+a43+"',`endout`='"+a44+":"+a45+":"+a46+"'    where Num_RunID='"+a4+"' and `s_Days`='"+sund+"'";

                            Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

                            Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

                            PreparedStatement pst= con.prepareStatement(query);                             // Create statement
                            pst.executeUpdate();
                            reset3();JOptionPane.showMessageDialog(null,"Command Successfull");
                            reset();                        //                                    Execute Query
                            //pst.setString(1,str1);
                            //          pst.setString(2,p);
                            // Close the open connection
                        }
                        catch(Exception e)
                        {JOptionPane.showMessageDialog(null,"Command Unsuccessfull");
                        }}}
        //UPDATE `num_run_days` SET `Num_Run_name`='"+a1+"',`Start_Time`='"+d1+" "+a5+":"+a6+":"+a7+"',`End_Time`='"+d2+" "+a8+":"+a9+":"+a10+"'
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void table9211MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table9211MouseClicked
               DefaultTableModel model = (DefaultTableModel)table9211.getModel();

        // get the selected row index
        int selectedRowIndex = table9211.getSelectedRow();

        // set the selected row data into jtextfields
        aid.setText(model.getValueAt(selectedRowIndex, 0).toString());
        aname.setText(model.getValueAt(selectedRowIndex, 1).toString());
        
        astartdate.setDate((Date) model.getValueAt(selectedRowIndex, 2));
        aenddate.setDate((Date) model.getValueAt(selectedRowIndex, 3));
//Num_RunID as 'Schedule ID', Num_Run_name as 'Schedule Name', `Start_Time`, `End_Time` ,`Over_Time` , `In_OT_Exceed`, `Late_Exceed`, `Early_Exceed`, `late_after`, `early_before`, `s_Days`  ,`Sch_ID` ,`Sch_name` 
    }//GEN-LAST:event_table9211MouseClicked

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        try{
            String dep=department2.getSelectedItem().toString();
            // table123.getTableHeader().setFont( new Font( "Tahoma" , Font.BOLD, 14 ));

            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,id,pass);
            if(dep == "All"){PreparedStatement pst2=con.prepareStatement("SELECT  `ID`, `Name`, `Department` FROM `emp_list`");
                ResultSet rst2=pst2.executeQuery();

                selectedEmployee.setModel (DbUtils.resultSetToTableModel(rst2)); }
            else{String query="SELECT  `ID`, `Name`, `Department` from emp_list where Department='"+dep+"'";
                PreparedStatement pst=con.prepareStatement(query);
                ResultSet rst1=pst.executeQuery();selectedEmployee.setModel (DbUtils.resultSetToTableModel(rst1));}}catch(Exception E){}
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void department2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_department2ActionPerformed
        reset4();
        //finally{try {pst.close();} catch (SQLException ex) {Logger.getLogger(shift.class.getName()).log(Level.SEVERE, null, ex);}}
    }//GEN-LAST:event_department2ActionPerformed

    private void sunWeekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sunWeekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sunWeekActionPerformed

    private void satWeekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_satWeekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_satWeekActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
     TableModel model1 = table2.getModel();

        int[] indexs = table2.getSelectedRows();

        Object[] row = new Object[3];

        DefaultTableModel model2 = (DefaultTableModel) selectedEmployee.getModel();

        for(int i = 0; i < indexs.length; i++)
        {
            row[0] = model1.getValueAt(indexs[i], 0);

            row[1] = model1.getValueAt(indexs[i], 1);

            row[2] = model1.getValueAt(indexs[i], 2);

       //     row[3] = model1.getValueAt(indexs[i], 3);

            model2.addRow(row);
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void selectedEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectedEmployeeMouseClicked
       DefaultTableModel model2 = (DefaultTableModel) selectedEmployee.getModel();
     try{ int a=  selectedEmployee.getSelectedRow();
    model2.removeRow(a);
     
     }catch(Exception e){JOptionPane.showMessageDialog(null,"Please Select Row");}
    }//GEN-LAST:event_selectedEmployeeMouseClicked

    private void empidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empidActionPerformed
        String s12=empid.getSelectedItem().toString();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst=conn.prepareStatement("SELECT Name FROM `emp_list` where ID='"+s12+"'");
            ResultSet rst1=pst.executeQuery();

            while(rst1.next()){
                empname.setSelectedItem(rst1.getString("Name"));}
            reset1();
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null,"");
        }
    }//GEN-LAST:event_empidActionPerformed

    private void empnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empnameActionPerformed
        String s12=empname.getSelectedItem().toString();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst=conn.prepareStatement("SELECT ID FROM `emp_list` where Name='"+s12+"'");
            ResultSet rst1=pst.executeQuery();

            while(rst1.next()){
                empid.setSelectedItem(rst1.getString("ID"));}
            reset();
        }
        catch(Exception ex){JOptionPane.showMessageDialog(null,"");
        }
    }//GEN-LAST:event_empnameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private lu.tudor.santec.jtimechooser.JTimeChooser EA;
    private lu.tudor.santec.jtimechooser.JTimeChooser EB;
    private lu.tudor.santec.jtimechooser.JTimeChooser EE;
    private lu.tudor.santec.jtimechooser.JTimeChooser IOT;
    private lu.tudor.santec.jtimechooser.JTimeChooser LE;
    private javax.swing.JTextField acycle;
    private com.toedter.calendar.JDateChooser aenddate;
    private javax.swing.JTextField aid;
    private javax.swing.JTextField aname;
    private com.toedter.calendar.JDateChooser astartdate;
    private javax.swing.JTextField aunit;
    private lu.tudor.santec.jtimechooser.JTimeChooser checkin;
    private lu.tudor.santec.jtimechooser.JTimeChooser checkout;
    private javax.swing.JCheckBox dayRotate;
    private javax.swing.JComboBox<String> department2;
    private javax.swing.JCheckBox earlyRotate;
    private javax.swing.JComboBox<String> empid;
    private javax.swing.JComboBox<String> empname;
    private com.toedter.calendar.JDateChooser enddate;
    private lu.tudor.santec.jtimechooser.JTimeChooser endin;
    private lu.tudor.santec.jtimechooser.JTimeChooser endout;
    private javax.swing.JLabel eror;
    private javax.swing.JLabel eror2;
    private javax.swing.JLabel eror5;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JCheckBox fri;
    private javax.swing.JTextField idd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    protected javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    protected javax.swing.JTabbedPane jTabbedPane1;
    private lu.tudor.santec.jtimechooser.JTimeChooser lunchin;
    private lu.tudor.santec.jtimechooser.JTimeChooser lunchout;
    private javax.swing.JCheckBox mon;
    private javax.swing.JTextField name;
    private javax.swing.JCheckBox nights;
    private javax.swing.JCheckBox otRotate;
    private lu.tudor.santec.jtimechooser.JTimeChooser overtime;
    private javax.swing.JTextArea progressing;
    private javax.swing.JCheckBox sat;
    private javax.swing.JCheckBox satWeek;
    private javax.swing.JComboBox<String> schedule1;
    private javax.swing.JLabel scheduleid;
    private javax.swing.JTable selectedEmployee;
    private lu.tudor.santec.jtimechooser.JTimeChooser sendtime;
    private javax.swing.JComboBox<String> shift1;
    private javax.swing.JTable shifted;
    private javax.swing.JLabel shiftid;
    private javax.swing.JComboBox<String> shiftid2;
    private javax.swing.JComboBox<String> shiftname;
    private lu.tudor.santec.jtimechooser.JTimeChooser sstarttime;
    private com.toedter.calendar.JDateChooser startdate;
    private lu.tudor.santec.jtimechooser.JTimeChooser startin;
    private lu.tudor.santec.jtimechooser.JTimeChooser startout;
    private javax.swing.JCheckBox sun;
    private javax.swing.JCheckBox sunWeek;
    public static javax.swing.JTable table;
    public javax.swing.JTable table2;
    public javax.swing.JTable table3;
    public static javax.swing.JTable table5;
    private javax.swing.JTable table9211;
    private javax.swing.JCheckBox thurs;
    private javax.swing.JCheckBox tues;
    private javax.swing.JCheckBox wed;
    // End of variables declaration//GEN-END:variables
}

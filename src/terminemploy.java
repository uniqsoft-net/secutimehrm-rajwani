import java.awt.Font;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

import newpackage.*;

public class terminemploy extends javax.swing.JInternalFrame {
    public ImageIcon format = null;PreparedStatement pst=null;
    String filename = "C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources_7jan\\src\\empdefault.png";
    byte[] person_image = null;FileInputStream fix=null;File image=null;
 dbclass dbd=new dbclass();
          String url=   dbd.server();
      String id=dbd.serverid();
      String pass=dbd.serverpass();
 CreateConnection createConnection = new CreateConnection();
  public ImageIcon ResizeImage(String ImagePath, byte[] pic)
    {
        ImageIcon MyImage = null;
        if(ImagePath != null)
        {
           MyImage = new ImageIcon(ImagePath);
        }else
        {
            MyImage = new ImageIcon(pic);
        }
        Image imgg = MyImage.getImage();
        Image newImg = imgg.getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imagee = new ImageIcon(newImg);
        return imagee;
    }
    
    public void reset(){
    try{ 
        String dep=department2.getSelectedItem().toString();
        // table123.getTableHeader().setFont( new Font( "Tahoma" , Font.BOLD, 14 ));

        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
if(dep == "All"){PreparedStatement pst2=con.prepareStatement("SELECT  `ID`, `Name`, `Department`,designation as 'Designation',bank as 'Joining', `Contact`, `Salary`, `Medical`, `HouseRent`, `Convence`, `Dearness`, `Late`, `Early`,`Late_Exceed` as 'Late Hour', `Early_Exceed` as 'Early Hour', `OT`, `Tax`,NIC,Address,status FROM `termin_emp`");
            ResultSet rst2=pst2.executeQuery();
            
        table123.setModel (DbUtils.resultSetToTableModel(rst2)); }
else{String query="SELECT  `ID`, `Name`, `Department`,designation as 'Designation',bank as 'Joining', `Contact`, `Salary`, `Medical`, `HouseRent`, `Convence`, `Dearness`, `Late`, `Early`,`Late_Exceed` as 'Late Hour', `Early_Exceed` as 'Early Hour', `OT`, `Tax`,NIC,Address,status from termin_emp where Department='"+dep+"'";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rst1=pst.executeQuery();table123.setModel (DbUtils.resultSetToTableModel(rst1));}}catch(Exception E){}}

    
  public terminemploy() {
        initComponents();
         
      
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst=conn.prepareStatement("SELECT MAX(ID) FROM `emp_list`");
            ResultSet rst1=pst.executeQuery();
            if(rst1.next()){
           String a=rst1.getString("MAX(ID)");
              int b=Integer.parseInt(a)+1;
           idd.setText(Integer.toString(b));
            }
                    }
        catch(Exception ex){
        
   
       }
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst=conn.prepareStatement("SELECT Department_Name FROM `department_list`");
           
            ResultSet rst1=pst.executeQuery();
            
           while(rst1.next()){
    department2.addItem(rst1.getString("Department_Name"));
           }
        }catch(Exception ex){
        
   
       }//finally{try {pst.close();} catch (SQLException ex) {Logger.getLogger(shift.class.getName()).log(Level.SEVERE, null, ex);}}
        
        
     try{ String dep=department2.getSelectedItem().toString();
         table123.getTableHeader().setFont( new Font( "Time New Roman" , Font.BOLD, 14 ));

        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
        String query="select `ID`, `Name`, `Department`,designation as 'Designation',bank as 'Bank Account', `Contact`, `Salary`, `Medical`, `HouseRent`, `Convence`, `Dearness`, `Late`, `Early`,`Late_Exceed` as 'Late Hour', `Early_Exceed` as 'Early Hour', `OT`, `Tax`,NIC,Address,status from termin_emp where Department='"+dep+"'";

if(dep == "All"){
             PreparedStatement pst2=con.prepareStatement("SELECT `ID`, `Name`, `Department`,designation as 'Designation',bank as 'Joining', `Contact`, `Salary`, `Medical`, `HouseRent`, `Convence`, `Dearness`, `Late`, `Early`,`Late_Exceed` as 'Late Hour', `Early_Exceed` as 'Early Hour', `OT`, `Tax`,NIC,Address,status  FROM `termin_emp`");
            ResultSet rst2=pst2.executeQuery();
        table123.setModel (DbUtils.resultSetToTableModel(rst2)); }
else{
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rst1=pst.executeQuery(); 
        table123.setModel (DbUtils.resultSetToTableModel(rst1)); 
}
     }   
     catch(Exception E){}
      
     
     try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            pst=conn.prepareStatement("SELECT Department_Name FROM department_list");
           ResultSet rst1=pst.executeQuery();
           
           while(rst1.next()){
               depp.addItem(rst1.getString("Department_Name"));
           }     }
        catch(Exception ex){
        JOptionPane.showMessageDialog(null, "Error combo"+ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        acc = new javax.swing.JTextField();
        namm = new javax.swing.JTextField();
        contt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        sall = new javax.swing.JTextField();
        depp = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        all1 = new javax.swing.JTextField();
        all2 = new javax.swing.JTextField();
        all3 = new javax.swing.JTextField();
        all6 = new javax.swing.JTextField();
        earlyy = new javax.swing.JTextField();
        all5 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        all7 = new javax.swing.JTextField();
        lat1 = new javax.swing.JTextField();
        Eror = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        LEE = new javax.swing.JTextField();
        EEE = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        idd = new javax.swing.JTextField();
        desig = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table123 = new javax.swing.JTable();
        ma = new javax.swing.JCheckBox();
        ha = new javax.swing.JCheckBox();
        ca = new javax.swing.JCheckBox();
        da = new javax.swing.JCheckBox();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        NIC = new javax.swing.JTextField();
        Address = new javax.swing.JTextField();
        img = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        department2 = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Employee Management");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/mainlogo.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete-ic.png"))); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update-ic.png"))); // NOI18N
        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Date of Joining");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, -1, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Employee Name:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 100, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Department:");
        jLabel3.setToolTipText("");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Contact: ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 20));

        acc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        acc.setText("0");
        acc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        acc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accActionPerformed(evt);
            }
        });
        jPanel2.add(acc, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 160, 24));

        namm.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        namm.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        namm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nammActionPerformed(evt);
            }
        });
        jPanel2.add(namm, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 156, 24));

        contt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        contt.setText("0");
        contt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        jPanel2.add(contt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 156, 24));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Basic Salary");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 20));

        sall.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sall.setText("0");
        sall.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        sall.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sallMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sallMousePressed(evt);
            }
        });
        sall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sallActionPerformed(evt);
            }
        });
        sall.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sallKeyPressed(evt);
            }
        });
        jPanel2.add(sall, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 156, 24));

        depp.setEditable(true);
        depp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        depp.setAutoscrolls(true);
        depp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        depp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deppActionPerformed(evt);
            }
        });
        jPanel2.add(depp, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 156, 24));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Medical Allowance");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Convence Allowance");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("House Rent Allowance");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("OT Allowance Per Hour");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Early Per Day");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, -1, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Employee Status");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, -1, 20));

        all1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        all1.setText("0");
        all1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        all1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                all1MouseExited(evt);
            }
        });
        jPanel2.add(all1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 156, 24));

        all2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        all2.setText("0");
        all2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        all2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                all2MouseExited(evt);
            }
        });
        jPanel2.add(all2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 156, 24));

        all3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        all3.setText("0");
        all3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        all3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                all3MouseExited(evt);
            }
        });
        jPanel2.add(all3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 156, 24));

        all6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        all6.setText("0");
        all6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        jPanel2.add(all6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, 156, 24));

        earlyy.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        earlyy.setText("0");
        earlyy.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        jPanel2.add(earlyy, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, 156, 24));

        all5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        all5.setText("0");
        all5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        jPanel2.add(all5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 156, 24));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Dearness Allowance");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, 20));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Late Per Day");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, -1, 20));

        all7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        all7.setText("0");
        all7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        all7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                all7MouseExited(evt);
            }
        });
        jPanel2.add(all7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 156, 24));

        lat1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lat1.setText("0");
        lat1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        lat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lat1ActionPerformed(evt);
            }
        });
        jPanel2.add(lat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, 156, 24));

        Eror.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(Eror, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, 110, 20));

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources_7jan\\src\\reset-icon.png")); // NOI18N
        jButton2.setText("Reset Form");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, -1, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Late Per Hour");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, -1, 20));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Early Per Hour");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, -1, 20));

        LEE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LEE.setText("0");
        LEE.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        LEE.setMinimumSize(new java.awt.Dimension(6, 25));
        LEE.setPreferredSize(new java.awt.Dimension(59, 25));
        jPanel2.add(LEE, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, 156, -1));

        EEE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        EEE.setText("0");
        EEE.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        EEE.setMinimumSize(new java.awt.Dimension(6, 25));
        EEE.setPreferredSize(new java.awt.Dimension(59, 25));
        jPanel2.add(EEE, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, 156, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Employee ID:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 20));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Designation");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 80, 20));

        idd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        idd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        idd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iddActionPerformed(evt);
            }
        });
        jPanel2.add(idd, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 156, 24));

        desig.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        desig.setText("0");
        desig.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        desig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desigActionPerformed(evt);
            }
        });
        jPanel2.add(desig, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 160, 24));

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setMinimumSize(new java.awt.Dimension(100, 200));

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(1825, 40));

        table123.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table123.setModel(new javax.swing.table.DefaultTableModel(
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
        table123.setPreferredSize(new java.awt.Dimension(300, 999999999));
        table123.setRowHeight(25);
        table123.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table123MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table123);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1805, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel1);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 800, 140));

        ma.setText("%");
        ma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maActionPerformed(evt);
            }
        });
        jPanel2.add(ma, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, -1, -1));

        ha.setText("%");
        ha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                haActionPerformed(evt);
            }
        });
        jPanel2.add(ha, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, -1, -1));

        ca.setText("%");
        ca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caActionPerformed(evt);
            }
        });
        jPanel2.add(ca, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, -1, -1));

        da.setText("%");
        da.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daActionPerformed(evt);
            }
        });
        jPanel2.add(da, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("NIC No");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, 20));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Address");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, -1, 20));

        NIC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NIC.setText("0");
        NIC.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        NIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NICActionPerformed(evt);
            }
        });
        jPanel2.add(NIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 160, 24));

        Address.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Address.setText("0");
        Address.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        Address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressActionPerformed(evt);
            }
        });
        jPanel2.add(Address, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 160, 24));

        img.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        img.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                imgMousePressed(evt);
            }
        });
        jPanel2.add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, 120, 130));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel-btn-icon-20.png"))); // NOI18N
        jButton6.setText("Close");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 570, 90, 30));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(252, 126, 1));
        jLabel25.setText("Terminated Employees");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        department2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        department2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                department2ActionPerformed(evt);
            }
        });
        jPanel2.add(department2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 400, 139, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Search Department");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 10, -1));

        jLabel22.setForeground(new java.awt.Color(255, 0, 0));
        jLabel22.setText("*");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 10, -1));

        jLabel23.setForeground(new java.awt.Color(255, 0, 0));
        jLabel23.setText("*");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 10, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setText("Tax Deduction");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, -1, 20));

        status.setEditable(true);
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Probation Period", "Permanent", "Terminated" }));
        jPanel2.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 160, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddressActionPerformed

    private void NICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NICActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NICActionPerformed

    private void daActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_daActionPerformed

    private void caActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caActionPerformed

    private void haActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_haActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_haActionPerformed

    private void maActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maActionPerformed

    private void table123MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table123MouseClicked
        DefaultTableModel model = (DefaultTableModel)table123.getModel();

        // get the selected row index
        int selectedRowIndex = table123.getSelectedRow();

        // set the selected row data into jtextfields
        idd.setText(model.getValueAt(selectedRowIndex, 0).toString());
        namm.setText(model.getValueAt(selectedRowIndex, 1).toString());
        depp.setSelectedItem(model.getValueAt(selectedRowIndex, 2).toString());
        desig.setText(model.getValueAt(selectedRowIndex, 3).toString());
        acc.setText(model.getValueAt(selectedRowIndex, 4).toString());
        contt.setText(model.getValueAt(selectedRowIndex, 5).toString());
        sall.setText(model.getValueAt(selectedRowIndex, 6).toString());
        all1.setText(model.getValueAt(selectedRowIndex, 7).toString());
        all2.setText(model.getValueAt(selectedRowIndex, 8).toString());
        all3.setText(model.getValueAt(selectedRowIndex, 9).toString());
        all5.setText(model.getValueAt(selectedRowIndex, 15).toString());
        all6.setText(model.getValueAt(selectedRowIndex, 16).toString());
        all7.setText(model.getValueAt(selectedRowIndex, 10).toString());
        lat1.setText(model.getValueAt(selectedRowIndex, 11).toString());
        earlyy.setText(model.getValueAt(selectedRowIndex, 12).toString());
        LEE.setText(model.getValueAt(selectedRowIndex, 13).toString());
        EEE.setText(model.getValueAt(selectedRowIndex, 14).toString());
        NIC.setText(model.getValueAt(selectedRowIndex, 17).toString());
        Address.setText(model.getValueAt(selectedRowIndex, 18).toString());
        
        status.setSelectedItem(model.getValueAt(selectedRowIndex, 19).toString());
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst2=conn.prepareStatement("SELECT pic FROM `termin_emp` where id='"+idd.getText()+"'");
           
            ResultSet rst1=pst2.executeQuery();
            
           while(rst1.next()){
               img.setIcon(ResizeImage(null, rst1.getBytes("pic")));

           }}catch(Exception ex){
        
   
       }
        
    }//GEN-LAST:event_table123MouseClicked

    private void desigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desigActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desigActionPerformed

    private void iddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iddActionPerformed

    private void department2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_department2ActionPerformed
        reset();
        //finally{try {pst.close();} catch (SQLException ex) {Logger.getLogger(shift.class.getName()).log(Level.SEVERE, null, ex);}}
    }//GEN-LAST:event_department2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        acc.setText("");
        namm.setText("");
        contt.setText("");
        sall.setText("");
        all1.setText("");
        all2.setText("");
        all3.setText("");
        all5.setText("");
        all6.setText("");
        all7.setText("");
        lat1.setText("");
        earlyy.setText("");
        LEE.setText("");
        EEE.setText("");
        desig.setText("");
        acc.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void lat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lat1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lat1ActionPerformed

    private void deppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deppActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deppActionPerformed

    private void sallKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sallKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_sallKeyPressed

    private void sallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sallActionPerformed

    }//GEN-LAST:event_sallActionPerformed

    private void sallMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sallMouseExited
        int a= (Integer.parseInt(sall.getText())+Integer.parseInt(all1.getText())+Integer.parseInt(all2.getText())+Integer.parseInt(all3.getText())+Integer.parseInt(all7.getText()))*12;
        double s=0;
        
        if(a > 400000 && a < 500000 ){s=(((a-400000)/100)*2)/12;   }
        all6.setText(Double.toString(s));

        if(a > 500000 && a < 750000 ){s=((((a-500000)/100)*5)+2000)/12;   }
        all6.setText(Double.toString(s));

        if(a > 750000 && a < 1400000 ){s=((((a-750000)/100)*10)+14500)/12;   }
        all6.setText(Double.toString(s));

        if(a > 1400000 && a < 1500000 ){s=((((a-1400000)/100)*12.5)+79500)/12;   }
        all6.setText(Double.toString(s));

        if(a > 1500000 && a < 1800000 ){s=((((a-1500000)/100)*15)+92000)/12;   }
        all6.setText(Double.toString(s));

        if(a > 1800000 && a < 2500000 ){s=((((a-1800000)/100)*17.5)+137000)/12;   }
        all6.setText(Double.toString(s));

        if(a > 2500000 && a < 3000000 ){s=((((a-2500000)/100)*20)+259500)/12;   }
        all6.setText(Double.toString(s));

        if(a > 3000000 && a < 3500000 ){s=((((a-3000000)/100)*22.5)+359500)/12;   }
        all6.setText(Double.toString(s));

        if(a > 3500000 && a < 4000000 ){s=((((a-3500000)/100)*25)+472000)/12;   }
        all6.setText(Double.toString(s));

        if(a > 4000000 && a < 7000000 ){s=(((((a-4000000)/100)*27.5)+597000)/12);   }
        all6.setText(Double.toString(s));

        if(a > 7000000){s=((((a-7000000)/100)*30)+1450000)/12;   }
        all6.setText(Double.toString(s));
    }//GEN-LAST:event_sallMouseExited

    private void nammActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nammActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nammActionPerformed

    private void accActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accActionPerformed
        Function f = new Function();
        ResultSet rs = null;

        rs = f.find(idd.getText());
        try{
            if(rs.next()){
                namm.setText(rs.getString("Name"));
                depp.setSelectedItem(rs.getString("Department"));
                contt.setText(rs.getString("Contact"));
                sall.setText(rs.getString("Salary"));
                //`Medical`, `HouseRent`, `Convence`, `Dearness`, `Late`, `Early`, `OT`, `Tax`)
            all1.setText(rs.getString("Medical"));
            all2.setText(rs.getString("HouseRent"));
            all3.setText(rs.getString("Convence"));
            all7.setText(rs.getString("Dearness"));

            all6.setText(rs.getString("Tax"));
            all5.setText(rs.getString("OT"));

            lat1.setText(rs.getString("Late"));
            earlyy.setText(rs.getString("Early"));
            LEE.setText(rs.getString("Late_Exceed"));
            EEE.setText(rs.getString("Early_Exceed"));
            desig.setText(rs.getString("designation"));
            acc.setText(rs.getString("bank"));
        }  else{
            Eror.setText("No data for this id");
        }
        }catch(Exception ex){
            Eror.setText(" Data Error");
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
                    ps = con.prepareStatement("select * from emp_list where id = ?");
                    ps.setString(1,s);
                    rs = ps.executeQuery();
                }catch(Exception ex){
                    Eror.setText(" Data Error");
                }
                return rs;}
    }//GEN-LAST:event_accActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
int choice=JOptionPane.showOptionDialog(null, "Really want to update ?","Save Record",JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
if(choice == JOptionPane.YES_OPTION){
        try
        {
            
            String str2=idd.getText();
            String q=namm.getText();
            String r=depp.getSelectedItem().toString();
            String c=contt.getText();
            String d=sall.getText();
            String e=all1.getText();
            String f=all2.getText();
            String g=all3.getText();
            String h=all7.getText();
            String i=all5.getText();
            String j=all6.getText();
            String k=lat1.getText();
            String l=earlyy.getText();
            String m=LEE.getText();
            String n=EEE.getText();
            String o=desig.getText();
            String p=acc.getText();
            String s=NIC.getText();
            String t=Address.getText();
            String u=status.getSelectedItem().toString();
if(status.getSelectedIndex() == 0 || status.getSelectedIndex() == 1){String query ="INSERT INTO `emp_list` Select * from termin_emp where ID='"+str2+"' ";       // Create query string to insert name into table
//INSERT INTO persons_table select * from customer_table where person_name = 'tom';
            Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

            Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

             pst= con.prepareStatement(query);                             // Create statement
            pst.executeUpdate(query);
           String query2 ="DELETE FROM `termin_emp` WHERE `ID`='"+str2+"'";       // Create query string to insert name into table

                                   // Load Driver cl  // Connect to Database using credentials

            pst= con.prepareStatement(query2);                             // Create statement
            pst.executeUpdate(query2);
                    //PreparedStatement statement = null;
                    //FileInputStream inputStream = null;inputStream = new FileInputStream(image);

                   // statement = con.prepareStatement("update emp_list set pic=? where ID='"+str2+"' ");
                    //statement.setString(1, str2);
            //        statement.setBinaryStream(1, (InputStream) inputStream,(int) (image.length()));
              //      statement.executeUpdate();

            JOptionPane.showMessageDialog(null,"Employee Updated Successfully"); reset();}else{
            String query ="UPDATE `termin_emp` SET Name='"+q+"',Department='"+r+"',Contact='"+c+"',Salary='"+d+"',`Medical`='"+e+"',`HouseRent`='"+f+"',`Convence`='"+g+"',`Dearness`='"+h+"',`Late`='"+k+"',`Early`='"+l+"',`OT`='"+i+"',`Tax`='"+j+"',`Late_Exceed`='"+m+"',`Early_Exceed`='"+n+"',`designation`='"+o+"',`bank`='"+p+"',`NIC`='"+s+"',`Address`='"+t+"',status='"+u+"' where `ID`='"+str2+"'";       // Create query string to insert name into table

            Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

            Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

             pst= con.prepareStatement(query);                             // Create statement
            pst.executeUpdate(query);
                    //PreparedStatement statement = null;
                    //FileInputStream inputStream = null;inputStream = new FileInputStream(image);

                   // statement = con.prepareStatement("update emp_list set pic=? where ID='"+str2+"' ");
                    //statement.setString(1, str2);
            //        statement.setBinaryStream(1, (InputStream) inputStream,(int) (image.length()));
              //      statement.executeUpdate();

            JOptionPane.showMessageDialog(null,"Employee Updated Successfully");
            // Close the open connectio
          //  Eror.setText("Update Successfull");
            reset();
}
        }
        catch
        (Exception ex)
        {JOptionPane.showMessageDialog(null,"Update Failed"+ex);
            
        }}
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
int choice=JOptionPane.showOptionDialog(null, "Really want to delete ?","Delete Record",JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
if(choice == JOptionPane.YES_OPTION){
        try
        {
            String str2=idd.getText();

            String query ="DELETE FROM `emp_list` WHERE `ID`='"+str2+"'";       // Create query string to insert name into table

            Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

            Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

            pst= con.prepareStatement(query);                             // Create statement
            pst.executeUpdate(query);

            // Close the open connectio
  JOptionPane.showMessageDialog(null,"Employee Deleted Successfully");
            reset();
//            Eror.setText("Employee Removed");
        }
        catch
        (Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Record not exist");
          //  Eror.setText("Deleting JOptionPane.showMessageDialog(null,");
        }}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void imgMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgMousePressed
//String fit =new File("C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources_7jan\\src\\empdefault.png").getAbsolutePath();
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources_7jan\\src\\empdefault.png"));
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        System.out.println(f);
        ImageIcon imageIcon = new ImageIcon (new ImageIcon(filename).getImage().getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_DEFAULT));
        img.setIcon(imageIcon);
try{
            image = new File(filename);
            fix = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for(int number; (number = fix.read(buf))!= -1;)
            {
                bos.write(buf,0,number);
            }
            person_image = bos.toByteArray();
        }
        catch(Exception e){
            
        }
    }//GEN-LAST:event_imgMousePressed

    private void sallMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sallMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_sallMousePressed

    private void all1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all1MouseExited
 int a= (Integer.parseInt(sall.getText())+Integer.parseInt(all1.getText())+Integer.parseInt(all2.getText())+Integer.parseInt(all3.getText())+Integer.parseInt(all7.getText()))*12;
        double s=0;
        
        if(a > 400000 && a < 500000 ){s=(((a-400000)/100)*2)/12;   }
        all6.setText(Double.toString(s));

        if(a > 500000 && a < 750000 ){s=((((a-500000)/100)*5)+2000)/12;   }
        all6.setText(Double.toString(s));

        if(a > 750000 && a < 1400000 ){s=((((a-750000)/100)*10)+14500)/12;   }
        all6.setText(Double.toString(s));

        if(a > 1400000 && a < 1500000 ){s=((((a-1400000)/100)*12.5)+79500)/12;   }
        all6.setText(Double.toString(s));

        if(a > 1500000 && a < 1800000 ){s=((((a-1500000)/100)*15)+92000)/12;   }
        all6.setText(Double.toString(s));

        if(a > 1800000 && a < 2500000 ){s=((((a-1800000)/100)*17.5)+137000)/12;   }
        all6.setText(Double.toString(s));

        if(a > 2500000 && a < 3000000 ){s=((((a-2500000)/100)*20)+259500)/12;   }
        all6.setText(Double.toString(s));

        if(a > 3000000 && a < 3500000 ){s=((((a-3000000)/100)*22.5)+359500)/12;   }
        all6.setText(Double.toString(s));

        if(a > 3500000 && a < 4000000 ){s=((((a-3500000)/100)*25)+472000)/12;   }
        all6.setText(Double.toString(s));

        if(a > 4000000 && a < 7000000 ){s=(((((a-4000000)/100)*27.5)+597000)/12);   }
        all6.setText(Double.toString(s));

        if(a > 7000000){s=((((a-7000000)/100)*30)+1450000)/12;   }
        all6.setText(Double.toString(s));        // TODO add your handling code here:
    }//GEN-LAST:event_all1MouseExited

    private void all2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all2MouseExited
 int a= (Integer.parseInt(sall.getText())+Integer.parseInt(all1.getText())+Integer.parseInt(all2.getText())+Integer.parseInt(all3.getText())+Integer.parseInt(all7.getText()))*12;
        double s=0;
        
        if(a > 400000 && a < 500000 ){s=(((a-400000)/100)*2)/12;   }
        all6.setText(Double.toString(s));

        if(a > 500000 && a < 750000 ){s=((((a-500000)/100)*5)+2000)/12;   }
        all6.setText(Double.toString(s));

        if(a > 750000 && a < 1400000 ){s=((((a-750000)/100)*10)+14500)/12;   }
        all6.setText(Double.toString(s));

        if(a > 1400000 && a < 1500000 ){s=((((a-1400000)/100)*12.5)+79500)/12;   }
        all6.setText(Double.toString(s));

        if(a > 1500000 && a < 1800000 ){s=((((a-1500000)/100)*15)+92000)/12;   }
        all6.setText(Double.toString(s));

        if(a > 1800000 && a < 2500000 ){s=((((a-1800000)/100)*17.5)+137000)/12;   }
        all6.setText(Double.toString(s));

        if(a > 2500000 && a < 3000000 ){s=((((a-2500000)/100)*20)+259500)/12;   }
        all6.setText(Double.toString(s));

        if(a > 3000000 && a < 3500000 ){s=((((a-3000000)/100)*22.5)+359500)/12;   }
        all6.setText(Double.toString(s));

        if(a > 3500000 && a < 4000000 ){s=((((a-3500000)/100)*25)+472000)/12;   }
        all6.setText(Double.toString(s));

        if(a > 4000000 && a < 7000000 ){s=(((((a-4000000)/100)*27.5)+597000)/12);   }
        all6.setText(Double.toString(s));

        if(a > 7000000){s=((((a-7000000)/100)*30)+1450000)/12;   }
        all6.setText(Double.toString(s));    }//GEN-LAST:event_all2MouseExited

    private void all3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all3MouseExited
       int a= (Integer.parseInt(sall.getText())+Integer.parseInt(all1.getText())+Integer.parseInt(all2.getText())+Integer.parseInt(all3.getText())+Integer.parseInt(all7.getText()))*12;
        double s=0;
        
        if(a > 400000 && a < 500000 ){s=(((a-400000)/100)*2)/12;   }
        all6.setText(Double.toString(s));

        if(a > 500000 && a < 750000 ){s=((((a-500000)/100)*5)+2000)/12;   }
        all6.setText(Double.toString(s));

        if(a > 750000 && a < 1400000 ){s=((((a-750000)/100)*10)+14500)/12;   }
        all6.setText(Double.toString(s));

        if(a > 1400000 && a < 1500000 ){s=((((a-1400000)/100)*12.5)+79500)/12;   }
        all6.setText(Double.toString(s));

        if(a > 1500000 && a < 1800000 ){s=((((a-1500000)/100)*15)+92000)/12;   }
        all6.setText(Double.toString(s));

        if(a > 1800000 && a < 2500000 ){s=((((a-1800000)/100)*17.5)+137000)/12;   }
        all6.setText(Double.toString(s));

        if(a > 2500000 && a < 3000000 ){s=((((a-2500000)/100)*20)+259500)/12;   }
        all6.setText(Double.toString(s));

        if(a > 3000000 && a < 3500000 ){s=((((a-3000000)/100)*22.5)+359500)/12;   }
        all6.setText(Double.toString(s));

        if(a > 3500000 && a < 4000000 ){s=((((a-3500000)/100)*25)+472000)/12;   }
        all6.setText(Double.toString(s));

        if(a > 4000000 && a < 7000000 ){s=(((((a-4000000)/100)*27.5)+597000)/12);   }
        all6.setText(Double.toString(s));

        if(a > 7000000){s=((((a-7000000)/100)*30)+1450000)/12;   }
        all6.setText(Double.toString(s));
    }//GEN-LAST:event_all3MouseExited

    private void all7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all7MouseExited
 int a= (Integer.parseInt(sall.getText())+Integer.parseInt(all1.getText())+Integer.parseInt(all2.getText())+Integer.parseInt(all3.getText())+Integer.parseInt(all7.getText()))*12;
        double s=0;
        
        if(a > 400000 && a < 500000 ){s=(((a-400000)/100)*2)/12;   }
        all6.setText(Double.toString(s));

        if(a > 500000 && a < 750000 ){s=((((a-500000)/100)*5)+2000)/12;   }
        all6.setText(Double.toString(s));

        if(a > 750000 && a < 1400000 ){s=((((a-750000)/100)*10)+14500)/12;   }
        all6.setText(Double.toString(s));

        if(a > 1400000 && a < 1500000 ){s=((((a-1400000)/100)*12.5)+79500)/12;   }
        all6.setText(Double.toString(s));

        if(a > 1500000 && a < 1800000 ){s=((((a-1500000)/100)*15)+92000)/12;   }
        all6.setText(Double.toString(s));

        if(a > 1800000 && a < 2500000 ){s=((((a-1800000)/100)*17.5)+137000)/12;   }
        all6.setText(Double.toString(s));

        if(a > 2500000 && a < 3000000 ){s=((((a-2500000)/100)*20)+259500)/12;   }
        all6.setText(Double.toString(s));

        if(a > 3000000 && a < 3500000 ){s=((((a-3000000)/100)*22.5)+359500)/12;   }
        all6.setText(Double.toString(s));

        if(a > 3500000 && a < 4000000 ){s=((((a-3500000)/100)*25)+472000)/12;   }
        all6.setText(Double.toString(s));

        if(a > 4000000 && a < 7000000 ){s=(((((a-4000000)/100)*27.5)+597000)/12);   }
        all6.setText(Double.toString(s));

        if(a > 7000000){s=((((a-7000000)/100)*30)+1450000)/12;   }
        all6.setText(Double.toString(s));    }//GEN-LAST:event_all7MouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField Address;
    private javax.swing.JTextField EEE;
    private javax.swing.JLabel Eror;
    private javax.swing.JTextField LEE;
    public javax.swing.JTextField NIC;
    public javax.swing.JTextField acc;
    private javax.swing.JTextField all1;
    private javax.swing.JTextField all2;
    private javax.swing.JTextField all3;
    private javax.swing.JTextField all5;
    private javax.swing.JTextField all6;
    private javax.swing.JTextField all7;
    private javax.swing.JCheckBox ca;
    private javax.swing.JTextField contt;
    private javax.swing.JCheckBox da;
    private javax.swing.JComboBox<String> department2;
    private javax.swing.JComboBox<String> depp;
    public javax.swing.JTextField desig;
    private javax.swing.JTextField earlyy;
    private javax.swing.JCheckBox ha;
    public javax.swing.JTextField idd;
    private javax.swing.JLabel img;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lat1;
    private javax.swing.JCheckBox ma;
    private javax.swing.JTextField namm;
    private javax.swing.JTextField sall;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JTable table123;
    // End of variables declaration//GEN-END:variables
}

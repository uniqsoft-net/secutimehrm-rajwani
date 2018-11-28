import java.awt.Font;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


public class employ extends javax.swing.JInternalFrame {
    dbclass dbd=new dbclass();
   
    public ImageIcon format = null;PreparedStatement pst=null;
    String filename = "C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources_7jan\\src\\empdefault.png";
    byte[] person_image = null;FileInputStream fix=null;File image=null;
    String url=   dbd.server();
      String id=dbd.serverid();
      String pass=dbd.serverpass();
//String url="jdbc:mysql://localhost:3306/hrm";String id="root";String pass="1234";
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
    JFileChooser chooser = new JFileChooser();
    public void reset(){
    try{ 
        String dep=department2.getSelectedItem().toString();
        // table123.getTableHeader().setFont( new Font( "Tahoma" , Font.BOLD, 14 ));

        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
if(dep == "All"){PreparedStatement pst2=con.prepareStatement("SELECT  `ID`, `Name`, `Department`,designation as 'Designation',bank as 'Joining', `Contact`, `Salary`, `Medical`, `HouseRent`, `Convence`, `Dearness`, `Late`, `Early`,`Late_Exceed` as 'Late Hour', `Early_Exceed` as 'Early Hour', `OT`, `Tax`,NIC,Address,status,eobi,sessi,email,stype FROM `emp_list`");
            ResultSet rst2=pst2.executeQuery();
            
        table123.setModel (DbUtils.resultSetToTableModel(rst2)); }
else{String query="SELECT  `ID`, `Name`, `Department`,designation as 'Designation',bank as 'Joining', `Contact`, `Salary`, `Medical`, `HouseRent`, `Convence`, `Dearness`, `Late`, `Early`,`Late_Exceed` as 'Late Hour', `Early_Exceed` as 'Early Hour', `OT`, `Tax`,NIC,Address,status,eobi,sessi,email,stype from emp_list where Department='"+dep+"'";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rst1=pst.executeQuery();table123.setModel (DbUtils.resultSetToTableModel(rst1));}}catch(Exception E){}}

    
  public employ() {
        initComponents();
      
//depp.setNextFocusableComponent(contt);
       // chooser.setCurrentDirectory(new File("C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources_7jan\\src\\empdefault.png"));
      nighttt.setVisible(false);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
             pst=conn.prepareStatement("SELECT MAX(ID) FROM `emp_list`");
            ResultSet rst1=pst.executeQuery();
            if(rst1.next()){
           String a=rst1.getString("MAX(ID)");
              int b=Integer.parseInt(a)+1;
           idd.setText(Integer.toString(b));
            }
         
            PreparedStatement pst1=conn.prepareStatement("SELECT Department_Name FROM `department_list`");
           
            ResultSet rst2=pst1.executeQuery();
            
           while(rst2.next()){
    department2.addItem(rst2.getString("Department_Name"));
           }
      String dep=department2.getSelectedItem().toString();
         table123.getTableHeader().setFont( new Font( "Tahoma" , Font.BOLD, 12 ));

        String query="select `ID`, `Name`, `Department`,designation as 'Designation',bank as 'Bank Account', `Contact`, `Salary`, `Medical`, `HouseRent`, `Convence`, `Dearness`, `Late`, `Early`,`Late_Exceed` as 'Late Hour', `Early_Exceed` as 'Early Hour', `OT`, `Tax`,NIC,Address,status,eobi,sessi,email,stype from emp_list where Department='"+dep+"'";

if(dep == "All"){
             PreparedStatement pst23=conn.prepareStatement("SELECT `ID`, `Name`, `Department`,designation as 'Designation',bank as 'Joining', `Contact`, `Salary`, `Medical`, `HouseRent`, `Convence`, `Dearness`, `Late`, `Early`,`Late_Exceed` as 'Late Hour', `Early_Exceed` as 'Early Hour', `OT`, `Tax`,NIC,Address,status,eobi,sessi,email,stype  FROM `emp_list`");
            ResultSet rst23=pst23.executeQuery();
        table123.setModel (DbUtils.resultSetToTableModel(rst23)); }
else{
        PreparedStatement pst3=conn.prepareStatement(query);
        ResultSet rst13=pst3.executeQuery(); 
        table123.setModel (DbUtils.resultSetToTableModel(rst13)); 
}
     
           PreparedStatement pst4=conn.prepareStatement("SELECT Department_Name FROM department_list");
           ResultSet rst14=pst4.executeQuery();
           
           while(rst14.next()){
               depp.addItem(rst14.getString("Department_Name"));
           }     }
        catch(Exception ex){
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mail = new javax.swing.JTextField();
        namm = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        sall = new javax.swing.JTextField();
        contt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        all1 = new javax.swing.JTextField();
        all2 = new javax.swing.JTextField();
        all3 = new javax.swing.JTextField();
        sessiii = new javax.swing.JTextField();
        earlyy = new javax.swing.JTextField();
        all5 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        all7 = new javax.swing.JTextField();
        lat1 = new javax.swing.JTextField();
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
        jLabel25 = new javax.swing.JLabel();
        department2 = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        img = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        all8 = new javax.swing.JTextField();
        eobiii = new javax.swing.JTextField();
        depp = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        acc1 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        Stype = new javax.swing.JComboBox<>();
        nighttt = new javax.swing.JCheckBox();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Employee Management");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/mainlogo.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add-ic.png"))); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete-ic.png"))); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update-ic.png"))); // NOI18N
        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Date of Joining:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Employee Name:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Department:");
        jLabel3.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Contact: ");

        mail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mail.setText("0");
        mail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailActionPerformed(evt);
            }
        });

        namm.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        namm.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        namm.setNextFocusableComponent(depp);
        namm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nammActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Basic Salary:");

        sall.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sall.setText("0");
        sall.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));

        contt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        contt.setText("0");
        contt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        contt.setNextFocusableComponent(NIC);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Medical Allowance:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Convence Allowance:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("House Rent Allowance:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("OT Allowance Per Hour:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Absent Per Early Day:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Employee Status:");

        all1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        all1.setText("0");
        all1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));

        all2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        all2.setText("0");
        all2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));

        all3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        all3.setText("0");
        all3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));

        sessiii.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sessiii.setText("0");
        sessiii.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));

        earlyy.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        earlyy.setText("0");
        earlyy.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));

        all5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        all5.setText("0");
        all5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Dearness Allowance:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Absent Per Late Day:");

        all7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        all7.setText("0");
        all7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));

        lat1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lat1.setText("0");
        lat1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        lat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lat1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources_7jan\\src\\reset-icon.png")); // NOI18N
        jButton2.setText("Reset Form");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Late Per Hour:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Early Per Hour:");

        LEE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LEE.setText("0");
        LEE.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        LEE.setMinimumSize(new java.awt.Dimension(6, 25));
        LEE.setPreferredSize(new java.awt.Dimension(59, 25));

        EEE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        EEE.setText("0");
        EEE.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        EEE.setMinimumSize(new java.awt.Dimension(6, 25));
        EEE.setPreferredSize(new java.awt.Dimension(59, 25));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Employee ID:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Designation:");

        idd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        idd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        idd.setNextFocusableComponent(namm);
        idd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iddActionPerformed(evt);
            }
        });

        desig.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        desig.setText("0");
        desig.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        desig.setNextFocusableComponent(mail);
        desig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desigActionPerformed(evt);
            }
        });

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setMinimumSize(new java.awt.Dimension(100, 200));

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(1825, 40));

        table123.setAutoCreateRowSorter(true);
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
        table123.setGridColor(new java.awt.Color(204, 204, 204));
        table123.setPreferredSize(new java.awt.Dimension(300, 999999999));
        table123.setRowHeight(25);
        table123.setSelectionBackground(new java.awt.Color(252, 126, 1));
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1805, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jScrollPane2.setViewportView(jPanel1);

        ma.setText("%");
        ma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maActionPerformed(evt);
            }
        });

        ha.setText("%");
        ha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                haActionPerformed(evt);
            }
        });

        ca.setText("%");
        ca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caActionPerformed(evt);
            }
        });

        da.setText("%");
        da.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("National Identity NO.:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Address:");

        NIC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NIC.setText("0");
        NIC.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        NIC.setNextFocusableComponent(Address);
        NIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NICActionPerformed(evt);
            }
        });

        Address.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Address.setText("0");
        Address.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        Address.setNextFocusableComponent(desig);
        Address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(252, 126, 1));
        jLabel25.setText("Employee Management");

        department2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        department2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                department2ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Search Department:");

        jLabel22.setForeground(new java.awt.Color(255, 0, 0));
        jLabel22.setText("*");

        jLabel23.setForeground(new java.awt.Color(255, 0, 0));
        jLabel23.setText("*");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setText("SESSI Deduction:");

        status.setEditable(true);
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Probation Period", "Permanent", "Terminated" }));
        status.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 239, 239)));

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employee-default-pic.png"))); // NOI18N
        img.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 239, 239)));
        img.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                imgMousePressed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update-ic.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setText("Income Tax Deduction:");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setText("EOBI Deduction:");

        all8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        all8.setText("0");
        all8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));

        eobiii.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        eobiii.setText("0");
        eobiii.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));

        depp.setEditable(true);
        depp.setAutoscrolls(true);
        depp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        depp.setKeySelectionManager(null);
        depp.setVerifyInputWhenFocusTarget(false);
        depp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deppActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*");

        acc1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        acc1.setText("0");
        acc1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 239, 239), 1, true));
        acc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acc1ActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setText("Email Address:");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setText("Shift Type:");

        Stype.setEditable(true);
        Stype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Periodic Timings", "No Timings" }));
        Stype.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        Stype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StypeActionPerformed(evt);
            }
        });

        nighttt.setText("Night");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shifts.png"))); // NOI18N
        jButton6.setText("Shifts");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update-ic.png"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update-ic.png"))); // NOI18N
        jButton8.setBorder(null);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(department2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(159, 159, 159)
                                .addComponent(sall, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel14)
                                .addGap(13, 13, 13)
                                .addComponent(lat1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(82, 82, 82)
                                .addComponent(ma)
                                .addGap(3, 3, 3)
                                .addComponent(all1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel11)
                                .addGap(12, 12, 12)
                                .addComponent(earlyy, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel10)
                                                    .addGap(92, 92, 92)
                                                    .addComponent(all5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel29)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(nighttt)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(Stype, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(44, 44, 44)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel27)
                                                    .addGap(39, 39, 39)
                                                    .addComponent(eobiii, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel24)
                                                    .addGap(34, 34, 34)
                                                    .addComponent(sessiii, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel13)
                                            .addGap(72, 72, 72)
                                            .addComponent(da)
                                            .addGap(3, 3, 3)
                                            .addComponent(all7, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(44, 44, 44)
                                            .addComponent(jLabel26)
                                            .addGap(1, 1, 1)
                                            .addComponent(all8, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(67, 67, 67)
                                        .addComponent(ca)
                                        .addGap(3, 3, 3)
                                        .addComponent(all3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)
                                        .addComponent(jLabel16)
                                        .addGap(49, 49, 49)
                                        .addComponent(EEE, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(57, 57, 57)
                                        .addComponent(ha)
                                        .addGap(3, 3, 3)
                                        .addComponent(all2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)
                                        .addComponent(jLabel15)
                                        .addGap(50, 50, 50)
                                        .addComponent(LEE, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton7)
                                    .addComponent(jButton8)
                                    .addComponent(jButton5)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(47, 47, 47)
                                        .addComponent(idd, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(namm, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(50, 50, 50)
                                        .addComponent(depp, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel28))
                                        .addGap(24, 24, 24)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(status, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(jLabel4)))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NIC, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Address, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(acc1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(desig, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(contt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 137, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {depp, status});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(idd, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(namm, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(depp, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(status)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel23)
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel5))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(desig, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(7, 7, 7)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(NIC, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(Address, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(acc1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(16, 16, 16))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(contt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(63, Short.MAX_VALUE)
                        .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sall, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lat1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ma)
                    .addComponent(all1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(earlyy, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ha)
                        .addComponent(all2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LEE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ca)
                        .addComponent(all3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(EEE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(da)
                        .addComponent(all7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(all8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(all5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Stype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nighttt))
                                .addGap(2, 2, 2))
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eobiii, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sessiii, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(department2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {depp, status});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        acc1.setText(model.getValueAt(selectedRowIndex, 4).toString());
        contt.setText(model.getValueAt(selectedRowIndex, 5).toString());
        sall.setText(model.getValueAt(selectedRowIndex, 6).toString());
        all1.setText(model.getValueAt(selectedRowIndex, 7).toString());
        all2.setText(model.getValueAt(selectedRowIndex, 8).toString());
        all3.setText(model.getValueAt(selectedRowIndex, 9).toString());
        all5.setText(model.getValueAt(selectedRowIndex, 15).toString());
        all8.setText(model.getValueAt(selectedRowIndex, 16).toString());
        all7.setText(model.getValueAt(selectedRowIndex, 10).toString());
        lat1.setText(model.getValueAt(selectedRowIndex, 11).toString());
        earlyy.setText(model.getValueAt(selectedRowIndex, 12).toString());
        LEE.setText(model.getValueAt(selectedRowIndex, 13).toString());
        EEE.setText(model.getValueAt(selectedRowIndex, 14).toString());
        NIC.setText(model.getValueAt(selectedRowIndex, 17).toString());
        Address.setText(model.getValueAt(selectedRowIndex, 18).toString());
         sessiii.setText(model.getValueAt(selectedRowIndex,21 ).toString());
        eobiii.setText(model.getValueAt(selectedRowIndex, 20).toString());
        mail.setText(model.getValueAt(selectedRowIndex,22).toString());
        status.setSelectedItem(model.getValueAt(selectedRowIndex, 19).toString());
        Stype.setSelectedIndex(Integer.parseInt(model.getValueAt(selectedRowIndex, 23).toString()));
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst2=conn.prepareStatement("SELECT pic FROM `emp_pic` where id='"+idd.getText()+"'");
           
            ResultSet rst1=pst2.executeQuery();
            
           if(rst1.next()){
               img.setIcon(ResizeImage(null, rst1.getBytes("pic")));

           }
           else{ img.setIcon(new javax.swing.ImageIcon("employee-default-pic.png"));}
        }catch(Exception ex){
   
       }
        
    }//GEN-LAST:event_table123MouseClicked

    private void desigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desigActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desigActionPerformed

    private void iddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iddActionPerformed
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
   NIC.setText(rs.getString("NIC"));
        Address.setText(rs.getString("Address"));
        
        acc1.setText(rs.getString("bank"));
       // desig.setText(rs.getString("Dearness"));
        
            all8.setText(rs.getString("Tax"));
            all5.setText(rs.getString("OT"));

            lat1.setText(rs.getString("Late"));
            earlyy.setText(rs.getString("Early"));
            LEE.setText(rs.getString("Late_Exceed"));
            EEE.setText(rs.getString("Early_Exceed"));
            desig.setText(rs.getString("designation"));
            acc1.setText(rs.getString("bank"));
             sessiii.setText(rs.getString("sessi"));
            eobiii.setText(rs.getString("eobi"));
            mail.setText(rs.getString("email"));
        }  else{
            JOptionPane.showMessageDialog(null,"Not Found");
        }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Data Error");
        }
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,id,pass);
            PreparedStatement pst2=conn.prepareStatement("SELECT pic FROM `emp_pic` where id='"+idd.getText()+"'");
           
            ResultSet rst1=pst2.executeQuery();
            
           if(rst1.next()){
               img.setIcon(ResizeImage(null, rst1.getBytes("pic")));

           }
           else{ img.setIcon(new javax.swing.ImageIcon("employee-default-pic.png"));}
        }catch(Exception ex){}
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
                    JOptionPane.showMessageDialog(null,"Data Error");
                }
                return rs;}
            
    }//GEN-LAST:event_iddActionPerformed

    private void department2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_department2ActionPerformed
        reset();
        //finally{try {pst.close();} catch (SQLException ex) {Logger.getLogger(shift.class.getName()).log(Level.SEVERE, null, ex);}}
    }//GEN-LAST:event_department2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        mail.setText("0");
        namm.setText("0");
        contt.setText("0");
        sall.setText("0");
        all1.setText("0");
        all2.setText("0");
        all3.setText("0");
        all5.setText("0");
        all8.setText("0");
        all7.setText("0");
        lat1.setText("0");
        earlyy.setText("0");
        LEE.setText("0");
        EEE.setText("0");
        desig.setText("0");
        mail.setText("0");
        sessiii.setText("0");
        eobiii.setText("0");
         mail.setText("0");
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void lat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lat1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lat1ActionPerformed

    private void deppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deppActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deppActionPerformed

    private void nammActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nammActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nammActionPerformed

    private void mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailActionPerformed
    
    }//GEN-LAST:event_mailActionPerformed

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
            String j=all8.getText();
            String k=lat1.getText();
            String l=earlyy.getText();
            String m=LEE.getText();
            String n=EEE.getText();
            String o=desig.getText();
            String p=acc1.getText();
            String s=NIC.getText();
            String t=Address.getText();
            String u=status.getSelectedItem().toString();
            String v=eobiii.getText();
        String w=sessiii.getText();
        String x=mail.getText(); int y=Stype.getSelectedIndex();
if(status.getSelectedIndex()==2){String query ="INSERT INTO `termin_emp` select * from emp_list where ID='"+str2+"' ";       // Create query string to insert name into table
//INSERT INTO persons_table select * from customer_table where person_name = 'tom';
            Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

            Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

             pst= con.prepareStatement(query);                             // Create statement
            pst.executeUpdate(query);
           String query2 ="DELETE FROM `emp_list` WHERE `ID`='"+str2+"'";       // Create query string to insert name into table

                                   // Load Driver cl  // Connect to Database using credentials

            pst= con.prepareStatement(query2);                             // Create statement
            pst.executeUpdate(query2);
            try{
                    PreparedStatement statement = null;
                    FileInputStream inputStream = new FileInputStream(image);

                    statement = con.prepareStatement("replace into emp_pic values('"+str2+"',?) ");
//                    statement.setString(1, str2);
              statement.setBinaryStream(1, (InputStream) inputStream,(int) (image.length()));
                    statement.executeUpdate();
            }catch(Exception ep){}
            JOptionPane.showMessageDialog(null,"Employee Updated Successfully"); reset();}else{
            String query ="UPDATE `emp_list` SET Name='"+q+"',Department='"+r+"',Contact='"+c+"',Salary='"+d+"',`Medical`='"+e+"',`HouseRent`='"+f+"',`Convence`='"+g+"',`Dearness`='"+h+"',`Late`='"+k+"',`Early`='"+l+"',`OT`='"+i+"',`Tax`='"+j+"',`Late_Exceed`='"+m+"',`Early_Exceed`='"+n+"',`designation`='"+o+"',`bank`='"+p+"',`NIC`='"+s+"',`Address`='"+t+"',status='"+u+"',`eobi`='"+v+"',sessi='"+w+"',email='"+x+"',stype='"+y+"' where `ID`='"+str2+"'";       // Create query string to insert name into table

            Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

            Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

             pst= con.prepareStatement(query);                             // Create statement
            pst.executeUpdate(query);
            
try{
                        PreparedStatement statement = null;
                    FileInputStream inputStream = null;inputStream = new FileInputStream(image);

                    statement = con.prepareStatement("update emp_pic set pic=? where id='"+str2+"' ");
                    //statement.setString(1, str2);
                    statement.setBinaryStream(1, (InputStream) inputStream,(int) (image.length()));
                    statement.executeUpdate();
}catch(Exception kh){}
            JOptionPane.showMessageDialog(null,"Employee Updated Successfully");
       
            reset();
}
        }
        catch
        (Exception ex)
        {JOptionPane.showMessageDialog(null,ex);
            
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
//            JOptionPane.showMessageDialog(null,"Employee Removed");
        }
        catch
        (Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Record not exist","Error",JOptionPane.ERROR_MESSAGE);
          //  JOptionPane.showMessageDialog(null,"Deleting JOptionPane.showMessageDialog(null,");
        }}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String str2=idd.getText();int idddd=0;String idddd2="";
         try{                    String query3 ="select ID,Name from emp_list where id='"+str2+"'";       // Create query string to insert name into table
                    Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class
 Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials
                    pst= con.prepareStatement(query3);                             // Create statement
                        ResultSet rst2= pst.executeQuery(query3);
                        while(rst2.next()){idddd=Integer.parseInt(rst2.getString("ID"));idddd2=rst2.getString("Name");}}catch(Exception fd){}
            try{                    String query3 ="select ID from termin_emp where ID='"+str2+"'";       // Create query string to insert name into table
                    Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class
 Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials
                    pst= con.prepareStatement(query3);                             // Create statement
                        ResultSet rst2= pst.executeQuery(query3);
                        while(rst2.next()){idddd=Integer.parseInt(rst2.getString("ID"));}}catch(Exception fd){}
         
        String q=namm.getText();
        String r=depp.getSelectedItem().toString();
        String c=contt.getText();
        String d=sall.getText();
        String e=all1.getText();
        String f=all2.getText();
        String g=all3.getText();
        String h=all7.getText();
        String i=all5.getText();
        String j=all8.getText();
        String k=lat1.getText();
        String l=earlyy.getText();
        String m=LEE.getText();
        String n=EEE.getText();
        String o=desig.getText();
        String p=acc1.getText();
        String s=NIC.getText();
        String t=Address.getText();
        String u=status.getSelectedItem().toString();
              String v=eobiii.getText();
        String w=sessiii.getText();
        String x=mail.getText();
        String y=Integer.toString(Stype.getSelectedIndex());
if(status.getSelectedIndex()==2){
    if( x.isEmpty() ||u.isEmpty() ||s.isEmpty() || t.isEmpty() || str2.isEmpty() || q.isEmpty() || r.isEmpty() || c.isEmpty() || d.isEmpty() || e.isEmpty() || f.isEmpty() || g.isEmpty() || h.isEmpty() || i.isEmpty() || j.isEmpty() || k.isEmpty() || l.isEmpty() || m.isEmpty() || n.isEmpty() || o.isEmpty() || p.isEmpty() || v.isEmpty() || w.isEmpty() )
        {JOptionPane.showMessageDialog(null,"Missing information","Error",JOptionPane.ERROR_MESSAGE);}

        else{
            String regex = "[0-9]+";

            if (y.matches(regex) ||!str2.matches(regex) || !c.matches(regex) || !d.matches(regex) || !e.matches(regex) || !f.matches(regex) || !g.matches(regex) || !h.matches(regex) || !i.matches(regex) || !k.matches(regex) || !l.matches(regex) || !m.matches(regex) || !n.matches(regex) || !v.matches(regex) || !w.matches(regex) )
            {JOptionPane.showMessageDialog(null," Only numeric input required","Error",JOptionPane.ERROR_MESSAGE);}
            else{
                try
                {
                   
                        if(idddd == (Integer.parseInt(str2)) ){
                        JOptionPane.showMessageDialog(null,"Record already exist","Error",JOptionPane.ERROR_MESSAGE);}else{
                       //     if(idddd2.equals(q) ){
                      //  JOptionPane.showMessageDialog(null,"Name '"+q+"' already exist");}else{
                  
                            if(ma.isSelected()){e=Integer.toString(Integer.parseInt(d)/100*Integer.parseInt(e)); }
                    if(ha.isSelected()){f=Integer.toString(Integer.parseInt(d)/100*Integer.parseInt(f)); }
                    if(ca.isSelected()){g=Integer.toString(Integer.parseInt(d)/100*Integer.parseInt(g)); }
                    if(da.isSelected()){h=Integer.toString(Integer.parseInt(d)/100*Integer.parseInt(h)); }

                    FileInputStream a=fix;

                    String query ="INSERT INTO `termin_emp` VALUES ('"+str2+"','"+q+"','"+r+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+k+"','"+l+"','"+i+"','"+j+"','"+m+"','"+n+"','"+o+"','"+p+"','','"+s+"','"+t+"','"+u+"','"+v+"','"+w+"','"+x+"','"+y+"')";       // Create query string to insert name into table
                    Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

                    Connection con = DriverManager.getConnection(url,id,pass); 
                    // Connect to Database using credentials
                    pst= con.prepareStatement(query);                             // Create statement
                             pst.executeUpdate(query);reset();JOptionPane.showMessageDialog(null,"Employee Added Successfully");
                    try{
                        PreparedStatement statement = null;
                    FileInputStream inputStream = null;inputStream = new FileInputStream(image);

                    statement = con.prepareStatement("update termin_emp set pic=? where ID='"+str2+"' ");
                    //statement.setString(1, str2);
                    statement.setBinaryStream(1, (InputStream) inputStream,(int) (image.length()));
                    statement.executeUpdate();
                    
                    idd.setText(Integer.toString(Integer.parseInt(str2)+1));
                    // Close the open connectio
                    namm.setText("");
                    reset();}catch(Exception Ea){}}
                }
                catch
                (Exception ex)
                {JOptionPane.showMessageDialog(null,"Name '"+q+"' already exist","Error",JOptionPane.ERROR_MESSAGE);
                   
                }}}}else{
        if(x.isEmpty() ||u.isEmpty() ||s.isEmpty() || t.isEmpty() || str2.isEmpty() || q.isEmpty() || r.isEmpty() || c.isEmpty() || d.isEmpty() || e.isEmpty() || f.isEmpty() || g.isEmpty() || h.isEmpty() || i.isEmpty() || j.isEmpty() || k.isEmpty() || l.isEmpty() || m.isEmpty() || n.isEmpty() || o.isEmpty() || p.isEmpty() )
        {JOptionPane.showMessageDialog(null," Missing information","Error",JOptionPane.ERROR_MESSAGE);}

        else{
            String regex = "[0-9]+";

            if (!y.matches(regex) ||!str2.matches(regex) || !c.matches(regex) || !d.matches(regex) || !e.matches(regex) || !f.matches(regex) || !g.matches(regex) || !h.matches(regex) || !i.matches(regex)  || !k.matches(regex) || !l.matches(regex) || !m.matches(regex) || !n.matches(regex) )
            {JOptionPane.showMessageDialog(null," Only numeric input required","Error",JOptionPane.ERROR_MESSAGE);}
            else{
                try
                {
                      if(idddd == (Integer.parseInt(str2)) ){
                        JOptionPane.showMessageDialog(null,"Record already exist","Error",JOptionPane.ERROR_MESSAGE);}else{
                         //   if(idddd2.equals(q) ){
                       // JOptionPane.showMessageDialog(null,"Name '"+q+"' already exist","Error",JOptionPane.ERROR_MESSAGE);}else{
                            if(ma.isSelected()){e=Integer.toString(Integer.parseInt(d)/100*Integer.parseInt(e)); }
                            if(ha.isSelected()){f=Integer.toString(Integer.parseInt(d)/100*Integer.parseInt(f)); }
                            if(ca.isSelected()){g=Integer.toString(Integer.parseInt(d)/100*Integer.parseInt(g)); }
                            if(da.isSelected()){h=Integer.toString(Integer.parseInt(d)/100*Integer.parseInt(h)); }
                            
                            FileInputStream a=fix;
                            
                            String query ="INSERT INTO `emp_list` VALUES ('"+str2+"','"+q+"','"+r+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+k+"','"+l+"','"+i+"','"+j+"','"+m+"','"+n+"','"+o+"','"+p+"','','"+s+"','"+t+"','"+u+"','"+v+"','"+w+"','"+x+"','"+y+"')";       // Create query string to insert name into table
                            Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

                    Connection con = DriverManager.getConnection(url,id,pass); 
                            // Connect to Database using credentials
                            pst= con.prepareStatement(query);                             // Create statement
                            pst.executeUpdate(query);reset();JOptionPane.showMessageDialog(null,"Employee Added Successfully");

 if(Stype.getSelectedIndex()==1 && nighttt.isSelected()== false){
    /* new Thread (new Runnable(){
          @Override
          public void run(){
              try{
      String shift="replace INTO `num_run`(`Num_RunID`, `Name`, `Start_Date`, `End_Date`, `Cycle`, `Unit`) VALUES ('100','default','2017-10-10','2017-10-10','1','1')";
pst.executeUpdate(shift);  
   for(int mond=1;mond <= 7;mond++){
           String sift = "replace INTO `num_run_days` VALUES('100','default','2017-01-01 09:00:00','2017-01-01 17:00:00','"+mond+"','"+mond+"','100','default','2017-01-01 00:00:01','2017-01-01 00:00:01','2017-01-01 00:00:01','2017-01-01 00:00:01','2017-01-01 00:00:01','2017-01-01 00:00:01','2017-01-01 00:00:01','2017-01-01 00:00:01','0','2017-01-01 00:01:00','2017-01-01 23:59:59','2017-01-01 00:01:00','2017-01-01 23:59:59')";
                         // query        tablename           id       name    starttime             endtime                 days       days     shftid  shftname             late               early                 inot                 outot               lateexceed          early exceed                   
                            pst.executeUpdate(sift);
   }        String incDate="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ff = Calendar.getInstance();
            LocalDate startDate=            LocalDate.parse("2018-03-01");
            LocalDate endDate=                LocalDate.parse("2020-05-01");
        //    String qwe=abc.toString();
            ff.setTime(sdf.parse("2018-01-01"));
            final long days = ChronoUnit.DAYS.between(startDate,endDate);

              for(int co=0; co<=days-1 ; co++){
                    ff.add(Calendar.DATE, 1);
                    incDate = sdf.format(ff.getTime());
                   
                       
            PreparedStatement pst2=con.prepareStatement("replace INTO `user_of_run2` (`User_ID`,Num_of_run, Start_Date) VALUES ('"+str2+"','100','"+incDate+"')");
            pst2.executeUpdate();}}catch(Exception e){}}}).start();
 
 }
  if(Stype.getSelectedIndex()==1 && nighttt.isSelected()== true){
     new Thread (new Runnable(){
          @Override
          public void run(){
              try{
      String shift="replace INTO `num_run`(`Num_RunID`, `Name`, `Start_Date`, `End_Date`, `Cycle`, `Unit`) VALUES ('101','nightdefault','2017-10-10','2017-10-10','1','1')";
pst.executeUpdate(shift);  
   for(int mond=1;mond <= 7;mond++){
           String sift = "replace INTO `num_run_days` VALUES('101','nightdefault','2017-01-01 09:00:00','2017-01-01 17:00:00','"+mond+"','"+mond+"','101','nightdefault','2017-01-01 00:00:01','2017-01-01 00:00:01','2017-01-01 00:00:01','2017-01-01 00:00:01','2017-01-01 00:00:01','2017-01-01 00:00:01','2017-01-01 00:00:01','2017-01-01 00:00:01','1','08:00:00','23:59:59','00:00:01','07:59:59')";
                         
                            pst.executeUpdate(sift);
   }        String incDate="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ff = Calendar.getInstance();
            LocalDate startDate=            LocalDate.parse("2018-03-01");
            LocalDate endDate=                LocalDate.parse("2020-05-01");
        //    String qwe=abc.toString();
            ff.setTime(sdf.parse("2018-01-01"));
            final long days = ChronoUnit.DAYS.between(startDate,endDate);

              for(int co=0; co<=days-1 ; co++){
                    ff.add(Calendar.DATE, 1);
                    incDate = sdf.format(ff.getTime());
                   
                       
            PreparedStatement pst2=con.prepareStatement("replace INTO `user_of_run2` (`User_ID`,Num_of_run, Start_Date, `shiftname`, `starttime`, `endtime`, `ot`, `inot`, `late`, `early`, `lateexceed`, `earlyexceed`, `lunchin`, `lunchout`, `startin`, `endin`, `startout`, `endout`, `status`) VALUES ('"+str2+"','101','"+incDate+"','nightdefault','"+incDate+" 09:00:00','"+incDate+" 17:00:00,'"+incDate+" 00:00:01','"+incDate+" 00:00:01','"+incDate+" 00:00:01','"+incDate+" 00:00:01','"+incDate+" 00:00:01','"+incDate+" 00:00:01','"+incDate+" 00:00:01','"+incDate+" 00:00:01','08:00:00','23:59:59','00:00:01','07:59:59','1')");
            pst2.executeUpdate();}}catch(Exception e){}}}).start();
 */
 }
                            
                          try{  PreparedStatement statement = null;
                            FileInputStream inputStream = null;inputStream = new FileInputStream(image);
                            
                            statement = con.prepareStatement("replace into emp_pic values('"+str2+"',?) ");
                            //statement.setString(1, str2);
                            statement.setBinaryStream(1, (InputStream) inputStream,(int) (image.length()));
                            statement.executeUpdate();
                            
                            idd.setText(Integer.toString(Integer.parseInt(str2)+1));
                            // Close the open connectio
                            namm.setText("");
                            
                            
                            
                            reset();}catch(Exception Ea){}}
                }
                catch
                (Exception ex)
                {JOptionPane.showMessageDialog(null,"Name '"+q+"' already exist","Error",JOptionPane.ERROR_MESSAGE);
                
                }}}}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void imgMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgMousePressed
        //String fit =new File("C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources_7jan\\src\\empdefault.png").getAbsolutePath();

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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
 int a= (Integer.parseInt(sall.getText())+Integer.parseInt(all1.getText())+Integer.parseInt(all2.getText())+Integer.parseInt(all3.getText())+Integer.parseInt(all7.getText()))*12;
                            double s=0.0;
                            String salr="0";
                            if(a > 400000 && a < 500000 ){s=(((a-400000)/100)*2);   }
                            salr=(Double.toString(s/12));

                            if(a > 500000 && a < 750000 ){s=((((a-500000)/100)*5)+2000);   }
                            salr=(Double.toString(s/12));

                            if(a > 750000 && a < 1400000 ){s=((((a-750000)/100)*10)+14500);   }//2572.4-330
                            salr=(Double.toString(s/12));

                            if(a > 1400000 && a < 1500000 ){s=((((a-1400000)/100)*12.5)+79500);   }
                            salr=(Double.toString(s/12));

                            if(a > 1500000 && a < 1800000 ){s=((((a-1500000)/100)*15)+92000);   }
                            salr=(Double.toString(s/12));

                            if(a > 1800000 && a < 2500000 ){s=((((a-1800000)/100)*17.5)+137000);   }
                            salr=(Double.toString(s/12));

                            if(a > 2500000 && a < 3000000 ){s=((((a-2500000)/100)*20)+259500);   }
                            salr=(Double.toString(s/12));

                            if(a > 3000000 && a < 3500000 ){s=((((a-3000000)/100)*22.5)+359500);   }
                            salr=(Double.toString(s/12));

                            if(a > 3500000 && a < 4000000 ){s=((((a-3500000)/100)*25)+472000);   }
                            salr=(Double.toString(s/12));

                            if(a > 4000000 && a < 7000000 ){s=(((((a-4000000)/100)*27.5)+597000));   }
                            salr=(Double.toString(s/12));

                            if(a > 7000000){s=((((a-7000000)/100)*30)+1450000);   }
                            salr=(Double.toString(s/12));
                            all8.setText(salr);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void acc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acc1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acc1ActionPerformed

    private void StypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StypeActionPerformed
       if(Stype.getSelectedIndex() == 0){nighttt.setVisible(false);jLabel11.setText("Absent per Early Day:"); }else {nighttt.setVisible(true);jLabel11.setText("Halfday count per day");}
       
    }//GEN-LAST:event_StypeActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      shift a=new shift();
  a.setVisible(true);
       this.getDesktopPane().add(a);
       a.jTabbedPane1.setSelectedIndex(3);
      try{
a.setSelected(true);}catch(Exception e){} 
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        LEE.setText(Integer.toString((Integer.parseInt(sall.getText())+Integer.parseInt(all1.getText())+Integer.parseInt(all2.getText())+Integer.parseInt(all3.getText())+Integer.parseInt(all7.getText()))/30/9));        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
     EEE.setText(Integer.toString((Integer.parseInt(sall.getText())+Integer.parseInt(all1.getText())+Integer.parseInt(all2.getText())+Integer.parseInt(all3.getText())+Integer.parseInt(all7.getText()))/30/9));        

    }//GEN-LAST:event_jButton8ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField Address;
    private javax.swing.JTextField EEE;
    private javax.swing.JTextField LEE;
    public javax.swing.JTextField NIC;
    private javax.swing.JComboBox<String> Stype;
    public javax.swing.JTextField acc1;
    private javax.swing.JTextField all1;
    private javax.swing.JTextField all2;
    private javax.swing.JTextField all3;
    private javax.swing.JTextField all5;
    private javax.swing.JTextField all7;
    private javax.swing.JTextField all8;
    private javax.swing.JCheckBox ca;
    private javax.swing.JTextField contt;
    private javax.swing.JCheckBox da;
    private javax.swing.JComboBox<String> department2;
    private javax.swing.JComboBox<String> depp;
    public javax.swing.JTextField desig;
    private javax.swing.JTextField earlyy;
    private javax.swing.JTextField eobiii;
    private javax.swing.JCheckBox ha;
    public javax.swing.JTextField idd;
    private javax.swing.JLabel img;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
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
    public javax.swing.JTextField mail;
    private javax.swing.JTextField namm;
    private javax.swing.JCheckBox nighttt;
    private javax.swing.JTextField sall;
    private javax.swing.JTextField sessiii;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JTable table123;
    // End of variables declaration//GEN-END:variables
}

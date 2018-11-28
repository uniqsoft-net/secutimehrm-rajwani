/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Properties;
 
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
 
/**
 *
 * @author Mohsin
 */
public class email extends javax.swing.JInternalFrame {
     dbclass dbd=new dbclass();
          String url=   dbd.server();
      String id=dbd.serverid();
      String pass=dbd.serverpass();
  public static void sendEmailWithAttachments(String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String message, String[] attachFiles)
            throws AddressException, MessagingException, IOException {
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.user", userName);
        properties.put("mail.password", password);
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
 
        // creates message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(message, "text/html");
 
        // creates multi-part
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
 
        // adds attachments
        if (attachFiles != null && attachFiles.length > 0) {
            for (String filePath : attachFiles) {
                MimeBodyPart attachPart = new MimeBodyPart();
 
                try {
                    attachPart.attachFile(filePath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
 
                multipart.addBodyPart(attachPart);
            }
        }
 
        // sets the multi-part as e-mail's content
        msg.setContent(multipart);
 
        // sends the e-mail
        Transport.send(msg);
 
    }
    
    
public void reset(){
 try{ 
        String dep=department2.getSelectedItem().toString();
        // table123.getTableHeader().setFont( new Font( "Tahoma" , Font.BOLD, 14 ));

        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);

        
        if(dep == "All"){PreparedStatement pst2=con.prepareStatement("SELECT  `ID`, `Name`, `Department`,`email` FROM `emp_list`");
            ResultSet rst2=pst2.executeQuery();
            
        employeesss.setModel (DbUtils.resultSetToTableModel(rst2)); }
else{String query="SELECT  `ID`, `Name`, `Department`,`email` from emp_list where Department='"+dep+"'";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rst1=pst.executeQuery();employeesss.setModel (DbUtils.resultSetToTableModel(rst1));
}
 
 
 
 }catch(Exception E){}}
 public void reset1(){
try{Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
PreparedStatement pst3=con.prepareStatement("SELECT Department_Name FROM `department_list`");
            ResultSet rst3=pst3.executeQuery();
           while(rst3.next()){
            department2.addItem(rst3.getString("Department_Name"));}
}catch(Exception e){}
}
  public void reset2(){
try{Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
PreparedStatement pst3=con.prepareStatement("SELECT email FROM `mail`");
            ResultSet rst3=pst3.executeQuery();
           while(rst3.next()){
            selectMail.addItem(rst3.getString("email"));}
}catch(Exception e){}
}
 public void reset3(){
 try{ 
        String dep=selectMail.getSelectedItem().toString();
        // table123.getTableHeader().setFont( new Font( "Tahoma" , Font.BOLD, 14 ));

        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,id,pass);
PreparedStatement pst2=con.prepareStatement("SELECT  `Host`, `Port`, `Pass`,`email` FROM `mail` where email='"+dep+"' ");
            ResultSet rst2=pst2.executeQuery();
            if(rst2.next()){
            Host.setText(rst2.getString("host"));
            Port.setText(rst2.getString("port"));
            eMail.setText(rst2.getString("email"));
            Pass.setText(rst2.getString("pass"));
            }
 
 
 
 }catch(Exception E){}}
    /**
     * Creates new form email
     */
    public email() {
        initComponents();
         reset();reset1();reset2();reset3();
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
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        sub = new javax.swing.JTextField();
        from123 = new com.toedter.calendar.JDateChooser();
        att = new javax.swing.JRadioButton();
        to123 = new com.toedter.calendar.JDateChooser();
        pay = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        employeesss = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table21 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        department2 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        selectMail = new javax.swing.JComboBox<>();
        mess = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        eMail = new javax.swing.JTextField();
        Pass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Port = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Host = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        mesas = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Mail To Employee");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/mainlogo.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setText("Select Email:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        jLabel9.setText("Subject:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        jLabel4.setText("Your Message:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        sub.setText("Human Resources Management");
        jPanel1.add(sub, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 190, -1));
        jPanel1.add(from123, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 190, -1));

        buttonGroup1.add(att);
        att.setSelected(true);
        att.setText("Attendance Report");
        jPanel1.add(att, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, -1, -1));

        to123.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(to123, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 190, -1));

        buttonGroup1.add(pay);
        pay.setText("PayRoll Report");
        pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payActionPerformed(evt);
            }
        });
        jPanel1.add(pay, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, -1, -1));

        jLabel18.setText("Select End Date:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, 22));

        employeesss.setAutoCreateRowSorter(true);
        employeesss.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                "Employee ID", "Name", "Department", "Email"
            }
        ));
        employeesss.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        employeesss.setSelectionBackground(new java.awt.Color(252, 156, 1));
        jScrollPane3.setViewportView(employeesss);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 90, 380, 180));

        jLabel10.setText("Select Month:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, 25));

        table21.setAutoCreateRowSorter(true);
        table21.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Name", "Email Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
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
        table21.setSelectionBackground(new java.awt.Color(252, 156, 1));
        jScrollPane2.setViewportView(table21);
        table21.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 288, 180));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(252, 126, 1));
        jLabel5.setText("Selected Employees");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(252, 126, 1));
        jLabel6.setText("Select Employees");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, -1, -1));

        department2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        department2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                department2ActionPerformed(evt);
            }
        });
        jPanel1.add(department2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 110, -1));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setText("<<");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 50, -1));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setText("<");
        jButton5.setOpaque(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 50, -1));

        selectMail.setEditable(true);
        selectMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectMailActionPerformed(evt);
            }
        });
        jPanel1.add(selectMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 190, -1));

        mess.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        mess.setText("Secutime HRM Attendance/PaySlip Mail");
        jPanel1.add(mess, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 190, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mail-16.gif"))); // NOI18N
        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 90, 30));

        jLabel11.setText("Select Report:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, 25));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Email Setting"));

        jLabel2.setText("Email Address:");

        jLabel3.setText("Mail password:");

        jLabel1.setText("Port:");

        jLabel7.setText("Host:");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add-ic.png"))); // NOI18N
        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete-ic.png"))); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel1))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eMail, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Pass, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Port, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Host, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Host, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addGap(23, 23, 23))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 260, 170));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(252, 126, 1));
        jLabel12.setText("Mail To Employee");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel-btn-icon-20.png"))); // NOI18N
        jButton6.setText("Close");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 520, -1, -1));
        jPanel1.add(mesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 110, 30));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update-ic.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 20, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,id,pass);
            String query="Delete from mail where Host='"+Host.getText()+"' and port='"+Port.getText()+"' and email='"+eMail.getText()+"' and pass='"+Pass.getText()+"' ";
            PreparedStatement pst=con.prepareStatement(query);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Delete Successfull");

        }catch(Exception E){}
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
            if(dep == "All"){PreparedStatement pst2=con.prepareStatement("SELECT  `ID`, `Name`, `email` FROM `emp_list`");
                ResultSet rst2=pst2.executeQuery();

                table21.setModel (DbUtils.resultSetToTableModel(rst2)); }
            else{String query="SELECT  `ID`, `Name`,`email` from emp_list where Department='"+dep+"'";
                PreparedStatement pst=con.prepareStatement(query);
                ResultSet rst1=pst.executeQuery();table21.setModel (DbUtils.resultSetToTableModel(rst1));}}catch(Exception E){}
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        DefaultTableModel model = (DefaultTableModel)employeesss.getModel();
        DefaultTableModel model2 = (DefaultTableModel)table21.getModel();

        // get the selected row index
        int selectedRowIndex = employeesss.getSelectedRow();

        // set the selected row data into jtextfields
        String id=(model.getValueAt(selectedRowIndex, 0).toString());
        String name=(model.getValueAt(selectedRowIndex, 1).toString());
        String mail=(model.getValueAt(selectedRowIndex, 3).toString());
        model2.addRow(new Object[]{id,name,mail});

        model.removeRow(selectedRowIndex);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void selectMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectMailActionPerformed
        reset3();
    }//GEN-LAST:event_selectMailActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,id,pass);
            String query="insert into mail values('"+Host.getText()+"','"+Port.getText()+"','"+eMail.getText()+"','"+Pass.getText()+"') ";
            PreparedStatement pst=con.prepareStatement(query);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Add Successfull");

        }catch(Exception E){JOptionPane.showMessageDialog(null,E);}

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String table=null;InputStream  is2=null;

        String reportDest = "C:\\HRMS\\HRMS.pdf";
        File pdf = new File(reportDest);
        java.util.Date sdate=from123.getDate();
        java.sql.Date fromsql=new java.sql.Date(sdate.getTime());
        java.util.Date sdate2=to123.getDate();
        java.sql.Date tosql=new java.sql.Date(sdate2.getTime());
        //for mail
        String host = Host.getText();
        String port = Port.getText();
        String mailFrom = eMail.getText();
        String password = Pass.getText();
        try{

            for(int q=0; q < table21.getRowCount(); q++){
                String id=(table21.getValueAt(q, 0).toString());
                String EEmail=(table21.getValueAt(q, 2).toString());

                // message info
                String mailTo = EEmail;
                String subject = sub.getText();
                String message = mess.getText();

                // attachments
                String[] attachFiles = new String[1];
                attachFiles[0] ="C:/HRMS/HRMS.pdf";

                if(pay.isSelected()){ is2= getClass().getResourceAsStream("payslip.jrxml"); table="SELECT * FROM report WHERE ID='"+id+"' and Date between '"+fromsql+"' and '"+tosql+"'";}
                if(att.isSelected()) {is2 = getClass().getResourceAsStream("emplist_2_1.jrxml");table="SELECT * FROM statistic_report WHERE ID='"+id+"' and Date between '"+fromsql+"' and '"+tosql+"'";}

                JasperDesign jd=JRXmlLoader.load(is2);

                String sql=table;
                JRDesignQuery newQuery=new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);

                //String report="C:\\Users\\Mohsin\\Documents\\NetBeansProjects\\HumanResources\\src\\report1.jrxml";
                JasperReport jr=JasperCompileManager.compileReport(jd);
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(url,id,pass);
                JasperPrint jp=JasperFillManager.fillReport(jr,null,conn);
                //  JasperViewer.viewReport(jp,false);

                //          JasperViewer jv = new JasperViewer( jp, false );
                //jv.viewReport( jp,false);
                JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(pdf));

                //for mail
                try {
                    sendEmailWithAttachments(host, port, mailFrom, password, mailTo,
                        subject, message, attachFiles);
                mesas.setText("Email sent.");
                } catch (Exception ex) {
                  JOptionPane.showMessageDialog(null,"ERROR! Network failure or Connection busy");
                    ex.printStackTrace();
                }
            }
            
        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}

        // SMTP info

    }//GEN-LAST:event_jButton1ActionPerformed

    private void payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_payActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
reset2();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Host;
    private javax.swing.JPasswordField Pass;
    private javax.swing.JTextField Port;
    private javax.swing.JRadioButton att;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> department2;
    private javax.swing.JTextField eMail;
    private javax.swing.JTable employeesss;
    private com.toedter.calendar.JDateChooser from123;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel mesas;
    private javax.swing.JTextField mess;
    private javax.swing.JRadioButton pay;
    private javax.swing.JComboBox<String> selectMail;
    private javax.swing.JTextField sub;
    private javax.swing.JTable table21;
    private com.toedter.calendar.JDateChooser to123;
    // End of variables declaration//GEN-END:variables
}

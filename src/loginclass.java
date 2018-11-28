
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mohsin
 */
public class loginclass {
     dbclass dbd=new dbclass();
          String url=   dbd.server();
      String id=dbd.serverid();
      String pass=dbd.serverpass();
    int emp=1,dep=1,shft=1,leave=1,loan=1,manual=1,attendan=1,payro=1,open=0;
    String error="N";int a111=0;
    String asd="";
    
    
    public int login(String a,String b ){
                                                     // Default Password is empty string

        String str1 = a;
        String p =b;
        try
        {

            String query = "SELECT `id`, `pass`, `email`, `contact`, `admin`, `data`, `path`, `machine`, `calculate`, `attendance`, `payroll`, `depart`, `employee`, `manual`, `shift`, `leavemanage`, `import`, `help`, `termin_emp`, `empRpt`, `holi`, `loan`, `adva`, `finan`, `mail`, `termemprpt`  FROM login WHERE id='"+str1+"' And pass='"+p+"'";             // Create query string to insert name into table

            Class.forName("com.mysql.jdbc.Driver");                             // Load Driver class

            Connection con = DriverManager.getConnection(url,id,pass);  // Connect to Database using credentials

            PreparedStatement pst= con.prepareStatement(query);                             // Create statement
            ResultSet result = pst.executeQuery();
            //                                    Execute Query
            //pst.setString(1,str1);
            //          pst.setString(2,p);
            // Close the open connection
            if(result.next()){ int a66=result.getInt("attendance");
                 if(a66 == 0){attendan=0;} 
                int a77=result.getInt("payroll");
                if(a77 == 0){payro=0;}
                int a88=result.getInt("depart");
                if(a88 == 0){dep=0;}
                int a99=result.getInt("employee");
                if(a99 == 0){emp=0;}
                int a100=result.getInt("shift");
                if(a100 == 0){shft=0;}
                int a110=result.getInt("manual");
                if(a110 == 0){manual=0;}
                int a122=result.getInt("leavemanage");
                if(a122 == 0){leave=0;}
                 int a18=result.getInt("loan");
                if(a18 == 0){loan=0;}
            PreparedStatement pst1= con.prepareStatement("replace into fields values('1','"+dep+"','"+emp+"','"+shft+"','"+leave+"','"+loan+"','"+manual+"','"+attendan+"','"+payro+"')");                             // Create statement
           pst1.executeUpdate();    
                  abcd as=new abcd();
                int a1=result.getInt("admin");
                if(a1 == 0){as.jMenuItem4.setEnabled(false);}
                int a2=result.getInt("data");
                if(a2 == 0){as.jMenuItem8.setEnabled(false);}
                int a3=result.getInt("path");
                if(a3 == 0){as.jMenuItem3.setEnabled(false);}
                int a4=result.getInt("machine");
                if(a4 == 0){as.jMenuItem7.setEnabled(false);}
                int a5=result.getInt("calculate");
                if(a5 == 0){as.jMenuItem13.setEnabled(false);}
                int a6=result.getInt("attendance");
                if(a6 == 0){as.jMenuItem5.setEnabled(false); } 
                int a7=result.getInt("payroll");
                if(a7 == 0){as.jMenuItem6.setEnabled(false); }
                int a8=result.getInt("depart");
                if(a8 == 0){as.jMenuItem9.setEnabled(false); }
                int a9=result.getInt("employee");
                if(a9 == 0){as.jMenuItem10.setEnabled(false); }
                int a10=result.getInt("shift");
                if(a10 == 0){as.jMenuItem11.setEnabled(false); }
                int a11=result.getInt("manual");
                if(a11 == 0){as.jMenuItem12.setEnabled(false);as.jMenuItem25.setEnabled(false); }
                int a12=result.getInt("leavemanage");
                if(a12 == 0){as.jMenuItem15.setEnabled(false); }
                int a13=result.getInt("import");
                if(a13 == 0){as.jMenuItem14.setEnabled(false);}
                int a14=result.getInt("help");
                if(a14 == 0){as.jMenuItem2.setEnabled(false);}
                  int a15=result.getInt("termin_emp");
                if(a15 == 0){as.jMenuItem19.setEnabled(false);}
                int a16=result.getInt("empRpt");
                if(a16 == 0){as.jMenuItem17.setEnabled(false);}
                int a17=result.getInt("holi");
                if(a17 == 0){as.jMenuItem22.setEnabled(false);}
                int a23=result.getInt("loan");
                if(a23 == 0){as.jMenuItem20.setEnabled(false);loan=0;}
                int a19=result.getInt("adva");
                if(a19 == 0){as.jMenuItem21.setEnabled(false);}
                int a20=result.getInt("finan");
                if(a20 == 0){as.jMenuItem18.setEnabled(false);}
                int a21=result.getInt("mail");
                if(a21 == 0){as.jMenuItem23.setEnabled(false);}
                int a22=result.getInt("termemprpt");
                if(a22 == 0){as.jMenuItem17.setEnabled(false);}
            
               
           
               
                open=1;//as.setVisible(true);
            }
            else {error="Invalid Username or/and Password ";}
        }
        catch(Exception e)
        {
            error="Database Connection Error";
        }
        
         
        
    return open;
    }
 public String eror(){
return  error;}
 
 
 
}

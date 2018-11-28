
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mohsin
 */
public class dbclass {
    String url=null;
      String id=null;
      String pass=null;
    public String server(){
    String line=null;
   String ip="";
   
        try{
           String link="D://server.txt";
 
        //        FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(link);

      //       Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
        ip=line;
            }}catch(Exception e){}
        System.out.println(ip);
    url=ip;
        return ip;
    }//jdbc:mysql://localhost:3306/hrm
    public String serverid(){
    String line=null;
   String a=null;
        try{
            String link="D://serverid.txt";
 
               // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(link);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
      a=line;
            }}catch(Exception e){}
    System.out.println(a);
    id=a;
    return a;
    }
    public String serverpass(){
    String line=null;
   String a=null;
        try{
            String link="D://serverpass.txt";
 
               // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(link);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
        a=line;
            }}catch(Exception e){}
        System.out.println(a);
    pass=a;
        return a;
    }
   
}

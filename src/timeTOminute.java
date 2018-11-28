/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mohsin
 */
public class timeTOminute {
    public double parseTimeToMinutes(String hourFormat) {  
      
    double minutes = 0;  
    String[] split = hourFormat.split(":");  
      
    try {  
          
        minutes =( Double.parseDouble(split[0])*60)+Double.parseDouble(split[1])+(Double.parseDouble(split[2])/60);  
       
        return minutes;  
      
    } catch (Exception e) {  
        return 0;  
    } 
      
}  
}

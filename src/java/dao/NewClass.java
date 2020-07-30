/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/**
 *
 * @author Zafrul Hasan Nasim
 */
public class NewClass {
    public static void main(String[] args) {
       

Date date = new Date();
SimpleDateFormat DateFor = new SimpleDateFormat("MM/dd/yyyy");
String stringDate = DateFor.format(date);
System.out.println("Date Format with MM/dd/yyyy : "+stringDate);
DateFor = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
stringDate = DateFor.format(date);
System.out.println("Date Format with dd-M-yyyy hh:mm:ss : "+stringDate);
DateFor = new SimpleDateFormat("dd MMMM yyyy");
stringDate = DateFor.format(date);
System.out.println("Date Format with dd MMMM yyyy : "+stringDate);
DateFor = new SimpleDateFormat("dd MMMM yyyy zzzz");
stringDate = DateFor.format(date);
System.out.println("Date Format with dd MMMM yyyy zzzz : "+stringDate);
DateFor = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
stringDate = DateFor.format(date);
System.out.println("Date Format with E, dd MMM yyyy HH:mm:ss z :"+stringDate);

/*Date date = new Date();
                       SimpleDateFormat DateFor = new SimpleDateFormat("MM/dd/yyyy");
                       
                       DateFor = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
                        String stringDate = DateFor.format(date);
                       System.out.println(stringDate);*/
}
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import db.DBConnection;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zafrul Hasan Nasim
 */
@WebServlet(urlPatterns = {"/retrieve_image"})
public class retrieve_image extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nas=null;
        try {
            nas="imon";
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("select image from post where filename=nas");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 Blob blob = rs.getBlob("image");
         byte byteArray[] = blob.getBytes(1, (int)blob.length());
       
        
        response.setContentType("image/gif");
        OutputStream os = response.getOutputStream();
        os.write(byteArray);
        
       os.flush();
       os.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(retrieve_image.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(retrieve_image.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
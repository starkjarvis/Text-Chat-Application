package chat.java.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.Statement;

@MultipartConfig(maxFileSize = 16177215)

@Controller
public class UploadFile {
	
	@RequestMapping(value="/uploadFile", method=RequestMethod.GET)
	public ModelAndView uploadFileGET(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		ModelAndView model=new ModelAndView("uploadFile");
		return model;
	}
	
	@RequestMapping(value="/deletefile", method=RequestMethod.GET)
	public ModelAndView deletefileGET(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		ModelAndView model=new ModelAndView("uploadFile");
		String id=(request.getParameter("id"));
        
       
        try
        {    
        	try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","root");
        
            String sqlString = "delete FROM files WHERE id = '"+id+"'";
            PreparedStatement myStatement=conn.prepareStatement(sqlString);            
            int rs=myStatement.executeUpdate(sqlString);
            
            if (rs>0) 
            {
                request.setAttribute("fileDeletedY", "File has been deleted!");
               
            } else 
            {
            	 request.setAttribute("fileDeletedY", "File has been deleted!");
            }
            
            
            
        } catch (SQLException ex) {Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);} 
		return model;
	}
	
	@RequestMapping(value="/view_file", method=RequestMethod.GET)
	public ModelAndView viewFileGET(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		ModelAndView model=new ModelAndView("view_file");
		return model;
	}
	
	@RequestMapping(value="/uploadFile", method=RequestMethod.POST)
	public ModelAndView uploadFilePOST(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IllegalStateException, IOException, ServletException
	{
		ModelAndView model=null;
		Random rand = new Random();
        int  n = rand.nextInt(9999) + 1;
        String idTemp=(String.valueOf(n));

        InputStream inputStream = null;
        String title=(request.getParameter("title"));
        Part filePart = request.getPart("file_uploaded");
        
        if (filePart != null) 
        {
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            inputStream = filePart.getInputStream();
        }
        
        try 
        {
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","root");
            
            String sql = "INSERT INTO files (id, title, file) values (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, idTemp);
            statement.setString(2, title);
     
            if (inputStream != null) 
            {
                statement.setBinaryStream(3, inputStream, (int) filePart.getSize());
            }
            
            int row = statement.executeUpdate();
            if (row > 0) 
            {
                request.setAttribute("FileUploadedY", "File has been uploaded");
                model=new ModelAndView("uploadFile");
                conn.close();
                
               
            }
            else
            {
            	request.setAttribute("FileUploadedN", "File has NOT been uploaded");
                model=new ModelAndView("uploadFile");
                
                conn.close();
            }    

        }catch(Exception e){e.printStackTrace();}
        
		return model;
	}

}

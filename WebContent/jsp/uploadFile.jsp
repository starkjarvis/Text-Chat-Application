<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

    <!-- Plugin CSS -->
    <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

    <!-- Theme CSS -->
    <link href="css/creative.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload File</title>
</head>
<body background="img/blue.jpg" style="background-size:cover;">
	<jsp:include page="navigationBar.jsp"></jsp:include>
	<center>
	<h1>Share Files</h1>
	<br>
	<div class="container col-sm-12">
	<form method="post" action="uploadFile" enctype="multipart/form-data">
            
                <table class="table table-striped" border="1" width="25%" cellpadding="5">
                <center>
                    <thead> 
                            <th colspan="4"><center>Upload File</center></th>        
                    </thead>
                  
                    <tbody>
                        <tr>    
                            <td><center>Title :</center> </td>
                            <td><center><input placeholder="Title should be in form: sentby-filename-date-time . extension" class="form-control" type="text" name="title" size="40"></center></td>
                        </tr>
                        <tr>
                            <td><center>Choose File : </center></td>
                            <td><center><input class="btn" type="file" name="file_uploaded" /></center></td>
                        </tr>
                        <tr>
                            <td colspan="3"><center><input type="submit"  value="Upload" style="width:20%;" class="btn btn-md btn-primary btn-block" /></center></td>
                        </tr>
                    </tbody>  
                   </center>           
                </table>
            </center>
        </form>
       </div>
       
       <div class="container col-sm-12">
        <br><br><br>
        <table border="1" width="25%" class="table table-striped " cellpadding="5">
            <thead> 
               <th colspan="4"><center>Uploaded Files  (*Note: After Downloading the file, open the file in application as per given extension in the Title)</center></th>        
            </thead>
                <tbody>
                    <tr>
                        <td><center><b>Id</b></center><td><center><b>Title(sentby-filename-date-time.extension)</b></center></td><td><center><b>Download a file</b></center></td><td><center><b>Delete a file</b></center></td>
                    </tr>
                    
                    <%
                        try
                        {
                        	Class.forName("com.mysql.jdbc.Driver");
                        	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","root");
                            

                                String sqlString = "SELECT * FROM files";
                                Statement myStatement = conn.createStatement();
                                ResultSet rs=myStatement.executeQuery(sqlString);
                                
                                if(!rs.isBeforeFirst())
                                {
                                    %>
                                        <tr>
                                        <td colspan="4"><center><%out.print("No Files!"); %></center></td>
                                        </tr>
                                    <%
                                }    
                                
                                while(rs.next())
                                {   
                            %>
                                    <tr>
                                        <td><center><%out.print(rs.getString("id")); %></center></td>
                                        <td><center><%out.print(rs.getString("title")); %></center></td>
                                        <td><center><a href="view_file?id=<%out.print(rs.getString("id"));%>">Download</a></center></td>
                                        <td><center><a href="deletefile?id=<%out.print(rs.getString("id"));%>">Delete</a></center></td>
                                    </tr>
                            <%
                                }
                            %>
                            
                </tbody> 
        </table>
        </div>                    
                            <%
                                rs.close();
                                myStatement.close();
                                conn.close();
                        }catch(Exception e){e.printStackTrace();}    
                        
                    %>
                    </center>
</body>
</html>
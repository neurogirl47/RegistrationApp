<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.sql.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Spring Pet Clinic</title>
</head>
<body>
<center>
<h1>Welcome to Spring Pet Clinic!</h1>
<p>Please select the Owner you are searching for.</p>

        <FORM ACTION="search.jsp" METHOD="POST">
            Please enter the ID of the publisher you want to find:
            <BR>
            Owner Id: <INPUT TYPE="TEXT" NAME="id">
            <BR>
            <INPUT TYPE="SUBMIT" value="Submit">
        </FORM>
<%
    try {    
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3702/petclinic"
						+ "?verifyServerCertificate=false"
						+ "&useSSL=false" + "&requireSSL=false", "root",
				"password");
        
        Statement stmt = con.createStatement();
        String id = request.getParameter("id");
        
        ResultSet rsForOwners = 
                stmt.executeQuery("SELECT * FROM petclinic.Owners where id = ? "); 
        
      
	while (rsForOwners.next()) try{
		%>
		
		     <TABLE BORDER="1">
            <TR>
               <TH>ID</TH>
               <TH>First Name</TH>
               <TH>Last Name</TH>
               <TH>Address</TH>
               <TH>City</TH>
               <TH>Telephone</TH>
           </TR>
           <TR>
               <TD> <%= rsForOwners.getInt(1) %> </TD>
               <TD> <%= rsForOwners.getString(2) %> </TD>
               <TD> <%= rsForOwners.getString(3) %> </TD>
               <TD> <%= rsForOwners.getString(4) %> </TD>
               <TD> <%= rsForOwners.getString(5) %> </TD>
               <TD> <%= rsForOwners.getString(6) %> </TD>
           </TR>
       </TABLE>

    <%
    
	}catch (Exception ex){
		System.out.println("Error: " + ex);
	}
	
    
   	 catch (Exception e){
   		System.out.println("Error: " + e);
   	}
	
 	finally {
		con.close();
	} 
	
    
%>


</center>
</body>
</html>
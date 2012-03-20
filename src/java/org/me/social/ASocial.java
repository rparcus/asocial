/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.social;

import java.sql.*;


import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


/**
 *
 * @author Beento
 */
@WebService(serviceName = "ASocial")
public class ASocial {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        database db=new database();
        return username+":::"+password+":::"+db.checkLogin(username, password);
        /*if(db.checkLogin(username, password)){
            return "è andata!";
        }else{
            return "NON è andata";
        }*/
    } 
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "register")
    public String register(@WebParam(name = "username") String username, @WebParam(name = "email") String email, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        return "Sei un figo!";
    }
}

class database 
{
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    database()
    {
        try{

            //MAKE SURE YOU KEEP THE mysql_connector.jar file in java/lib folder
            //ALSO SET THE CLASSPATH
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/asocial_db","root","qweqweqwe");
            pst=con.prepareStatement("select * from user_authentication where username=? and password=?");
        }
        catch (Exception e) 
        {
                System.out.println(e);
        }
}
//ip:username,password
//return boolean
public Boolean checkLogin(String username,String password)
{
        try {

                pst.setString(1, username); //this replaces the 1st  "?" in the query for username
                pst.setString(2, password);    //this replaces the 2st  "?" in the query for password
                //executes the prepared statement
                rs=pst.executeQuery();
                if(rs.next())
                {
                        //TRUE if the query founds any corresponding data
                        return true;
                }
                else
                {
                        return false;
                }
        } catch (Exception e) {
                // TODO Auto-generated catch block
                System.out.println("error while validating"+e);
                return false;
        }
}
}

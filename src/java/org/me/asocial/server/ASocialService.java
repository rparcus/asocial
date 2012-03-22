package org.me.asocial.server;

import java.io.File;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

//@author Andrea

// **********************************************************
// ************************ CLASSES *************************
// **********************************************************

class Database 
{
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	Database()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/asocial_db","asocial_god","asocial");
		   }
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}

	protected String checkLogin(String usr,String pwd)
	{
		try {
                    String query="SELECT * FROM user_authentication WHERE username=? AND password=?";
                    pst=con.prepareStatement(query);
                    pst.setString(1, usr);
                    pst.setString(2, pwd);
                    rs=pst.executeQuery();
                    if(rs.next())
                    {
			return "Login effettuato!";
                    } else {
			return "Login errato!";
                    }
		} catch (Exception e) {
                    return "Errore: " + e;
		}
        }
        
        protected String sendPost(int userID, String postTitle, String postBody)
        {
                try {
                    String query="INSERT INTO `asocial_db`.`posts` (`post_id`, `post_date`, `post_title`, `post_body`, `user_id`)"
                                + "VALUES (NULL, CURRENT_TIMESTAMP,?,?,1)";
                    pst=con.prepareStatement(query);
                    pst.setString(1, postTitle);
                    pst.setString(2, postBody);                    
                    pst.executeUpdate();
                } catch (Exception e){
                    return "Errore! " + e;
                }
          return "Post inserito!";  
        }
        
        protected ResultSet getPost()
        {
                try {
                    String query="SELECT * FROM posts";
                    pst=con.prepareStatement(query);
                    rs=pst.executeQuery();
                } catch (Exception e) {
                    System.out.println("Errore: " + e);
                    return null;
                }
            return rs;
        }
}

class WriteXMLFile 
{
        String post_repo_xml="C:\\file.xml";
 
	protected void getXML() {
                Database db = new Database();
                ResultSet xrs=db.getPost();
                
            try {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                  
                Document doc = docBuilder.newDocument();
                Element post_root = doc.createElement("post_root");
                doc.appendChild(post_root);
                
                while (xrs.next()) {
                    String ptitle = xrs.getString("post_title");
                    String pbody = xrs.getString("post_body");
                    Timestamp pdate = xrs.getTimestamp("post_date");
                    int pid = xrs.getInt("post_id");
                    int uid = xrs.getInt("user_id");

 
                    Element post = doc.createElement("post");
                    post_root.appendChild(post);

                    Attr post_id = doc.createAttribute("post_id");
                    post_id.setValue(""+pid); // CACATA
                    post.setAttributeNode(post_id);

                    Attr user_id = doc.createAttribute("user_id");
                    user_id.setValue(""+uid); // CACATA
                    post.setAttributeNode(user_id);

                    Element post_date = doc.createElement("post_date");
                    post_date.appendChild(doc.createTextNode(""+pdate)); // CACATA
                    post.appendChild(post_date);

                    Element post_title = doc.createElement("post_title");
                    post_title.appendChild(doc.createTextNode(ptitle));
                    post.appendChild(post_title);

                    Element post_body = doc.createElement("post_body");
                    post_body.appendChild(doc.createTextNode(pbody));
                    post.appendChild(post_body);
                }
 
		// Scrive nel file XML
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(post_repo_xml));
 		
 		transformer.transform(source, result);
 
		System.out.println("File XML creato.");
 
	  } catch (SQLException ex) {
                System.out.println(ex);
        } catch (ParserConfigurationException pce) {
              System.out.println(pce);
	  } catch (TransformerException tfe) {
              System.out.println(tfe);
	  }
	}
}

// **********************************************************
// *************** WEB SERVICE ASocialService ***************
// **********************************************************

@WebService(serviceName = "ASocialService")
public class ASocialService {
    
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "loginRequest")
    public String loginRequest(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        //TODO: Authorization Checks
        Database db = new Database();
        return db.checkLogin(username,password);
    }

    @WebMethod(operationName = "setPost")
    public String sendPost(@WebParam(name = "userID") int userID, @WebParam(name = "postTitle") String postTitle, @WebParam(name = "postBody") String postBody) {
        //TODO: Authorization Checks
        Database db = new Database();
        String res=db.sendPost(userID, postTitle, postBody);
        WriteXMLFile xml = new WriteXMLFile();
        xml.getXML();
        return res;
    }
}

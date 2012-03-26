package org.me.asocial.server;


import java.io.File;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.*;



import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.net.URL;
import java.net.MalformedURLException;

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
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/asocial_db","root","qweqweqwe");
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
        
        protected String setPost(int userID, String postTitle, String postBody)
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
        
        protected String registrationRequest(String username, String password)
        {
                try {
                    String query="SELECT `user_authentication`.`username` FROM `asocial_db`.`user_authentication` WHERE `username`=?";
                    pst=con.prepareStatement(query);
                    pst.setString(1, username);
                    rs=pst.executeQuery();
                    if(rs.next()) {
                        return "Nome utente già in uso!";
                    }
                    pst.close();
                    query="INSERT INTO `asocial_db`.`user_authentication` (`username`, `password`, `user_id`)" 
                            + "VALUES (?, ?, NULL)";
                    pst=con.prepareStatement(query);
                    pst.setString(1, username);
                    pst.setString(2, password);
                    pst.executeUpdate();
                } catch (Exception e) {
                    return "Errore! " + e;
                }
                    return "Registrazione effettuata!";
        }
        
        protected ResultSet getPost()
        {
                try {
                    String query="SELECT * FROM posts ORDER BY `post_date` DESC";
                    pst=con.prepareStatement(query);
                    rs=pst.executeQuery();
                } catch (Exception e) {
                    System.out.println("Errore: " + e);
                    return null;
                }
            return rs;
        }
        
        protected String setComment(int userID, int postID, String commentBody)
        {
                try {
                    String query="INSERT INTO `asocial_db`.`post_comments` (`user_id`, `post_id`, `comment_id`, `comment_body`, `comment_date`)"
                                + "VALUES (1, ?, NULL, ?, CURRENT_TIMESTAMP)";
                    pst=con.prepareStatement(query);
                    pst.setInt(1, postID);
                    pst.setString(2, commentBody);                    
                    pst.executeUpdate();
                } catch (Exception e){
                    return "Errore! " + e;
                }
          return "Commento inserito!";  
        }
        
        protected ResultSet getComment()
        {
                try {
                    String query="SELECT * FROM post_comments ORDER BY `comment_date` ASC";
                    pst=con.prepareStatement(query);
                    rs=pst.executeQuery();
                } catch (Exception e) {
                    System.out.println("Errore: " + e);
                    return null;
                }
            return rs;
        }
}

class XMLPostFile 
{
        String post_repo_xml="C:\\xampp\\htdocs\\ASocialClient\\file.xml";
 
	protected boolean getXML() {
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

//                    Attr post_id = doc.createAttribute("post_id");
//                    post_id.setValue(""+pid); // CACATA
//                    post.setAttributeNode(post_id);
//
//                    Attr user_id = doc.createAttribute("user_id");
//                    user_id.setValue(""+uid); // CACATA
//                    post.setAttributeNode(user_id);
                    
                    Element post_id = doc.createElement("post_id");
                    post_id.appendChild(doc.createTextNode(""+pid)); // CACATA
                    post.appendChild(post_id);
                    
                    Element user_id = doc.createElement("user_id");
                    user_id.appendChild(doc.createTextNode(""+uid)); // CACATA
                    post.appendChild(user_id);

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
 
		return true;
                
 	  } catch (SQLException ex) {
                System.out.println(ex);
                return false;
        } catch (ParserConfigurationException pce) {
              System.out.println(pce);
              return false;
	  } catch (TransformerException tfe) {
              System.out.println(tfe);
              return false;
	  }
	}
}

// sostituisce un URL con il <a href= url>url</a>...
class URLInString 
{
    protected static String findURL(String[] args) {
        String s = args[0];
        // separa l'input per in per spazi ( un URL non ha spazi )
        String [] parts = s.split("\\s");
        String out = new String();

        // Cerca di covnertire ogni parte in un URL  
        for( String item : parts ) try {
            URL url = new URL(item);
            // Se possibile aggiunge le ancore
            out = out +"<a href=\"" + url + "\">"+ url + "</a> ";
        } catch (MalformedURLException e) {
            // se c'era un URL non era questo...
            //System.out.print( item + " " );
            out = out + item + " ";
        }

        return out;
    }
}

class XMLCommentsFile
{
        String post_repo_xml="C:\\xampp\\htdocs\\ASocialClient\\commentsfile.xml";
 
	protected boolean getXML() {
                Database db = new Database();
                ResultSet xrs=db.getComment();
                
            try {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                  
                Document doc = docBuilder.newDocument();
                Element comment_root = doc.createElement("comment_root");
                doc.appendChild(comment_root);
                
                while (xrs.next()) {
                    String cbody = xrs.getString("comment_body");
                    int cid = xrs.getInt("comment_id");
                    int uid = xrs.getInt("user_id");
                    int pid = xrs.getInt("post_id");
                    Timestamp cdate = xrs.getTimestamp("comment_date");
 
                    Element comment = doc.createElement("comment");
                    comment_root.appendChild(comment);

//                    Attr post_id = doc.createAttribute("post_id");
//                    post_id.setValue(""+pid); // CACATA
//                    comment.setAttributeNode(post_id);
//
//                    Attr user_id = doc.createAttribute("user_id");
//                    user_id.setValue(""+uid); // CACATA
//                    comment.setAttributeNode(user_id);
//                    
//                    Attr comment_id = doc.createAttribute("comment_id");
//                    user_id.setValue(""+cid); // CACATA
//                    comment.setAttributeNode(comment_id);
                    
                    Element post_id = doc.createElement("post_id");
                    post_id.appendChild(doc.createTextNode(""+pid)); // CACATA
                    comment.appendChild(post_id);
                    
                    Element user_id = doc.createElement("user_id");
                    user_id.appendChild(doc.createTextNode(""+uid)); // CACATA
                    comment.appendChild(user_id);
                    
                    Element comment_id = doc.createElement("comment_id");
                    comment_id.appendChild(doc.createTextNode(""+cid)); // CACATA
                    comment.appendChild(comment_id);
                  
                    Element comment_date = doc.createElement("comment_date");
                    comment_date.appendChild(doc.createTextNode(""+cdate)); // CACATA
                    comment.appendChild(comment_date);

                    Element comment_body = doc.createElement("comment_body");
                    comment_body.appendChild(doc.createTextNode(cbody));
                    comment.appendChild(comment_body);
                }
 
		// Scrive nel file XML
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(post_repo_xml));
 		
 		transformer.transform(source, result);
 
		return true;
                
 	  } catch (SQLException ex) {
                System.out.println(ex);
                return false;
        } catch (ParserConfigurationException pce) {
              System.out.println(pce);
              return false;
	  } catch (TransformerException tfe) {
              System.out.println(tfe);
              return false;
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
        Database db = new Database();
        return db.checkLogin(username,password);
    }
    
    @WebMethod(operationName = "registrationRequest")
    public String registrationRequest(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "pwconfirm") String pwconfirm) {
        Database db = new Database();
        if(password.equals(pwconfirm)) {
            return db.registrationRequest(username, password);
        }
        return "le password non corrispondono!";
    }

    @WebMethod(operationName = "setPost")
    public String setPost(@WebParam(name = "userID") int userID, @WebParam(name = "postTitle") String postTitle, @WebParam(name = "postBody") String postBody) {
        Database db = new Database();
        String res = db.setPost(userID, postTitle, postBody);
        return res;
    }

    @WebMethod(operationName = "updatePostXML")
    public boolean updatePostXML() {
        XMLCommentsFile xmlcom = new XMLCommentsFile();
        xmlcom.getXML();
        XMLPostFile xml = new XMLPostFile();
        boolean res = xml.getXML();
        return res;
    }

    @WebMethod(operationName = "setComment")
    public String setComment(@WebParam(name = "userID") int userID, @WebParam(name = "postID") int postID, @WebParam(name = "commentBody") String commentBody) {
        Database db = new Database();
        String res = db.setComment(userID, postID, commentBody);
        return res;
    }
}

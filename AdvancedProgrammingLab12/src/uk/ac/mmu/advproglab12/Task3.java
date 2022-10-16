package uk.ac.mmu.advproglab12;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Task3 {

	public static void main(String[] args) {
		
		try ( Connection c = DriverManager.getConnection("jdbc:sqlite:hygienedatabase.db")){
			
			try {
			
			DocumentBuilder db = DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder();
			Document doc = db.parse("w:/eclipse_2021/myworkspace/AdvancedProgrammingLab12/hygienelibrary/boltonhygiene.xml");
			System.out.println("Bolton hygiene");
			
			Element root = doc.getDocumentElement();
			NodeList titleNodes = root.getElementsByTagName("BusinessName");
			NodeList titleNodesPC = root.getElementsByTagName("PostCode");
			NodeList titleNodesRV = root.getElementsByTagName("RatingValue");
			
			for(int i=0;i<titleNodes.getLength();i++) {
					System.out.println(" Establishment:" + titleNodes.item(i).getTextContent() + " ,Postcode:" + titleNodesPC.item(i).getTextContent()  + " ,RatingValue" + titleNodesRV.item(i).getTextContent());
			
					PreparedStatement s = c.prepareStatement("INSERT INTO hygienedatabase (Name, Postcode, Rating) VALUES (?,?,?);"); 
					
					s.setString(1, titleNodes.item(i).getTextContent());
					s.setString(2, titleNodesPC.item(i).getTextContent());
					s.setString(3,titleNodesRV.item(i).getTextContent());
					
					s.execute();
			}
		
		}
		
		catch (ParserConfigurationException | SAXException | IOException e) {
			System.err.println("Error opening XML file: " + e);
		}
			}
		
		catch (SQLException se) {
			se.printStackTrace();
		}

	}
}

package uk.ac.mmu.advproglab12;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class BrokenRestaurantFinder {

		
		public static void main(String[] args) throws Exception {
			

			// TODO Auto-generated method stub
			DocumentBuilder db = DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder();
			Document doc = db.parse("w:/eclipse_2021/myworkspace/AdvancedProgrammingLab12/hygienelibrary/boltonhygiene.xml");
			
			Element root = doc.getDocumentElement();
			NodeList establishments = root.getElementsByTagName("EstablishmentDetail");
			
			for(int i=0;i<establishments.getLength();i++) {
				Element e = (Element) establishments.item(i);
				
				NodeList postcodes = e.getElementsByTagName("PostCode");
				if ( postcodes.getLength() == 0 ) {
					System.out.println(e.getElementsByTagName("BusinessName").item(0).getTextContent());
				}
				
			}
		}

}

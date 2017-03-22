import java.io.File;
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

public class WriteXMLFile {

	DocumentBuilderFactory docFactory = null;
	DocumentBuilder docBuilder = null;
	Document doc = null;
	Element element = null;
	StreamResult xmlFile = null;
	TransformerFactory transformerFactory = null;
	Transformer transformer = null;
	DOMSource source = null;
	
	public Element CreateRootElement(String str)
	{
		// root elements
		element = doc.createElement(str);
		doc.appendChild(element);
		return element;
	}
	
	public Element CreateChildElement(Element parent,String str)
	{
		// root elements
		element = doc.createElement(str);
		parent.appendChild(element);
		return element;
	}
	
	public Attr CreateAttribute(Element ele, String attrs, String value)
	{
		// root elements
		Attr attr = doc.createAttribute(attrs);
		attr.setValue(value);
		ele.setAttributeNode(attr);
		return attr;
	}
	
	public Element CreateTextNode(Element parent,String nodeName,String text)
	{
		element = doc.createElement(nodeName);
		element.appendChild(doc.createTextNode(text));
		parent.appendChild(element);
		return element;
	}

	public WriteXMLFile (String filename)
	{
		try {
			docFactory = DocumentBuilderFactory.newInstance();
			docBuilder = docFactory.newDocumentBuilder();
			doc = docBuilder.newDocument();
			xmlFile = new StreamResult(new File(filename));
			transformerFactory = TransformerFactory.newInstance();
			transformer = transformerFactory.newTransformer();
			source = new DOMSource(doc);
		}
		catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void writeFile()
	{
		try{
			// Output to console for testing
			// StreamResult xmlFile = new StreamResult(System.out);
			transformer.transform(source, xmlFile);
		}catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
	
	
	
	
	public Document getDocument()
	{
		return doc;
	}
	
	public static void main(String argv[]) {

		WriteXMLFile w = new WriteXMLFile("file.xml");
		Element rootElement = w.CreateRootElement("Company");
		Element staff = w.CreateChildElement(rootElement,"Staff");
		rootElement.appendChild(staff);

		// set attribute to staff element
		w.CreateAttribute(staff,"id","1");
		
		// firstname elements
		w.CreateTextNode(staff,"firstname","Harish");
		
		// lastname elements
		w.CreateTextNode(staff,"lastname","Iyer");

		// nickname elements
		w.CreateTextNode(staff,"nickname","hariiyer");
		
		// salary elements
		w.CreateTextNode(staff,"salary","10000");
		
		// write the content into xml file
		w.writeFile();

		System.out.println("File saved!");
	  
	}
}
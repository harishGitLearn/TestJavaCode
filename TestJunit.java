import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.w3c.dom.Element;
import org.junit.BeforeClass;
import org.junit.AfterClass;

public class TestJunit {
   
   static WriteXMLFile testoutput = null;
   static Element root = null;
  
   @BeforeClass
   public static void beforeClass()
   {
	   testoutput = new WriteXMLFile("file.xml");
	   root = testoutput.CreateRootElement("TestHelloWorld");
   }
   
   @AfterClass
   public static void afterClass()
   {
	   testoutput.writeFile();
   }
      
   @Test
	public void testPrintMessageSuccess() {
	  
	  String message = "Harish";
	  HelloWorld hw = new HelloWorld(message);
	  Element element = testoutput.CreateChildElement(root,"Test_1");
      String str = hw.printMessage();
	  if(str != "Error" )
	  {
		  testoutput.CreateTextNode(element,"Result","Pass");
	  }
	  else
	  {
		  testoutput.CreateTextNode(element,"Result","Fail");
	  }
      //assertEquals("Junit is working fine",str);
   }
   
   @Test
   public void testPrintMessageFailure() {
	  
	  HelloWorld hw = new HelloWorld();
	  Element element = testoutput.CreateChildElement(root,"Test_2");
      String str = hw.printMessage();
	  if(str != "Error" )
	  {
		  testoutput.CreateTextNode(element,"Result","Pass");
	  }
	  else
	  {
		  testoutput.CreateTextNode(element,"Result","Fail");
	  }
      //assertEquals("Junit is working fine",str);
   }
   
}
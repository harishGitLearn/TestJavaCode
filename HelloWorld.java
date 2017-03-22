/**
 *
 * @author harishi
 */
public class HelloWorld {

	String message = null;
    
	public HelloWorld(String msg){
		message = msg;
	}
	
	public HelloWorld()
	{
		message = null;
	}

	public String printMessage()
	{
		if(message != null) {
			System.out.println("Hello " + message);
			return message;
		}
		else
			return "Error";
	}		
	
	/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello World");
	}
	
	
}

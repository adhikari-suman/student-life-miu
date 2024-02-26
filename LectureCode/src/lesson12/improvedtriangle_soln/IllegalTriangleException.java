package lesson12.improvedtriangle_soln;
public class IllegalTriangleException extends Exception {
	
	
	

	public IllegalTriangleException (){
		super();
	}
	
	public IllegalTriangleException (String msg){
		super("IllegalTriangleException thrown: "+msg);
	}
	
	private static final long serialVersionUID = 1L;

}

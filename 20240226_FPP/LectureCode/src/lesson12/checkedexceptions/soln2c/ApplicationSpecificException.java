package lesson12.checkedexceptions.soln2c;

public class ApplicationSpecificException extends Exception {

	public ApplicationSpecificException(String message) {
		super(message);
	}
	public ApplicationSpecificException() {
		super();
	}

}

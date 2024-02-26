package lesson12.old_checkedexceptions.soln2c;

public class ApplicationSpecificException extends Exception {

	public ApplicationSpecificException(String message) {
		super(message);
	}
	public ApplicationSpecificException() {
		super();
	}

}

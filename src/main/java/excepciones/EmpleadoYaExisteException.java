package excepciones;

public class EmpleadoYaExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmpleadoYaExisteException(String message) {
		super(message);
	}

}

package excepciones;

public class DepartamentoNoEncontradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

  // Metodo constructor
  public DepartamentoNoEncontradoException(String message){
    super(message);
  }

}

package excepciones;

public class DepartamentoYaExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

  public DepartamentoYaExisteException(String message){
    super(message);
  }

}

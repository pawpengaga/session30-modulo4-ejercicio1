package interfaces;
import java.util.List;

import excepciones.EmpleadoNoEncontradoException;
import excepciones.EmpleadoYaExisteException;
import modelo.Empleado;

public interface IEmpleado {

  // El equivalente a resources :empleado
  public void crearEmpleado(Empleado emp) throws EmpleadoYaExisteException;
  public Empleado obtenerEmpleado(String rut) throws EmpleadoNoEncontradoException;
  public List<Empleado> listarEmpleados();
  public void actualizarEmplado(Empleado empleado);
  public void eliminarEmpleado(String rut) throws EmpleadoNoEncontradoException;

}

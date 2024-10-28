package interfaces;
import java.util.List;
import modelo.Empleado;

public interface IEmpleado {

  // El equivalente a resources :empleado
  public void crearEmpleado(Empleado emp);
  public Empleado obtenerEmpleado(String rut);
  public List<Empleado> listarEmpleados();
  public void actualizarEmplado(Empleado empleado);
  public void eliminarEmpleado(String rut);

}

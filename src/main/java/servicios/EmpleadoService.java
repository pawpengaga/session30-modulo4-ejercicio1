package servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interfaces.IEmpleado;
import modelo.Empleado;

public class EmpleadoService implements IEmpleado {

  private Map<String, Empleado> empleados = new HashMap<>(); // empleados = {"11.222.333-4": Empleado@3544obj}

  @Override
  public void crearEmpleado(Empleado emp) {
    // El map no acepta datos repetidos, solo una persona por rut
    empleados.put(emp.getRut(), emp);
    System.out.println("Empleado creado con exito!!!!");
  }

  @Override
  public Empleado obtenerEmpleado(String rut) {
    // Obtener por el rut particular
    return empleados.get(rut);
  }

  @Override
  public List<Empleado> listarEmpleados() {
    return new ArrayList<>(empleados.values());
  }

  @Override
  public void actualizarEmplado(Empleado empleado) {
    // Verificar que el empleado exista
    if(empleados.containsKey(empleado.getRut())){
      empleados.put(empleado.getRut(), empleado);
      System.out.println("Empleado actualizado con exito!!");
    } else {
      System.out.println("EMPLEADO NO ENCONTRADO.");
    }
  }

  @Override
  public void eliminarEmpleado(String rut) {
    // Podemos usar el metodo anterior
    if (empleados.containsKey(rut)){
      empleados.remove(rut);
      System.out.println("Empleado eliminado con exito");
    } else {
      System.out.println("EMPLEADO NO ENCONTRADO.");
    }
  }

}

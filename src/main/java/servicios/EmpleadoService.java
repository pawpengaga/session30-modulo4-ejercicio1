package servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import excepciones.EmpleadoNoEncontradoException;
import excepciones.EmpleadoYaExisteException;
import interfaces.IEmpleado;
import modelo.Empleado;

public class EmpleadoService implements IEmpleado {

  private Map<String, Empleado> empleados = new HashMap<>(); // empleados = {"11.222.333-4": Empleado@3544obj}

  @Override
  public void crearEmpleado(Empleado emp) throws EmpleadoYaExisteException {

    // Si el conjunto de datos contiene este valor
    if(empleados.containsKey(emp.getRut())){
      throw new EmpleadoYaExisteException("El rut del nuevo empleado ya esta registrado.");
    }

    // El map no acepta datos repetidos, solo una persona por rut
    empleados.put(emp.getRut(), emp);
    System.out.println();
    System.out.println("Empleado creado con exito!!!!");
    System.out.println();
  }

  @Override
  public Empleado obtenerEmpleado(String rut) throws EmpleadoNoEncontradoException {

    Empleado emp = empleados.get(rut);

    if(emp == null){
      throw new EmpleadoNoEncontradoException("RUT de empleado no encontrado...");
    }

    // Obtener por el rut particular
    return emp;
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
  public void eliminarEmpleado(String rut) throws EmpleadoNoEncontradoException {
    // Podemos usar el metodo anterior
    if (empleados.containsKey(rut)){
      empleados.remove(rut);
      System.out.println("Empleado eliminado con exito");
    } else {
      throw new EmpleadoNoEncontradoException("EMPLEADO NO ENCONTRADO...");
    }
  }

}

package servicios;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import interfaces.IDepartamento;
import modelo.Departamento;
import modelo.Empleado;

public class DepartamentoService implements IDepartamento {

  private Map<Integer, Departamento> departamentos = new HashMap<>();
  private EmpleadoService empleadoService = new EmpleadoService();

  @Override
  public void crearDepartamento(Departamento departamento) {
    // Se usa putput como en hamtaro
    departamentos.put(departamento.getIdDpto(), departamento);
    System.out.println("Departamento creado con exito!!");
  }

  @Override
  public Departamento obtenenerDepartamento(int id) {
    return departamentos.get(id);
  }

  @Override
  public List<Departamento> listaDepartamentos() {
    return new ArrayList<>(departamentos.values());
  }

  @Override
  public void actualizarDepartamento(Departamento departamento) {
    if(departamentos.containsKey(departamento.getIdDpto())){
      departamentos.put(departamento.getIdDpto(), departamento);
      System.out.println("Departamento actualizado con exito!!");
    } else {
      System.out.println("DEPARTAMENTO NO ENCONTRADO.");
    }
  }

  @Override
  public void eliminarDepartamento(int id) {
    if(departamentos.containsKey(id)){
      // Si hay un empleado que tenga dentro de sus datos del id de un departamento, es el que departamento tiene empleados
      // Por ende, no se va borrar.
      boolean tieneEmpleados = empleadoService.listarEmpleados().stream().anyMatch(e -> e.getDepartamento().getIdDpto() == id);
      // boolean tieneEmpleados = listaDepartamentos().stream().anyMatch(e -> e.getIdDpto() == id);
      if (tieneEmpleados){
        System.out.println("No se puede eliminar el departamento. Tiene empleados dentro.");
      } else {
        departamentos.remove(id);
        System.out.println("Departamento eliminado con exito!");
      }
    } else {
      System.out.println("DEPARTAMENTO NO ENCONTRADO.");
    }
  }

}

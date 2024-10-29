package servicios;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import excepciones.DepartamentoConEmpleadosException;
import excepciones.DepartamentoNoEncontradoException;
import excepciones.DepartamentoYaExisteException;
import interfaces.IDepartamento;
import modelo.Departamento;
public class DepartamentoService implements IDepartamento {

  private Map<Integer, Departamento> departamentos = new HashMap<>();
  private EmpleadoService empleadoService = new EmpleadoService();

  @Override
  public void crearDepartamento(Departamento departamento) throws DepartamentoYaExisteException {
    if(departamentos.containsKey(departamento.getIdDpto())){
      throw new DepartamentoYaExisteException("El id para el departamento ya existe...");
    }
    // Se usa putput como en hamtaro
    departamentos.put(departamento.getIdDpto(), departamento);
    System.out.println("Departamento creado con exito!!");
  }

  @Override
  public Departamento obtenenerDepartamento(int id) throws DepartamentoNoEncontradoException {
    Departamento dpto = departamentos.get(id);

    if(dpto == null){
      // Si dpto es null entonces no hay departamento...
      throw new DepartamentoNoEncontradoException("ID departamento no encontrado");
    }

    return dpto;
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
  public void eliminarDepartamento(int id) throws DepartamentoNoEncontradoException, DepartamentoConEmpleadosException {
    if(departamentos.containsKey(id)){
      // Si hay un empleado que tenga dentro de sus datos del id de un departamento, es el que departamento tiene empleados
      // Por ende, no se va borrar.
      boolean tieneEmpleados = empleadoService.listarEmpleados().stream().anyMatch(e -> e.getDepartamento().getIdDpto() == id);
      // boolean tieneEmpleados = listaDepartamentos().stream().anyMatch(e -> e.getIdDpto() == id);
      if (tieneEmpleados){
        throw new DepartamentoConEmpleadosException("No se puede eliminar el departamento. Tiene empleados dentro.");
      } else {
        departamentos.remove(id);
        System.out.println("Departamento eliminado con exito!");
      }
    } else {
      throw new DepartamentoNoEncontradoException("Departamento no encontrado por su id...");
    }
  }

}

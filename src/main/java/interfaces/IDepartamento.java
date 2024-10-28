package interfaces;

import java.util.List;

import modelo.Departamento;

public interface IDepartamento {

  // Esto se pudo haber hecho con objetos genericos
  // Pero lo que se estila es mantener la logica separada
  public void crearDepartamento(Departamento departamento);
  public Departamento obtenenerDepartamento(int id);
  public List<Departamento> listaDepartamentos();
  public void actualizarDepartamento(Departamento departamento);
  public void eliminarDepartamento(int id);
  
}

package modelo;

public class Empleado {

  private String rut;
  private String nombre;


  private Departamento departamento;
  private Contrato contrato;

  public Empleado(String rut, String nombre, Departamento departamento, Contrato contrato) {
    this.rut = rut;
    this.nombre = nombre;
    this.departamento = departamento;
    this.contrato = contrato;
  }

  public String getRut() {
    return this.rut;
  }

  public void setRut(String rut) {
    this.rut = rut;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Departamento getDepartamento() {
    return this.departamento;
  }

  public void setDepartamento(Departamento departamento) {
    this.departamento = departamento;
  }

  public Contrato getContrato() {
    return this.contrato;
  }

  public void setContrato(Contrato contrato) {
    this.contrato = contrato;
  }


  @Override
  public String toString() {
    return "{" +
      " nombre='" + getNombre() + "'" +
      ", rut='" + getRut() + "'" +
      ", departamento='" + getDepartamento() + "'" +
      ", contrato='" + getContrato() + "'" +
      "}";
  }



}

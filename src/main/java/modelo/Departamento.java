package modelo;

public class Departamento {

  private int idDpto;
  private String nombre;
  private String area;


  public Departamento(int idDpto, String nombre, String area) {
    super();
    this.idDpto = idDpto;
    this.nombre = nombre;
    this.area = area;
  }


  public int getIdDpto() {
    return this.idDpto;
  }

  public void setIdDpto(int idDpto) {
    this.idDpto = idDpto;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getArea() {
    return this.area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  @Override
  public String toString() {
    return "{" +
      " idDpto='" + getIdDpto() + "'" +
      ", nombre='" + getNombre() + "'" +
      ", area='" + getArea() + "'" +
      "}";
  }


  

}

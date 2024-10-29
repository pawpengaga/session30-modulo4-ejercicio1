package modelo;

import java.time.LocalDate;
// import java.util.Date;
import java.util.Date;

public class Contrato {

  private Date fechaContratacion;
  private int sueldo;
  private String responsabilidad;

  // Todos los enum en java deben ser publicos para poder ser accesados directamente
  public enum tipoContrato {PROYECTO, INDEFINIDO, PLAZO};

  tipoContrato tipo;

  private int duracionContrato;


  public Contrato(Date fecha, int sueldo, String responsabilidad, int duracionContrato, tipoContrato tipo) {
    this.fechaContratacion = fecha;
    this.sueldo = sueldo;
    this.responsabilidad = responsabilidad;
    this.duracionContrato = duracionContrato;
    this.tipo = tipo;
  }


  public Date getFechaContratacion() {
    return this.fechaContratacion;
  }

  public void setFechaContratacion(Date fechaContratacion) {
    this.fechaContratacion = fechaContratacion;
  }

  public int getSueldo() {
    return this.sueldo;
  }

  public void setSueldo(int sueldo) {
    this.sueldo = sueldo;
  }

  public String getResponsabilidad() {
    return this.responsabilidad;
  }

  public void setResponsabilidad(String responsabilidad) {
    this.responsabilidad = responsabilidad;
  }

  public int getDuracionContrato() {
    return this.duracionContrato;
  }

  public void setDuracionContrato(int duracionContrato) {
    this.duracionContrato = duracionContrato;
  }

  @Override
  public String toString() {
    return "{" +
      " fechaContratacion='" + getFechaContratacion() + "'" +
      ", sueldo='" + getSueldo() + "'" +
      ", responsabilidad='" + getResponsabilidad() + "'" +
      ", duracionContrato='" + getDuracionContrato() + "'" +
      "}";
  }

}

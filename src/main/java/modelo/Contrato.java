package modelo;

import java.time.LocalDate;

public class Contrato {

  private LocalDate fechaContratacion;
  private int sueldo;
  private String responsabilidad;

  // Todos los enum en java deben ser publicos para poder ser accesados directamente
  public enum tipoContrato {PROYECTO, INDEFINIDO, PLAZO};

  private LocalDate fechaFinalizacion;


  public Contrato(LocalDate fechaContratacion, int sueldo, String responsabilidad, LocalDate fechaFinalizacion) {
    this.fechaContratacion = fechaContratacion;
    this.sueldo = sueldo;
    this.responsabilidad = responsabilidad;
    this.fechaFinalizacion = fechaFinalizacion;
  }


  public LocalDate getFechaContratacion() {
    return this.fechaContratacion;
  }

  public void setFechaContratacion(LocalDate fechaContratacion) {
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

  public LocalDate getFechaFinalizacion() {
    return this.fechaFinalizacion;
  }

  public void setFechaFinalizacion(LocalDate fechaFinalizacion) {
    this.fechaFinalizacion = fechaFinalizacion;
  }



}

package vista;

import java.util.Scanner;

import modelo.Departamento;
import modelo.Contrato.tipoContrato;
import servicios.DepartamentoService;
import servicios.EmpleadoService;

public class EmpleadoApp {
  
  private static EmpleadoService empleadoService = new EmpleadoService();
  private static DepartamentoService departamentoService = new DepartamentoService();

  private static Scanner myscan = new Scanner(System.in);

  public static void main(String[] args) {

    boolean salir = false;

    while (!salir) {
      System.out.println("...................... MENU DE EMPLEADOS ......................");
      System.out.println("Ingrese la accion que quiera realizar");
      System.out.println("1. Crear departamento");
      System.out.println("2. Listar departamentos");
      System.out.println("3. Eliminar departamento");
      System.out.println("4. Crear empleado");
      System.out.println("5. Listar empleados");
      System.out.println("6. Eliminar empleado");
      System.out.println("7. Generar reporte");
      System.out.println("8. Salir");

      System.out.println();

      System.out.println("Ingrese una opcion");
      int opcion = myscan.nextInt();

      switch (opcion) {
        case 1 -> crearDepartamento();
        case 2 -> listarDepartamentos();
        case 3 -> eliminarDepartamentos();
        case 4 -> crearEmpleado();
        case 5 -> listarEmpleados();
        case 6 -> eliminarEmpleados();
      }
    }


  }
  private static Object eliminarEmpleados() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'eliminarEmpleados'");
  }
  private static Object listarEmpleados() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'listarEmpleados'");
  }
  private static void crearEmpleado() {
    System.out.println("Ingrese el RUT");
    String rut = myscan.nextLine();
    
    System.out.println("Ingrese el nombre");
    String nombre = myscan.nextLine();

    System.out.println("Ingrese el ID del departamento");
    int id = myscan.nextInt();

    Departamento dpto = departamentoService.obtenenerDepartamento(id);

    if (dpto == null){
      System.out.println("DEPARTAMENTO NO EXISTE.");
      return;
    }

    System.out.println("Fecha de contratacion (DD-MM-AAAA)");
    String fechaStr = myscan.nextLine();

    System.out.println("Ingrese el sueldo");
    int sueldo = myscan.nextInt();
    myscan.nextLine();

    System.out.println("Ingrese el cargo");
    String cargo = myscan.nextLine();

    System.out.println("Tipo de contrato");
    System.out.println("1. PROYECTO");
    System.out.println("2. INDEFINIDO");
    System.out.println("3. A PLAZO");

    int tipo = myscan.nextInt();
    tipoContrato tt;

    if (tipo == 1){
      tt = tipoContrato.PROYECTO;
    } else if (tipo == 2){
      tt = tipoContrato.INDEFINIDO;
    } else if (tipo == 3){
      tt = tipoContrato.PLAZO;
    }

    if (tt == tipoContrato.INDEFINIDO){
      int duracion = 0;
    } else {
      System.out.println("Duraccion");
      int duracion = myscan.nextInt();
    }

    System.out.println("Duracion");
    

  }
  private static void crearDepartamento(){
    System.out.println("Id del departamento");
    int id = myscan.nextInt();
    myscan.nextLine();

    System.out.println("Nombre del departamento");
    String nombre = myscan.nextLine();

    System.out.println("Area del departamento");
    String area = myscan.nextLine();
    
    departamentoService.crearDepartamento(new Departamento(id, nombre, area));
  }

  private static void listarDepartamentos(){
    departamentoService.listaDepartamentos();
  }

  private static void eliminarDepartamentos(){
    System.out.println("Id del departamento");
    int id = myscan.nextInt();
    myscan.nextLine();

    departamentoService.eliminarDepartamento(id);
  }
}

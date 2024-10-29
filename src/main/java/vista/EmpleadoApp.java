package vista;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
// import java.time.LocalDate;
// import java.time.ZoneId;
// import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import modelo.Contrato;
import modelo.Departamento;
import modelo.Empleado;
import modelo.Contrato.tipoContrato;
import servicios.DepartamentoService;
import servicios.EmpleadoService;

// Existe una clase llamada period para sacar la diferencia entre las fechas o_o

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
      myscan.nextLine();

      switch (opcion) {
        case 1 -> crearDepartamento();
        case 2 -> listarDepartamentos();
        case 3 -> eliminarDepartamentos();
        case 4 -> crearEmpleado();
        case 5 -> listarEmpleados();
        case 6 -> eliminarEmpleados();
        case 7 -> generarArchivo();
        case 8 -> salir = true;
      }
    }
  }
  private static void generarArchivo() {
    try (FileWriter writter = new FileWriter("empleados.csv")) {
      writter.append("Rut, Nombre, Departamento, Fecha Contratacion, Sueldo, Cargo\n");
      for (Empleado empleado : empleadoService.listarEmpleados()) {
        writter.append(empleado.getRut() + ", ")
        .append(empleado.getNombre() + ", ")
        .append(empleado.getDepartamento().getNombre() + ", ")
        .append(new SimpleDateFormat("dd-MM-yyyy").format(empleado.getContrato().getFechaContratacion()) + ", ")
        .append(empleado.getContrato().getSueldo() + ", ")
        .append(empleado.getContrato().getResponsabilidad() + "\n");
      }
    } catch (Exception e) {
      System.out.println("Error al generar archivo");
    }
  }
  private static void eliminarEmpleados() {
    System.out.println("Rut a eliminar");
    String rut = myscan.nextLine();
    empleadoService.eliminarEmpleado(rut);
  }
  private static void listarEmpleados() {
    empleadoService.listarEmpleados().forEach(System.out::println);
  }
  private static void crearEmpleado() {
    System.out.println("Ingrese el RUT");
    String rut = myscan.nextLine();
    
    System.out.println("Ingrese el nombre");
    String nombre = myscan.nextLine();

    System.out.println("Ingrese el ID del departamento");
    int id = myscan.nextInt();
    myscan.nextLine();

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
    myscan.nextLine();
    tipoContrato tt = null;

    if (tipo == 1){
      tt = tipoContrato.PROYECTO;
    } else if (tipo == 2){
      tt = tipoContrato.INDEFINIDO;
    } else if (tipo == 3){
      tt = tipoContrato.PLAZO;
    }

    int duracion;

    if (tt == tipoContrato.INDEFINIDO){
      duracion = 0;
    } else {
      System.out.println("Duraccion");
      duracion = myscan.nextInt();
      myscan.nextLine();
    }

    try {
      // LocalDate fechanueva = LocalDate.now();
      // DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      // String fechaFormateada = fechanueva.format(formateador);
      
      Date fecha = new SimpleDateFormat("dd-MM-yyyy").parse(fechaStr);
      // LocalDate fechaLocalDate = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
      System.out.println(fecha);
      System.out.println(fechaStr);
      Contrato contrato = new Contrato(fecha, sueldo, cargo, duracion, tt);
      Empleado empl = new Empleado(rut, nombre, dpto, contrato);
      empleadoService.crearEmpleado(empl);
    } catch (Exception e) {
      System.err.println("Error en el formato de la fecha");
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
    departamentoService.listaDepartamentos().forEach(System.out::println); // ._.
  }

  private static void eliminarDepartamentos(){
    System.out.println("Id del departamento");
    int id = myscan.nextInt();
    myscan.nextLine();

    departamentoService.eliminarDepartamento(id);
  }
}

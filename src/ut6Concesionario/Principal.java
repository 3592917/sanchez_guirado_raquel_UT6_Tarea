/**
 * Clase Principal que contiene la lógica para:
 * 1. Nuevo Vehículo.
 * 2. Listar Vehículos.
 * 3. Buscar Vehículo.
 * 4. Modificar kms Vehículo.
 * 5. Salir.
 *
 * @author Raquel Sánchez Guirado
 */
package ut6Concesionario;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static final String OPCION_1 = "1. Nuevo Vehículo.";
    public static final String OPCION_2 = "2. Listar Vehículos.";
    public static final String OPCION_3 = "3. Buscar Vehículo.";
    public static final String OPCION_4 = "4. Modificar kms Vehículo.";
    public static final String OPCION_5 = "5. Salir.";
    public static final String SALTO_LINEA = "\n";

    public static final String RETURN_0 = "Vehículo creado correctamente";
    public static final String RETURN_1 = "Concesionario lleno, el máximo son 50 vehículos";
    public static final String RETURN_2 = "El vehículo con la matrícula introducida ya existe";
    public static final String RETURN_3 = "El vehículo no cumple con el formato de DNI, matrícula o nombre del propietario";


    private static void mostrarMenu() {
        System.out.println("Seleccione una opción: " + SALTO_LINEA +
                OPCION_1 + SALTO_LINEA +
                OPCION_2 + SALTO_LINEA +
                OPCION_3 + SALTO_LINEA +
                OPCION_4 + SALTO_LINEA +
                OPCION_5 + SALTO_LINEA);
    }

    Scanner sc = new Scanner(System.in);
    Concesionario concesionario = new Concesionario();

    private void nuevoVehiculo() {
            System.out.println("Introduzca marca: ");
            String entradaMarca = sc.nextLine();

            System.out.println("Introduzca matrícula: ");
            String entradaMatricula = sc.nextLine();

            System.out.println("Introduzca nº de kilómetros: ");
            int entradaKm = sc.nextInt();
            sc.nextLine();

            System.out.println("Introduzca fecha matriculación: ");
            System.out.println("Día: ");
            int entradaDia = sc.nextInt();
            sc.nextLine();
            System.out.println("Mes: ");
            int entradaMes = sc.nextInt();
            sc.nextLine();
            System.out.println("Año: ");
            int entradaAnnio = sc.nextInt();
            LocalDate entradaFecha = LocalDate.of(entradaAnnio, entradaMes, entradaDia);
            sc.nextLine();

            System.out.println("Introduzca descripción: ");
            String entradaDescripcion = sc.nextLine();

            System.out.println("Introduzca precio: ");
            Double entradaPrecio = sc.nextDouble();
            sc.nextLine();

            System.out.println("Introduzca nombre del propietario: ");
            String entradaNombre = sc.nextLine();

            System.out.println("Introduzca DNI del propietario: ");
            String entradaDNI = sc.nextLine();

            int resultado = concesionario.insertarVehiculo(entradaMarca, entradaMatricula, entradaKm, entradaFecha, entradaDescripcion, entradaPrecio, entradaNombre, entradaDNI);
            switch (resultado){
                case 0:
                    System.out.println(RETURN_0 + SALTO_LINEA);
                    break;
                case -1:
                    System.out.println(RETURN_1 + SALTO_LINEA);
                    break;
                case -2:
                    System.out.println(RETURN_2 + SALTO_LINEA);
                    break;
                case -3:
                    System.out.println(RETURN_3 + SALTO_LINEA);
                    break;
            }
    }

    private void listarVehiculos() {
        System.out.println(concesionario.listarVehiculos());
    }

    private void buscaVehiculo(String matricula){
        System.out.println(concesionario.buscaVehiculo(matricula));
    }

    public static void main(String[] args) {
        Principal principal = new Principal();
        mostrarMenu();

        Scanner sc = new Scanner(System.in);
        int entrada = sc.nextInt();

        do {
            switch (entrada) {
                case 1:
                    principal.nuevoVehiculo();
                    mostrarMenu();
                    entrada = sc.nextInt();
                    break;

                case 2:
                    principal.listarVehiculos();
                    mostrarMenu();
                    entrada = sc.nextInt();
                    break;
                case 3:
                    System.out.println("Introduzca matrícula: ");
                    String entradaMatricula = sc.nextLine();
                    principal.buscaVehiculo(entradaMatricula);
                    mostrarMenu();
                    entrada = sc.nextInt();
                    break;
                case 4:
                    mostrarMenu();
                    entrada = sc.nextInt();
                    break;
            }
        } while (entrada != 5);
    }
}
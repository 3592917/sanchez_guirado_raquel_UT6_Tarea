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
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Principal {

    public static final String OPCION_1 = "1. Nuevo Vehículo.";
    public static final String OPCION_2 = "2. Listar Vehículos.";
    public static final String OPCION_3 = "3. Buscar Vehículo.";
    public static final String OPCION_4 = "4. Modificar kms Vehículo.";
    public static final String OPCION_5 = "5. Eliminar Vehículo.";
    public static final String OPCION_6 = "6. Salir.";
    public static final String SALTO_LINEA = "\n";

    /**
     * Método para mostrar el menú en cada case del switch
     */
    private static void mostrarMenu() {
        System.out.println("Seleccione una opción: " + SALTO_LINEA +
                OPCION_1 + SALTO_LINEA +
                OPCION_2 + SALTO_LINEA +
                OPCION_3 + SALTO_LINEA +
                OPCION_4 + SALTO_LINEA +
                OPCION_5 + SALTO_LINEA +
                OPCION_6 + SALTO_LINEA);
    }

    Scanner sc = new Scanner(System.in);
    Concesionario concesionario = new Concesionario();

    /**
     * Método que recoge la información introducida por el usuario y realiza
     * la llamada al método de la clase para insertar un vehículo
     */
    private void nuevoVehiculo() {
        try {
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

            concesionario.insertarVehiculo(entradaMarca, entradaMatricula, entradaKm, entradaFecha, entradaDescripcion, entradaPrecio, entradaNombre, entradaDNI);
            System.out.println(SALTO_LINEA + "Vehículo creado correctamente" + SALTO_LINEA);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método que realiza la llamada al método de la clase que lista los vehículos
     * en caso de que dicha lista no esté vacía
     */
    private void listarVehiculos() {
        String listaVehiculos = concesionario.listarVehiculos();
        if (listaVehiculos.isEmpty()) {
            System.out.println("No hay vehículos en la lista" + SALTO_LINEA);
        } else {
            System.out.println(concesionario.listarVehiculos());
        }
    }

    /**
     * Método que recoge la matrícula introducida por el usuario y realiza la llamada
     * al método de la clase para realizar la búsqueda de un vehículo por matrícula
     * @param matricula
     */
    private void buscaVehiculo(String matricula){
        String vehiculoEncontrado = concesionario.buscaVehiculo(matricula);
        if (vehiculoEncontrado == null){
            System.out.println("No existe vehículo con la matrícula introducida");
        } else {
            System.out.println(concesionario.buscaVehiculo(matricula));
        }
    }

    /**
     * Método que recoge la matrícula y los km introducidos por el usuario y realiza
     * la llamada al método de la case para realizar la búsqueda y actualización del
     * vehículo, en caso de encontrarlo por matrícula
     * @param matricula
     * @param km
     */
    private void actualizaKm(String matricula, int km){
        boolean sePuedeActualizar = concesionario.actualizaKm(matricula, km);
        if (sePuedeActualizar) {
            System.out.println("Kilómetros actualizados correctamente" + SALTO_LINEA);
        } else {
            System.out.println("No se ha podido realizar la actualización" + SALTO_LINEA);
        }
    }

    /**
     * Método que recoge la matrícula introducida por el usuario y realiza la llamada
     * al método de la clase para eliminar dicho vehículo si lo encuentra por matrícula
     * @param matricula
     */
    private void eliminaVehiculo(String matricula){
        try {
            concesionario.eliminarVehiculo(matricula);
            System.out.println("El vehículo con matrícula "
                    + matricula
                    + " ha sido eliminado correctamente"
                    + SALTO_LINEA);

        } catch (NoSuchElementException s){
            System.out.println(s.getMessage());
        }
    }

    /**
     * Método principal que realiza la ejecución del programa
     * @param args
     */
    public static void main(String[] args) {
        Principal principal = new Principal();
        mostrarMenu();

        Scanner sc = new Scanner(System.in);
        int entrada = sc.nextInt();

        do {
            switch (entrada) {
                case 1:
                    System.out.println(OPCION_1 + SALTO_LINEA);
                    sc.nextLine();
                    principal.nuevoVehiculo();
                    mostrarMenu();
                    entrada = sc.nextInt();
                    break;

                case 2:
                    System.out.println(OPCION_2 + SALTO_LINEA);
                    principal.listarVehiculos();
                    mostrarMenu();
                    entrada = sc.nextInt();
                    break;

                case 3:
                    System.out.println(OPCION_3 + SALTO_LINEA);
                    sc.nextLine();
                    System.out.println("Introduzca matrícula: ");
                    String entradaMatricula = sc.nextLine();
                    principal.buscaVehiculo(entradaMatricula);
                    mostrarMenu();
                    entrada = sc.nextInt();
                    break;

                case 4:
                    System.out.println(OPCION_4 + SALTO_LINEA);
                    sc.nextLine();
                    System.out.println("Introduzca matrícula del vehículo que desea actualizar: ");
                    String entradaMatriculaKm = sc.nextLine();
                    System.out.println("Introduzca km que desea sumar al vehículo: ");
                    int entradaKmUpdate = sc.nextInt();
                    principal.actualizaKm(entradaMatriculaKm, entradaKmUpdate);
                    mostrarMenu();
                    entrada = sc.nextInt();
                    break;

                case 5:
                    System.out.println(OPCION_5 + SALTO_LINEA);
                    sc.nextLine();
                    System.out.println("Introduzca matrícula del vehículo a eliminar: ");
                    String entradaMatriculaEliminar = sc.nextLine();
                    principal.eliminaVehiculo(entradaMatriculaEliminar);
                    mostrarMenu();
                    entrada = sc.nextInt();
                    break;
            }
        } while (entrada != 6);
        sc.close();
    }
}
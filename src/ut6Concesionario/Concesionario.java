/**
 * Clase Concesionario
 * Métodos CRUD para gestionar la lista de vehículos
 *
 * @author Raquel Sánchez Guirado
 */
package ut6Concesionario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Concesionario {

    private final List<Vehiculo> vehiculos;

    private Integer numeroVehiculos;

    public Concesionario() {
        vehiculos = new ArrayList<>();
        numeroVehiculos = 0;
    }

    /**
     * Método para insertar un vehículo en el concesionario
     * Lista de parámetros que recibe para la inserción del objeto:
     * @param marca
     * @param matricula
     * @param kilometros
     * @param fechaMatriculacion
     * @param descripcion
     * @param precio
     * @param nombrePropietario
     * @param dniPropietario
     * @throws Exception -> Se lanza una excepción si fallan las validaciones
     */
    public void insertarVehiculo(String marca, String matricula,
                                 int kilometros,
                                 LocalDate fechaMatriculacion,
                                 String descripcion,
                                 Double precio,
                                 String nombrePropietario,
                                 String dniPropietario) throws Exception {

        Pattern matriculaPatron = Pattern.compile("\\d{4}[A-Z]{3}");
        Matcher m = matriculaPatron.matcher(matricula);

        if (!m.matches()) {
            throw new Exception("El vehículo no cumple con el formato de matrícula");
        }

        for (Vehiculo v : vehiculos) {
            if (v.getMatricula().equals(matricula)) {
                throw new Exception("El vehículo con la matrícula introducida ya existe");
            }
        }

        String[] cadenasNombre = nombrePropietario.split(" ");

        if (cadenasNombre.length < 3 && nombrePropietario.length() > 40) {
            throw new Exception("Debe introducir al menos un nombre y dos apellidos que no superen el máximo de 40 caracteres");
        }

        if (!dniPropietario.matches("\\d{8}[A-HJ-NP-TV-Z]")) {
            throw new Exception("El vehículo no cumple con el formato de DNI");
        }

        if (numeroVehiculos >= 50) {
            throw new Exception("Concesionario lleno, el máximo son 50 vehículos");
        }

        vehiculos.add(new Vehiculo(marca, matricula, kilometros, fechaMatriculacion, descripcion, precio, nombrePropietario, dniPropietario));
        numeroVehiculos++;

    }

    /**
     * Método que lista los vehículos del concesionario
     * @return Devuelve una lista de vehículos formateada con String Builder
     */
    public String listarVehiculos() {
        StringBuilder sb = new StringBuilder();
        for (Vehiculo v : vehiculos) {
            sb.append("Vehículo número ").append(vehiculos.indexOf(v) + 1).append("\n");
            sb.append("Marca: ").append(v.getMarca()).append("\n");
            sb.append("Matrícula: ").append(v.getMatricula()).append("\n");
            sb.append("Precio: ").append(v.getPrecio()).append("\n");
            sb.append("Kilómetros: ").append(v.getKilometros()).append("\n");
            sb.append("Descripción: ").append(v.getDescripcion()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Método que busca un vehículo en el concesarionario
     * @param matricula -> Parámetro por el que realiza la búsqueda
     * @return Devuelve el vehículo si lo encuentra formateado con String Builder
     */
    public String buscaVehiculo(String matricula) {
        StringBuilder sb = new StringBuilder();
        for (Vehiculo v : vehiculos) {
            if (v.getMatricula().equals(matricula)) {
                sb.append("Vehículo encontrado: \n");
                sb.append("Marca: ").append(v.getMarca()).append("\n");
                sb.append("Matrícula: ").append(v.getMatricula()).append("\n");
                sb.append("Precio: ").append(v.getPrecio()).append("\n");
                return sb.toString();
            }
        }
        return null;
    }

    /**
     * Método para actualizar los km de un vehículo
     * @param matricula -> Parámetro para buscar el vehículo
     * @param km -> Parámetro para introducir los km
     * @return -> Devuelve verdadero o falso en función de si se completa la actualización
     */
    public boolean actualizaKm(String matricula, int km) {
        for (Vehiculo v : vehiculos) {
            if (v.getMatricula().equals(matricula)) {
                v.setKilometros(v.getKilometros() + km);
                return true;
            }
        }
        return false;
    }

    /**
     * Método para eliminar un vehículo del concesionario
     * @param matricula -> Parámetro por el que busca el vehículo si existe
     * @throws NoSuchElementException -> Si no existe se lanza una excepción
     */
    public void eliminarVehiculo(String matricula) throws NoSuchElementException {
        boolean eliminado = vehiculos.removeIf(v -> v.getMatricula().equals(matricula));
        if (!eliminado) {
            throw new NoSuchElementException("El vehículo con la matrícula introducida no existe \n");
        }
    }
}

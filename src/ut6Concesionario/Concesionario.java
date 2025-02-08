/**
 * Clase Concesionario
 * @author Raquel Sánchez Guirado
 */
package ut6Concesionario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concesionario {

    private final List<Vehiculo> vehiculos;

    private Integer numeroVehiculos;

  /*  public void setNumeroVehiculos(Integer numeroVehiculos) {
        this.numeroVehiculos = numeroVehiculos;
    }
*/
 /*   public List<Vehiculo> getVehiculos(){
        return vehiculos;
    }

    public Integer getNumeroVehiculos(){
        return vehiculos.size();
    }
*/


    public Concesionario(){
        vehiculos = new ArrayList<>();
        numeroVehiculos = 0;
    }

    public Concesionario(List<Vehiculo> vehiculos){
        this.vehiculos = vehiculos;
    }

    /**
     *
     * @param marca
     * @param matricula
     * @param kilometros
     * @param fechaMatriculacion
     * @param descripcion
     * @param precio
     * @param nombrePropietario
     * @param dniPropietario
     */
    public int insertarVehiculo(String marca, String matricula,
     int kilometros,
     LocalDate fechaMatriculacion,
     String descripcion,
     Double precio,
     String nombrePropietario,
     String dniPropietario){
        if(!dniPropietario.matches("\\d{8}[A-HJ-NP-TV-Z]") ||
                !matricula.matches("\\d{4}[A-Z]{3}")){
            return - 3;
        }

        for (Vehiculo v : vehiculos){
            if(v.getMatricula().equals(matricula)){
                return -2;
            }
        }

        if (numeroVehiculos >= 50){
            return - 1;
        }

        vehiculos.add(new Vehiculo(marca, matricula, kilometros, fechaMatriculacion, descripcion, precio, nombrePropietario, dniPropietario));
        numeroVehiculos++;
        return 0;

    }

    public String buscaVehiculo(String matricula){
        StringBuilder sb = new StringBuilder();
        for (Vehiculo v : vehiculos){
            if (v.getMatricula().equals(matricula)){
               sb.append("Vehículos encontrado: \n")
                       .append(listarVehiculos());
                return sb.toString();
            }
        }
        return null;
    }

    public String listarVehiculos() {
        StringBuilder sb = new StringBuilder("Vehículos del concesionario: \n");
        for (Vehiculo v : vehiculos) {
            sb.append("\n").append("Vehículo número ").append(vehiculos.indexOf(v) + 1).append("\n");
            sb.append("Matrícula: ").append(v.getMatricula()).append("\n");
        }
        return sb.toString();
    }
}

/**
 * Clase Vehículo que gestiona los métodos y atributos del objeto
 * @author Raquel Sánchez Guirado
 */
package ut6Concesionario;

import java.time.LocalDate;

public class Vehiculo {
    private String marca;
    private String matricula;
    private int kilometros;
    private LocalDate fechaMatriculacion;
    private String descripcion;
    private Double precio;
    private String nombrePropietario;
    private String dniPropietario;

    public String getMarca() {
        return marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public Vehiculo(String marca,
                    String matricula,
                    int kilometros,
                    LocalDate fechaMatriculacion,
                    String descripcion,
                    Double precio,
                    String nombrePropietario,
                    String dniPropietario) {
        this.marca = marca;
        this.matricula = matricula;
        this.kilometros = kilometros;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaMatriculacion = fechaMatriculacion;
        this.nombrePropietario = nombrePropietario;
        this.dniPropietario = dniPropietario;
    }

}

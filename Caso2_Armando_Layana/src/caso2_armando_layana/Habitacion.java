/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caso2_armando_layana;

/**
 *
 * @author arjol
 */
public class Habitacion {
  
    
   public  int numeroHabitacion;
   public  String tipoHabitacion;
   public  double precioPorNoche;
   public  String estado;

    // Constructor para crear la habitacion.
    public Habitacion(int numeroHabitacion, String tipoHabitacion, double precioPorNoche, String estado) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.precioPorNoche = precioPorNoche;
        this.estado = estado;
    }
    
    // metodo para modificar datos 
    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    // Metodo para mostrar la info de la habitación.
    public String informacion() {
        return "Habitacion " + this.numeroHabitacion + " - Tipo: " + this.tipoHabitacion + 
               " (" + this.precioPorNoche + "$) - Estado: " + this.estado;
    }
}

   
    
    
    

    

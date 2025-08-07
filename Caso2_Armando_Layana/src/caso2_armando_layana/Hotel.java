package caso2_armando_layana;


import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



/**
 *
 * @author arjol
 */
public class Hotel{
    
    Habitacion[][] hotel;

    // Constructor que prepara el hotel.
    public Hotel() {
        int totalPisos = 5;
        int habitacionesPorPiso = 5;
        this.hotel = new Habitacion[totalPisos][habitacionesPorPiso];
        precargarHabitaciones();
    }
    
    // Rellena la matriz con habitaciones al inicio.
    private void precargarHabitaciones() {
        for (int piso = 0; piso < hotel.length; piso++) {
            for (int cuarto = 0; cuarto < hotel[piso].length; cuarto++) {
                int numeroCompleto = (piso + 1) * 100 + (cuarto + 1);
                String estado = "Libre";
                String tipo;
                double precio;
                if (cuarto % 2 == 0) {
                    tipo = "Simple";
                    precio = 50.0;
                } else {
                    tipo = "Doble";
                    precio = 80.0;
                }
                hotel[piso][cuarto] = new Habitacion(numeroCompleto, tipo, precio, estado);
            }
        }
    }

    // Llista de todas las habitaciones.
    public String obtenerVistaHotel() {
        String vistaCompleta = "Vista de habitaciones del hotel\n\n";
        for (int i = 0; i < hotel.length; i++) {
            vistaCompleta += "- Piso " + (i + 1) + " \n";
            for (int j = 0; j < hotel[i].length; j++) {
                vistaCompleta += hotel[i][j].informacion() + "\n";
            }
            vistaCompleta += "\n";
        }
        return vistaCompleta;
    }

    // Cambiar los datos de una habitacion.
    public void modificarHabitacion() {
        String numeroTexto = JOptionPane.showInputDialog("Ingrese el numero de la habitacion a modificar:");
        if (numeroTexto == null) {
            return; 
        }
        
        int numeroBuscado = Integer.parseInt(numeroTexto);

        Habitacion habitacionEncontrada = null;
        for (int i = 0; i < hotel.length; i++) {
            for (int j = 0; j < hotel[i].length; j++) {
                if (hotel[i][j].numeroHabitacion == numeroBuscado) {
                    habitacionEncontrada = hotel[i][j];
                    break;
                }
            }
            if (habitacionEncontrada != null) {
                break;
            }
        }

        if (habitacionEncontrada == null) {
            JOptionPane.showMessageDialog(null, " Habitacion no encontrada.");
            return;
        }

       
        String mensaje = "Que desea modificar para la habitacion " + numeroBuscado + "?\n\n" +
                         "1. Estado\n" +
                         "2. Tipo\n" +
                         "3. Precio";
        String eleccion = JOptionPane.showInputDialog(mensaje);

        if (eleccion == null) {
            return; 
        }
        
        
        switch (eleccion) {
            case "1": // Opcion para Estado
                String nuevoEstado = JOptionPane.showInputDialog("Ingrese el nuevo estado (Libre, Ocupada, Sucia):");
                if (nuevoEstado != null) {
                    habitacionEncontrada.setEstado(nuevoEstado);
                }
                break;
            case "2": // Opcion para Tipo
                String nuevoTipo = JOptionPane.showInputDialog("Ingrese el nuevo tipo (Simple, Doble):");
                if (nuevoTipo != null) {
                    habitacionEncontrada.setTipoHabitacion(nuevoTipo);
                }
                break;
            case "3": // Opcion para Precio
                String nuevoPrecioTexto = JOptionPane.showInputDialog("Ingrese el nuevo precio por noche:");
                if (nuevoPrecioTexto != null) {
                    double nuevoPrecioNumero = Double.parseDouble(nuevoPrecioTexto);
                    habitacionEncontrada.setPrecioPorNoche(nuevoPrecioNumero);
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcion no valida.");
                break;
        }
        
        // Este mensaje solo aparece si no hay errores.
        JOptionPane.showMessageDialog(null, "Habitacion " + numeroBuscado + " actualizada con exito.");
    }

    // Resumen de cuentas del hotel.
    public String obtenerResumen() {
        int libres = 0, ocupadas = 0, sucias = 0;
        double ganancia = 0.0;
        
        for (int i = 0; i < hotel.length; i++) {
            for (int j = 0; j < hotel[i].length; j++) {
                Habitacion habitacionActual = hotel[i][j];
                
                switch (habitacionActual.estado) {
                    case "Ocupada":
                        ocupadas++;
                        ganancia += habitacionActual.precioPorNoche;
                        break;
                    case "Sucia":
                        sucias++;
                        break;
                    default:
                        libres++;
                        break;
                }
            }
        }
        
        return "Resumen del estado del hotel\n\n" +
               "Habitaciones libres: " + libres + "\n" +
               "Habitaciones ocupadas: " + ocupadas + "\n" +
               "Habitaciones sucias: " + sucias + "\n\n" +
               "Ganancia actual por habitaciones ocupadas: $" + ganancia;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package caso2_armando_layana;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author arjol
 */
public class Caso2_Armando_Layana {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        Hotel miHotel = new Hotel();
        boolean salir = false;
        
        do {
            String opcionTexto = JOptionPane.showInputDialog(
                "Menu principal del hotel\n\n" +
                "1. Ver todas las habitaciones\n" +
                "2. Modificar una habitacion\n" +
                "3. Ver resumen del hotel\n\n" +
                "4. Salir"
            );

            if (opcionTexto == null) {
                salir = true;
            } else {
                 switch (opcionTexto) {
                    case "1":
                        // Ya no se usa JTextArea ni .setEditable.
                        String vista = miHotel.obtenerVistaHotel();
                        JOptionPane.showMessageDialog(null, vista);
                        break;

                    case "2":
                        miHotel.modificarHabitacion();
                        break;

                    case "3":
                        String resumen = miHotel.obtenerResumen();
                        JOptionPane.showMessageDialog(null, resumen);
                        break;

                    case "4":
                        JOptionPane.showMessageDialog(null, "Cerrando el sistema. Adios.");
                        salir = true;
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opcion no valida. Por favor, intente de nuevo.");
                        break;
                }
            }
        } while (!salir);
    }
}
    


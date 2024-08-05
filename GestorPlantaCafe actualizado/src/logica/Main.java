package logica;

import gui.Menu_Inicio;

/**
 * Clase principal para ejecutar la aplicación.
 * 
 * @autor josem
 */
public class Main {
    public static void main(String[] args) {
        // Crear una instancia de Menu_Inicio y mostrar la ventana
        Menu_Inicio pantalla = new Menu_Inicio();
        pantalla.setVisible(true);
        // La siguiente línea es redundante ya que está en el constructor de Menu_Inicio
        // pantalla.setLocationRelativeTo(null);
    }
}
/*EPD07-P
*/

package Principal;

import Interno.*;
import Vista.*;

/**
 *
 * @author José_Manuel_Fernández_Labrador
 */
public class Main {
    public static void main(String[] args) throws Exception{
            
        Almacen almacen = new Almacen();
        Controlador controlador = new Controlador(almacen);
        
        Pantalla pantalla = new Pantalla(controlador);
        
        pantalla.mostrarOpciones();
    }
}

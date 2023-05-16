
package swing.ejemplocompleto;

import java.io.Serializable;

/**
 *
 * @author cic
 */
public class Propietario implements Serializable {

    private String dni;
    private String nombre;
    private String telefono;

    public Propietario(String dni, String nombre, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Propietario{" + "dni=" + dni + ", nombre=" + nombre + ", telefono=" + telefono + '}';
    }
    
    
}

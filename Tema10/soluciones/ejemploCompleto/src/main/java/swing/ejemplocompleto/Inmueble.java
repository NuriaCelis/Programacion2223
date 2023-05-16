
package swing.ejemplocompleto;

/**
 *
 * @author cic
 */
public class Inmueble {

    private int id;
    private String direccion;
    private String localidad;
    private String anio;
    private int superficie;
    private String nifPropietario;
    private int precio;

    public Inmueble(String direccion, String localidad, String anio, int superficie, String nifPropietario, int precio) {
        this.direccion = direccion;
        this.localidad = localidad;
        this.anio = anio;
        this.superficie = superficie;
        this.nifPropietario = nifPropietario;
        this.precio = precio;
    }

     public Inmueble(int id, String direccion, String localidad) {
        this.id = id;
        this.direccion = direccion;
        this.localidad = localidad;
    }

    public int getId() {
        return id;
    }
    

    public String getDireccion() {
        return direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getAnio() {
        return anio;
    }

    public int getSuperficie() {
        return superficie;
    }

    public String getNifPropietario() {
        return nifPropietario;
    }

    public int getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Inmueble{" + "id=" + id + ", direccion=" + direccion + ", localidad=" + localidad + '}';
    }
    
    
}

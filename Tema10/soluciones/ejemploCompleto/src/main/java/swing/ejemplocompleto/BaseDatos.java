/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing.ejemplocompleto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author cic
 */
public class BaseDatos {

    private Connection conn = null; //atributo conexión
    // constantes a definir
    private static final String BD = "inmobiliaria2";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/" + BD;

    private BaseDatos() {

        try {
            Properties properties = new Properties();
            properties.setProperty("user", USUARIO);
            properties.setProperty("password", CLAVE);
            properties.setProperty("useSSL", "false");
            properties.setProperty("autoReconnect", "true");
            conn = (Connection) DriverManager.getConnection(URL, properties);
            if (conn == null) {
                System.out.println("Error en conexion");
            } else {
                System.out.println("Conexion correcta a: " + URL);
            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public static BaseDatos getInstance() {
        return BaseDatosHolder.INSTANCE;
    }

    private static class BaseDatosHolder {

        private static final BaseDatos INSTANCE = new BaseDatos();
    }

    // otros métodos
    // método obtener la conexión
    public Connection getConn() {
        return conn;
    }

    // 
    public Propietario seleccionPropietario(String dni) {
        Propietario p = null;
        String sql = "Select DNItitular,nombre,telefono from propietarios where DNItitular=?";
        try ( PreparedStatement sentencia = conn.prepareStatement(sql);) {
            sentencia.setString(1, dni);
            try ( ResultSet rs = sentencia.executeQuery();) {
                if (rs.next()) {
                    p = new Propietario(rs.getString(1), rs.getString(2), rs.getString(3));
                    System.out.println(p.toString());
                }
            }
        } catch (SQLException ex) {
            System.out.println("error al consultar seleccion propietario" + ex.toString());
        }
        return p;
    }

    //
    public void Insertar(Propietario p, Inmueble i) {
        int nPropietario = 0, nInmuebles = 0;
        if (seleccionPropietario(p.getDni()) == null) {
            // transaccion inserta ambos o ninguno
            String insertaP = "INSERT INTO propietarios(DNItitular,nombre,telefono)VALUES (?,?,?)";
            try ( PreparedStatement sentencia = conn.prepareStatement(insertaP);) {
                conn.setAutoCommit(false);
                sentencia.setString(1, p.getDni());
                sentencia.setString(2, p.getNombre());
                sentencia.setString(3, p.getTelefono());
                nPropietario = sentencia.executeUpdate();
                if (nPropietario != 1) {
                    throw new Exception("error al insertar Propietario");
                }

                String insertaI = "INSERT INTO inmuebles(direccion,localidad,annoconstruccion,superficiem2,NIFpropietario,precio) VALUES ( ?,?,?,?,?,?)";
                try ( PreparedStatement sentencia1 = conn.prepareStatement(insertaI);) {
                    sentencia1.setString(1, i.getDireccion());
                    sentencia1.setString(2, i.getLocalidad());
                    sentencia1.setString(3, i.getAnio());
                    sentencia1.setInt(4, i.getSuperficie());
                    sentencia1.setString(5, i.getNifPropietario());
                    sentencia1.setInt(6, i.getPrecio());
                    nInmuebles = sentencia1.executeUpdate();
                    if (nInmuebles != 1) {
                        throw new Exception("error al insertar en el inmueble");
                    }
                    JOptionPane.showMessageDialog(null, "Insertardos el propietario y el inmueble.", "Informativo", JOptionPane.INFORMATION_MESSAGE, null);
                    conn.commit();

                }
            } catch (Exception ex) {
                if (conn != null) {
                    try {
                        conn.rollback();
                    } catch (SQLException e) {
                        System.out.println("error al insertar en las tablas " + e.toString());
                    }
                }
               System.out.println("error al insertar en las tablas " + ex.toString());
            }
        }
        else{
            String insertaI = "INSERT INTO inmuebles(direccion,localidad,annoconstruccion,superficiem2,NIFpropietario,precio) VALUES ( ?,?,?,?,?,?)";
                try ( PreparedStatement sentencia1 = conn.prepareStatement(insertaI);) {
                    sentencia1.setString(1, i.getDireccion());
                    sentencia1.setString(2, i.getLocalidad());
                    sentencia1.setString(3, i.getAnio());
                    sentencia1.setInt(4, i.getSuperficie());
                    sentencia1.setString(5, i.getNifPropietario());
                    sentencia1.setInt(6, i.getPrecio());
                    nInmuebles = sentencia1.executeUpdate();
                    if (nInmuebles != 1) {
                        throw new Exception("error al insertar en el inmueble");
                    }
                    JOptionPane.showMessageDialog(null, "Insertardo el inmueble correctamente" , "Informativo", JOptionPane.INFORMATION_MESSAGE, null);

                }
                catch (Exception ex) {
                        System.out.println("error al insertar en inmueble " + ex.toString());
                    }
        }

    }
    //

    public ArrayList<Inmueble> consultaInmueblesDelPropietario(String id) {
        ArrayList<Inmueble> obj = new ArrayList<>();
        String sql = "select idinmueble,direccion,localidad,annoconstruccion,superficiem2,"
                + "NIFpropietario,precio from inmuebles where NIFpropietario=?";
        try ( PreparedStatement sentencia = conn.prepareStatement(sql);) {
            sentencia.setString(1, id);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                Inmueble inm = new Inmueble(rs.getInt(1), rs.getString(2), rs.getString(3));
                obj.add(inm);
            }
        } catch (SQLException ex) {
            System.out.println(" error en consulta inmueble propietario " + ex.toString());
        }
        return obj;
    }

    //
    public Object[][] consultaInmuebles(String loca) {
        Object[][] obj = null;
        PreparedStatement sentencia;
        try {

            String contador = "Select count(*) from inmuebles where localidad=?";
            sentencia = conn.prepareStatement(contador);
            sentencia.setString(1, loca);
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                int filas = rs.getInt(1);//devuelve cuantas filas tendra nuestra matriz
                rs.close();
                obj = new Object[filas][5];
                String sql = "select idinmueble,direccion,localidad,superficiem2,precio "
                        + "from inmuebles where localidad=?";
                sentencia = conn.prepareStatement(sql);
                sentencia.setString(1, loca);
                rs = sentencia.executeQuery();
                int i = 0;
                while (rs.next()) {
                    obj[i][0] = rs.getInt("idinmueble");
                    obj[i][1] = rs.getString("direccion");
                    obj[i][2] = rs.getString("localidad");
                    obj[i][3] = rs.getInt("superficiem2");
                    obj[i][4] = rs.getInt("precio");
                    i++;
                }
            }
            rs.close();
            sentencia.close();
        } catch (SQLException ex) {
            System.out.println(" error en consulta inmueble " + ex.toString());
        }
        return obj;
    }
    //

    public Object[][] consultaPropietarios() {
        Object[][] obj = null;
        PreparedStatement sentencia;
        try {
            String contador = "Select count(*) from propietarios";
            sentencia = conn.prepareStatement(contador);
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {

                int filas = rs.getInt(1);//devuelve cuantas filas tendra nuestra matriz
                rs.close();
                obj = new Object[filas][3];

                String sql = "SELECT DNItitular,nombre,telefono FROM propietarios";
                sentencia = conn.prepareStatement(sql);
                rs = sentencia.executeQuery();
                int i = 0;
                while (rs.next()) {
                    obj[i][0] = rs.getString("DNItitular");
                    obj[i][1] = rs.getString("nombre");
                    obj[i][2] = rs.getString("telefono");
                    i++;
                }
            }
            rs.close();
            sentencia.close();
        } catch (SQLException ex) {
            System.out.println(" error en la consulta de propietarios" + ex.toString());
        }
        return obj;
    }

    public ArrayList<Propietario> consultarPropietarios() {
        Propietario p = null;
        ArrayList<Propietario> lista = new ArrayList<>();
        String sql = "SELECT DNItitular,nombre,telefono FROM propietarios";
        try ( PreparedStatement sentencia = conn.prepareStatement(sql);) {
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                p = new Propietario(rs.getString(1), rs.getString(2), rs.getString(3));

                lista.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("error al consultar propietarios arraylist" + ex.toString());
        }
        return lista;
    }
}

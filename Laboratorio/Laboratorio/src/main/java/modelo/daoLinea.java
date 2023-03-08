/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import controlador.clsLinea;
import modelo.daoLinea;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoLinea {

    private static final String SQL_SELECT = "SELECT codigo_linea, nombre_linea , estatus_linea FROM tbl_lineas";
    private static final String SQL_INSERT = "INSERT INTO tbl_lineas(nombre_linea, estatus_linea) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_lineas SET nombre_linea=?, estatus_linea=? WHERE codigo_linea = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_lineas WHERE codigo_linea=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT codigo_linea, nombre_linea, linea FROM tbl_lineas WHERE nombre_linea = ?";
    private static final String SQL_SELECT_ID = "SELECT codigo_linea, nombre_linea, estatus_linea FROM tbl_lineas WHERE codigo_linea = ?";    

    public List<clsLinea> consultaLineas() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsLinea> lineas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("codigo_linea");
                String nombre = rs.getString("nombre_linea");
                String estatus = rs.getString("estatus_linea");
                clsLinea linea = new clsLinea();
                linea.setIdLinea(id);
                linea.setNombreLinea(nombre);
                linea.setEstatusLinea(estatus);
                lineas.add(linea);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return lineas;
    }

    public int ingresaLineas(clsLinea linea) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, linea.getNombreLinea());
            stmt.setString(2, linea.getEstatusLinea());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaLineas(clsLinea linea) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, linea.getNombreLinea());
            stmt.setString(2, linea.getEstatusLinea());
            stmt.setInt(3, linea.getIdLinea());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarLineas(clsLinea linea) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, linea.getIdLinea());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsLinea consultaLineasPorNombre(clsLinea linea) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + linea);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, linea.getIdLinea());            
            stmt.setString(1, linea.getNombreLinea());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("codigo_linea");
                String nombre = rs.getString("nombre_linea");
                String estatus = rs.getString("estatus_linea");

                //linea = new clsLinea();
                linea.setIdLinea(id);
                linea.setNombreLinea(nombre);
                linea.setEstatusLinea(estatus);
                System.out.println(" registro consultado: " + linea);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return linea;
    }
    public clsLinea consultaLineasPorId(clsLinea linea) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + linea);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, linea.getIdLinea());            
            //stmt.setString(1, linea.getNombreLinea());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("codigo_linea");
                String nombre = rs.getString("nombre_linea");
                String estatus = rs.getString("estatus_linea");

                //linea = new clsLinea();
                linea.setIdLinea(id);
                linea.setNombreLinea(nombre);
                linea.setEstatusLinea(estatus);
                System.out.println(" registro consultado: " + linea);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return linea;
    }    
}

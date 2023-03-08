/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoLinea;
/**
 *
 * @author visitante
 */
public class clsLinea {
    private int IdLinea;
    private String NombreLinea;
    private String EstatusLinea;

    public clsLinea() {
    }
    
    public clsLinea(int IdLinea) {
        this.IdLinea = IdLinea;
    }    
    
    public clsLinea(String NombreLinea, String EstatusLinea) {
        this.NombreLinea = NombreLinea;
        this.EstatusLinea = EstatusLinea;
    }
    
    public clsLinea(int IdLinea, String NombreLinea, String EstatusLinea) {
        this.IdLinea = IdLinea;
        this.NombreLinea = NombreLinea;
        this.EstatusLinea = EstatusLinea;
    }    

    public int getIdLinea() {
        return IdLinea;
    }

    public void setIdLinea(int IdLinea) {
        this.IdLinea = IdLinea;
    }

    public String getNombreLinea() {
        return NombreLinea;
    }

    public void setNombreLinea(String NombreLinea) {
        this.NombreLinea = NombreLinea;
    }

    public String getEstatusLinea() {
        return EstatusLinea;
    }

    public void setEstatusLinea(String EstatusLinea) {
        this.EstatusLinea = EstatusLinea;
    }
    @Override
    public String toString() {
        return "clsLinea{" + "IdLinea=" + IdLinea + ", NombreLinea=" + NombreLinea + ", EstatusLinea=" + EstatusLinea + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsLinea getBuscarInformacionLineasPorNombre(clsLinea linea)
    {
        daoLinea daolinea = new daoLinea();
        return daolinea.consultaLineasPorNombre(linea);
    }
    public clsLinea getBuscarInformacionLineasPorId(clsLinea linea)
    {
        daoLinea daolinea = new daoLinea();
        return daolinea.consultaLineasPorId(linea);
    }    
    public List<clsLinea> getListadoLineas()
    {
        daoLinea daolinea = new daoLinea();
        List<clsLinea> listadoLineas = daolinea.consultaLineas();
        return listadoLineas;
    }
    public int setBorrarLineas(clsLinea linea)
    {
        daoLinea daolinea = new daoLinea();
        return daolinea.borrarLineas(linea);
    }          
    public int setIngresarLineas(clsLinea linea)
    {
        daoLinea daolinea = new daoLinea();
        return daolinea.ingresaLineas(linea);
    }              
    public int setModificarLinea(clsLinea linea)
    {
        daoLinea daolinea = new daoLinea();
        return daolinea.actualizaLineas(linea);
    }              
}

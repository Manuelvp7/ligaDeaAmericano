/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author manuel
 */
public interface interfazAdministrarMercancia {
    
    public void agregar(String categoria, String proveedor,String nombre, double precio,String nombreTienda,int existencias);
    public void borrar(String proveedor,String nombre,String tienda);
    public void actualizar(String categoria, String proveedor, String nombre, double precio, String nombreTienda,int existencias);
    public void cargarTablaMercancia();
    
}

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
         
    public void buscarProducto(String tienda,String argumentoDeBusqueda,int campo);
    public void buscarProducto(String tienda,String argumentoDeBusqueda1,String argumentoDeBusqueda2, int combinacion);    
    public void buscarProductoEnTodasLasTiendas(String argumentoDeBusqueda1,String argumentoDeBusqueda2);
    public void buscarProductoEnTienda(String tienda);
    
    public void regresar();
}

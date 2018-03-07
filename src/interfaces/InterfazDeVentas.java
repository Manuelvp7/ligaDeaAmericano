/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.Date;
import java.util.List;
import modelo.Articulo;




//[0],[nombre],[provedor],[categoria],[nombre,proveedor],[nombre,categoria],[proveedor,categoria],[nombre,proveedor,categoria]


public interface InterfazDeVentas {
	
        public void buscarProducto(String tienda,String argumentoDeBusqueda,int campo);
        
	
	public void buscarProducto(String tienda,String argumentoDeBusqueda1,String argumentoDeBusqueda2, int combinacion);
        
        public void buscarProductoEnTodasLasTiendas(String argumentoDeBusqueda1,String argumentoDeBusqueda2);
        
	
	public void registrarEmpleadoTieneVentas(String curpEmpleado,int idVenta,int anio,int trimestre);
        
	public void registrarRecordDeVentas(String nombreTienda,int idVenta,int anio,int trimestre
                ,double monto);

        public void registrarDetalleDeVenta(String nombreTienda,int idVenta,int anio,
                int trimestre,String nombreArticulo,String nombreProveedor,int piezasVendidas);
        
        public int calcularIdVenta(String tienda,int anio,int trimestre);
        
        public void actualizarExistencias(String tienda,String articulo,String Proveedor,int noPiezas);
}        

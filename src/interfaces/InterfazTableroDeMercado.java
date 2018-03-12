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
public interface InterfazTableroDeMercado {
    
    public void cargarTablaDeVentas(String tienda,int anio,int trimestre,int criterioDeBusqueda);
    public void cargarTablaDeVendedores(String tienda,int anio,int trimestre,int criterioDeBusqueda);
    public void regresarAlPanelPadre();
    public void irA();
    
    
    
    
    
    
    
}

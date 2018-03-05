/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAOimpl.ArticuloDAOImpl;
import DAOimpl.CategoriaDAOImpl;
import DAOimpl.JugadorDAOImpl;
import DAOimpl.PersonaDAOImpl;
import DAOimpl.ProveedorDAOImpl;
import DAOimpl.TiendatienearticuloDAOImpl;
import interfaces.interfazAdministrarMercancia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Articulo;
import modelo.ArticuloKey;
import modelo.Categoria;
import modelo.Jugador;
import modelo.Proveedor;
import modelo.Tienda;
import modelo.Tiendatienearticulo;
import modelo.TiendatienearticuloKey;
import vista.PanelAdminDeMercancia;
import vista.panelAdminPlantilla;

/**
 *
 * @author manuel
 */
public class ControladorArticulo implements interfazAdministrarMercancia{
    
    private Articulo unArticulo;
    private Tienda unaTienda;
    private PanelAdminDeMercancia unPanelAdminDeMercancia;
    private ArticuloDAOImpl unArticuloDAOImpl;
    private CategoriaDAOImpl unaCategoriaDAOIMpl;
    private ProveedorDAOImpl unProveedorDAOImpl;
    private TiendatienearticuloDAOImpl unaTiendaTieneArticuloDAO;
    private Tiendatienearticulo unaTiendatienearticulo;
    Connection conn;
    
    
    
    public ControladorArticulo(){
        
            
        try{
			
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lmfa?autoReconnect=true&useSSL=false", "root" , "manolito130");
            if (conn!=null) {
                
                unArticulo = new Articulo();
                unaTienda = new Tienda();
                unPanelAdminDeMercancia = new PanelAdminDeMercancia(this);
                unArticuloDAOImpl = new ArticuloDAOImpl();
                unaCategoriaDAOIMpl = new CategoriaDAOImpl();
                unProveedorDAOImpl = new ProveedorDAOImpl();
                unaTiendaTieneArticuloDAO = new TiendatienearticuloDAOImpl();
                cargarComboCategorias();
                cargarComboProveedores();
                cargarTablaMercancia();
                
            
            }else{
                System.out.println("NO SE PUDO CARGAR LA CONEXION");
                        
            }

	}
	catch (Exception exc) {
            
            exc.printStackTrace();
	}
        
        
    }

    public void agregar(String categoria, String proveedor, String nombre, double precio, String nombreTienda,int existencias) {
        try {
            
            unArticulo = new Articulo(categoria, proveedor, nombre, precio);
            
            unArticuloDAOImpl.create(unArticulo, conn);
            
            unaTiendatienearticulo = new Tiendatienearticulo(nombre,proveedor,nombreTienda,existencias);

                    
            unaTiendaTieneArticuloDAO.create(unaTiendatienearticulo, conn);
            cargarTablaMercancia();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorArticulo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void cargarTablaMercancia() {
        
               
        try {
             List<Object[]> articulos;
            String tienda = unPanelAdminDeMercancia.getNombreTienda();
            articulos = unArticuloDAOImpl.load(tienda,conn);
            unPanelAdminDeMercancia.actualizarTabla(articulos);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorArticulo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cargarComboCategorias(){
        
        List<Categoria> categorias;
        try {
            categorias = unaCategoriaDAOIMpl.load(conn);
            if (categorias==null) {
                System.out.println("FUUUUUUUUUUCK");
            }
            unPanelAdminDeMercancia.cargarComboCategoria(categorias);
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorArticulo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
    }
    
        public void cargarComboProveedores(){
        
        List<Proveedor> proveedores;
        try {
            proveedores = unProveedorDAOImpl.load(conn);
            unPanelAdminDeMercancia.cargarComboProveedores(proveedores);
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorArticulo.class.getName()).log(Level.SEVERE, null, ex);
        }
        

       
        
    }
        
               
        public void mostrarPanelAdministrarArticulos(){
            
            unPanelAdminDeMercancia.setVisible(true);
        }
        
             
        public void ocultarPanelAdministrarArticulos(){
            
            unPanelAdminDeMercancia.setVisible(false);
        }

    @Override
    public void borrar(String proveedor, String nombre, String tienda) {
        
        try {
            TiendatienearticuloKey key = new TiendatienearticuloKey(proveedor, nombre, tienda);
            unaTiendaTieneArticuloDAO.delete(key, conn);
            cargarTablaMercancia();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorArticulo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actualizar(String categoria, String proveedor, String nombre, double precio, String nombreTienda, int existencias) {
        
            
            
        try {
            
            unaTiendatienearticulo = new Tiendatienearticulo(nombre,proveedor,nombreTienda,existencias);  
            System.out.println(unaTiendatienearticulo.toString());
            unaTiendaTieneArticuloDAO.update(unaTiendatienearticulo, conn);
            unArticulo = new Articulo(categoria, proveedor, nombre, precio);
            System.out.println(unArticulo.toString());
            unArticuloDAOImpl.update(unArticulo, conn);

            cargarTablaMercancia();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorArticulo.class.getName()).log(Level.SEVERE, null, ex);
        }
            

        
    }



 
        
    

    
    
    
    
    
}

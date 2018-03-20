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
import DAOimpl.TiendaDAOImpl;
import DAOimpl.TiendatienearticuloDAOImpl;
import interfaces.interfazAdministrarMercancia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Articulo;
import modelo.ArticuloKey;
import modelo.Categoria;
import modelo.Jugador;
import modelo.Proveedor;
import modelo.Tienda;
import modelo.Tiendatienearticulo;
import modelo.TiendatienearticuloKey;

import vista.panelAdminPlantilla;
import vista_jpanel.PanelAdminDeMercancia;

/**
 *
 * @author manuel
 */
public class ControladorPanelAdminDeMercancia implements interfazAdministrarMercancia{
    
    private interfaces.interfazAdministrarEquipo unaInterfazAdministrarEquipo;
    private Articulo unArticulo;
    private Tienda unaTienda;
    private PanelAdminDeMercancia unPanelAdminDeMercancia;
    private ArticuloDAOImpl unArticuloDAOImpl;
    private CategoriaDAOImpl unaCategoriaDAOIMpl;
    private ProveedorDAOImpl unProveedorDAOImpl;
    private TiendatienearticuloDAOImpl unaTiendaTieneArticuloDAO;
    private Tiendatienearticulo unaTiendatienearticulo;
    private TiendaDAOImpl unaTiendaDaoImpl;
    private Connection conn;
    private TiendatienearticuloDAOImpl unaTiendatienearticuloDAOImpl;
    
    
    
    public ControladorPanelAdminDeMercancia(interfaces.interfazAdministrarEquipo unaInterfazAdministrarEquipo){
        
            
        try{
			
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lmfa?autoReconnect=true&useSSL=false", "root" , "manolito130");
            if (conn!=null) {
                
                
                this.unaInterfazAdministrarEquipo = unaInterfazAdministrarEquipo;
                unArticulo = new Articulo();
                unaTienda = new Tienda();
                unPanelAdminDeMercancia = new PanelAdminDeMercancia(this);
                unArticuloDAOImpl = new ArticuloDAOImpl();
                unaCategoriaDAOIMpl = new CategoriaDAOImpl();
                unProveedorDAOImpl = new ProveedorDAOImpl();
                unaTiendaDaoImpl = new TiendaDAOImpl();
                unaTiendatienearticuloDAOImpl = new TiendatienearticuloDAOImpl();
                
                cargarComboDeTiendas();
                cargarComboCategorias();
                cargarComboProveedores();
                //buscarProducto(String.valueOf(unPanelAdminDeMercancia.getNombreTienda()),null ,1);
                //cargarTablaMercancia();
                
            
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

            System.out.println("EL ARTICULO "+unaTiendatienearticulo.toString());
                
            unaTiendatienearticuloDAOImpl.create(unaTiendatienearticulo, conn);
            cargarTablaMercancia();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPanelAdminDeMercancia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void cargarTablaMercancia() {
        
               
        try {
             List<Object[]> articulos;
            String tienda = unPanelAdminDeMercancia.getNombreTienda();
            articulos = unArticuloDAOImpl.load(tienda,conn);
            if(articulos!=null)
                unPanelAdminDeMercancia.actualizarTabla(articulos);
            else{
                unPanelAdminDeMercancia.actualizarTabla(null);
                JOptionPane.showMessageDialog(null, "NO SE ENCONTRO EL ARTICULO");
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPanelAdminDeMercancia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void cargarTablaMercancia(List<Object[]> articulos) {   
            if(articulos!=null)
                unPanelAdminDeMercancia.actualizarTabla(articulos);
                        
            else{
                unPanelAdminDeMercancia.actualizarTabla(null);
                JOptionPane.showMessageDialog(null, "NO SE ENCONTRO EL ARTICULO");
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
            Logger.getLogger(ControladorPanelAdminDeMercancia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
    }
    
        public void cargarComboProveedores(){
        
        List<Proveedor> proveedores;
        try {
            proveedores = unProveedorDAOImpl.load(conn);
            unPanelAdminDeMercancia.cargarComboProveedores(proveedores);
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPanelAdminDeMercancia.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControladorPanelAdminDeMercancia.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControladorPanelAdminDeMercancia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
 
            

        
    }

    public void cargarComboDeTiendas(){
        List<Object[]> registros;
        try {
            registros = unaTiendaDaoImpl.loadNombreTiendas(conn);
            if(registros!=null){
                
                unPanelAdminDeMercancia.cargarComboDeTiendas(registros);
                
            }
                
            else 
                JOptionPane.showMessageDialog(null,"NO SE ENCONTRARON TIENDAS");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"NO SE ENCONTRARON TIENDAS");
        }
        
    }

    public PanelAdminDeMercancia getUnPanelAdminDeMercancia() {
        return unPanelAdminDeMercancia;
    }
    
        @Override
    public void buscarProducto(String tienda, String argumentoDeBusqueda, int campo) {
               try {
                   List<Object[]> losArticulos;
                   losArticulos=unArticuloDAOImpl.load(tienda, argumentoDeBusqueda, campo, conn);
                   if(losArticulos!=null)
                        cargarTablaMercancia(losArticulos);
                   else
                       cargarTablaMercancia(null);
               } catch (SQLException ex) {
                   Logger.getLogger(ControladorVenta.class.getName()).log(Level.SEVERE, null, ex);
               }
    }
    


    
    @Override
    
    public void buscarProducto(String laTienda, String argumentoDeBusqueda1, String argumentoDeBusqueda2, int combinacion) {
                       
        try {
                   
            List<Object[]> losArticulos;       
            losArticulos=unArticuloDAOImpl.load(laTienda, argumentoDeBusqueda1, argumentoDeBusqueda2, combinacion, conn);
                               
            if(losArticulos!=null)
            
                cargarTablaMercancia(losArticulos);
                
            else
            
                cargarTablaMercancia(null);
            
                   
               } catch (SQLException ex) {
                   Logger.getLogger(ControladorVenta.class.getName()).log(Level.SEVERE, null, ex);
               }
    }
       


    @Override
    public void buscarProductoEnTodasLasTiendas(String nombre, String proveedor) {
        JOptionPane cuadroDeDialogo = new JOptionPane();
        try {
            List<Object[]> lasTiendas;
            ArticuloKey key= new ArticuloKey(nombre,proveedor);       
            lasTiendas =
                    unaTiendatienearticuloDAOImpl.load(key, conn);
            if(lasTiendas!=null)
                JOptionPane.showMessageDialog(null, lasTiendas.toString());        
            else
                JOptionPane.showMessageDialog(null, "NO SE ENCONTRO EL ARTICULO");
            
               } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null, "NO SE ENCONTRO EL ARTICULO");
               }
    }
    
    public void regresar(){
        
        unaInterfazAdministrarEquipo.regresarAlPanelPadre();
        
        
    }

    @Override
    public void buscarProductoEnTienda(String tienda) {
        
                              
        try {
                   List<Object[]> losArticulos;
                   losArticulos=unArticuloDAOImpl.load(tienda,conn);
                   cargarTablaMercancia(losArticulos);
               } catch (SQLException ex) {
                   Logger.getLogger(ControladorVenta.class.getName()).log(Level.SEVERE, null, ex);

               }
        
    }
    
    
    
    
    
    
}

package control;

import DAOimpl.ArticuloDAOImpl;
import DAOimpl.CategoriaDAOImpl;
import DAOimpl.DetalledeventaDAOImpl;
import DAOimpl.EmpleadotieneventasDAOImpl;
import DAOimpl.ProveedorDAOImpl;
import DAOimpl.RecorddeventasDAOImpl;
import DAOimpl.TiendatienearticuloDAOImpl;

import interfaces.InterfazDeVentas;
import java.lang.reflect.GenericArrayType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Articulo;
import modelo.ArticuloKey;
import modelo.Categoria;
import modelo.Detalledeventa;
import modelo.Empleado;

import modelo.Empleadotieneventas;
import modelo.Proveedor;
import modelo.Recorddeventas;
import modelo.Tienda;
import modelo.Tiendatienearticulo;
import modelo.TiendatienearticuloKey;

import vista.PanelVentas;






public class ControladorVenta implements InterfazDeVentas{
	
           //MODELOS
	   
           private Empleadotieneventas unEmpleadotieneventas;
           private Articulo unArticulo;
           private Recorddeventas unRecorddeventas;
           private Detalledeventa unDetalledeventa;
           private Tiendatienearticulo unaTiendatienearticulo;
           
           
           
           
           /////DAO
           
           private ArticuloDAOImpl unArticuloDAOImpl;
           
           private EmpleadotieneventasDAOImpl unEmpleadotieneventasDAOImpl;
           private ProveedorDAOImpl unProveedorDAOImpl;
           private CategoriaDAOImpl unaCategoriaDAOImpl;
           private TiendatienearticuloDAOImpl unaTiendatienearticuloDAOImpl;
           private RecorddeventasDAOImpl unRecorddeventasDAOImpl;
           private DetalledeventaDAOImpl unDetalledeventaDAOImpl;
           
           
           
           
           //CONNECTION TO SQL
           private Connection conn;
           
           //PANEL
           private PanelVentas unPanelVentas;
                   
	
	
	public ControladorVenta() {
		
               try {
                   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lmfa?autoReconnect=true&useSSL=false", "root" , "manolito130");
                   if (conn!=null) {

                       
                       //MODELOS
                       
                       unEmpleadotieneventas = new Empleadotieneventas();
                       unArticulo  = new Articulo();
                       
                       
                       //DAOS
                       
                       unEmpleadotieneventasDAOImpl = new EmpleadotieneventasDAOImpl();
                       unArticuloDAOImpl = new ArticuloDAOImpl();
                       unProveedorDAOImpl = new ProveedorDAOImpl();
                       unaCategoriaDAOImpl = new CategoriaDAOImpl();
                       unaTiendatienearticuloDAOImpl = new TiendatienearticuloDAOImpl();
                       unRecorddeventasDAOImpl = new RecorddeventasDAOImpl();
                       unDetalledeventaDAOImpl = new DetalledeventaDAOImpl();
                       
                                              
                       //PANEL
                       unPanelVentas = new PanelVentas(this);
                       
                       cargarComboCategorias();
                       cargarComboProveedores();
                       
                   }
               } catch (SQLException ex) {
                   Logger.getLogger(ControladorVenta.class.getName()).log(Level.SEVERE, null, ex);
               }
		
	}
/*	
	public PanelVenta getPanelVenta(){
		
		return panelVenta;
	}
*/	
	







    @Override
    public void buscarProducto(String tienda, String argumentoDeBusqueda, int campo) {
               try {
                   List<Object[]> losArticulos;
                   losArticulos=unArticuloDAOImpl.load(tienda, argumentoDeBusqueda, campo, conn);
                   cargarTablaPorBusqueda(losArticulos);
               } catch (SQLException ex) {
                   Logger.getLogger(ControladorVenta.class.getName()).log(Level.SEVERE, null, ex);
               }
    }


    @Override
    public void buscarProducto(String laTienda, String argumentoDeBusqueda1, String argumentoDeBusqueda2, int combinacion) {
                       
        try {
                   
            List<Object[]> losArticulos;       
            losArticulos=unArticuloDAOImpl.load(laTienda, argumentoDeBusqueda1, argumentoDeBusqueda2, combinacion, conn);
            cargarTablaPorBusqueda(losArticulos);
                   
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
            lasTiendas = unaTiendatienearticuloDAOImpl.load(key, conn);
            if(lasTiendas!=null)
                JOptionPane.showMessageDialog(unPanelVentas, lasTiendas.toString());
            else
                JOptionPane.showMessageDialog(unPanelVentas, "NO SE ENCONTRO EL ARTICULO");
               } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(unPanelVentas, "NO SE ENCONTRO EL ARTICULO");
               }
    }
    public void mostrarPanel(){
        
        unPanelVentas.setVisible(true);
    }
    
    public void cargarTablaPorBusqueda(List<Object[]> losArticulos){
        
            unPanelVentas.actualizarTabla(losArticulos);
       
    }
    
        public void cargarComboCategorias(){
        
        List<Categoria> categorias;
        try {
            categorias = unaCategoriaDAOImpl.load(conn);
            if (categorias==null) {
                System.out.println("FUUUUUUUUUUCK");
            }
            unPanelVentas.cargarComboCategoria(categorias);
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorArticulo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
    }
    
        public void cargarComboProveedores(){
        
        List<Proveedor> proveedores;
        try {
            proveedores = unProveedorDAOImpl.load(conn);
            unPanelVentas.cargarComboProveedores(proveedores);
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorArticulo.class.getName()).log(Level.SEVERE, null, ex);
        }
        

       
        
    }

    @Override
    public void registrarEmpleadoTieneVentas(String curpEmpleado, int idVenta, int anio, int trimestre) {
        


        try {
                                
            unEmpleadotieneventas = new Empleadotieneventas();
            unEmpleadotieneventas.setVendedorcurp(curpEmpleado);
            unEmpleadotieneventas.setIdventa(idVenta);
            unEmpleadotieneventas.setAnio(anio);
            unEmpleadotieneventas.setTrimestre(trimestre);

            unEmpleadotieneventasDAOImpl.create(unEmpleadotieneventas, conn);
            
             
        } catch (SQLException ex) {
        
            Logger.getLogger(ControladorVenta.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }

    @Override
    public void registrarRecordDeVentas(String nombreTienda, int idVenta, int anio, int trimestre, double monto) {
        
        unRecorddeventas = new Recorddeventas();
        unRecorddeventas.setNombretienda(nombreTienda);
        unRecorddeventas.setIdventa(idVenta);
        unRecorddeventas.setAnio(anio);
        unRecorddeventas.setTrimestre(trimestre);
        unRecorddeventas.setMonto(monto);
        
        System.out.println("        EL RECORD DE VENTAS " + unRecorddeventas.toString());
              
        try {
            
                  
            unRecorddeventasDAOImpl.create(unRecorddeventas, conn);
        
        } catch (SQLException ex) {
        
            System.out.println("NO SE PUDO CREAR EL RECORD DE VENTAS");
            
            
        }
    }

    @Override
    public void registrarDetalleDeVenta(String nombreTienda, int idVenta, int anio, int trimestre, String nombreArticulo,
            String nombreProveedor, int piezasVendidas) {
        
        unDetalledeventa = new Detalledeventa();
        unDetalledeventa.setAnio(anio);
        unDetalledeventa.setNombretienda(nombreTienda);
        unDetalledeventa.setIdventa(idVenta);
        unDetalledeventa.setTrimestre(trimestre);
        unDetalledeventa.setNombrearticulo(nombreArticulo);
        unDetalledeventa.setNombreproveedor(nombreProveedor);
        unDetalledeventa.setPiezasvendidas(piezasVendidas);
  
        try {
        
            unDetalledeventaDAOImpl.create(unDetalledeventa, conn);
            
        } catch (SQLException ex) {
        
            Logger.getLogger(ControladorVenta.class.getName()).log(Level.SEVERE, null, ex);
            
        }

    }

    public int calcularIdVenta(String tienda,int anio,int trimestre){
    
        System.out.println("CALCULANDO ID VENTA"+tienda+" "+anio+" "+trimestre);
        try {
        
            return unRecorddeventasDAOImpl.generarIDVenta(tienda, anio, trimestre, conn);

        } catch (SQLException ex) {
             
            Logger.getLogger(ControladorVenta.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
        return 0;
    
    }

    @Override
    public void actualizarExistencias(String tienda, String articulo, String proveedor, int noPiezas) {
        
        TiendatienearticuloKey key= new TiendatienearticuloKey(tienda, articulo, proveedor);
        int existencias = 0;
        
               try {
                   
                   unaTiendatienearticulo = unaTiendatienearticuloDAOImpl.load(key, conn);
                   existencias=unaTiendatienearticulo.getExistencias();
                   existencias-=noPiezas;
                   unaTiendatienearticulo.setExistencias(existencias);
                   unaTiendatienearticuloDAOImpl.update(unaTiendatienearticulo, conn);
                       
               } catch (SQLException ex) {
                   Logger.getLogger(ControladorVenta.class.getName()).log(Level.SEVERE, null, ex);
               }
        
    }
    
    


 
    




	

}

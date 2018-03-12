/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAOimpl.EmpleadotieneventasDAOImpl;
import DAOimpl.RecorddeventasDAOImpl;
import DAOimpl.TiendaDAOImpl;
import interfaces.InterfazLoginControl;
import interfaces.InterfazTableroDeMercado;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista_jpanel.PanelTableroDeMercado;

/**
 *
 * @author manuel
 */
public class ControladorTableroDeMercado implements InterfazTableroDeMercado {
    
    private Connection conn;
    private PanelTableroDeMercado unPanelTableroDeMercado; 
    private EmpleadotieneventasDAOImpl unEmpleadotieneventasDAOImpl;
    private RecorddeventasDAOImpl unRecorddeventasDAOImpl;
    private TiendaDAOImpl unaTiendaDAOImpl;
    
    
    private ControladorPersona unControladorPersona;
    private InterfazLoginControl unaInterfazLoginControl;

    
    
    
    public ControladorTableroDeMercado(InterfazLoginControl unaInterfazLoginCOntrol){
        
        try {
            
                
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lmfa?autoReconnect=true&useSSL=false", "root" , "manolito130");
            if(conn!=null){
                
                this.unaInterfazLoginControl = unaInterfazLoginCOntrol;

                
                                
                                    
                unControladorPersona = new ControladorPersona();
                unControladorPersona.setUnaInterfazTableroDeMercado(this);
                
                unEmpleadotieneventasDAOImpl = new EmpleadotieneventasDAOImpl();
                unRecorddeventasDAOImpl = new RecorddeventasDAOImpl();
                unaTiendaDAOImpl = new TiendaDAOImpl();
                unPanelTableroDeMercado = new PanelTableroDeMercado(this);
                unPanelTableroDeMercado.cargarTablas();
                cargarComboDeTiendas();
                
                
                
                
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorTableroDeMercado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public void cargarTablaDeVentas(String tienda, int anio, int trimestre, int criterioDeBusqueda) {
        
        try {
            List<Object[]> registros;
            registros = unRecorddeventasDAOImpl.loadRecord(tienda, anio, trimestre, criterioDeBusqueda, conn);
            if(registros!=null){
                System.out.println("LOS REGISTROS DE VENTAS "+registros);
                unPanelTableroDeMercado.cargarTablaDeVentas(registros);
            }   
            else
                JOptionPane.showMessageDialog(null, "NO HAY RECORD DE VENTAS PARA LA TIENDA "+ tienda );
                
        } catch (SQLException ex) {
            
        }
        
    }

    @Override
    public void cargarTablaDeVendedores(String tienda,int anio,int trimestre,int tipoDeBusqueda) {
        List<Object[]> registros;
        try {
            registros=unEmpleadotieneventasDAOImpl.loadResultadosConFiltro(tienda, anio, trimestre, tipoDeBusqueda, conn);
            if(registros!=null){
                
                                
                System.out.println("LOS VENDEDORES "+registros);
                unPanelTableroDeMercado.cargarTablaDeVendedores(registros);
                
            }

            else
                System.out.println("NO HAY REGISTRO DE TIENDAS");
                  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO HAY TIENDAS");
        }
        
    }
    
    public void cargarComboDeTiendas(){
        List<Object[]> registros;
        try {
            registros = unaTiendaDAOImpl.loadNombreTiendas(conn);
            if(registros!=null){
                
                unPanelTableroDeMercado.cargarComboDeTiendas(registros);
                
            }
                
            else 
                System.out.println("NO HAY COMBO DE TABLEROS");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"NO SE ENCONTRARON TIENDAS");
        }
        
    }

    public PanelTableroDeMercado getUnPanelTableroDeMercado() {
        return unPanelTableroDeMercado;
    }
    
    

 
      
    @Override
    public void regresarAlPanelPadre() {
        
        unaInterfazLoginControl.cambiarPanel(unPanelTableroDeMercado);
    }

    @Override
    public void irA() {
        
        unaInterfazLoginControl.cambiarPanel(unControladorPersona.getPanelUsuariosDelSistema());
        
    }

    
    
    
    
    
}

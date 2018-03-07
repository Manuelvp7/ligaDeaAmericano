/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAOimpl.ArticuloDAOImpl;
import DAOimpl.CategoriaDAOImpl;
import DAOimpl.EquipoDAOImpl;
import DAOimpl.PartidoDAOImpl;
import DAOimpl.ProveedorDAOImpl;
import DAOimpl.TiendatienearticuloDAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Articulo;
import modelo.Equipo;
import modelo.Partido;
import modelo.PartidoKey;
import modelo.Tienda;
import vista.PanelAdminDeLiga;
import vista.PanelAdminDeMercancia;

/**
 *
 * @author manuel
 */
public class ControladorPartido implements interfaces.InterfazAdministrarLigaDeAmericano{
    
    private Partido unPartido;
    private PartidoDAOImpl unPartidoDAOImpl;
    private PanelAdminDeLiga unPanelAdminDeLiga;
    private Connection conn;
    private EquipoDAOImpl unEquipoDAOImpl;
    
    public ControladorPartido(){
    
                   
        try{
			
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lmfa?autoReconnect=true&useSSL=false", "root" , "manolito130");
            if (conn!=null) {
                
                unPartido = new Partido();
                unPartidoDAOImpl = new PartidoDAOImpl();
                unPanelAdminDeLiga = new PanelAdminDeLiga(this);
                unEquipoDAOImpl = new EquipoDAOImpl();
                cargarEquipos();
                cargarTablaPartidos();
                
            
            }else{
                System.out.println("NO SE PUDO CARGAR LA CONEXION");
                        
            }

	}
	catch (Exception exc) {
            
            exc.printStackTrace();
	}
}

    @Override
    public void agregar(String temporada, int noJornada, String equipolocal, String equipovisitante, Date fecha, Date hora) {
        
        
        
        try {
            
            SimpleDateFormat hcn = new SimpleDateFormat("hh:mm"); 
            unPartido = new Partido(temporada, noJornada, equipolocal, equipovisitante, fecha, hora);
            unPartidoDAOImpl.create(unPartido, conn);
            
            cargarTablaPartidos();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPartido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

 


    
    public void cargarTablaPartidos() {
        
        
        try {
            List<Partido> partidos;
            partidos=unPartidoDAOImpl.load(conn);
            unPanelAdminDeLiga.actualizarTabla(partidos);
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPartido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cargarEquipos(){
        
        
        try {
            List<Equipo> equipos;
            equipos = unEquipoDAOImpl.load(conn);
            
            if (equipos==null) {
                System.out.println("FUUUUUUUK");
            }
            
            
            unPanelAdminDeLiga.cargarComboEquipos(equipos);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPartido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void mostrarPanel(){
        unPanelAdminDeLiga.setVisible(true);
    }
    
    public void ocultarPanel(){
        unPanelAdminDeLiga.setVisible(false);
    }

    @Override
    public void actualizar(String temporada, int noJornada, String equipolocal, String equipovisitante, Date fecha, Date hora, int ml, int mv) {
        
                    

        try {
                    
        
            unPartido = new Partido(temporada, noJornada, equipolocal, equipovisitante, fecha, hora);
            unPartido.setMarcadorlocal(ml);
            unPartido.setMarcadorvisitante(mv);
           
            unPartidoDAOImpl.update(unPartido, conn);
            cargarTablaPartidos();
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPartido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public void borrar(String temporada, int noJornada, String equipolocal, String equipovisitante) {
        
        
        try {
            PartidoKey pk= new PartidoKey(temporada, noJornada, equipolocal, equipovisitante);
            unPartidoDAOImpl.delete(pk, conn);
            cargarTablaPartidos();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPartido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    
}

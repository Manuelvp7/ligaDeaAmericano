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
import DAOimpl.RecorddeequipoDAOImpl;
import DAOimpl.TiendatienearticuloDAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import modelo.Articulo;
import modelo.Equipo;
import modelo.Partido;
import modelo.PartidoKey;
import modelo.Recorddeequipo;
import modelo.RecorddeequipoKey;
import modelo.Tienda;
import vista_jpanel.PanelAdminDeLiga;

import vista_jpanel.PanelAdminDeMercancia;

/**
 *
 * @author manuel
 */
public class ControladorPartido implements interfaces.InterfazAdministrarLigaDeAmericano{
    
    private Partido unPartido;
    private PartidoDAOImpl unPartidoDAOImpl;
    private RecorddeequipoDAOImpl unRecorddeequipoDAOImpl;
    
    private PanelAdminDeLiga unPanelAdminDeLiga;
    
    private Connection conn;
    private EquipoDAOImpl unEquipoDAOImpl;
    Recorddeequipo unRecordDeEquipo;
    
    public ControladorPartido(){
    
                   
        try{
			
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lmfa?autoReconnect=true&useSSL=false", "root" , "manolito130");
            if (conn!=null) {
                
                unPartido = new Partido();
                unRecorddeequipoDAOImpl = new RecorddeequipoDAOImpl();
                unPartidoDAOImpl = new PartidoDAOImpl();
                unPanelAdminDeLiga = new PanelAdminDeLiga(this);
                unEquipoDAOImpl = new EquipoDAOImpl();
                unRecordDeEquipo = new Recorddeequipo();
                cargarEquipos();
                cargarTablaPartidos();
                unPanelAdminDeLiga.setVisible(true);
                
            
            }else{
                System.out.println("NO SE PUDO CARGAR LA CONEXION");
                        
            }

	}
	catch (Exception exc) {
            
            exc.printStackTrace();
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
    public void actualizar(String temporada, int noJornada, String equipolocal, String equipovisitante, Date fecha, Date hora,
            int ml, int mv,boolean partidoFinalizado) {
        
                    

        try {
             
            int aux=0;
            
            RecorddeequipoKey keyLocal = new RecorddeequipoKey(temporada,equipolocal);
            RecorddeequipoKey keyVisitante = new RecorddeequipoKey(temporada,equipovisitante);
            
            Recorddeequipo recordEquipoLocal = new Recorddeequipo();
            Recorddeequipo recordEquipoVisitante = new Recorddeequipo();
            
            recordEquipoLocal = buscarRecordEquipo(keyLocal);
            recordEquipoVisitante = buscarRecordEquipo(keyVisitante);
                
            unPartido = new Partido(temporada, noJornada, equipolocal, equipovisitante, fecha, hora,partidoFinalizado);
            unPartido.setMarcadorlocal(ml);
            unPartido.setMarcadorvisitante(mv);
           
            unPartidoDAOImpl.update(unPartido, conn);
            
            if(ml>mv){
                aux = recordEquipoLocal.getPartidosganados();
                recordEquipoLocal.setPartidosganados(aux+1);
                unRecorddeequipoDAOImpl.update(recordEquipoLocal, conn);
                
                                
                aux = recordEquipoVisitante.getPartidosperdidos();
                recordEquipoVisitante.setPartidosperdidos(aux+1);
                unRecorddeequipoDAOImpl.update(recordEquipoVisitante, conn);
                
            }else if(ml<mv){
                
                                
                aux = recordEquipoVisitante.getPartidosganados();
                recordEquipoVisitante.setPartidosganados(aux+1);
                unRecorddeequipoDAOImpl.update(recordEquipoVisitante, conn);
                
                                
                aux = recordEquipoLocal.getPartidosperdidos();
                recordEquipoLocal.setPartidosperdidos(aux+1);
                unRecorddeequipoDAOImpl.update(recordEquipoLocal, conn);
            

            
            }else if(mv==ml){
                
                                
                aux = recordEquipoVisitante.getPartidosempatados();
                recordEquipoVisitante.setPartidosempatados(aux+1);
                unRecorddeequipoDAOImpl.update(recordEquipoVisitante, conn);
                
                                
                aux = recordEquipoLocal.getPartidosempatados();
                recordEquipoLocal.setPartidosempatados(aux+1);
                unRecorddeequipoDAOImpl.update(recordEquipoLocal, conn);
                

            }
            
            
            cargarTablaPartidos();
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPartido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public Recorddeequipo buscarRecordEquipo(RecorddeequipoKey key){
        
           
        Recorddeequipo recordEquipo;
        try {
            recordEquipo = unRecorddeequipoDAOImpl.load(key, conn);
            
                        
            if(recordEquipo!=null){
                
                               
                unRecordDeEquipo = unRecorddeequipoDAOImpl.load(key, conn);
                return unRecordDeEquipo;

                
            }else{
                recordEquipo = new Recorddeequipo();
                recordEquipo.setNombreequipo(key.getNombreequipo());
                recordEquipo.setTemporada(key.getTemporada());
                recordEquipo.setPartidosempatados(0);
                recordEquipo.setPartidosganados(0);
                recordEquipo.setPartidosperdidos(0);
                unRecorddeequipoDAOImpl.create(recordEquipo, conn);
                
                                
                unRecordDeEquipo = unRecorddeequipoDAOImpl.load(key, conn);
                return unRecordDeEquipo;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPartido.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;
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
    
    
    
    public PanelAdminDeLiga getPanelAdminDeLiga(){
    
        
        return unPanelAdminDeLiga;

    }

    @Override
    public void agregar(String temporada, int noJornada, String equipolocal, String equipovisitante, Date fecha, Date hora, boolean partidoFinalizado) {
                
        try {
            
            System.out.println("PARTIDO FINALIZADO EN EL CONTROLADOR "+partidoFinalizado);
            
            SimpleDateFormat hcn = new SimpleDateFormat("hh:mm"); 
            unPartido = new Partido(temporada, noJornada, equipolocal, equipovisitante, fecha, hora,partidoFinalizado);
            System.out.println("OBJETO PARTIDO DESDE CONTROLADOR PARTIDO"+unPartido.toString());
            unPartidoDAOImpl.create(unPartido, conn);
            
            cargarTablaPartidos();
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPartido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
    
}


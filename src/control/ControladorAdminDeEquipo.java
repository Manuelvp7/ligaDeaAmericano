/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAOimpl.EquipoDAOImpl;
import DAOimpl.PartidoDAOImpl;
import DAOimpl.RecorddeequipoDAOImpl;
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import interfaces.InterfazLoginControl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.Partido;
import modelo.Recorddeequipo;

import vista_jpanel.panelAdminEquipo;

/**
 *
 * @author manuel
 */
public class ControladorAdminDeEquipo implements interfaces.interfazAdministrarEquipo{
    
    //INTERFAZ
    private interfaces.interfazAdministrarEquipo unaInterfazAdministrarEquipo;
    
    //CONTROL
    private ControladorPersona unControladorPersona;
    private ControladorTableroDeMercado unControladorTableroDeMercado;
    private ControladorJugador unControladorJugador;
    private ControladorPanelAdminDeMercancia unControladorPanelAdminDeMercancia;
    
    private InterfazLoginControl unaInterfazLoginControl;
    
    //PANEL
    private panelAdminEquipo unPanelAdminEquipo;
    
    //DAO
    private PartidoDAOImpl unPartidoDAOImpl;
    private RecorddeequipoDAOImpl unRecorddeequipoDAOImpl;
    
    //CONEXION
    private Connection conn;
    
    
    
    public ControladorAdminDeEquipo( InterfazLoginControl unaInterfazLoginControl,String nombre){
               
        try{
		
                
    
            this.unaInterfazAdministrarEquipo = unaInterfazAdministrarEquipo;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lmfa?autoReconnect=true&useSSL=false", "root" , "manolito130");
            if (conn!=null) {
                
                this.unaInterfazLoginControl = unaInterfazLoginControl;
                
                unControladorJugador = new ControladorJugador(nombre,this);
                unControladorPersona = new ControladorPersona();
                unControladorPersona.setUnaInterfazAdministrarEquipo(this);
                unControladorPanelAdminDeMercancia = new ControladorPanelAdminDeMercancia(this);
                
                unPartidoDAOImpl = new PartidoDAOImpl();
                unRecorddeequipoDAOImpl = new RecorddeequipoDAOImpl();
                unPanelAdminEquipo = new panelAdminEquipo(this);
                unPanelAdminEquipo.cargarTablas();
                        
                

            }else{
                
                System.out.println("NO SE PUDO CARGAR LA CONEXION");
                        
            }

	}
	catch (Exception exc) {
            
            exc.printStackTrace();
	}
        

        
    }

    @Override
    public void cargarProximasFechas(String temporada,String equipo) {
        
        
        try {
            System.out.println("CARGANDO PROXIMAS FECHAS ");
            List<Object[]> registros;
            registros = unPartidoDAOImpl.loadProximosPartidos(temporada, equipo, conn);
            if(registros==null)
                System.out.println("COCK SUUUUUUUUUUUUUUUCKER PARA PROXIMAS FECHAS");
                
            else{
                                    
                System.out.println("REGRESARON LOS REGISTROS DE PROXIMAS FECHAS");
                System.out.println("PRIMER REGISTRO "+ registros.get(0).toString());
                unPanelAdminEquipo.cargarProximasFechas(registros);
            }

            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO HAY TABLA DE PROXIMAS FECHAS");
        }
        
        
    }

    @Override
    public void cargarTablaDePosiciones(String temporada) {

        try {
            List<Recorddeequipo> registros;
            registros=unRecorddeequipoDAOImpl.load(temporada, conn);
            if(registros!=null)
                
                unPanelAdminEquipo.cargarTablaDePosiciones(registros);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO HAY TABLA DE POSICIONES");
        }
        
        
    }

    @Override
    public void cargarTablaDeResultados(String temporada, String equipo) {
        try {
            List<Partido> registros;
            registros=unPartidoDAOImpl.loadResultados(temporada, equipo, conn);
            
            if(registros!=null)
                unPanelAdminEquipo.cargarTablaDeResultados(registros);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO HAY TABLA DE RESULTADOS");
        }
    }

    public panelAdminEquipo getUnPanelAdminEquipo() {
        return unPanelAdminEquipo;
    }

    @Override
    public void irA(int panel) {
        JPanel elPanel = null;
        switch ( panel){
            case 1:{
                
                elPanel=unControladorJugador.getPanelAdminPlantilla();
                break;
            }
            case 2:{
                
                
                elPanel=unControladorPanelAdminDeMercancia.getUnPanelAdminDeMercancia();
                break;
            }
            case 3:{
                elPanel=unControladorPersona.getPanelUsuariosDelSistema();
                
                break;
            }
            default:{
                break;
            }

        }
        unaInterfazLoginControl.cambiarPanel(elPanel);
    }

    @Override
    public void regresarAlPanelPadre() {
        
        unaInterfazLoginControl.cambiarPanel(unPanelAdminEquipo);
        
    }
        

    


    
}

package control;

import Conexiones.Conexion;
import DAO.PersonaDAO;
import DAOimpl.PersonaDAOImpl;
import interfaces.VistaControladorAdministrarUsuarios;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


import modelo.Persona;
import modelo.PersonaKey;


import vista.panelAdminUsuarioDelSistema;

public class ControladorPersona implements VistaControladorAdministrarUsuarios{

	private panelAdminUsuarioDelSistema panelUsuariosDelSistema;
	private Persona unaPersona ;
	private java.sql.Date fechaSQL;
        private Conexion conn;
	//private ConsultorBD consultor;
	//private InsertorBD insertor;
        private PersonaDAOImpl personaDAOImpl;
	
	public ControladorPersona(){
		
            unaPersona = new Persona();
            panelUsuariosDelSistema = new panelAdminUsuarioDelSistema(this);
            personaDAOImpl = new PersonaDAOImpl();
            conn = new Conexion();
            conn.crearConexion();
            	
	}

    public void agregar(String curp, String Nombre, String ApellidoPaterno, String ApellidoMaterno,int edad, Date fechaNacimiento) {
        
            try {
                
                unaPersona = new Persona(curp,Nombre,ApellidoPaterno,ApellidoMaterno,edad,fechaNacimiento);
                

                personaDAOImpl.create(unaPersona, conn.crearConexion());
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    


       public void MostrarPanelAdministradorDeUsuariosDelSistema(){
           
           panelUsuariosDelSistema.setVisible(true);
       }
       public void ocultarPanelAdministradorDeUsuariosDelSistema(){
           
           panelUsuariosDelSistema.setVisible(true);
           
       }

    @Override
    public void borrar(String curp, String Nombre, String ApellidoPaterno, String ApellidoMaterno, int edad, Date fechaNacimiento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(String curp, String Nombre, String ApellidoPaterno, String ApellidoMaterno, int edad, Date fechaNacimiento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


	



}

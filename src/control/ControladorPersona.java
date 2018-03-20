package control;

import Conexiones.Conexion;
import DAO.PersonaDAO;
import DAOimpl.CategoriausuarioDAOImpl;
import DAOimpl.EmpleadoDAOImpl;
import DAOimpl.PersonaDAOImpl;
import DAOimpl.TiendaDAOImpl;
import DAOimpl.UsuarioDAOImpl;
import interfaces.InterfazAdministrarLigaDeAmericano;
import interfaces.InterfazTableroDeMercado;
import interfaces.VistaControladorAdministrarUsuarios;
import interfaces.interfazAdministrarEquipo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Categoriausuario;
import modelo.Empleado;


import modelo.Persona;
import modelo.PersonaKey;
import modelo.Usuario;


import vista_jpanel.panelAdminUsuarioDelSistema;

public class ControladorPersona implements VistaControladorAdministrarUsuarios{

	private panelAdminUsuarioDelSistema panelUsuariosDelSistema;
	private Persona unaPersona ;
        private Usuario unUsuario;
	private Empleado unEmpleado;
        private Conexion conn;
        
        
	//private ConsultorBD consultor;
	//private InsertorBD insertor;
        private CategoriausuarioDAOImpl unaCategoriausuarioDAOImpl;
        private PersonaDAOImpl personaDAOImpl;
        private UsuarioDAOImpl unUsuarioDAOImpl;
        private EmpleadoDAOImpl unEmpleadoDAOImpl;
        private TiendaDAOImpl unaTiendaDAOImpl;
        
        
        
            
    
        int tipoInterface;
        private interfaces.interfazAdministrarEquipo unaInterfazAdministrarEquipo = null;
        private interfaces.InterfazTableroDeMercado unaInterfazTableroDeMercado= null;
        private interfaces.InterfazAdministrarLigaDeAmericano unaInterfazAdministrarLigaDeAmericano = null;
                    

        
	
	public ControladorPersona(){
            
            
            unaPersona = new Persona();
            unUsuarioDAOImpl = new UsuarioDAOImpl();
            
            unEmpleadoDAOImpl = new EmpleadoDAOImpl();
            panelUsuariosDelSistema = new panelAdminUsuarioDelSistema(this);
            unaTiendaDAOImpl = new TiendaDAOImpl();
            personaDAOImpl = new PersonaDAOImpl();
            unaCategoriausuarioDAOImpl = new CategoriausuarioDAOImpl();
            conn = new Conexion();
            cargarComboDeTiendas();
            cargarTablaPersona();
            cargarComboTipoDeUsuarios();
            
            	
	}

    public void setUnaInterfazAdministrarEquipo(interfazAdministrarEquipo unaInterfazAdministrarEquipo) {
        tipoInterface =1;
        this.unaInterfazAdministrarEquipo = unaInterfazAdministrarEquipo;
    }

    public void setUnaInterfazAdministrarLigaDeAmericano(InterfazAdministrarLigaDeAmericano unaInterfazAdministrarLigaDeAmericano) {
        tipoInterface = 2;
        this.unaInterfazAdministrarLigaDeAmericano = unaInterfazAdministrarLigaDeAmericano;
    }

    public void setUnaInterfazTableroDeMercado(InterfazTableroDeMercado unaInterfazTableroDeMercado) {
        tipoInterface = 3;
        this.unaInterfazTableroDeMercado = unaInterfazTableroDeMercado;
    }
    
        
        
        
        
        
        public void cargarComboTipoDeUsuarios(){
            List<Object[]> categoriaDeUsuarios;
            try {
                categoriaDeUsuarios = unaCategoriausuarioDAOImpl.loadCategorias(conn.crearConexion());
                if (categoriaDeUsuarios!=null) {
                
                    panelUsuariosDelSistema.cargarComboTipoDeUsuarios(categoriaDeUsuarios);
                }else{
                    System.out.println("FUUUUUUUUUUUUUUUUUUUCK DESDE CARGAR CATEGORIA DE USUARIOS");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
        public void cargarTablaPersona(){
            
           
            List<Object[]> personas;
            try {
                personas = personaDAOImpl.load(conn.crearConexion());
                if(personas!=null)
                    panelUsuariosDelSistema.actualizarTabla(personas);
                else
                    System.out.println("FUUUUUUUUUUUUUUUUUUUUCK EN CONTROLADOR PERSONA CARGAR TABLA DE PERSONA");
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }

    public void agregar(String curp, String Nombre, String ApellidoPaterno, String ApellidoMaterno,int edad, Date fechaNacimiento
        ,String categoriaUsuario,String userName,String password,String tienda) {
        
            try {
                
                unaPersona = new Persona(curp,Nombre,ApellidoPaterno,ApellidoMaterno,edad,fechaNacimiento);
                personaDAOImpl.create(unaPersona, conn.crearConexion());
                
                unUsuario = new Usuario();
                unUsuario.setCategoriausuario(categoriaUsuario);
                unUsuario.setCurp(curp);
                unUsuario.setNombreusuario(userName);
                unUsuario.setContrasena(password);
                
                unaTiendaDAOImpl = new TiendaDAOImpl();
                
                
                
                 unUsuarioDAOImpl.create(unUsuario, 
                         conn.crearConexion());
                 


                 if (categoriaUsuario.equals("VENDEDOR")) {
                     
                                      
                     
                     unEmpleado = new Empleado();
                 
                    unEmpleado.setCurp(curp);
                    unEmpleado.setIdtienda(tienda);
                    unEmpleadoDAOImpl.create(unEmpleado, conn.crearConexion());
                }

                
                //unEmpleadoDAOImpl.update(unEmpleado, conn.crearConexion());
                cargarTablaPersona();
                
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public panelAdminUsuarioDelSistema getPanelUsuariosDelSistema() {
        return panelUsuariosDelSistema;
    }

    



    @Override
    public void borrar(String curp) {
        
     
            try {
                   PersonaKey pk = new PersonaKey();
                   pk.setCurp(curp);
                   personaDAOImpl.delete(pk, conn.crearConexion());
                   cargarTablaPersona();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    
        public void cargarComboDeTiendas(){
        List<Object[]> registros;
        try {
            registros =
                    unaTiendaDAOImpl.loadNombreTiendas(conn.crearConexion());
            if(registros!=null){
                
                panelUsuariosDelSistema.cargarComboDeTiendas(registros);
                
            }
                
            else 
                JOptionPane.showMessageDialog(null,"NO SE ENCONTRARON TIENDAS");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"NO SE ENCONTRARON TIENDAS");
        }
        
    }

    

    @Override
    public void actualizar(String curp, String Nombre, String ApellidoPaterno, String ApellidoMaterno, int edad, Date fechaNacimiento
        ,String categoriaUsuario,String userName,String password,String tienda) {
        
        
        
            try {
                
                
                Persona unaPersona = new Persona(curp, Nombre, ApellidoPaterno, ApellidoMaterno, edad, fechaNacimiento);
                personaDAOImpl.update(unaPersona, conn.crearConexion());
                
                Usuario unUsuario = new Usuario();
                unUsuario.setCategoriausuario(categoriaUsuario);
                unUsuario.setContrasena(password);
                unUsuario.setCurp(curp);
                unUsuario.setNombreusuario(userName);
                
                System.out.println("EL USUARIO ACTUALIZADO ES:" + unUsuario.toString());

                unUsuarioDAOImpl.update(unUsuario, conn.crearConexion());
                
                unEmpleado = new Empleado();
                unEmpleado.setCurp(curp);
                unEmpleado.setIdtienda(tienda);
                
//                unEmpleadoDAOImpl.update(unEmpleado, conn.crearConexion());
                
                
                                 
                if (unUsuario.getCategoriausuario()=="VENDEDOR") {
                     
                                      
                     unEmpleado = new Empleado();
                 
                 
                    unEmpleado.setCurp(curp);
                    unEmpleado.setIdtienda(tienda);
                    unEmpleadoDAOImpl.create(unEmpleado, conn.crearConexion());
                }
                
                cargarTablaPersona();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    public interfazAdministrarEquipo getUnaInterfazAdministrarEquipo() {
        return unaInterfazAdministrarEquipo;
    }

    public InterfazTableroDeMercado getUnaInterfazTableroDeMercado() {
        return unaInterfazTableroDeMercado;
    }

    public InterfazAdministrarLigaDeAmericano getUnaInterfazAdministrarLigaDeAmericano() {
        return unaInterfazAdministrarLigaDeAmericano;
    }
    
    
    
    @Override
    public void regresar(){
        
        switch(tipoInterface){
            
            case 1:{
                System.out.println(" LA INTERFACE " + getUnaInterfazAdministrarEquipo());
                unaInterfazAdministrarEquipo.regresarAlPanelPadre();
                
                break;
            }
            case 2:{
                unaInterfazAdministrarLigaDeAmericano.regresarAlPanelPadre();        
                break;
                
            }
            case 3:{
                unaInterfazTableroDeMercado.regresarAlPanelPadre();
            }
        }
        
   
    }
    
    



	



}

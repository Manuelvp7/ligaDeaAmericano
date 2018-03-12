/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAOimpl.CategoriausuarioDAOImpl;
import DAOimpl.PartidoDAOImpl;
import DAOimpl.RecorddeequipoDAOImpl;
import DAOimpl.UsuarioDAOImpl;
import interfaces.InterfazLoginControl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.Persona;
import modelo.Usuario;
import modelo.UsuarioKey;
import vista.login;
import vista_jpanel.PanelLogin;
import vista_jpanel.panelAdminEquipo;

/**
 *
 * @author manuel
 */
public class ControlLogin implements InterfazLoginControl{
    
    private Connection conn;
    private UsuarioDAOImpl unUsuarioDAOImpl;
    private CategoriausuarioDAOImpl unaCategoriausuarioDAOImpl;
    private PanelLogin unPanelLogin;
    private Usuario unUsuario;
    private Persona unaPersona;
    private  JFrame miFrame;
    
    private ControladorAdminDeEquipo unControladorAdminDeEquipo;
    private ControladorTableroDeMercado unControladorTableroDeMercado;
    private ControladorPartido unControladorPartido;
    private ControladorVenta unControladorVenta;
    private ControladorPanelAdminDeMercancia unControladorPanelAdminDeMercancia;
    
    
    public ControlLogin() {
        
                
        try{
			
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lmfa?autoReconnect=true&useSSL=false", "root" , "manolito130");
            if (conn!=null) {
                
                 miFrame = new JFrame();
        

                 
                 
                miFrame.setDefaultCloseOperation(3);
                unUsuarioDAOImpl = new UsuarioDAOImpl();
                unaCategoriausuarioDAOImpl = new CategoriausuarioDAOImpl();                
                unPanelLogin = new PanelLogin(this);
                cargarComboTipoDeUsuarios();
                ejecutarGUI();
                
                                

                
                

            }else{
                System.out.println("NO SE PUDO CARGAR LA CONEXION");
                        
            }

	}
	catch (Exception exc) {
            
            exc.printStackTrace();
	}
        
       
        
    }
    
    
            
    public void cargarComboTipoDeUsuarios(){
            List<Object[]> categoriaDeUsuarios;
            try {
                categoriaDeUsuarios = unaCategoriausuarioDAOImpl.loadCategorias(conn);
                if (categoriaDeUsuarios!=null) {
                
//                    unPanelLogin.cargarComboTipoDeUsuarios(categoriaDeUsuarios);
                }else{
                    System.out.println("FUUUUUUUUUUUUUUUUUUUCK DESDE CARGAR CATEGORIA DE USUARIOS");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }

    @Override
    public void ingresar(String userName, String pass, String categoriaUsuario) {
        
        Object[] resultado = new Object[5];
        
        try {
            resultado=unUsuarioDAOImpl.LoadUsuario(userName,pass, conn);
            if(resultado!=null){
                iniciarPanel(resultado);
            }else
                JOptionPane.showMessageDialog(null, "USUARIO NO RECONOCIDO");
        } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, "USUARIO Y CONTRASENIA NO VALIDOS");
        }
    }
    public void iniciarPanel(Object[] registro){
        
        String CURP = String.valueOf(registro[0]);
        String nombre = String.valueOf(registro[1]);
        String paterno = String.valueOf(registro[2]);
        String nombreUsuario = String.valueOf(registro[3]);
        String categoriaUsuario = String.valueOf(registro[4]);
        
        switch(categoriaUsuario){
            case "ADMINISTRADOR DE EQUIPO":{
                                
                unControladorAdminDeEquipo = new ControladorAdminDeEquipo(this,nombre);
                cambiarPanel(unControladorAdminDeEquipo.getUnPanelAdminEquipo());
                break;
            }
            case "ADMINISTRADOR DE LIGA":{
               
                unControladorPartido = new ControladorPartido(this);
                cambiarPanel(unControladorPartido.getPanelAdminDeLiga());
                break;
            }
            case "GERENTE DE VENTAS":{
                unControladorTableroDeMercado = new ControladorTableroDeMercado(this);
                cambiarPanel(unControladorTableroDeMercado.getUnPanelTableroDeMercado());
                break;
                
            }
            case "VENDEDOR":{
                unControladorVenta = new ControladorVenta();
                cambiarPanel((JPanel) unControladorVenta.getUnPanelVentas().getContentPane());
                break;
                
            }
        }
        
        
    }
    
    public void cambiarPanel(JPanel unPanel){
        
        miFrame.getContentPane().removeAll();
        miFrame.getContentPane().invalidate();
        
        miFrame.getContentPane().add(unPanel);
        miFrame.getContentPane().revalidate();
        miFrame.pack();
        
        miFrame.setVisible(true);
               
        
    }
    
    public void ejecutarGUI(){

        miFrame.add(unPanelLogin);
        miFrame.pack();
        miFrame.setVisible(true);
       
    }
     
    
    
    
}

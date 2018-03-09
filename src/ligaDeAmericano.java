
import control.ControladorAdminDeEquipo;
import control.ControladorArticulo;
import control.ControladorJugador;
import control.ControladorPartido;
import control.ControladorPersona;
import control.ControladorVenta;
import javax.swing.JFrame;
import vista.login;
import vista.PanelAdminDeLiga;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manuel
 */
public class ligaDeAmericano {
    
    public static void main(String[] args) {
        
       //ControladorPersona cp = new ControladorPersona();
        //cp.MostrarPanelAdministradorDeUsuariosDelSistema();
        
        //ControladorJugador cj = new ControladorJugador();
        //cj.mostrarPanelAdminPlantilla();
        
        //ControladorArticulo ca = new ControladorArticulo();
        //ca.mostrarPanelAdministrarArticulos();
        
        ControladorPartido cp = new ControladorPartido();
        //cp.mostrarPanel();
        //ControladorVenta cv = new ControladorVenta();
        //cv.mostrarPanel();
        
        ControladorAdminDeEquipo unControladorAdminDeEquipo = new ControladorAdminDeEquipo();
        
        JFrame miFrame = new JFrame();
        miFrame.setDefaultCloseOperation(0);
        
        
        		
        miFrame.setDefaultCloseOperation(3);
	
        miFrame.add(unControladorAdminDeEquipo.getUnPanelAdminEquipo());
        //miFrame.add(cp.getPanelAdminDeLiga());
	
        miFrame.setBounds(50,100,1200,550);
	
        miFrame.setVisible(true);
        

        
        
    }
    
}

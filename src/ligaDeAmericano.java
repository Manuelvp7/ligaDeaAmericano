
import control.ControladorArticulo;
import control.ControladorJugador;
import control.ControladorPersona;
import vista.login;

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
        
        ControladorJugador cj = new ControladorJugador();
        cj.mostrarPanelAdminPlantilla();
        
        //ControladorArticulo ca = new ControladorArticulo();
        //ca.mostrarPanelAdministrarArticulos();
        
        
    }
    
}

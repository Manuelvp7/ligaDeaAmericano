/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import java.sql.Date;

/**
 *
 * @author manuel
 */
public interface VistaControladorAdministrarUsuarios {
    
    public void agregar(String curp, String Nombre, String ApellidoPaterno, String ApellidoMaterno,
            int edad,Date fechaNacimiento,String categoriaUsuario,String userName,String Password);
    public void borrar(String curp);
    public void actualizar(String curp, String Nombre, String ApellidoPaterno, String ApellidoMaterno, int edad,Date fechaNacimiento,String categoriaUsuario,String userName,String Password);
    public void cargarTablaPersona();
    public void regresar();
}

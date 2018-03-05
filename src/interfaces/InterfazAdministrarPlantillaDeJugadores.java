
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
public interface InterfazAdministrarPlantillaDeJugadores {
    
    public void agregar(String curp,String nombre, String paterno, String materno, int edad, java.util.Date fechanacimiento,
        int numero,String posicion,double salario,String nombreEquipo, boolean bajaporlesion);
    public void borrar(String curp);
    public void actualizar(String curp,String nombre, String paterno, String materno, int edad, java.util.Date fechanacimiento,
        int numero,String posicion,double salario,String nombreEquipo, boolean bajaporlesion);
    public void cargarTablaJugador();
    
}

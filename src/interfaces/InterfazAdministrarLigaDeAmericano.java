/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.Date;

/**
 *
 * @author manuel
 */
public interface InterfazAdministrarLigaDeAmericano {
    
    public void agregar(String temporada,int noJornada,String equipolocal,String equipovisitante,Date fecha,Date hora);
    
    public void borrar(String temporada,int noJornada,String equipolocal,String equipovisitante);
    
    public void actualizar(String temporada,int noJornada,String equipolocal,String equipovisitante,Date fecha,Date hora,int ml,int mv);
    
    
    
}

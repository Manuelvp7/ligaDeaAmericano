/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author manuel
 */
public interface InterfazAdministrarLigaDeAmericano {
    
    public void agregar(String temporada,int noJornada,String equipolocal,String equipovisitante,Date fecha,Timestamp hora,boolean partidoFinalizado);
    
    public void borrar(String temporada,int noJornada,String equipolocal,String equipovisitante);
    
    public void actualizar(String temporada,int noJornada,String equipolocal,String equipovisitante,Date fecha,Timestamp hora,int ml,int mv,boolean partidoFinalizado);
    
    public void regresarAlPanelPadre();
    
    public void irA();

    
    
    
    
    
    
}

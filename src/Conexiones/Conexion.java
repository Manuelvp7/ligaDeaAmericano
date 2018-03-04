/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author manuel
 */
public class Conexion {
    
    private Connection conexion;
    
    	public Connection crearConexion() {
		
		Connection myConn = null;
		try{
			
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lmfa?autoReconnect=true&useSSL=false", "root" , "manolito130");
                        if (myConn!=null) {
                    return myConn;
            }

		}
		catch (Exception exc) {
				exc.printStackTrace();
			}
                
        return null;
			
		}

    public Connection getConexion() {
        
        if(conexion!=null)
            return conexion;
        return null;
    }
        
    
    
}

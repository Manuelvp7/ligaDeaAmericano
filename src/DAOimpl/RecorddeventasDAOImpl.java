/*
 * This java source file is generated by DAO4J v1.19
 * Generated on Tue Mar 06 22:47:33 CST 2018
 * For more information, please contact b-i-d@163.com
 * Please check http://sourceforge.net/projects/dao4j/ for the latest version.
 */

package DAOimpl;

import modelo.RecorddeventasKey;
import modelo.Recorddeventas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.ArrayList;
import DAO.RecorddeventasDAO;

/**
 * This class provides methods to populate DB Table of RecordDeVentas
 */
public class RecorddeventasDAOImpl implements RecorddeventasDAO {
    /* SQL to insert data */
    
    private static final String SQL_SELECT_MONTO_DE_LAS_VENTAS_TIENDA_ANIO_TRIMESTRE =""
            + "SELECT anio,trimestre,nombreTienda,SUM(monto) AS monto "
            + "FROM RecordDeVentas  "
            + "WHERE nombreTienda = ? And anio = ? AND trimestre = ? "
            + "";
    
    private static final String SQL_SELECT_MONTO_DE_LAS_VENTAS_FILTRO_TIENDA =""
            
            + "SELECT anio,trimestre,nombreTienda,SUM(monto) AS monto  "
            + "FROM RecordDeVentas "
            + "WHERE nombreTienda = ? "
            + "GROUP BY anio ";
    
    private static final String SQL_SELECT_MONTO_DE_LAS_VENTAS_FILTRO_ANIO =""
            
            + "SELECT anio,trimestre,nombreTienda,SUM(monto) AS monto "
            + "FROM RecordDeVentas "
            + "WHERE anio = ? "
            + "GROUP BY trimestre ";
    
        
    private static final String SQL_SELECT_MONTO_DE_LAS_VENTAS_FILTRO_TIENDA_Y_ANIO =""
            
            + "SELECT anio,trimestre,nombreTienda,SUM(monto) AS monto "
            + "FROM RecordDeVentas "
            + "WHERE nombreTienda = ? AND anio = ? "
            + "GROUP BY trimestre ";
        
            
    private static final String SQL_SELECT =""
            + "SELECT anio,trimestre,nombreTienda,SUM(monto) AS monto "
            + "FROM RecordDeVentas "
            + "GROUP BY nombreTienda";

    private static final String SQL_INSERT =
        "INSERT INTO RecordDeVentas ("
        + "nombreTienda, idVenta, anio, trimestre, monto"
        + ") VALUES (?, ?, ?, ?, ?)";

    /* SQL to select data */

    
    private static final String SQL_COUNT_IDVENTA =""
            + "SELECT COUNT(*) as conteo "
            + "FROM RecordDeVentas WHERE "
            + "nombreTienda = ? "
            + "AND anio = ? AND trimestre = ?";



    /* SQL to update data */
    private static final String SQL_UPDATE =
        "UPDATE RecordDeVentas SET "
        + "monto = ? "
        + "WHERE "
        + "nombreTienda = ? AND idVenta = ? AND anio = ? AND trimestre = ?";

    /* SQL to delete data */
    private static final String SQL_DELETE =
        "DELETE FROM RecordDeVentas WHERE "
        + "nombreTienda = ? AND idVenta = ? AND anio = ? AND trimestre = ?";

    /**
     * Create a new record in Database.
     * @param bean   The Object to be inserted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void create(Recorddeventas bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, bean.getNombretienda());
            ps.setInt(2, bean.getIdventa());
            ps.setInt(3, bean.getAnio());
            ps.setInt(4, bean.getTrimestre());
            
            
            ps.setDouble(5, bean.getMonto());
            System.out.println("PREPARED STATEMNT: "+ps);
            ps.executeUpdate();
        }finally {
            close(ps);
        }
    }
    
    
        
    public List<Object[]> loadRecord(String tienda,int anio, int trimestre, int tipoDeBusqueda,Connection conn) throws SQLException{
     

                   
        PreparedStatement ps = null;    
        
        ResultSet rs = null;
        try {
                    
            switch(tipoDeBusqueda){
            
                case 1:{

                    ps = conn.prepareStatement(SQL_SELECT);
                    break;                    
                }
                case 2:{
                    ps = conn.prepareStatement(SQL_SELECT_MONTO_DE_LAS_VENTAS_FILTRO_ANIO);
                    ps.setInt(1, anio);
                    break;
                }
                case 3:{
                    
                          
                    ps = conn.prepareStatement(SQL_SELECT_MONTO_DE_LAS_VENTAS_FILTRO_TIENDA);
                    ps.setString(1, tienda);
                    break;
                    
                }
                case 4:{
                    
                          
                    ps = conn.prepareStatement(SQL_SELECT_MONTO_DE_LAS_VENTAS_FILTRO_TIENDA_Y_ANIO);
                    ps.setString(1, tienda);
                    ps.setInt(2, anio);
                    break;
                    
                   
                }
                case 5:{
                    
                          
                    ps = conn.prepareStatement(SQL_SELECT_MONTO_DE_LAS_VENTAS_TIENDA_ANIO_TRIMESTRE);
                                       
                    ps.setString(1, tienda);
                    ps.setInt(2, anio);
                    ps.setInt(3, trimestre);
                    break;
                    
                }
                default:{
                    break;
                }
                    

                    
            }
            System.out.println("EL STATEMENT DESDE RECORDDEVENTASDAOIMPL "+ps);
            rs = ps.executeQuery();
            List results = getResultsRecord(rs);
            if (results.size() > 0)
                return results;
            else
                return null;
        }finally {
            close(rs);
            close(ps);
        }
        
    }

    /**
     * Retrive a record from Database.
     * @param store
     * @param beanKey   The PK Object to be retrived.
     * @param conn      JDBC Connection.
     * @exception       SQLException if something is wrong.
     */
    

    public Recorddeventas load(RecorddeventasKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setString(1, key.getNombretienda());
            ps.setInt(2, key.getIdventa());
            ps.setInt(3, key.getAnio());
            ps.setInt(4, key.getTrimestre());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return (Recorddeventas) results.get(0);
            else
                return null;
        }finally {
            close(rs);
            close(ps);
        }
    }
    public int generarIDVenta(String tienda,int anio,int trimestre, Connection conn) throws SQLException{
                
        System.out.println("CALCULANDO IDVENTA DESDE DAO"+tienda+" "+anio+" "+trimestre);
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
           
            ps = conn.prepareStatement(SQL_COUNT_IDVENTA);
            ps.setString(1, tienda);
            ps.setInt(2, anio);
            ps.setInt(3, trimestre);
            
            
            
            rs = ps.executeQuery();
            rs.next();
            
            
            
            return rs.getInt("conteo")+1;
        }finally {
            close(rs);
            close(ps);
        }
        
    }

    /**
     * Update a record in Database.
     * @param bean   The Object to be saved.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void update(Recorddeventas bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setDouble(1, bean.getMonto());
            ps.setString(2, bean.getNombretienda());
            ps.setInt(3, bean.getIdventa());
            ps.setInt(4, bean.getAnio());
            ps.setInt(5, bean.getTrimestre());
            ps.executeUpdate();
        }finally {
            close(ps);
        }
    }

    /**
     * Create a new record in Database.
     * @param bean   The PK Object to be deleted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void delete(RecorddeventasKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setString(1, key.getNombretienda());
            ps.setInt(2, key.getIdventa());
            ps.setInt(3, key.getAnio());
            ps.setInt(4, key.getTrimestre());
            ps.executeUpdate();
        }finally {
            close(ps);
        }
    }
    
    /**
     * Populate the ResultSet.
     * @param rs     The ResultSet.
     * @return       The Object to retrieve from DB.
     * @exception    SQLException if something is wrong.
     */
        
    protected List<Object[]> getResultsRecord(ResultSet rs) throws SQLException {
        List results = new ArrayList<Object[]>();
        while (rs.next()) {
            Object[] registro = new Object[4];
            registro[0]=(rs.getString("nombreTienda"));
            registro[1]=(rs.getInt("anio"));
            registro[2]=(rs.getInt("trimestre"));
            registro[3]=(rs.getDouble("monto"));
            results.add(registro);
        }
        return results;
    }
    
    protected List<Recorddeventas> getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList<Recorddeventas>();
        while (rs.next()) {
            Recorddeventas bean = new Recorddeventas();
            bean.setNombretienda(rs.getString("nombreTienda"));
            bean.setIdventa(rs.getInt("idVenta"));
            bean.setAnio(rs.getInt("anio"));
            bean.setTrimestre(rs.getInt("trimestre"));
            bean.setMonto(rs.getDouble("monto"));
            results.add(bean);
        }
        return results;
    }

    /**
     * Close JDBC Statement.
     * @param stmt  Statement to be closed.
     */
    protected void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            }catch(SQLException e){}
        }
    }

    /**
     * Close JDBC ResultSet.
     * @param rs  ResultSet to be closed.
     */
    protected void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            }catch(SQLException e){}
        }
    }
}
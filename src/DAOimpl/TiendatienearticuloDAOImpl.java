/*
 * This java source file is generated by DAO4J v1.19
 * Generated on Mon Mar 05 02:22:23 CST 2018
 * For more information, please contact b-i-d@163.com
 * Please check http://sourceforge.net/projects/dao4j/ for the latest version.
 */

package DAOimpl;

import DAO.TiendatienearticuloDAO;
import DAO.TiendatienearticuloDAO;
import modelo.TiendatienearticuloKey;
import modelo.Tiendatienearticulo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.ArrayList;
import modelo.Articulo;
import modelo.ArticuloKey;

/**
 * This class provides methods to populate DB Table of TiendaTieneArticulo
 */
public class TiendatienearticuloDAOImpl implements TiendatienearticuloDAO {
    /* SQL to insert data */
    private static final String SQL_INSERT =
        "INSERT INTO TiendaTieneArticulo ("
        + "nombreTienda, nombreArticulo, nombreProveedor, existencias"
        + ") VALUES (?, ?, ?, ?)";

    /* SQL to select data */
    private static final String SQL_SELECT =
        "SELECT "
        + "nombreTienda, nombreArticulo, nombreProveedor, existencias "
        + "FROM TiendaTieneArticulo WHERE "
        + "nombreTienda = ? AND nombreArticulo = ? AND nombreProveedor = ?";
    
       
    private static final String SQL_SELECT_PARA_TODAS_LAS_TIENDAS =
        "SELECT "
        + "nombreTienda, nombreArticulo, nombreProveedor, existencias "
        + "FROM TiendaTieneArticulo WHERE "
        + "nombreArticulo = ? AND nombreProveedor = ?";

    /* SQL to update data */
    private static final String SQL_UPDATE =
        "UPDATE TiendaTieneArticulo SET "
        + "existencias = ? "
        + "WHERE "
        + "nombreTienda = ? AND nombreArticulo = ? AND nombreProveedor = ?";

    /* SQL to delete data */
    private static final String SQL_DELETE =
        "DELETE FROM TiendaTieneArticulo WHERE "
        + "nombreTienda = ? AND nombreArticulo = ? AND nombreProveedor = ?";

    /**
     * Create a new record in Database.
     * @param bean   The Object to be inserted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void create(Tiendatienearticulo bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, bean.getNombretienda());
            ps.setString(2, bean.getNombrearticulo());
            ps.setString(3, bean.getNombreproveedor());
            ps.setInt(4, bean.getExistencias());
            ps.executeUpdate();
        }finally {
            close(ps);
        }
    }

    /**
     * Retrive a record from Database.
     * @param beanKey   The PK Object to be retrived.
     * @param conn      JDBC Connection.
     * @exception       SQLException if something is wrong.
     */
    
       
    public List<Object[]> load(ArticuloKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        System.out.println("KEY DEL ARTICULO EN LOAD "+key.toString());
        try {
            ps = conn.prepareStatement(SQL_SELECT_PARA_TODAS_LAS_TIENDAS);
            ps.setString(1, key.getNombre());
            ps.setString(2, key.getProveedor());
            
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return results;
            else
                return null;
        }finally {
            close(rs);
            close(ps);
        }
    }
    
    public Tiendatienearticulo load(TiendatienearticuloKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setString(1, key.getNombretienda());
            ps.setString(2, key.getNombrearticulo());
            ps.setString(3, key.getNombreproveedor());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return (Tiendatienearticulo) results.get(0);
            else
                return null;
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
    public void update(Tiendatienearticulo bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setInt(1, bean.getExistencias());
            ps.setString(2, bean.getNombretienda());
            ps.setString(3, bean.getNombrearticulo());
            ps.setString(4, bean.getNombreproveedor());
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
    public void delete(TiendatienearticuloKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setString(1, key.getNombretienda());
            ps.setString(2, key.getNombrearticulo());
            ps.setString(3, key.getNombreproveedor());
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
    protected List<Tiendatienearticulo> getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList<Tiendatienearticulo>();
        while (rs.next()) {
            Tiendatienearticulo bean = new Tiendatienearticulo();
            bean.setNombretienda(rs.getString("nombreTienda"));
            bean.setNombrearticulo(rs.getString("nombreArticulo"));
            bean.setNombreproveedor(rs.getString("nombreProveedor"));
            bean.setExistencias(rs.getInt("existencias"));
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
/*
 * This java source file is generated by DAO4J v1.19
 * Generated on Sun Feb 25 05:11:23 CST 2018
 * For more information, please contact b-i-d@163.com
 * Please check http://sourceforge.net/projects/dao4j/ for the latest version.
 */

package DAOimpl;

import modelo.JornadaKey;
import modelo.Jornada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.ArrayList;
import DAO.JornadaDAO;

/**
 * This class provides methods to populate DB Table of Jornada
 */
public class JornadaDAOImpl implements JornadaDAO {
    /* SQL to insert data */
    private static final String SQL_INSERT =
        "INSERT INTO Jornada ("
        + "temporada, noJornada, fecha"
        + ") VALUES (?, ?, ?)";

    /* SQL to select data */
    private static final String SQL_SELECT =
        "SELECT "
        + "temporada, noJornada, fecha "
        + "FROM Jornada WHERE "
        + "temporada = ? AND noJornada = ?";

    /* SQL to update data */
    private static final String SQL_UPDATE =
        "UPDATE Jornada SET "
        + "fecha = ? "
        + "WHERE "
        + "temporada = ? AND noJornada = ?";

    /* SQL to delete data */
    private static final String SQL_DELETE =
        "DELETE FROM Jornada WHERE "
        + "temporada = ? AND noJornada = ?";

    /**
     * Create a new record in Database.
     * @param bean   The Object to be inserted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void create(Jornada bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, bean.getTemporada());
            ps.setInt(2, bean.getNojornada());
            if (bean.getFecha() != null)
                ps.setDate(3, new java.sql.Date(bean.getFecha().getTime()));
            else
                ps.setNull(3, Types.DATE);
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
    public Jornada load(JornadaKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setString(1, key.getTemporada());
            ps.setInt(2, key.getNojornada());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return (Jornada) results.get(0);
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
    public void update(Jornada bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            if (bean.getFecha() != null)
                ps.setDate(1, new java.sql.Date(bean.getFecha().getTime()));
            else
                ps.setNull(1, Types.DATE);
            ps.setString(2, bean.getTemporada());
            ps.setInt(3, bean.getNojornada());
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
    public void delete(JornadaKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setString(1, key.getTemporada());
            ps.setInt(2, key.getNojornada());
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
    protected List<Jornada> getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList<Jornada>();
        while (rs.next()) {
            Jornada bean = new Jornada();
            bean.setTemporada(rs.getString("temporada"));
            bean.setNojornada(rs.getInt("noJornada"));
            bean.setFecha(rs.getDate("fecha"));
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
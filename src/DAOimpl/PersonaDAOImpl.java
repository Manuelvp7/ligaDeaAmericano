/*
 * This java source file is generated by DAO4J v1.19
 * Generated on Sun Feb 25 05:11:23 CST 2018
 * For more information, please contact b-i-d@163.com
 * Please check http://sourceforge.net/projects/dao4j/ for the latest version.
 */

package DAOimpl;

import modelo.Persona;
import modelo.PersonaKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.ArrayList;
import DAO.PersonaDAO;

/**
 * This class provides methods to populate DB Table of Persona
 */
public class PersonaDAOImpl implements PersonaDAO {
    
    
    /* SQL to insert data */
    private static final String SQL_INSERT =
        "INSERT INTO Persona ("
        + "CURP, nombre, paterno, materno, edad, fechaNacimiento"
        + ") VALUES (?, ?, ?, ?, ?, ?)";

    /* SQL to select data */
    private static final String SQL_SELECT =
        "SELECT "
        + "CURP, nombre, paterno, materno, edad, fechaNacimiento "
        + "FROM Persona WHERE "
        + "CURP = ?";

    /* SQL to update data */
    private static final String SQL_UPDATE =
        "UPDATE Persona SET "
        + "nombre = ?, paterno = ?, materno = ?, edad = ?, fechaNacimiento = ? "
        + "WHERE "
        + "CURP = ?";

    /* SQL to delete data */
    private static final String SQL_DELETE =
        "DELETE FROM Persona WHERE "
        + "CURP = ?";

    /**
     * Create a new record in Database.
     * @param bean   The Object to be inserted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void create(Persona bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            
            if (conn==null) {
                System.out.println("CONEXION INVALIDA");
            }
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, bean.getCurp());
            ps.setString(2, bean.getNombre());
            ps.setString(3, bean.getPaterno());
            ps.setString(4, bean.getMaterno());
            ps.setInt(5, bean.getEdad());
            if (bean.getFechanacimiento() != null)
                ps.setDate(6, new java.sql.Date(bean.getFechanacimiento().getTime()));
            else
                ps.setNull(6, Types.DATE);
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
    public Persona load(PersonaKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setString(1, key.getCurp());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return (Persona) results.get(0);
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
    public void update(Persona bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, bean.getNombre());
            ps.setString(2, bean.getPaterno());
            ps.setString(3, bean.getMaterno());
            ps.setInt(4, bean.getEdad());
            if (bean.getFechanacimiento() != null)
                ps.setDate(5, new java.sql.Date(bean.getFechanacimiento().getTime()));
            else
                ps.setNull(5, Types.DATE);
            ps.setString(6, bean.getCurp());
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
    public void delete(PersonaKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setString(1, key.getCurp());
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
    protected List<Persona> getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList<Persona>();
        while (rs.next()) {
            Persona bean = new Persona();
            bean.setCurp(rs.getString("CURP"));
            bean.setNombre(rs.getString("nombre"));
            bean.setPaterno(rs.getString("paterno"));
            bean.setMaterno(rs.getString("materno"));
            bean.setEdad(rs.getInt("edad"));
            bean.setFechanacimiento(rs.getDate("fechaNacimiento"));
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
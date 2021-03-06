/*
 * This java source file is generated by DAO4J v1.19
 * Generated on Sun Feb 25 05:11:23 CST 2018
 * For more information, please contact b-i-d@163.com
 * Please check http://sourceforge.net/projects/dao4j/ for the latest version.
 */

package modelo;

/*
 * For Table Tienda
 */
public class Tienda implements java.io.Serializable, Cloneable {
    private TiendaKey _key = new TiendaKey();

    /* nombre, PK */
    protected String nombre;

    /* nombreEstadio */
    protected String nombreestadio;

    /* curpGerente */
    protected String curpgerente;

    /* Return the key object. */
    public TiendaKey getKeyObject() {
        return _key;
    }

    /* nombre, PK */
    public String getNombre() {
        return nombre;
    }

    /* nombre, PK */
    public void setNombre(String nombre) {
        this.nombre = nombre;
        _key.setNombre(nombre);
    }

    /* nombreEstadio */
    public String getNombreestadio() {
        return nombreestadio;
    }

    /* nombreEstadio */
    public void setNombreestadio(String nombreestadio) {
        this.nombreestadio = nombreestadio;
    }

    /* curpGerente */
    public String getCurpgerente() {
        return curpgerente;
    }

    /* curpGerente */
    public void setCurpgerente(String curpgerente) {
        this.curpgerente = curpgerente;
    }

    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof Tienda))
            return false;

        Tienda bean = (Tienda) obj;

        if (this.nombre == null) {
            if (bean.nombre != null)
                return false;
        }
        else if (!this.nombre.equals(bean.nombre)) 
            return false;

        if (this.nombreestadio == null) {
            if (bean.nombreestadio != null)
                return false;
        }
        else if (!this.nombreestadio.equals(bean.nombreestadio)) 
            return false;

        if (this.curpgerente == null) {
            if (bean.curpgerente != null)
                return false;
        }
        else if (!this.curpgerente.equals(bean.curpgerente)) 
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        Tienda bean = new Tienda();
        bean.nombre = this.nombre;
        bean.nombreestadio = this.nombreestadio;
        bean.curpgerente = this.curpgerente;
        return bean;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("nombre").append(" = ").append(nombre).append("]").append(sep);
        sb.append("[").append("nombreestadio").append(" = ").append(nombreestadio).append("]").append(sep);
        sb.append("[").append("curpgerente").append(" = ").append(curpgerente).append("]").append(sep);
        return sb.toString();
    }
}
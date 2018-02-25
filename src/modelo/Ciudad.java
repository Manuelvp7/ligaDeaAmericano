/*
 * This java source file is generated by DAO4J v1.19
 * Generated on Sun Feb 25 05:11:22 CST 2018
 * For more information, please contact b-i-d@163.com
 * Please check http://sourceforge.net/projects/dao4j/ for the latest version.
 */

package modelo;

/*
 * For Table Ciudad
 */
public class Ciudad implements java.io.Serializable, Cloneable {
    private CiudadKey _key = new CiudadKey();

    /* nombreCiudad, PK */
    protected String nombreciudad;

    /* Return the key object. */
    public CiudadKey getKeyObject() {
        return _key;
    }

    /* nombreCiudad, PK */
    public String getNombreciudad() {
        return nombreciudad;
    }

    /* nombreCiudad, PK */
    public void setNombreciudad(String nombreciudad) {
        this.nombreciudad = nombreciudad;
        _key.setNombreciudad(nombreciudad);
    }

    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof Ciudad))
            return false;

        Ciudad bean = (Ciudad) obj;

        if (this.nombreciudad == null) {
            if (bean.nombreciudad != null)
                return false;
        }
        else if (!this.nombreciudad.equals(bean.nombreciudad)) 
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        Ciudad bean = new Ciudad();
        bean.nombreciudad = this.nombreciudad;
        return bean;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("nombreciudad").append(" = ").append(nombreciudad).append("]").append(sep);
        return sb.toString();
    }
}
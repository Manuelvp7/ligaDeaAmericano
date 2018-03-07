/*
 * This java source file is generated by DAO4J v1.19
 * Generated on Tue Mar 06 22:47:33 CST 2018
 * For more information, please contact b-i-d@163.com
 * Please check http://sourceforge.net/projects/dao4j/ for the latest version.
 */

package modelo;

/*
 * For Table DetalleDeVenta
 */
public class Detalledeventa implements java.io.Serializable, Cloneable {
    private DetalledeventaKey _key = new DetalledeventaKey();

    /* nombreTienda */
    protected String nombretienda;

    /* idVenta, PK */
    protected int idventa;

    /* anio, PK */
    protected int anio;

    /* trimestre, PK */
    protected int trimestre;

    /* nombreArticulo */
    protected String nombrearticulo;

    /* nombreProveedor */
    protected String nombreproveedor;

    /* piezasVendidas */
    protected int piezasvendidas;

    /* Return the key object. */
    public DetalledeventaKey getKeyObject() {
        return _key;
    }

    /* nombreTienda */
    public String getNombretienda() {
        return nombretienda;
    }

    /* nombreTienda */
    public void setNombretienda(String nombretienda) {
        this.nombretienda = nombretienda;
    }

    /* idVenta, PK */
    public int getIdventa() {
        return idventa;
    }

    /* idVenta, PK */
    public void setIdventa(int idventa) {
        this.idventa = idventa;
        _key.setIdventa(idventa);
    }

    /* anio, PK */
    public int getAnio() {
        return anio;
    }

    /* anio, PK */
    public void setAnio(int anio) {
        this.anio = anio;
        _key.setAnio(anio);
    }

    /* trimestre, PK */
    public int getTrimestre() {
        return trimestre;
    }

    /* trimestre, PK */
    public void setTrimestre(int trimestre) {
        this.trimestre = trimestre;
        _key.setTrimestre(trimestre);
    }

    /* nombreArticulo */
    public String getNombrearticulo() {
        return nombrearticulo;
    }

    /* nombreArticulo */
    public void setNombrearticulo(String nombrearticulo) {
        this.nombrearticulo = nombrearticulo;
    }

    /* nombreProveedor */
    public String getNombreproveedor() {
        return nombreproveedor;
    }

    /* nombreProveedor */
    public void setNombreproveedor(String nombreproveedor) {
        this.nombreproveedor = nombreproveedor;
    }

    /* piezasVendidas */
    public int getPiezasvendidas() {
        return piezasvendidas;
    }

    /* piezasVendidas */
    public void setPiezasvendidas(int piezasvendidas) {
        this.piezasvendidas = piezasvendidas;
    }

    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof Detalledeventa))
            return false;

        Detalledeventa bean = (Detalledeventa) obj;

        if (this.nombretienda == null) {
            if (bean.nombretienda != null)
                return false;
        }
        else if (!this.nombretienda.equals(bean.nombretienda)) 
            return false;

        if (this.idventa != bean.idventa)
            return false;

        if (this.anio != bean.anio)
            return false;

        if (this.trimestre != bean.trimestre)
            return false;

        if (this.nombrearticulo == null) {
            if (bean.nombrearticulo != null)
                return false;
        }
        else if (!this.nombrearticulo.equals(bean.nombrearticulo)) 
            return false;

        if (this.nombreproveedor == null) {
            if (bean.nombreproveedor != null)
                return false;
        }
        else if (!this.nombreproveedor.equals(bean.nombreproveedor)) 
            return false;

        if (this.piezasvendidas != bean.piezasvendidas)
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        Detalledeventa bean = new Detalledeventa();
        bean.nombretienda = this.nombretienda;
        bean.idventa = this.idventa;
        bean.anio = this.anio;
        bean.trimestre = this.trimestre;
        bean.nombrearticulo = this.nombrearticulo;
        bean.nombreproveedor = this.nombreproveedor;
        bean.piezasvendidas = this.piezasvendidas;
        return bean;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("nombretienda").append(" = ").append(nombretienda).append("]").append(sep);
        sb.append("[").append("idventa").append(" = ").append(idventa).append("]").append(sep);
        sb.append("[").append("anio").append(" = ").append(anio).append("]").append(sep);
        sb.append("[").append("trimestre").append(" = ").append(trimestre).append("]").append(sep);
        sb.append("[").append("nombrearticulo").append(" = ").append(nombrearticulo).append("]").append(sep);
        sb.append("[").append("nombreproveedor").append(" = ").append(nombreproveedor).append("]").append(sep);
        sb.append("[").append("piezasvendidas").append(" = ").append(piezasvendidas).append("]").append(sep);
        return sb.toString();
    }
}
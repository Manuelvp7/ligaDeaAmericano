/*
 * This java source file is generated by DAO4J v1.19
 * Generated on Mon Mar 05 02:22:23 CST 2018
 * For more information, please contact b-i-d@163.com
 * Please check http://sourceforge.net/projects/dao4j/ for the latest version.
 */

package modelo;

public class TiendatienearticuloKey implements java.io.Serializable, Cloneable {
    /* nombreTienda */
    protected String nombretienda;

    /* nombreArticulo */
    protected String nombrearticulo;

    /* nombreProveedor */
    protected String nombreproveedor;

    
    public TiendatienearticuloKey(String tienda, String nombre, String proveedor){
        
        this.nombrearticulo = nombre;
        this.nombreproveedor = proveedor;
        this.nombretienda = tienda;
        
    }
    
   
    
    public TiendatienearticuloKey(){
        
    }
    /* nombreTienda */
    public String getNombretienda() {
        return nombretienda;
    }

    /* nombreTienda */
    public void setNombretienda(String nombretienda) {
        this.nombretienda = nombretienda;
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

    /* Calculate hash code */
    public int hashCode() {
        int hashCode = 0;
        if (nombretienda != null)  
            hashCode += nombretienda.hashCode();
        if (nombrearticulo != null)  
            hashCode += nombrearticulo.hashCode();
        if (nombreproveedor != null)  
            hashCode += nombreproveedor.hashCode();
        return hashCode;
    }
    
    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof TiendatienearticuloKey))
            return false;

        TiendatienearticuloKey key = (TiendatienearticuloKey) obj;

        if (this.nombretienda == null) {
            if (key.nombretienda != null)
                return false;
        }
        else if (!this.nombretienda.equals(key.nombretienda)) 
            return false;

        if (this.nombrearticulo == null) {
            if (key.nombrearticulo != null)
                return false;
        }
        else if (!this.nombrearticulo.equals(key.nombrearticulo)) 
            return false;

        if (this.nombreproveedor == null) {
            if (key.nombreproveedor != null)
                return false;
        }
        else if (!this.nombreproveedor.equals(key.nombreproveedor)) 
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        TiendatienearticuloKey key = new TiendatienearticuloKey();
        key.nombretienda = this.nombretienda;
        key.nombrearticulo = this.nombrearticulo;
        key.nombreproveedor = this.nombreproveedor;
        return key;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("nombretienda").append(" = ").append(nombretienda).append("]");
        sb.append("[").append("nombrearticulo").append(" = ").append(nombrearticulo).append("]");
        sb.append("[").append("nombreproveedor").append(" = ").append(nombreproveedor).append("]");
        return sb.toString();
    }
}
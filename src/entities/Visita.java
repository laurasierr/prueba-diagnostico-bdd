package entities;

/**
 *
 * @author Laura Sierra
 */
public class Visita {
    private Vendedor vendedor;
    private Zona zona;
    private String fecha;
    private Integer dinero;

    public Visita(String fecha, Integer dinero) {
        this.vendedor = null;
        this.zona = null;
        this.fecha = fecha;
        this.dinero = dinero;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getDinero() {
        return dinero;
    }

    public void setDinero(Integer dinero) {
        this.dinero = dinero;
    }
    
}

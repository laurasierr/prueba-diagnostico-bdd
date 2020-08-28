package entities;
import java.util.*;

/**
 *
 * @author Laura Sierra
 */
public class Vendedor {
    private Integer id;
    private String nombre;
    private Integer edad;
    private Integer salario;
    private Vendedor jefe; // Relacion de uno a uno
    private List<Vendedor> vendedores; // Relacion de uno a muchos

    public Vendedor(String nombre, Integer edad, Integer salario) {
        this.id = new Random().nextInt(1000);
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
        this.jefe = null;
        this.vendedores = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    public Vendedor getJefe() {
        return jefe;
    }

    public void setJefe(Vendedor jefe) {
        this.jefe = jefe;
    }

    public List<Vendedor> getVendedores() {
        return new ArrayList<>(this.vendedores);
    }

    public void addVendedor(Vendedor subordinado) {
        this.vendedores.add(subordinado);
    }

    @Override
    public String toString() {
        return "Vendedor{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
}

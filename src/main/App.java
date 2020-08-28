package main;

import entities.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author Laura Sierra
 */
public class App {

    private static List<Zona> zonas = new ArrayList<>();
    private static List<Visita> visitas = new ArrayList<>();
    private static List<Vendedor> vendedores = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        initVisitas();
        String nombre = "";
        boolean exit = false;
        System.out.println("El Directorio Ordenado de Vendedores Es:\n");
        List<Vendedor> directorio = getDirectorio();
        directorio.forEach(System.out::println);//para cada elemento en el directorio lo mostramos en consola
        System.out.println("-----------------------------------------------");
        do {
            Scanner scanner = new Scanner(System.in); //Clase que lee cualquier entrada de texto que ahora lee de consola
            System.out.print("Digite el nombre del vendedor: ");
            nombre = scanner.next().trim();
            exit = "exit".equalsIgnoreCase(nombre);
            if (!exit) {
                System.out.println(String.format("El Dinero Totalizado de %s es %d", nombre, getDineroByVendedor(nombre)));
                System.out.println("-----------------------------------------------");
            }
        } while (!exit);
      
    }

    public static void initVisitas() {
        initZonas();
        initVendedores("Miguel", "Laura", "Santiago", "Fay");
        Visita visita = null;
        visita = new Visita("Agosto 2020", 30000);
        visita.setVendedor(getVendedorByNombre("Miguel"));
        visita.setZona(getZonaById(123));
        visitas.add(visita);

        visita = new Visita("Enero 2020", 65200);
        visita.setVendedor(getVendedorByNombre("Miguel"));
        visita.setZona(getZonaById(456));
        visitas.add(visita);

        visita = new Visita("Agosto 2020", 27100);
        visita.setVendedor(getVendedorByNombre("Fay"));
        visita.setZona(getZonaById(123));
        visitas.add(visita);
    }

    private static Integer getDineroByVendedor(String nombre) {
        int sumaTotal = 0;
        for (Visita visita : visitas) {
            if (visita.getVendedor().getNombre().equals(nombre)) {
                sumaTotal += visita.getDinero();
            }
        }
        return sumaTotal;
    }

    private static List<Vendedor> getDirectorio() {
        // Devuelve una lista con los verndedores ordenados de forma alfabetica
        List<Vendedor> copia = new ArrayList<>(vendedores);
        Collections.sort(copia, new Comparator<Vendedor>() {
            public int compare(Vendedor uno, Vendedor dos) {
                return uno.getNombre().compareTo(dos.getNombre());
            }
        });

        return copia;
    }

    public static void initZonas() {
        Zona zona = null;
        zona = new Zona(123, "Zona Uno");
        zonas.add(zona);
        zona = new Zona(321, "Zona Dos");
        zonas.add(zona);
        zona = new Zona(456, "Zona Tres");
        zonas.add(zona);
    }

    public static Zona getZonaById(Integer codigo) {
        for (Zona zona : zonas) {
            if (zona.getCodigo() == codigo) {
                return zona;
            }
        }

        return null;
    }

    private static void initVendedores(String... nombres) {
        Vendedor vendedor = null;
        for (String nombre : nombres) {
            vendedor = new Vendedor(nombre, new Random().nextInt(99), 100000);
            vendedores.add(vendedor);
        }
    }

    private static Vendedor getVendedorByNombre(String nombre) {
        // Asumiendo que el nombre sea unico
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getNombre().equals(nombre)) {
                return vendedor;
            }
        }

        return null;
    }
}

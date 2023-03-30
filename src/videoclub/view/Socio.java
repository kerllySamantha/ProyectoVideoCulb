package view;

import java.util.ArrayList;

public class Socio {
    private String nif;
    private String nombre;
    private String fechaNac;
    private String poblacion;
    private int recargo;
    private ArrayList <Multimedia> historial;
    private ArrayList <Multimedia> alquilerActual;

    public Socio() {
        nif = "";
        nombre = "";
        fechaNac = "";
        poblacion = "";
        recargo = 0;
        historial = new ArrayList<>();
        alquilerActual = new ArrayList<>();
    }

    public Socio(String nif, String nombre, String fechaNac, String poblacion) {
        this();
        setNif(nif);
        setNombre(nombre);
        setFechaNac(fechaNac);
        setPoblacion(poblacion);
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {

        this.fechaNac = fechaNac;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public int getRecargo() {
        return recargo;
    }

    public void setRecargo(int recargo) {
        this.recargo = recargo;
    }

    public ArrayList<Multimedia> getHistorial() {
        return historial;
    }

    public ArrayList<Multimedia> getAlquilerActual() {
        return alquilerActual;
    }

    public String toString() {
        return "NIF: " + getNif() +
                "\nNombre: " + getNombre() +
                "\nFecha de nacimiento: " + getFechaNac() +
                "\nPoblación: " + getPoblacion() +
                "\nCargo: " + getRecargo();
    }
}

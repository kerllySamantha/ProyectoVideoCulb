package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Socio {
    public static final int RECARGO_POR_DEFECTO = 0;
    private String nif;
    private String nombre;
    private LocalDate fechaNac;
    private String poblacion;
    private double recargo;
    private ArrayList <Multimedia> historial;
    private ArrayList <Multimedia> alquilerActual;

    public Socio(String nif, String nombre, LocalDate fechaNac, String poblacion) {
        setNif(nif);
        setNombre(nombre);
        setFechaNac(fechaNac);
        setPoblacion(poblacion);
        recargo = RECARGO_POR_DEFECTO;
        historial = new ArrayList<>();
        alquilerActual = new ArrayList<>();
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

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {

        this.fechaNac = fechaNac;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public double getRecargo() {
        return recargo;
    }

    public void setRecargo(double recargo) {
        this.recargo = recargo;
    }

    public ArrayList<Multimedia> getHistorial() {
        return historial;
    }

    public ArrayList<Multimedia> getAlquilerActual() {
        return alquilerActual;
    }

    public static boolean calcularEdad(String fecha) {
        String [] partesFecha = fecha.split("/");
        LocalDate fechaNac = LocalDate.of(Integer.parseInt(partesFecha[2]), Integer.parseInt(partesFecha[1]), Integer.parseInt(partesFecha[0]));
        LocalDate fechaActual = LocalDate.now();
        Period period = Period.between(fechaNac, fechaActual);
        int edad = period.getYears();
        if (edad > 18) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "NIF: " + getNif() +
                "\nNombre: " + getNombre() +
                "\nFecha de nacimiento: " + getFechaNac() +
                "\nPoblación: " + getPoblacion() +
                "\nCargo: " + getRecargo();
    }
}
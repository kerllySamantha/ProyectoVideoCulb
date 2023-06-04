package model;

import controller.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Socio {
    public static final int RECARGO_POR_DEFECTO = 0;
    private String nif, nombre, poblacion;
    private LocalDate fechaNac;

    private int recargo;

    private ArrayList <GestionAlquilerMul> alquilerActual;

    public Socio(String nif, String nombre, LocalDate fechaNac, String poblacion) {
        setNif(nif);
        setNombre(nombre);
        setFechaNac(fechaNac);
        setPoblacion(poblacion);
        setRecargo(RECARGO_POR_DEFECTO);
        alquilerActual = new ArrayList<>();
    }
    public Socio(String nif, String nombre, LocalDate fechaNac, String poblacion, int recargo) {
        setNif(nif);
        setNombre(nombre);
        setFechaNac(fechaNac);
        setPoblacion(poblacion);
        setRecargo(recargo);
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

    public int getRecargo() {
        return recargo;
    }

    public void setRecargo(int recargo) {
        this.recargo = recargo;
    }


    public ArrayList<GestionAlquilerMul> getAlquilerActual() {
        return alquilerActual;
    }

    public static boolean calcularEdad(String fecha) {
        String [] partesFecha = fecha.split("/");
        LocalDate fechaNac = LocalDate.of(Integer.parseInt(partesFecha[2]), Integer.parseInt(partesFecha[1]), Integer.parseInt(partesFecha[0]));
        LocalDate fechaActual = LocalDate.now();
        Period period = Period.between(fechaNac, fechaActual);
        int edad = period.getYears();
        return edad > 18;
    }

    @Override
    public boolean equals(Object obj) {
        Socio s = (Socio) obj;
        return (s.getNif().equals(getNif()));
    }

    public String toString() {
        return "NIF: " + getNif() +
                "\nNombre: " + getNombre() +
                "\nFecha de nacimiento: " + getFechaNac() +
                "\nPoblación: " + getPoblacion() +
                "\nRecargo: " + getRecargo();
    }
}
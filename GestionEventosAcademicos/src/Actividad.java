/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public abstract class Actividad {
    protected String nombre;
    protected double costoBase;
    
    public Actividad(String nombre, double costoBase) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la actividad no debe estar vacio.");
        }
        if (costoBase <= 0) {
            throw new IllegalArgumentException("El costo base debe ser mayor que cero.");
        }
        this.nombre = nombre;
        this.costoBase = costoBase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        }
    }

    public double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(double costoBase) {
        if (costoBase > 0) {
            this.costoBase = costoBase;
        }
    }

    public abstract double calcularCosto();

    public abstract void mostrarInfo();

    String setCostoBase() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
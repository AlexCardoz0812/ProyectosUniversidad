/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class Taller extends Actividad {
    private double costoMaterial;

    public Taller(String nombre, double costoBase, double costoMaterial) {
        super(nombre, costoBase);
        if (costoMaterial <= 0) {
            throw new IllegalArgumentException("El costo de material debe ser mayor que cero.");
        }
        this.costoMaterial = costoMaterial;
    }

    public double getCostoMaterial() {
        return costoMaterial;
    }

    public void setCostoMaterial(double costoMaterial) {
        if (costoMaterial > 0) {
            this.costoMaterial = costoMaterial;
        }
    }

    @Override
    public double calcularCosto() {
        return costoBase + costoMaterial;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Tipo: Taller");
        System.out.println("Nombre: " + nombre);
        System.out.println("Costo Base: $" + costoBase);
        System.out.println("Costo Material: $" + costoMaterial);
        System.out.println("Costo Final: $" + calcularCosto());
        System.out.println("----------------------------------------");
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class Conferencia extends Actividad {
    private double porcentajeDescuento;

    public Conferencia(String nombre, double costoBase, double porcentajeDescuento) {
        super(nombre, costoBase);
        if (porcentajeDescuento < 0 || porcentajeDescuento > 100) {
            throw new IllegalArgumentException("El porcentaje de descuento debe estar entre 0 y 100.");
        }
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        if (porcentajeDescuento >= 0 && porcentajeDescuento <= 100) {
            this.porcentajeDescuento = porcentajeDescuento;
        }
    }

    @Override
    public double calcularCosto() {
        return costoBase - (costoBase * porcentajeDescuento / 100.0);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Tipo: Conferencia");
        System.out.println("Nombre: " + nombre);
        System.out.println("Costo Base: $" + costoBase);
        System.out.println("Descuento (" + porcentajeDescuento + "%): $" + (costoBase * porcentajeDescuento / 100.0));
        System.out.println("Costo Final: $" + calcularCosto());
        System.out.println("----------------------------------------");
    }
}
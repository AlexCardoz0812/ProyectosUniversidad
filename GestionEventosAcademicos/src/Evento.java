/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
import java.util.ArrayList;

public class Evento {
    private String nombre;
    private ArrayList<Actividad> actividades;

    public Evento(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del evento no debe estar vacio.");
        }
        this.nombre = nombre;
        this.actividades = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        }
    }

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    public void agregarActividad(Actividad actividad) {
        if (actividad != null) {
            actividades.add(actividad);
        }
    }

    public double calcularCostoTotal() {
        double acumulado = 0;
        for (Actividad actividad : actividades) {
            acumulado += actividad.calcularCosto();
        }
        return acumulado;
    }
}
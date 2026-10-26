/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Evento evento = null;
        Taller taller = null;
        Conferencia conferencia = null;
        ArrayList<Actividad> listaActividades = new ArrayList<>();

        int opcion = 0;

        do {
            System.out.println("\n==================================================");
            System.out.println("     SISTEMA DE GESTION DE EVENTOS ACADEMICOS     ");
            System.out.println("==================================================");
            System.out.println("1. [Paso 1] Crear un Evento");
            System.out.println("2. [Paso 2] Crear un Taller");
            System.out.println("3. [Paso 3] Crear una Conferencia");
            System.out.println("4. [Paso 4] Inicializar ArrayList<Actividad>");
            System.out.println("5. [Paso 5] Registrar Actividades en la Lista y en el Evento");
            System.out.println("6. [Paso 6] Recorrer Lista y Mostrar Informacion");
            System.out.println("7. [Paso 7] Calcular y Mostrar Costo Final de cada Actividad");
            System.out.println("8. [Paso 8] Calcular Costo Total del Evento");
            System.out.println("9. [Extra] Guardar reporte en archivo de texto (.txt)");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opcion (1-10): ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
                System.out.println("--------------------------------------------------");

                switch (opcion) {
                    case 1 -> {
                        System.out.println("--> PASO 1: Crear un Evento");
                        System.out.print("Ingrese el nombre del evento: ");
                        String nombreEvento = sc.nextLine();
                        evento = new Evento(nombreEvento);
                        System.out.println("\n[RESULTADO ESPERADO]: Objeto Evento inicializado.");
                        System.out.println("Evento creado con exito: " + evento.getNombre());
                    }

                    case 2 -> {
                        System.out.println("--> PASO 2: Crear un Taller");
                        System.out.print("Ingrese el nombre del taller: ");
                        String nomTaller = sc.nextLine();

                        System.out.print("Ingrese el costo base ($): ");
                        double cBaseTaller = Double.parseDouble(sc.nextLine());

                        System.out.print("Ingrese el costo de materiales ($): ");
                        double cMatTaller = Double.parseDouble(sc.nextLine());

                        taller = new Taller(nomTaller, cBaseTaller, cMatTaller);
                        System.out.println("\n[RESULTADO ESPERADO]: Objeto Taller valido.");
                        System.out.println("Taller registrado correctamente.");
                    }

                    case 3 -> {
                        System.out.println("--> PASO 3: Crear una Conferencia");
                        System.out.print("Ingrese el nombre de la conferencia: ");
                        String nomConf = sc.nextLine();

                        System.out.print("Ingrese el costo base ($): ");
                        double cBaseConf = Double.parseDouble(sc.nextLine());

                        System.out.print("Ingrese el porcentaje de descuento (0 - 100): ");
                        double descConf = Double.parseDouble(sc.nextLine());

                        conferencia = new Conferencia(nomConf, cBaseConf, descConf);
                        System.out.println("\n[RESULTADO ESPERADO]: Objeto Conferencia valido.");
                        System.out.println("Conferencia registrada correctamente.");
                    }

                    case 4 -> {
                        System.out.println("--> PASO 4: Crear un ArrayList<Actividad>");
                        listaActividades = new ArrayList<>();
                        System.out.println("[RESULTADO ESPERADO]: Lista capaz de almacenar ambos tipos.");
                        System.out.println("ArrayList<Actividad> inicializado en memoria.");
                    }

                    case 5 -> {
                        System.out.println("--> PASO 5: Agregar las Actividades a la lista y al Evento");
                        if (evento == null) {
                            System.out.println(" Error: Primero debe crear un Evento (Opción 1).");
                            break;
                        }
                        if (taller == null && conferencia == null) {
                            System.out.println(" Error: Debe crear al menos una actividad (Taller o Conferencia).");
                            break;
                        }

                        listaActividades.clear();
                        evento.getActividades().clear();

                        if (taller != null) {
                            listaActividades.add(taller);
                            evento.agregarActividad(taller);
                        }
                        if (conferencia != null) {
                            listaActividades.add(conferencia);
                            evento.agregarActividad(conferencia);
                        }

                        System.out.println("[RESULTADO ESPERADO]: Dos Actividades registradas sin duplicar su calculo.");
                        System.out.println("Actividades asociadas exitosamente al evento '" + evento.getNombre() + "'.");
                        System.out.println("Total de actividades registradas: " + evento.getActividades().size());
                    }

                    case 6 -> {
                        System.out.println("--> PASO 6: Recorrer la lista");
                        if (listaActividades.isEmpty()) {
                            System.out.println(" La lista de actividades esta vacia. Ejecute el Paso 5 primero.");
                        } else {
                            System.out.println("[RESULTADO ESPERADO]: Informacion individual de cada Actividad.\n");
                            for (Actividad act : listaActividades) {
                                act.mostrarInfo();
                            }
                        }
                    }

                    case 7 -> {
                        System.out.println("--> PASO 7: Calcular el costo final de cada actividad");
                        if (listaActividades.isEmpty()) {
                            System.out.println(" La lista de actividades esta vacia. Ejecute el Paso 5 primero.");
                        } else {
                            System.out.println("[RESULTADO ESPERADO]: Calculos correspondientes aplicados.\n");
                            for (Actividad act : listaActividades) {
                                System.out.println("Costo final de '" + act.getNombre() + "': $" + act.calcularCosto());
                            }
                        }
                    }

                    case 8 -> {
                        System.out.println("--> PASO 8: Calcular el costo del evento");
                        if (evento == null) {
                            System.out.println(" Error: No existe un Evento registrado.");
                        } else if (evento.getActividades().isEmpty()) {
                            System.out.println(" Error: El evento no tiene actividades asignadas. Ejecute el Paso 5.");
                        } else {
                            System.out.println("[RESULTADO ESPERADO]: Suma de los costos finales.\n");
                            double total = evento.calcularCostoTotal();
                            System.out.println("==================================================");
                            System.out.println(" EVENTO: " + evento.getNombre());
                            System.out.println(" COSTO TOTAL DEL EVENTO: $" + total);
                            System.out.println("==================================================");
                        }
                    }

                    case 9 -> {
                        System.out.println("--> Guardar reporte en archivo de texto");
                        if (evento == null || evento.getActividades().isEmpty()) {
                            System.out.println(" Error: No hay un evento con actividades asignadas para guardar.");
                        } else {
                            guardarReporteEnArchivo(evento);
                        }
                    }

                    case 10 -> System.out.println("Saliendo de la aplicacion...");

                    default -> System.out.println(" Opcion no valida. Ingrese un numero entre 1 y 10.");
                }

            } catch (NumberFormatException e) {
                System.out.println(" Error: Ingrese un numero válido.");
            } catch (IllegalArgumentException e) {
                System.out.println(" Error de Validación: " + e.getMessage());
            }

        } while (opcion != 10);

        sc.close();
    }

    /**
     * Método auxiliar para escribir el reporte en un archivo .txt
     */
    private static void guardarReporteEnArchivo(Evento evento) {
        String nombreArchivo = "reporte_evento.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            writer.println("==================================================");
            writer.println("     REPORTE DE EVENTO ACADEMICO Y ACTIVIDADES     ");
            writer.println("==================================================");
            writer.println("Nombre del Evento: " + evento.getNombre());
            writer.println("Cantidad de Actividades: " + evento.getActividades().size());
            writer.println("--------------------------------------------------\n");

            writer.println("DETALLE DE LAS ACTIVIDADES:");
            for (Actividad act : evento.getActividades()) {
                if (act instanceof Taller) {
                    Taller t = (Taller) act;
                    writer.println("Tipo: Taller");
                    writer.println("Nombre: " + t.getNombre());
                    writer.println("Costo Base: $" + t.getCostoBase());
                    writer.println("Costo Material: $" + t.getCostoMaterial());
                    writer.println("Costo Final: $" + t.calcularCosto());
                } else if (act instanceof Conferencia) {
                    Conferencia c = (Conferencia) act;
                    writer.println("Tipo: Conferencia");
                    writer.println("Nombre: " + c.getNombre());
                    writer.println("Costo Base: $" + c.getCostoBase());
                    writer.println("Porcentaje Descuento: " + c.getPorcentajeDescuento() + "%");
                    writer.println("Costo Final: $" + c.calcularCosto());
                }
                writer.println("--------------------------------------------------");
            }

            writer.println("\n==================================================");
            writer.println("COSTO TOTAL DEL EVENTO: $" + evento.calcularCostoTotal());
            writer.println("==================================================");

            System.out.println(" Reporte guardado con exito en el archivo '" + nombreArchivo + "'.");
            System.out.println(" Ubicacion: Se encuentra en la carpeta raiz de tu proyecto NetBeans.");

        } catch (IOException e) {
            System.out.println(" Error al intentar guardar el archivo: " + e.getMessage());
        }
    }
}
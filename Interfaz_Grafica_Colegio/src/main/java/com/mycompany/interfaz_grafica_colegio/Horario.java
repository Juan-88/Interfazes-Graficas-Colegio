/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfaz_grafica_colegio;

/**
 *
 * @author Juan David
 */
public class Horario {
    String dia;
    String horaInicio;
    String horaFin;

    public Horario(String dia, String horaInicio, String horaFin) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String mostrarInfo() {
        return "Día: " + dia + "\nHora de Inicio: " + horaInicio + "\nHora de Fin: " + horaFin + "\n";
    }
}

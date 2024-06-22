/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfaz_grafica_colegio;

/**
 *
 * @author Juan David
 */
import java.util.ArrayList;

public class Profesor {
    String nombre;
    String apellido;
    ArrayList<Asignatura> asignaturas;

    public Profesor(String nombre, String apellido, ArrayList<Asignatura> asignaturas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.asignaturas = asignaturas;
    }

    public String mostrarInfo() {
        String info = "Nombre del profesor: " + nombre + " " + apellido + "\n";
        info += "Asignaturas a cargo: \n";
        for (Asignatura asignatura : asignaturas) {
            info += asignatura.mostrarInfo();
        }
        return info;
    }
}
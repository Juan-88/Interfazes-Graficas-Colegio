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

public class Curso {
    String nombre;
    Profesor profesor;
    ArrayList<Estudiante> estudiantes;
    Horario horario;

    public Curso(String nombre, Profesor profesor, Horario horario) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.estudiantes = new ArrayList<>();
        this.horario = horario;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public String mostrarInfo() {
        String info = "Curso: " + nombre + "\n";
        info += profesor.mostrarInfo();
        info += horario.mostrarInfo();
        for (Estudiante estudiante : estudiantes) {
            info += estudiante.mostrarInfo();
        }
        return info;
    }
}

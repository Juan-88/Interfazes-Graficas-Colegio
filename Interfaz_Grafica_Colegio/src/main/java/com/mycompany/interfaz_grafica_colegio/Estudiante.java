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

public class Estudiante {
    String nombre;
    String apellido;
    String idEstudiante;
    ArrayList<Curso> cursos;

    public Estudiante(String nombre, String apellido, String idEstudiante) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idEstudiante = idEstudiante;
        this.cursos = new ArrayList<>();
    }

    public String mostrarInfo() {
        String info = "Nombre del estudiante: " + nombre + " " + apellido + "\n";
        info += "ID Estudiante: " + idEstudiante + "\n";
        info += "Cursos inscritos:\n";
        for (Curso curso : cursos) {
            info += curso.nombre + "\n";
        }
        return info;
    }
}

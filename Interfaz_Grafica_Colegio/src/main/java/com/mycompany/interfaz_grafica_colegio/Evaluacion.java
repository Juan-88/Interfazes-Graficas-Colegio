/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfaz_grafica_colegio;

/**
 *
 * @author Juan David
 */

public class Evaluacion {
    Curso curso;
    Estudiante estudiante;
    String nota;

    public Evaluacion(Curso curso, Estudiante estudiante, String nota) {
        this.curso = curso;
        this.estudiante = estudiante;
        this.nota = nota;
    }

    public String mostrarInfo() {
        return "Curso: " + curso.nombre + "\nEstudiante: " + estudiante.nombre + " " + estudiante.apellido + "\nNota: " + nota + "\n";
    }
}

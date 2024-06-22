/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfaz_grafica_colegio;

/**
 *
 * @author Juan David
 */

public class Asignatura {
    String nombre;

    public Asignatura(String nombre) {
        this.nombre = nombre;
    }

    public String mostrarInfo() {
        return "- " + nombre + "\n";
    }
}


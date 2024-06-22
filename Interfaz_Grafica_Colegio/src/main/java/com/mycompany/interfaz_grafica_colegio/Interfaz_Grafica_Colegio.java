/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.interfaz_grafica_colegio;

/**
 *
 * @author Juan David
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Interfaz_Grafica_Colegio {
    private static final ArrayList<Profesor> profesores = new ArrayList<>();
    private static final ArrayList<Curso> cursos = new ArrayList<>();
    private static final ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private static final ArrayList<Asignatura> asignaturas = new ArrayList<>();
    private static final ArrayList<Evaluacion> evaluaciones = new ArrayList<>();

    private static JTextField estudianteNombreEntry;
    private static JTextField estudianteApellidoEntry;
    private static JTextField estudianteIdEntry;
    private static JTextField profesorNombreEntry;
    private static JTextField profesorApellidoEntry;
    private static JComboBox<String> asignaturasComboBox;
    private static JTextField cursoNombreEntry;
    private static JComboBox<String> profesorSeleccionadoComboBox;
    private static JTextField cursoDiaEntry;
    private static JTextField cursoHoraInicioEntry;
    private static JTextField cursoHoraFinEntry;
    private static JComboBox<String> estudianteSeleccionadoEvalComboBox;
    private static JComboBox<String> cursoSeleccionadoEvalComboBox;
    private static JTextField evaluacionNotaEntry;
    private static JComboBox<String> cursosComboBox;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema de Gestión de Cursos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 1));

        // Panel de registro de estudiante
        JPanel estudiantePanel = new JPanel(new GridLayout(4, 2));
        estudiantePanel.setBorder(BorderFactory.createTitledBorder("Registro de Estudiante"));
        estudiantePanel.setBackground(Color.BLUE);
        estudianteNombreEntry = new JTextField();
        estudianteApellidoEntry = new JTextField();
        estudianteIdEntry = new JTextField();
        estudiantePanel.add(new JLabel("Nombre:"));
        estudiantePanel.add(estudianteNombreEntry);
        estudiantePanel.add(new JLabel("Apellido:"));
        estudiantePanel.add(estudianteApellidoEntry);
        estudiantePanel.add(new JLabel("ID Estudiante:"));
        estudiantePanel.add(estudianteIdEntry);
        JButton registrarEstudianteButton = new JButton("Registrar Estudiante");
        registrarEstudianteButton.addActionListener(e -> registrarEstudiante());
        estudiantePanel.add(registrarEstudianteButton);
        frame.add(estudiantePanel);

        // Panel de registro de profesor
        JPanel profesorPanel = new JPanel(new GridLayout(4, 2));
        profesorPanel.setBorder(BorderFactory.createTitledBorder("Registro de Profesor"));
        profesorPanel.setBackground(Color.BLUE);
        profesorNombreEntry = new JTextField();
        profesorApellidoEntry = new JTextField();
        asignaturasComboBox = new JComboBox<>();
        for (Asignatura asignatura : asignaturas) {
            asignaturasComboBox.addItem(asignatura.nombre);
        }
        profesorPanel.add(new JLabel("Nombre:"));
        profesorPanel.add(profesorNombreEntry);
        profesorPanel.add(new JLabel("Apellido:"));
        profesorPanel.add(profesorApellidoEntry);
        profesorPanel.add(new JLabel("Asignaturas a cargo:"));
        profesorPanel.add(asignaturasComboBox);
        JButton registrarProfesorButton = new JButton("Registrar Profesor");
        registrarProfesorButton.addActionListener(e -> registrarProfesor());
        profesorPanel.add(registrarProfesorButton);
        frame.add(profesorPanel);

        // Panel de registro de curso
        JPanel cursoPanel = new JPanel(new GridLayout(6, 2));
        cursoPanel.setBorder(BorderFactory.createTitledBorder("Registro de Curso"));
        cursoPanel.setBackground(Color.BLUE);
        cursoNombreEntry = new JTextField();
        profesorSeleccionadoComboBox = new JComboBox<>();
        for (Profesor profesor : profesores) {
            profesorSeleccionadoComboBox.addItem(profesor.nombre);
        }
        cursoDiaEntry = new JTextField();
        cursoHoraInicioEntry = new JTextField();
        cursoHoraFinEntry = new JTextField();
        cursoPanel.add(new JLabel("Nombre:"));
        cursoPanel.add(cursoNombreEntry);
        cursoPanel.add(new JLabel("Profesor:"));
        cursoPanel.add(profesorSeleccionadoComboBox);
        cursoPanel.add(new JLabel("Día:"));
        cursoPanel.add(cursoDiaEntry);
        cursoPanel.add(new JLabel("Hora de inicio:"));
        cursoPanel.add(cursoHoraInicioEntry);
        cursoPanel.add(new JLabel("Hora de fin:"));
        cursoPanel.add(cursoHoraFinEntry);
        JButton registrarCursoButton = new JButton("Registrar Curso");
        registrarCursoButton.addActionListener(e -> registrarCurso());
        cursoPanel.add(registrarCursoButton);
        frame.add(cursoPanel);

        // Panel de realización de evaluación
        JPanel evaluacionPanel = new JPanel(new GridLayout(4, 2));
        evaluacionPanel.setBorder(BorderFactory.createTitledBorder("Realizar Evaluación"));
        evaluacionPanel.setBackground(Color.BLUE);
        estudianteSeleccionadoEvalComboBox = new JComboBox<>();
        for (Estudiante estudiante : estudiantes) {
            estudianteSeleccionadoEvalComboBox.addItem(estudiante.nombre);
        }
        cursoSeleccionadoEvalComboBox = new JComboBox<>();
        for (Curso curso : cursos) {
            cursoSeleccionadoEvalComboBox.addItem(curso.nombre);
        }
        evaluacionNotaEntry = new JTextField();
        evaluacionPanel.add(new JLabel("Estudiante:"));
        evaluacionPanel.add(estudianteSeleccionadoEvalComboBox);
        evaluacionPanel.add(new JLabel("Curso:"));
        evaluacionPanel.add(cursoSeleccionadoEvalComboBox);
        evaluacionPanel.add(new JLabel("Nota:"));
        evaluacionPanel.add(evaluacionNotaEntry);
        JButton realizarEvaluacionButton = new JButton("Realizar Evaluación");
        realizarEvaluacionButton.addActionListener(e -> realizarEvaluacion());
        evaluacionPanel.add(realizarEvaluacionButton);
        frame.add(evaluacionPanel);

        // Panel de mostrar información del curso
        JPanel mostrarInfoPanel = new JPanel(new GridLayout(2, 1));
        mostrarInfoPanel.setBorder(BorderFactory.createTitledBorder("Mostrar Información del Curso"));
        mostrarInfoPanel.setBackground(Color.BLUE);
        cursosComboBox = new JComboBox<>();
        for (Curso curso : cursos) {
            cursosComboBox.addItem(curso.nombre);
        }
        JButton mostrarInfoCursoButton = new JButton("Mostrar Información del Curso");
        mostrarInfoCursoButton.addActionListener(e -> mostrarInfoCurso());
        mostrarInfoPanel.add(cursosComboBox);
        mostrarInfoPanel.add(mostrarInfoCursoButton);
        frame.add(mostrarInfoPanel);

        frame.pack();
        frame.setVisible(true);
    }

    private static void registrarEstudiante() {
        String nombre = estudianteNombreEntry.getText();
        String apellido = estudianteApellidoEntry.getText();
        String idEstudiante = estudianteIdEntry.getText();
        Estudiante estudiante = new Estudiante(nombre, apellido, idEstudiante);
        estudiantes.add(estudiante);
        JOptionPane.showMessageDialog(null, "Estudiante registrado correctamente.");
    }

    private static void registrarProfesor() {
        String nombre = profesorNombreEntry.getText();
        String apellido = profesorApellidoEntry.getText();
        ArrayList<Asignatura> asignaturasSeleccionadas = new ArrayList<>();
        asignaturasSeleccionadas.add(new Asignatura((String) asignaturasComboBox.getSelectedItem()));
        Profesor profesor = new Profesor(nombre, apellido, asignaturasSeleccionadas);
        profesores.add(profesor);
        JOptionPane.showMessageDialog(null, "Profesor registrado correctamente.");
    }

    private static void registrarCurso() {
        String nombre = cursoNombreEntry.getText();
        String profesorNombre = (String) profesorSeleccionadoComboBox.getSelectedItem();
        Profesor profesor = profesores.stream().filter(p -> p.nombre.equals(profesorNombre)).findFirst().orElse(null);
        Horario horario = new Horario(cursoDiaEntry.getText(), cursoHoraInicioEntry.getText(), cursoHoraFinEntry.getText());
        Curso curso = new Curso(nombre, profesor, horario);
        cursos.add(curso);
        JOptionPane.showMessageDialog(null, "Curso registrado correctamente.");
    }

    private static void realizarEvaluacion() {
        String estudianteNombre = (String) estudianteSeleccionadoEvalComboBox.getSelectedItem();
        Estudiante estudiante = estudiantes.stream().filter(e -> e.nombre.equals(estudianteNombre)).findFirst().orElse(null);
        String cursoNombre = (String) cursoSeleccionadoEvalComboBox.getSelectedItem();
        Curso curso = cursos.stream().filter(c -> c.nombre.equals(cursoNombre)).findFirst().orElse(null);
        String nota = evaluacionNotaEntry.getText();
        Evaluacion evaluacion = new Evaluacion(curso, estudiante, nota);
        evaluaciones.add(evaluacion);
        JOptionPane.showMessageDialog(null, "Evaluación realizada correctamente.");
    }

    private static void mostrarInfoCurso() {
        String cursoNombre = (String) cursosComboBox.getSelectedItem();
        Curso curso = cursos.stream().filter(c -> c.nombre.equals(cursoNombre)).findFirst().orElse(null);
        if (curso != null) {
            String info = curso.mostrarInfo();
            JOptionPane.showMessageDialog(null, info);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un curso primero.");
        }
    }
}
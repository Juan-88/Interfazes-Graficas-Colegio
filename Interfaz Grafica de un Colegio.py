import tkinter as tk
from tkinter import messagebox, simpledialog, ttk

class Curso:
    def __init__(self, nombre, profesor, horario):
        self.nombre = nombre
        self.profesor = profesor
        self.estudiantes = []
        self.horario = horario

    def agregar_estudiante(self, estudiante):
        self.estudiantes.append(estudiante)

    def mostrar_info(self):
        info += f"Curso: {self.nombre}"
        self.profesor.mostrar_info()
        self.horario.mostrar_info()
        for estudiante in self.estudiantes:
            info += estudiante.mostrar_info()
        return info

class Profesor:
    def __init__(self, nombre, apellido, asignatura):
        self.nombre = nombre
        self.apellido = apellido
        self.asignatura = asignatura

    def mostrar_info(self):
        info += f" Nombre del profesor: {self.nombre} {self.apellido}\n"
        info += f"Asignaturas a cargo: \n"
        for asignatura in self.asignatura:
            info += asignatura.mostrar_info()
        return info

class Estudiante:
    def __init__(self, nombre, apellido, id_estudiante, cursos):
        self.nombre = nombre
        self.apellido = apellido
        self.id_estudiante = id_estudiante
        self.cursos = cursos

    def mostrar_info(self):
        info += f"Nombre del estudiante: {self.nombre} {self.apellido}"
        info += f"ID Estudiante: {self.id_estudiante}"
        info += "Cursos inscritos:"
        for curso in self.cursos:
            info += curso.nombre
        return info

class Asignatura:
    def __init__(self, nombre):
        self.nombre = nombre

    def mostrar_info(self):
        return f"- {self.nombre}"

class Evaluacion:
    def __init__(self, curso, estudiante, nota):
        self.curso = curso
        self.estudiante = estudiante
        self.nota = nota

    def mostrar_info(self):
        print("Información de la Evaluación:")
        return f"Curso: {self.curso.nombre} \nEstudiante: {self.estudiante.nombre} {self.estudiante.apellido} \nNota: {self.nota}"

class Horario:
    def __init__(self, dia, hora_inicio, hora_fin):
        self.dia = dia
        self.hora_inicio = hora_inicio
        self.hora_fin = hora_fin

    def mostrar_info(self):
        return f"Día: {self.dia} \nHora de Inicio: {self.hora_inicio} \nHora de Fin: {self.hora_fin}"


def registrar_estudiante():
    nombre = estudiante_nombre_entry.get()
    apellido = estudiante_apellido_entry.get()
    id_estudiante = estudiante_id_entry.get()
    estudiante = Estudiante(nombre, apellido, id_estudiante)
    estudiantes.append(estudiante)
    messagebox.showinfo("Éxito", "Estudiante registrado correctamente.")

def registrar_profesor():
    nombre = profesor_nombre_entry.get()
    apellido = profesor_apellido_entry.get()
    asignaturas = [asignatura.nombre for asignatura in asignaturas]
    profesor = Profesor(nombre, apellido, asignaturas)
    profesores.append(profesor)
    messagebox.showinfo("Éxito", "Profesor registrado correctamente.")

def registrar_curso():
    nombre = curso_nombre_entry.get()
    profesor = profesor_seleccionado.get()
    horario = Horario(curso_dia_entry.get(), curso_hora_inicio_entry.get(), curso_hora_fin_entry.get())
    curso = Curso(nombre, profesor, horario)
    cursos.append(curso)
    messagebox.showinfo("Éxito", "Curso registrado correctamente.")

def realizar_evaluacion():
    estudiante = estudiante_seleccionado_eval.get()
    nota = evaluacion_nota_entry.get()
    evaluacion = Evaluacion(estudiante, nota)
    evaluaciones.append(evaluacion)
    messagebox.showinfo("Éxito", "Evaluación realizada correctamente.")

def mostrar_info_curso():
    curso_index = cursos_combobox.current()
    if curso_index >= 0:
        curso = cursos[curso_index]
        info = curso.mostrar_info()
        messagebox.showinfo("Información del Curso", info)
    else:
        messagebox.showerror("Error", "Seleccione un curso primero.")

profesores = []
cursos = []
estudiantes = []
asignaturas = []
evaluaciones = []

root = tk.Tk()
root.title("sistema de gestion de cursos")
root.configure(bg="blue")


estudiante_frame = ttk.LabelFrame(root, text="Registro de Estudiante")
estudiante_frame.grid(row=0, column=0, padx=10, pady=10, sticky="w")

ttk.Label(estudiante_frame, text="Nombre:").grid(row=0, column=0, padx=5, pady=5, sticky="w")
estudiante_nombre_entry = ttk.Entry(estudiante_frame)
estudiante_nombre_entry.grid(row=0, column=1, padx=5, pady=5, sticky="w")

ttk.Label(estudiante_frame, text="Apellido:").grid(row=1, column=0, padx=5, pady=5, sticky="w")
estudiante_apellido_entry = ttk.Entry(estudiante_frame)
estudiante_apellido_entry.grid(row=1, column=1, padx=5, pady=5, sticky="w")

ttk.Label(estudiante_frame, text="ID Estudiante:").grid(row=2, column=0, padx=5, pady=5, sticky="w")
estudiante_id_entry = ttk.Entry(estudiante_frame)
estudiante_id_entry.grid(row=2, column=1, padx=5, pady=5, sticky="w")

ttk.Button(estudiante_frame, text="Registrar Estudiante", command=registrar_estudiante).grid(row=3, column=0, columnspan=2, padx=5, pady=5)

# Registro de Profesor
profesor_frame = ttk.LabelFrame(root, text="Registro de Profesor")
profesor_frame.grid(row=1, column=0, padx=10, pady=10, sticky="w")

ttk.Label(profesor_frame, text="Nombre:").grid(row=0, column=0, padx=5, pady=5, sticky="w")
profesor_nombre_entry = ttk.Entry(profesor_frame)
profesor_nombre_entry.grid(row=0, column=1, padx=5, pady=5, sticky="w")

ttk.Label(profesor_frame, text="Apellido:").grid(row=1, column=0, padx=5, pady=5, sticky="w")
profesor_apellido_entry = ttk.Entry(profesor_frame)
profesor_apellido_entry.grid(row=1, column=1, padx=5, pady=5, sticky="w")

ttk.Label(profesor_frame, text="Asignaturas a cargo:").grid(row=2, column=0, padx=5, pady=5, sticky="w")
asignaturas_seleccionadas = []
for i, asignatura in enumerate(asignaturas):
    var = tk.BooleanVar()
    asignatura_checkbox = ttk.Checkbutton(profesor_frame, text=asignatura.nombre, variable=var)
    asignatura_checkbox.grid(row=2, column=i+1, padx=5, pady=5, sticky="w")
    asignaturas_seleccionadas.append(var)

ttk.Button(profesor_frame, text="Registrar Profesor", command=registrar_profesor).grid(row=3, column=0, columnspan=2, padx=5, pady=5)

# Registro de Curso
curso_frame = ttk.LabelFrame(root, text="Registro de Curso")
curso_frame.grid(row=2, column=0, padx=10, pady=10, sticky="w")

ttk.Label(curso_frame, text="Nombre:").grid(row=0, column=0, padx=5, pady=5, sticky="w")
curso_nombre_entry = ttk.Entry(curso_frame)
curso_nombre_entry.grid(row=0, column=1, padx=5, pady=5, sticky="w")

ttk.Label(curso_frame, text="Profesor:").grid(row=1, column=0, padx=5, pady=5, sticky="w")
profesor_seleccionado = ttk.Combobox(curso_frame, values=[profesor.nombre for profesor in profesores])
profesor_seleccionado.grid(row=1, column=1, padx=5, pady=5, sticky="w")

ttk.Label(curso_frame, text="Día:").grid(row=2, column=0, padx=5, pady=5, sticky="w")
curso_dia_entry = ttk.Entry(curso_frame)
curso_dia_entry.grid(row=2, column=1, padx=5, pady=5, sticky="w")

ttk.Label(curso_frame, text="Hora de inicio:").grid(row=3, column=0, padx=5, pady=5, sticky="w")
curso_hora_inicio_entry = ttk.Entry(curso_frame)
curso_hora_inicio_entry.grid(row=3, column=1, padx=5, pady=5, sticky="w")

ttk.Label(curso_frame, text="Hora de fin:").grid(row=4, column=0, padx=5, pady=5, sticky="w")
curso_hora_fin_entry = ttk.Entry(curso_frame)
curso_hora_fin_entry.grid(row=4, column=1, padx=5, pady=5, sticky="w")

ttk.Button(curso_frame, text="Registrar Curso", command=registrar_curso).grid(row=5, column=0, columnspan=2, padx=5, pady=5)

# Realizar Evaluación
evaluacion_frame = ttk.LabelFrame(root, text="Realizar Evaluación")
evaluacion_frame.grid(row=4, column=0, padx=10, pady=10, sticky="w")

ttk.Label(evaluacion_frame, text="Estudiante:").grid(row=0, column=0, padx=5, pady=5, sticky="w")
estudiante_seleccionado_eval = ttk.Combobox(evaluacion_frame, values=[estudiante.nombre for estudiante in estudiantes])
estudiante_seleccionado_eval.grid(row=0, column=1, padx=5, pady=5, sticky="w")

ttk.Label(evaluacion_frame, text="Curso:").grid(row=1, column=0, padx=5, pady=5, sticky="w")
curso_seleccionado_eval = ttk.Combobox(evaluacion_frame, values=[curso.nombre for curso in cursos])
curso_seleccionado_eval.grid(row=1, column=1, padx=5, pady=5, sticky="w")

ttk.Label(evaluacion_frame, text="Nota:").grid(row=2, column=0, padx=5, pady=5, sticky="w")
evaluacion_nota_entry = ttk.Entry(evaluacion_frame)
evaluacion_nota_entry.grid(row=2, column=1, padx=5, pady=5, sticky="w")

ttk.Button(evaluacion_frame, text="Realizar Evaluación", command=realizar_evaluacion).grid(row=3, column=0, columnspan=2, padx=5, pady=5)

# Mostrar Información del Curso
mostrar_info_frame = ttk.LabelFrame(root, text="Mostrar Información del Curso")
mostrar_info_frame.grid(row=5, column=0, padx=10, pady=10, sticky="w")

cursos_combobox = ttk.Combobox(mostrar_info_frame, values=[curso.nombre for curso in cursos])
cursos_combobox.grid(row=0, column=0, padx=5, pady=5, sticky="w")

ttk.Button(mostrar_info_frame, text="Mostrar Información del Curso", command=mostrar_info_curso).grid(row=1, column=0, padx=5, pady=5)

root.mainloop()
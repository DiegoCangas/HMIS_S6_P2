package ual.hmis.asignatura;

import java.util.ArrayList;

public class Alumno {

	private String nombre;
	private ArrayList<Actividad> actividadesAsignadas;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Actividad> getActividadesAsignadas() {
		return actividadesAsignadas;
	}

	public void setActividadesAsignadas(ArrayList<Actividad> actividadesAsignadas) {
		this.actividadesAsignadas = actividadesAsignadas;
	}

	public double calcularNotaActividad(String nombreActividad) {
		Actividad ac = null;

		for (Actividad a : actividadesAsignadas)
			if (a.getNombre().equals(nombreActividad)) {
				ac = a;
				break;
			}
		if (ac == null)
			return -1;

		double nota = 0;
		for (Ejercicio e : ac.getEjercicios())
			nota += e.getPuntuacion();

		ac.setPuntuacionTotal(nota);

		return nota;

	}

	public String calificacion(double nota) {
		if (nota < 0 || nota > 10)
			return "error en la calificacion";
		else if (nota < 5)
			return "Suspenso";
		else if (nota < 7)
			return "Aprobado";
		else if (nota < 9)
			return "Notable";
		else if (nota < 10)
			return "Sobresaliente";
		else
			return "Matricula";
	}

	public String cursoSegunEdad(int anyoNacimiento) {
		int anyoMatriculacion = 2020;
		int edad = anyoMatriculacion - anyoNacimiento;

		if (edad < 3 || edad > 15)
			return "El alumno no tiene edad para matricularse en ningun curso";
		else if (edad < 6)
			return edad - 2 + " Educacion Infantil";
		else if (edad < 12)
			return edad - 5 + " Educacion Primaria";
		else
			return edad - 11 + " Educacion Secundaria";

	}

}

package ual.hmis.asignatura;

import java.util.ArrayList;

public class Alumno {
/**
 * nombre.
 */
private String nombre;
/**
 * actividades Asignadas.
 */
private ArrayList<Actividad> actividadesAsignadas;
/**
 * @return nombre
 */
public String getNombre() {
return nombre;
}
/**
 * @param nombre
 */
public void setNombre(final String nombre) {
	this.nombre = nombre;
}
	/**
	 * @return actividades
	 */
public ArrayList<Actividad> getActividadesAsignadas() {
	return actividadesAsignadas;
}
	/**
	 * @param actividadesAsignadas
	 */
public void setActividadesAsignadas(final ArrayList<Actividad> actividadesAsignadas) {
	this.actividadesAsignadas = actividadesAsignadas;
}
	/**
	 * @param nombreActividad
	 * @return nota
	 */
public double calcularNotaActividad(final String nombreActividad) {
Actividad ac = null;
for (final Actividad a : actividadesAsignadas) {
	if (a.getNombre().equals(nombreActividad)) {
		ac = a;
		break;
		}
}
	if (ac == null) {
		return -1;
	}
		double nota = 0;

	for (final Ejercicio e : ac.getEjercicios()) {
		nota += e.getPuntuacion();
	}
		ac.setPuntuacionTotal(nota);
		return nota;
	}
	/**
	 * @param nota
	 * @return calificacion
	 */
	public String calificacion(final double nota) {
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
/**
 * @param anyoNacimiento
 * @return curso
 */
public String cursoSegunEdad(final int anyoNacimiento) {
	final int anyoMatriculacion = 2020;
	final int edad = anyoMatriculacion - anyoNacimiento;
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
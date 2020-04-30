package ual.hmis.asignatura;

import java.util.ArrayList;

/**
 * @author Diego Cangas
 *
 */
public class Actividad {

/**
nombre.
 */
private String nombre; // nombre de la actividad
/**
 * ejercicios.
 */
private ArrayList<Ejercicio> ejercicios;
/**
 * apta.
 */
private boolean apta;
/**
 * puntuación Total.
 */
private double puntuacionTotal;
/**
 * @return nombre Actividad
 */
public String getNombre() {
	return nombre;
}
/**
 * Set del nombre de la actividad.
 * @param nombre
 */
public void setNombre(final String nombre) {
	this.nombre = nombre;
}
/**
 * @return lista de ejercicios de la actividad.
 */
	public ArrayList<Ejercicio> getEjercicios() {
	return ejercicios;
}
/**
* @param ejercicios lista de ejercicios.
*/
public void setEjercicios(final ArrayList<Ejercicio> ejercicios) {
	this.ejercicios = ejercicios;
}
/**
* @return es apta.
*/
public boolean isApta() {
	return apta;
}
/**
 * @param apta
 */
public void setApta(final boolean apta) {
	this.apta = apta;
}
/**
 * @return puntuación total.
 */
public double getPuntuacionTotal() {
	return this.puntuacionTotal;
}
/**
 * @param value
 */

public void setPuntuacionTotal(final double value) {
	this.puntuacionTotal = value;
}
/**
 * @param nombreEjercicio
 * @param puntuacion
 */
	public void agregarEjercicioCalificado(final String nombreEjercicio, final double puntuacion)
	{

		final Ejercicio nuevoEjercicio = new Ejercicio();

		nuevoEjercicio.setNombre(nombreEjercicio);
		nuevoEjercicio.setPuntuacion(puntuacion);

		ejercicios.add(nuevoEjercicio);
	}

}

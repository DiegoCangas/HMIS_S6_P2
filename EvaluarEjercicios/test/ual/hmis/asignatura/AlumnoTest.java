package ual.hmis.asignatura;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AlumnoTest {
	static Alumno al;
	@BeforeAll
	public static void setUp() {
		al = new Alumno();
		ArrayList<Actividad> actividades = new ArrayList<Actividad>();
		Actividad a1 = new Actividad();
		a1.setNombre("a1");
		
		ArrayList<Ejercicio> ej = new ArrayList<Ejercicio>();
		
		Ejercicio ej1 = new Ejercicio();
		Ejercicio ej2 = new Ejercicio();
		
		ej1.setNombre("Ej1");
		ej1.setPuntuacion(8);
		
		ej2.setNombre("Ej2");
		ej2.setPuntuacion(800);
		
		ej.add(ej1);
		ej.add(ej2);
		
		a1.setEjercicios(ej);
		
		actividades.add(a1);
		
		al.setActividadesAsignadas(actividades);
	}
	@ParameterizedTest (name = "{index} => Con entrada ({0}) sale {1}")
	@CsvSource({"a1, 808",
				"a2, -1",
				"a1, 808",
				"a3, -1"
				})
	void testCalcularNota(String input1, double expected) {
		assertEquals(expected, al.calcularNotaActividad(input1));
}
	@ParameterizedTest (name = "{index} => Con entrada ({0}) sale {1}")
	@CsvSource({"-0.001, error en la calificación",
				"0.001, Suspenso",
				"4.999, Suspenso",
				"5, Aprobado",
				"6.001, Aprobado",
				"7, Notable",
				"9, Sobresaliente",
				"10, Matrícula",
				"9.99999999999, Sobresaliente",
				"10.00000001, error en la calificación",
				"10000, error en la calificación"
				})
	void testCalificacion(double input1, String expected) {
		assertEquals(expected, al.calificacion(input1));
}
	@ParameterizedTest (name = "{index} => Con entrada ({0}) sale {1}")
	@CsvSource({"2004, El alumno no tiene edad para matricularse en ningún curso",
				"2018, El alumno no tiene edad para matricularse en ningún curso",
				"2017, 1º Educación Infantil",
				"2015, 3º Educación Infantil",
				"2014, 1º Educación Primaria",
				"2009, 6º Educación Primaria",
				"2008, 1º Educación Secundaria",
				"2005, 4º Educación Secundaria"
				})
	void testMatriculacion(int input1, String expected) {
		assertEquals(expected, al.cursoSegunEdad(input1));
}
}

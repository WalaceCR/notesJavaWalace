package runningOn;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

import businessNotes.IdadeMinima;
import businessNotes.Usuario;

public class Startar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario usuario = new Usuario("Mário", "42198284863", LocalDate.of(2005, Month.MARCH, 14));
		System.out.println(validador(usuario));


	}
	
	public static <T> boolean validador(T objeto) {
		boolean validar = false;
		//usando reflection
		Class<?> classe = objeto.getClass();
		for (Field field : classe.getDeclaredFields()) {
			if (field.isAnnotationPresent(IdadeMinima.class)) {
				IdadeMinima idadeMinima = field.getAnnotation(IdadeMinima.class);
				try{
		            field.setAccessible(true);
		            LocalDate dataNascimento = (LocalDate) field.get(objeto);
		            validar = Period.between(dataNascimento, LocalDate.now()).getYears() >= idadeMinima.valor();
		         } catch (IllegalAccessException e) {
		              e.printStackTrace();
		         }
			}
		}
		return validar;
		
	}

}

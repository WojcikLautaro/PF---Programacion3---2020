package clases;

import java.util.ArrayList;
import java.util.Random;

import atributes.AtributeMultipliers;
import clases.interfaces.ClaseBase;
import clases.interfaces.ISpell;
import habilidades.Habilidad;
import razas.ClasesNoConcretas.RazaBase.POSIBLES_CLASES;
import recursos.MaximosRecursos;
import recursos.Recursos;

/**
 * 
 * Esta clase escala con inteligencia y carisma, ademas de suerte para algunas de sus habilidades.
 *
 */

public class Druida implements ClaseBase , ISpell {
	@Override
	public POSIBLES_CLASES getEnumDeClase () {
		return POSIBLES_CLASES.DRUIDA;
	}

	@Override
	public AtributeMultipliers getMultiplicadorDeAtributosDeClase() {
		return new AtributeMultipliers(1,1,1,1,1,1,1,1);
	}

	@Override
	public Recursos getClassResources() {
		return new Recursos(new MaximosRecursos(100, 100, 0, 0));
	}

	@Override
	public ArrayList<Habilidad> getClassAbilities()  {
		return new ArrayList <> ();
	}
	
	@Override
	public String basicSpell() {
		float totalDamage = 100; // 100 es el danio que realiza el hechizo basico.
		float totalInteligence = this.getMultiplicadorDeAtributosDeClase().getInteligence(); 
		float totalCharisma = this.getMultiplicadorDeAtributosDeClase().getCarism();
		totalDamage = totalDamage * ((totalInteligence/100)+1);
		totalDamage = totalDamage * ((totalCharisma/100)+1);
		StringBuilder sb = new StringBuilder();
		sb.append("El ataque basico ha golpeado exitosamente realizando "+totalDamage+" danio.");
		return sb.toString();
	}

	// TODO -> Mas adelante intentar la implementación de usar los hechizos contra 'jugadores' o 'monstruos'
	
	@Override
	public String freeze() {
		
		int totalProbability = 30; 	// Se arranca con un 30% de probabilidad de que el hechizo funciona, y a esto se le suma la suerte del jugador.
		totalProbability += this.getMultiplicadorDeAtributosDeClase().getLuck();
		Random rand = new Random();
		int randomProb = rand.nextInt(100);
		StringBuilder sb = new StringBuilder();
		if( randomProb <= totalProbability) {
			sb.append("El hechizo se realizo con exito!");
		}else {
			sb.append("Fallaste");
		}
		
		return sb.toString();
	}

	@Override
	public String teleport() {
		int totalProbability = 50; 
		totalProbability += this.getMultiplicadorDeAtributosDeClase().getLuck();
		Random rand = new Random();
		int randomProb = rand.nextInt(100);
		StringBuilder sb = new StringBuilder();
		if( randomProb <= totalProbability) {
			sb.append("El hechizo se realizo con exito!");
		}else {
			sb.append("Fallaste");
		}
		
		return sb.toString();
	}
}

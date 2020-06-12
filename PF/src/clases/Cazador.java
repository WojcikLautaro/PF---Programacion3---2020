package clases;

import java.util.ArrayList;

import atributes.AtributeMultipliers;
import clases.interfaces.ClaseBase;
import clases.interfaces.IRanged;
import habilidades.Habilidad;
import razas.ClasesNoConcretas.RazaBase.POSIBLES_CLASES;
import recursos.MaximosRecursos;
import recursos.Recursos;

/**
 * Esta clase escala con destreza y fuerza, ademas de suerte para algunos de sus habilidades.
 */

public class Cazador implements ClaseBase, IRanged{
	@Override
	public POSIBLES_CLASES getEnumDeClase () {
		return POSIBLES_CLASES.CAZADOR;
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
	public String basicArrow() {
			float totalDamage = 100; // 100 es el danio que realiza el ataque basico.
			float totalStrenght = this.getMultiplicadorDeAtributosDeClase().getStrenght();  
			float totalDexterity = this.getMultiplicadorDeAtributosDeClase().getDexterity();
			totalDamage = totalDamage * ((totalStrenght/100)+1);
			totalDamage = totalDamage * ((totalDexterity/100)+1);
			StringBuilder sb = new StringBuilder();
			sb.append("El ataque basico ha golpeado exitosamente realizando "+totalDamage+" danio.");
			return sb.toString();
	}

	@Override
	public String piercingArrow() {
		float totalDamage = 220; // Danio base de la habilidad.
		float totalStrenght = this.getMultiplicadorDeAtributosDeClase().getStrenght();
		float totalDexterity = this.getMultiplicadorDeAtributosDeClase().getDexterity();
		totalDamage = totalDamage * ((totalStrenght/100)+1);
		totalDamage = totalDamage * ((totalDexterity/100)+1);
		StringBuilder sb = new StringBuilder();
		sb.append("El ataque penetrante ha golpeado exitosamente realizando "+totalDamage+" danio.");
		return sb.toString();
	}

	@Override
	public String venomousArrow() {
		this.getMultiplicadorDeAtributosDeClase()
		return null;
	}
}

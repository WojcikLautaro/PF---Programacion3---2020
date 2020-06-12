package clases;

import java.util.ArrayList;

import atributes.AtributeMultipliers;
import clases.interfaces.ClaseBase;
import clases.interfaces.IMelee;
import habilidades.Habilidad;
import razas.ClasesNoConcretas.RazaBase.POSIBLES_CLASES;
import recursos.MaximosRecursos;
import recursos.Recursos;

/**
 * 
 * Esta clase escala con fuerza y destreza, ademas de suerte para algunas de sus habilidades.
 *
 */

public class Picaro implements ClaseBase, IMelee {
	@Override
	public POSIBLES_CLASES getEnumDeClase () {
		return POSIBLES_CLASES.PÍCARO;
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
	public String bassicAttack() {
		
		return null;
	}

	@Override
	public String chargeAttack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String twisterAttack() {
		// TODO Auto-generated method stub
		return null;
	}
}

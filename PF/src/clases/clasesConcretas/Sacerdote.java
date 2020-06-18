package clases.clasesConcretas;

import java.util.ArrayList;

import atributosDeRazaYClase.AtributeMultipliers;
import clases.habilidades.Habilidad;
import clases.interfaces.ClaseBase;
import clases.recursos.MaximosRecursos;
import clases.recursos.Recursos;
import razas.clasesNoConcretas.RazaBase.POSIBLES_CLASES;

public final class Sacerdote implements ClaseBase {
	@Override
	public ArrayList<Habilidad> getClassAbilities() {
		return new ArrayList<>();
	}

	@Override
	public Recursos getClassResources() {
		return new Recursos(new MaximosRecursos(100, 100, 0, 0));
	}

	@Override
	public POSIBLES_CLASES getEnumDeClase() {
		return POSIBLES_CLASES.SACERDOTE;
	}

	@Override
	public AtributeMultipliers getMultiplicadorDeAtributosDeClase() {
		return new AtributeMultipliers(1, 1, 1, 1, 1, 1, 1, 1);
	}
}

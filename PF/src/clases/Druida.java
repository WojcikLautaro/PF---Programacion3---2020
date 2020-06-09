package clases;

import java.util.ArrayList;

import atributes.AtributeMultipliers;
import habilidades.Habilidad;
import razas.RazaBase.POSIBLES_CLASES;
import recursos.MaximosRecursos;
import recursos.Recursos;

public class Druida extends ClaseBase {
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
}

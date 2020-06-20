package personajes.clases.clasesConcretas;

import java.util.ArrayList;

import personajes.atributosDeRazaYClase.AtributeMultipliers;
import personajes.clases.habilidades.Habilidad;
import personajes.clases.interfaces.ClaseBase;
import personajes.clases.recursos.MaximosRecursos;
import personajes.clases.recursos.Recursos;
import personajes.razas.clasesNoConcretas.RazaBase.POSIBLES_CLASES;

/**
 * Clase que implementa metodos de la interfaz {@code ClaseBase}
 * 
 * @author lautarowojcik
 */
public final class Brujo implements ClaseBase {
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
		return POSIBLES_CLASES.BRUJO;
	}

	@Override
	public AtributeMultipliers getMultiplicadorDeAtributosDeClase() {
		return new AtributeMultipliers(1, 1, 1, 1, 1, 1, 1, 1);
	}
}

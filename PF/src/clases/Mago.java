package clases;

import java.util.ArrayList;

import atributes.AtributeMultipliers;
import habilidades.Habilidad;
import razas.ClasesNoConcretas.RazaBase.POSIBLES_CLASES;
import razas.InterfacesClasesConcretas.HerenciaDraenelana;
import razas.InterfacesClasesConcretas.HerenciaElfa;
import razas.InterfacesClasesConcretas.HerenciaNoMuerta;
import recursos.MaximosRecursos;
import recursos.Recursos;

public class Mago extends ClaseBase implements HerenciaNoMuerta, HerenciaElfa, HerenciaDraenelana {
	@Override
	public POSIBLES_CLASES getEnumDeClase () {
		return POSIBLES_CLASES.MAGO;
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

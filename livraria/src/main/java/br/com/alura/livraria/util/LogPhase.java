package br.com.alura.livraria.util;

import javax.enterprise.event.Observes;
import javax.faces.event.PhaseEvent;

import br.com.alura.alura_lib.jsf.phaselistener.annotation.After;
import br.com.alura.alura_lib.jsf.phaselistener.annotation.Phase;
import br.com.alura.alura_lib.jsf.phaselistener.annotation.Phase.Phases;

public class LogPhase {
	
	public void log(@Observes @After @Phase(Phases.RESTORE_VIEW) PhaseEvent phaseEvent){
		System.out.println("Fase: " + phaseEvent.getPhaseId());
	}

}

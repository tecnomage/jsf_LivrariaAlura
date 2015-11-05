package br.com.caelum.livraria.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import sun.launcher.resources.launcher;

public class LogPhaseListener  implements PhaseListener {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void afterPhase(PhaseEvent event) {
		//System.out.println("FASE1" + event.getPhaseId());
		
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		System.out.println("FASE " + event.getPhaseId());
		
	}

	@Override
	public PhaseId getPhaseId() {
		
		return PhaseId.ANY_PHASE;
	}

}

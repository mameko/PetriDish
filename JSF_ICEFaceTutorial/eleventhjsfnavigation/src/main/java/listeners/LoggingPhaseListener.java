package listeners;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class LoggingPhaseListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent arg0) {
		System.out.println("After Phase : " + arg0.getPhaseId().toString());
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		System.out.println("Before Phase : " + arg0.getPhaseId().toString());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}

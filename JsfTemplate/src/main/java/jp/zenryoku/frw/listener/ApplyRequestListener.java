package jp.zenryoku.frw.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * APPLY_REQUEST_VALUESフェーズで呼び出される
 * @author ZenryokuService
 */
@SuppressWarnings("serial")
public class ApplyRequestListener implements PhaseListener {

	/**
	 * APPLY_REQUEST_VALUESフェーズの後で呼び出される
	 */
	@Override
	public void afterPhase(PhaseEvent arg0) {
		System.out.println("*** After APPLY_REQUEST_VALUES ***");
	}

	/**
	 * APPLY_REQUEST_VALUESフェーズの前で呼び出される
	 */
	@Override
	public void beforePhase(PhaseEvent arg0) {
		System.out.println("*** Befire APPLY_REQUEST_VALUES ***");
	}

	/**
	 * APPLY_REQUEST_VALUESのフェーズID
	 */
	@Override
	public PhaseId getPhaseId() {
		return PhaseId.APPLY_REQUEST_VALUES;
	}

}

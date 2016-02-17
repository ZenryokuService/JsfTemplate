package jp.zenryoku.frw.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * UPDATE_MODEL_VALUESフェーズで呼び出される
 * @author ZenryokuService
 *
 */
@SuppressWarnings("serial")
public class UpdateMedelListener implements PhaseListener {

	/**
	 * UPDATE_MODEL_VALUESの後で呼び出される
	 */
	@Override
	public void afterPhase(PhaseEvent arg0) {
		System.out.println("*** After UPDATE_MODEL_VALUES ***");
	}

	/**
	 * UPDATE_MODEL_VALUESの前で呼び出される
	 */
	@Override
	public void beforePhase(PhaseEvent arg0) {
		System.out.println("*** Before UPDATE_MODEL_VALUES ***");
	}

	/**
	 * UPDATE_MODEL_VALUESのフェーズID
	 */
	@Override
	public PhaseId getPhaseId() {
		return PhaseId.UPDATE_MODEL_VALUES;
	}

}

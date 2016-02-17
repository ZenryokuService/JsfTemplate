package jp.zenryoku.frw.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * PROCESS_VALIDATIONSフェーズで呼び出される
 * @author ZenryokuService
 *
 */
@SuppressWarnings("serial")
public class ProcessValidationListener implements PhaseListener {

	/**
	 * PROCESS_VALIDATIONSの後で呼ばれる
	 */
	@Override
	public void afterPhase(PhaseEvent arg0) {
		System.out.println("*** After ProcessValidation ***");
	}

	/**
	 * PROCESS_VALIDATIONSの前で呼ばれる
	 */
	@Override
	public void beforePhase(PhaseEvent arg0) {
		System.out.println("*** Before ProcessValidation ***");
	}

	/**
	 * PROCESS_VALIDATIONSのフェーズID
	 */
	@Override
	public PhaseId getPhaseId() {
		return PhaseId.PROCESS_VALIDATIONS;
	}

}

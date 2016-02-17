package jp.zenryoku.frw.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * INVOKE_APPLICATIONで呼び出される
 * @author ZenryokuService
 */
@SuppressWarnings("serial")
public class InvokeApplicationListener implements PhaseListener {

	/**
	 * INVOKE_APPLICATIONの後で呼び出される
	 */
	@Override
	public void afterPhase(PhaseEvent arg0) {
		System.out.println("*** After INVOKE_APPLICATION ***");
	}

	/**
	 * INVOKE_APPLICATIONの前で呼び出される
	 */
	@Override
	public void beforePhase(PhaseEvent arg0) {
		System.out.println("*** Before INVOKE_APPLICATION ***");
	}

	/**
	 * INVOKE_APPLICATIONのフェーズID
	 */
	@Override
	public PhaseId getPhaseId() {
		return PhaseId.INVOKE_APPLICATION;
	}

}

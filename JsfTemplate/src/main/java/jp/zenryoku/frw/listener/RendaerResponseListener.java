package jp.zenryoku.frw.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * RENDER_RESPONSEフェーズで呼び出される
 * @author ZenryokuService
 */
@SuppressWarnings("serial")
public class RendaerResponseListener implements PhaseListener {

	/**
	 * RENDER_RESPONSEの後で呼び出される
	 */
	@Override
	public void afterPhase(PhaseEvent arg0) {
		System.out.println("*** After RENDER_RESPONSE ***");
	}

	/**
	 * RENDER_RESPONSE前で呼び出される
	 */
	@Override
	public void beforePhase(PhaseEvent arg0) {
		System.out.println("*** Before RENDER_RESPONSE ***");
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

}

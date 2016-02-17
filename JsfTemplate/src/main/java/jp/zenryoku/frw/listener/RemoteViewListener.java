package jp.zenryoku.frw.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * RESTORE_VIEWフェーズの切り出しメソッド
 * 
 * @author ZenryokuService
 */
@SuppressWarnings("serial")
public class RemoteViewListener implements PhaseListener{
	/**
	 * RESTORE_VIEWフェーズの後に呼ばれる
	 */
	@Override
	public void afterPhase(PhaseEvent arg0) {
		System.out.println("*** After RESTORE_VIEW ***");
	}

	/**
	 * RESTORE_VIEWフェーズの前に呼ばれる
	 */
	@Override
	public void beforePhase(PhaseEvent arg0) {
		System.out.println("*** Before RESTORE_VIEW ***");
	}

	/**
	 * RESTORE_VIEWのフェーズID
	 */
	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}

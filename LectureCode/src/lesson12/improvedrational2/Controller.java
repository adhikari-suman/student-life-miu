package lesson12.improvedrational2;

import java.util.logging.Logger;

public class Controller {	
	public void performAddition(int x, int y, int z, int u)  {
		try {
			Rational r1 = new Rational(x,y);
			Rational r2 = new Rational(z,u);
			Rational sum = r1.add(r2);
			ui.setSum(sum.toString());
			
		} catch(NonPositiveDenomException e) {
			LOG.warning("Controller: Attempted to use a nonpositive denominator");
			ui.showMessage(e.getMessage());
		}
	}
	private static final Logger LOG = Logger.getLogger("lesson12.improvedrational2");
	UI ui;
	public Controller(UI ui) {
		this.ui = ui;
	}
}

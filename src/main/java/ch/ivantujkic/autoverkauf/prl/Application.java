package ch.ivantujkic.autoverkauf.prl;

import ch.ivantujkic.autoverkauf.bll.AutoService;

public class Application {

	public static void main(String[] args) {

		// Auto Operationen
		try (AutoService autoService = new AutoService()) {
			autoService.AutoOperationen();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

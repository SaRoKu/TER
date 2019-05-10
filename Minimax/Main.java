package Minimax;

import javax.swing.UIManager;

public class Main {

	public static void main(String[] args) throws Exception{

		//Look & Feel del sistema operativo
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		javax.swing.SwingUtilities.invokeLater(()->{

			CtrlPresentacion ctrlPresentacion = new CtrlPresentacion();
		});
	}
}

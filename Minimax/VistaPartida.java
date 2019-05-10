package Minimax;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author samuel
 */
public class VistaPartida extends javax.swing.JFrame {

	private CtrlPresentacion cp;
	//PATH RELATIVO AL CLASSPATH --> TIENE QUE EMPEZAR POR '/'
	ImageIcon vaciaIcon = new ImageIcon(getClass().getResource("/casilla_vacia.png"));
	ImageIcon cruzIcon = new ImageIcon(getClass().getResource("/Cruz.png"));
	ImageIcon circuloIcon = new ImageIcon(getClass().getResource("/Circulo.png"));
	/**
	 * Creates new form VistaPartida
	 */
	public VistaPartida(CtrlPresentacion cp) {

		this.cp = cp;
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		celdas = new JLabel[3][3];
		for(int i=0; i<3; i++){
			for(int j = 0; j<3; j++)celdas[i][j]= new JLabel();
		}

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Tres en raya");
		setSize(new Dimension(500,500));
		setResizable(false);
		getContentPane().setLayout(new GridLayout(3, 3));

		for(int i=0; i<3; i++){
			for(int j = 0; j<3; j++){

				celdas[i][j].setIcon(vaciaIcon);
				celdas[i][j].setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
				celdas[i][j].addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						CeldaMouseClicked(evt);
					}
				});
				getContentPane().add(celdas[i][j]);
			}
		}

		pack();
		setLocationRelativeTo(null);
		iniciarMaquina();
	}// </editor-fold>//GEN-END:initComponents

	private void CeldaMouseClicked(MouseEvent evt) {//GEN-FIRST:event_Celda1MouseClicked

		int i=-1,j=-1;
		boolean found = false;
		for(int auxi=0;!found && auxi<3; auxi++){
			for(int auxj=0;!found && auxj<3; auxj++){

				if(evt.getSource()==celdas[auxi][auxj]){

					found = true;
					i=auxi;
					j=auxj;
				}
			}
		}

		if(cp.JugarTurno(i,j)){

			((JLabel)evt.getSource()).setIcon(cp.getUsuarioJuegaCruz() ? cruzIcon : circuloIcon);
			if(cp.finalizada()) finalizarPartida(cp.getResultados());
			cp.JugarTurno();
			celdas[cp.getPos().getFirst()][cp.getPos().getSecond()].setIcon(cp.getUsuarioJuegaCruz() ? circuloIcon : cruzIcon);
			if(cp.finalizada()) finalizarPartida(cp.getResultados());
		}
	}//GEN-LAST:event_Celda1MouseClicked

	private void iniciarMaquina(){

		if(!cp.getTurnoHumano()){

			cp.JugarTurno();
			celdas[cp.getPos().getFirst()][cp.getPos().getSecond()].setIcon(cp.getUsuarioJuegaCruz() ? circuloIcon : cruzIcon);
		}
	}

	private void finalizarPartida(int resultado){

		String msg;
		switch (resultado){

			case 1: msg = "Felicidades "+cp.getUsername()+" has ganado!"; break;
			case 0: msg = "Has empatado, "+cp.getUsername(); break;
			case -1: msg = "Que pena! Has perdido, "+cp.getUsername(); break;
			default: msg = "ESTO NUNCA SE DEBERIA MOSTRAR";
		}
		JOptionPane.showMessageDialog(null,msg);
		System.exit(0); //De momento
	}

	public void hacerlaVisible(){

		this.setVisible(true);
	}
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JLabel[][] celdas;
	// End of variables declaration//GEN-END:variables
}

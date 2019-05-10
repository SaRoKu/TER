package Minimax;

import javax.swing.*;
import java.awt.*;

public class VistaPrincipal {

	private JFrame frame;
	private JButton botonSalir;
	private JButton botonIniciar;
	private JLabel texto;
	private JTextField fieldUsername;
	private JComboBox color;
	private JCheckBox empezar;
	private JPanel PanelPrincipal;
	private ctrlDominio CD;

	VistaPrincipal(ctrlDominio CD){

		this.CD = CD;
	}

	public void inicializarComponentes(){

		//CREAR COMPONENTES

		PanelPrincipal = new JPanel();
		fieldUsername = new JTextField();
		botonSalir = new JButton("Salir");
		botonIniciar = new JButton("Jugar");
		color = new JComboBox(new String[]{"Cruz","Circulo"});
		empezar = new JCheckBox("Quiero empezar el primero");
		texto = new JLabel("Nombre de usuario:");
		frame = new JFrame("Inicio");

		//CONFIGURACION INICIAL

		PanelPrincipal.setLayout(new GridLayout());
		color.setSelectedIndex(0);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		//AÑADIR AL LAYOUT

		//nota: importa el orden
		PanelPrincipal.add(texto);
		PanelPrincipal.add(fieldUsername);
		PanelPrincipal.add(color);
		PanelPrincipal.add(empezar);
		PanelPrincipal.add(botonIniciar);
		PanelPrincipal.add(botonSalir);
		frame.add(PanelPrincipal);

		//ACTION LISTENERS

		botonSalir.addActionListener(e->System.exit(0));
		botonIniciar.addActionListener(e-> {

			CD.iniciarPartida(fieldUsername.getText(),color.getSelectedIndex(),empezar.isSelected());
			JOptionPane.showMessageDialog(null,"Has introducido: Nombre -> ["+fieldUsername.getText()
				+"] color ficha -> ["+color.getSelectedIndex()+"] Empezar? ["+empezar.isSelected()+"]");
		});
	}

	public void hacerlaVisible(){

		frame.pack();
		frame.setVisible(true);
	}
}

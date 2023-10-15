package apresentacao;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JPanel;

import negocio.Memoria;

public class Teclado extends JPanel implements ActionListener {

	private final Memoria memoria;
	private final Display display;
	public Teclado(Memoria memoria, Display display) {

		this.memoria = memoria;
		this.display = display;
				
		setLayout(new GridLayout(4, 4));
		setBackground(Color.lightGray);

		add(criarBotao("7", Color.GRAY));
		add(criarBotao("8", Color.GRAY));
		add(criarBotao("9", Color.GRAY));
		add(criarBotao("+", Color.lightGray));

		add(criarBotao("4", Color.GRAY));
		add(criarBotao("5", Color.GRAY));
		add(criarBotao("6", Color.GRAY));
		add(criarBotao("-", Color.lightGray));

		add(criarBotao("1", Color.GRAY));
		add(criarBotao("2", Color.GRAY));
		add(criarBotao("3", Color.GRAY));
		add(criarBotao("*", Color.lightGray));
		
		add(criarBotao("0", Color.GRAY));
		add(criarBotao("/", Color.lightGray));
		add(criarBotao(".", Color.lightGray));
		add(criarBotao("=", Color.lightGray));

	}

	public Botao criarBotao(String texto, Color cor) {

		Botao b = new Botao(texto, cor);
		b.addActionListener(this);
		return b;

	}


	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();

		display.setText(b.getText());

		if(memoria.getValorDado()){
			if (Pattern.matches("[0-9]", b.getText()) || Pattern.matches("[+\\-*/]", b.getText()) || b.getText().equals(".")) {
				memoria.setNumerous(b.getText());

			}else if (b.getText().equals("=")) {
				memoria.defineNumerous();
				display.setText(String.valueOf(memoria.calculator()));
				memoria.setValorDado(false);
			}
		} else {
			System.out.println("else");
			display.clear();
			memoria.clear();
			memoria.setNumerous(b.getText());
			display.setText(b.getText());

		}






	}
	
	

}

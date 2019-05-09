import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font; 
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

public class Calculadora extends JFrame implements ActionListener{
	
	private JLabel mensaje;
	private JLabel mensaje2;
	private JLabel mensaje3;
	private JLabel mensaje4;

	private JButton botonSuma;
	private JButton botonResta;
	private JButton botonMultiplicacion;
	private JButton botonDivision;
	private JButton botonRaiz;
	private JButton botonPotencia;
	private JButton botonResultado;


	private JTextField caja;
	private JTextField caja2;
	private JTextField caja3;
	
	public Calculadora()
	{
		super();
		configurarVentana();
		crearComponentes();
		this.getContentPane().setBackground(Color.BLACK);
	}
	
	private void configurarVentana(){
		this.setTitle("CALCULADORA");
		this.setSize(580,260);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void crearComponentes() {
		mensaje = new JLabel();
		mensaje2 = new JLabel();
		mensaje3 = new JLabel();
		mensaje4 = new JLabel();
		
		Font fuente = new Font("Lucida Sans", 1, 18);
		Font fuente2 = new Font("Arial", 3, 20);
		Font fuente3 = new Font("Arial", 3, 12);
		
        mensaje.setFont(fuente); 
		mensaje.setText("CALCULADORA");
		mensaje.setBounds(220, 1, 260, 50);
		this.add(mensaje);
		mensaje.setForeground(Color.WHITE);
		
		mensaje2.setFont(fuente3);
		mensaje2.setText("Primer numero: ");
		mensaje2.setBounds(50, 80, 100, 30);
		this.add(mensaje2);
		mensaje2.setForeground(Color.WHITE);
		
		caja = new JTextField();
		caja.setBounds(150, 80, 90, 30);
		this.add(caja);
		
		mensaje3.setFont(fuente3);
		mensaje3.setText("Segundo numero:");
		mensaje3.setBounds(305, 80, 120, 30);
		this.add(mensaje3);
		mensaje3.setForeground(Color.WHITE);
			
		caja2 = new JTextField();
		caja2.setBounds(420, 80, 90, 30);
		this.add(caja2);
				
		botonSuma = new JButton();
		botonSuma.setFont(fuente2);
		botonSuma.setText("+");
		botonSuma.setBounds(50, 160, 50, 30);
		botonSuma.addActionListener(this);
		botonSuma.setBackground(java.awt.Color.WHITE);
		botonSuma.setForeground(Color.BLACK);
		this.add(botonSuma);
		
		botonResta = new JButton();
		botonResta.setFont(fuente2);
		botonResta.setText("-");
		botonResta.setBounds(110, 160, 50, 30);
		botonResta.addActionListener(this);
		botonResta.setBackground(java.awt.Color.WHITE);
		botonResta.setForeground(Color.BLACK);
		this.add(botonResta);
		
		botonMultiplicacion = new JButton();
		botonMultiplicacion.setFont(fuente2);
		botonMultiplicacion.setText("x");
		botonMultiplicacion.setBounds(170, 160, 50, 30);
		botonMultiplicacion.addActionListener(this);
		botonMultiplicacion.setBackground(java.awt.Color.WHITE);
		botonMultiplicacion.setForeground(Color.BLACK);
		this.add(botonMultiplicacion);
		
		botonDivision = new JButton();
		botonDivision.setFont(fuente2);
		botonDivision.setText("÷");
		botonDivision.setBounds(230, 160, 50, 30);
		botonDivision.addActionListener(this);
		botonDivision.setBackground(java.awt.Color.WHITE);
		botonDivision.setForeground(Color.BLACK);
		this.add(botonDivision );
		
		botonPotencia = new JButton();
		botonPotencia.setFont(fuente2);
		botonPotencia.setText("^");
		botonPotencia.setBounds(290, 160, 50, 30);
		botonPotencia.addActionListener(this);
		botonPotencia.setBackground(java.awt.Color.red);
		botonPotencia.setForeground(Color.WHITE);
		this.add(botonPotencia);
		
		botonRaiz = new JButton();
		botonRaiz.setText("\u221A");
		botonRaiz.setBounds(350, 160, 60, 30);
		botonRaiz.addActionListener(this);
		botonRaiz.setBackground(java.awt.Color.red);
		botonRaiz.setForeground(Color.WHITE);
		this.add(botonRaiz);
				
		mensaje4.setText("RESULTADO:");
		mensaje4.setBounds(433, 130, 100, 30);
		this.add(mensaje4);
		mensaje4.setForeground(Color.WHITE);
		
		caja3 = new JTextField();
		caja3.setBounds(425, 160, 120, 30);
		caja3.setBackground(java.awt.Color.blue);
		this.add(caja3);
		
		
}
	@Override
	public void actionPerformed(ActionEvent e) {
		String numero1 = caja.getText();
		String numero2 = caja2.getText();
		boolean bandera = false;
		
		if(numero1.isEmpty()) {
			numero1 = "0";
		}
		if(numero2.isEmpty()) {
			numero2 = "0";
		}
		
		
		double cantidad1 = Double.parseDouble(numero1);
		double cantidad2 = Double.parseDouble(numero2);
		double resultado = 0;
		

		switch(e.getActionCommand()) {
			case "+" : 
			resultado = cantidad1 + cantidad2;
			
			break;
			case "-" : 
				resultado = cantidad1 - cantidad2;
			break;
			case "x" : 
				resultado = cantidad1*cantidad2;
			break;
			case "÷" : 
				resultado = cantidad1/cantidad2;
				if(cantidad1 == 0 || cantidad2 == 0) {
					bandera = true;
				}
			break;
			case "^" : 
				resultado = Math.pow(cantidad1, cantidad2);
			break;
			case "\u221A" : 
				resultado =  Math.sqrt(cantidad1);
			break;
			
		}
		mostrarResultado(resultado,bandera);
		
			 		
	}
	private void mostrarResultado(double resultado,boolean bandera) {
		String resultadoFinal = String.valueOf(resultado); 
		if(bandera==true) {
			JOptionPane.showMessageDialog(this,"ERROR, division entre cero");
		}
		else {
			caja3.setForeground(Color.white);
			caja3.setText(resultadoFinal);
		}
	}
	
	public static void main(String[] args) {
		Calculadora ventana = new Calculadora();
		ventana.setVisible(true);
	}


}

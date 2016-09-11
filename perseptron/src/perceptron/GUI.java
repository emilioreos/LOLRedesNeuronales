package perceptron;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Panel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/perceptron/lolicon.png")));
		setTitle("Test de League of Legends");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Panel Seleccion = new Panel();
		contentPane.add(Seleccion, BorderLayout.WEST);
		
		JLabel Pregunta = new JLabel("Iniciar Test");
		Seleccion.add(Pregunta);
		
		Panel MostrarPregunta = new Panel();
		contentPane.add(MostrarPregunta, BorderLayout.CENTER);
		
		JLabel pregunta = new JLabel();
		MostrarPregunta.add(pregunta);
		
		JRadioButton res1 = new JRadioButton();
		MostrarPregunta.add(res1);
		JRadioButton res2 = new JRadioButton();
		MostrarPregunta.add(res2);
		ButtonGroup gruposeleccion=new ButtonGroup();
		gruposeleccion.add(res1);
		gruposeleccion.add(res2);
		double[] resultados=new double[10];
		res1.show(false);
		res2.show(false);
		Panel panel = new Panel();
		contentPane.add(panel, BorderLayout.SOUTH);
		JButton siguiente = new JButton("Siguiente pregunta");
		siguiente.setEnabled(false);
		siguiente.addActionListener(new ActionListener() {
			int contador=2;
			public void actionPerformed(ActionEvent arg0) {
				if(contador<=10){
				String s="Pregunta "+contador;
				Pregunta.setText(s);
				switch(contador){
				case 2:
					pregunta.setText("¿Tienes miedo a ser golpeado?");
					res1.setText("Sí");
					res2.setText("No");
					if(res1.isSelected()){
						resultados[0]=1;
					}else if(res2.isSelected()){
						resultados[0]=0;
					}
					break;
				case 3:
					pregunta.setText("¿Prefieres tu bienestar o el de los demás?");
					res1.setText("Mi bienestar");
					res2.setText("El de los demás");
					if(res1.isSelected()){
						resultados[1]=1;
					}else if(res2.isSelected()){
						resultados[1]=0;
					}
					break;
				case 4:
					pregunta.setText("¿Eres bueno trabajando en equipo?");
					res1.setText("Sí");
					res2.setText("No");
					if(res1.isSelected()){
						resultados[2]=1;
					}else if(res2.isSelected()){
						resultados[2]=0;
					}
					break;
				case 5:
					pregunta.setText("¿Prefieres ir a lo seguro o arriesgarte?");
					res1.setText("Ir a lo seguro");
					res2.setText("Arriesgarme");
					if(res1.isSelected()){
						resultados[3]=1;
					}else if(res2.isSelected()){
						resultados[3]=0;
					}
					break;
				case 6:
					pregunta.setText("¿Te gusta la comida saludable?");
					res1.setText("Sí");
					res2.setText("No");
					if(res1.isSelected()){
						resultados[4]=1;
					}else if(res2.isSelected()){
						resultados[4]=0;
					}
					break;
				case 7:
					pregunta.setText("¿Prefieres pelear a distancia o cuerpo a cuerpo?");
					res1.setText("Distancia");
					res2.setText("Cuerpo a Cuerpo");
					if(res1.isSelected()){
						resultados[5]=1;
					}else if(res2.isSelected()){
						resultados[5]=0;
					}
					break;
				case 8:
					pregunta.setText("¿Te gusta divertirte?");
					res1.setText("Sí");
					res2.setText("No");
					if(res1.isSelected()){
						resultados[6]=1;
					}else if(res2.isSelected()){
						resultados[6]=0;
					}
					break;
				case 9:
					pregunta.setText("¿Te gustan las mascotas?");
					res1.setText("Sí");
					res2.setText("No");
					if(res1.isSelected()){
						resultados[7]=1;
					}else if(res2.isSelected()){
						resultados[7]=0;
					}
					break;
				case 10:
					pregunta.setText("¿Te gusta llevarte toda la gloria cuando trabajas en equipo?");
					res1.setText("Sí");
					res2.setText("No");
					if(res1.isSelected()){
						resultados[8]=1;
					}else if(res2.isSelected()){
						resultados[8]=0;
					}
					break;
				}
				contador++;
					if(contador==11){
						siguiente.setText("Ver Resultado");
					}
				}
				else{
					if(res1.isSelected()){
						resultados[9]=1;
					}else if(res2.isSelected()){
						resultados[9]=0;
					}
					siguiente.setEnabled(false);
					res1.show(false);
					res2.show(false);
					String ss="Respuestas: ";
					for(int i=0;i<=9;i++){
						int aux=0;
						aux=(int)resultados[i];
						ss=ss+aux+" ";
					}
					Pregunta.setText(ss);
					pregunta.setText("Tu rol ideal es: ");
				}
			}
		});
		
		JButton iniciar = new JButton("Iniciar Test");
		iniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iniciar.setEnabled(false);
				siguiente.setEnabled(true);
				res1.show(true);
				res2.show(true);
				Pregunta.setText("Pregunta 1");
				pregunta.setText("¿Te gusta tratar con las personas?");
				res1.setText("Sí");
				res1.setSelected(true);
				res2.setText("No");
			}
		});
		panel.add(iniciar);
		panel.add(siguiente);
		
	}

}

package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglo.ArregloEstudiante;
import clase.Estudiante;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class Ventana1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textCod;
	private JTextField textNom;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textNota1;
	private JTextField textNota2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane;
	private JTextArea textS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana1 frame = new Ventana1();
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
	public Ventana1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Código:");
			lblNewLabel.setBounds(36, 41, 62, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(36, 84, 84, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			textCod = new JTextField();
			textCod.setBounds(142, 50, 126, 20);
			contentPane.add(textCod);
			textCod.setColumns(10);
		}
		{
			textNom = new JTextField();
			textNom.setBounds(142, 95, 126, 20);
			contentPane.add(textNom);
			textNom.setColumns(10);
		}
		{
			lblNewLabel_2 = new JLabel("Nota 1:");
			lblNewLabel_2.setBounds(36, 129, 62, 14);
			contentPane.add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("Nota 2:");
			lblNewLabel_3.setBounds(32, 167, 66, 14);
			contentPane.add(lblNewLabel_3);
		}
		{
			textNota1 = new JTextField();
			textNota1.setBounds(142, 133, 126, 20);
			contentPane.add(textNota1);
			textNota1.setColumns(10);
		}
		{
			textNota2 = new JTextField();
			textNota2.setBounds(142, 169, 126, 20);
			contentPane.add(textNota2);
			textNota2.setColumns(10);
		}
		{
			btnNewButton = new JButton("Reportar");
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(334, 55, 89, 43);
			contentPane.add(btnNewButton);
		}
		{
			btnNewButton_1 = new JButton("Agregar");
			btnNewButton_1.addActionListener(this);
			btnNewButton_1.setBounds(334, 104, 94, 39);
			contentPane.add(btnNewButton_1);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 225, 474, 148);
			contentPane.add(scrollPane);
			{
				textS = new JTextArea();
				textS.setText("Reporte de alumno y calificaciones");
				scrollPane.setViewportView(textS);
			}
		}
		{
			btnNewButton_2 = new JButton("Buscar");
			btnNewButton_2.addActionListener(this);
			btnNewButton_2.setBounds(334, 158, 94, 43);
			contentPane.add(btnNewButton_2);
		}
		{
			btnNewButton_3 = new JButton("Eliminar");
			btnNewButton_3.addActionListener(this);
			btnNewButton_3.setBounds(467, 70, 89, 43);
			contentPane.add(btnNewButton_3);
		}
		{
			lblNewLabel_4 = new JLabel("Reporte de estudiante y Rendimiento");
			lblNewLabel_4.setBounds(178, 11, 202, 16);
			contentPane.add(lblNewLabel_4);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_3) {
			do_btnNewButton_3_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton_2) {
			do_btnNewButton_2_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton_1) {
			do_btnNewButton_1_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	ArregloEstudiante ae = new ArregloEstudiante();
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel_4;
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		textS.setText("");
		Listado();
		Imprimir("\n");
		Imprimir("La cantidad de estudiantes es: "+ ae.Tamaño());
		Imprimir("El promedio general es: "+ ae.PromedioGeneral());
	}
	
	void Imprimir(String s) {
		textS.append(s+"\n");
	}
	
	void Listado() {
		Imprimir("Código\tNombre\tNota 1\tNota 2\tPromedio");
		for(int i = 0; i < ae.Tamaño(); i++) {
			Imprimir(""+ae.Obtener(i).getCod()+"\t"+ae.Obtener(i).getNombre() +"\t"+ ae.Obtener(i).getN1() +"\t"+ ae.Obtener(i).getN2() +"\t"+ ae.Obtener(i).Promedio());
		}
	}
	
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		Estudiante es = ae.Buscar(Integer.parseInt(textCod.getText()));
		
		if(es == null) {
			Estudiante e1 = new Estudiante(LeerCodigo(), LeerNombre(), LeerN1(), LeerN2());
			ae.Agregar(e1);
		}else
		{
			JOptionPane.showMessageDialog(this, "El código ya existe");
		}
	}
	
	int LeerCodigo() {
		return Integer.parseInt(textCod.getText());
	}
	
	String LeerNombre() {
		return textNom.getText();
	}
	
	double LeerN1() {
		return Double.parseDouble(textNota1.getText());
	}
	
	double LeerN2() {
		return Double.parseDouble(textNota2.getText());
	}
	
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		Estudiante es = ae.Buscar(LeerCodigo());
		if(es != null) {
			Imprimir("Código\tNombre\tNota 1\tNota 2\tPromedio");
			Imprimir(""+es.getCod()+"\t"+ es.getNombre()+"\t"+ es.getN1()+"\t"+ es.getN2()+ "\t"+ es.Promedio());
		}else {
			JOptionPane.showMessageDialog(this, "El código no existe");
		}
	}
	
	protected void do_btnNewButton_3_actionPerformed(ActionEvent e) {
		Estudiante es = ae.Buscar(LeerCodigo());
		if(es != null) {
			ae.Eliminar(es);
		}else {
			JOptionPane.showMessageDialog(this, "El código no existe");
		}
		
		
	}
}

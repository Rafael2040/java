package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.filme;
import model.dao.FilmeDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFCadastrarFilme extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastrarFilme frame = new JFCadastrarFilme();
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
	public JFCadastrarFilme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Filme");
		lblNewLabel.setBounds(5, 5, 154, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EDtulo");
		lblNewLabel_1.setBounds(5, 30, 56, 14);
		contentPane.add(lblNewLabel_1);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(5, 55, 421, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Sinopse");
		lblNewLabel_2.setBounds(5, 86, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(69, 174, 6, 20);
		contentPane.add(textPane);
		
		JLabel lblNewLabel_3 = new JLabel("Categoria");
		lblNewLabel_3.setBounds(5, 217, 90, 14);
		contentPane.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 102, 421, 104);
		contentPane.add(scrollPane);
		
		JTextArea txtSinopse = new JTextArea();
		scrollPane.setViewportView(txtSinopse);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(5, 233, 421, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Tempo");
		lblNewLabel_4.setBounds(5, 266, 70, 14);
		contentPane.add(lblNewLabel_4);
		
		JSpinner spTempo = new JSpinner();
		spTempo.setBounds(5, 280, 29, 20);
		contentPane.add(spTempo);
		
		JLabel lblNewLabel_5 = new JLabel("Imagem");
		lblNewLabel_5.setBounds(93, 266, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JRadioButton rdbtnNewRadioButton3D = new JRadioButton("3D");
		rdbtnNewRadioButton3D.setBounds(85, 279, 109, 23);
		contentPane.add(rdbtnNewRadioButton3D);
		
		JRadioButton rdbtnNewRadioButton2D = new JRadioButton("2D");
		rdbtnNewRadioButton2D.setBounds(85, 306, 109, 23);
		contentPane.add(rdbtnNewRadioButton2D);
		
		ButtonGroup imagem = new ButtonGroup();
		imagem.add(rdbtnNewRadioButton3D);
		imagem.add(rdbtnNewRadioButton2D);
		
		JLabel lblNewLabel_6 = new JLabel("Audio");
		lblNewLabel_6.setBounds(255, 266, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JRadioButton rdbtnNewRadioButtonDublado = new JRadioButton("Dublado");
		rdbtnNewRadioButtonDublado.setBounds(248, 279, 109, 23);
		contentPane.add(rdbtnNewRadioButtonDublado);
		
		JRadioButton rdbtnNewRadioButtonLegendado = new JRadioButton("Legendado");
		rdbtnNewRadioButtonLegendado.setBounds(248, 306, 109, 23);
		contentPane.add(rdbtnNewRadioButtonLegendado);
		
		ButtonGroup audio = new ButtonGroup();
		audio.add(rdbtnNewRadioButtonDublado);
		audio.add(rdbtnNewRadioButtonLegendado);
		
		JButton btnNewButtonCadastrar = new JButton("Cadastrar");
		btnNewButtonCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filme f = new filme();
				FilmeDAO dao = new FilmeDAO();
				f.setTitulo(txtTitulo.getText());
				f.setSinopse(txtSinopse.getText());
				f.setCategoria(txtCategoria.getText());
				f.setTempo(Integer.parseInt(spTempo.getValue().toString()));
				if(rdbtnNewRadioButton2D.isSelected()) {
					f.setImagem3d(false);
				}else if(rdbtnNewRadioButton3D.isSelected()) {
					f.setImagem3d(true);
				}
				
				if(rdbtnNewRadioButtonDublado.isSelected()) {
					f.setDublado(true);
				}else if(rdbtnNewRadioButtonLegendado.isSelected()) {
					f.setImagem3d(false);
				}
				dao.create(f);
			}
		});	
		btnNewButtonCadastrar.setBounds(5, 343, 89, 23);
		contentPane.add(btnNewButtonCadastrar);
		
		JButton btnNewButtonLimpar = new JButton("Limpar");
		btnNewButtonLimpar.setBounds(174, 343, 89, 23);
		contentPane.add(btnNewButtonLimpar);
		
		JButton btnNewButtonCancelar = new JButton("Cancelar");
		btnNewButtonCancelar.setBounds(333, 343, 89, 23);
		contentPane.add(btnNewButtonCancelar);
	}
}	
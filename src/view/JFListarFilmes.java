package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.filme;
import model.dao.FilmeDAO;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class JFListarFilmes extends JFrame {

	private JPanel contentPane;
	private JTable JTFilmes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarFilmes frame = new JFListarFilmes();
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
	public JFListarFilmes() {
		setTitle("Listagem de Filmes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar Filmes");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 131, 21);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 625, 247);
		contentPane.add(scrollPane);
		
		JTFilmes = new JTable();
		JTFilmes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idFilme", "titulo", "categoria", "tempo"
			}
		));
		scrollPane.setViewportView(JTFilmes);
		
		JButton BTNCadastrar = new JButton("Cadastrar Filme");
		BTNCadastrar.setBounds(20, 318, 131, 23);
		contentPane.add(BTNCadastrar);
		
		JButton BTNExcluir = new JButton("Excluir Filme");
		BTNExcluir.setBounds(492, 318, 131, 23);
		contentPane.add(BTNExcluir);
		
		JButton BTNAlterar = new JButton("Alterar Filme");
		BTNAlterar.setBounds(255, 318, 121, 23);
		contentPane.add(BTNAlterar);
		
		readJTable();
		}
		public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) jtfilme.getModel();
		modelo.setNumRows(0);
		FilmeDAO fdao = new FilmeDAO();
		for(filme f: fdao.read()) {
			modelo.addRow(new Object[] {
				f.getIdFilme(),
				f.getTitulo(),
				f.getCategoria(),
				f.getTempo()
			});
		}
	}
}

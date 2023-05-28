package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.AlunoController;

public class Tela extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNomeAluno;
	private JTextField tfRAAluno;
	private JTextField tfEscrita;
	private JTextField tfHistorico;
	private JTextField tfRegistraID;
	private JTextField tfTemaTrabalho;
	private JTextField tfMetodologia;
	private JTextField tfConsultaID;
	private JTextField tfWhatsaapAluno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
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
	public Tela() {
		setTitle("Sistema de Controle de TCC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 35, 572, 488);
		contentPane.add(tabbedPane);
		
		JPanel Alunos = new JPanel();
		tabbedPane.addTab("Aluno", null, Alunos, "Cadastro de alunos");
		Alunos.setLayout(null);
		
		JLabel lblNomeAluno = new JLabel("Nome do aluno:");
		lblNomeAluno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeAluno.setBounds(10, 38, 112, 20);
		Alunos.add(lblNomeAluno);
		
		JLabel lblRa = new JLabel("RA:");
		lblRa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRa.setBounds(10, 78, 112, 20);
		Alunos.add(lblRa);
		
		tfNomeAluno = new JTextField();
		tfNomeAluno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNomeAluno.setBounds(132, 38, 254, 20);
		Alunos.add(tfNomeAluno);
		tfNomeAluno.setColumns(10);
		
		tfRAAluno = new JTextField();
		tfRAAluno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfRAAluno.setColumns(10);
		tfRAAluno.setBounds(132, 78, 254, 20);
		Alunos.add(tfRAAluno);
		
		JButton btnGravarAlunos = new JButton("Gravar");
		btnGravarAlunos.setToolTipText("Gravar Aluno no Sistema");
		btnGravarAlunos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGravarAlunos.setBackground(new Color(128, 255, 128));
		btnGravarAlunos.setBounds(431, 37, 89, 23);
		Alunos.add(btnGravarAlunos);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setToolTipText("Excluir Aluno do Sistema");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir.setBackground(new Color(255, 181, 181));
		btnExcluir.setBounds(431, 77, 89, 23);
		Alunos.add(btnExcluir);
		
		JLabel lblDataDeIncio = new JLabel("Data de início:");
		lblDataDeIncio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataDeIncio.setBounds(10, 183, 112, 20);
		Alunos.add(lblDataDeIncio);
		
		JLabel lblPrevisaoConclusao = new JLabel("Previsão de conclusão:");
		lblPrevisaoConclusao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrevisaoConclusao.setBounds(10, 228, 159, 20);
		Alunos.add(lblPrevisaoConclusao);
		
		JPanel Grupos = new JPanel();
		tabbedPane.addTab("Registrar Grupo", null, Grupos, null);
		Grupos.setLayout(null);
		
		JLabel lblRegistraID = new JLabel("ID grupo:");
		lblRegistraID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRegistraID.setBounds(23, 29, 81, 20);
		Grupos.add(lblRegistraID);
		
		tfRegistraID = new JTextField();
		tfRegistraID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfRegistraID.setColumns(10);
		tfRegistraID.setBounds(143, 29, 307, 20);
		Grupos.add(tfRegistraID);
		
		JLabel lblAreaTrabalho = new JLabel("Área do trabalho:");
		lblAreaTrabalho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAreaTrabalho.setBounds(23, 64, 115, 18);
		Grupos.add(lblAreaTrabalho);
		
		JComboBox cbAreaTrabalho = new JComboBox();
		cbAreaTrabalho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbAreaTrabalho.setBounds(143, 64, 307, 22);
		Grupos.add(cbAreaTrabalho);
		
		JLabel lblTemaTrabalho = new JLabel("Tema:");
		lblTemaTrabalho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTemaTrabalho.setBounds(23, 105, 81, 20);
		Grupos.add(lblTemaTrabalho);
		
		tfTemaTrabalho = new JTextField();
		tfTemaTrabalho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfTemaTrabalho.setColumns(10);
		tfTemaTrabalho.setBounds(143, 108, 307, 20);
		Grupos.add(tfTemaTrabalho);
		
		JLabel lblOrientador = new JLabel("Orientador:");
		lblOrientador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOrientador.setBounds(23, 154, 103, 20);
		Grupos.add(lblOrientador);
		
		JComboBox cbOrientador = new JComboBox();
		cbOrientador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbOrientador.setBounds(143, 152, 307, 22);
		Grupos.add(cbOrientador);
		
		JLabel lblMetodologia = new JLabel("Metodologia:");
		lblMetodologia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMetodologia.setBounds(23, 200, 110, 18);
		Grupos.add(lblMetodologia);
		
		tfMetodologia = new JTextField();
		tfMetodologia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfMetodologia.setColumns(10);
		tfMetodologia.setBounds(143, 198, 307, 20);
		Grupos.add(tfMetodologia);
		
		JLabel lblIntegrantes = new JLabel("Integrantes do grupo:");
		lblIntegrantes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIntegrantes.setBounds(210, 242, 155, 20);
		Grupos.add(lblIntegrantes);
		
		JTextArea taIntegrantes = new JTextArea();
		taIntegrantes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		taIntegrantes.setBounds(10, 272, 547, 104);
		Grupos.add(taIntegrantes);
		
		JButton btnGravarGrupo = new JButton("Gravar");
		btnGravarGrupo.setToolTipText("Grava os Integrantes do grupo no Sistema");
		btnGravarGrupo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGravarGrupo.setBackground(new Color(128, 255, 128));
		btnGravarGrupo.setBounds(131, 396, 115, 37);
		Grupos.add(btnGravarGrupo);
		
		JButton btnLimparGrupo = new JButton("Limpar");
		btnLimparGrupo.setToolTipText("Apaga os campos ");
		btnLimparGrupo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimparGrupo.setBackground(new Color(255, 181, 181));
		btnLimparGrupo.setBounds(319, 396, 103, 37);
		Grupos.add(btnLimparGrupo);
		
		JPanel ConsultarGrupos = new JPanel();
		tabbedPane.addTab("Consultar Grupo por Área", null, ConsultarGrupos, null);
		ConsultarGrupos.setLayout(null);
		
		JLabel lblSelecionarArea = new JLabel("Sub-Área:");
		lblSelecionarArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelecionarArea.setBounds(10, 70, 106, 18);
		ConsultarGrupos.add(lblSelecionarArea);
		
		JComboBox cbArea = new JComboBox();
		cbArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbArea.setBounds(110, 25, 326, 22);
		ConsultarGrupos.add(cbArea);
		
		JButton btnConsultarSubArea = new JButton("Consultar");
		btnConsultarSubArea.setToolTipText("Consulta grupo por Sub-Área");
		btnConsultarSubArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultarSubArea.setForeground(Color.BLACK);
		btnConsultarSubArea.setBackground(new Color(193, 193, 255));
		btnConsultarSubArea.setBounds(403, 231, 106, 34);
		ConsultarGrupos.add(btnConsultarSubArea);
		
		JLabel lblGrupo = new JLabel("Grupos:");
		lblGrupo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGrupo.setBounds(10, 115, 78, 22);
		ConsultarGrupos.add(lblGrupo);
		
		JList lGrupos = new JList();
		lGrupos.setBounds(10, 158, 339, 183);
		ConsultarGrupos.add(lGrupos);
		
		JLabel lblArea = new JLabel("Área:");
		lblArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblArea.setBounds(10, 27, 66, 18);
		ConsultarGrupos.add(lblArea);
		
		JComboBox cbSubArea = new JComboBox();
		cbSubArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbSubArea.setBounds(110, 71, 326, 21);
		ConsultarGrupos.add(cbSubArea);
		
		JPanel ConsultarGruposID = new JPanel();
		tabbedPane.addTab("Consultar Grupos por ID", null, ConsultarGruposID, null);
		ConsultarGruposID.setLayout(null);
		
		JLabel lblConsultaID = new JLabel("ID Grupo:");
		lblConsultaID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConsultaID.setBounds(10, 30, 85, 14);
		ConsultarGruposID.add(lblConsultaID);
		
		tfConsultaID = new JTextField();
		tfConsultaID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfConsultaID.setColumns(10);
		tfConsultaID.setBounds(105, 27, 379, 20);
		ConsultarGruposID.add(tfConsultaID);
		
		JButton btnConsultarID = new JButton("Consultar");
		btnConsultarID.setToolTipText("Consulta grupo por ID");
		btnConsultarID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultarID.setForeground(Color.BLACK);
		btnConsultarID.setBackground(new Color(193, 193, 255));
		btnConsultarID.setBounds(406, 191, 106, 34);
		ConsultarGruposID.add(btnConsultarID);
		
		JLabel lblInformacoes = new JLabel("Informações do grupo:");
		lblInformacoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInformacoes.setBounds(10, 70, 146, 20);
		ConsultarGruposID.add(lblInformacoes);
		
		JList lInformacoesGrupo = new JList();
		lInformacoesGrupo.setBackground(Color.WHITE);
		lInformacoesGrupo.setBounds(10, 113, 339, 193);
		ConsultarGruposID.add(lInformacoesGrupo);
		
		JPanel RegistrarOrientacao = new JPanel();
		RegistrarOrientacao.setToolTipText("");
		tabbedPane.addTab("Registrar/Consultar Orientação", null, RegistrarOrientacao, null);
		RegistrarOrientacao.setLayout(null);
		
		JLabel lblIDGrupo = new JLabel("ID grupo:");
		lblIDGrupo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIDGrupo.setBounds(10, 14, 141, 22);
		RegistrarOrientacao.add(lblIDGrupo);
		
		JComboBox cbIDGrupo = new JComboBox();
		cbIDGrupo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbIDGrupo.setBounds(92, 14, 306, 22);
		RegistrarOrientacao.add(cbIDGrupo);
		
		JLabel lblDataEntrega = new JLabel("Data de entrega:");
		lblDataEntrega.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataEntrega.setBounds(10, 65, 141, 22);
		RegistrarOrientacao.add(lblDataEntrega);
		
		JLabel lblOrientacao = new JLabel("Digite sua orientação:");
		lblOrientacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOrientacao.setBounds(20, 112, 141, 22);
		RegistrarOrientacao.add(lblOrientacao);
		
		JButton btnGravaOrientacao = new JButton("Lançar");
		btnGravaOrientacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGravaOrientacao.setToolTipText("Lançar a orientação no Sistema");
		btnGravaOrientacao.setForeground(Color.BLACK);
		btnGravaOrientacao.setBackground(new Color(128, 255, 128));
		btnGravaOrientacao.setBounds(28, 357, 99, 34);
		RegistrarOrientacao.add(btnGravaOrientacao);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setToolTipText("Apagar a orientação escrita");
		btnLimpar.setBackground(new Color(255, 181, 181));
		btnLimpar.setBounds(158, 357, 99, 34);
		RegistrarOrientacao.add(btnLimpar);
		
		tfEscrita = new JTextField();
		tfEscrita.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfEscrita.setToolTipText("");
		tfEscrita.setBounds(23, 160, 234, 176);
		RegistrarOrientacao.add(tfEscrita);
		tfEscrita.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultar.setToolTipText("Consulta Histórico de orientações com o ID do grupo");
		btnConsultar.setForeground(Color.BLACK);
		btnConsultar.setBackground(new Color(193, 193, 255));
		btnConsultar.setBounds(357, 357, 107, 34);
		RegistrarOrientacao.add(btnConsultar);
		
		tfHistorico = new JTextField();
		tfHistorico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfHistorico.setBounds(292, 160, 234, 176);
		RegistrarOrientacao.add(tfHistorico);
		tfHistorico.setColumns(10);
		
		JLabel lblHistorico = new JLabel("Histórico:");
		lblHistorico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHistorico.setBounds(292, 112, 91, 22);
		RegistrarOrientacao.add(lblHistorico);
		
		
		AlunoController alunoCont = new AlunoController(tfNomeAluno, tfRAAluno);
		
		JButton btnConsultarAluno = new JButton("Consultar");
		btnConsultarAluno.setBackground(new Color(193, 193, 255));
		btnConsultarAluno.setToolTipText("Verifica se Aluno ja esta no sistema");
		btnConsultarAluno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConsultarAluno.setBounds(431, 117, 89, 23);
		Alunos.add(btnConsultarAluno);
		
		JLabel lblWhatsaapAluno = new JLabel("Whatsapp:");
		lblWhatsaapAluno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWhatsaapAluno.setBounds(10, 117, 97, 20);
		Alunos.add(lblWhatsaapAluno);
		
		tfWhatsaapAluno = new JTextField();
		tfWhatsaapAluno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfWhatsaapAluno.setBounds(132, 120, 254, 19);
		Alunos.add(tfWhatsaapAluno);
		tfWhatsaapAluno.setColumns(10);
		
		btnGravarAlunos.addActionListener(alunoCont);
		
		
		
		
		
	}
}
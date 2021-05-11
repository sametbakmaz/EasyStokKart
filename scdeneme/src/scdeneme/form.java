package scdeneme;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class form extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	Object[] kolonlar = { "Stok Kodu", "Stok Adı", "Stok Tipi", "Birimi", "Barkodu", "KDV Tipi", "Açıklama",
			"Oluşturma Tarihi" };
	Object[] satirlar = new Object[9];
	private JTextField tf_StokKodu;
	private JTextField tf_StokAdi;
	private JTextField tf_Barkod;
	private JTextField tf_arama;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form frame = new form();
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
	public form() {
		setForeground(SystemColor.controlShadow);
		setFont(new Font("Dialog", Font.BOLD, 14));
		setTitle("STOK KARTI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1156, 677);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(26, 78, 802, 341);
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("STOK KODU");
		lblNewLabel.setBounds(26, 463, 66, 13);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 10));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("STOK ADI");
		lblNewLabel_1.setBounds(276, 463, 55, 13);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 10));
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("STOK TİPİ");
		lblNewLabel_1_1.setBounds(26, 545, 55, 13);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 10));
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("BİRİMİ");
		lblNewLabel_1_2.setBounds(276, 545, 55, 13);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 10));
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("BARKODU");
		lblNewLabel_1_3.setBounds(526, 463, 55, 13);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 10));
		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("KDV TİPİ");
		lblNewLabel_1_4.setBounds(526, 500, 45, 13);
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 10));
		contentPane.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("AÇIKLAMA");
		lblNewLabel_1_5.setBounds(526, 545, 71, 13);
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.BOLD, 10));
		contentPane.add(lblNewLabel_1_5);

		JButton btn_Kaydet = new JButton("KAYDET");
		btn_Kaydet.setBounds(905, 519, 213, 97);
		btn_Kaydet.setBackground(new Color(154, 205, 50));
		btn_Kaydet.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(btn_Kaydet);

		tf_StokKodu = new JTextField();
		tf_StokKodu.setBounds(102, 459, 140, 38);
		tf_StokKodu.setBackground(new Color(255, 255, 204));
		contentPane.add(tf_StokKodu);
		tf_StokKodu.setColumns(10);

		tf_StokAdi = new JTextField();
		tf_StokAdi.setBounds(342, 459, 140, 38);
		tf_StokAdi.setBackground(new Color(255, 255, 204));
		tf_StokAdi.setColumns(10);
		contentPane.add(tf_StokAdi);

		JComboBox cb_StokTipi = new JComboBox();
		cb_StokTipi.setBounds(102, 540, 140, 38);
		cb_StokTipi.setBackground(new Color(255, 255, 204));
		cb_StokTipi.setModel(new DefaultComboBoxModel(new String[] { "KUMAŞ\t", "AKSESUAR" }));
		cb_StokTipi.setSelectedIndex(1);
		contentPane.add(cb_StokTipi);

		JComboBox cb_Birim = new JComboBox();
		cb_Birim.setBounds(342, 540, 140, 38);
		cb_Birim.setBackground(new Color(255, 255, 204));
		cb_Birim.setModel(new DefaultComboBoxModel(new String[] { "METRE", "KILOGRAM", "LITRE", "ADET" }));
		cb_Birim.setSelectedIndex(3);
		contentPane.add(cb_Birim);

		tf_Barkod = new JTextField();
		tf_Barkod.setBounds(607, 459, 123, 35);
		tf_Barkod.setBackground(new Color(255, 255, 204));
		contentPane.add(tf_Barkod);
		tf_Barkod.setColumns(10);

		JComboBox cb_Kdv = new JComboBox();
		cb_Kdv.setBounds(607, 504, 55, 19);
		cb_Kdv.setBackground(new Color(255, 255, 204));
		cb_Kdv.setModel(new DefaultComboBoxModel(new String[] { "8.0", "18.0" }));
		cb_Kdv.setSelectedIndex(1);
		contentPane.add(cb_Kdv);

		JTextArea ta_Aciklama = new JTextArea();
		ta_Aciklama.setBounds(607, 543, 221, 75);
		ta_Aciklama.setBackground(SystemColor.info);
		ta_Aciklama.setForeground(SystemColor.infoText);
		contentPane.add(ta_Aciklama);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				tf_StokKodu.setText(model.getValueAt(table.getSelectedRow(), 0) + "");
				tf_StokAdi.setText((String) model.getValueAt(table.getSelectedRow(), 1));
				tf_Barkod.setText((String) model.getValueAt(table.getSelectedRow(), 4));

				if (((String) model.getValueAt(table.getSelectedRow(), 3)).equals("METRE")) {
					cb_Birim.setSelectedIndex(0);
				}
				if (((String) model.getValueAt(table.getSelectedRow(), 3)).equals("KILOGRAM")) {
					cb_Birim.setSelectedIndex(1);
				}
				if (((String) model.getValueAt(table.getSelectedRow(), 3)).equals("LITRE")) {
					cb_Birim.setSelectedIndex(2);
				}
				if (((String) model.getValueAt(table.getSelectedRow(), 3)).equals("ADET")) {
					cb_Birim.setSelectedIndex(3);
				}
				if (((String) model.getValueAt(table.getSelectedRow(), 2)).equals("KUMAŞ")) {
					cb_StokTipi.setSelectedIndex(0);

				}
				if (((String) model.getValueAt(table.getSelectedRow(), 2)).equals("AKSESUAR")) {
					cb_StokTipi.setSelectedIndex(1);

				}
				System.out.println(model.getValueAt(table.getSelectedRow(), 5));
				if ((Double) model.getValueAt(table.getSelectedRow(), 5) == 8) {
					cb_Kdv.setSelectedIndex(0);
				} else if ((Double) model.getValueAt(table.getSelectedRow(), 5) == 18) {
					cb_Kdv.setSelectedIndex(1);
				}

				ta_Aciklama.setText((String) model.getValueAt(table.getSelectedRow(), 6));

			}
		});

		JButton btn_duzenle = new JButton("DÜZENLE");
		btn_duzenle.setBounds(905, 131, 213, 55);
		btn_duzenle.setBackground(new Color(204, 204, 51));
		btn_duzenle.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(btn_duzenle);

		JButton btn_kopyala = new JButton("KOPYALA");
		btn_kopyala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String stokKodu, stokAdi, birimi = null, barkodu, aciklama = null; //kopyala
				int stokTipi;

				double kdvTipi = 0;
				

				stokKodu = JOptionPane.showInputDialog("Yeni stok kodunu giriniz : ");
				if (stokKodu.equals("")) {
					String st = "stok kodu boş bırakılamaz";
					JOptionPane.showMessageDialog(null, st);
					return;
				}
				
				stokAdi = tf_StokAdi.getText();
				barkodu = tf_Barkod.getText();
				aciklama = ta_Aciklama.getText();

				if (cb_Kdv.getSelectedIndex() == 0) {// kdv
					kdvTipi = 8.0;
				}
				if (cb_Kdv.getSelectedIndex() == 1) {
					kdvTipi = 18.0;
				}

				stokTipi = cb_StokTipi.getSelectedIndex();

				if (cb_Birim.getSelectedIndex() == 0)// birim

				{
					birimi = "METRE";
				}
				if (cb_Birim.getSelectedIndex() == 1)

				{
					birimi = "KILOGRAM";
				}
				if (cb_Birim.getSelectedIndex() == 2)

				{
					birimi = "LITRE";
				}
				if (cb_Birim.getSelectedIndex() == 3)

				{
					birimi = "ADET";
				}

				String kaydetSQL = "INSERT INTO stok_kart(stok_kodu,stok_adi,stok_tipi,stok_birimi,stok_barkodu,stok_kdv,stok_aciklama)"
						+ " VALUES('" + stokKodu + "','" + stokAdi + "','" + stokTipi + "','" + birimi + "','" + barkodu
						+ "','" + kdvTipi + "','" + aciklama + "')";
				System.out.println(kaydetSQL);
				veritabani.kaydet(kaydetSQL);
				baglanListele();
//				String st = "KAYIT KOPYALANDI ";
//				JOptionPane.showMessageDialog(null, st);

			}
		});
		btn_kopyala.setBounds(905, 223, 213, 55);
		btn_kopyala.setBackground(new Color(255, 204, 51));
		btn_kopyala.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(btn_kopyala);

		JButton btn_sil = new JButton("SİL");// SİL
		btn_sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stokKodu, sorgu;

				stokKodu = tf_StokKodu.getText();
				if (stokKodu.equals("")) {
					String st = "SİLİNECEK KAYITI SEÇİNİZ";
					JOptionPane.showMessageDialog(null, st);
				} else {
					sorgu = "DELETE  FROM stok_kart WHERE stok_kodu = \"" + stokKodu + "\"";
					System.out.println(sorgu);

					veritabani.sil(sorgu);
					baglanListele();
					String st = "KAYIT SİLİNDİ";
					JOptionPane.showMessageDialog(null, st);
					
						

				}
				
				

			}
		});

		btn_sil.setBounds(905, 310, 213, 55);
		btn_sil.setBackground(new Color(255, 51, 0));
		btn_sil.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(btn_sil);

		JButton btn_arama = new JButton("ARAMA"); // ARA
		btn_arama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				model.setRowCount(0);
				String stokKodu = tf_arama.getText();
				ResultSet rs = null;
				String sorgu = "select * from stok_kart where stok_kodu like'" + stokKodu + "%'";
				System.out.println(sorgu);
				rs = veritabani.ara(sorgu);

				try {
					while (rs.next()) {

						satirlar[0] = rs.getObject("stok_kodu");
						satirlar[1] = rs.getObject("stok_adı");
						satirlar[2] = rs.getObject("stok_tipi");
						satirlar[3] = rs.getObject("stok_birimi");
						satirlar[4] = rs.getObject("stok_barkodu");
						satirlar[5] = rs.getObject("stok_kdv");
						satirlar[6] = rs.getObject("stok_aciklama");
						satirlar[7] = rs.getObject("stok_tarih");
						model.addRow(satirlar);

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table.setModel(model);

			}
		});
		btn_arama.setBounds(1025, 68, 93, 38);
		btn_arama.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btn_arama.setBackground(SystemColor.inactiveCaption);
		contentPane.add(btn_arama);

		tf_arama = new JTextField();
		tf_arama.setFont(new Font("Times New Roman", Font.BOLD, 10));
		tf_arama.setBounds(908, 70, 96, 38);
		tf_arama.setForeground(Color.DARK_GRAY);
		contentPane.add(tf_arama);
		tf_arama.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("STOK KARTI");
		lblNewLabel_2.setBounds(276, 10, 292, 55);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 40));
		contentPane.add(lblNewLabel_2);

		JButton btn_listele = new JButton("LİSTELE");

		btn_listele.setBounds(971, 10, 93, 26);
		contentPane.add(btn_listele);

		btn_listele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				baglanListele();

			}
		});

		btn_Kaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // EKLE
				String stokKodu, stokAdi, birimi = null, barkodu, aciklama = null;
				int stokTipi;

				double kdvTipi = 0;

				if (tf_StokKodu.getText().equals("")) {
					String st = "stok kodu boş bırakılamaz";
					JOptionPane.showMessageDialog(null, st);
					return;
				}

				stokKodu = tf_StokKodu.getText();
				stokAdi = tf_StokAdi.getText();
				barkodu = tf_Barkod.getText();
				aciklama = ta_Aciklama.getText();

				if (cb_Kdv.getSelectedIndex() == 0) {// kdv
					kdvTipi = 8.0;
				}
				if (cb_Kdv.getSelectedIndex() == 1) {
					kdvTipi = 18.0;
				}

				stokTipi = cb_StokTipi.getSelectedIndex();

				if (cb_Birim.getSelectedIndex() == 0)// birim

				{
					birimi = "METRE";
				}
				if (cb_Birim.getSelectedIndex() == 1)

				{
					birimi = "KILOGRAM";
				}
				if (cb_Birim.getSelectedIndex() == 2)

				{
					birimi = "LITRE";
				}
				if (cb_Birim.getSelectedIndex() == 3)

				{
					birimi = "ADET";
				}

				String kaydetSQL = "INSERT INTO stok_kart(stok_kodu,stok_adi,stok_tipi,stok_birimi,stok_barkodu,stok_kdv,stok_aciklama)"
						+ " VALUES('" + stokKodu + "','" + stokAdi + "','" + stokTipi + "','" + birimi + "','" + barkodu
						+ "','" + kdvTipi + "','" + aciklama + "')";
				System.out.println(kaydetSQL);
				veritabani.kaydet(kaydetSQL);
				baglanListele();
				/*if(!stokKodu.equals("")) {
				String st = "KAYIT BAŞARIYLA EKLENDİ";
				JOptionPane.showMessageDialog(null, st);
				}*/
			}
		});

		btn_duzenle.addActionListener(new ActionListener() { // DÜZENLE
			public void actionPerformed(ActionEvent e) {

				String stokKodu, stokAdi, birimi = null, barkodu, aciklama = null;
				double kdvTipi = 0;
				int stokTipi = 0;
				stokKodu = tf_StokKodu.getText();
				stokAdi = tf_StokAdi.getText();
				barkodu = tf_Barkod.getText();
				aciklama = ta_Aciklama.getText();

				if (cb_Kdv.getSelectedIndex() == 0) {// kdv
					kdvTipi = 8.0;
				}
				if (cb_Kdv.getSelectedIndex() == 1) {
					kdvTipi = 18.0;
				}

				stokTipi = cb_StokTipi.getSelectedIndex();

				if (cb_Birim.getSelectedIndex() == 0)// birim

				{
					birimi = "METRE";
				}
				if (cb_Birim.getSelectedIndex() == 1)

				{
					birimi = "KILOGRAM";
				}
				if (cb_Birim.getSelectedIndex() == 2)

				{
					birimi = "LITRE";
				}
				if (cb_Birim.getSelectedIndex() == 3)

				{
					birimi = "ADET";
				}

				String sorgu = "UPDATE stok_kart SET stok_kodu=\"" + stokKodu + "\"," + "stok_adi=\"" + stokAdi
						+ "\",stok_tipi=\"" + stokTipi + "\",stok_birimi=\"" + birimi + "\",stok_barkodu=\"" + barkodu
						+ "\",stok_kdv=\"" + kdvTipi + "\",stok_aciklama=\"" + aciklama + "\" WHERE stok_kodu = \""
						+ stokKodu + "\"";

				System.out.println(sorgu);
				veritabani.duzenle(sorgu);
				baglanListele();

			}
		});

	}

	void baglanListele() {

		veritabani.baglan();
		String listeleSql = "select*from stok_kart";
		ResultSet rs = veritabani.listele(listeleSql);

		model.setColumnCount(0);
		model.setRowCount(0);
		model.setColumnIdentifiers(kolonlar);

		try {
			while (rs.next()) {

				satirlar[0] = rs.getObject("stok_kodu");
				satirlar[1] = rs.getObject("stok_adı");
				satirlar[2] = rs.getObject("stok_tipi");
				if ((int) rs.getObject("stok_tipi") == 0) {
					satirlar[2] = "KUMAŞ";

				} else if ((int) rs.getObject("stok_tipi") == 1) {
					satirlar[2] = "AKSESUAR";
				}

				satirlar[3] = rs.getObject("stok_birimi");
				satirlar[4] = rs.getObject("stok_barkodu");
				satirlar[5] = rs.getObject("stok_kdv");
				satirlar[6] = rs.getObject("stok_aciklama");
				satirlar[7] = rs.getObject("stok_tarih");
				model.addRow(satirlar);

			}
			table.setModel(model);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class MudurMenu extends JFrame {

	private JPanel contentPane;
	private JTextField textAdSoyad;
	private JTextField textTelefon;
	private JTextField textAdres;
	private JTextField textE_posta;
	private JTextField textTCNO;
	private JTextField textKrediFaizi;
	private JTextField textGecikmeFaizi;
	private JTextField textParaBirimi;
	private JTextField textKurGuncelle;
	private JTextField textMaasBelirle;
	private JTextField textKullaniciAdi;
	private JTextField textXAdetGir;
	private JTable table;
	private Sorgular sorgu=new Sorgular();
	private Connection connect=DataBaseBaglanti.connect;
	private Mudur mudur;
	private Banka banka=Banka.getBanka();
	private JTextField textSifre;
	private JTextField textKacAy;
	private JTextField textYeniPbKur;
	public MudurMenu(Mudur mudur) {
		this.mudur=mudur;
		sorgu.bankaBilgileriGuncelle(banka);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 973, 469);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel giris = new JPanel();
		giris.setBackground(Color.PINK);
		tabbedPane.addTab("Giris", null, giris, null);
		giris.setLayout(null);
		
		JLabel lblMerhaba = new JLabel("Merhaba ,");
		lblMerhaba.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMerhaba.setBounds(322, 69, 138, 68);
		giris.add(lblMerhaba);
		
		JLabel lblGirisAdSoyadDonut = new JLabel(mudur.getAdSoyad());
		lblGirisAdSoyadDonut.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblGirisAdSoyadDonut.setBounds(492, 69, 241, 68);
		giris.add(lblGirisAdSoyadDonut);
		
		JButton btnGirisEkraninaDon = new JButton("< Giris Ekranina Don");
		btnGirisEkraninaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				form1 frame2=new form1();
				frame2.giris();
				frame2.setVisible(true);
			}
		});
		btnGirisEkraninaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btnGirisEkraninaDon.setBounds(20, 346, 173, 23);
		giris.add(btnGirisEkraninaDon);
		
		JLabel lblGirisKullaniciAdi = new JLabel("Kullanici Adi :");
		lblGirisKullaniciAdi.setBounds(126, 182, 102, 14);
		giris.add(lblGirisKullaniciAdi);
		
		JLabel lblGirisKullaniciAdiDonut = new JLabel(mudur.getKullaniciAdi());
		lblGirisKullaniciAdiDonut.setBounds(242, 182, 102, 14);
		giris.add(lblGirisKullaniciAdiDonut);
		
		JPanel bankaBilgileri = new JPanel();
		bankaBilgileri.setBackground(new Color(255, 255, 224));
		tabbedPane.addTab("Banka Bilgileri", null, bankaBilgileri, null);
		bankaBilgileri.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(39, 30, 187, 288);
		panel_2.setBackground(new Color(0, 255, 127));
		bankaBilgileri.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Gelir");
		lblNewLabel_5.setBounds(10, 45, 46, 14);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Gider");
		lblNewLabel_6.setBounds(10, 79, 46, 14);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Kar");
		lblNewLabel_7.setBounds(10, 115, 46, 14);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("bakiye");
		lblNewLabel_8.setBounds(10, 148, 46, 14);
		panel_2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Banka'nin");
		lblNewLabel_9.setBounds(42, 11, 67, 14);
		panel_2.add(lblNewLabel_9);
		
		JLabel lblGelirDonut = new JLabel(""+banka.bankaHesabi.getGelir());
		lblGelirDonut.setBounds(97, 45, 67, 14);
		panel_2.add(lblGelirDonut);
		
		JLabel lblGiderDonut = new JLabel(""+banka.bankaHesabi.getGider());
		lblGiderDonut.setBounds(97, 79, 67, 14);
		panel_2.add(lblGiderDonut);
		
		JLabel lblKarDonut = new JLabel(""+banka.bankaHesabi.getKar());
		lblKarDonut.setBounds(97, 115, 67, 14);
		panel_2.add(lblKarDonut);
		
		JLabel lblBakiyeDonut = new JLabel(""+banka.bankaHesabi.getBakiye());
		lblBakiyeDonut.setBounds(97, 148, 55, 14);
		panel_2.add(lblBakiyeDonut);
		
		JLabel lblNewLabel_11_2 = new JLabel("Kredi Faizi");
		lblNewLabel_11_2.setBounds(10, 184, 73, 14);
		panel_2.add(lblNewLabel_11_2);
		
		JLabel lblNewLabel_11_1_1 = new JLabel("Gecikme Faizi");
		lblNewLabel_11_1_1.setBounds(10, 220, 89, 14);
		panel_2.add(lblNewLabel_11_1_1);
		
		JLabel lblNewLabel_14_1 = new JLabel("Kredi Kac Ay");
		lblNewLabel_14_1.setBounds(10, 250, 73, 14);
		panel_2.add(lblNewLabel_14_1);
		
		JLabel lblKrediFaiziDonut = new JLabel(""+banka.bankaHesabi.getKrediFaizi());
		lblKrediFaiziDonut.setBounds(97, 184, 67, 14);
		panel_2.add(lblKrediFaiziDonut);
		
		JLabel lblGecikmeFaiziDonut = new JLabel(""+banka.bankaHesabi.getGecikmeFaizi());
		lblGecikmeFaiziDonut.setBounds(97, 220, 67, 14);
		panel_2.add(lblGecikmeFaiziDonut);
		
		JLabel lblKacAyDonut = new JLabel(""+banka.bankaHesabi.getKacAy());
		lblKacAyDonut.setBounds(97, 250, 67, 14);
		panel_2.add(lblKacAyDonut);
		
		JLabel lblNewLabel_17 = new JLabel("TL");
		lblNewLabel_17.setBounds(156, 148, 21, 14);
		panel_2.add(lblNewLabel_17);
		
		JLabel lblNewLabel_10 = new JLabel("Maas Belirle");
		lblNewLabel_10.setBounds(449, 235, 73, 14);
		bankaBilgileri.add(lblNewLabel_10);
		
		JButton btnKrediFaizi = new JButton("Gonder");
		btnKrediFaizi.setBounds(675, 325, 89, 23);
		bankaBilgileri.add(btnKrediFaizi);
		
		textKrediFaizi = new JTextField();
		textKrediFaizi.setBounds(554, 326, 86, 20);
		bankaBilgileri.add(textKrediFaizi);
		textKrediFaizi.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Kredi Faizi");
		lblNewLabel_11.setBounds(449, 329, 73, 14);
		bankaBilgileri.add(lblNewLabel_11);
		
		textGecikmeFaizi = new JTextField();
		textGecikmeFaizi.setBounds(554, 363, 86, 20);
		textGecikmeFaizi.setColumns(10);
		bankaBilgileri.add(textGecikmeFaizi);
		
		JButton btnGecikmeFaizi = new JButton("Gonder");
		btnGecikmeFaizi.setBounds(675, 360, 89, 23);
		bankaBilgileri.add(btnGecikmeFaizi);
		
		JLabel lblNewLabel_11_1 = new JLabel("Gecikme Faizi");
		lblNewLabel_11_1.setBounds(449, 369, 89, 14);
		bankaBilgileri.add(lblNewLabel_11_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(433, 47, 401, 104);
		panel_3.setBackground(new Color(224, 255, 255));
		bankaBilgileri.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_12 = new JLabel("Para Birimi");
		lblNewLabel_12.setBounds(10, 43, 79, 14);
		panel_3.add(lblNewLabel_12);
		
		textParaBirimi = new JTextField();
		textParaBirimi.setBounds(93, 18, 86, 20);
		panel_3.add(textParaBirimi);
		textParaBirimi.setColumns(10);
		
		JButton btnParaBirimi = new JButton("Ekle");
		btnParaBirimi.setBounds(302, 17, 89, 23);
		panel_3.add(btnParaBirimi);
		
		JComboBox comboBoxParaBirimleri = new JComboBox();
		comboBoxParaBirimleri.setModel(new DefaultComboBoxModel(banka.paraBirimleri));
		comboBoxParaBirimleri.setBounds(93, 57, 86, 22);
		panel_3.add(comboBoxParaBirimleri);
		
		JLabel lblNewLabel_13 = new JLabel("Kur");
		lblNewLabel_13.setBounds(206, 43, 46, 14);
		panel_3.add(lblNewLabel_13);
		
		textKurGuncelle = new JTextField();
		textKurGuncelle.setBounds(206, 58, 86, 20);
		panel_3.add(textKurGuncelle);
		textKurGuncelle.setColumns(10);
		
		JButton btnKurGuncelle = new JButton("Guncelle");
		
		btnKurGuncelle.setBounds(302, 57, 89, 23);
		panel_3.add(btnKurGuncelle);
		
		textYeniPbKur = new JTextField();
		textYeniPbKur.setColumns(10);
		textYeniPbKur.setBounds(206, 18, 86, 20);
		panel_3.add(textYeniPbKur);
		
		JLabel lblNewLabel_16 = new JLabel("kur");
		lblNewLabel_16.setBounds(206, 0, 46, 14);
		panel_3.add(lblNewLabel_16);
		
		JButton btnGirisEkraninaDon2 = new JButton("< Giris Ekranina Don");
		btnGirisEkraninaDon2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				form1 frame2=new form1();
				frame2.giris();
				frame2.setVisible(true);
			}
		});
		btnGirisEkraninaDon2.setBounds(10, 365, 173, 23);
		btnGirisEkraninaDon2.setHorizontalAlignment(SwingConstants.LEFT);
		bankaBilgileri.add(btnGirisEkraninaDon2);
		
		JButton birAyIleri = new JButton("1 Ay ileri al");
		birAyIleri.setBounds(251, 151, 124, 23);
		bankaBilgileri.add(birAyIleri);
		
		textMaasBelirle = new JTextField();
		textMaasBelirle.setBounds(554, 232, 86, 20);
		bankaBilgileri.add(textMaasBelirle);
		textMaasBelirle.setColumns(10);
		
		JButton btnMaasBelirle = new JButton("Gonder");
		btnMaasBelirle.setBounds(675, 231, 89, 23);
		bankaBilgileri.add(btnMaasBelirle);
		
		JLabel lblNewLabel_14 = new JLabel("Kredi Kac Ay");
		lblNewLabel_14.setBounds(449, 282, 73, 14);
		bankaBilgileri.add(lblNewLabel_14);
		
		textKacAy = new JTextField();
		textKacAy.setColumns(10);
		textKacAy.setBounds(554, 279, 86, 20);
		bankaBilgileri.add(textKacAy);
		
		JButton btnKacAyGonder = new JButton("Gonder");
		btnKacAyGonder.setBounds(675, 278, 89, 23);
		bankaBilgileri.add(btnKacAyGonder);
		
		
		JLabel lblNewLabel_18 = new JLabel("kac ay ileride:");
		lblNewLabel_18.setBounds(254, 128, 82, 14);
		bankaBilgileri.add(lblNewLabel_18);
		
		JLabel lblKacAyIleride = new JLabel(""+banka.bankaHesabi.getKacAyIleride());
		lblKacAyIleride.setBounds(348, 128, 27, 14);
		bankaBilgileri.add(lblKacAyIleride);
		//panel.add(table);
		
		JPanel islemOzeti = new JPanel();
		islemOzeti.setBackground(Color.ORANGE);
		tabbedPane.addTab("Islem Ozeti", null, islemOzeti, null);
		islemOzeti.setLayout(null);
		
		JLabel lblXADet = new JLabel("Son X Adet");
		lblXADet.setBounds(274, 34, 90, 14);
		islemOzeti.add(lblXADet);
		
		textXAdetGir = new JTextField();
		textXAdetGir.setBounds(402, 31, 79, 20);
		islemOzeti.add(textXAdetGir);
		textXAdetGir.setColumns(10);
		
		JButton btnXAdetGoster = new JButton("Goster");
		btnXAdetGoster.setBounds(508, 30, 89, 23);
		islemOzeti.add(btnXAdetGoster);
		
		JButton btnGirisEkranindaDon3 = new JButton("< Giris Ekranina Don");
		btnGirisEkranindaDon3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				form1 frame2=new form1();
				frame2.giris();
				frame2.setVisible(true);
			}
		});
		btnGirisEkranindaDon3.setHorizontalAlignment(SwingConstants.LEFT);
		btnGirisEkranindaDon3.setBounds(10, 358, 173, 23);
		islemOzeti.add(btnGirisEkranindaDon3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(113, 89, 730, 260);
		islemOzeti.add(scrollPane);
		
		table = new JTable();
		table.setBounds(113, 89, 730, 260);
		
		scrollPane.setViewportView(table);
		
		JPanel musteriEkle = new JPanel();
		musteriEkle.setBackground(new Color(255, 228, 225));
		tabbedPane.addTab("Musteri Ekle", null, musteriEkle, null);
		musteriEkle.setLayout(null);
		
		JButton btnMusteriEkle = new JButton("Ekle");
		btnMusteriEkle.setBounds(575, 358, 89, 23);
		musteriEkle.add(btnMusteriEkle);
		
		JLabel lblNewLabel = new JLabel("Ad-Soyad");
		lblNewLabel.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel.setBounds(197, 11, 63, 14);
		musteriEkle.add(lblNewLabel);
		
		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setBounds(197, 53, 77, 14);
		musteriEkle.add(lblTelefon);
		
		JLabel lblNewLabel_2 = new JLabel("Adres");
		lblNewLabel_2.setBounds(197, 106, 77, 14);
		musteriEkle.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("e-posta");
		lblNewLabel_3.setBounds(197, 152, 77, 14);
		musteriEkle.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("TC No");
		lblNewLabel_4.setBounds(197, 198, 63, 14);
		musteriEkle.add(lblNewLabel_4);
		
		textAdSoyad = new JTextField();
		textAdSoyad.setBounds(348, 8, 141, 20);
		musteriEkle.add(textAdSoyad);
		textAdSoyad.setColumns(10);
		
		textTelefon = new JTextField();
		textTelefon.setBounds(348, 50, 141, 20);
		musteriEkle.add(textTelefon);
		textTelefon.setColumns(10);
		
		textAdres = new JTextField();
		textAdres.setBounds(348, 103, 141, 20);
		musteriEkle.add(textAdres);
		textAdres.setColumns(10);
		
		textE_posta = new JTextField();
		textE_posta.setBounds(348, 149, 141, 20);
		musteriEkle.add(textE_posta);
		textE_posta.setColumns(10);
		
		textTCNO = new JTextField();
		textTCNO.setBounds(348, 195, 141, 20);
		musteriEkle.add(textTCNO);
		textTCNO.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel(":");
		lblNewLabel_1.setBounds(300, 11, 19, 14);
		musteriEkle.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel(":");
		lblNewLabel_1_1.setBounds(300, 53, 19, 14);
		musteriEkle.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel(":");
		lblNewLabel_1_1_1.setBounds(300, 106, 19, 14);
		musteriEkle.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel(":");
		lblNewLabel_1_1_1_1.setBounds(300, 152, 19, 14);
		musteriEkle.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel(":");
		lblNewLabel_1_1_1_2.setBounds(300, 198, 19, 14);
		musteriEkle.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_15 = new JLabel("Sifre");
		lblNewLabel_15.setBounds(197, 297, 46, 14);
		musteriEkle.add(lblNewLabel_15);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel(":");
		lblNewLabel_1_1_1_2_1.setBounds(300, 297, 19, 14);
		musteriEkle.add(lblNewLabel_1_1_1_2_1);
		
		JButton btnNewButton_3_1 = new JButton("< Giris Ekranina Don");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				form1 frame=new form1();
				frame.giris();
				frame.setVisible(true);
			}
		});
		btnNewButton_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_3_1.setBounds(10, 358, 173, 23);
		musteriEkle.add(btnNewButton_3_1);
		
		JLabel lblNewLabel_15_1 = new JLabel("Kullanici Adi");
		lblNewLabel_15_1.setBounds(197, 251, 77, 14);
		musteriEkle.add(lblNewLabel_15_1);
		
		JLabel lblNewLabel_1_1_1_2_1_1 = new JLabel(":");
		lblNewLabel_1_1_1_2_1_1.setBounds(300, 251, 19, 14);
		musteriEkle.add(lblNewLabel_1_1_1_2_1_1);
		
		textKullaniciAdi = new JTextField();
		textKullaniciAdi.setColumns(10);
		textKullaniciAdi.setBounds(348, 248, 141, 20);
		musteriEkle.add(textKullaniciAdi);
		
		textSifre = new JTextField();
		textSifre.setColumns(10);
		textSifre.setBounds(348, 294, 141, 20);
		musteriEkle.add(textSifre);
		
		btnXAdetGoster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x=Integer.parseInt(textXAdetGir.getText());
				Object [][]colonBilgileri=sorgu.islemOzetiDon(0, 0, x);
				table.setModel(new DefaultTableModel(
						colonBilgileri,
						new String[] {
								"islem no", "hesap 1", "hesap 2", "tutar", "icerik", "Kaynak Bakiye", "Hedef Bakiye", "tarih"
						}
					));
			}
		});
		btnMusteriEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textAdres.getText().isEmpty() || textTelefon.getText().isEmpty() || 
						   textE_posta.getText().isEmpty()||textSifre.getText().isEmpty() ||
						   textKullaniciAdi.getText().isEmpty() || textTCNO.getText().isEmpty()||
						   textAdSoyad.getText().isEmpty()
						) {
							JOptionPane.showMessageDialog(null,"Alanlar Bos Birakilamaz","",JOptionPane.INFORMATION_MESSAGE);
				}
		    	else {
		    		Musteri tmpMusteri=new Musteri();
		    		tmpMusteri.setTelefon(textTelefon.getText());
		    		tmpMusteri.setAdres(textAdres.getText());
		    		tmpMusteri.setAdSoyad(textAdSoyad.getText());
		    		tmpMusteri.setE_posta(textE_posta.getText());
		    		tmpMusteri.setKullaniciAdi(textKullaniciAdi.getText());
		    		tmpMusteri.setTCNO(textTCNO.getText());
		    		tmpMusteri.setSifre(textSifre.getText());
					if(sorgu.musteriEkle(tmpMusteri,0)) {//temsilciId 0 
						JOptionPane.showMessageDialog(null,"Musteri Eklendi","",JOptionPane.INFORMATION_MESSAGE);
					}		
				}
			}
		});
		btnMaasBelirle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textMaasBelirle.getText().isEmpty()) {
					float maas=Float.parseFloat(textMaasBelirle.getText());
					if(maas<=0) {
						JOptionPane.showMessageDialog(null,"Gecersiz Deger","",JOptionPane.INFORMATION_MESSAGE);
					}else {
						sorgu.maasGuncelle(maas);
						JOptionPane.showMessageDialog(null,"Maas Guncellendi","",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnParaBirimi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textParaBirimi.getText().isEmpty() && !textYeniPbKur.getText().isEmpty() ) {
					sorgu.yeniPbEkle(textParaBirimi.getText(),Float.parseFloat(textYeniPbKur.getText()));
					JOptionPane.showMessageDialog(null,"Para birimi eklendi","",JOptionPane.INFORMATION_MESSAGE);
					banka.paraBirimleri[banka.paraBirimSayisi++]=textParaBirimi.getText();
					comboBoxParaBirimleri.removeAllItems();
					for(int i=0;i<banka.paraBirimSayisi;i++) {
						comboBoxParaBirimleri.addItem(banka.paraBirimleri[i]);
					}
				}else {
					JOptionPane.showMessageDialog(null,"para birimi ve kur alani bos birakilamaz","",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnKurGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textKurGuncelle.getText().isEmpty() ) {
					String pb=String.valueOf(comboBoxParaBirimleri.getSelectedItem());
					float kur=Float.parseFloat(textKurGuncelle.getText());
					sorgu.kurGuncelle(pb, kur);
					JOptionPane.showMessageDialog(null,"Kur guncellendi","",JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null,"kur alani bos birakilamaz","",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnKrediFaizi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textKrediFaizi.getText().isEmpty()) {
					float deger=Float.parseFloat(textKrediFaizi.getText());
					sorgu.krediFaiziGuncelle(deger);
					banka.bankaHesabi.setKrediFaizi(deger);
					lblKrediFaiziDonut.setText(String.valueOf(deger));
					JOptionPane.showMessageDialog(null,"Guncelleme Basarili","",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnGecikmeFaizi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textGecikmeFaizi.getText().isEmpty()) {
					float deger=Float.parseFloat(textGecikmeFaizi.getText());
					sorgu.gecikmeFaiziGuncelle(deger);
					banka.bankaHesabi.setGecikmeFaizi(deger);
					lblGecikmeFaiziDonut.setText(String.valueOf(deger));
					JOptionPane.showMessageDialog(null,"Guncelleme Basarili","",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnKacAyGonder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textKacAy.getText().isEmpty()) {
					int deger=Integer.parseInt(textKacAy.getText());
					sorgu.kacAyGuncelle(deger);
					banka.bankaHesabi.setKacAy(deger);
					lblKacAyDonut.setText(String.valueOf(deger));
					JOptionPane.showMessageDialog(null,"Guncelleme Basarili","",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		birAyIleri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Calendar c = Calendar.getInstance();
				
				String bankaTarihi=banka.bankaHesabi.getTarih();
				String[] arr1=bankaTarihi.split("/");
				int gun1=Integer.parseInt(arr1[0]);
				int ay1=Integer.parseInt(arr1[1]);
				int yil1=Integer.parseInt(arr1[2]);
				c.set(Calendar.DAY_OF_MONTH,gun1);
				c.set(Calendar.MONTH, ay1-1);//burda 1 fazlasini yaziyor.
				c.set(Calendar.YEAR,yil1);

				c.add(Calendar.DATE,31); 
				banka.bankaHesabi.setTarih(sdf.format(c.getTime()));
				//banka.bankaHesabi.setTarih() bu kismi ayarlican
				int x=banka.bankaHesabi.getKacAyIleride()+1;
				banka.bankaHesabi.setKacAyIleride(x);
				lblKacAyIleride.setText(""+x);
				sorgu.bankaBilgileriGuncelle(banka);
			}
		});
		
	}
}

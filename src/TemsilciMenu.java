import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class TemsilciMenu extends JFrame {

	private JPanel contentPane;
	private JTextField textTelefon;
	private JTextField textAdres;
	private JTextField textE_posta;
	private JTable table;
	private Sorgular sorgu=new Sorgular();
	private Temsilci temsilci; 
	private Musteri musteri;
	private Hesap hesap;
	private JTextField textKullaniciAdi;
	private JTextField textSifre;
	private JTextField textAdSoyad;
	private JTextField textTelefonEkleme;
	private JTextField textAdresEkleme;
	private JTextField textE_PostaEkleme;
	private JTextField textTCNO;
	private String hesapAcmapb;
	public TemsilciMenu(Temsilci temsilci) {
		this.temsilci=temsilci;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,850, 469);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11,940, 419);
		contentPane.add(tabbedPane);
		
		JPanel Giris = new JPanel();
		Giris.setBackground(Color.YELLOW);
		tabbedPane.addTab("Giris", null, Giris, null);
		Giris.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Merhaba ,");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_10.setBounds(203, 42, 161, 96);
		Giris.add(lblNewLabel_10);
		
		JLabel lblGirisDonut = new JLabel(temsilci.getAdSoyad());
		lblGirisDonut.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblGirisDonut.setBounds(380, 42, 343, 96);
		Giris.add(lblGirisDonut);
		
		JButton btnGirisEkraninaDon_1 = new JButton("Giris Ekranina Don");
		btnGirisEkraninaDon_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				form1 frame2=new form1();
				frame2.giris();
				frame2.setVisible(true);
			}
		});
		btnGirisEkraninaDon_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnGirisEkraninaDon_1.setBounds(22, 357, 156, 23);
		Giris.add(btnGirisEkraninaDon_1);
		
		JLabel lblKullaniciAdi = new JLabel("Kullanici Adi :");
		lblKullaniciAdi.setBounds(77, 165, 86, 14);
		Giris.add(lblKullaniciAdi);
		
		JLabel lblMaas = new JLabel("Maas");
		lblMaas.setBounds(77, 213, 46, 14);
		Giris.add(lblMaas);
		
		JLabel lblKullaniciAdiDonut = new JLabel(temsilci.getKullaniciAdi());
		lblKullaniciAdiDonut.setBounds(204, 165, 95, 14);
		Giris.add(lblKullaniciAdiDonut);
		
		JLabel lblMaasDonut = new JLabel(""+temsilci.getMaas());
		lblMaasDonut.setBounds(203, 213, 95, 14);
		Giris.add(lblMaasDonut);
		JPanel MusteriBilgileri = new JPanel();
		MusteriBilgileri.setBackground(Color.YELLOW);
		tabbedPane.addTab("Musteri Bilgileri", null, MusteriBilgileri, null);
		MusteriBilgileri.setLayout(null);
		
		JComboBox comboBoxMusteriSec = new JComboBox();
		comboBoxMusteriSec.setModel(new DefaultComboBoxModel(musterileriDon()));
		comboBoxMusteriSec.setBounds(40, 34, 124, 22);
		MusteriBilgileri.add(comboBoxMusteriSec);
		
		JButton btnMusteriSec = new JButton("Musteri Sec");
		btnMusteriSec.setBounds(181, 34, 102, 23);
		MusteriBilgileri.add(btnMusteriSec);
		
		JLabel lblAdSoyad = new JLabel("Ad-Soyad");
		lblAdSoyad.setBounds(40, 97, 74, 14);
		MusteriBilgileri.add(lblAdSoyad);
		
		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setBounds(40, 136, 63, 14);
		MusteriBilgileri.add(lblTelefon);
		
		JLabel lblAdres = new JLabel("Adres");
		lblAdres.setBounds(40, 177, 46, 14);
		MusteriBilgileri.add(lblAdres);
		
		JLabel lblE_posta = new JLabel("e-posta");
		lblE_posta.setBounds(40, 223, 63, 14);
		MusteriBilgileri.add(lblE_posta);
		
		JLabel lblTCNo = new JLabel("TC NO");
		lblTCNo.setBounds(40, 275, 63, 14);
		MusteriBilgileri.add(lblTCNo);
		
		JLabel lblAdSoyadDonut = new JLabel("");
		lblAdSoyadDonut.setBounds(124, 97, 238, 14);
		MusteriBilgileri.add(lblAdSoyadDonut);
		
		JLabel lblTelefonDonut = new JLabel("");
		lblTelefonDonut.setBounds(124, 136, 238, 14);
		MusteriBilgileri.add(lblTelefonDonut);
		
		JLabel lblAdresDonut = new JLabel("");
		lblAdresDonut.setBounds(124, 177, 238, 14);
		MusteriBilgileri.add(lblAdresDonut);
		
		JLabel lblE_postaDonut = new JLabel("");
		lblE_postaDonut.setBounds(124, 223, 238, 14);
		MusteriBilgileri.add(lblE_postaDonut);
		
		JLabel lblTCNoDonut = new JLabel("");
		lblTCNoDonut.setBounds(124, 275, 238, 14);
		MusteriBilgileri.add(lblTCNoDonut);
		
		textTelefon = new JTextField();
		textTelefon.setBounds(393, 133, 252, 20);
		MusteriBilgileri.add(textTelefon);
		textTelefon.setColumns(10);
		
		textAdres = new JTextField();
		textAdres.setColumns(10);
		textAdres.setBounds(393, 174, 252, 20);
		MusteriBilgileri.add(textAdres);
		
		textE_posta = new JTextField();
		textE_posta.setColumns(10);
		textE_posta.setBounds(393, 220, 252, 20);
		MusteriBilgileri.add(textE_posta);
		
		JButton btnTelefonGuncelle = new JButton("Guncelle");
		btnTelefonGuncelle.setBounds(682, 132, 89, 23);
		MusteriBilgileri.add(btnTelefonGuncelle);
		
		JButton btnAdresGuncelle = new JButton("Guncelle");
		btnAdresGuncelle.setBounds(682, 173, 89, 23);
		MusteriBilgileri.add(btnAdresGuncelle);
		
		JButton btnE_postaGuncelle = new JButton("Guncelle");
		btnE_postaGuncelle.setBounds(682, 219, 89, 23);
		MusteriBilgileri.add(btnE_postaGuncelle);
		
		JButton btnMusteriSil = new JButton("Musteri Sil");
		btnMusteriSil.setBounds(668, 317, 119, 23);
		MusteriBilgileri.add(btnMusteriSil);
		
		JButton btnHesapAcmaOnay = new JButton("Onayla");
		btnHesapAcmaOnay.setEnabled(false);
		btnHesapAcmaOnay.setBounds(540, 11, 89, 23);
		MusteriBilgileri.add(btnHesapAcmaOnay);
		
		JLabel lblNewLabel_6 = new JLabel("Hesap Acma Istegi");
		lblNewLabel_6.setBounds(393, 15, 137, 14);
		MusteriBilgileri.add(lblNewLabel_6);
		JButton btnHesapAcmaIptal = new JButton("Iptal");
		btnHesapAcmaIptal.setEnabled(false);
		btnHesapAcmaIptal.setBounds(635, 11, 89, 23);
		MusteriBilgileri.add(btnHesapAcmaIptal);
		
		JButton btnGirisEkraninaDon = new JButton("Giris Ekranina Don");
		btnGirisEkraninaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				form1 frame2=new form1();
				frame2.giris();
				frame2.setVisible(true);
			}
		});
		btnGirisEkraninaDon.setHorizontalAlignment(SwingConstants.LEADING);
		btnGirisEkraninaDon.setBounds(10, 357, 156, 23);
		MusteriBilgileri.add(btnGirisEkraninaDon);
		
		
		JPanel MusteriHesapBilgileri = new JPanel();
		MusteriHesapBilgileri.setBackground(Color.YELLOW);
		tabbedPane.addTab("Musteri Hesap Bilgileri", null, MusteriHesapBilgileri, null);
		MusteriHesapBilgileri.setLayout(null);
		
		JComboBox comboBoxHesapSec = new JComboBox();
		comboBoxHesapSec.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBoxHesapSec.setBounds(37, 27, 112, 22);
		MusteriHesapBilgileri.add(comboBoxHesapSec);
		
		JButton btnHesapSec = new JButton("Hesap Sec");
		btnHesapSec.setBounds(181, 27, 112, 23);
		MusteriHesapBilgileri.add(btnHesapSec);
		
		JLabel lblNewLabel_8 = new JLabel("Toplam Bakiye");
		lblNewLabel_8.setBounds(37, 100, 99, 14);
		MusteriHesapBilgileri.add(lblNewLabel_8);
		
		JLabel lblNewLabel_8_1 = new JLabel("Gelir");
		lblNewLabel_8_1.setBounds(37, 140, 99, 14);
		MusteriHesapBilgileri.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_8_1_1 = new JLabel("Gider");
		lblNewLabel_8_1_1.setBounds(37, 181, 99, 14);
		MusteriHesapBilgileri.add(lblNewLabel_8_1_1);
		
		JLabel lblNewLabel_9 = new JLabel("Kredi Borcu");
		lblNewLabel_9.setBounds(37, 223, 99, 14);
		MusteriHesapBilgileri.add(lblNewLabel_9);
		
		JLabel lblToplamBakiye = new JLabel("-");
		lblToplamBakiye.setBounds(181, 100, 46, 14);
		MusteriHesapBilgileri.add(lblToplamBakiye);
		
		JLabel lblgelir = new JLabel("-");
		lblgelir.setBounds(181, 140, 46, 14);
		MusteriHesapBilgileri.add(lblgelir);
		
		JLabel lblGider = new JLabel("-");
		lblGider.setBounds(181, 181, 46, 14);
		MusteriHesapBilgileri.add(lblGider);
		
		JLabel lblKrediBorcu = new JLabel("-");
		lblKrediBorcu.setBounds(181, 223, 46, 14);
		MusteriHesapBilgileri.add(lblKrediBorcu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(290, 99, 527, 280);
		MusteriHesapBilgileri.add(scrollPane);
		
		JLabel lblNewLabel_11 = new JLabel("Aylik Ozet");
		lblNewLabel_11.setBounds(514, 74, 105, 14);
		MusteriHesapBilgileri.add(lblNewLabel_11);
		
		table = new JTable();
		table.setBounds(566, 63, 105, 14);
		scrollPane.setViewportView(table);
		
		JButton btnGirisEkraninaDon2 = new JButton("Giris Ekranina Don");
		btnGirisEkraninaDon2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				form1 frame2=new form1();
				frame2.giris();
				frame2.setVisible(true);
			}
		});
		btnGirisEkraninaDon2.setHorizontalAlignment(SwingConstants.LEADING);
		btnGirisEkraninaDon2.setBounds(10, 357, 156, 23);
		MusteriHesapBilgileri.add(btnGirisEkraninaDon2);
		
		JLabel lblNewLabel_7 = new JLabel("Hesap Silme Istegi");
		lblNewLabel_7.setBounds(320, 11, 137, 14);
		MusteriHesapBilgileri.add(lblNewLabel_7);
		
		JButton btnHesapSilmeOnay = new JButton("Onayla");
		btnHesapSilmeOnay.setEnabled(false);
		btnHesapSilmeOnay.setBounds(458, 7, 89, 23);
		MusteriHesapBilgileri.add(btnHesapSilmeOnay);
		
		JButton btnHesapSilmeIptal = new JButton("Iptal");
		btnHesapSilmeIptal.setEnabled(false);
		btnHesapSilmeIptal.setBounds(560, 7, 89, 23);
		MusteriHesapBilgileri.add(btnHesapSilmeIptal);
		
		JLabel lblParaBirimiDonut = new JLabel("-");
		lblParaBirimiDonut.setBounds(217, 100, 46, 14);
		MusteriHesapBilgileri.add(lblParaBirimiDonut);
		
		JLabel lblNewLabel_7_1 = new JLabel("Kredi Istegi");
		lblNewLabel_7_1.setBounds(320, 44, 137, 14);
		MusteriHesapBilgileri.add(lblNewLabel_7_1);
		
		JButton btnKrediIstegiOnay = new JButton("Onayla");
		btnKrediIstegiOnay.setEnabled(false);
		btnKrediIstegiOnay.setBounds(458, 40, 89, 23);
		MusteriHesapBilgileri.add(btnKrediIstegiOnay);
		
		JButton btnKrediIstegiIptal = new JButton("Iptal");
		btnKrediIstegiIptal.setEnabled(false);
		btnKrediIstegiIptal.setBounds(560, 41, 89, 23);
		MusteriHesapBilgileri.add(btnKrediIstegiIptal);
		
		JPanel MusteriEkleme = new JPanel();
		MusteriEkleme.setBackground(Color.YELLOW);
		tabbedPane.addTab("Yeni Musteri Ekle", null, MusteriEkleme, null);
		MusteriEkleme.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kullanici Adi");
		lblNewLabel.setBounds(187, 46, 124, 14);
		MusteriEkleme.add(lblNewLabel);
		
		textKullaniciAdi = new JTextField();
		textKullaniciAdi.setBounds(389, 43, 161, 20);
		MusteriEkleme.add(textKullaniciAdi);
		textKullaniciAdi.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Sifre");
		lblNewLabel_1.setBounds(187, 83, 124, 14);
		MusteriEkleme.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ad Soyad");
		lblNewLabel_2.setBounds(187, 122, 124, 14);
		MusteriEkleme.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telefon");
		lblNewLabel_3.setBounds(187, 160, 124, 14);
		MusteriEkleme.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Adres");
		lblNewLabel_4.setBounds(187, 199, 124, 14);
		MusteriEkleme.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("e_posta");
		lblNewLabel_5.setBounds(187, 238, 124, 14);
		MusteriEkleme.add(lblNewLabel_5);
		
		JLabel lblTc = new JLabel("TC NO");
		lblTc.setBounds(187, 283, 124, 14);
		MusteriEkleme.add(lblTc);
		
		textSifre = new JTextField();
		textSifre.setColumns(10);
		textSifre.setBounds(389, 80, 161, 20);
		MusteriEkleme.add(textSifre);
		
		textAdSoyad = new JTextField();
		textAdSoyad.setColumns(10);
		textAdSoyad.setBounds(389, 119, 161, 20);
		MusteriEkleme.add(textAdSoyad);
		
		textTelefonEkleme = new JTextField();
		textTelefonEkleme.setColumns(10);
		textTelefonEkleme.setBounds(389, 157, 161, 20);
		MusteriEkleme.add(textTelefonEkleme);
		
		textAdresEkleme = new JTextField();
		textAdresEkleme.setColumns(10);
		textAdresEkleme.setBounds(389, 196, 161, 20);
		MusteriEkleme.add(textAdresEkleme);
		
		textE_PostaEkleme = new JTextField();
		textE_PostaEkleme.setColumns(10);
		textE_PostaEkleme.setBounds(389, 235, 161, 20);
		MusteriEkleme.add(textE_PostaEkleme);
		
		textTCNO = new JTextField();
		textTCNO.setColumns(10);
		textTCNO.setBounds(389, 280, 161, 20);
		MusteriEkleme.add(textTCNO);
		
		JButton btnGirisEkraninaDon2_1 = new JButton("Giris Ekranina Don");
		btnGirisEkraninaDon2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				form1 frame2=new form1();
				frame2.giris();
				frame2.setVisible(true);
			}
		});
		btnGirisEkraninaDon2_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnGirisEkraninaDon2_1.setBounds(26, 357, 156, 23);
		MusteriEkleme.add(btnGirisEkraninaDon2_1);
		
		JButton btnMusteriEkle = new JButton("Ekle");
		btnMusteriEkle.setBounds(557, 330, 89, 23);
		MusteriEkleme.add(btnMusteriEkle);
		
		btnMusteriSec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(temsilci.musteriler!=null) {
					String secim=String.valueOf(comboBoxMusteriSec.getSelectedItem());
					for(int i=0;i<temsilci.musteriler.size();i++) {
						String kontrol=temsilci.musteriler.get(i).getId()+"-"+temsilci.musteriler.get(i).getAdSoyad();
						if(kontrol.compareTo(secim)==0) {
							musteri=temsilci.musteriler.get(i);
							musteriHesaplariDon();
							comboBoxHesapSec.removeAllItems();
							if(musteri.hesaplar!=null) {
								for(int x=0;x<musteri.hesaplar.size();x++) {
									Hesap tmp=musteri.hesaplar.get(x);
									comboBoxHesapSec.addItem(String.valueOf(tmp.getId()+"-"+musteri.getAdSoyad()));
								}
								break;
							}
						}
					}
					hesapAcmapb=sorgu.hesapAcmaIstegiVarmi(musteri.getId());
					if(!hesapAcmapb.isEmpty()) {
						JOptionPane.showMessageDialog(null,"Musteriniz Hesap Acma isteginde bulundu","",JOptionPane.INFORMATION_MESSAGE);
						btnHesapAcmaOnay.setEnabled(true);
						btnHesapAcmaIptal.setEnabled(true);
					}
					lblAdresDonut.setText(musteri.getAdres());
					lblAdSoyadDonut.setText(musteri.getAdSoyad());
					lblE_postaDonut.setText(musteri.getE_posta());
					lblTelefonDonut.setText(musteri.getTelefon());
					lblTCNoDonut.setText(musteri.getTCNO());
					Object[][] colonBilgileri=sorgu.islemOzetiDon(0,musteri.getId(),0);
					table.setModel(new DefaultTableModel(
							colonBilgileri,
							new String[] {
									"islem no", "hesap 1", "hesap 2", "tutar", "icerik", "Kaynak Bakiye", "Hedef Bakiye", "tarih"
							}
					));
					lblToplamBakiye.setText("-");
					lblgelir.setText("-");
					lblGider.setText("-");
					lblKrediBorcu.setText("-");
					lblParaBirimiDonut.setText("-");
					
				}else {
					JOptionPane.showMessageDialog(null,"Musteri Yok","",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnTelefonGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(musteri==null) {
					JOptionPane.showMessageDialog(null,"Musteri Seciniz","",JOptionPane.INFORMATION_MESSAGE);
				}else {
					if(!textTelefon.getText().isEmpty()) {
						if(sorgu.kisiselBilgiGuncelle("telefon",textTelefon.getText(),musteri.getTCNO())) {
							musteri.setTelefon(textTelefon.getText());
							lblTelefonDonut.setText(musteri.getTelefon());
							JOptionPane.showMessageDialog(null,"Guncelleme Basarili","",JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null,"Guncelleme Basarisiz","",JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			}
		});
		btnAdresGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(musteri==null) {
					JOptionPane.showMessageDialog(null,"Musteri Seciniz","",JOptionPane.INFORMATION_MESSAGE);
				}else {
					if(!textAdres.getText().isEmpty()) {
						if(sorgu.kisiselBilgiGuncelle("adres",textAdres.getText(),musteri.getTCNO())) {
							musteri.setAdres(textAdres.getText());
							lblAdresDonut.setText(musteri.getAdres());
							JOptionPane.showMessageDialog(null,"Guncelleme Basarili","",JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null,"Guncelleme Basarisiz","",JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			}
		});
		btnE_postaGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(musteri==null) {
					JOptionPane.showMessageDialog(null,"Musteri Seciniz","",JOptionPane.INFORMATION_MESSAGE);
				}else {
					if(!textE_posta.getText().isEmpty()) {
						if(sorgu.kisiselBilgiGuncelle("e_posta",textE_posta.getText(),musteri.getTCNO())) {
							musteri.setE_posta(textE_posta.getText());
							lblE_postaDonut.setText(musteri.getE_posta());
							JOptionPane.showMessageDialog(null,"Guncelleme Basarili","",JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null,"Guncelleme Basarisiz","",JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			}
		});
		btnMusteriSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(musteri==null) {
					JOptionPane.showMessageDialog(null,"Musteri Seciniz","",JOptionPane.INFORMATION_MESSAGE);
				}else {
					sorgu.musteriSil(musteri.getId());
					lblAdresDonut.setText("-");
					lblAdSoyadDonut.setText("-");
					lblE_postaDonut.setText("-");
					lblTelefonDonut.setText("-");
					lblTCNoDonut.setText("-");
					
					lblToplamBakiye.setText("-");
					lblgelir.setText("-");
					lblGider.setText("-");
					lblKrediBorcu.setText("-");
					lblParaBirimiDonut.setText("-");
					
					musterileriDon();
					comboBoxMusteriSec.removeAllItems();
					if(temsilci.musteriler!=null) {
						for(int i=0;i<temsilci.musteriler.size();i++){
							comboBoxMusteriSec.addItem(temsilci.musteriler.get(i).getId()+"-"+temsilci.musteriler.get(i).getAdSoyad());
						}
					}
					musteri=null;
				}
			}
		});
		btnHesapSec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(musteri==null) {
					JOptionPane.showMessageDialog(null,"Musteri Seciniz","",JOptionPane.INFORMATION_MESSAGE);
				}else {
					if(musteri.hesaplar!=null) {
					    hesap=musteri.hesaplar.get(comboBoxHesapSec.getSelectedIndex());
						lblToplamBakiye.setText(""+hesap.getBakiye());
						lblgelir.setText(""+hesap.getGelir());
						lblGider.setText(""+hesap.getGider());
						lblKrediBorcu.setText(""+hesap.getToplamKrediBorcu());
						lblParaBirimiDonut.setText(hesap.getParaBirimi());
						if(sorgu.hesapSilmeIstegiVarmi(hesap.getId())) {
							JOptionPane.showMessageDialog(null,"bu hesabin silinemesi isteniyor","",JOptionPane.INFORMATION_MESSAGE);
							btnHesapSilmeOnay.setEnabled(true);
							btnHesapSilmeIptal.setEnabled(true);
						}
						if(sorgu.krediIstegiVarmi(hesap.getId())) {
							JOptionPane.showMessageDialog(null,"Kredi isteniyor","",JOptionPane.INFORMATION_MESSAGE);
							btnKrediIstegiOnay.setEnabled(true);
							btnKrediIstegiIptal.setEnabled(true);
						}
						Object[][] colonBilgileri=sorgu.islemOzetiDon(hesap.getId(),musteri.getId(),0);
						table.setModel(new DefaultTableModel(
								colonBilgileri,
								new String[] {
										"islem no", "hesap 1", "hesap 2", "tutar", "icerik", "Kaynak Bakiye", "Hedef Bakiye", "tarih"
								}
						));
					}else {
						JOptionPane.showMessageDialog(null,"Hesap Yok","",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnMusteriEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textAdresEkleme.getText().isEmpty() || textTelefonEkleme.getText().isEmpty() || 
				   textE_PostaEkleme.getText().isEmpty()||textSifre.getText().isEmpty() ||
				   textKullaniciAdi.getText().isEmpty() || textTCNO.getText().isEmpty()||
				   textAdSoyad.getText().isEmpty()
				) {
					JOptionPane.showMessageDialog(null,"Alanlar Bos Birakilamaz","",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					Musteri tmpMusteri=new Musteri();
		    		tmpMusteri.setTelefon(textTelefonEkleme.getText());
		    		tmpMusteri.setAdres(textAdresEkleme.getText());
		    		tmpMusteri.setAdSoyad(textAdSoyad.getText());
		    		tmpMusteri.setE_posta(textE_PostaEkleme.getText());
		    		tmpMusteri.setKullaniciAdi(textKullaniciAdi.getText());
		    		tmpMusteri.setTCNO(textTCNO.getText());
		    		tmpMusteri.setSifre(textSifre.getText());
					if(sorgu.musteriEkle(tmpMusteri,temsilci.getId())) {
						JOptionPane.showMessageDialog(null,"Musteri Eklendi","",JOptionPane.INFORMATION_MESSAGE);
					}
					musterileriDon();
					comboBoxMusteriSec.removeAllItems();
					for(int i=0;i<temsilci.musteriler.size();i++){
						comboBoxMusteriSec.addItem(temsilci.musteriler.get(i).getId()+"-"+temsilci.musteriler.get(i).getAdSoyad());
					}
				}
			}
		});
		btnHesapAcmaOnay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sorgu.hesapAc(hesapAcmapb,musteri.getId());
				sorgu.hesapAcmaSifirla(musteri.getId());
				btnHesapAcmaIptal.setEnabled(false);
				btnHesapAcmaOnay.setEnabled(false);
				musteriHesaplariDon();
				comboBoxHesapSec.removeAllItems();
				if(musteri.hesaplar!=null) {
					for(int x=0;x<musteri.hesaplar.size();x++) {
						Hesap tmp=musteri.hesaplar.get(x);
						comboBoxHesapSec.addItem(String.valueOf(tmp.getId()+"-"+musteri.getAdSoyad()));
					}
				}
			}
		});
		btnHesapAcmaIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sorgu.hesapAcmaSifirla(musteri.getId());
				btnHesapAcmaIptal.setEnabled(false);
				btnHesapAcmaOnay.setEnabled(false);
				JOptionPane.showMessageDialog(null,"istek iptal edildi","",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnHesapSilmeOnay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sorgu.hesapSil(musteri.getId(),hesap.getId());
				JOptionPane.showMessageDialog(null,"Hesap Silme Basarili","",JOptionPane.INFORMATION_MESSAGE);
				btnHesapSilmeIptal.setEnabled(false);
				btnHesapSilmeOnay.setEnabled(false);
				musteriHesaplariDon();
				comboBoxHesapSec.removeAllItems();
				if(musteri.hesaplar!=null) {
					for(int x=0;x<musteri.hesaplar.size();x++) {
						Hesap tmp=musteri.hesaplar.get(x);
						comboBoxHesapSec.addItem(String.valueOf(tmp.getId()+"-"+musteri.getAdSoyad()));
					}
				}
			}
		});
		btnHesapSilmeIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sorgu.hesapSilmeSifirla(hesap.getId());
				btnHesapSilmeIptal.setEnabled(false);
				btnHesapSilmeOnay.setEnabled(false);
				JOptionPane.showMessageDialog(null,"istek iptal edildi","",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnKrediIstegiOnay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float tmpBakiye=hesap.getBakiye();
				float gelir=hesap.getGelir();
				sorgu.krediMiktariAyarla(hesap);
				sorgu.krediIstegiSifirla(hesap.getId());
				lblToplamBakiye.setText(""+hesap.getBakiye());
				lblgelir.setText(""+hesap.getGelir());
				lblGider.setText(""+hesap.getGider());
				lblKrediBorcu.setText(""+hesap.getToplamKrediBorcu());
				lblParaBirimiDonut.setText(hesap.getParaBirimi());
				btnKrediIstegiOnay.setEnabled(false);
				btnKrediIstegiIptal.setEnabled(false);
				sorgu.islemYaz(0,hesap.getGelir()-gelir,0, tmpBakiye,"KrediCekme",hesap.getId(),musteri.getId());
				Object[][] colonBilgileri=sorgu.islemOzetiDon(hesap.getId(),musteri.getId(),0);
				table.setModel(new DefaultTableModel(
						colonBilgileri,
						new String[] {
								"islem no", "hesap 1", "hesap 2", "tutar", "icerik", "Kaynak Bakiye", "Hedef Bakiye", "tarih"
						}
				));
			}
		});
		btnKrediIstegiIptal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				sorgu.krediIstegiSifirla(hesap.getId());
				btnKrediIstegiOnay.setEnabled(false);
				btnKrediIstegiIptal.setEnabled(false);
			}
		});
	}
	private String[] musterileriDon() {
		String[] musteriAdlari=new String[10];
		sorgu.musterileriDon(temsilci);
		int i=0;
		if(temsilci.musteriler!=null) {
			for(Musteri musteri:temsilci.musteriler) {
				musteriAdlari[i]=musteri.getId()+"-"+musteri.getAdSoyad();
				i++;
			}
		}
		return musteriAdlari;
	}
	private void musteriHesaplariDon() {
		sorgu.hesaplariDon(musteri,temsilci.getId());//temsilci id verilmesinin sebebi istegin temsilciden gelmis oldugunu bilmek
		//boylelikle silinme asamasinda olan hesabin temsilcide gozukup musteride gozukmemeusi saglandi.
	}
}

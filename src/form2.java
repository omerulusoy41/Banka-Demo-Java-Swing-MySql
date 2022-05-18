import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

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
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class form2 extends JFrame {
	private JTextField textAdSoyad;
	private JTextField textTelefon;
	private JTextField textAdres;
	private JTextField textE_posta;
	private JTextField textParaCek;
	private JTextField textParaYatir;
	private JTextField textHesabaTransfer;
	private JTextField textKullaniciyaTransfer;
	private JTable table;
	private JTextField textKullaniciyaTransferTC;
	private Sorgular sorgu=new Sorgular(); 
	Musteri musteri;
	public Hesap hesap;
	public Banka banka=Banka.getBanka();
	private JTextField textKullaniciAdi;
	private JTextField textSifre;
	public form2(Musteri musteri) {
		this.musteri=musteri;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 469);
		setResizable(false);
		getContentPane().setLayout(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 829, 430);
		getContentPane().add(tabbedPane);
		
		JPanel kisiselBilgiler = new JPanel();
		kisiselBilgiler.setBackground(Color.YELLOW);
		tabbedPane.addTab("Kisisel Bilgiler", null, kisiselBilgiler, null);
		tabbedPane.setBackgroundAt(0, Color.LIGHT_GRAY);
		kisiselBilgiler.setLayout(null);
		
		JLabel labelAdSoyad = new JLabel("Ad-Soyad :");
		labelAdSoyad.setBounds(10, 11, 77, 14);
		kisiselBilgiler.add(labelAdSoyad);
		
		JLabel labelAdSoyadDonut = new JLabel(musteri.getAdSoyad());
		labelAdSoyadDonut.setBounds(91, 11, 262, 14);
		kisiselBilgiler.add(labelAdSoyadDonut);
		
		
		textAdSoyad = new JTextField();
		textAdSoyad.setBounds(526, 8, 86, 20);
		kisiselBilgiler.add(textAdSoyad);
		textAdSoyad.setColumns(10);
		
		JButton btnAdSoyadGuncelle = new JButton("Guncelle");
		btnAdSoyadGuncelle.setBounds(643, 7, 89, 23);
		kisiselBilgiler.add(btnAdSoyadGuncelle);
		
		JLabel labelTelefon = new JLabel("Telefon:");
		labelTelefon.setBounds(10, 63, 60, 14);
		kisiselBilgiler.add(labelTelefon);
		
		JLabel labelTelefonDonut = new JLabel(musteri.getTelefon());
		labelTelefonDonut.setBounds(91, 63, 276, 14);
		kisiselBilgiler.add(labelTelefonDonut);
		
		textTelefon = new JTextField();
		textTelefon.setBounds(526, 60, 86, 20);
		kisiselBilgiler.add(textTelefon);
		textTelefon.setColumns(10);
		
		JButton btnTelefonGuncelle = new JButton("Guncelle");
		btnTelefonGuncelle.setBounds(643, 59, 89, 23);
		kisiselBilgiler.add(btnTelefonGuncelle);
		
		JLabel labelAdres = new JLabel("Adres :");
		labelAdres.setBounds(10, 118, 40, 14);
		kisiselBilgiler.add(labelAdres);
		
		JLabel labelE_posta = new JLabel("e-posta :");
		labelE_posta.setBounds(10, 176, 60, 14);
		kisiselBilgiler.add(labelE_posta);
		
		JLabel labelAdresDonut = new JLabel(musteri.getAdres());
		labelAdresDonut.setBounds(87, 118, 359, 14);
		kisiselBilgiler.add(labelAdresDonut);
		
		textAdres = new JTextField();
		textAdres.setBounds(526, 115, 86, 20);
		kisiselBilgiler.add(textAdres);
		textAdres.setColumns(10);
		
		JButton btnAdresGuncelle = new JButton("Guncelle");
		btnAdresGuncelle.setBounds(643, 114, 89, 23);
		kisiselBilgiler.add(btnAdresGuncelle);
		
		JLabel labelE_postaDonut = new JLabel(musteri.getE_posta());
		labelE_postaDonut.setBounds(91, 176, 209, 14);
		kisiselBilgiler.add(labelE_postaDonut);
		
		textE_posta = new JTextField();
		textE_posta.setBounds(526, 173, 86, 20);
		kisiselBilgiler.add(textE_posta);
		textE_posta.setColumns(10);
		
		JButton btnE_postaGuncelle = new JButton("Guncelle");
		btnE_postaGuncelle.setBounds(643, 172, 89, 23);
		kisiselBilgiler.add(btnE_postaGuncelle);
		
		JLabel labelTCNo = new JLabel("TC-NO :");
		labelTCNo.setBounds(10, 317, 46, 14);
		kisiselBilgiler.add(labelTCNo);
		
		JLabel labelTCNoDonut = new JLabel(musteri.getTCNO());
		labelTCNoDonut.setBounds(91, 317, 130, 14);
		kisiselBilgiler.add(labelTCNoDonut);
		
		JButton btnGeriDonus = new JButton("Giris Ekranina Don");
		btnGeriDonus.setHorizontalAlignment(SwingConstants.LEADING);
		btnGeriDonus.setBounds(10, 368, 156, 23);
		kisiselBilgiler.add(btnGeriDonus);
		
		JLabel labelKullaniciAdi = new JLabel("Kullanici Adi :");
		labelKullaniciAdi.setBounds(10, 223, 77, 14);
		kisiselBilgiler.add(labelKullaniciAdi);
		
		JLabel labelSifre = new JLabel("Sifre :");
		labelSifre.setBounds(10, 267, 60, 14);
		kisiselBilgiler.add(labelSifre);
		
		textKullaniciAdi = new JTextField();
		textKullaniciAdi.setColumns(10);
		textKullaniciAdi.setBounds(526, 220, 86, 20);
		kisiselBilgiler.add(textKullaniciAdi);
		
		textSifre = new JTextField();
		textSifre.setColumns(10);
		textSifre.setBounds(526, 264, 86, 20);
		kisiselBilgiler.add(textSifre);
		
		JLabel labelKullaniciAdiDonut = new JLabel(musteri.getKullaniciAdi());
		labelKullaniciAdiDonut.setBounds(91, 223, 209, 14);
		kisiselBilgiler.add(labelKullaniciAdiDonut);
		
		JButton btnKullaniciAdiGuncelle = new JButton("Guncelle");
		btnKullaniciAdiGuncelle.setBounds(643, 219, 89, 23);
		kisiselBilgiler.add(btnKullaniciAdiGuncelle);
		
		JButton btnSifreGuncelle = new JButton("Guncelle");
		btnSifreGuncelle.setBounds(643, 263, 89, 23);
		kisiselBilgiler.add(btnSifreGuncelle);
		
		JLabel lblNewLabel = new JLabel("**************");
		lblNewLabel.setBounds(91, 267, 97, 14);
		kisiselBilgiler.add(lblNewLabel);
		JPanel hesapBilgileri = new JPanel();
		hesapBilgileri.setBackground(Color.YELLOW);
		tabbedPane.addTab("Hesap Bilgileri", null, hesapBilgileri, null);
		hesapBilgileri.setLayout(null);
		
		JButton btnGirisEkraninaDon = new JButton("Giris Ekranina Don");
		btnGirisEkraninaDon.setHorizontalAlignment(SwingConstants.LEADING);
		btnGirisEkraninaDon.setBounds(10, 368, 156, 23);
		hesapBilgileri.add(btnGirisEkraninaDon);
		
		JComboBox comboBoxHesapSec = new JComboBox();
		String[] tmpHesaplar=hesaplariDon();
		comboBoxHesapSec.setModel(new DefaultComboBoxModel(tmpHesaplar));
		comboBoxHesapSec.setBounds(504, 48, 130, 22);
		hesapBilgileri.add(comboBoxHesapSec);
		
		JButton btnHesapSec = new JButton("Hesap Sec\r\n");
		btnHesapSec.setBounds(657, 48, 130, 23);
		hesapBilgileri.add(btnHesapSec);
		
		JLabel lblBakiye = new JLabel("Bakiye :");
		lblBakiye.setBounds(40, 52, 86, 14);
		hesapBilgileri.add(lblBakiye);
		
		textParaCek = new JTextField();
		textParaCek.setBounds(249, 88, 61, 20);
		hesapBilgileri.add(textParaCek);
		textParaCek.setColumns(10);
		
		JLabel lblBakiyeDonut = new JLabel("-");
		lblBakiyeDonut.setBounds(249, 52, 61, 14);
		hesapBilgileri.add(lblBakiyeDonut);
		
		JLabel lblParaCek = new JLabel("Para Cek");
		lblParaCek.setBounds(39, 91, 87, 14);
		hesapBilgileri.add(lblParaCek);
		
		JLabel lblParaYatir = new JLabel("Para Yatir\r\n");
		lblParaYatir.setBounds(40, 137, 86, 14);
		hesapBilgileri.add(lblParaYatir);
		
		textParaYatir = new JTextField();
		textParaYatir.setBounds(249, 134, 61, 20);
		hesapBilgileri.add(textParaYatir);
		textParaYatir.setColumns(10);
		
		JLabel lblHesapTransfer = new JLabel("Hesabina Para Transferi\r\n");
		lblHesapTransfer.setBounds(40, 190, 156, 14);
		hesapBilgileri.add(lblHesapTransfer);
		
		textHesabaTransfer = new JTextField();
		textHesabaTransfer.setBounds(249, 187, 61, 20);
		hesapBilgileri.add(textHesabaTransfer);
		textHesabaTransfer.setColumns(10);
		
		JLabel lblKullaniciTransfer = new JLabel("Kullaniciya para tranferi");
		lblKullaniciTransfer.setBounds(41, 243, 146, 14);
		hesapBilgileri.add(lblKullaniciTransfer);
		
		textKullaniciyaTransfer = new JTextField();
		textKullaniciyaTransfer.setBounds(249, 240, 61, 20);
		hesapBilgileri.add(textKullaniciyaTransfer);
		textKullaniciyaTransfer.setColumns(10);
		
		JButton btnHesapSil = new JButton("Hesabi Sil");
		btnHesapSil.setBounds(575, 87, 130, 23);
		hesapBilgileri.add(btnHesapSil);
		
		JButton btnYeniHesapAc = new JButton("Yeni Hesap Ac\r\n");
		btnYeniHesapAc.setBounds(504, 133, 130, 23);
		hesapBilgileri.add(btnYeniHesapAc);
		
		JLabel lblToplamKredi = new JLabel("Toplam Kredi Borcu");
		lblToplamKredi.setBounds(40, 291, 114, 14);
		hesapBilgileri.add(lblToplamKredi);
		
		JLabel lblToplamKrediDonut = new JLabel("-");
		lblToplamKrediDonut.setBounds(250, 291, 61, 14);
		hesapBilgileri.add(lblToplamKrediDonut);
		
		JButton btnAylikKrediOde = new JButton("Aylik Kredi Ode");
		btnAylikKrediOde.setEnabled(false);
		btnAylikKrediOde.setBounds(408, 323, 128, 23);
		hesapBilgileri.add(btnAylikKrediOde);
		
		JButton btnTumKrediOde = new JButton("Tum kredi Ode\r\n");
		btnTumKrediOde.setBounds(408, 287, 130, 23);
		btnTumKrediOde.setEnabled(false);
		hesapBilgileri.add(btnTumKrediOde);
		
		JComboBox comboBoxParaBirimi = new JComboBox();
		comboBoxParaBirimi.setBounds(644, 133, 102, 22);
		comboBoxParaBirimi.setModel(new DefaultComboBoxModel(banka.paraBirimleri));
		hesapBilgileri.add(comboBoxParaBirimi);
		
		JLabel lblNewLabel_16 = new JLabel("Para Birimi\r\n");
		lblNewLabel_16.setBounds(756, 137, 86, 14);
		hesapBilgileri.add(lblNewLabel_16);
		
		JButton btnKrediTalebi = new JButton("Kredi Talebi");
		btnKrediTalebi.setBounds(504, 190, 130, 23);
		hesapBilgileri.add(btnKrediTalebi);
		
		JLabel lblNewLabel_14_1 = new JLabel("Aylik Kredi Borcu");
		lblNewLabel_14_1.setBounds(40, 327, 114, 14);
		hesapBilgileri.add(lblNewLabel_14_1);
		
		JLabel lblAylikKrediDonut = new JLabel("-");
		lblAylikKrediDonut.setBounds(250, 327, 61, 14);
		hesapBilgileri.add(lblAylikKrediDonut);
		
		JComboBox comboBoxHesapTransfer = new JComboBox();
		comboBoxHesapTransfer.setBounds(320, 186, 74, 22);
		comboBoxHesapTransfer.setModel(new DefaultComboBoxModel(tmpHesaplar));
		hesapBilgileri.add(comboBoxHesapTransfer);
		
		JButton btnParaYatir = new JButton("ok\r\n");
		btnParaYatir.setBounds(320, 133, 61, 23);
		hesapBilgileri.add(btnParaYatir);
		
		JButton btnParaCek = new JButton("ok\r\n");
		btnParaCek.setBounds(320, 87, 61, 23);
		hesapBilgileri.add(btnParaCek);
		
		JButton btnHesabaTransfer = new JButton("ok\r\n");
		btnHesabaTransfer.setBounds(404, 186, 61, 23);
		hesapBilgileri.add(btnHesabaTransfer);
		
		JButton btnKullaniciyaTransfer = new JButton("ok\r\n");
		btnKullaniciyaTransfer.setBounds(404, 239, 61, 23);
		hesapBilgileri.add(btnKullaniciyaTransfer);
		
		textKullaniciyaTransferTC = new JTextField();
		textKullaniciyaTransferTC.setBounds(320, 240, 74, 20);
		hesapBilgileri.add(textKullaniciyaTransferTC);
		textKullaniciyaTransferTC.setColumns(10);
		
		JLabel lblTCNo = new JLabel("TC NO");
		lblTCNo.setBounds(320, 219, 46, 14);
		hesapBilgileri.add(lblTCNo);
		
		JLabel lblParaBirimiDonut = new JLabel("-");
		lblParaBirimiDonut.setBounds(320, 52, 46, 14);
		hesapBilgileri.add(lblParaBirimiDonut);
		
		JLabel lblTl_1 = new JLabel("TL");
		lblTl_1.setBounds(321, 291, 46, 14);
		hesapBilgileri.add(lblTl_1);
		
		JLabel lblTl = new JLabel("TL");
		lblTl.setBounds(321, 327, 46, 14);
		hesapBilgileri.add(lblTl);
		
		JTextPane textKrediTalebi = new JTextPane();
		textKrediTalebi.setBounds(644, 190, 114, 23);
		hesapBilgileri.add(textKrediTalebi);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(617, 243, 168, 148);
		hesapBilgileri.add(panel);
		panel.setLayout(null);
		
		JLabel lblGelir = new JLabel("Gelir");
		lblGelir.setBounds(10, 25, 46, 14);
		panel.add(lblGelir);
		
		JLabel lblGider = new JLabel("Gider");
		lblGider.setBounds(10, 83, 46, 14);
		panel.add(lblGider);
		
		JLabel lblGelirDonut = new JLabel("");
		lblGelirDonut.setBounds(66, 25, 46, 14);
		panel.add(lblGelirDonut);
		
		JLabel lblGiderDonut = new JLabel("");
		lblGiderDonut.setBounds(81, 83, 46, 14);
		panel.add(lblGiderDonut);
		
		JLabel lblParaBirimiDonut2 = new JLabel("-");
		lblParaBirimiDonut2.setBounds(122, 25, 46, 14);
		panel.add(lblParaBirimiDonut2);
		
		JLabel lblParaBirimiDonut3 = new JLabel("-");
		lblParaBirimiDonut3.setBounds(122, 83, 46, 14);
		panel.add(lblParaBirimiDonut3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.YELLOW);
		tabbedPane.addTab("Aylik Ozet", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(106, 11, 708, 339);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setBounds(189, 52, 501, 339);
		scrollPane.setViewportView(table);
		
		JButton btnGirisEkraninaDon3 = new JButton("Giris Ekranina Don");
		btnGirisEkraninaDon3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				form1 frame2=new form1();
				frame2.giris();
				frame2.setVisible(true);
			}
		});
		btnGirisEkraninaDon3.setHorizontalAlignment(SwingConstants.LEADING);
		btnGirisEkraninaDon3.setBounds(10, 368, 156, 23);
		panel_2.add(btnGirisEkraninaDon3);
		
		JButton btnOzetGoster = new JButton("Goster");
		btnOzetGoster.setBounds(7, 28, 89, 23);
		panel_2.add(btnOzetGoster);
		
		btnGirisEkraninaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				form1 frame2=new form1();
				frame2.giris();
				frame2.setVisible(true);
			}
		});
		btnGeriDonus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				form1 frame2=new form1();
				frame2.giris();
				frame2.setVisible(true);
			}
		});
		
		btnAdSoyadGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textAdSoyad.getText().isEmpty()) {
					if(sorgu.kisiselBilgiGuncelle("adSoyad",textAdSoyad.getText(),musteri.getTCNO())) {
						JOptionPane.showMessageDialog(null,"Guncelleme Basarili","",JOptionPane.INFORMATION_MESSAGE);
						musteri.setAdSoyad(textAdSoyad.getText());
						labelAdSoyadDonut.setText(musteri.getAdSoyad());
					}else {
						JOptionPane.showMessageDialog(null,"Guncelleme Basarisiz","",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
			}
		});
		btnTelefonGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textTelefon.getText().isEmpty()) {
					if(sorgu.kisiselBilgiGuncelle("Telefon",textTelefon.getText(),musteri.getTCNO())) {
						JOptionPane.showMessageDialog(null,"Guncelleme Basarili","",JOptionPane.INFORMATION_MESSAGE);
						musteri.setTelefon(textTelefon.getText());
						labelTelefonDonut.setText(musteri.getTelefon());
					}
					else {
						JOptionPane.showMessageDialog(null,"Guncelleme Basarisiz","",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnE_postaGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textE_posta.getText().isEmpty()) {
					if(sorgu.kisiselBilgiGuncelle("e_posta",textE_posta.getText(),musteri.getTCNO())) {
						JOptionPane.showMessageDialog(null,"Guncelleme Basarili","",JOptionPane.INFORMATION_MESSAGE);
						musteri.setE_posta(textE_posta.getText());
						labelE_postaDonut.setText(musteri.getE_posta());
					}else {
						JOptionPane.showMessageDialog(null,"Guncelleme Basarisiz","",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnAdresGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textAdres.getText().isEmpty()) {
					if(sorgu.kisiselBilgiGuncelle("adres",textAdres.getText(),musteri.getTCNO())) {
						JOptionPane.showMessageDialog(null,"Guncelleme Basarili","",JOptionPane.INFORMATION_MESSAGE);
						musteri.setAdres(textAdres.getText());
						labelAdresDonut.setText(musteri.getAdres());
					}else {
						JOptionPane.showMessageDialog(null,"Guncelleme Basarisiz","",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnKullaniciAdiGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textKullaniciAdi.getText().isEmpty()) {
					if(sorgu.MusteriEklemeKontrol(musteri.getKullaniciAdi(),"0")) {
						if(sorgu.kisiselBilgiGuncelle("kullaniciAdi",textKullaniciAdi.getText(),musteri.getTCNO())) {
							JOptionPane.showMessageDialog(null,"Guncelleme Basarili","",JOptionPane.INFORMATION_MESSAGE);
							musteri.setKullaniciAdi(textKullaniciAdi.getText());
							labelKullaniciAdiDonut.setText(musteri.getKullaniciAdi());
						}
					}else {
						JOptionPane.showMessageDialog(null,"Guncelleme Basarisiz","",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnSifreGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textSifre.getText().isEmpty()) {
					if(sorgu.kisiselBilgiGuncelle("sifre",textSifre.getText(),musteri.getTCNO())) {
						JOptionPane.showMessageDialog(null,"Guncelleme Basarili","",JOptionPane.INFORMATION_MESSAGE);
						musteri.setSifre(textSifre.getText());
					}else {
						JOptionPane.showMessageDialog(null,"Guncelleme Basarisiz","",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnHesapSec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hesaplariDon();
				if(musteri.hesaplar==null) {
					JOptionPane.showMessageDialog(null,"Hesap Yok","",JOptionPane.INFORMATION_MESSAGE);
				}else {
					hesap=musteri.hesaplar.get(comboBoxHesapSec.getSelectedIndex());
					comboBoxHesapTransfer.removeAllItems();
					for(Hesap tumHesap:musteri.hesaplar) {
						if(hesap.getId()!=tumHesap.getId()) {
							comboBoxHesapTransfer.addItem(tumHesap.getId()+"-"+musteri.getAdSoyad());
						}
					}
					lblBakiyeDonut.setText(String.valueOf(hesap.getBakiye()));
					lblParaBirimiDonut.setText(hesap.getParaBirimi());
					lblGelirDonut.setText(""+hesap.getGelir());
					lblGiderDonut.setText(""+hesap.getGider());
					lblParaBirimiDonut2.setText(hesap.getParaBirimi());
					lblParaBirimiDonut3.setText(hesap.getParaBirimi());
					if(hesap.getToplamKrediBorcu()!=0) {
						lblToplamKrediDonut.setText(""+hesap.getToplamKrediBorcu());
						lblAylikKrediDonut.setText(""+hesap.getAylikKrediBorcu());
						int gecikme=aylikKrediGecikmesiVarMi();
						if(gecikme>0) {	
							lblToplamKrediDonut.setText(""+hesap.getToplamKrediBorcu());
						}
						btnAylikKrediOde.setEnabled(true);
						btnTumKrediOde.setEnabled(true);
					}else {
						lblToplamKrediDonut.setText("-");
						lblAylikKrediDonut.setText("-");
						btnAylikKrediOde.setEnabled(false);
						btnTumKrediOde.setEnabled(false);
					}
					
				}
			}
		});
		
		btnHesapSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hesap==null) {
					JOptionPane.showMessageDialog(null,"Lutfen Hesap Seciniz","",JOptionPane.INFORMATION_MESSAGE);
				}else {
					if(hesap.getBakiye()!=0) {
						JOptionPane.showMessageDialog(null,"Bakiye 0 dan farkli olan Hesap silinemez","",JOptionPane.INFORMATION_MESSAGE);
					}else {
						//sorgu.hesapSil(musteri,hesap.getId());
						JOptionPane.showMessageDialog(null,"Hesap Silme Talebiniz temsilciye iletildi","",JOptionPane.INFORMATION_MESSAGE);
						JOptionPane.showMessageDialog(null,"Hesap kullaniminiz kisitlanmistir","",JOptionPane.INFORMATION_MESSAGE);
						btnHesapSil.setEnabled(false);
						sorgu.hesapSilmeAsamasiAyarla(hesap.getId());
						lblBakiyeDonut.setText("-");
						lblParaBirimiDonut.setText("-");
						lblToplamKrediDonut.setText("-");
						lblAylikKrediDonut.setText("-");
						lblGelirDonut.setText("-");
						lblGiderDonut.setText("-");
						lblParaBirimiDonut2.setText("-");
						lblParaBirimiDonut3.setText("-");
						comboBoxHesapSec.removeAllItems();
						comboBoxHesapTransfer.removeAllItems();
						hesaplariDon();
						if(musteri.hesaplar!=null) {
							for(Hesap tumHesap:musteri.hesaplar) {
								if(hesap.getId()!=tumHesap.getId()) {
									comboBoxHesapSec.addItem(tumHesap.getId()+"-"+musteri.getAdSoyad());
									comboBoxHesapTransfer.addItem(tumHesap.getId()+"-"+musteri.getAdSoyad());
								}
							    
							}
						}
						hesap=null;
					}
				}

			}
		});
		btnYeniHesapAc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pb=String.valueOf(comboBoxParaBirimi.getSelectedItem());
				sorgu.hesapAcmaAsamasiAyarla(pb,musteri.getId());
				JOptionPane.showMessageDialog(null,"Temsilcinize istek yollandi","",JOptionPane.INFORMATION_MESSAGE);
				btnYeniHesapAc.setEnabled(false);
				comboBoxParaBirimi.setEnabled(false);
				
			}
		});
		btnParaCek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hesap==null) {
					JOptionPane.showMessageDialog(null,"Lutfen Hesap Seciniz","",JOptionPane.INFORMATION_MESSAGE);
				}else {
					float cek=Float.parseFloat(textParaCek.getText());
					if(cek>hesap.getBakiye()) {
						JOptionPane.showMessageDialog(null,"Yetersiz Bakiye","",JOptionPane.INFORMATION_MESSAGE);
					}else {
						sorgu.islemYaz(-1,cek,hesap.getBakiye(),0,"para Cekme",hesap.getId(),musteri.getId());
						hesap.setBakiye(hesap.getBakiye()-cek);
						lblBakiyeDonut.setText(String.valueOf(hesap.getBakiye()));
						hesap.setGider(hesap.getGider()+cek);
						lblGiderDonut.setText(""+hesap.getGider());
						sorgu.gelirGiderGuncelle(hesap,0);
						sorgu.bakiyeGuncelle(hesap.getBakiye(),hesap.getId());
						JOptionPane.showMessageDialog(null,"Islem Basarili","",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnParaYatir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hesap==null) {
					JOptionPane.showMessageDialog(null,"Lutfen Hesap Seciniz","",JOptionPane.INFORMATION_MESSAGE);
				}else {
					float yatir=Float.parseFloat(textParaYatir.getText());
					sorgu.islemYaz(-1,yatir,0,hesap.getBakiye(),"para Yatirma",hesap.getId(),musteri.getId());
					hesap.setBakiye(hesap.getBakiye()+yatir);
					lblBakiyeDonut.setText(String.valueOf(hesap.getBakiye()));
					hesap.setGelir(hesap.getGelir()+yatir);
					lblGelirDonut.setText(""+hesap.getGelir());
					sorgu.gelirGiderGuncelle(hesap,1);
					sorgu.bakiyeGuncelle(hesap.getBakiye(),hesap.getId());
					
					JOptionPane.showMessageDialog(null,"Islem Basarili","",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnHesabaTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hesap==null) {
					JOptionPane.showMessageDialog(null,"Lutfen Hesap Seciniz","",JOptionPane.INFORMATION_MESSAGE);
				}else {
					if(!textHesabaTransfer.getText().isEmpty()) {
						float cek=Float.parseFloat(textHesabaTransfer.getText());
						if(cek>hesap.getBakiye()) {
							JOptionPane.showMessageDialog(null,"Yetersiz Bakiye","",JOptionPane.INFORMATION_MESSAGE);
						}else if(cek<=0) {
							JOptionPane.showMessageDialog(null,"Gecersiz Islem","",JOptionPane.INFORMATION_MESSAGE);
						}else {
							String a=String.valueOf(comboBoxHesapTransfer.getSelectedItem());
							int kesme=a.indexOf('-');
							Hesap tmpHesap=null;
							for(int i=0;i<musteri.hesaplar.size();i++){
								tmpHesap=musteri.hesaplar.get(i);
								if(tmpHesap.getId()==Integer.parseInt(a.substring(0,kesme))){
									sorgu.transferEdilecekHesabiAyarla(tmpHesap);
									sorgu.islemYaz(tmpHesap.getId(),cek,hesap.getBakiye(),tmpHesap.getBakiye(),"Hesaba Transfer"
											, hesap.getId(),musteri.getId());
									hesap.setBakiye(hesap.getBakiye()-cek);
									lblBakiyeDonut.setText(String.valueOf(hesap.getBakiye()));
									hesap.setGider(hesap.getGider()+cek);
									lblGiderDonut.setText(""+hesap.getGider());
									sorgu.gelirGiderGuncelle(hesap,0);
									sorgu.bakiyeGuncelle(hesap.getBakiye(),hesap.getId());
									if(hesap.getParaBirimi().compareTo(tmpHesap.getParaBirimi())==0) {
										sorgu.bakiyeGuncelle(tmpHesap.getBakiye()+cek,tmpHesap.getId());
										tmpHesap.setGelir(tmpHesap.getGelir()+cek);
										sorgu.gelirGiderGuncelle(tmpHesap,1);
									}else {
										float kur1=sorgu.kurDon(hesap.getParaBirimi());
										float kur2=sorgu.kurDon(tmpHesap.getParaBirimi());
										cek*=kur1;
										cek/=kur2;
										float yatir=tmpHesap.getBakiye()+cek;
										tmpHesap.setBakiye(yatir);
										tmpHesap.setGelir(tmpHesap.getGelir()+cek);
										sorgu.gelirGiderGuncelle(tmpHesap,1);
										sorgu.bakiyeGuncelle(yatir,tmpHesap.getId());
									}
								}
							}
							JOptionPane.showMessageDialog(null,"Islem Basarili","",JOptionPane.INFORMATION_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null,"Miktar Giriniz","",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnKullaniciyaTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hesap==null) {
					JOptionPane.showMessageDialog(null,"Lutfen Hesap Seciniz","",JOptionPane.INFORMATION_MESSAGE);
				}else {
					if(!textKullaniciyaTransfer.getText().isEmpty()) {
						float cek=Float.parseFloat(textKullaniciyaTransfer.getText()) ;
						if(cek>hesap.getBakiye()) {
							JOptionPane.showMessageDialog(null,"Yetersiz Bakiye","",JOptionPane.INFORMATION_MESSAGE);
						}else if(cek<=0) {
							JOptionPane.showMessageDialog(null,"Gecersiz islem","",JOptionPane.INFORMATION_MESSAGE);
						}else {
							
							Hesap tmpHesap=sorgu.kullanicilarArasiHesabiDon(Integer.parseInt(textKullaniciyaTransferTC.getText()));
							sorgu.islemYaz(tmpHesap.getId(),cek,hesap.getBakiye(),tmpHesap.getBakiye(),
									"Kullaniciya Transfer",hesap.getId(),musteri.getId());
							hesap.setBakiye(hesap.getBakiye()-cek);
							lblBakiyeDonut.setText(String.valueOf(hesap.getBakiye()));
							hesap.setGider(hesap.getGider()+cek);
							lblGiderDonut.setText(""+hesap.getGider());
							sorgu.gelirGiderGuncelle(hesap,0);
							sorgu.bakiyeGuncelle(hesap.getBakiye(),hesap.getId());
							if(hesap.getParaBirimi().compareTo(tmpHesap.getParaBirimi())==0) {
								sorgu.bakiyeGuncelle(tmpHesap.getBakiye()+cek,tmpHesap.getId());
								tmpHesap.setGelir(tmpHesap.getGelir()+cek);
							}else {
								float kur1=sorgu.kurDon(hesap.getParaBirimi());
								float kur2=sorgu.kurDon(tmpHesap.getParaBirimi());
								cek*=kur1;
								cek/=kur2;
								float yatir=tmpHesap.getBakiye()+cek;
								tmpHesap.setBakiye(yatir);
								tmpHesap.setGelir(tmpHesap.getGelir()+cek);
								sorgu.gelirGiderGuncelle(tmpHesap,1);
								sorgu.bakiyeGuncelle(yatir,tmpHesap.getId());
							}
							JOptionPane.showMessageDialog(null,"Islem Basarili","",JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			}
		});
		btnOzetGoster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hesap==null) {
					JOptionPane.showMessageDialog(null,"Lutfen Hesap Seciniz","",JOptionPane.INFORMATION_MESSAGE);
				}else {
					Object[][] colonBilgileri=sorgu.islemOzetiDon(hesap.getId(),musteri.getId(),0);//musteriId temsilci icin
					table.setModel(new DefaultTableModel(
							colonBilgileri,
							new String[] {
								"islem no", "hesap 1", "hesap 2", "tutar", "icerik", "Kaynak Bakiye", "Hedef Bakiye", "tarih"
							}
					));
				}
			}
		});
		btnKrediTalebi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hesap!=null) {
					if(!(textKrediTalebi.getText().isEmpty())) {
						Float kredi=Float.parseFloat(textKrediTalebi.getText());
						if(kredi<=0) {
							JOptionPane.showMessageDialog(null,"Hatali deger","",JOptionPane.INFORMATION_MESSAGE);
						}else if(kredi>banka.bankaHesabi.getBakiye()) {
							JOptionPane.showMessageDialog(null,"Banka bakiyesi bu krediyi almaniza onay vermiyor","",JOptionPane.INFORMATION_MESSAGE);
						}else {
							sorgu.krediIstegiAsamasiAyarla(hesap.getId(),kredi);
							JOptionPane.showMessageDialog(null,"Kredi Istegi Temsilcinize Gonderildi","",JOptionPane.INFORMATION_MESSAGE);
							btnKrediTalebi.setEnabled(false);
							textKrediTalebi.setEnabled(false);
						}
					}
				}else {
					JOptionPane.showMessageDialog(null,"Lutfen Hesap Seciniz","",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnTumKrediOde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hesap!=null) {
					float kur=sorgu.kurDon(hesap.getParaBirimi());
					float TLKontrol=hesap.getBakiye()*kur;
					if(TLKontrol>=hesap.getToplamKrediBorcu()) {
						sorgu.krediOde(1, hesap);
						sorgu.islemYaz(0,hesap.getToplamKrediBorcu(),hesap.getBakiye(),0,"Borc Odeme",hesap.getId(),musteri.getId());
						if(kur!=1) {
							hesap.setGider(hesap.getGider()+hesap.getToplamKrediBorcu()/kur);
							hesap.setBakiye(hesap.getBakiye()-hesap.getToplamKrediBorcu()/kur);
						}else {
							hesap.setGider(hesap.getGider()+hesap.getToplamKrediBorcu());
							hesap.setBakiye(hesap.getBakiye()-hesap.getToplamKrediBorcu());
						}
						hesap.setToplamKrediBorcu(0);
						hesap.setAylikKrediBorcu(0);
						
						lblGiderDonut.setText(""+hesap.getGider());
						sorgu.gelirGiderGuncelle(hesap,0);
						
						lblToplamKrediDonut.setText("0");
						lblBakiyeDonut.setText(""+hesap.getBakiye());
						lblAylikKrediDonut.setText("0");
						
						sorgu.bakiyeGuncelle(hesap.getBakiye(),hesap.getId());
						JOptionPane.showMessageDialog(null,"Tum kredi Odenmistir","",JOptionPane.INFORMATION_MESSAGE);
						btnTumKrediOde.setEnabled(false);
						btnAylikKrediOde.setEnabled(false);
					}else {
						JOptionPane.showMessageDialog(null,"yetersiz bakiye","",JOptionPane.INFORMATION_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null,"Lutfen Hesap Seciniz","",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnAylikKrediOde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hesap!=null) {
					float kur=sorgu.kurDon(hesap.getParaBirimi());
					float TLKontrol=hesap.getBakiye()*kur;
					if(TLKontrol>=hesap.getAylikKrediBorcu()) {
						sorgu.krediOde(0, hesap);
						sorgu.islemYaz(0,hesap.getAylikKrediBorcu(),hesap.getBakiye(),0,"borc odeme",hesap.getId(),musteri.getId());
						if(kur!=1) {
							hesap.setGider(hesap.getGider()+hesap.getAylikKrediBorcu()/kur);
							hesap.setBakiye(hesap.getBakiye()-hesap.getAylikKrediBorcu()/kur);
						}else {
							hesap.setGider(hesap.getGider()+hesap.getAylikKrediBorcu());
							hesap.setBakiye(hesap.getBakiye()-hesap.getAylikKrediBorcu());
						}
						lblGiderDonut.setText(""+hesap.getGider());
						sorgu.gelirGiderGuncelle(hesap,0);
						hesap.setToplamKrediBorcu(hesap.getToplamKrediBorcu()-hesap.getAylikKrediBorcu());
						lblToplamKrediDonut.setText(""+hesap.getToplamKrediBorcu());
						lblBakiyeDonut.setText(""+hesap.getBakiye());
						
						sorgu.bakiyeGuncelle(hesap.getBakiye(),hesap.getId());
						JOptionPane.showMessageDialog(null,"Aylik kredi Odenmistir","",JOptionPane.INFORMATION_MESSAGE);
						if(hesap.getToplamKrediBorcu()==0) {
							lblAylikKrediDonut.setText("-");
							lblToplamKrediDonut.setText("-");
							btnTumKrediOde.setEnabled(false);
							btnAylikKrediOde.setEnabled(false);
						}
					}else {
						JOptionPane.showMessageDialog(null,"yetersiz bakiye","",JOptionPane.INFORMATION_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null,"Lutfen Hesap Seciniz","",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}
	private String[] hesaplariDon() {
		sorgu.hesaplariDon(musteri,0);// 0 verilmesinin nedeni temsilciMenuden farkli olmali
		String[] tmpHesaplar=new String[10];
		if(musteri.hesaplar!=null) {
			int i=0;
			for(Hesap hesap:musteri.hesaplar) {
				tmpHesaplar[i]=hesap.getId()+"-"+musteri.getAdSoyad();
				i++;
			}
		}
		return tmpHesaplar;
	}
	private int aylikKrediGecikmesiVarMi() {
		String bankaTarihi=banka.bankaHesabi.getTarih();
		String[] arr1=bankaTarihi.split("/");
		int gun1=Integer.parseInt(arr1[0]);
		int ay1=Integer.parseInt(arr1[1]);
		int yil1=Integer.parseInt(arr1[2]);
		
		String krediTarihi=hesap.getKrediCekmeTarihi();
		String[] arr2=krediTarihi.split("/");
		int gun2=Integer.parseInt(arr2[0]);
		int ay2=Integer.parseInt(arr2[1]);
		int yil2=Integer.parseInt(arr2[2]);
		
		LocalDate t1=LocalDate.of(yil1,ay1,gun1);
		LocalDate t2=LocalDate.of(yil2, ay2,gun2);
		Period period=Period.between(t2,t1);
		if(period.getMonths()>hesap.getKacAyOdendi()) {
			int gecikme=period.getMonths()-hesap.getKacAyOdendi();
			float eklenecek=0;
			eklenecek=hesap.getAylikKrediBorcu()*banka.bankaHesabi.getGecikmeFaizi();
			eklenecek*=gecikme;
			JOptionPane.showMessageDialog(null,"Kredi Odemelerinizde Gecikme mevcut","",JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null,"Toplam Kredi borcuna "+eklenecek+" TL eklenmistir","",JOptionPane.INFORMATION_MESSAGE);
			sorgu.gecikmeEkle(hesap, eklenecek);
			return  1;
		}
		return 0;
	}
}

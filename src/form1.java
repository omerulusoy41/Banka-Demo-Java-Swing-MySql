import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class form1 extends JFrame {

	private JPanel girisPaneli;
	private JLabel Hosgeldiniz;
	private JTextField kullaniciAdiText;
	private JLabel kullaniciAdiLabel;
	private JLabel sifreLabel;
	private JPasswordField sifreText;
	private Sorgular sorgu=new Sorgular();
	public form1() {
		
	}
	public void giris() {
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100,850, 469);
			girisPaneli = new JPanel();
			girisPaneli.setBackground(new Color(255, 218, 185));
			girisPaneli.setBorder(new LineBorder(new Color(0, 0, 0), 4));
			girisPaneli.setVisible(true);
			setContentPane(girisPaneli);
			girisPaneli.setLayout(null);
			Hosgeldiniz = new JLabel("Banka Yonetim Sistemine Hosgeldiniz");
			Hosgeldiniz.setHorizontalAlignment(SwingConstants.CENTER);
			Hosgeldiniz.setFont(new Font("Times New Roman", Font.PLAIN, 35));
			Hosgeldiniz.setBackground(Color.ORANGE);
			Hosgeldiniz.setBounds(128, 30, 564, 58);
			girisPaneli.add(Hosgeldiniz);
			Hosgeldiniz.setOpaque(true);
			setResizable(false);
			JButton girisYap = new JButton("Giris Yap");
			girisYap.setFont(new Font("Tahoma", Font.PLAIN, 18));
			girisYap.setBackground(new Color(127, 255, 212));
			
			girisYap.setBounds(495, 324, 108, 23);
			girisPaneli.add(girisYap);
			
			kullaniciAdiText = new JTextField();
			kullaniciAdiText.setBounds(391, 159, 125, 20);
			girisPaneli.add(kullaniciAdiText);
			kullaniciAdiText.setColumns(10);
			
			kullaniciAdiLabel = new JLabel("Kullanici Adi :");
			kullaniciAdiLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
			kullaniciAdiLabel.setBackground(Color.YELLOW);
			kullaniciAdiLabel.setBounds(209, 162, 131, 14);
			girisPaneli.add(kullaniciAdiLabel);
			
			sifreLabel = new JLabel("Sifre           :");
			sifreLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
			sifreLabel.setBounds(209, 245, 108, 14);
			girisPaneli.add(sifreLabel);
			
			sifreText = new JPasswordField();
			sifreText.setBounds(391, 242, 125, 20);
			girisPaneli.add(sifreText);
			girisYap.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String kullaniciAdi=kullaniciAdiText.getText();
					String sifre=String.valueOf(sifreText.getPassword());
					Musteri musteri=sorgu.musteriGirisKontrol(kullaniciAdi,sifre);
					Mudur mudur=sorgu.mudurGirisKontrol(kullaniciAdi,sifre);
					Temsilci temsilci=sorgu.temsilciGirisKontrol(kullaniciAdi, sifre);
					if(musteri!=null) {
						JOptionPane.showMessageDialog(null,"Kullanici Giris Islemi Basarili","",JOptionPane.INFORMATION_MESSAGE);	
						dispose();
						form2 frame2=new form2(musteri);
						frame2.setVisible(true);
					}else if(mudur!=null) {
						JOptionPane.showMessageDialog(null,"Mudur Giris Islemi Basarili","",JOptionPane.INFORMATION_MESSAGE);	
						dispose();
						MudurMenu mudurFrame=new MudurMenu(mudur);
						//mudurFrame.goster();
						mudurFrame.setVisible(true);
					}else if(temsilci!=null) {
						JOptionPane.showMessageDialog(null,"Personel Giris Islemi Basarili","",JOptionPane.INFORMATION_MESSAGE);	
						dispose();
						TemsilciMenu frameT=new TemsilciMenu(temsilci);
						frameT.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null,"Kullanici Adi veya Sifre hatali","Hata",JOptionPane.OK_OPTION);
					}
				}
			});
	}
	

}

import java.util.ArrayList;

public class Musteri {
	private int Id;
	private String adSoyad;
	private String sifre;
	private String telefon;
	private String adres;
	private String e_posta;
	private String kullaniciAdi;
	private String TCNO;
	public ArrayList<Hesap> hesaplar=new ArrayList<>();
	public Musteri() {
		
	}
	public Musteri(int id,String adSoyad, String sifre, String telefon, String adres, String e_posta, String kullaniciAdi,String TCNO) {
		super();
		this.Id=id;
		this.adSoyad = adSoyad;
		this.sifre = sifre;
		this.telefon = telefon;
		this.adres = adres;
		this.e_posta = e_posta;
		this.kullaniciAdi = kullaniciAdi;
		this.TCNO=TCNO;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getTCNO() {
		return TCNO;
	}
	public void setTCNO(String tCNO) {
		TCNO = tCNO;
	}
	public String getAdSoyad() {
		return adSoyad;
	}
	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public String getE_posta() {
		return e_posta;
	}
	public void setE_posta(String e_posta) {
		this.e_posta = e_posta;
	}
	public String getKullaniciAdi() {
		return kullaniciAdi;
	}
	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}
}

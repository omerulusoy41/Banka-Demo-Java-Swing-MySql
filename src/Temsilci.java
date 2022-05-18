import java.util.ArrayList;

public class Temsilci {
	private int id;
	private String adSoyad;
	private String kullaniciAdi;
	private String sifre;
	private float maas;
	ArrayList<Musteri> musteriler;
	public Temsilci() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKullaniciAdi() {
		return kullaniciAdi;
	}
	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	public float getMaas() {
		return maas;
	}
	public void setMaas(float maas) {
		this.maas = maas;
	}
	public String getAdSoyad() {
		return adSoyad;
	}
	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}
	

}

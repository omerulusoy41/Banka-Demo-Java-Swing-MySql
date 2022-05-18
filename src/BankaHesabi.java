import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BankaHesabi {
	private Sorgular sorgu=new Sorgular(); 
	private float bakiye;
	private float gelir;
	private float gider;
	private float kar;
	private float krediFaizi;
	private float gecikmeFaizi;
	private int kacAy;
	private String tarih;
	private int kacAyIleride;
	public int getKacAyIleride() {
		return kacAyIleride;
	}
	public void setKacAyIleride(int kacAyIleride) {
		this.kacAyIleride = kacAyIleride;
	}
	public static BankaHesabi bankaHesabi;
	private BankaHesabi() {
		
	}
	public static BankaHesabi getBankaHesabi() {
	
		if(bankaHesabi==null) {
			bankaHesabi=new BankaHesabi();
		}
		return bankaHesabi;
	}
	public String getTarih() {
		return tarih;
	}
	public void setTarih(String tarih) {
		this.tarih = tarih;
	}
	public float getBakiye() {
		return bakiye;
	}
	public void setBakiye(float bakiye) {
		this.bakiye = bakiye;
	}
	public float getGelir() {
		return gelir;
	}
	public void setGelir(float gelir) {
		this.gelir = gelir;
	}
	public float getGider() {
		return gider;
	}
	public void setGider(float gider) {
		this.gider = gider;
	}
	public float getKar() {
		return kar;
	}
	public void setKar(float kar) {
		this.kar = kar;
	}
	public float getKrediFaizi() {
		return krediFaizi;
	}
	public void setKrediFaizi(float krediFaizi) {
		this.krediFaizi = krediFaizi;
	}
	public float getGecikmeFaizi() {
		return gecikmeFaizi;
	}
	public void setGecikmeFaizi(float gecikmeFaizi) {
		this.gecikmeFaizi = gecikmeFaizi;
	}
	public int getKacAy() {
		return kacAy;
	}
	public void setKacAy(int kacAy) {
		this.kacAy = kacAy;
	}
	
}

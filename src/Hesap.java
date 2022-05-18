
public class Hesap {
	private int id;
	private float bakiye;
	private float gelir;
	private float gider;
	private String paraBirimi;
	private float toplamKrediBorcu;
	private float aylikKrediBorcu;
	private String krediCekmeTarihi;
	private int kacAyOdendi;
	public Hesap() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getParaBirimi() {
		return paraBirimi;
	}
	public void setParaBirimi(String paraBirimi) {
		this.paraBirimi = paraBirimi;
	}
	public float getToplamKrediBorcu() {
		return toplamKrediBorcu;
	}
	public void setToplamKrediBorcu(float toplamKrediBorcu) {
		this.toplamKrediBorcu = toplamKrediBorcu;
	}
	public float getAylikKrediBorcu() {
		return aylikKrediBorcu;
	}
	public void setAylikKrediBorcu(float aylikKrediBorcu) {
		this.aylikKrediBorcu = aylikKrediBorcu;
	}
	public String getKrediCekmeTarihi() {
		return krediCekmeTarihi;
	}
	public void setKrediCekmeTarihi(String krediCekmeTarihi) {
		this.krediCekmeTarihi = krediCekmeTarihi;
	}
	public int getKacAyOdendi() {
		return kacAyOdendi;
	}
	public void setKacAyOdendi(int kacAyOdendi) {
		this.kacAyOdendi = kacAyOdendi;
	}	
	
}

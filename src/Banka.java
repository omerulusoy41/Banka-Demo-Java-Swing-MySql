import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class Banka {
	private Sorgular sorgu=new Sorgular(); 
	public String[] paraBirimleri;
	public int paraBirimSayisi=0;
	public BankaHesabi bankaHesabi;

	public static Banka banka;
	private Banka() {
		paraBirimleri=sorgu.paraBirimleriDon();
		bankaHesabi=BankaHesabi.getBankaHesabi();
		sorgu.bankaHesapBilgileriDon(bankaHesabi);
		bankaHesabi.setKacAyIleride(kacAyIleride());
		for(int i=0;i<paraBirimleri.length;i++) {
			if(paraBirimleri[i]==null) {
				paraBirimSayisi=i;
				break;
			}
		}
		
	}
	public static Banka getBanka() {
		if(banka==null) {
			banka=new Banka();
		}
		return banka;
	}
	private int kacAyIleride() {
		int ay=0;
		String bankaTarihi=bankaHesabi.getTarih();
		String[] arr1=bankaTarihi.split("/");
		int gun1=Integer.parseInt(arr1[0]);
		int ay1=Integer.parseInt(arr1[1]);
		int yil1=Integer.parseInt(arr1[2]);
		
		SimpleDateFormat format =new SimpleDateFormat("dd/MM/yyyy");
		Date date=new Date();
		String anlikTarih=format.format(date);
		String[] arr2=anlikTarih.split("/");
		int gun2=Integer.parseInt(arr2[0]);
		int ay2=Integer.parseInt(arr2[1]);
		int yil2=Integer.parseInt(arr2[2]);
		
		LocalDate t1=LocalDate.of(yil1,ay1,gun1);
		LocalDate t2=LocalDate.of(yil2, ay2,gun2);
		Period period=Period.between(t2,t1);
		ay+=period.getMonths();
		ay+=(12*period.getYears());
		return ay;
	}
}

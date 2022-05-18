import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class Sorgular {
	private Connection connect=DataBaseBaglanti.connect;
	public Musteri musteriGirisKontrol(String kText,String sText) {
		Statement state;
		Musteri musteri=null;
		try {
			state = connect.createStatement();
			ResultSet result= state.executeQuery("Select * from musteri");
			String dKullaniciAdi;
			String dSifre;
			while(result.next()) {
				dKullaniciAdi=result.getString("kullaniciadi");
				dSifre=result.getString("sifre");
				if(dKullaniciAdi.compareTo(kText)==0 && dSifre.compareTo(sText)==0) {
					musteri=new Musteri();
					musteri.setId(result.getInt("idmusteri"));
					musteri.setAdSoyad(result.getString("adSoyad"));
					musteri.setSifre(dSifre);
					musteri.setKullaniciAdi(dKullaniciAdi);
					musteri.setAdres(result.getString("adres"));
					musteri.setE_posta(result.getString("e_posta"));
					musteri.setTelefon(result.getString("telefon"));
					musteri.setTCNO(result.getString("TCNO"));
					return musteri;
				}
			}
			state.close();
			result.close();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return musteri;
	}
	public Temsilci temsilciGirisKontrol(String kText,String sText) {
		Statement state;
		Temsilci temsilci=null;
		try {
			state = connect.createStatement();
			ResultSet result=state.executeQuery("select * from temsilci");
			while(result.next()) {
				String dKullaniciAdi=result.getString("kullaniciadi");
				String dSifre=result.getString("sifre");
				if(dKullaniciAdi.compareTo(kText)==0 && dSifre.compareTo(sText)==0) {
					temsilci=new Temsilci();
					temsilci.setId(result.getInt("idtemsilci"));
					temsilci.setKullaniciAdi(dKullaniciAdi);
					temsilci.setMaas(result.getFloat("maas"));
					temsilci.setAdSoyad(result.getString("adSoyad"));
					return temsilci;
				}
			}
			state.close();
			result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temsilci;
	}
	public Mudur mudurGirisKontrol(String kText,String sText) {
		Statement state;
		Mudur mudur=null;
		try {
			state = connect.createStatement();
			ResultSet result= state.executeQuery("Select * from mudur");
			String dKullaniciAdi;
			String dSifre;
			while(result.next()) {
				dKullaniciAdi=result.getString("kullaniciadi");
				dSifre=result.getString("sifre");
				if(dKullaniciAdi.compareTo(kText)==0 && dSifre.compareTo(sText)==0) {
					mudur=new Mudur();
					mudur.setId(result.getInt("idmudur"));
					mudur.setAdSoyad(result.getString("adsoyad"));
					mudur.setKullaniciAdi(dKullaniciAdi);
					mudur.setSifre(dSifre);
					return mudur;
				}
			}
			state.close();
			result.close();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return mudur;
	}
	public void hesaplariDon(Musteri musteri,int temsilciId) {
		int[] hesapId=new int[10];
		int i=0;
		try {
			Statement state=connect.createStatement();
			// Musteriye ait hesap Bilgilerini don
			ResultSet result=state.executeQuery("Select Distinct * from hesapalma where musteriId="+musteri.getId());
			while(result.next()) {
				hesapId[i]=result.getInt("hesapId");
				i++;
			}
			state.close();
			result.close();
			musteri.hesaplar=null;
			if(i==0) { 
				return;
			}
			musteri.hesaplar=new ArrayList<Hesap>();
			state=connect.createStatement();
			String inCumlecigi="";
			for(int x=0;x<i;x++) {
				if(i==x+1) {
					inCumlecigi+=hesapId[x];
				}else
					inCumlecigi+=hesapId[x]+",";
			}
			result=state.executeQuery("Select * from hesap where idhesap IN("+inCumlecigi+")");
			while(result.next()) {
					int id=result.getInt("idhesap");
					// temsilci Id nin 0 dan farkli olmasi gelen istegin temsilciden oldugunu gosterir
					if(!hesapSilmeIstegiVarmi(id) || temsilciId!=0) {
						Hesap hesap=new Hesap();
						hesap.setId(id);
						hesap.setBakiye(result.getFloat("bakiye"));
						hesap.setGelir(result.getFloat("gelir"));
						hesap.setGider(result.getFloat("gider"));
						hesap.setToplamKrediBorcu(result.getFloat("toplamKrediBorcu"));
						hesap.setAylikKrediBorcu(result.getFloat("aylikKrediBorcu"));
						hesap.setParaBirimi(result.getString("parabirimi"));
						hesap.setKrediCekmeTarihi(result.getString("krediCekmeTarihi"));
						hesap.setKacAyOdendi(result.getInt("kacAyOdedi"));
						musteri.hesaplar.add(hesap);
					}
					
			}
			result.close();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ;
	}
	public void hesapAc(String pb,int musteriId) {
		String sql="insert into Hesap(bakiye,gelir,gider,parabirimi,toplamkrediborcu,aylikkrediborcu)"
				+ "values(0,0,0,"+"\""+pb+ "\","+"0,0)";
		try {
			PreparedStatement state=connect.prepareStatement(sql);
			state.executeUpdate();
			state.close();
			sql="select idhesap from hesap where idhesap>=all(select idhesap from hesap)";
			Statement yeniState=connect.createStatement();
			ResultSet result=yeniState.executeQuery(sql);
			result.next();
			int id=result.getInt("idhesap");
			yeniState.close();
			result.close();
			sql="insert into hesapalma(hesapId,musteriId) values("+id+","+musteriId+")";
			state=connect.prepareStatement(sql);
			state.executeUpdate();
			JOptionPane.showMessageDialog(null,"Hesap acma  Basarili","",JOptionPane.INFORMATION_MESSAGE);
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean kisiselBilgiGuncelle(String kolon,String veri,String TCNO) {
		String sql="update musteri set "+kolon+" = \""+veri+"\""+" where TCNO="+TCNO;
		try {
			PreparedStatement state=connect.prepareStatement(sql);
			if(state.executeUpdate()==1) {
				return true;
			}
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public void hesapSil(int musteriId,int hesapId) {
		try {
				String sql="delete from hesapalma where musteriId="+musteriId+" and hesapId="+hesapId;
				PreparedStatement state=connect.prepareStatement(sql);
				state.executeUpdate();
				state.close();
				sql="delete from hesap where idhesap="+hesapId;
				state=connect.prepareStatement(sql);
				state.executeUpdate();
				state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void bakiyeGuncelle(float bakiye,int hesapId) {
		String sql="update hesap set bakiye="+bakiye+" where idhesap="+hesapId;
		try {
			PreparedStatement state=connect.prepareStatement(sql);
			state.executeUpdate();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void islemYaz(int hesapId2,float tutar,float kaynakBakiye,float hedefBakiye,String icerik,int hesapId,int musteriId) {
		String sql="insert into islem(hesapid1,hesapid2,icerik,tutar,kaynakBakiye,hedefBakiye,tarih,musteriId) values"
				+ "(?,?,?,?,?,?,?,?)";
		try {
			Banka banka=Banka.getBanka();
			PreparedStatement state=connect.prepareStatement(sql);
			state.setInt(1,hesapId);
			state.setInt(2, hesapId2);
			state.setString(3,icerik);
			state.setFloat(4, tutar);
			state.setFloat(5,kaynakBakiye);
			state.setFloat(6,hedefBakiye);
			state.setString(7,banka.bankaHesabi.getTarih());
			state.setInt(8,musteriId);
			state.executeUpdate();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Object[][] islemOzetiDon(int hesapId,int musteriId,int x){
		Object[][] colonBilgileri=new Object[100][8];
		try {
			Statement state=connect.createStatement();
			ResultSet result;
			int i=0;
			if(hesapId==0 && musteriId==0) {
				result=state.executeQuery("select  * from islem order by idislem desc limit "+x);
				while(result.next()) {
					colonBilgileri[i][0]=result.getObject("idislem");
					int hesapId1=result.getInt("hesapId1");
					int hesapId2=result.getInt("hesapId2");
					if(hesapId1==0) {
						colonBilgileri[i][1]="Banka";
					}else if(hesapId1==-1){
						colonBilgileri[i][1]="EL";
					}else {
						colonBilgileri[i][1]=hesapId1;
					}
					if(hesapId2==0) {
						colonBilgileri[i][2]="Banka";
					}else if(hesapId2==-1) {
						colonBilgileri[i][2]="EL";
					}else {
						colonBilgileri[i][2]=hesapId2;
					}
					colonBilgileri[i][3]=result.getObject("tutar");
					colonBilgileri[i][4]=result.getObject("icerik");
					colonBilgileri[i][5]=result.getObject("kaynakBakiye");
					colonBilgileri[i][6]=result.getObject("hedefBakiye");
					colonBilgileri[i][7]=result.getObject("tarih");
					i++;
				}
			}else {
				result=state.executeQuery("select  * from islem");
				while(result.next()) {
					int id1=result.getInt("hesapId1");
					int id2=result.getInt("hesapId2");
				    if(hesapId==0) {
						if(musteriId==result.getInt("musteriId")) {
							colonBilgileri[i][0]=result.getObject("idislem");
							if(id1==0) {
								colonBilgileri[i][1]="Banka";
							}else if(id1==-1) {
								colonBilgileri[i][1]="EL";
							}
							else {
								colonBilgileri[i][1]=id1;
							}
							if(id2==0) {
								colonBilgileri[i][2]="Banka";
							}else if(id2==-1) {
								colonBilgileri[i][2]="El";
							}
							else {
								colonBilgileri[i][2]=id2;
							}
							colonBilgileri[i][3]=result.getObject("tutar");
							colonBilgileri[i][4]=result.getObject("icerik");
							colonBilgileri[i][5]=result.getObject("kaynakBakiye");
							colonBilgileri[i][6]=result.getObject("hedefBakiye");
							colonBilgileri[i][7]=result.getObject("tarih");
							i++;
						}
					}else {
						if(id1==hesapId || id2==hesapId) {
							colonBilgileri[i][0]=result.getObject("idislem");
							if(id1==0) {
								colonBilgileri[i][1]="Banka";
							}else if(id1==-1) {
								colonBilgileri[i][1]="EL";
							}
							else {
								colonBilgileri[i][1]=id1;
							}
							if(id2==0) {
								colonBilgileri[i][2]="Banka";
							}else if(id2==-1) {
								colonBilgileri[i][2]="EL";
							}
							else {
								colonBilgileri[i][2]=id2;
							}
							colonBilgileri[i][3]=result.getObject("tutar");
							colonBilgileri[i][4]=result.getObject("icerik");
							colonBilgileri[i][5]=result.getObject("kaynakBakiye");
							colonBilgileri[i][6]=result.getObject("hedefBakiye");
							colonBilgileri[i][7]=result.getObject("tarih");
							i++;
						}
					}
				}
			}
			result.close();
			state.close();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return colonBilgileri;
	}
	public void transferEdilecekHesabiAyarla(Hesap hesap) {
		try {
			Statement state=connect.createStatement();
			ResultSet result=state.executeQuery("select * from hesap where idhesap="+hesap.getId());
			result.next();
			hesap.setBakiye(result.getFloat("bakiye"));
			hesap.setGelir(result.getFloat("gelir"));
			hesap.setGider(result.getFloat("gider"));
			hesap.setToplamKrediBorcu(result.getFloat("toplamKrediBorcu"));
			hesap.setAylikKrediBorcu(result.getFloat("aylikKrediBorcu"));
		    hesap.setParaBirimi(result.getString("parabirimi"));
			result.close();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Hesap kullanicilarArasiHesabiDon(int TC) {
		Hesap tmpHesap=new Hesap();
		Statement state;
		try {
			state = connect.createStatement();
			ResultSet result=state.executeQuery("select idmusteri from musteri where TCNO="+TC);
			result.next();
			int idMusteri=result.getInt("idmusteri");
			state.close();
			result.close();
			state=connect.createStatement();
			result=state.executeQuery("select * from hesapAlma where musteriId="+idMusteri);
			result.next();
			int hesapId=result.getInt("hesapId");
			state.close();
			result.close();
			state=connect.createStatement();
			result=state.executeQuery("select * from hesap where idhesap="+hesapId);
			result.next();
			tmpHesap.setId(result.getInt("idhesap"));
			tmpHesap.setBakiye(result.getFloat("bakiye"));
			tmpHesap.setParaBirimi(result.getString("paraBirimi"));
			state.close();
			result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmpHesap;
	}
	public void musterileriDon(Temsilci temsilci) {
		int[] musteriId=new int[10];
		try {
			Statement state=connect.createStatement();
			ResultSet result=state.executeQuery("select Distinct musteriId from temsilEtme where temsilciid="+temsilci.getId());
			int i=0;
			while(result.next()) {
				musteriId[i]=result.getInt("musteriId");
				i++;
			}
			state.close();
			result.close();
			temsilci.musteriler=null;
			if(i==0) {
				return ;
			}
			temsilci.musteriler=new ArrayList<Musteri>();
			state=connect.createStatement();
			String inCumlecigi="";
			for(int x=0;x<i;x++) {
				if(i==x+1) {
					inCumlecigi+=musteriId[x];
				}else
					inCumlecigi+=musteriId[x]+",";
			}
			result=state.executeQuery("select * from musteri where idmusteri IN("+inCumlecigi+")");
			i=0;
			while(result.next()) {
				Musteri musteri=new Musteri();
				musteri.setAdSoyad(result.getString("adSoyad"));
				musteri.setId(result.getInt("idmusteri"));
				musteri.setAdres(result.getString("adres"));
				musteri.setE_posta(result.getString("e_posta"));
				musteri.setTelefon(result.getString("telefon"));
				musteri.setTCNO(result.getString("TCNO"));
				temsilci.musteriler.add(musteri);
				i++;
			}
			result.close();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ;
	}
	public void musteriSil(int musteriId) {
		try {
			PreparedStatement state=connect.prepareStatement("delete from hesapalma where musteriId="+musteriId);
			state.executeUpdate();
			state.close();
			state=connect.prepareStatement("delete from temsilEtme where musteriId="+musteriId);
			state.executeUpdate();
			state.close();
			state=connect.prepareStatement("delete from musteri where idmusteri="+musteriId);
			state.executeUpdate();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean musteriEkle(Musteri musteri,int temsilciId) {
		Musteri tmpMusteri=musteri;
		if(MusteriEklemeKontrol(tmpMusteri.getKullaniciAdi(),tmpMusteri.getTCNO())) {
			try {
				PreparedStatement state=connect.prepareStatement
				("insert into musteri(adSoyad,sifre,telefon,adres,e_posta,TCNO,kullaniciadi) values(?,?,?,?,?,?,?)");
				state.setString(1,musteri.getAdSoyad());
				state.setString(2,musteri.getSifre());
				state.setString(3,musteri.getTelefon());
				state.setString(4,musteri.getAdres());
				state.setString(5,musteri.getE_posta());
				state.setString(6,musteri.getTCNO());
				state.setString(7,musteri.getKullaniciAdi());
				state.executeUpdate();
				state.close();
				Statement state2=connect.createStatement();
				ResultSet result=state2.executeQuery("select max(idmusteri) as 'maxid' from musteri");
				result.next();
				int musteriId=result.getInt("maxid");
				state2.close();
				result.close();
				if(temsilciId!=0) {//TEmsilci id kontrolu gelen istegin temsilcidenmi mudurdenmi oldugunu belirler.
					state=connect.prepareStatement("insert into temsiletme(musteriId,temsilciId) values(?,?)");
					state.setInt(1, musteriId);
					state.setInt(2, temsilciId);
					state.executeUpdate();
					state.close();
				}else {
					String hicOlmayan="select idtemsilci from temsilci where idtemsilci!=all(select temsilciid from temsiletme)";
					String enAziBulma=
					"SELECT temsilciid,count(musteriid) from temsiletme "+
					"group by temsilciid "+
					"having count(musteriid)<=all(select count(musteriid) from temsiletme "+
					"group by temsilciid) "; 
					 state2=connect.createStatement();
					 result=state2.executeQuery(hicOlmayan);
					 if(result.next()) {
					 temsilciId=result.getInt("idtemsilci");
					 }else {
					    result.close();
					    state2.close();
					    state2=connect.createStatement();
						result=state2.executeQuery(enAziBulma);
						result.next();
						temsilciId=result.getInt("temsilciId");
					 }
					 state2.close();
				     result.close();
					 state=connect.prepareStatement("insert into temsiletme(musteriId,temsilciId) values(?,?)");
					 state.setInt(1, musteriId);
					 state.setInt(2, temsilciId);
					 state.executeUpdate();
					 state.close();
				}
		  	} catch (SQLException e1) {
					e1.printStackTrace();
			}
			return true;
		}
		return false;
	}
	public boolean MusteriEklemeKontrol(String kullaniciAdi,String TCNO){
		try {
			Statement state=connect.createStatement();
			ResultSet result=state.executeQuery("select kullaniciAdi,TCNO from musteri");
			while(result.next()) {
				if(result.getString("kullaniciAdi").compareTo(kullaniciAdi)==0) {
					JOptionPane.showMessageDialog(null,"Kullanici Adi Sistemde Mevcut","",JOptionPane.INFORMATION_MESSAGE);
					return false;
				}else if(result.getString("TCNO").compareTo(TCNO)==0) {
					JOptionPane.showMessageDialog(null,"Bu kullanici sistemde mevcut","",JOptionPane.INFORMATION_MESSAGE);
					return false;
				}
			}
			result.close();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	public void maasGuncelle(float maas) {
		try {
			PreparedStatement state=connect.prepareStatement("update temsilci set maas="+maas);
			state.executeUpdate();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String[] paraBirimleriDon(){
		String[] pb=new String[10];
		Statement state;
		try {
			state = connect.createStatement();
			ResultSet result=state.executeQuery("select * from paraBirimleri");
			int i=0;
			while(result.next()) {
				pb[i]=result.getString("parabirimi");
				i++;
			}
			result.close();
			state.close();
			return pb;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pb;
	}
	public float kurDon(String pb) {
		
		try {
			Statement state=connect.createStatement();
			ResultSet result=state.executeQuery("select kur from paraBirimleri where paraBirimi='"+pb+"'");
			result.next();
			return result.getFloat("kur");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0 ;
	}
	public void yeniPbEkle(String pb,float kur) {
		try {
			PreparedStatement state=connect.prepareStatement("insert into paraBirimleri(parabirimi,kur) values(?,?)");
			state.setString(1,pb);
			state.setFloat(2,kur);
			state.executeUpdate();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void kurGuncelle(String pb,float kur) {
		try {
			PreparedStatement state=connect.prepareStatement("update parabirimleri set kur="+kur+"where parabirimi='"+pb+"'");
			state.executeUpdate();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void bankaHesapBilgileriDon(BankaHesabi bankaHesabi) {
		try {
			Statement state=connect.createStatement();
			ResultSet result=state.executeQuery("select * from bankaHesabi");
			result.next();
			bankaHesabi.setBakiye(result.getFloat("bakiye"));
			bankaHesabi.setGelir(result.getFloat("gelir"));
			bankaHesabi.setGider(result.getFloat("gider"));
			bankaHesabi.setKacAy(result.getInt("kacay"));
			bankaHesabi.setKar(result.getFloat("kar"));
			bankaHesabi.setKrediFaizi(result.getFloat("krediFaizi"));
			bankaHesabi.setGecikmeFaizi(result.getFloat("gecikmefaizi"));
			bankaHesabi.setTarih(result.getString("tarih"));
			result.close();
			state.close();
			if(bankaHesabi.getTarih()==null) {
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				Date date=new Date();
				bankaHesabi.setTarih(format.format(date));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void hesapAcmaAsamasiAyarla(String pb,int musteriId) {
		try {
			String sql="update temsiletme set hesapAcmaistegi=1,parabirimi='"+pb+"' where musteriId="+musteriId;
			PreparedStatement state=connect.prepareStatement(sql);
			state.executeUpdate();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String hesapAcmaIstegiVarmi(int musteriId) {
		String pb="";
		try {
			Statement state=connect.createStatement();
			ResultSet result=state.executeQuery("select * from temsilEtme where musteriId="+musteriId);
			result.next();
			if(result.getInt("hesapAcmaistegi")==1) {
				pb=result.getString("parabirimi");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return pb;
	}
	public void hesapAcmaSifirla(int musteriId) {
		try {
			String sql="update temsiletme set hesapAcmaIstegi=0,parabirimi=null where musteriId="+musteriId;
			PreparedStatement state=connect.prepareStatement(sql);
			state.executeUpdate();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean hesapSilmeIstegiVarmi(int hesapId) {
		
		try {
			Statement state=connect.createStatement();
			ResultSet result=state.executeQuery("select silinecekmi from hesapalma where hesapId="+hesapId);
			
			if(result.next() && result.getInt("silinecekmi")==1  ) {
				return true;
			}
			result.close();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public void hesapSilmeAsamasiAyarla(int hesapId) {
		try {
			PreparedStatement state=connect.prepareStatement("update hesapalma set silinecekmi=1 where hesapId="+hesapId);
			state.executeUpdate();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void hesapSilmeSifirla(int hesapId) {
		try {
			PreparedStatement state=connect.prepareStatement("update hesapalma set silinecekmi=0 where hesapId="+hesapId);
			state.executeUpdate();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void krediMiktariAyarla(Hesap hesap) {

		try {
			Statement state;
			state = connect.createStatement();
			ResultSet result=state.executeQuery("select krediIstegi from hesapalma where hesapId="+hesap.getId());
			result.next();
			float kredi=result.getFloat("krediIstegi");
			result.close();
			state.close();
			
			Banka banka=Banka.getBanka();
			float faiz=banka.bankaHesabi.getKrediFaizi();
			float miktar=kredi;
			kredi=miktar+(miktar*faiz);
			hesap.setToplamKrediBorcu(hesap.getToplamKrediBorcu()+kredi);
			PreparedStatement state2=connect.prepareStatement("update hesap set toplamkrediBorcu="+hesap.getToplamKrediBorcu()+" where idhesap="+hesap.getId());
			state2.executeUpdate();
			state2.close();
			
			banka.bankaHesabi.setBakiye(banka.bankaHesabi.getBakiye()-miktar);
			banka.bankaHesabi.setGider(banka.bankaHesabi.getGider()+miktar);
			banka.bankaHesabi.setKar(banka.bankaHesabi.getGelir()-banka.bankaHesabi.getGider());
			bankaBilgileriGuncelle(banka);

			float aylik=kredi/banka.bankaHesabi.getKacAy();
			hesap.setAylikKrediBorcu(hesap.getAylikKrediBorcu()+aylik);
			state2=connect.prepareStatement("update hesap set aylikkrediBorcu="+hesap.getAylikKrediBorcu()+" where idhesap="+hesap.getId());
			state2.executeUpdate();
			state2.close();
			
			if(hesap.getParaBirimi().compareTo("TL")!=0) {
				float kur=kurDon(hesap.getParaBirimi());
			    hesap.setBakiye(hesap.getBakiye()+(miktar/kur));
			    hesap.setGelir(hesap.getGelir()+(miktar/kur));
			}else {
				hesap.setBakiye(hesap.getBakiye()+miktar);
				hesap.setGelir(hesap.getGelir()+miktar);
			}
			state2=connect.prepareStatement("update hesap set bakiye="+hesap.getBakiye()+" where idhesap="+hesap.getId());
			state2.executeUpdate();
			state2.close();
			
			
			
			state2=connect.prepareStatement("update hesap set gelir="+miktar+" where idhesap="+hesap.getId());
			state2.executeUpdate();
			state2.close();
			gelirGiderGuncelle(hesap,1);

		    state2=connect.prepareStatement("update hesap set krediCekmeTarihi='"+banka.bankaHesabi.getTarih()+"' where idhesap="+hesap.getId());
		    state2.executeUpdate();
		    state2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void krediIstegiAsamasiAyarla(int hesapId,float kredi) {
		try {
			PreparedStatement state=connect.prepareStatement("update hesapalma set krediIstegi="+kredi+" where hesapId="+hesapId);
			state.executeUpdate();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean krediIstegiVarmi(int hesapId) {

		try {
			Statement state=connect.createStatement();
			ResultSet result=state.executeQuery("select krediIstegi from hesapalma where hesapId="+hesapId);
			result.next();
			if(result.getInt("krediIstegi")!=0) {
				return true;
			}
			result.close();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public void krediIstegiSifirla(int hesapId) {
		try {
			PreparedStatement state=connect.prepareStatement("update hesapalma set krediIstegi=0 where hesapId="+hesapId);
			state.executeUpdate();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void krediFaiziGuncelle(float deger) {
		try {
			PreparedStatement state=connect.prepareStatement("update bankaHesabi set krediFaizi="+deger);
			state.executeUpdate();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void gecikmeFaiziGuncelle(float deger) {
		try {
			PreparedStatement state=connect.prepareStatement("update bankaHesabi set gecikmeFaizi="+deger);
			state.executeUpdate();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void kacAyGuncelle(int deger) {
		try {
			PreparedStatement state=connect.prepareStatement("update bankaHesabi set kacAy="+deger);
			state.executeUpdate();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void krediOde(int a,Hesap hesap){
		try {
			PreparedStatement state;
			Banka banka=Banka.getBanka();
			if(a==1) {
				state=connect.prepareStatement("update hesap set toplamKrediBorcu=0,aylikKrediBorcu=0,kacAyOdedi=0 where idhesap="+hesap.getId());
				banka.bankaHesabi.setBakiye(banka.bankaHesabi.getBakiye()+hesap.getToplamKrediBorcu());
				banka.bankaHesabi.setGelir(banka.bankaHesabi.getGelir()+hesap.getToplamKrediBorcu());
				banka.bankaHesabi.setKar(banka.bankaHesabi.getGelir()-banka.bankaHesabi.getGider());
				
			}else {
				float tkb=(hesap.getToplamKrediBorcu()-hesap.getAylikKrediBorcu());
				String ek="";
				if(tkb==0) {
					ek=",aylikKrediBorcu=0";
				}
				hesap.setKacAyOdendi(hesap.getKacAyOdendi()+1);
			    state=connect.prepareStatement("update hesap set toplamKrediBorcu="+
				tkb+ek+" ,kacAyodedi="+hesap.getKacAyOdendi()
						+ " where idhesap="+hesap.getId());
			    banka.bankaHesabi.setBakiye(banka.bankaHesabi.getBakiye()+hesap.getAylikKrediBorcu());
			    banka.bankaHesabi.setGelir(banka.bankaHesabi.getGelir()+hesap.getAylikKrediBorcu());
				banka.bankaHesabi.setKar(banka.bankaHesabi.getGelir()-banka.bankaHesabi.getGider());
			}
			bankaBilgileriGuncelle(banka);
			state.executeUpdate();
			state.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	public void gelirGiderGuncelle(Hesap hesap,int x) {
		try {
			PreparedStatement state;
			String sql="update hesap set ";
			if(x==1)
				state=connect.prepareStatement(sql+"gelir="+hesap.getGelir()+" where idhesap="+hesap.getId());
			else {
				state=connect.prepareStatement(sql+"gider="+hesap.getGider()+" where idhesap="+hesap.getId());
			}
			state.executeUpdate();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void bankaBilgileriGuncelle(Banka banka) {
		String sql="update bankaHesabi set tarih='"+banka.bankaHesabi.getTarih()+"',bakiye="+banka.bankaHesabi.getBakiye()+
				" ,gelir="+banka.bankaHesabi.getGelir()+" ,gider="+banka.bankaHesabi.getGider()+
				" ,kar="+banka.bankaHesabi.getKar();
		try {
			PreparedStatement state=connect.prepareStatement(sql);
			state.executeUpdate();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void gecikmeEkle(Hesap hesap,float eklenecek) {
		hesap.setToplamKrediBorcu(hesap.getToplamKrediBorcu()+eklenecek);
		hesap.setKacAyOdendi(hesap.getKacAyOdendi()+1);
		try {
			PreparedStatement state=connect.prepareStatement("update hesap set toplamKrediBorcu="+hesap.getToplamKrediBorcu()
					+",kacAyOdedi="+hesap.getKacAyOdendi()
					+ " where idhesap="+hesap.getId());
			state.executeUpdate();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	public void guncellenmisHesap(Hesap hesap) {
		Statement state;
		try {
			state = connect.createStatement();
			ResultSet result=state.executeQuery("Select * from hesap where idhesap="+hesap.getId());
			result.next();
			hesap.setBakiye(result.getFloat("bakiye"));
			hesap.setGelir(result.getFloat("gelir"));
			hesap.setGider(result.getFloat("gider"));
			hesap.setToplamKrediBorcu(result.getFloat("toplamKrediBorcu"));
			hesap.setAylikKrediBorcu(result.getFloat("aylikKrediBorcu"));
		    hesap.setParaBirimi(result.getString("parabirimi"));
			result.close();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}

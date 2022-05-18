import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		DataBaseBaglanti bagla=new DataBaseBaglanti();
		try {
			Connection connect=bagla.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Banka.banka=Banka.getBanka();
		form1 frame=new form1();
		frame.giris();
		frame.setVisible(true);
		
		
	}

}

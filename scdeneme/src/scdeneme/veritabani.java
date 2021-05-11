package scdeneme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;



public class veritabani {
	static String url = "jdbc:mysql://localhost:3306/test";
	static String username = "root";
	static String password = "samet";
	static Connection conn = null;

	static boolean baglan() {

		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("veri tabanı bağlandı");
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("hata");
			return false;
		}
	}

	static ResultSet listele(String sorgu) {// listele
		Statement st;
		ResultSet rs;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sorgu);
			return rs;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}

	}

	static void kaydet(String sorgu) { // kayıt
		Statement st;
		try {
			st = conn.createStatement();
			st.executeUpdate(sorgu);
			System.out.println("kayıt başarılı");

		} catch (SQLException e) {
			
			if(e instanceof MySQLIntegrityConstraintViolationException) {
				String errorMessage = "AYNI STOK KODU İLE KAYIT EKLENEMEZ";
				JOptionPane.showMessageDialog(null, errorMessage);
			}
			e.printStackTrace();
		}
	}

	static void duzenle(String sorgu) {// düzenle
		Statement st;
		try {
			st = conn.createStatement();
			st.executeUpdate(sorgu);
			System.out.println("Düzenleme başarılı");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static void sil(String sorgu) {// sil
		Statement st;
		try {
			st = conn.createStatement();
			st.executeUpdate(sorgu);
			System.out.println("Silme işlemi başarılı");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static ResultSet ara(String sorgu) {// ara
		Statement st;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;

	}

}

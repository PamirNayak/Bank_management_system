package bank.management.system;

import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Connectionn {
	Connection con;
//	PreparedStatement pst=null;
	Statement st;
	ResultSet rs;
	public Connectionn(){
		Properties p=new Properties();
		FileInputStream fin=null;
		try {
		    fin=new FileInputStream("D:\\jdbcproperties\\jdbc.properties");
			p.load(fin);
			Class.forName(p.getProperty("driverClass"));
			con=DriverManager.getConnection(p.getProperty("url"), p);
			st=con.createStatement();	
		} catch (IOException|ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(fin !=null) {
				try {
					fin.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
	}
}

package com.abc.model;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Part;
public class Model {
//	List al;
	Map p;
	private Connection conn;
	private String singer;
	private String song_link;
	private String first_name;
	private String last_name;
	private String password;
	private String email;
	private long phone;
	private Part photo;
	private String song_name;
	
	private PreparedStatement pstmt;


	private ResultSet rs;
	
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long number) {
		this.phone = number;
	}
	public Part getPhoto() {
		return photo;
	}
	public void setPhoto(Part photo) {
		this.photo = photo;
	}
	
	public String getSinger() {
		return singer;
	}
	public String getSong_link() {
		return song_link;
	}
	public void setSong_link(String song_link) {
		this.song_link = song_link;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public Model()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc_tracker", "root", "password,12345");

		} catch (ClassNotFoundException | SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public boolean register()
	{
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO music values(?,?,?,?,?,?)");
			pstmt.setString(1, first_name);
			pstmt.setString(2, last_name);
			pstmt.setString(3,password);
			pstmt.setString(4,email);
			pstmt.setLong(5,phone);
			InputStream is = photo.getInputStream();
			pstmt.setBlob(6,is);
			int m=pstmt.executeUpdate();
			if(m==1)
			{
				return true;
			}
		} 
		catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return false;	
	}
	public boolean login(String email,String pw)
	{
		try {
			pstmt = conn.prepareStatement("Select * from music where email=? AND password=?");
			pstmt.setString(1, email);
			pstmt.setString(2,pw);
			rs=pstmt.executeQuery();
			System.out.println("True");
			if(rs.next())
			{
				
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return false;	
	}
	public boolean retrieve(String singer) {
		
		 try {
			pstmt = conn.prepareStatement("SELECT * FROM SINGER WHERE SINGER_NAME=?");
			pstmt.setString(1, singer);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				song_link=rs.getString(2);
				song_name=rs.getString(3);
				if(p==null)
				{
				p=new LinkedHashMap();
					
				}
				p.put(song_name,song_link);
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public Map getP() {
		return p;
	}
	public void setP(Map p) {
		this.p = p;
	}
	public String getSong_name() {
		return song_name;
	}
	public void setSong_name(String song_name) {
		this.song_name = song_name;
	}
	
	

	
	
	
}

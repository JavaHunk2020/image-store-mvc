package com.rab3.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rab3.controller.vo.ProfileDTO;
import com.rab3.utils.AppDBConnection;


///This is model or action
@Controller
public class LoginController {
	
	//http://localhost:9999/image-store-mvc/editProfile?aid=10
	@GetMapping("/editProfile")
	public String editProfile(@RequestParam int aid,Model model) {
		
		try {
			//Creating connection
			Connection connection=AppDBConnection.getConnection();	
			String sql="select  *  from profiles_tbl where aid =?";
			//compiling the query
			PreparedStatement pstmt=connection.prepareStatement(sql);
			//setting values inside the compiled query
			pstmt.setInt(1,aid);
			//Firing the query and getting data into result set
			ResultSet resultSet=pstmt.executeQuery();
			if(resultSet.next()) {
				 //Go to home.jsp
				//Below line will forward your request from servlet to the JSP
				String username=resultSet.getString(2);
				String password=resultSet.getString(3);
				String name=resultSet.getString(4);
				String email=resultSet.getString(5);
				String gender=resultSet.getString(6);
				String photo=resultSet.getString(7);
				Timestamp doe=resultSet.getTimestamp(8);
				String role=resultSet.getString(9);
				ProfileDTO profileDTO=new ProfileDTO();
				profileDTO.setAid(aid);
				profileDTO.setName(name);
				profileDTO.setEmail(email);
				profileDTO.setGender(gender);
				profileDTO.setImage(photo);
				profileDTO.setUsername(username);
				profileDTO.setPassword(password);
				profileDTO.setDoe(doe);
				profileDTO.setRole(role);
				//Hey I need this data on home.jsp
				model.addAttribute("profileDTO", profileDTO);
			}
			
		}catch (Exception e) {
				e.printStackTrace();
		}
		return "editProfile";
	}

	
	@PostMapping("/auth")
	public String authUser(String username,String password,HttpSession session,Model model) {
		String result="";
		try {
			//Creating connection
			Connection connection=AppDBConnection.getConnection();
			String sql="select  *  from profiles_tbl where username =? and password = ?";
			//compiling the query
			PreparedStatement pstmt=connection.prepareStatement(sql);
			//setting values inside the compiled query
			pstmt.setString(1,username);
			pstmt.setString(2,password);
			//Firing the query and getting data into result set
			ResultSet resultSet=pstmt.executeQuery();
			if(resultSet.next()) {
				 //Go to home.jsp
				//Below line will forward your request from servlet to the JSP
				int aid=resultSet.getInt(1);
				String name=resultSet.getString(4);
				String email=resultSet.getString(5);
				String gender=resultSet.getString(6);
				String photo=resultSet.getString(7);
				Timestamp doe=resultSet.getTimestamp(8);
				String role=resultSet.getString(9);
				ProfileDTO profileDTO=new ProfileDTO();
				profileDTO.setAid(aid);
				profileDTO.setName(name);
				profileDTO.setEmail(email);
				profileDTO.setGender(gender);
				profileDTO.setImage(photo);
				profileDTO.setUsername(username);
				profileDTO.setPassword(password);
				profileDTO.setDoe(doe);
				profileDTO.setRole(role);
				//Hey I need this data on home.jsp
				//Create the session for the user
				session.setAttribute("profileDTO", profileDTO);
				//model - req
				model.addAttribute("magic", profileDTO);
				result="home";    // =>> /home.jsp
			}else {
				 //go to login.jsp
				//req ->is kind of HashMap
				//msg - key will be always string and value could be anything
				model.addAttribute("msg", "Sorry!! username and password are not valid!!!!!!!!!!!!!!!");
				result = "login";
			}
		}catch (Exception e) {
				e.printStackTrace();
		}
		return result;
	}
}

package com.rab3.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rab3.controller.vo.ProfileDTO;


///This is model or action
@Controller
public class LoginController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@PostMapping("/forgotPassword")
	public String forgotPassword(@RequestParam String email,HttpSession session,Model model) {
			//Creating connection
			/*Connection connection=AppDBConnection.getConnection();*/
		/*	//compiling the query
			PreparedStatement pstmt=connection.prepareStatement(sql);
			//setting values inside the compiled query
			pstmt.setString(1,email);
			//Firing the query and getting data into result set
			ResultSet resultSet=pstmt.executeQuery();
			if(resultSet.next()) {
				 //Go to home.jsp
				//Below line will forward your request from servlet to the JSP
				String password=resultSet.getString(1);*/
			
			    String sql="select password  from profiles_tbl where email =?";
			    try {
				  String password=jdbcTemplate.queryForObject(sql, new Object[] {email},String.class);
				//Hey I need this data on home.jsp
					model.addAttribute("password","Hello your password is  =  "+ password);
					model.addAttribute("password", "Sorry!! email is not valid!!!!!!!!!!!!!!!");
			    }catch (Exception e) {
					e.printStackTrace();
				}
			    return "forgotPassword";
	}
	
	
	@PostMapping("/auth")
	public String authUser(String username,String password,HttpSession session,Model model) {
		String result="";
		String sql="select  *  from profiles_tbl where username =? and password = ?";
		List<ProfileDTO>  profileDTOs=jdbcTemplate.query(sql, new Object[] {username,password},new BeanPropertyRowMapper(ProfileDTO.class));
		if(profileDTOs.size()>0) {
			session.setAttribute("profileDTO", profileDTOs.get(0));
			//model - req
			model.addAttribute("magic", profileDTOs.get(0));
			result="home";    // =>> /home.jsp
		}else {
			 //go to login.jsp
			//req ->is kind of HashMap
			//msg - key will be always string and value could be anything
			model.addAttribute("msg", "Sorry!! username and password are not valid!!!!!!!!!!!!!!!");
			result = "login";
		}
		
	/*	try {
			//Creating connection
			Connection connection=AppDBConnection.getConnection();
			
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
		}*/
		return result;
	}
	
	
}

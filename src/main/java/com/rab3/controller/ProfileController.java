package com.rab3.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rab3.controller.vo.ProfileDTO;
import com.rab3.utils.AppDBConnection;

@Controller
public class ProfileController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@PostMapping("/updateProfile")
	public String UpdateProfile(@ModelAttribute ProfileDTO profileDTO,Model model) {
		//Code to save all these data into the database!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		 ///JDBC Programming
		//
		try {
			//Creating connection
			Connection connection=AppDBConnection.getConnection();
			String sql="update profiles_tbl set username=? ,name =? ,email =? ,gender =? ,photo= ?  where aid =?";
			//compiling the query
			PreparedStatement pstmt=connection.prepareStatement(sql);
			//setting values inside the compiled query
			pstmt.setString(1,profileDTO.getUsername());
			pstmt.setString(2,profileDTO.getName());
			pstmt.setString(3,profileDTO.getEmail());
			pstmt.setString(4,profileDTO.getGender());
			pstmt.setString(5,profileDTO.getImage());
			pstmt.setInt(6,profileDTO.getAid());
			//Firing the query and getting data into result set
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("magic", profileDTO);
		model.addAttribute("msg", "Your profile is successfully updated!!");
		return "home";
	}		
	
	
	
	@GetMapping("/profiles")
	public String allProfiles(Model model) {
		try {
			
			String sql="select  aid,username,password,name,email,gender,photo,doe,role  from profiles_tbl";
			List<ProfileDTO> profileDTOs =jdbcTemplate.query(sql, new BeanPropertyRowMapper(ProfileDTO.class));
			//Creating connection
			/*Connection connection=AppDBConnection.getConnection();
			//compiling the query
			PreparedStatement pstmt=connection.prepareStatement(sql);
			//Firing the query and getting data into result set
			ResultSet resultSet=pstmt.executeQuery();
			List<ProfileDTO> profileDTOs=new ArrayList<>();
			while(resultSet.next()) {
				 //Go to home.jsp
				//Below line will forward your request from servlet to the JSP
				int aid=resultSet.getInt(1);
				String username=resultSet.getString(2);
				String password=resultSet.getString(2);
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
				profileDTOs.add(profileDTO);
			}*/
			
			//Hey I need this data on home.jsp
			model.addAttribute("profileDTOs", profileDTOs);
		}catch (Exception e) {
				e.printStackTrace();
		}
		return "profiles";
	}
	
	@GetMapping("/deleteProfile")
	public String deleteProfile(@RequestParam String uname,Model model) {

		jdbcTemplate.update("delete  from  profiles_tbl where username =?",new Object[] {uname});
		
	/*	try {
			Connection connection=AppDBConnection.getConnection();	
			//compiling the query
			PreparedStatement pstmt=connection.prepareStatement(sql);
			//setting values inside the compiled query
			pstmt.setString(1,uname);
			//Firing the query and getting data into result set
			pstmt.executeUpdate();
			//Dispatcher from servle tp servlet
			
		}catch (Exception e) {
			e.printStackTrace();
		}	*/
		return  "redirect:/profiles";
	}	
	
	//http://localhost:9999/image-store-mvc/editProfile?aid=10
		@PostMapping("/register")
		public String posRegister(@ModelAttribute ProfileDTO profileDTO,Model model) {
		
			//Code to save all these data into the database!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			 ///JDBC Programming
			//
			Timestamp timestamp=new Timestamp(new Date().getTime());
			/*Object[] data= {profileDTO.getUsername(),profileDTO.getPassword(),profileDTO.getName(),
					profileDTO.getEmail(),profileDTO.getGender(),profileDTO.getImage(),timestamp};
			*/
			jdbcTemplate.update("insert into profiles_tbl(username,password,name,email,gender,photo,doe)  values(?,?,?,?,?,?,?)",
					new Object[]{profileDTO.getUsername(),profileDTO.getPassword(),profileDTO.getName(),
					profileDTO.getEmail(),profileDTO.getGender(),profileDTO.getImage(),timestamp});
			
		/*	try {
				//Creating connection
				Connection connection=AppDBConnection.getConnection();
				
				//compiling the query
				PreparedStatement pstmt=connection.prepareStatement(sql);
				//setting values inside the compiled query
				pstmt.setString(1,profileDTO.getUsername());
				pstmt.setString(2,profileDTO.getPassword());
				pstmt.setString(3,profileDTO.getName());
				pstmt.setString(4,profileDTO.getEmail());
				pstmt.setString(5,profileDTO.getGender());
				pstmt.setString(6,profileDTO.getImage());
			
				pstmt.setTimestamp(7,timestamp);
				//Firing the query and getting data into result set
				pstmt.executeUpdate();
				
			}catch (Exception e) {
				e.printStackTrace();
			}*/
			
			model.addAttribute("msg", "You are successfully registered!!!");
			return "register";
		
	   }
	
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

}

package endpoints;

import utilities.ConfigReader;

public class RouteURL {
	
	ConfigReader config = new ConfigReader();
	
	public static String base_url = "https://userapi-8877aadaae71.herokuapp.com/uap";
	public static String Invalid_base_url = "https://userapi-8877aadaae71.herokuapp.com";
	
//POST Create Users
	public static String PostUser_Url = base_url+"/createusers";	
	public static String PostUser_InvalidUrl = Invalid_base_url+"/createusers";
	public static String PostUser_InvalidEP = base_url+"/create";
	
//GET All Users
	public static String GetUsers_Url = base_url+"/users";
	public static String GetUsers_InvalidUrl = Invalid_base_url+"/users";
	public static String GetUsers_InvalidEP = base_url+"/user";

//GET User by ID
	public static String GetUserID_Url = base_url+"/user/6484";
	public static String GetUserID_InvalidUrl = Invalid_base_url+"/user/6484";
	public static String GetUserID_InvalidEP = base_url+"/users/6484";
	public static String GetUserID_InvalidID = base_url+"/user/99999000";

//GET User by FirstName
	public static String GetUserFirstName_Url = base_url+"/users/username/{Firstname}";
	public static String GetUserFirstName_InvalidUrl = Invalid_base_url+"/users/username/shany";
	public static String GetUserFirstName_InvalidEP = base_url+"/user/username/shany";
	public static String GetUserFirstName_InvalidFN = base_url+"/users/username/99900";
	
//PUT Update user by ID
	public static String PutUser_Url = base_url+"/updateuser/{userId}";
	public static String PutUserId_InvalidID = base_url+"/updateuser/{InvaliduserID}";
	
//DELETE User by ID
	public static String DeleteUserID_Url = base_url+"/deleteuser/6484";
	public static String DeleteUserID_InvalidUrl = Invalid_base_url+"/deleteuser/6484";
	public static String DeleteUserID_InvalidEP = base_url+"/deleteuse/6484";
	public static String DeleteUserID_InvalidID = base_url+"/deleteuser/99900";
	public static String DeleteUserID_InvalidIDAlpha = base_url+"/deleteuser/abcd";
	
//DELETE User by FirstName
	public static String DeleteUserFirstName_Url = base_url+"/deleteuser/username/delisa";
	public static String DeleteUserFirstName_InvalidUrl = Invalid_base_url+"/deleteuser/username/delisa";
	public static String DeleteUserFirstName_InvalidEP = base_url+"/deleteuser/usernam/delisa";
	public static String DeleteUserFirstName_InvalidFN = base_url+"/deleteuser/username/99000";
	
	
}

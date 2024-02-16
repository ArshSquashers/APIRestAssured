package RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Pojo.UserAPI_Pojo;
import Pojo.userAddress;
//import Pojo.userAddress;
import utilities.ExcelReader;

public class UserRequestBody extends ExcelReader{

	public static UserAPI_Pojo pojo = new UserAPI_Pojo();
	
	//public static userAddress Address= new userAddress();
	
	static List<String> userAddress = new ArrayList<String>();
 
	 public static UserAPI_Pojo UserRequest(String TestCaseNumber, String sheetname) throws Exception
	{
		Map<String, String> excelDataMap;
		excelDataMap = ExcelReader.getData(TestCaseNumber, sheetname);	
			
			
		pojo.setUser_first_name(excelDataMap.get("user_first_name"));
		pojo.setUser_last_name(excelDataMap.get("user_last_name"));
		pojo.setUser_contact_number(excelDataMap.get("user_contact_number"));
		pojo.setUser_email_id(excelDataMap.get("user_email_id"));
		

		userAddress.add(excelDataMap.get("plotNumber"));
		userAddress.add(excelDataMap.get("Street"));
		userAddress.add(excelDataMap.get("state"));
		userAddress.add(excelDataMap.get("Country"));
		userAddress.add(excelDataMap.get("zipCode"));
		pojo.setuserAddress(userAddress);
		
		
		
//		Address.setPlotNumber(excelDataMap.get("plotNumber"));
//		Address.setStreet(excelDataMap.get("Street"));
//		Address.setState(excelDataMap.get("state"));
//		Address.setCountry(excelDataMap.get("Country"));
//		Address.setZipCode(excelDataMap.get("zipCode"));
//		pojo.setuserAddress(userAddress);

		return pojo;
	}
}

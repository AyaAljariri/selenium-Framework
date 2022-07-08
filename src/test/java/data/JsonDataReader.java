package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataReader {
	 public String Firstname , Lastname , email , password ;
	public void JsonReader() throws Throwable, IOException, ParseException {
		String getPath=System.getProperty("user.dir")+"/src/test/java/data/UserData.json"; 
		File srcFile = new File(getPath);
		//i added jsonParser by my self from apache to the dependencies 
		JSONParser Jparser = new JSONParser();
		JSONArray Jarray = (JSONArray) Jparser.parse(new FileReader(srcFile));
		
		for (Object jsonObj : Jarray) {
			JSONObject person = (JSONObject) jsonObj;
			Firstname = (String) person.get("Firatsname");
			System.out.println(Firstname);
			Lastname = (String) person.get("Lastname");
			System.out.println(Lastname);

			email = (String) person.get("Email");
			System.out.println(email);

			password = (String) person.get("Password");
			System.out.println(password);


		}
	}

}

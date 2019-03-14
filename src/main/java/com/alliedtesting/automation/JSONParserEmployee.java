package com.alliedtesting.automation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONParserEmployee {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		try {

            Object obj = parser.parse(new FileReader("./src/main/resources/employee.json"));

           JSONObject jsonObject = (JSONObject) obj;
           // JSONArray jsonArray = (JSONArray)obj;
            System.out.println(jsonObject);

            Object name = jsonObject.get("department");
            System.out.println(name);

           /* long age = (Long) jsonObject.get("age");
            System.out.println(age);

            // loop array
            JSONArray msg = (JSONArray) jsonObject.get("messages");
            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


}

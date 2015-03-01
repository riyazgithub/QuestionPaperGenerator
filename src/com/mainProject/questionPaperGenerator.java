package com.mainProject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

import com.utilities.cellInfo;
import com.utilities.readXLFile;
import com.utilities.writeXLFile;

public class questionPaperGenerator {
	
	public static void main(String[] args) throws IOException {
		
		readXLFile rxlf = new readXLFile();
		HashMap<String, LinkedList<cellInfo>> hm = rxlf.readXL("partA.xls");
		
//		System.out.println("Tada "+hm);
		
		//Now some picking questions
		
		Set<String> keySet= hm.keySet();
		for(String key:keySet)
		{
			String questions=getQuestions(hm.get(key));
	        try {
	            FileWriter writer = new FileWriter(key+".txt", true);
	            
	            writer.write(questions);
	            writer.write("\r\n");   // write new line
	        
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			    }
			
		}
		
	

	private static String getQuestions(LinkedList<cellInfo> linkedList) throws IOException {
		// TODO Auto-generated method stub
		String Questions = new String();
		cellInfo question1 = linkedList.get(0);
		System.out.println(question1);
		Questions=Questions.concat("1) "+question1.getQuestion()+"\n");
		cellInfo question2 = linkedList.get(1);
		System.out.println(question2);
		Questions=Questions.concat("2) "+question2.getQuestion()+"\n");
		
		writeXLFile wXLFile = new writeXLFile();
		wXLFile.updateXL(question1);
		wXLFile.updateXL(question2);
		
		
		return Questions;
		
	}
	

	

}

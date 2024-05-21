import java.util.Scanner;

import javax.naming.Context;

import java.util.*;
import java.io.*;

public class ChangeMaker {

	public static void main(String[] args) throws IOException {
	Scanner s = new Scanner(System.in);
	String in, out;
	System.out.println("Please enter your java file path location (C:\\x): ");
	int CB = 0;
	int Semi = 0;
	in = s.next();

	Scanner L = new Scanner(new File(in));
	
	
	ArrayList<String> list = new ArrayList<String>();
    try (BufferedReader br = new BufferedReader(new FileReader(in)))
    {

        String sCurrentLine;

        while ((sCurrentLine = br.readLine()) != null) 
        {
        	
        	
            list.add(sCurrentLine);
        }
			/*
			 * if(sCurrentLine == "." || sCurrentLine == ";" || sCurrentLine == "}") {
			 * list.add("\n"); list.add("        "); }
			 */
        
        
        for(int i = 0; i < list.size(); i++) {
        if(list.contains("."))
        {
        	int temp = list.indexOf(".");
        	list.add(temp, "\n");
        	list.add(temp+1, "        ");	
        	
        }
        
        else if(list.contains("{")) {
        	while(!list.contains("}")) {
        		list.add("}");
        	}
        }
        else if(list.contains(";")) {
        	int temp1 = list.indexOf(";");
        	list.add(temp1, "\n");
        	list.add(temp1+1, "        ");
        	
        	
        }
       
        }
       
      
       
    } catch (IOException e) {
        e.printStackTrace();
    }  
    System.out.println(list);
    L.close();
    System.out.println("Please indicate the file path for output: ");
    out = s.next();
    writer(list, out);
		/*
		 * FileOutputStream fos = new FileOutputStream(out); ObjectOutputStream oos =
		 * new ObjectOutputStream(fos); oos.writeObject(list); oos.close();
		 * 
		 */	
	

    }
	public static void writer(ArrayList<String> datArrayList, String file) throws IOException {

        PrintWriter pw = null;
        FileOutputStream fo = null;
        
        try {
            
            pw = new PrintWriter(new FileOutputStream(file));
            fo = new FileOutputStream(file);
            int datList = datArrayList.size();
            for (int i = 0; i < datList; i++) {
                pw.write(datArrayList.get(i).toString() + "\n");
            }
        } finally {
            pw.flush();
            pw.close();
            fo.close();
        }
	}
}

	
	


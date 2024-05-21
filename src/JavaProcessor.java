import java.io.*;
import java.util.*;
import java.util.Scanner;
import javax.naming.Context;


public class JavaProcessor {

	
	public static void main(String[] args) throws IOException {
		Scanner r = new Scanner(System.in);
		String in, out;
		System.out.println("Enter java file path location");
		int CB = 0;
		int Semi = 0;
		in = r.next();

		Scanner D = new Scanner(new File(in));
		
		
		ArrayList<String> list = new ArrayList<String>();
	    try (BufferedReader br = new BufferedReader(new FileReader(in))) //file upload reader
	    {

	        String sCurrentLine;

	        while ((sCurrentLine = br.readLine()) != null) 
	        {
	        	
	        	
	            list.add(sCurrentLine);
	        }
				
				
				  
				
	        
	        
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
	    D.close();
	    System.out.println("Please indicate the file path for output: ");
	    out = r.next();
	    write(list, out);
			
			// Output of file to save
			 
	
		

	    }
		public static void write(ArrayList<String> dataArrayList, String file) throws IOException {

	        PrintWriter pw = null;
	        FileOutputStream fo = null;
	        
	        try {
	            
	            pw = new PrintWriter(new FileOutputStream(file));
	            fo = new FileOutputStream(file);
	            int dataList = dataArrayList.size();
	            for (int i = 0; i < dataList; i++) {
	                pw.write(dataArrayList.get(i).toString() + "\n");
	            }
	        } finally {
	            pw.flush();
	            pw.close();
	            fo.close();
	        }
		}
	}

		
		


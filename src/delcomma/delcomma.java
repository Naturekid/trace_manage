package delcomma;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class delcomma {
	
	//long epoch = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/01/1970 01:00:00");
		private static String in_file = ""; 
		public FileReader reader ; //= new FileReader();
		public BufferedReader br ; //= new BufferedReader(reader);
		
	    FileWriter writer ;
	    BufferedWriter bw ;
		
		public String src_file;
/*		public time_format(String file_path)
		{
			src_file = new String(file_path);
			try {
				writer = new FileWriter("e://Coding/Android/trace_management/dealed_file.txt");
				bw = new BufferedWriter(writer);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}*/
		
		public boolean change_time_format()
		{
			try {
				reader = new FileReader(src_file);
			
				br = new BufferedReader(reader);
				
				
			
			String tmp_str = null;
			
			int count =0;
			
			while((tmp_str = br.readLine()) != null) {
		          
				System.out.println(tmp_str);
				
				String[] str_arr = tmp_str.split("	");
				
				System.out.println(str_arr[1]);
				
				//String new_time_f = str_arr[1].replace("-", "/");
				
				//System.out.println(new_time_f);
				
				//2015-06-30 12:39:55.282009
				//new_time_f = new_time_f.substring(0,19);
				
				str_arr[1] = str_arr[1].substring(0,23);
				
				SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.SSS" );

				//String time=new_time_f;

				Date date = format.parse(str_arr[1]);
				
				System.out.println(str_arr[1]);
				
				long time_stamp = date.getTime() ;

				System.out.print("Format To times:" + str_arr[1] + "->" + time_stamp);
							
				switch(str_arr[0])
				{
				case "flowA.0": str_arr[0]="1"; break;
				case "flowB.0": str_arr[0]="2"; break;
				case "flowC.0": str_arr[0]="3"; break;
				case "flowD.0": str_arr[0]="4"; break;
				case "flowE.0": str_arr[0]="5"; break;
				default:break;
					
				}
				
				tmp_str = str_arr[0] + "	" + Long.toString(time_stamp, 10) + "	" + str_arr[2] + "	"
						+ str_arr[3] + "	" + str_arr[4] + "	" + str_arr[5] + "\n";
				
				count ++;
				
				System.out.println(tmp_str);
				bw.append(tmp_str);

		    }
		   
		    br.close();
		    reader.close();
	        bw.close();
	        writer.close();
		    
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return false;
		}
		

}

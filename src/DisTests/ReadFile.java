package DisTests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadFile {
	
	private String configPath = new String("E://Coding/Android/trace_management/dealed_file.txt");
	private String dealedFile = new String("e://Coding/Android/trace_management/dis_file.txt");
	
	FileReader fr  = null; 
	BufferedReader buf =null;
	
	FileWriter writer = null;
    BufferedWriter bw = null;
	
	ParseConfigFile lastLoc;
	ParseConfigFile curLoc;
	
	public ReadFile()
	{
		lastLoc = new ParseConfigFile();
		curLoc = new ParseConfigFile();
	}
	
	//切记代码结束时要调用关闭连接代码
	public void delConfigLocation()
	{
		//要不要先判断下是否已到文件末被关闭了？
		try { 
		      buf.close(); 
		      fr.close(); 
		      bw.close();
		      writer.close();
		    } 
		catch (IOException ex2) { 
		      ex2.printStackTrace(); 
		} 
	}
		
	public void traceLocation()
	{
		
		
		String curLine = null;
		String lastLine = null;
				
		/* 
		 * 配置文件的第一行，为模拟器的第一个时间
		 * 若请求时间恰好为模拟器开始时间或者小于模拟器的开始时间
		 * 设置节点位置为此位置
		 */
		
		//按行读取文件内容
		try { 
			
			long queryTime = System.currentTimeMillis();
			System.out.println("query time = "+Long.toString(queryTime));
			
			//构造一个FileReader和BUfferedReader的对象
			fr = new FileReader(configPath); 
			buf = new BufferedReader(fr);
			
			writer = new FileWriter(dealedFile);
			bw = new BufferedWriter(writer);
			
			curLine = buf.readLine(); 
			lastLine = buf.readLine();
			
			while( curLine!=null && lastLine !=null ) //当curLine==null时，说明已到文件末，设置节点位置为配置文件里相关的最后一个位置。 
			{
				//解析配置文件的一行数据
				ParseConfigFile curPcf = new ParseConfigFile(curLine);
				ParseConfigFile lastPcf = new ParseConfigFile(lastLine);
				//配置文件某行出错
				if(curPcf.gotTime == -1){
					System.out.println("Wrong Config Line");
					curLine =buf.readLine(); 
					continue;
				}
				
				double dis = Distance.getDistance(lastPcf.latitude,lastPcf.longitude,
						curPcf.latitude,curPcf.longitude);
				
				String tmp = lastPcf.gotTime + "	" +lastPcf.nodeNo + "-" + curPcf.nodeNo +"	"+ dis + "\n";
				
				bw.append(tmp);
				
				lastLine = curLine;
				curLine = buf.readLine(); 

			}
		} 
		catch (IOException ex1) { 
			 ex1.printStackTrace(); 
		}
	}
	
}

package lguplus.cs.sms;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

	private String filePath = "";
	
	public FileHandler (String path) {
		
		this.filePath = path;
		
	}
	
	public List<String> fileReader() {
		
        //���� ��ü ����
//        Path path = Paths.get("C:\\Users\\sndre\\Documents\\TCT_EAD CNS����\\test_data\\java_input_data.txt");
		Path path = Paths.get(filePath);
        
        // ĳ���ͼ� ����
        Charset cs = StandardCharsets.UTF_8;
        
        //���� ������� ����Ʈ
        List<String> list = new ArrayList<String>();
        
        try{
            list = Files.readAllLines(path,cs);
        }catch(IOException e){
            e.printStackTrace();
        }
        
        //just print
//        for(String readLine : list){
//            System.out.println(readLine);
//        }
        
        return list;

	}
}

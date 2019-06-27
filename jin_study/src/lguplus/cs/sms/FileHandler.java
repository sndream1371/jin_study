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
		
        //파일 객체 생성
//        Path path = Paths.get("C:\\Users\\sndre\\Documents\\TCT_EAD CNS시험\\test_data\\java_input_data.txt");
		Path path = Paths.get(filePath);
        
        // 캐릭터셋 지정
        Charset cs = StandardCharsets.UTF_8;
        
        //파일 내용담을 리스트
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

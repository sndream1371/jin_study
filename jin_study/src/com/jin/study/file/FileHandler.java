package com.jin.study.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHandler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String srcfile = "d:/filetest/e.txt";
		String destfile = "d:/filetest_done/done/employee.json-1_copyed";

		String srcP = "d:/filetest";
		String destP = "d:/filetest_done/done";
		try {
//			moveFile(srcfile, destfile);
			
			fileMove(srcfile, destfile);
			
			List<File> arrFile = getDirFileList(destP);
			
			for(int i=0; i < arrFile.size() ; i++) {
				System.out.println("file name :" + arrFile.get(i).getName());
			}
			
			

//			moveDir(srcP, destP);

//			File folder1 = new File("d:/filetest");
//			File folder2 = new File("d:/filetest_done/done");
//			FileHandler.copy(folder1, folder2);
//			FileHandler.delete(folder1.toString());

//			copyWithJavaNewIO(srcP, destP);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	// 파일을 이동하는 메소드
	public static void fileMove(String inFileName, String outFileName) {
		try {
			String destPath = outFileName.substring(0, outFileName.lastIndexOf("/") + 1);

			File Dir = new File(destPath);
			if (!Dir.exists()) {
				Dir.mkdirs(); // 마지막 폴더까지 생성
				System.out.println("폴더를 생성하였습니다.[" + Dir + "]");
			}
			
			FileInputStream fis = new FileInputStream(inFileName);
			FileOutputStream fos = new FileOutputStream(outFileName);

			int data = 0;
			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();

			// 복사한뒤 원본파일을 삭제함
			fileDelete(inFileName);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 디렉토리의 파일 리스트를 읽는 메소드
	public static List<File> getDirFileList(String dirPath) {
		// 디렉토리 파일 리스트
		List<File> dirFileList = null;

		// 파일 목록을 요청한 디렉토리를 가지고 파일 객체를 생성함
		File dir = new File(dirPath);

		// 디렉토리가 존재한다면
		if (dir.exists()) {
			// 파일 목록을 구함
			File[] files = dir.listFiles();

			// 파일 배열을 파일 리스트로 변화함
			dirFileList =  Arrays.asList(files);
		}

		return dirFileList;
	}

	// 파일을 존재여부를 확인하는 메소드
	public static Boolean fileIsLive(String isLivefile) {
		File f1 = new File(isLivefile);

		if (f1.exists()) {
			return true;
		} else {
			return false;
		}
	}

	// 파일을 생성하는 메소드
	public static void fileMake(String makeFileName) {
		File f1 = new File(makeFileName);
		try {
			f1.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 파일을 삭제하는 메소드
	public static void fileDelete(String deleteFileName) {
		File I = new File(deleteFileName);
		I.delete();
	}

	// 파일을 복사하는 메소드
	public static void fileCopy(String inFileName, String outFileName) {
		try {
			FileInputStream fis = new FileInputStream(inFileName);
			FileOutputStream fos = new FileOutputStream(outFileName);

			int data = 0;
			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public static void copy(File sourceF, File targetF) {
//		File[] target_file = sourceF.listFiles();
//		for (File file : target_file) {
//			File temp = new File(targetF.getAbsolutePath() + File.separator + file.getName());
//			if (file.isDirectory()) {
//				temp.mkdirs();
//				copy(file, temp);
//			} else {
//				FileInputStream fis = null;
//				FileOutputStream fos = null;
//				try {
//					fis = new FileInputStream(file);
//					fos = new FileOutputStream(temp);
//					byte[] b = new byte[4096];
//					int cnt = 0;
//					while ((cnt = fis.read(b)) != -1) {
//						fos.write(b, 0, cnt);
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				} finally {
//					try {
//						fis.close();
//						fos.close();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//
//				}
//			}
//		}
//	}
//
//	public static void delete(String path) {
//
//		File folder = new File(path);
//		try {
//			if (folder.exists()) {
//				File[] folder_list = folder.listFiles();
//
//				for (int i = 0; i < folder_list.length; i++) {
//					if (folder_list[i].isFile()) {
//						folder_list[i].delete();
//					} else {
//						delete(folder_list[i].getPath());
//					}
//					folder_list[i].delete();
//				}
//			}
//		} catch (Exception e) {
//			e.getStackTrace();
//		}
//	}

	public static void moveFile(String srcFile, String destFile) {

		boolean isTrue = false;

		try {
			String destPath = destFile.substring(0, destFile.lastIndexOf("/") + 1);

			File Dir = new File(destPath);
			if (!Dir.exists()) {
				Dir.mkdirs(); // 마지막 폴더까지 생성
				System.out.println("폴더를 생성하였습니다.[" + Dir + "]");
			}

			// create new File objects
			File sFile = new File(srcFile);
			File dFile = new File(destFile);

			// rename file
			isTrue = sFile.renameTo(dFile);

			System.out.print("File renamed? " + isTrue);

		} catch (Exception e) {
			// if any error occurs
			e.printStackTrace();
		}

	}

	// file Move
//	public static void moveDir(String srcFilePath, String destFilePath)
//	{
//		try
//		{
//			if(srcFilePath!=null && srcFilePath.trim().length() > 0 && destFilePath!=null && destFilePath.trim().length() > 0)
//			{
//				/* Create the source Path instance. */
//				Path srcPathObj = Paths.get(srcFilePath); 
//				
//				/* Create the target Path instance. */
//				Path destPathObj = Paths.get(destFilePath); 
//				
//				/* Rename source to target, replace it if target exist. */
//				Path targetPathObj = Files.move(srcPathObj, destPathObj, StandardCopyOption.REPLACE_EXISTING);
//				
//				System.out.println("Use java new io to move success from " + srcFilePath + " to " + destFilePath);
//			}
//		}catch(Exception ex)
//		{
//			ex.printStackTrace();
//		}
//	}
}

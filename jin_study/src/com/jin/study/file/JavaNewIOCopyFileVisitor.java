package com.jin.study.file;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class JavaNewIOCopyFileVisitor extends SimpleFileVisitor{
	
	private String srcDir;
	
	private String destDir;

	public String getSrcDir() {
		return srcDir;
	}

	public void setSrcDir(String srcDir) {
		this.srcDir = srcDir;
	}

	public String getDestDir() {
		return destDir;
	}

	public void setDestDir(String destDir) {
		this.destDir = destDir;
	}

	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes arg1) throws IOException {
		/* Get both source and destination directory Path object. */
		Path srcPath = Paths.get(this.getSrcDir());
		Path destPath = Paths.get(this.getDestDir());
		
		/* Get the relative Path object between source and current directory. */
		Path relativePath = srcPath.relativize(dir);
		
		/* Get the target directory Path instance. */
		Path targetDirPath = destPath.resolve(relativePath);
		
		try {
			/* Copy current go through directory to target directory, replace target if exist. */
            Files.copy(dir, targetDirPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (FileAlreadyExistsException ex) {
             if (!Files.isDirectory(targetDirPath))
                 throw ex;
        }
		
		return FileVisitResult.CONTINUE;
	}

	public FileVisitResult visitFile(Path file, BasicFileAttributes arg1) throws IOException {
		/* Get both source and destination directory Path object. */
		Path srcPath = Paths.get(this.getSrcDir());
		Path destPath = Paths.get(this.getDestDir());
		
		/* Get Path object that current file relative to source folder. */
		Path relativeFilePath = srcPath.relativize(file);
		
		/* Use the relative path to get target folder Path object. */
		Path targetFilePath = destPath.resolve(relativeFilePath);

		/* Copy current file to target file, replace target if exist. */
		Files.copy(file, targetFilePath, StandardCopyOption.REPLACE_EXISTING);
		
		return FileVisitResult.CONTINUE;
	}
}
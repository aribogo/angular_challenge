package com.store.utility;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileUtility {
	@Value("${file.root.path}")
	private String root;
	
	@Value("${file.api.folder}")
	private String imageDirectory;

	
	/**
	 * Creates folder by given path and saves file in the folder or gives an exception.
	 * @param file
	 * @param filePolitician
	 */
	public void saveFile(byte[] file, String filePolitician, String fileName) throws Exception {
		Path directoryPath = Paths.get(this.root, imageDirectory + filePolitician);
		FileOutputStream fos = null;
		try {
			Files.createDirectories(directoryPath);
			fos = new FileOutputStream(new File(directoryPath.toString()+"/"+fileName));	
			fos.write(file);
		} catch (IOException e) {
			throw e;
		} finally {
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					throw e;
				}
			}
		}
		
	}
	
	/**
	 * Reads file to byte array from given directory or gives an exception.
	 * @param filePolitician
	 * @param fileName
	 * @return
	 */
	public byte[] readFile(String filePolitician, String fileName) {
		Path directoryPath = Paths.get(this.root, imageDirectory + filePolitician+"/"+fileName);
		
		try {
			File file = directoryPath.toFile();
			 
			return FileUtils.readFileToByteArray(file);
		} catch (IOException e) {
			throw new RuntimeException("Problems trying to read the file", e);
		}
		
	}

	
	/**
	 * Deletes image from folder
	 * @param String filePath
	 * @throws IOException
	 */
	public void deleteFile(String filePath) throws Exception {
		try {
			Path path = Paths.get(root, imageDirectory + filePath);
			Files.delete(path);
		} catch (IOException e) {
			throw e;
		}
	}
}

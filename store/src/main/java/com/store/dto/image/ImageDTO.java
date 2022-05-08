package com.store.dto.image;

public class ImageDTO {
	
	private String fileFolder;

	private String fileName;

	private Long fileSize;

	private String fileType;

	public ImageDTO(String fileFolder, String fileName, Long fileSize, String fileType) {
		this.fileFolder = fileFolder;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileType = fileType;
	}

	public String getFileFolder() {
		return fileFolder;
	}

	public void setFileFolder(String fileFolder) {
		this.fileFolder = fileFolder;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

}

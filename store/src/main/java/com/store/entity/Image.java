package com.store.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

@Embeddable
public class Image {

	@Column(name= "file_folder")
	@NotEmpty(message = "Can not be blank")
	private String fileFolder;
	
	@Column(name= "file_name")
	@NotEmpty(message = "Can not be blank")
	private String fileName;
	
	@Column(name= "file_size")
	private Long fileSize;
	
	@Column(name= "file_type")
	private String fileType;
	
	public Image(String fileFolder, String fileName, Long fileSize, String fileType) {
		this.fileFolder = fileFolder;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileType = fileType;
	}

	public Image() {
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

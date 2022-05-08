package com.store.dto.image;

import com.store.entity.Image;

public class ImageMapper {

	public static Image fromDTO(ImageDTO dto) {
		
		return new Image(dto.getFileFolder(), dto.getFileName(), dto.getFileSize(), dto.getFileType());
	}
	
	public static ImageDTO fromEntity(Image image) {
		
		return new ImageDTO(image.getFileFolder(), image.getFileName(), image.getFileSize(), image.getFileType());
	}
	
}

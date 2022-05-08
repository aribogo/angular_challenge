package com.store.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.store.dto.product.ProductDTO;
import com.store.dto.product.ProductMapper;
import com.store.dto.saleItems.SaleItemsDTO;
import com.store.dto.saleItems.SaleItemsMapper;
import com.store.entity.Product;
import com.store.entity.SaleItems;
import com.store.service.SaleItemsService;
import com.store.utility.FileUtility;

@Controller
@RequestMapping("v1/saleItems")
public class SaleItemsController {

	public final SaleItemsService saleItemsService;
	private final FileUtility fileU;

	public SaleItemsController(SaleItemsService saleItemsService, FileUtility fileU) {
		this.saleItemsService = saleItemsService;
		this.fileU = fileU;
	}

	@GetMapping(path = "{saleId}")
	public ResponseEntity<?> getItemsBySale(@PathVariable Long saleId) {

		try {

			List<SaleItems> saleItems = saleItemsService.getAllSaleItemsBySaleId(saleId);

			SaleItemsDTO saleItemDTO = new SaleItemsDTO();
			List<SaleItemsDTO> saleitemsDTO = new ArrayList<SaleItemsDTO>();

			for (SaleItems sItems : saleItems) {

				String path = sItems.getProduct().getDisplayImage().getFileFolder() + "/" + sItems.getProduct().getId();
				byte[] file = fileU.readFile(path, sItems.getProduct().getDisplayImage().getFileName());
			
				saleItemDTO = SaleItemsMapper.fromEntity(sItems);
				saleItemDTO.getProduct().setBase64Image(Base64.getMimeEncoder().encodeToString(file));
				saleitemsDTO.add(saleItemDTO);
			}

			for (SaleItems saleItem : saleItems) {

			}

			return ResponseEntity.ok(saleitemsDTO);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

	}

}

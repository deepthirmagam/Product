package com.product.quality.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.quality.pojo.ProductInput;
import com.product.quality.pojo.ProductResult;
import com.product.quality.service.QualityService;

@RestController("/")
public class QualityController {
	QualityService service = new QualityService();

	/**
	 * 
	 * @param input
	 * @param model
	 * @return
	 */
	@PostMapping("/add")
	public ResponseEntity<String> addProduct(@RequestBody ProductInput input, Model model) {
		service.addProduct(input);
		return new ResponseEntity<String>("{\"name\":" + input.getProductName() + ",\n\"info\":\"Product added\"}",
				HttpStatus.OK);
	}

	/**
	 * result list containing all the products
	 * 
	 * @param statusDate
	 * @return
	 * @throws ParseException
	 */
	@GetMapping("/quality/{statusDate}")
	public ResponseEntity<List<ProductResult>> getProductList(@PathVariable("statusDate") String statusDate)
			throws ParseException {
		List<ProductResult> items = service.getProductList(statusDate);
		return new ResponseEntity<List<ProductResult>>(items, HttpStatus.OK);
	}
}
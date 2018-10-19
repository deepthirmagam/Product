package com.product.quality.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.product.quality.config.ProductsRule;
import com.product.quality.helper.CommonUtil;
import com.product.quality.helper.QualityHelper;
import com.product.quality.pojo.ProductInput;
import com.product.quality.pojo.ProductResult;

@Service
public class QualityService {
	public static String DATE_FORMAT = "dd-MM-yyyy";
	private static List<ProductInput> products = new ArrayList<ProductInput>();

	/**
	 * add product
	 * 
	 * @param input
	 */
	public void addProduct(ProductInput input) {
		input.setEntryDate(CommonUtil.getDate());
		Date sellInDate = CommonUtil.getDate();
		sellInDate.setDate(sellInDate.getDate() + input.getSellIn());
		input.setSellDate(sellInDate);
		getProducts().add(input);
	}

	/**
	 * Get the products list
	 * 
	 * @param statusDate
	 * @return List<ProductResult>
	 * @throws ParseException
	 */
	public List<ProductResult> getProductList(String statusDate) throws ParseException {
		Date inputDate = new SimpleDateFormat(DATE_FORMAT).parse(statusDate);
		List<ProductResult> result = new ArrayList<>();
		for (ProductInput productInput : getProducts()) {
			result.add(QualityHelper.getProductResult(productInput, inputDate));
		}
		return result;
	}

	public static List<ProductInput> getProducts() {
		return products;
	}
}
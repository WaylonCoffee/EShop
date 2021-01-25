package com.qingala.admin;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.qingala.admin.application.command.produtct.CreateSkuParam;
import com.qingala.admin.application.command.produtct.CreateSpuParam;
import com.qingala.admin.domain.product.SpuService;
import com.qingala.admin.domain.product.model.Photo;
import com.qingala.admin.domain.product.model.PhotoTuple;
import com.qingala.admin.domain.product.model.Spec;
import com.qingala.admin.domain.product.model.SpecTuple;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(classes = ShopAdminApplication.class)
@Slf4j
class ShopAdminApplicationTests {


	@Autowired
	private SpuService spuService;

	


	@Test
	void contextLoads() {
	}
	
	@Test
	public void test(){

		CreateSpuParam spuParam = new CreateSpuParam();
		spuParam.setShopId("1");
		spuParam.setCategoryId("123");
		spuParam.setUnit("台");
		spuParam.setName("Iphone 12");
		List<Photo> list = new ArrayList<>();
		
		list.add(new Photo("12312312312"));
		list.add(new Photo("12312312"));
		PhotoTuple tuple = new PhotoTuple(list);


		spuParam.setPhotoTuple(tuple);
		
		CreateSkuParam skuParam = new CreateSkuParam();
		skuParam.setRetailPrice(new BigDecimal(5300));
		skuParam.setMarketPrice(new BigDecimal(5400));
		skuParam.setBarCodes("6900001");
		List<Spec> specList = new ArrayList<>();
		specList.add(new Spec("颜色","绿色"));
		specList.add(new Spec("大小","64G"));

		SpecTuple specTuple = new SpecTuple(specList);
		skuParam.setSpecTuple(specTuple);

		CreateSkuParam skuParam2 = new CreateSkuParam();
		skuParam2.setRetailPrice(new BigDecimal(5300));
		skuParam2.setMarketPrice(new BigDecimal(5400));
		skuParam2.setBarCodes("6900001");
		List<Spec> specList2 = new ArrayList<>();
		specList2.add(new Spec("颜色","黑色"));
		specList2.add(new Spec("大小","64G"));

		SpecTuple specTuple2 = new SpecTuple(specList2);
		skuParam2.setSpecTuple(specTuple2);
		List<CreateSkuParam> skus = new ArrayList<>();
		skus.add(skuParam);skus.add(skuParam2);
		spuParam.setSkus(skus);
		log.info("param:{}",spuParam);
		spuService.create(spuParam);

		
	}

	@Test
	public void test2(){
		f();	
	}
	public static void f() {
		String[] a = new String[2];
		Object[] b = a;
		a[0] = "hi";
		b[1] = Integer.valueOf(42);
	}

}

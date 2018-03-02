package com.unihuatong.business.work.service.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.unihuatong.base.common.threadLocal.ParamsThreadLocal;
import com.unihuatong.business.work.service.IPriceService;

/**
 * @Description TODO(用一句话描述该文件做什么)
 * @author 戚兆宇
 * @date 2018年2月28日 下午3:21:35
 *
 */
@Service
public class PriceServiceImpl implements IPriceService {

	public List<Object> getPrice() {

		Double firstPrice = 0.0;
		Double secondPrice = 0.0;
		Double thirdPrice = 0.0;
		Double fourthPrice = 0.0;
		Double fifthPrice = 0.0;
		Double sixthPrice = 0.0;
		Double seventhPrice = 0.0;
		Double eighthPrice = 0.0;
		Double ninthPrice = 0.0;
		Double tenthPrice = 0.0;

		if (ParamsThreadLocal.get("firstPrice") != null) {
			firstPrice = Double.parseDouble(String.valueOf(ParamsThreadLocal.get("firstPrice")));
		}

		if (ParamsThreadLocal.get("secondPrice") != null) {
			secondPrice = Double.parseDouble(String.valueOf(ParamsThreadLocal.get("secondPrice")));
		}

		if (ParamsThreadLocal.get("thirdPrice") != null) {
			thirdPrice = Double.parseDouble(String.valueOf(ParamsThreadLocal.get("thirdPrice")));
		}

		if (ParamsThreadLocal.get("fourthPrice") != null) {
			fourthPrice = Double.parseDouble(String.valueOf(ParamsThreadLocal.get("fourthPrice")));
		}

		if (ParamsThreadLocal.get("fifthPrice") != null) {
			fifthPrice = Double.parseDouble(String.valueOf(ParamsThreadLocal.get("fifthPrice")));
		}

		if (ParamsThreadLocal.get("sixthPrice") != null) {
			sixthPrice = Double.parseDouble(String.valueOf(ParamsThreadLocal.get("sixthPrice")));
		}

		if (ParamsThreadLocal.get("seventhPrice") != null) {
			seventhPrice = Double.parseDouble(String.valueOf(ParamsThreadLocal.get("seventhPrice")));
		}

		if (ParamsThreadLocal.get("eighthPrice") != null) {
			eighthPrice = Double.parseDouble(String.valueOf(ParamsThreadLocal.get("eighthPrice")));
		}

		if (ParamsThreadLocal.get("ninthPrice") != null) {
			ninthPrice = Double.parseDouble(String.valueOf(ParamsThreadLocal.get("ninthPrice")));
		}

		if (ParamsThreadLocal.get("tenthPrice") != null) {
			tenthPrice = Double.parseDouble(String.valueOf(ParamsThreadLocal.get("tenthPrice")));
		}

		Double boxPrice = Double.parseDouble(String.valueOf(ParamsThreadLocal.get("boxPrice")));
		Double deliverPrice = Double.parseDouble(String.valueOf(ParamsThreadLocal.get("deliverPrice")));
		Double salePrice = Double.parseDouble(String.valueOf(ParamsThreadLocal.get("salePrice")));

		Integer personNum = Integer.valueOf(String.valueOf(ParamsThreadLocal.get("personNum")));

		Double sum = boxPrice + deliverPrice - salePrice;

		// 每份的差价
		Double differentPrice = sum / personNum;
		BigDecimal b = new BigDecimal(differentPrice);
		Double diffPrice = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

		// 总价格
		Double totlePrice = firstPrice + secondPrice + thirdPrice + fourthPrice + fifthPrice + sixthPrice + seventhPrice
				+ eighthPrice + ninthPrice + tenthPrice + sum;

		DecimalFormat df = new DecimalFormat("######0.00");
		// 每人应付的价格
		Double firstName = 0.0;
		Double secondName = 0.0;
		Double thirdName = 0.0;
		Double fourthName = 0.0;
		Double fifthName = 0.0;
		Double sixthName = 0.0;
		Double seventhName = 0.0;
		Double eighthName = 0.0;
		Double ninthName = 0.0;
		Double tenthName = 0.0;
		List<Object> list = new ArrayList<Object>();

		switch (personNum) {
		case 1:
			firstName = firstPrice + diffPrice;
			list.add(df.format(firstName));
			list.add(df.format(totlePrice));
			break;
		case 2:
			firstName = firstPrice + diffPrice;
			secondName = secondPrice + diffPrice;
			list.add(df.format(firstName));
			list.add(df.format(secondName));
			list.add(df.format(totlePrice));
			break;
		case 3:
			firstName = firstPrice + diffPrice;
			secondName = secondPrice + diffPrice;
			thirdName = thirdPrice + diffPrice;
			list.add(df.format(firstName));
			list.add(df.format(secondName));
			list.add(df.format(thirdName));
			list.add(df.format(totlePrice));
			break;
		case 4:
			firstName = firstPrice + diffPrice;
			secondName = secondPrice + diffPrice;
			thirdName = thirdPrice + diffPrice;
			fourthName = fourthPrice + diffPrice;
			list.add(df.format(firstName));
			list.add(df.format(secondName));
			list.add(df.format(thirdName));
			list.add(df.format(fourthName));
			list.add(df.format(totlePrice));
			break;
		case 5:
			firstName = firstPrice + diffPrice;
			secondName = secondPrice + diffPrice;
			thirdName = thirdPrice + diffPrice;
			fourthName = fourthPrice + diffPrice;
			fifthName = fifthPrice + diffPrice;
			list.add(df.format(firstName));
			list.add(df.format(secondName));
			list.add(df.format(thirdName));
			list.add(df.format(fourthName));
			list.add(df.format(fifthName));
			list.add(df.format(totlePrice));
			break;
		case 6:
			firstName = firstPrice + diffPrice;
			secondName = secondPrice + diffPrice;
			thirdName = thirdPrice + diffPrice;
			fourthName = fourthPrice + diffPrice;
			fifthName = fifthPrice + diffPrice;
			sixthName = sixthPrice + diffPrice;
			list.add(df.format(firstName));
			list.add(df.format(secondName));
			list.add(df.format(thirdName));
			list.add(df.format(fourthName));
			list.add(df.format(fifthName));
			list.add(df.format(sixthName));
			list.add(df.format(totlePrice));
			break;
		case 7:
			firstName = firstPrice + diffPrice;
			secondName = secondPrice + diffPrice;
			thirdName = thirdPrice + diffPrice;
			fourthName = fourthPrice + diffPrice;
			fifthName = fifthPrice + diffPrice;
			sixthName = sixthPrice + diffPrice;
			seventhName = seventhPrice + diffPrice;
			list.add(df.format(firstName));
			list.add(df.format(secondName));
			list.add(df.format(thirdName));
			list.add(df.format(fourthName));
			list.add(df.format(fifthName));
			list.add(df.format(sixthName));
			list.add(df.format(seventhName));
			list.add(df.format(totlePrice));
			break;
		case 8:
			firstName = firstPrice + diffPrice;
			secondName = secondPrice + diffPrice;
			thirdName = thirdPrice + diffPrice;
			fourthName = fourthPrice + diffPrice;
			fifthName = fifthPrice + diffPrice;
			sixthName = sixthPrice + diffPrice;
			seventhName = seventhPrice + diffPrice;
			eighthName = eighthPrice + diffPrice;
			list.add(df.format(firstName));
			list.add(df.format(secondName));
			list.add(df.format(thirdName));
			list.add(df.format(fourthName));
			list.add(df.format(fifthName));
			list.add(df.format(sixthName));
			list.add(df.format(seventhName));
			list.add(df.format(eighthName));
			list.add(df.format(totlePrice));
			break;
		case 9:
			firstName = firstPrice + diffPrice;
			secondName = secondPrice + diffPrice;
			thirdName = thirdPrice + diffPrice;
			fourthName = fourthPrice + diffPrice;
			fifthName = fifthPrice + diffPrice;
			sixthName = sixthPrice + diffPrice;
			seventhName = seventhPrice + diffPrice;
			eighthName = eighthPrice + diffPrice;
			ninthName = ninthPrice + diffPrice;
			list.add(df.format(firstName));
			list.add(df.format(secondName));
			list.add(df.format(thirdName));
			list.add(df.format(fourthName));
			list.add(df.format(fifthName));
			list.add(df.format(sixthName));
			list.add(df.format(seventhName));
			list.add(df.format(eighthName));
			list.add(df.format(ninthName));
			list.add(df.format(totlePrice));
			break;
		case 10:
			firstName = firstPrice + diffPrice;
			secondName = secondPrice + diffPrice;
			thirdName = thirdPrice + diffPrice;
			fourthName = fourthPrice + diffPrice;
			fifthName = fifthPrice + diffPrice;
			sixthName = sixthPrice + diffPrice;
			seventhName = seventhPrice + diffPrice;
			eighthName = eighthPrice + diffPrice;
			ninthName = ninthPrice + diffPrice;
			tenthName = tenthPrice + diffPrice;
			list.add(df.format(firstName));
			list.add(df.format(secondName));
			list.add(df.format(thirdName));
			list.add(df.format(fourthName));
			list.add(df.format(fifthName));
			list.add(df.format(sixthName));
			list.add(df.format(seventhName));
			list.add(df.format(eighthName));
			list.add(df.format(ninthName));
			list.add(df.format(tenthName));
			list.add(df.format(totlePrice));
			break;
		default:
			break;
		}

		return list;
	}
}

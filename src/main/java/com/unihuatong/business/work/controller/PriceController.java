package com.unihuatong.business.work.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unihuatong.base.common.annotation.NotNeedLogin;
import com.unihuatong.business.work.service.IPriceService;

/**
 * @Description TODO(用一句话描述该文件做什么)
 * @author 戚兆宇
 * @date 2018年2月28日 下午3:22:39
 *
 */
@RestController
@RequestMapping(value = "/price")
public class PriceController {

	@Autowired
	private IPriceService priceService;

	@RequestMapping(value = "/getPrice")
	@NotNeedLogin
	public List<Object> computePrice() {
		return priceService.getPrice();
	}
}

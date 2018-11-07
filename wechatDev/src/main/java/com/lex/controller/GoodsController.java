package com.lex.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("goods")
public class GoodsController {

	@RequestMapping("getGoodsById")
	@ResponseBody
	Object getGoodsById(int Id) throws Exception {
		return null;
	}
}

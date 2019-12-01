package rank.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
public class ConsultController {
	private static Logger logger = LoggerFactory.getLogger(ConsultController.class);

	/**
	 * 
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/rank/webapi.json")
	public byte[] rank(String name) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			String strConsult = JSON.toJSONString(list) + "_" + name;
			return strConsult.getBytes("UTF-8");
		} catch (Exception e) {
			logger.error("CurrencyController consultlist is error", e);
		}
		return null;
	}

}
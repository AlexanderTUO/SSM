/**
 * @projectName first
 * @package com.tyk.hutool.json
 * @className com.tyk.hutool.json.JsonTest
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.tyk.hutool.json;

import cn.hutool.core.io.resource.Resource;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * JsonTest
 * @description JSON测试类
 * @author tuoyangkun
 * @date 2020/6/3 17:40
 * @version 1.0
 */
public class JsonTest {
	public static void main(String[] args) throws FileNotFoundException {
		String jsons = "{'com':'zhongtong','data':[{'ftime':'2020-06-03 17:46:21','context':'【成都市】快件已在【中和二部】签收'}" +
				",{'ftime':'2020-06-01 17:46:21','context':'【成都市】快件已在【中和三部】签收'}]}";

		File jsonFile = ResourceUtils.getFile("classpath:template/jsonTest.json");
//		String json = FileUtils.readFileToString(jsonFile);

		JSONObject jsonObject = new JSONObject(jsons);
		String com = jsonObject.getStr("com");
		System.out.println(com);
		JSONArray array = jsonObject.getJSONArray("data");
		for (int i = 0; i < array.size(); i++) {
			JSONObject data = array.getJSONObject(i);
			String ftime = data.get("ftime").toString();
			String context = data.get("context").toString();
			System.out.println(ftime+":"+context);
		}
	}
}

package com.tentcoo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tentcoo.service.LibraryService;

@Controller
public class LibraryController {
	
	@Resource
	LibraryService libraryService;
	
	@RequestMapping(value="search_library_list")
	@ResponseBody
	public Map<String,Object> searchLibraryList(String word,String page){
		Map<String,Object> res = new HashMap<String,Object>();
		if(page==null || page.isEmpty()) {
			res.put("status", "error");
			return res;
		}
		if(word==null || word.isEmpty()) {
			res.put("status", "error");
			res.put("msg", "请输入查询关键字");
			return res;
		}
		int pageNumber = 0;
		try {
			pageNumber = Integer.valueOf(page);
		}catch(Exception e) {
			
		}
		if(pageNumber < 1) {
			pageNumber  = 0;
		}
		res.put("status", "ok");
		res.put("data", libraryService.queryByWord(word, pageNumber));
		return res;
	}

}

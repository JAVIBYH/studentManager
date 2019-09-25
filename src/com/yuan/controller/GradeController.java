package com.yuan.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yuan.bean.Grade;
import com.yuan.page.Page;
import com.yuan.service.GradeService;
import com.yuan.util.StringUtil;

/**
 * 年级信息管理
 * @author hjw
 *
 */
@Controller
@RequestMapping("/grade")
public class GradeController {
	
	@Autowired
	private GradeService gradeService;
	
	 
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView model){
		model.setViewName("grade/grade_list");
		return model;
	}
	
	/**
	 * 获取年级列表
	 * 实现分页
	 * @param name
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/get_list",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getList(
			@RequestParam(value="name",required=false,defaultValue="") String name,Page page){
		Map<String, Object> ret = new HashMap<String, Object>();
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("name", "%"+name+"%");
		queryMap.put("offset", page.getOffset());
		queryMap.put("pageSize", page.getRows());
		ret.put("rows", gradeService.findList(queryMap));
		ret.put("total", gradeService.getTotal(queryMap));
		return ret;
	}
	
	 
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> edit(Grade grade){
		Map<String, String> ret = new HashMap<String, String>();
		if(StringUtils.isEmpty(grade.getName())){
			ret.put("type", "error");
			ret.put("msg", "用户名不能为空");
			return ret;
		}
		if(gradeService.edit(grade) <= 0){
			ret.put("type", "error");
			ret.put("msg", "修改失败");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "修改成功");
		return ret;
	}
	
	
	 
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> add(Grade grade){
		Map<String, String> ret = new HashMap<String, String>();
		if(StringUtils.isEmpty(grade.getName())){
			ret.put("type", "error");
			ret.put("msg", "年级名称不能为空");
			return ret;
		}
		if(gradeService.add(grade) <= 0){
			ret.put("type", "error");
			ret.put("msg", "年级添加失败");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "年级添加成功");
		return ret;
	}
	
	 
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> delete(@RequestParam(value="ids[]",required=true) Long[] ids){
		Map<String, String> ret = new HashMap<String, String>();
		if(ids == null || ids.length == 0){
			ret.put("type", "error");
			ret.put("msg", "请选择要删除数据");
			return ret;
		}
		//年级下有班级存在不能删除
		try {
			if(gradeService.delete(StringUtil.joinString(Arrays.asList(ids), ",")) <= 0){
				ret.put("type", "error");
				ret.put("msg", "删除失败");
				return ret;
			}
		} catch (Exception e) {
			ret.put("type", "error");
			ret.put("msg", "该年级下有班级存在，不能删除");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "删除年级成功");
		return ret;
	}
	
}

package priv.mq.onePiece.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import priv.mq.onePiece.entities.Figure;
import priv.mq.onePiece.service.FigureService;

@Controller
public class FigureController {
	
	@Autowired
	private FigureService figureService;
	
	private Logger logger = Logger.getLogger(FigureController.class);
	
	@RequestMapping("Figures")
	public String Figures(){
		return "Figure/Figures";
	}

	@RequestMapping("saveFigure")
	public String saveFigure(){
		return "Figure/saveFigure";
	}
	
	/**
	 * 保存人物信息
	 * tips:1.报java.lang.IllegalStateException异常，age不能设置成int类型，int不能为null。
	 * @param name
	 * @param age
	 * @param characteristic
	 * @param hobby
	 * @param useWeapon
	 * @param weapon
	 * @param description
	 * @return
	 */
	@RequestMapping("saveFigureDone")
	public ModelAndView saveFigureDone(@RequestParam("name")String name, Integer age, String characteristic, String hobby, Boolean useWeapon, String weapon, String description){
		ModelAndView mav = new ModelAndView("Figure/saveFigureDone");
		if(StringUtils.isBlank(name)){
			return mav;
		}
		Figure figure = new Figure();
		figure.setName(name);
		figure.setPhotoPath(name + ".jpg");
		figure.setAge(age);
		figure.setCharacteristic(characteristic);
		figure.setHobby(hobby);
		if(useWeapon == true){
			figure.setUseWeapon(true);
			figure.setWeapon(weapon);
		}else{
			figure.setUseWeapon(false);
			figure.setWeapon("无");
		}
		figure.setDescription(description);
		figureService.saveFigure(figure);
		return mav;
	}
	
	@RequestMapping("getFigureDetail")
	public ModelAndView getFigureDetail(@RequestParam(defaultValue = "Luffy", value = "name")String name){
		ModelAndView mav = new ModelAndView("Figure/FigureDetail");
		try {
			mav.addObject("name",name);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("无相关数据！");
		}
		return mav;
	}
}

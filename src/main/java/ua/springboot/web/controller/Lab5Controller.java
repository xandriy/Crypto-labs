package ua.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ua.springboot.web.utils.Lab5Utils;

@Controller
public class Lab5Controller {

	@GetMapping("/lab5")
	public String showlab5(Model model) {
		model.addAttribute("fisrtArea", new String());
		model.addAttribute("secondArea", new String());
		model.addAttribute("key", new String());
		model.addAttribute("choice", new String());
		return "lab5";
	}
	
	@PostMapping("/lab5/get-data")
	public String lab1GetData(
			Model model,
			@ModelAttribute("firstArea")String firstArea,
			@ModelAttribute("secondArea")String secondArea,
			@ModelAttribute("key")String key,
			@ModelAttribute("choice")String choice
			) {
		
		if(choice.equals("code")) {
			secondArea = Lab5Utils.code(key, firstArea);
		}

		if(choice.equals("decode")) {
			secondArea = Lab5Utils.decode(key, firstArea);
		}
		model.addAttribute("firstArea", firstArea);
		model.addAttribute("secondArea", secondArea);
		model.addAttribute("key",  key);
		model.addAttribute("choice", new String());
		
		return "lab5";
	}
	
	
}

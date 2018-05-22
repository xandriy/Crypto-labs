package ua.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ua.springboot.web.utils.Lab1Utils;

@Controller
public class Lab1Controller {

	@GetMapping("/lab1")
	public String showlab1(Model model) {
		model.addAttribute("fisrtArea", new String());
		model.addAttribute("secondArea", new String());
		model.addAttribute("step", 21);
		model.addAttribute("choice", new String());
		return "lab1";
	}
	
	@PostMapping("/lab1/get-data")
	public String lab1GetData(
			Model model,
			@ModelAttribute("firstArea")String firstArea,
			@ModelAttribute("secondArea")String secondArea,
			@ModelAttribute("step")int step,
			@ModelAttribute("choice")String choice
			) {
		
		if(choice.equals("code")) {
			secondArea = Lab1Utils.codeString(step, firstArea);
		}

		if(choice.equals("decode")) {
			secondArea = Lab1Utils.decodeString(step, firstArea);
		}
		model.addAttribute("firstArea", firstArea);
		model.addAttribute("secondArea", secondArea);
		model.addAttribute("step",  step);
		model.addAttribute("choice", new String());
		
		return "lab1";
	}
	
}

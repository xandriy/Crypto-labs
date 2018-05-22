package ua.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ua.springboot.web.utils.Lab1Utils;
import ua.springboot.web.utils.Lab3Utils;

@Controller
public class Lab3Controller {


	@GetMapping("/lab3")
	public String showlab3(Model model) {
		model.addAttribute("fisrtArea", new String());

		return "lab3";
	}
	
	@PostMapping("/lab3/get-data")
	public String lab3GetData(
			Model model,
			@ModelAttribute("firstArea")String firstArea
			) {
		
		int[] frequency = Lab3Utils.countFrequencyOfLitters(firstArea);
		int step = Lab3Utils.getStep(frequency);
		String secondArea = Lab1Utils.decodeString(step, firstArea);
		model.addAttribute("frequency", Lab3Utils.countFrequencyOfLitters(firstArea));
		model.addAttribute("firstArea", firstArea);
		model.addAttribute("secondArea", secondArea);
		model.addAttribute("step",  step);
		
		return "lab3";
	}
}

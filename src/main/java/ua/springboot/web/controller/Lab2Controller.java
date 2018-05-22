package ua.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ua.springboot.web.utils.Lab2Utils;

@Controller
public class Lab2Controller {


	@GetMapping("/lab2")
	public String showlab2(Model model) {
		model.addAttribute("fisrtArea", new String());
		model.addAttribute("secondArea", new String());
		model.addAttribute("key", 21);
		model.addAttribute("choice", new String());
		model.addAttribute("loop", 3);

		return "lab2";
	}
	
	@PostMapping("/lab2/get-data")
	public String lab2GetData(
			Model model,
			@ModelAttribute("firstArea")String firstArea,
			@ModelAttribute("secondArea")String secondArea,
			@ModelAttribute("key")int key,
			@ModelAttribute("choice")String choice,
			@ModelAttribute("loop")int loop
			) {
		
		if(choice.equals("code")) {
			secondArea = Lab2Utils.codeString(key, firstArea, loop);
		}

		if(choice.equals("decode")) {
			secondArea = Lab2Utils.decodeString(key, firstArea, loop);
		}
		model.addAttribute("firstArea", firstArea);
		model.addAttribute("secondArea", secondArea);
		model.addAttribute("key", key);
		model.addAttribute("choice", new String());
		model.addAttribute("loop", loop);
		
		return "lab2";
	}
}

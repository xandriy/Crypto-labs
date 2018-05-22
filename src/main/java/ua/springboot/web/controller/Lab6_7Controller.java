package ua.springboot.web.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ua.springboot.web.utils.Lab6_7Utils;

@Controller
public class Lab6_7Controller {

	@GetMapping("/lab6-7")
	public String showlab5(Model model) {
		model.addAttribute("fisrtArea", new String());
		model.addAttribute("secondArea", new String());
		model.addAttribute("key", new String());
		model.addAttribute("choice", new String());
		return "lab6-7";
	}
	
	@PostMapping("/lab6-7/get-data")
	public String lab1GetData(
			Model model,
			@ModelAttribute("firstArea")String firstArea,
			@ModelAttribute("secondArea")String secondArea,
			@ModelAttribute("key")String key,
			@ModelAttribute("choice")String choice
			) {
		
		if(choice.equals("code")) {
			secondArea = Lab6_7Utils.code(key, firstArea);
			Map<Character, Integer> mapOfOpenKey = Lab6_7Utils.getMap(Lab6_7Utils.getCountOfEveryLeter(firstArea));
			model.addAttribute("countOpenLetters", mapOfOpenKey);
			
			Map<Character, Integer> mapOfCryptedKey = Lab6_7Utils.getMap(Lab6_7Utils.getCountOfEveryLeter(secondArea));
			model.addAttribute("countCodeLetters", mapOfCryptedKey);
		}

		if(choice.equals("decode")) {
			secondArea = Lab6_7Utils.decode(key, firstArea);
			
		}
		model.addAttribute("firstArea", firstArea);
		model.addAttribute("secondArea", secondArea);
		model.addAttribute("key",  key);
		model.addAttribute("choice", new String());
	
		
		return "lab6-7";
	}
	
}

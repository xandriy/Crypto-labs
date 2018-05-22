package ua.springboot.web.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ua.springboot.web.utils.Lab1Utils;
import ua.springboot.web.utils.Lab3Utils;
import ua.springboot.web.utils.Lab4Utils;

@Controller
public class Lab4Controller {

	@GetMapping("/lab4")
	public String showlab4(Model model) {
		model.addAttribute("firstArea", new String());
		model.addAttribute("secondArea", new String());
		model.addAttribute("choice", new String());
		model.addAttribute("textSize", 0);
		return "lab4";
	}
	
	@PostMapping("/lab4/get-data")
	public String lab3GetData(
			Model model,
			@ModelAttribute("firstArea")String firstArea,
			@ModelAttribute("secondArea")String secondArea,
			@ModelAttribute("choice")String choice,
			@ModelAttribute("textSize")int textSize
			) {
		try {
			if(choice.equals("code")) {
				textSize = Lab4Utils.code(firstArea);
			}
			if(choice.equals("decode")) {
				secondArea = Lab4Utils.decode(textSize);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("textSize", textSize);
		model.addAttribute("firstArea", new String());
		model.addAttribute("secondArea",secondArea);
		model.addAttribute("choice", new String());
		
		return "lab4";
	}
	
}

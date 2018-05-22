package ua.springboot.web.controller;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ua.springboot.web.utils.Lab8Utils;

@Controller
public class Lab8Controller {
	
	private byte[] encrypted;
	
	@GetMapping("/lab8")
	public String showlab8(Model model) {
		model.addAttribute("key", new String());
		model.addAttribute("initVector", new String());
		model.addAttribute("choice", new String());
		return "lab8";
	}
	
	@PostMapping("/lab8/get-data")
	public String lab8GetData(
			Model model,
			@ModelAttribute("key")String key,
			@ModelAttribute("initVector")String initVector,
			@ModelAttribute("choice")String choice
			) {
		try {
			if(choice.equals("code")) {
				encrypted = Lab8Utils.code(key,initVector);
				
			}

			if(choice.equals("decode")) {
				Lab8Utils.decode(key,initVector,encrypted);
			}
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("key",  key);
		model.addAttribute("initVector",initVector);
		model.addAttribute("choice", new String());
		
		return "lab8";
	}
}

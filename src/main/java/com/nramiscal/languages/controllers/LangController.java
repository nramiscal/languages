package com.nramiscal.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nramiscal.languages.models.Language;
import com.nramiscal.languages.services.LangService;

@Controller
public class LangController {
	
	private final LangService langService;
	
    public LangController(LangService langService){
        this.langService = langService;
    }
	
    @RequestMapping("/")
    public String index(Model model, @ModelAttribute("language") Language language) {
        List<Language> languages = langService.allLanguages();
        model.addAttribute("languages", languages);
        return "index";
    }
    
    @RequestMapping("/{index}")
    public String showLang(Model model, @PathVariable("index") int index) {
    		Language language = langService.findLangByIndex(index);
    		model.addAttribute("language", language);
    		return "showLang";
    }
   
   
    @PostMapping("/new")
    public String create(Model model, @Valid @ModelAttribute("language") Language language, BindingResult result) {
    		if (result.hasErrors()) {
    	        List<Language> languages = langService.allLanguages();
    	        model.addAttribute("languages", languages);
    			return "index";
    		}else {
    			langService.addLang(language);
    			return "redirect:/";
    		}
  
    }
    
    @RequestMapping("/edit/{id}")
    public String editLang(@PathVariable("id") int id, Model model) {
    		Language language = langService.findLangByIndex(id);
    		if (language != null) {
    			model.addAttribute("language", language);
    			return "edit";
    			
    		}else {
    			return "redirect:/";
    		}
    		
    }
    
    @PostMapping("/edit/{id}")
    public String updateBook(@PathVariable("id") int id, @Valid @ModelAttribute("language") Language language, BindingResult result) {
	    	if (result.hasErrors()) {
	    		return "edit";
	    	}else {
	    		langService.updateLang(id, language);
	    		return "redirect:/";
	    	}
    }
    
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
    		langService.deleteLang(id);
    		return "redirect:/";
    }

}

package com.nramiscal.languages.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import com.nramiscal.languages.models.Language;

@Service
public class LangService {
    
    // initialize the languages variable with values
    private List<Language> languages = new ArrayList<Language>(Arrays.asList(
            new Language("Java", "James Gosling", "1.8"),
            new Language("Python", "Guido van Rossum", "3.6"),
            new Language("JavaScript", "Brendan Eich", "1.9.5")
            ));
    
    // returns all the languages
    public List<Language> allLanguages() {
        return languages;
    }
    
    public Language findLangByIndex(int index) {
	    	if (index < languages.size()) {
	    		return languages.get(index);
	    	} else {
	    		return null;
	    	}
    }
    
    public void addLang(Language language) {
    		languages.add(language);
    }
    
    public void updateLang(int id, Language language) {
    		if (id < languages.size()) {
    			languages.set(id, language);
    			
    		}
    }
    
    public void deleteLang(int id) {
    		if (id < languages.size()) {
    			languages.remove(id);
    		}
    }
}
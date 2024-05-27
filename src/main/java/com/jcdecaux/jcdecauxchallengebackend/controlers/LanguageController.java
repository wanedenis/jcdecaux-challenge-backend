package com.jcdecaux.jcdecauxchallengebackend.controlers;

import com.jcdecaux.jcdecauxchallengebackend.models.Language;
import com.jcdecaux.jcdecauxchallengebackend.models.LanguageDto;
import com.jcdecaux.jcdecauxchallengebackend.services.LanguageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {


    private final LanguageService languageServices;

    public LanguageController(LanguageService languageServices) {
        this.languageServices = languageServices;
    }

    @GetMapping
    public ResponseEntity<List<Language>> getAllLanguages() {

        try {
            List<Language> languages = languageServices.getListLanguages();
            return new ResponseEntity<>(languages, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Language> createLanguage(@RequestBody LanguageDto language) {

        try {
            Language _lang = languageServices.createLanguage(language);
            if (_lang != null) return new ResponseEntity<>(_lang, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}

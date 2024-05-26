package com.jcdecaux.jcdecauxchallengebackend.controlers;

import com.jcdecaux.jcdecauxchallengebackend.models.Developpeur;
import com.jcdecaux.jcdecauxchallengebackend.models.DeveloppeurDto;
import com.jcdecaux.jcdecauxchallengebackend.models.LanguageDto;
import com.jcdecaux.jcdecauxchallengebackend.services.DeveloppeurServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class DeveloppeurController {

    private final DeveloppeurServices developpeurServices;

    public DeveloppeurController(DeveloppeurServices developpeurServices) {
        this.developpeurServices = developpeurServices;
    }

    @GetMapping("/developpeurs")
    public ResponseEntity<List<Developpeur>> getAllDeveloppeurs(@RequestParam(required = false) String language) {

        try {
            List<Developpeur> developpeurs = developpeurServices.getListDeveloppeurs(language);
            return new ResponseEntity<>(developpeurs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/developpeurs")
    public ResponseEntity<Developpeur> createDeveloppeur(@RequestBody DeveloppeurDto developpeur) {

        try {
            Developpeur _dev = developpeurServices.createDeveloppeur(developpeur);
            if (_dev != null) return new ResponseEntity<>(_dev, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/developpeurs/{id}")
    public ResponseEntity<Developpeur> updateDeveloppeur(@PathVariable("id") long id, @RequestBody DeveloppeurDto developpeur) {

        try{
            Developpeur _dev = developpeurServices.updateDeveloppeur(developpeur, id);
            if (_dev != null) return new ResponseEntity<>(_dev, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/developpeurs/{id}")
    public ResponseEntity<String> addLanguageToDeveloppeur(@PathVariable("id") long id, @RequestBody LanguageDto languageDto) {

        try{
            if (developpeurServices.addLanguageToDeveloppeur(languageDto, id))
                return new ResponseEntity<>("true", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}

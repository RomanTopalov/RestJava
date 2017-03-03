package ua.controller;


import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.entity.Human;
import ua.servise.HumanServise;

import java.security.Principal;
import java.text.ParseException;
import java.util.List;

/**
 * Created by -rom- on 13.02.2017.
 */
@RestController
public class HumanController  {

    @Autowired
    private HumanServise humanServise;

    @RequestMapping(value = "/saveHuman", method = RequestMethod.POST)
    public List<Human> saveHuman(@RequestBody  Human human){

        humanServise.save(human);

        return humanServise.findAll();
    }
    @RequestMapping(value = "/deleteHuman", method = RequestMethod.POST)
    public List<Human> loadHumans(@RequestBody String index) {

        humanServise.delete(Integer.parseInt(index));

        return humanServise.findAll();

    }

}

/*@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/loadCountries", method = RequestMethod.POST)
    public List<CountryDTO> loadCountries() {

        return DtoUtilMapper.countriesToCountriesDTOs(countryService.findAll());

    }

    @RequestMapping(value = "/saveCountry", method = RequestMethod.POST)
    public List<CountryDTO> saveCountry(@RequestBody Country country) {

        countryService.save(country);

        return DtoUtilMapper.countriesToCountriesDTOs(countryService.findAll());

    }

    @RequestMapping(value = "/deleteCountry", method = RequestMethod.POST)
    public List<CountryDTO> loadCountries(@RequestBody String index) {

        countryService.delete(Integer.parseInt(index));

        return DtoUtilMapper.countriesToCountriesDTOs(countryService.findAll());

    }

}*/

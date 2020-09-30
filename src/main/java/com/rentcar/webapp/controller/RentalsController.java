package com.rentcar.webapp.controller;

import com.rentcar.webapp.Exception.MasterException;
import com.rentcar.webapp.entity.Rentals;
import com.rentcar.webapp.service.RentalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class RentalsController {

    @Autowired
    private RentalsService rentalsService;

    @RequestMapping(value = "/rentals", method = RequestMethod.GET)
    public String getUsers(Model model){

        List<Rentals> rentals = rentalsService.all();
        model.addAttribute("Rentals",rentals);
        model.addAttribute("Titolo", "Ricerca Noleggi");
        model.addAttribute("Titolo2","Risultati Ricerca");
        return "rentals";
    }
    //-----------------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "/rental/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Rentals insertRental(@RequestBody Rentals rental, Model model, HttpServletResponse response) throws IOException {

        try {
            return rentalsService.create(rental);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    //-----------------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "/rental/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Rentals updateRental(@RequestBody Rentals rental, Model model, HttpServletResponse response) throws IOException {
        try {

            return rentalsService.update(rental);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @RequestMapping(value = "/user/delete", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteRental(@RequestBody Rentals rental, HttpServletResponse response) throws IOException {

        try {
            rentalsService.delete(rental);
        } catch (MasterException e) {
            throw e;
        }
    }
}

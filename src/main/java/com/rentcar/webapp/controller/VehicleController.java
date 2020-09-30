package com.rentcar.webapp.controller;

import com.rentcar.webapp.entity.Vehicle;
import com.rentcar.webapp.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(value = "/vehicles", method = RequestMethod.GET)
    public String getUsers(Model model){

        List<Vehicle> vehicles = vehicleService.all();
        model.addAttribute("Vehicles",vehicles);
        model.addAttribute("Titolo", "Ricerca Veicoli");
        model.addAttribute("Titolo2","Risultati Ricerca");
        return "vehicles";
    }

    @RequestMapping(value = "/vehicle/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public  @ResponseBody Vehicle insertVehicle(@RequestBody Vehicle vehicle, Model model, HttpServletResponse response) throws IOException {

        try {
            return vehicleService.create(vehicle);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @RequestMapping(value = "/vehicle/update", method = RequestMethod.PUT  , consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Vehicle updateVehicle(@RequestBody Vehicle vehicle, Model model, HttpServletResponse response) throws IOException {
        try {
            return vehicleService.update(vehicle);
        } catch (RuntimeException e) {
            throw e;
        }

    }

    @RequestMapping(value = "/vehicle/delete", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteVehicle(@RequestBody Vehicle vehicle, Model model, HttpServletResponse response) throws IOException {
        try {

            vehicleService.delete(vehicle);
        } catch (RuntimeException e) {
            throw e;
        }

    }


}

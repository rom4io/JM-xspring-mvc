package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Service.CarService;

@Controller
public class Carcontroller {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public String CarsCont(@RequestParam(value = "count", required = false) Integer count, ModelMap model){
        if (count == null){
        model.addAttribute("messages",carService.getAllCars());
        }
        else if (count != null){
            model.addAttribute("messages", carService.getCountCars(count));
        }
        return "index";
    }
}

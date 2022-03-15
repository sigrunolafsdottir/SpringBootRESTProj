package com.example.demoproj1.luckyyou;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class Övningsuppgift1_LuckyYou {


    private int random() {
        return (int) (Math.random() * 10) + 1;
    }

    private String randomAnimal() {
        switch ((int) (Math.random() * 4)) {
            case 0:
                return "skata";
            case 1:
                return "hund";
            case 2:
                return "spindel";
            default:
                return "katt";
        }
    }

    //uppg1b
    //http://localhost:8080/luckyYouB?type=animal
    //http://localhost:8080/luckyYouB?type=number
    @RequestMapping("/luckyYouB")
    public String ly(@RequestParam String type) {
        if (type.equalsIgnoreCase("animal")) {
            return randomAnimal();
        } else if (type.equalsIgnoreCase("number")) {
            return String.valueOf(random());
        } else return "I don't understand";
    }

    //uppg1c
    @RequestMapping("/luckyYouC")
    public String lyc(@RequestParam String type,
                      @RequestParam(required = false) String firstname,
                      @RequestParam(required = false) String lastname) {

        String f = "";
        String l = "";
        if (firstname != null) {
            f = firstname;
        }
        if (lastname != null) {
            l = lastname + ", ";
        }

        if (type.equalsIgnoreCase("animal")) {
            return f + " " + l + " ditt lyckodjur är " + randomAnimal();
        } else if (type.equalsIgnoreCase("number")) {
            return f + " " + l + " ditt lyckonummer är " + String.valueOf(random());
        } else return "I don't understand";
    }

    //1d
    @RequestMapping("/luckyYouD")
    public String lyd(@RequestParam String type,
                      @RequestParam(required = false, defaultValue = "Sigrun") String firstname,
                      @RequestParam(required = false, defaultValue = "Olafsdottir") String lastname) {

        String f = "";
        String l = "";
        if (firstname != null) {
            f = firstname;
        }
        if (lastname != null) {
            l = lastname + ", ";
        }

        if (type.equalsIgnoreCase("animal")) {
            return f + " " + l + " ditt lyckodjur är" + randomAnimal();
        } else if (type.equalsIgnoreCase("number")) {
            return f + " " + l + " ditt lyckonummer är" + String.valueOf(random());
        } else return "I don't understand";
    }

    //uppg1e
    @RequestMapping("/luckyYouE")
    public String le(@RequestParam String type, @RequestParam List<Integer> unlucky) {
        if (type.equalsIgnoreCase("animal")) {
            return randomAnimal();
        } else if (type.equalsIgnoreCase("number")) {
            boolean b = true;
            int nr = 0;
            while (b) {
                nr = random();
                if (!unlucky.contains(nr)) {
                    b = false;
                }
            }
            return String.valueOf(nr);
        } else return "I don't understand";
    }

    //uppgf
    @RequestMapping("/luckyYouF")
    public List<String> lf(@RequestParam String type, @RequestParam List<Integer> unlucky) {
        List<String> res = new LinkedList<>();
        if (type.equalsIgnoreCase("animal")) {
            res.add(randomAnimal());
        } else if (type.equalsIgnoreCase("number")) {
            for (int i = 1; i < 11; i++) {
                if (!unlucky.contains(i)) {
                    res.add(String.valueOf(i));
                }
            }
        }
        return res;
    }


    //uppg1g
    @RequestMapping("/luckyYouG/{type}")
    public String lyg(@PathVariable String type) {
        if (type.equalsIgnoreCase("animal")) {
            return randomAnimal();
        } else if (type.equalsIgnoreCase("number")) {
            return String.valueOf(random());
        } else return "I don't understand";
    }

    //uppg1g
    @RequestMapping(value = "/luckyYouHTML")
    public String hejhtml() {
        return "<html><head></head><body><h1>hej</h1> på er</body></html>";
    }

}
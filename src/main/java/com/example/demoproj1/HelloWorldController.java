package com.example.demoproj1;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
public class HelloWorldController {

    //anrop: http://localhost:8080
    @RequestMapping("/")
    public String index(){
        return "Hello World";
    }

    //anrop: http://localhost:8080/swe
    @RequestMapping("/swe")
    public String indexSwe(){
        return "Hejsan Världen";
    }

    //anrop: http://localhost:8080/esp
    @RequestMapping("/esp")
    public String indexEsp(){
        return "Hola Mundo";
    }

    //anrop: http://localhost:8080/hello?firstname=sigrun&lastname=olafsdottir
    @RequestMapping("/hello")
    public String helloParam(@RequestParam String firstname, @RequestParam String lastname){
        return "Hejsan "+firstname+ " "+lastname;
    }

    //anrop: http://localhost:8080/helloOptional?firstname=sigrun&lastname=olafsdottir
    //anrop: http://localhost:8080/helloOptional?firstname=sigrun
    //anrop: http://localhost:8080/helloOptional
    @RequestMapping("/helloOptional")
    public String helloOptional(@RequestParam(required = false) String firstname,
                                @RequestParam(required = false) String lastname) {
        String name = "";
        if (firstname != null){
            name = firstname;
        }
        if (lastname != null){
            if (name.length() == 0) name = lastname;
            else  name += " "+lastname;
        }
        return "Hej " + name;
    }

    //http://localhost:8080/helloHTML?firstname=sigrun&lastname=olafsdottir
    @RequestMapping("/helloHTML")
    public String helloHTML(@RequestParam String firstname, @RequestParam String lastname) {
        return "<H1>Hejsan " + firstname + " " + lastname+ "</h1>";
    }

    //anrop: http://localhost:8080/defaultHello
    @RequestMapping("/defaultHello")
    public String defaultHello(@RequestParam(defaultValue = "Sigrun") String name) {
        return "Hej " + name;
    }

    //anrop: http://localhost:8080/listHello?id=2,3,4,5
    @RequestMapping("/listHello")
    public String listHello(@RequestParam List<String> id) {
        return "IDs are " + id;
    }

    //anrop: http://localhost:8080/pathvartest/5
    @RequestMapping("/pathvartest/{id}")
    public String pathvartest(@PathVariable String id) {
        return "ID: " + id;
    }
}

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.validation.Valid;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class DemoApplication {

    @Controller
    public class HelloController {
        private  List<Customer> list = new ArrayList();

        @GetMapping(value = "/")
        public String index() {
            return "pealeht";
        }

        @GetMapping(value = "/müügiks")
        @ResponseBody
        public String müügiks() {
            String str = "";
            for (Customer i: list) {
                str = str +"<p>"+ i.getId() +"  "+ i.getFirstname() +"  "+ i.getLastname()+ "</p>";
            }
            return str;
        }


        @RequestMapping(value="/form", method=RequestMethod.GET)
        public String customerForm(Model model) {
            model.addAttribute("customer", new Customer());
            return "form";
        }



        @RequestMapping(value="/form", method=RequestMethod.POST)
        public String customerSubmit(@ModelAttribute Customer customer, Model model) {

            model.addAttribute("customer", customer);
            String info = String.format("hind = %d, nimi = %s, kirjeldus = %s",
                    customer.getId(), customer.getFirstname(), customer.getLastname());
            System.out.println(info);
            list.add(customer);

            return "result";
        }


        /*
        @PostMapping(value = "/upload.html")
        public String addFile(@ModelAttribute UserFile userFile) {

            //storageService.add(userFile, file);
            System.out.println(userFile.title);

            ResponseEntity response = new ResponseEntity(HttpStatus.OK);
            return "ok";
        }
        */

        @RequestMapping(value = "/greeting.html")
        public String gotGreeting() {
            return "/src/greeting.html";
        }

    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

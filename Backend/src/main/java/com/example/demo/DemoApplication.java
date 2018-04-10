package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
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
import java.sql.Array;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class DemoApplication {

    @Controller
    public class HelloController {
        private  List<Item> list = new ArrayList();
        private  List<Item> mainPageList = new ArrayList();
        private long id = 0;


        public HelloController() {


            Item item1 = new Item();
            item1.setName("Kõrvaklapid");
            item1.setPrice(200);
            item1.setCategory("Elektroonika");
            //item1.setImageAddress("https://images-na.ssl-images-amazon.com/images/I/61DBkN7aPsL._SL1200_.jpg");
            item1.setImageAddress("https://images-na.ssl-images-amazon.com/images/I/51z8lU3xnFL._SL500_AC_SS350_.jpg");
            list.add(item1);

            Item item2 = new Item();
            item2.setName("kohvimasin");
            item2.setPrice(300);
            item2.setCategory("Kodumasinad");
            item2.setImageAddress("https://images.philips.com/is/image/PhilipsConsumer/HD7450_20-IMS-en_HK?wid=494&hei=435&$pnglarge$");
            list.add(item2);

            Item item3 = new Item();
            item3.setName("telefon");
            item3.setPrice(400);
            item3.setCategory("Telefonid");
            item3.setImageAddress("http://images.samsung.com/is/image/samsung/p5/uk/pcd/smartphones/PCD-J5.png?$ORIGIN_PNG$");
            list.add(item3);

            Item item4 = new Item();
            item4.setName("ehetekarp");
            item4.setPrice(300);
            item4.setCategory("Ehted");
            item4.setImageAddress("https://www.westelm.com/weimgs/ab/images/wcm/products/201809/0046/grand-mirrored-jewelry-box-o.jpg");
            list.add(item4);

            Item item5 = new Item();
            item5.setName("padi");
            item5.setPrice(30);
            item5.setCategory("Kodu");
            item5.setImageAddress("https://img.etsystatic.com/il/e08c48/436362914/il_fullxfull.436362914_3bjr.jpg?version=1");
            list.add(item5);

            Item item6 = new Item();
            item6.setName("tööriistakarp");
            item6.setPrice(400);
            item6.setCategory("Tööriistad");
            item6.setImageAddress("https://images-na.ssl-images-amazon.com/images/I/51yPJo4VN2L._SY300_.jpg");
            list.add(item6);

        }

        public void newMainList() {
            for (Item item: list) {
                System.out.println(item.getCategory());
                if (item != null && item.getCategory()!=null) {
                    if (item.getCategory().equals("Elektroonika")) {
                        mainPageList.add(0, item);
                    }
                    if (item.getCategory().equals("Kodumasinad")) {
                        mainPageList.add(1, item);
                    }
                    if (item.getCategory().equals("Telefonid")) {
                        mainPageList.add(2, item);
                    }
                    if (item.getCategory().equals("Ehted")) {
                        mainPageList.add(3, item);
                    }
                    if (item.getCategory().equals("Kodu")) {
                        mainPageList.add(4, item);
                    }
                    if (item.getCategory().equals("Tööriistad")) {
                        mainPageList.add(5, item);
                    }
                }

            }
        }


        @Autowired
        private JdbcTemplate jdbcTemplate;



        @GetMapping(value = "/")
        public String index(Model model) {
            newMainList();
            model.addAttribute("items", mainPageList);
            return "src/Aurelia/src/mainPage.html"; //src/Aurelia/src/mainPage.html
        }

        @GetMapping(value = "/loggedin")
        public String logedin(Model model) {
            newMainList();
            model.addAttribute("items", mainPageList);
            return "src/Aurelia/src/mainPageLoggedIn.html"; //src/Aurelia/src/mainPage.html
        }

        @RequestMapping(value="/loggedin", method=RequestMethod.POST)
        public String itemSubmit(@ModelAttribute Item item, Model model) {

            model.addAttribute("item", item);
            String info = String.format("hind = %d, nimi = %s, description = %s",
                    item.getPrice(), item.getName(), item.getDescription());
            System.out.println(info+ "  " + item.getCategory());
            list.add(item);

            return "src/Aurelia/src/mainPageLoggedIn.html";
        }



        @RequestMapping(value="/", method=RequestMethod.POST)
        public String returnItems(@ModelAttribute Item item, Model model) {
            model.addAttribute("item", item);
            String info = String.format("nimi = %s",
                    item.getName());

            return "src/Aurelia/src/mainPage.html";
        }


        @RequestMapping(value="/form", method=RequestMethod.GET)
        public String customerForm(Model model) {
            model.addAttribute("item", new Item());
            return "form";
        }


        @RequestMapping(value="/form", method=RequestMethod.POST)
        public String customerSubmit(@ModelAttribute Item item, Model model) {

            model.addAttribute("item", item);
            String info = String.format("hind = %d, nimi = %s, category = %s, pictureAdress = %s",
                    item.getPrice(), item.getName(), item.getCategory(), item.getImageAddress());

            list.add(item);
            id++;

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

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class DemoApplication {

    @Controller
    public class HelloController {
        private  List<Item> list = new ArrayList();
        private  List<Item> mainPageList = new ArrayList();
        private  List<Item> arvutidList = new ArrayList();
        private  List<Item> kodumasinadList = new ArrayList();
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

            Item item7 = new Item();
            item7.setName("tolmuimeja");
            item7.setPrice(700);
            item7.setCategory("Kodumasinad");
            item7.setImageAddress("data:image/jpeg;base64,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");
            list.add(item7);

            Item item8 = new Item();
            item8.setName("veekeetja");
            item8.setPrice(50);
            item8.setCategory("Kodumasinad");
            item8.setImageAddress("data:image/jpeg;base64,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");
            list.add(item8);

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
                        if (!kodumasinadList.contains(item)) {
                            kodumasinadList.add(item);
                        }
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

        public void insertToDB(Item item){
            String sql = "INSERT INTO items VALUE " +  item;
            jdbcTemplate.execute(sql);
        }



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



        @GetMapping(value = "/kodumasinad")
        public String arvutid(Model model) {
            newMainList();
            model.addAttribute("items", kodumasinadList);
            return "src/Aurelia/src/Kodumasinad"; //src/Aurelia/src/mainPage.html
        }


        @RequestMapping(value="/kodumasinad", method=RequestMethod.POST)
        public String returnArvutid(@ModelAttribute Item item, Model model) {
            model.addAttribute("item", item);
            String info = String.format("nimi = %s",
                    item.getName());

            return "Kodumasinad";
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
            insertToDB(new Item());
            return "/src/greeting.html";
        }

    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

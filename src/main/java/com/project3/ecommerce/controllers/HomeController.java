package com.project3.ecommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
    @GetMapping("/home")
    public String getIndex(Model model){
        model.addAttribute("prodName","Gian penguin Shirt");
        model.addAttribute("prodDescription","Super cool penguin shirt");
        return "Index";
    }

    @GetMapping("/shop")
    public String showProducts(Model model){
        String product="blackmugYeti.jpg";
        String name="Black Mug";
        String price="$34.00";
        String category="Mugs";
        String description="Material con CALIDAD DE LUXE (AAA), resistente a ralladuras," +
                    " estropajos y lavavajillas. Apto para el microondas. Taza de color blanco " +
                    "recubierta con barniz de calidad superior.";
        model.addAttribute("product",product);
        model.addAttribute("name",name);
        model.addAttribute("price",price);
        model.addAttribute("category",category);
        model.addAttribute("description",description);
        return "product";
    }

    @GetMapping("/catalogue")
    public String showCategory(Model model){
        String catalogProduct="blackmugYeti.jpg";
        String name="Black Mug";
        String price="$34.00";
        model.addAttribute("catalogProduct",catalogProduct);
        model.addAttribute("name",name);
        model.addAttribute("price",price);
        return "catalogue";
    }

    @GetMapping("/cart")
    public String showShoppingCart(Model model){
        String cartProduct="blackmugYeti.jpg";
        String name="Black Mug";
        String price="$34.00";
        String totalPrice="$68.00";
        model.addAttribute("cartProduct",cartProduct);
        model.addAttribute("name",name);
        model.addAttribute("price",price);
        model.addAttribute("totalPrice",totalPrice);
        return "shoppingCart";
    }

    @GetMapping("/pay")
    public String showPaymentView(Model model){

        return "payment";
    }



}

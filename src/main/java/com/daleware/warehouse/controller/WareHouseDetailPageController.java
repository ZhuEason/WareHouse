package com.daleware.warehouse.controller;

import com.daleware.warehouse.basic.WareHouseUtil;
import com.daleware.warehouse.dao.UnshippedItemDao;
import com.daleware.warehouse.model.DynamoDBUnshippedItem;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@Configuration
@RequestMapping("/")
public class WareHouseDetailPageController {

    @Value("${default.message}")
    private String defaultMessage;

    @Autowired
    private UnshippedItemDao unshippedItemDao;

    @RequestMapping(value="/unshippedItem", method = RequestMethod.GET)
    public String getUnshippedItem(@RequestParam(value = "email", required = false, defaultValue = "stranger") String name, Model model) {
    /*
        Note: Alternately, you can also use this:
            public String printWelcome(String name, ModelMap model)
        This works only because the parameter name and the variable name happen to be the same; if they are not, then use the
        @RequestParam annotation.
    */
        model.addAttribute("email", "zhuyisong1994@gmail.com");
        model.addAttribute("unshippedPackage", unshippedItemDao.loadUnshippedPackage("zhuyisong1994@gmail.com", "FBA15DVVJ04PU000002_4011200296908"));

        DynamoDBUnshippedItem unshippedItem = unshippedItemDao.loadUnshippedPackage(
                "zhuyisong1994@gmail.com",
                "FBA15DVVJ04PU000002_4011200296908");

        List<DynamoDBUnshippedItem> unshippedItems = unshippedItemDao.loadUnshippedPackageByEmail("zhuyisong1994@gmail.com");

        /*String unshippedItemJSON = WareHouseUtil.getJSONStringfromObject(
                unshippedItemDao.loadUnshippedPackage(
                        "zhuyisong1994@gmail.com",
                        "FBA15DVVJ04PU000002_4011200296908"
                ));*/
        System.out.println(unshippedItems);

        model.addAttribute("unshippedItems", unshippedItems);

        return "mainPage";
    }

    @RequestMapping(value="/unshippedItemData", method = RequestMethod.GET)
    public void getUnshippedItemData(@RequestParam(value = "email", required = false, defaultValue = "stranger") String name,
                                     HttpServletRequest request,
                                     HttpServletResponse response) throws IOException {
    /*
        Note: Alternately, you can also use this:
            public String printWelcome(String name, ModelMap model)
        This works only because the parameter name and the variable name happen to be the same; if they are not, then use the
        @RequestParam annotation.
    */
        String unshippedItemJSON = WareHouseUtil.getJSONStringfromObject(
                unshippedItemDao.loadUnshippedPackage(
                        "zhuyisong1994@gmail.com",
                        "FBA15DVVJ04PU000002_4011200296908"
                ));

        response.getWriter().write(unshippedItemJSON);
    }

    @RequestMapping(value="/goodbye", method = RequestMethod.GET)
    public String printGoodbye(ModelMap model) {
        model.addAttribute("message", "Goodbye");
        return "goodbye";
    }

    /*
    @RequestMapping(value="/form", method=RequestMethod.GET)
    public String loadFormPage(Model m) {
        m.addAttribute("person", new Person());
        return "form";
    }

    @RequestMapping(value="/result", method=RequestMethod.POST)
    public String showResultPage(Person person, Model m) {
        m.addAttribute("name", person.getName());
        m.addAttribute("email", person.getEmail());
        return "result";
    } */

}

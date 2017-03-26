package com.epam.tsylko.andrei.controller;

import com.epam.tsylko.andrei.dao.PersonDao;
import com.epam.tsylko.andrei.dao.PhoneDao;
import com.epam.tsylko.andrei.model.Person;
import com.epam.tsylko.andrei.model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PageController {


    @Autowired
    private PersonDao personDao;

    @Autowired
    private PhoneDao phoneDao;


    @RequestMapping("/")
    public String getPeople(Model model) {
        List<Person> people = personDao.getPeople();
        model.addAttribute("people", people);
        return "main";
    }

    @RequestMapping("/main/deletePerson/{id}")
    public String deletePerson(@PathVariable int id) {
        Person person = personDao.getPersonById(id);
        personDao.deletePerson(person);
        return "redirect:/";
    }

    //    Add person Post/redirect/get pattern

    @RequestMapping("/main/addPerson")
    public String addPerson(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "addPerson";
    }

    @RequestMapping(value = "/main/addPerson", method = RequestMethod.POST)
    public String addPersonPost(@ModelAttribute("person") @Valid Person person, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "addPerson";
        }
        redirectAttributes.addFlashAttribute("person", person);
        return "redirect:/main/savePerson";
    }

    @RequestMapping("/main/savePerson")
    public String savePerson(@ModelAttribute("person") Person person) {
        personDao.addPerson(person);
        return "redirect:/";
    }

    //Edit person

    @RequestMapping(value = "/main/editPerson/{id}", method = RequestMethod.GET)
    public String editPerson(@PathVariable int id, Model model) {
        Person person = personDao.getPersonById(id);
        System.out.println("MAIN EDIT PERSON");
        System.out.println(person.toString());
        model.addAttribute("person", person);
        return "editPage";
    }

    @RequestMapping(value = "/main/editPerson/{id}", method = RequestMethod.POST)
    public String editPersonPost(@PathVariable int id, @ModelAttribute("person") @Valid Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "editPage";
        }
        personDao.updatePerson(person);

        return "redirect:/";
    }


//    @RequestMapping("/main/saveEditPerson")
//    public String saveEditPerson(@ModelAttribute("person") Person person) {
//        System.out.println("SAVE EDIT PERSON");
//        System.out.println(person.toString());
//        personDao.updatePerson(person);
//        return "redirect:/";
//    }

//Edit phone Post/redirect/get pattern

    @RequestMapping("/main/editPhone/{id}")
    public String editPhone(@PathVariable("id") int id, Model model) {
        Phone phone = phoneDao.getPhoneById(id);
        model.addAttribute("phone", phone);
        return "editPhone";
    }

    @RequestMapping(value = "/main/editPhone/{id}", method = RequestMethod.POST)
    public String editPhonePost(@Valid @ModelAttribute("phone") Phone phone, BindingResult result, @RequestParam int id, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "editPhone";
        }
        redirectAttributes.addFlashAttribute("phone", phone);
        return "redirect:/main/saveEditPerson";
    }

    @RequestMapping(value = "/main/saveEditPerson", method = RequestMethod.GET)
    public String saveEditPhone(@ModelAttribute("phone") Phone phone) {
        phoneDao.updatePhone(phone);
        return "redirect:/main/editPerson/" + phone.getOwner().getId();
    }

// Delete phone

    @RequestMapping("/main/deletePhone/{id}")
    public String deletePhone(@PathVariable("id") int id) {
        Phone phone = phoneDao.getPhoneById(id);
        phoneDao.deletePhone(phone);
        return "redirect:/main/editPerson/" + phone.getOwner().getId();
    }

//    Add phone to person. Post/redirect/get pattern

    @RequestMapping("/main/addPhone/{id}")
    public String addPhone(@PathVariable("id") int id, Model model) {
        Phone phone = new Phone();
        Person person = personDao.getPersonById(id);
        phone.setOwner(person);
        model.addAttribute("phone", phone);
        return "addPhone";
    }

    @RequestMapping(value = "/main/addPhone", method = RequestMethod.POST)
    public String addPhonePost(@Valid @ModelAttribute("phone") Phone phone, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "addPhone";
        }
        redirectAttributes.addFlashAttribute("phone", phone);
        return "redirect:/main/savePhone";
    }

    @RequestMapping(value = "/main/savePhone", method = RequestMethod.GET)
    public String savePhone(@ModelAttribute("phone") Phone phone) {
        phoneDao.addPhone(phone);
        return "redirect:/main/editPerson/" + phone.getOwner().getId();
    }


}

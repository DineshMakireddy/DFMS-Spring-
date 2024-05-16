package com.example.dairyfarm.controller;

import com.example.dairyfarm.entity.Company;
import com.example.dairyfarm.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public String listCompanies(Model model) {
        List<Company> companies = companyService.findAll();
        model.addAttribute("companies", companies);
        return "companies";
    }

    @GetMapping("/new")
    public String showCompanyForm(Model model) {
        Company company = new Company();
        model.addAttribute("company", company);
        return "company-form";
    }

    @PostMapping
    public String saveCompany(@ModelAttribute("company") Company company) {
        companyService.save(company);
        return "redirect:/companies";
    }

    @GetMapping("/edit/{id}")
    public String showCompanyFormForUpdate(@PathVariable Long id, Model model) {
        Optional<Company> company = companyService.findById(id);
        model.addAttribute("company", company);
        return "company-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCompany(@PathVariable Long id) {
        companyService.deleteById(id);
        return "redirect:/companies";
    }
}

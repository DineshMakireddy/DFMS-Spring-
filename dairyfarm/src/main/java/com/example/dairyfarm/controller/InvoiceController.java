package com.example.dairyfarm.controller;

import com.example.dairyfarm.entity.Invoice;
import com.example.dairyfarm.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public String listInvoices(Model model) {
        List<Invoice> invoices = invoiceService.findAll();
        model.addAttribute("invoices", invoices);
        return "invoices";
    }

    @GetMapping("/new")
    public String showInvoiceForm(Model model) {
        Invoice invoice = new Invoice();
        model.addAttribute("invoice", invoice);
        return "invoice-form";
    }

    @PostMapping
    public String saveInvoice(@ModelAttribute("invoice") Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @GetMapping("/edit/{id}")
    public String showInvoiceFormForUpdate(@PathVariable Long id, Model model) {
        Optional<Invoice> invoice = invoiceService.findById(id);
        model.addAttribute("invoice", invoice);
        return "invoice-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteById(id);
        return "redirect:/invoices";
    }
}

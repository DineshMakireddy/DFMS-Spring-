package com.example.dairyfarm.service;

import com.example.dairyfarm.entity.Invoice;
import com.example.dairyfarm.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    public Optional<Invoice> findById(Long id) {
        return invoiceRepository.findById(id);
    }

    public void save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public void deleteById(Long id) {
        invoiceRepository.deleteById(id);
    }
}

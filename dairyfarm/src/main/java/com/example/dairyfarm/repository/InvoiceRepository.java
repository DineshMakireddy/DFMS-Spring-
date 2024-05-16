package com.example.dairyfarm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dairyfarm.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}

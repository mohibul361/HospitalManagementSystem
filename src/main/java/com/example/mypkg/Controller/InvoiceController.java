package com.example.mypkg.Controller;

import com.example.mypkg.Model.Invoice;
import com.example.mypkg.Payload.Request.InvoiceRequest;
import com.example.mypkg.Payload.Response.MessageResponse;
import com.example.mypkg.Service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;

    @RequestMapping(value="all", method = RequestMethod.GET)
    public ResponseEntity<List<Invoice>> getAllInvoice () {
        List<Invoice> invoiceList = invoiceService.getAllInvoice();
        return new ResponseEntity<>(invoiceList, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addInvoice(@RequestBody InvoiceRequest invoice) {
        MessageResponse newInvoice = invoiceService.createInvoice(invoice);
        return new ResponseEntity<>(newInvoice, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageResponse> deleteInvoice(@PathVariable("id") Integer id) {
        MessageResponse removeInvoice = invoiceService.deleteInvoice(id);
        return new ResponseEntity<>(removeInvoice, HttpStatus.OK);
    }
}

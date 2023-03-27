package com.example.mypkg.Service;

import com.example.mypkg.Exception.ResourceNotFoundException;
import com.example.mypkg.Model.Invoice;
import com.example.mypkg.Payload.Request.InvoiceRequest;
import com.example.mypkg.Payload.Response.MessageResponse;
import com.example.mypkg.Repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService{
    @Autowired
    InvoiceRepository invoiceRepository;


    @Override
    public MessageResponse createInvoice(InvoiceRequest invoiceRequest) {
        Invoice newInvoice = new Invoice();
        newInvoice.setTotalAmount(invoiceRequest.getTotalAmount());
        newInvoice.setAppointment(invoiceRequest.getAppointment());
        invoiceRepository.save(newInvoice);
        return new MessageResponse("New Invoice created successfully");

    }


    @Override
    public List<Invoice> getAllInvoice() {
        return invoiceRepository.findAll();
    }


    public MessageResponse deleteInvoice(Integer invoiceId) throws ResourceNotFoundException {
        if (invoiceRepository.getById(invoiceId).getId().equals(invoiceId)){
            invoiceRepository.deleteById(invoiceId);
            return new MessageResponse("Invoice deleted successfully");

        }
        else throw new ResourceNotFoundException("Invoice", "id", invoiceId);
    }
}

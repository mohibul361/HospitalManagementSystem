package com.example.mypkg.Service;

import com.example.mypkg.Model.Invoice;
import com.example.mypkg.Payload.Request.InvoiceRequest;
import com.example.mypkg.Payload.Response.MessageResponse;

import java.util.List;

public interface InvoiceService {
    MessageResponse createInvoice(InvoiceRequest invoiceRequest);
    MessageResponse deleteInvoice(Integer invoiceId);
    List<Invoice> getAllInvoice();
}

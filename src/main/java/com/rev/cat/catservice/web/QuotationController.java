package com.rev.cat.catservice.web;

import com.rev.cat.catservice.domain.Quotation;
import com.rev.cat.catservice.dto.QuotationRequestDTO;
import com.rev.cat.catservice.service.QuotationService;
import com.rev.cat.catservice.service.SenderEmailService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quotations")
@Api(value = "quotations", description = "Operations related to Quotations")
public class QuotationController {

    @Autowired
    private QuotationService quotationService;

    @Autowired
    private SenderEmailService senderEmailService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Quotation> findAll() {
        return quotationService.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public Quotation findById(@PathVariable String id) {
        return quotationService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Quotation insert(@RequestBody QuotationRequestDTO dto) {
        Quotation quotation = quotationService.insert(dto);
        senderEmailService.sendEmail(quotation);
        return quotation;
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Quotation delete(@PathVariable String id) {
        return quotationService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Quotation update(@PathVariable String id, @RequestBody QuotationRequestDTO dto) {
        return quotationService.update(id, dto);
    }
}

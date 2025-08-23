package com.sujal.eventpass.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sujal.eventpass.model.EventDetails;
import com.sujal.eventpass.service.PDFGenerator;
import com.sujal.eventpass.service.QRGenerator;

@RestController
@RequestMapping("/api") 
public class controller {
     private final QRGenerator qrGen;
    private final PDFGenerator pdfGen;

    public controller(QRGenerator qrGen, PDFGenerator pdfGen) {
        this.qrGen = qrGen;
        this.pdfGen = pdfGen;
    }

    @PostMapping("/generate-pass")
    public String generatePass(@RequestBody EventDetails details) {
        String qrPath = "qr.png";
        String pdfPath = "eventpass.pdf";


        return "Event pass generated successfully!";
    }
    
}

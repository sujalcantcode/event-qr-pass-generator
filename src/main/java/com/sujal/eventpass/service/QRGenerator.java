package com.sujal.eventpass.service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@Service
public class QRGenerator {
    private static final Logger log = LoggerFactory.getLogger(QRGenerator.class);

    public String generateQRCode(String email, String eventName, String filePath) {
        int size = 300;
        String payload = email + "|" + eventName + "|" + UUID.randomUUID();

        try {
            QRCodeWriter writer = new QRCodeWriter();
            BitMatrix matrix = writer.encode(payload, BarcodeFormat.QR_CODE, size, size);

            Path path = FileSystems.getDefault().getPath(filePath);
            MatrixToImageWriter.writeToPath(matrix, "PNG", path);

            log.info("QR saved to {}", filePath);
            return payload;

        } catch (WriterException e) {
            log.error("QR encoding failed", e);
            throw new RuntimeException("Could not encode QR", e);

        } catch (IOException e) {
            log.error("Failed to write QR image to {}", filePath, e);
            throw new RuntimeException("Could not save QR image", e);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.awt.print.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kwadwooteng-amoako
 */
public class PrinterService implements Printable {

    /**
     *
     * @param libobj
     * @return
     */
    public List<String> getPrinters() {

        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();

        PrintService printServices[] = PrintServiceLookup.lookupPrintServices(flavor, pras);

        List<String> printerList = new ArrayList<>();

        for (PrintService printerService : printServices) {
            printerList.add(printerService.getName());
        };

        // if there is print services available, choose the first one 
        try {
            if (printServices.length > 0) {
                System.out.println("selected printer: " + printServices[0]);
                PrinterJob pjob = PrinterJob.getPrinterJob();
                pjob.setPrintService(printServices[0]);
                pjob.setPrintable(new PrinterService(), new PageFormat());
            }
        } catch (PrinterException t) {
        }

        return printerList;

    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {

        // references: http://www.mets-blog.com/java-pos-thermal-printer-example/
        // references: https://kbdeveloper.qoppa.com/sample-java-program-to-print-to-a-given-printer/
        if (pageIndex == 0) {
            try {
                int width = (int) (8.5 * 72);
                int height = 72;

                // create a yellow bufferedimage
                BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                Graphics2D biG = bi.createGraphics();
                biG.setColor(Color.yellow);
                biG.fillRect(0, 0, width, height);

                // print the buffered image to the print graphic
                Graphics2D g2Print = (Graphics2D) graphics;
                g2Print.drawImage(bi, 0, 144, null);
                graphics.setFont(new Font("Roman", 0, 8));
                graphics.drawString("Hello world!", 100, 100);

                return Printable.PAGE_EXISTS;
            } catch (Throwable t) {

            }
        }
        return Printable.NO_SUCH_PAGE;
    }

    public void printString(String printerName, String text) {

        // find the printService of name printerName
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();

        PrintService printService[] = PrintServiceLookup.lookupPrintServices(
                flavor, pras);
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();

        // how do we select a specific print service
        //PrintService service = findPrintService(printerName, printService);
        DocPrintJob job = service.createPrintJob();

        try {

            byte[] bytes;

            // important for umlaut chars
            bytes = text.getBytes("CP437");

            Doc doc = new SimpleDoc(bytes, flavor, null);

            job.print(doc, null);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void printBytes(String printerName, byte[] bytes) {

        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();

        PrintService printService[] = PrintServiceLookup.lookupPrintServices(
                flavor, pras);
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();

        // how do we select a specific print service
        // findPrintService(printerName, printService);
        DocPrintJob job = service.createPrintJob();

        try {

            Doc doc = new SimpleDoc(bytes, flavor, null);

            job.print(doc, null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private PrintService findPrintService(String printerName,
            PrintService[] services) {
        for (PrintService service : services) {
            if (service.getName().equalsIgnoreCase(printerName)) {
                return service;
            }
        }

        return null;
    }

    public void testprinter() {
        // byte[] left = new byte[]{0x1b, 0x61, 0x00};
        // byte[] center = new byte[]{0x1b, 0x61, 0x01};
        // byte[] right = new byte[]{0x1b, 0x61, 0x02};
        // byte[] reset = new byte[]{0x1b, 0x40};

        
        // when ready use the following code below to test printing to thermal printer. 
        PrinterService printerService = new PrinterService();

        System.out.println(printerService.getPrinters());

        //print some stuff
        printerService.printString("EPSON-TM-T20II", "\n\n testing testing 1 2 3eeeee \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        // cut that paper!
        byte[] cutP = new byte[]{0x1d, 'V', 1};

        printerService.printBytes("EPSON-TM-T20II", cutP);

    }
;

};

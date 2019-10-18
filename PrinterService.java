/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.awt.print.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.print.PrintService;
import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.List;
import javax.print.DocFlavor;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

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

        for (PrintService printerService : printServices) 
        {
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
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

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
                graphics.drawString("Hello world!", 100, 100);

                return Printable.PAGE_EXISTS;
            } catch (Throwable t) {

            }
        }

        return Printable.NO_SUCH_PAGE;

    }

    public void testprinter() {
        byte[] left = new byte[]{0x1b, 0x61, 0x00};
        byte[] center = new byte[]{0x1b, 0x61, 0x01};
        byte[] right = new byte[]{0x1b, 0x61, 0x02};
        byte[] reset = new byte[]{0x1b, 0x40};

    }
;

};

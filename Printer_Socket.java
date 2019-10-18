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

/**
 *
 * @author kwadwooteng-amoako
 */
public class Printer_Socket implements Printable {

    void print_receipt(
            BookObject libobj
    ) {
        PrintService[] services = PrinterJob.lookupPrintServices();

        // if there is print services available, choose the first one 
        try {
            if (services.length > 0) {
                System.out.println("selected printer: " + services[0]);
                PrinterJob pjob = PrinterJob.getPrinterJob();
                pjob.setPrintService(services[0]);
                pjob.setPrintable(new Printer_Socket(), new PageFormat());
            }
        } catch (PrinterException t) 
        {
        }

    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
       
         if (pageIndex == 0)
        {
            try
            {
                int width = (int)(8.5 * 72);
                int height = 72;
 
                // create a yellow bufferedimage
                BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                Graphics2D biG = bi.createGraphics();
                biG.setColor(Color.yellow);
                biG.fillRect(0, 0, width, height);
 
                // print the buffered image to the print graphic
                Graphics2D g2Print = (Graphics2D)graphics;
                g2Print.drawImage(bi, 0, 144, null);
                graphics.drawString("Hello world!", 100, 100);
 
                return Printable.PAGE_EXISTS;
            }
            catch(Throwable t)
            {
            
            }
        }
 
        return Printable.NO_SUCH_PAGE;
    
    }
    
    public void testprinter()
    {
          byte[] left = new byte[]{0x1b, 0x61, 0x00};
    byte[] center = new byte[]{0x1b, 0x61, 0x01};
    byte[] right = new byte[]{0x1b, 0x61, 0x02};
    byte[] reset = new byte[]{0x1b, 0x40};
        
    };

};


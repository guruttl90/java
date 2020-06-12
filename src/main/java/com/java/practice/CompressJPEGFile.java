package com.java.practice;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.logging.Logger;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;



public class CompressJPEGFile {
	private static final Logger log = Logger.getLogger(CompressJPEGFile.class.getName());
	public static void main(String[] args) throws IOException {
		InputStream is = null;
		OutputStream os = null;
		ImageWriter writer = null;
		ImageOutputStream ios = null;
		float quality = 0.5f;
		BufferedImage image = null;
		File imageFile = new File("D:\\IMPORTANT\\Guru\\20200611_105823_1.jpg");
		File compressedImageFile = new File("D:\\IMPORTANT\\Guru\\myimage_compressed_1.jpg");
		try {
			is = new FileInputStream(imageFile);
			os = new FileOutputStream(compressedImageFile);			
			image = ImageIO.read(is);
			Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");			
			writer= (ImageWriter) writers.next();
		    ios = ImageIO.createImageOutputStream(os);
		    writer.setOutput(ios);
		    ImageWriteParam param = writer.getDefaultWriteParam();
		    param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
	        param.setCompressionQuality(quality);	      
	        writer.write(null, new IIOImage(image, null, null), param);
			
		} catch (FileNotFoundException e) {
			log.info("error due to : "+e.getMessage());
		}catch (IllegalStateException e) {
			log.info("error due to : "+e.getMessage());
		}finally {			
			if(is!=null) is.close();			
			if(os!=null) os.close();		
			if(ios!=null) ios.close();			
			if(writer!=null) writer.dispose();		
		}
        
	}
}

package comp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class   compress1 
{	
	// compress filePath file into a zip file filePathZipped
    private static String  compress( String filePath )
    {
    	byte[] buffer = new byte[1024];
    	
    	String filePathZipped = filePath.substring(0,filePath.length()-4)+".zip";
    	
    	try{
    		
    		FileOutputStream fos = new FileOutputStream(filePathZipped);
    		ZipOutputStream zos = new ZipOutputStream(fos);
    		ZipEntry ze= new ZipEntry("license");
    		zos.putNextEntry(ze);
    		FileInputStream in = new FileInputStream(filePath);
   	   
    		int len;
    		while ((len = in.read(buffer)) > 0) {
    			zos.write(buffer, 0, len);
    		}

    		in.close();
    		zos.closeEntry();
           
    		//remember close it
    		zos.close();
          
    		System.out.println("Done");

    	}catch(IOException ex){
    	   ex.printStackTrace();
    	}
    	return filePathZipped;
    }
    public static void main( String args[] )
    {
    	compress("D:\\spy.txt");
    }
}

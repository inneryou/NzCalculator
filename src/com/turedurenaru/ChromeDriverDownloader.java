package com.turedurenaru;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ChromeDriverDownloader {
    public ChromeDriverDownloader() {
        String chromeDriverUrl = "https://chromedriver.storage.googleapis.com/LATEST_RELEASE";
        String chromeDriverVersion = "";
        try {
            URL url = new URL(chromeDriverUrl);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            chromeDriverVersion = reader.readLine();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String downloadUrl = "https://chromedriver.storage.googleapis.com/" + chromeDriverVersion + "/chromedriver_win32.zip";
        try {
            URL url = new URL(downloadUrl);
            ReadableByteChannel rbc = Channels.newChannel(url.openStream());
            FileOutputStream fos = new FileOutputStream("chromedriver.zip");
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();
            rbc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            unzip("chromedriver.zip", ".");
            new File("chromedriver.zip").delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void unzip(String zipFilePath, String destDirectory) throws IOException {
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry = zipIn.getNextEntry();
            while (entry != null) {
                String filePath = destDirectory + File.separator + entry.getName();
                if (!entry.isDirectory()) {
                    extractFile(zipIn, filePath);
                } else {
                    File dir = new File(filePath);
                    dir.mkdir();
                }
                zipIn.closeEntry();
                entry = zipIn.getNextEntry();
            }
        }
    }

    private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
            byte[] bytesIn = new byte[4096];
            int read = 0;
            while ((read = zipIn.read(bytesIn)) != -1) {
                bos.write(bytesIn, 0, read);
            }
        }
    }
}
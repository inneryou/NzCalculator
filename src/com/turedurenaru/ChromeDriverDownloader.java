package com.turedurenaru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ChromeDriverDownloader {
    String chromeVersion;
    String chromeDriverVersion;
    public ChromeDriverDownloader() {
        chromeVersion = getChromeVersion();
        chromeDriverVersion = getChromeDriverVersion(chromeVersion);
        downloadChromeDriver(chromeDriverVersion);
    }

    private static String getChromeVersion() {
        try {
            Process process = Runtime.getRuntime().exec("google-chrome --version");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Google Chrome")) {
                    String[] parts = line.split("\\s");
                    return parts[2];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getChromeDriverVersion(String chromeVersion) {
        String[] parts = chromeVersion.split("\\.");
        int majorVersion = Integer.parseInt(parts[0]);
        System.out.println(majorVersion);
        URL url = null;
        try{
            switch (majorVersion) {
                case 110:
                    url = new URL("https://chromedriver.storage.googleapis.com/110.0.5481.77/chromedriver_linux64.zip");
                    break;
                case 91:
                    url = new URL("https://chromedriver.storage.googleapis.com/91.0.4472.19/chromedriver_linux64.zip");
                    break;
                case 92:
                    url = new URL("https://chromedriver.storage.googleapis.com/92.0.4515.107/chromedriver_linux64.zip");
                    break;
                default:
                    throw new IllegalArgumentException("Chrome version not supported");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return url.toString();
    }

    private static void downloadChromeDriver(String chromeDriverUrl) {
        try {
            URL url = new URL(chromeDriverUrl);
            java.nio.file.Files.copy(url.openStream(), java.nio.file.Paths.get("chromedriver.zip"));
            System.out.println("ChromeDriver downloaded successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

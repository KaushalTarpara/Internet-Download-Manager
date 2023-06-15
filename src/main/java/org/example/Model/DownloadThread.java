package org.example.Model;

import org.example.DownloadManager;


import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.io.File.*;

public class DownloadThread extends Thread{

    private FileInfo file;

    DownloadManager manager;

    public DownloadThread(FileInfo file,DownloadManager manager){
        this.file=file;
        this.manager=manager;
    }

    @Override
    public void run() {

        this.file.setStatus("DOWNLOADING");
        this.manager.updateUI(this.file);

        try {
            //Download logic
            Files.copy(new URL(this.file.getUrl()).openStream(), Paths.get(this.file.getPath()));
            this.file.setStatus("DONE");

        } catch (IOException e) {
            this.file.setStatus("FAILED");
            System.out.println("Downloading Error");
            e.printStackTrace();
        }

        this.manager.updateUI(this.file);
    }
}

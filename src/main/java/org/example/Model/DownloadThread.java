package org.example.Model;

import org.example.DownloadManager;

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
        
    }
}

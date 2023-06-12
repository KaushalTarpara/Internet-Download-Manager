package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.example.Model.FileInfo;

public class DownloadManager {

    @FXML
    private TextField urlTextFiled;

    public int index = 0;
    @FXML
    void downloadButtonClicked(ActionEvent event) {

        String url = urlTextFiled.getText().trim();
        String filename = url.substring(url.lastIndexOf('/')+1);
        String status="STARTING";
        String action="open";

        FileInfo file=new FileInfo(index+1,filename,url,status,action);

    }

}

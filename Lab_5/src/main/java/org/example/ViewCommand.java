package org.example;

import java.awt.*;
import java.io.File;

public class ViewCommand implements Command{

    private String filePath;
    public ViewCommand(String filePath)
    {
        this.filePath = filePath;
    }
    @Override
    public void execute(DocumentRepository repo) throws Exception {
        Desktop.getDesktop().open(new File(filePath));
    }
}

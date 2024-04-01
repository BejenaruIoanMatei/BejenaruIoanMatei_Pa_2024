package org.example;

import java.awt.*;
import java.io.File;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;
import freemarker.template.*;

public class ReportCommand implements Command {

    private DocumentRepository repository;
    private String templatePath = "report.ftl";

    public ReportCommand(DocumentRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public void execute(DocumentRepository repository) throws Exception {
        Map<Person, List<Document>> reportData = repository.getDocuments();

        Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        cfg.setClassForTemplateLoading(ReportCommand.class, "/"); // Assuming template in resources

        Template template = cfg.getTemplate(templatePath);

        StringWriter writer = new StringWriter();
        template.process(reportData, writer);
        String reportContent = writer.toString();

        Desktop.getDesktop().open(new File("report.ftl"));
    }
}
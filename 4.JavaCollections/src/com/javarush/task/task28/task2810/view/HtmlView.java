package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View {
    private Controller controller;
    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies) { //проверить этот кусок дерьма
        try {
            updateFile(getUpdatedFileContent(vacancies));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Some exception");
        }


    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) {
        Document document = null;
        try {
            document = getDocument();
            Element templateVacancyByElement = document
                    .getElementsByClass("template").first();
            Element patternVacancyByElement = templateVacancyByElement.clone();
            patternVacancyByElement
                    .removeClass("template")
                    .removeAttr("style");
            document
                    .getElementsByAttributeValueEnding("class", "vacancy")
                    .remove();

            for (Vacancy vacancy : vacancies) {
                Element currentElement = patternVacancyByElement.clone();

                currentElement
                        .getElementsByClass("city").first()
                        .text(vacancy.getCity());
                currentElement
                        .getElementsByClass("companyName").first()
                        .text(vacancy.getCompanyName());
                currentElement
                        .getElementsByClass("salary").first()
                        .text(vacancy.getSalary());
                //currentElement.getElementsByAttribute("siteName").first().text(vacancy.getSiteName());

                Element link = currentElement.getElementsByTag("a").first();
                link.text(vacancy.getTitle());
                link.attr("href", vacancy.getUrl());

                templateVacancyByElement.before(currentElement.outerHtml());
            }

        } catch (Exception exp) {
            exp.printStackTrace();
            return "Some exception occurred";
        }
        return document.html();
    }

    protected Document getDocument() throws IOException {
        File in = new File(filePath);
        return Jsoup.parse(in, "UTF-8");
    }

    private void updateFile(String file) {
        try {
            FileWriter fileWriter = new FileWriter(new File(filePath));
            fileWriter.write(file);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

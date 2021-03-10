package ru.job4j.report;

public class HtmlReport extends TextReport  {
    @Override
    public String text(String name, String body) {
        return "<h1>" + name + "<h1>"
                + "<br/h>"
                + "<span>" + body + "</span>";
    }
}

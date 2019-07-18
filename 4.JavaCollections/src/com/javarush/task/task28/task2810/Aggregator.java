package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.HHStrategy;
import com.javarush.task.task28.task2810.model.Model;
import com.javarush.task.task28.task2810.model.MoikrugStrategy;
import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.view.HtmlView;
import com.javarush.task.task28.task2810.view.View;

public class Aggregator {
    public static void main(String[] args) {
//        HtmlView view = new HtmlView();
//        Provider providerHH = new Provider(new HHStrategy());
//        Model model = new Model(view, providerHH);
//        view.setController(new Controller(model));
//        view.userCitySelectEmulationMethod();


        HtmlView view = new HtmlView();
        Provider providerHH = new Provider(new HHStrategy());
        Provider providerMK = new Provider(new MoikrugStrategy());
        Model model = new Model(view, providerHH, providerMK);

        view.setController(new Controller(model));
        view.userCitySelectEmulationMethod();


    }
}

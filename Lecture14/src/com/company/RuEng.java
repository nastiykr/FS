package com.company;

// Каждая конкретная стратегия реализует общий интерфейс своим способом.
//Первая конкретная реализация-стратегия


public class RuEng implements Strategy {

    public void doTranslate(String inputStr, Dict dictRuEng, Dict dictEngRu) {

        dictRuEng.printDictRuEng(inputStr);

    }
}
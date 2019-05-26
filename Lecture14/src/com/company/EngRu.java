package com.company;

//Вторая конкретная реализация-стратегия
//Реализаций стратегий (различных алгоритмов) может быть сколько угодно. Столько
//сколько требуется для решения конкретной задачи


public class EngRu implements Strategy{
    public void doTranslate(String inputStr, Dict dictRuEng, Dict dictEngRu) {

        dictEngRu.printDictEngRu(inputStr);
    }
}
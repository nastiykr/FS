package com.company;

// Общий интерфейс всех стратегий.
//Этот интерфейс, должен наследовать класс, реализующий конкреную стратегию
//Класс Context использует данный интерфейс для вызова конкретной стратегии

public interface Strategy{

    void doTranslate(String inputStr, Dict dictRuEng, Dict dictEngRu);
}
//
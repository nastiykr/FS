package com.company;
//Контекст, использующий стратегию для решения поставленной задачи
// Контекст всегда работает со стратегиями через общий
// интерфейс. Он не знает, какая именно стратегия ему подана.
public class Context {

    private Strategy strategy;

    public void setTranslate(Strategy strategy){

        this.strategy = strategy;
    }

    public void performTranslate(String inputStr, Dict dictRuEng, Dict dictEngRu){

        strategy.doTranslate(inputStr, dictRuEng, dictEngRu);

    }
}


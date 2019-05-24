package com.company;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Context context = new Context();

        context.setTranslate(new EngRu());
        context.performTranslate();

        context.setTranslate(new RuEng());
        context.performTranslate();
    }

}

// Общий интерфейс всех стратегий.
//Этот интерфейс, должен наследовать класс, реализующий конкреную стратегию
//Класс Context использует данный интерфейс для вызова конкретной стратегии

interface Strategy{
    public void doTranslate();
}

// Каждая конкретная стратегия реализует общий интерфейс своим способом.
//Первая конкретная реализация-стратегия

class RuEng implements Strategy{
    public void doTranslate() {
        System.out.println("in english");
    }

}
//Вторая конкретная реализация-стратегия
//Реализаций стратегий (различных алгоритмов) может быть сколько угодно. Столько
//сколько требуется для решения конкретной задачи

class EngRu implements Strategy{
    public void doTranslate() {
        System.out.println("in russian");
    }
}

//Контекст, использующий стратегию для решения поставленной задачи
// Контекст всегда работает со стратегиями через общий
// интерфейс. Он не знает, какая именно стратегия ему подана.

class Context {

    private Strategy strategy;

    public void setTranslate(Strategy strategy){
        this.strategy = strategy;
    }

    public void performTranslate(){
        strategy.doTranslate();
    }
}

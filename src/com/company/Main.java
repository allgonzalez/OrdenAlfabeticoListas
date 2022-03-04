package com.company;

public class Main {

    public static void main(String[] args) {

        ListSimple listSimple = new ListSimple();



    listSimple.addEnd("Jose");
    listSimple.addEnd("Amlo");
    listSimple.addEnd("Eduardo");
    listSimple.addEnd("Arribaldo");
    listSimple.addEnd("Julio");
    listSimple.addEnd("Zulivan");
    listSimple.addEnd("Xamarin");

        System.out.println("---------------------Lista desordenada-----------------");

    listSimple.showList();

    listSimple.bubbleSort();

    //Graficado con graphviz
    listSimple.graph();










    }
}

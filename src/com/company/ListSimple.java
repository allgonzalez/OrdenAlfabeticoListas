package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class ListSimple {

    public Node start;
    public int size;

    public  ListSimple(){
        start = null;
        size = 0;
    }

    public boolean isEmpty(){
        return start == null;
    }

    public int getSize(){
        return size;
    }

    public void addEnd(String texto){
        Node node = new Node(texto);

        if(isEmpty()){
            start = node;
        }else{
            Node aux = start;
            while(aux.next != null){
                aux = aux.next;
            }
            aux.next = node;
        }

        size++;

    }

    public void showList(){
        if(!isEmpty()){
            Node aux = start;

            while(aux!=null){
                System.out.println("-> "+aux.texto);
                aux = aux.next;
            }
        }

    }

    //Método de burbuja

    public void bubbleSort(){
       String temp = "";

        for(int i = 0; i<getSize(); i++ ){
            for(int j = 1; j < getSize()-i; j++){

                if(search(j-1)>search(j)){
                    temp = searchString(j-1);
                    addPosition(j-1, searchString(j));
                    addPosition(j, temp);
                }
            }
        }
        System.out.println("-----------Lista ordenada----------------");
        showList();

    }


    public int search(int index){
        Node aux = start;

        StringBuilder stb = new StringBuilder(aux.texto);

        int cont = 0;

        while(cont < index){
            aux = aux.next;
            cont++;
        }

        return (int) aux.texto.charAt(0);
    }

    public String searchString(int index){
        Node aux = start;
        int cont=0;
        while(cont < index){
            aux = aux.next;
            cont++;
        }

        return aux.texto;

    }

    public void addPosition(int pos, String texto){

        Node aux = start;
        int cont = 0;

        while(cont < pos){
            cont++;
            aux = aux.next;
        }
        aux.texto = texto;



    }




    //Graphviz *

    public void graph(){
        try {
            String Path = "C:\\Users\\Allan\\IdeaProjects\\BurbujaEDD\\Lista.dot";
            Node aux = start;
            File file = new File(Path);
            String str = "digraph G{\n";
            str += "rankdir = LR\n";
            while(aux!=null){
                str = str + "Node"+aux.texto+"[label=\""+aux.texto+"\"];\n";
                if(aux.next!=null){
                    str=str+"Node"+aux.texto+" -> Node"+aux.next.texto+";\n";
                }
                aux = aux.next;
            }
            str = str + "}";
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(str);
            bw.close();


            Runtime.getRuntime().exec("dot -Tjpg Lista.dot -o ListaEnlazada.jpg");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }








}

package org.example.anonimus;




public class AnonimousDemo {
    public static void main(String[] args) {
    new One() {
       @Override
       public void show() {
           System.out.println("hello dolly");
       }
       public void showAll(){
           show();
       }
   }.showAll();
    }
}

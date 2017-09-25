package com.company;
import java.util.Random;
import java.util.Vector;
import java.util.Scanner;

public class BoxSearch {

    private Vector returnList(int max){
        Vector vector = new Vector();
        Vector tempVector = new Vector();
        Random rnd = new Random();


        for (int i = 1; i <= max + 1; i++){
            tempVector.add(i);
        }

        for (int j = 1; j <= max +1; j++){
            // Möjlig felkälla? Ska vara +1?
            int numberToGive = rnd.nextInt(tempVector.size());
            vector.add(tempVector.get(numberToGive));
            tempVector.remove(numberToGive);
        }
        return vector;
    }

    private boolean search(Vector persons, Vector boxes){
        for(int i = 0; i <= persons.size(); i++){
            int myNumber = Integer.parseInt(persons.get(i).toString());
            int tries = 0;
            boolean found = false;

            while(!found){
                if(myNumber == Integer.parseInt(boxes.get(myNumber).toString())){
                    found = true;
                    System.out.println("Found: " + persons.get(i).toString());
                }
                else
                    myNumber = Integer.parseInt(boxes.get(myNumber).toString());
                tries++;
            }
        }
        return true;
    }


    public void start(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hur många lådor handlar det om?");
        int sum = scanner.nextInt();

        Vector personer = returnList(sum);
        Vector boxes = returnList(sum);

        if(search(personer, boxes))
            System.out.println("Done!");
    }
}

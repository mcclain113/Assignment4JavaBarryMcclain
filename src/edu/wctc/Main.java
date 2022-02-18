package edu.wctc;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner keyboard = new Scanner(System.in) ;
    private static PaintCalculator paintCalculator = new PaintCalculator();
    private static final String ROOM_IMPORT = "roomimport.csv";
    private static final String ROOM_EXPORT = "roomexport.csv";

    private static void printMenu(){
        System.out.println("1. Add Room");
        System.out.println("2. View Room(s)");
        System.out.println("3. Read Rooms from File");
        System.out.println("4. Write Rooms to File");
        System.out.println("5. Exit Program");
    }

    private static double promptForDimension(){
        System.out.println("Enter selection (Number):  ");

        return Double.valueOf(keyboard.nextLine());
    }

    private static void createRoom(){
        System.out.println("Enter numerical length of room (Feet): ");
        Double length = Double.valueOf(keyboard.nextLine());
        System.out.println("Enter numerical  width of room (Feet): ");
        Double width = Double.valueOf(keyboard.nextLine());
        System.out.println("Enter numerical height of room (Feet): ");
        Double height = Double.valueOf(keyboard.nextLine());

        paintCalculator.addRoom(length,width,height);

    }

    private static void readFile() throws FileNotFoundException {
       // ObjectInputStream ois = new ObjectInputStream(new FileInputStream("paintAreaImport.dat"));
        //List<Room> listFromFile = (List<Room>)ois.readObject();
        //ois.close();
        File file = new File(ROOM_IMPORT);
        if (file.exists()){
            Scanner reader = new Scanner(file);
            while(reader.hasNext()) {
                String line = reader.nextLine();
                String[] linePieces = line.split(",");
                paintCalculator.addRoom((Double.parseDouble(linePieces[0])),
                        (Double.parseDouble(linePieces[1])),
                        Double.parseDouble(linePieces[2]));
            }

    }


    }

    private static void writeFile() throws FileNotFoundException {
        File file = new File(ROOM_EXPORT);
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.printf(paintCalculator.toString());
        printWriter.flush();
        printWriter.close();
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Double selection = Double.valueOf(0);
        while(selection != 5){
            printMenu();
            selection = promptForDimension();
            if (selection == 1){
                createRoom();
            }
            else if (selection == 2){
                System.out.println(paintCalculator.toString());
            }
            else if (selection == 3){
                readFile();
            }
            else if (selection == 4){
                writeFile();

            }
            else if (selection == 5){
                break;

            }
            else{
                System.out.println("Not a valid selection. Try again.");

            }

        }


    }


}

package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        SimScanner simScanner = new SimScanner("C:\\Users\\Dan_B\\Documents\\FLC\\lab3\\src\\com\\company\\Files\\program.in");
        /*try{
            simScanner.getscan();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
        simScanner.getscan();
    }
}

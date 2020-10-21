package com.company;

import java.io.*;
import java.util.*;

public class SimScanner {
    private HashTable table;
    private Map<String, Integer> pif;
    private List<String> tokens;
    private String filepath;

    public SimScanner(String path)
    {
        table = new HashTable(128);
        pif = new HashMap<>();
        tokens = new ArrayList<>();
        this.filepath = path;
        this.readTokens();
    }

    public void readTokens()
    {
        File file = new File("C:\\Users\\Dan_B\\Documents\\FLC\\lab3\\src\\com\\company\\Files\\token.in");
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext())
            {
                tokens.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void writePIFToFile()
    {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Dan_B\\Documents\\FLC\\lab3\\src\\com\\company\\Files\\PIF.out"));
            for (String key: pif.keySet()) {
                String s = key + " " + pif.get(key) + "\n";
                System.out.println(s);
                bufferedWriter.write(s);
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void writeSTToFile()
    {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Dan_B\\Documents\\FLC\\lab3\\src\\com\\company\\Files\\ST.out"));
            bufferedWriter.write(table.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getscan() throws Exception {
        File file = new File(this.filepath);
        String line;
        String token;
        int i = 1;

        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(line, " :;,[]()\"");
            while (tokenizer.hasMoreTokens())
            {
                token = tokenizer.nextToken();
                if (tokens.contains(token))
                    pif.put(token, 0);
                else
                {
                    table.put(token);
                    if(table.getpos(token) != -1)
                        pif.put(token, table.getpos(token));
                    else throw new Exception("Lexical error at line " + i);
                }
                i += 1;
            }
        }

        writePIFToFile();
        writeSTToFile();

    }


}

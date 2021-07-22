package by.bsu.lab10.file;

import by.bsu.lab10.tree.Node;
import by.bsu.lab10.tree.Road;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class RoadsReader {
    public List<Road> readFile(File file) {
        List<Road> roads = new LinkedList<>();
        try (Scanner scanner = new Scanner(file)){
            scanner.useLocale(Locale.US);
            while (scanner.hasNext()){
                String start = scanner.next();
                String end = scanner.next();
                float weight = scanner.nextFloat();
                roads.add(new Road(new Node(start), new Node(end), weight));
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e.toString());
        }

        return roads;
    }
}

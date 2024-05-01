package islands;

import javafx.util.Pair;

import java.io.*;
import java.util.*;

public class Solution {

    public static void islands() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++){
            String size = reader.readLine();
            int height = Integer.parseInt(size.substring(0, size.indexOf(" ")));
            int width = Integer.parseInt(size.substring(size.indexOf(" ") + 1));

            final char[][] currentCase = new char[height][width];
            for (int j = 0; j < height; j++){
                currentCase[i] = reader.readLine().toCharArray();
            }

            final HashSet<Pair<Integer, Integer>> visited = new HashSet<>();

            for (int j = 0; j < height; j++){
                for (int k = 0; k < width; k++){
                    Pair<Integer, Integer> currentPair = new Pair<>(j, k);
                    if (!visited.contains(currentPair)){
                        if (currentCase[j][k] == '.'){
                            check(currentCase, visited, j, k, height, width);
                        }
                        visited.add(currentPair);
                    }
                }
            }
            for (int f = 0; f < height; f++){
                System.out.println(Arrays.toString(currentCase[f]));
            }
        }
    }

    private static void check(char[][] currentCase, HashSet<Pair<Integer, Integer>> visited, int j, int k, int height, int width){
        Queue<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
        ArrayList<Pair<Integer, Integer>> island = new ArrayList<>();

        Pair<Integer, Integer> startPair = new Pair<Integer, Integer>(j, k);
        queue.add(startPair);
        island.add(startPair);

        boolean isEarth = false;

        while (!queue.isEmpty()){
            Pair<Integer, Integer> cur = queue.poll();
            int x = cur.getKey();
            int y = cur.getValue();

            if (x == width - 1 || x == 0 || y == height - 1 || y == 0){
                isEarth = true;
            }

            Pair<Integer, Integer> p = new Pair<>(x + 1, y);
            if (x + 1 < width && !visited.contains(p) && currentCase[x + 1][y] == '.'){
                queue.add(p);
                island.add(p);
            }

            p = new Pair<>(x - 1, y);
            if (x - 1 >= 0 && !visited.contains(p) && currentCase[x - 1][y] == '.'){
                queue.add(p);
                island.add(p);;
            }

            p = new Pair<>(x, y + 1);
            if (y + 1 < height && !visited.contains(p) && currentCase[x][y + 1] == '.'){
                queue.add(p);
                island.add(p);
            }

            p = new Pair<>(x, y - 1);
            if (y - 1 >= 0 && !visited.contains(p) && currentCase[x][y - 1] == '.'){
                queue.add(p);
                island.add(p);
            }

            currentCase[x][y] = '#';
            visited.add(cur);
        }

        if (!isEarth){
            for (Pair<Integer, Integer> integerIntegerPair : island) {
                currentCase[integerIntegerPair.getKey()][integerIntegerPair.getValue()] = '#';
            }
        }
    }

    public static void main(String[] args) throws IOException {
        islands();
    }
}

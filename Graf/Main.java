import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int V = 0;
		int E = 0;
		int x = 0;
		int y = 0;
		int start = 0;
		Graf graf = null;
		try{
			Scanner in = new Scanner(new File("date"));
			V = in.nextInt();
			E = in.nextInt();
			graf = new Graf(V, E);
			for(int i = 0; i < E; i++){
				x = in.nextInt();
				y = in.nextInt();
				graf.add(x, y);
			}
			start = in.nextInt();
			in.close();
		}catch(FileNotFoundException ex){
			ex.printStackTrace();
		}
		
		try{
			PrintWriter writer = new PrintWriter("date.out", "UTF-8");
			writer.println(graf);
			writer.println(graf.BFS(start));
			writer.close();
		}catch(FileNotFoundException | UnsupportedEncodingException  ex){
			ex.printStackTrace();
		}

	}
}

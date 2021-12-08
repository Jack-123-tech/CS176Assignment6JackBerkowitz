import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class WorldPop {

	public static void main(String[] args )throws FileNotFoundException {
		ArrayList <Long> pop=new ArrayList<>();
		ArrayList <Float> Area=new ArrayList<>();
		ArrayList <String> names=new ArrayList<>();
		File inputFile = new File("WorldPOP1");
		Scanner in = new Scanner(inputFile);

		File inputArea = new File("WorldArea");
		Scanner inArea = new Scanner(inputArea);
		PrintWriter output = new PrintWriter("WorldFinal");
		while (in.hasNextLine()) {
			String s=in.nextLine();
			String num="";
			for(int i=0;i<s.length();i++) {
				char c =s.charAt(i);
				if(Character.isDigit(c)) {
					num+=c;
				}
			}
			String name="";
			for(int i=0;i<s.length();i++) {
				char c =s.charAt(i);
				if(!Character.isDigit(c)) {
					name+=c;
				}
			}

			names.add(name);
			long population=Long.parseLong(num);
			pop.add(population);




		}
		
		while (inArea.hasNextLine()) {
			String s=inArea.nextLine();
			String num="";
			for(int i=0;i<s.length();i++) {
				char c =s.charAt(i);
				if(Character.isDigit(c)) {
					num+=c;
				}
			}
			float ar=Float.parseFloat(num);
			Area.add(ar);




		}

		for(int i=0;i<pop.size();i++) {
			float atLast=pop.get(i)/Area.get(i);
			output.println(names.get(i) + atLast );
			


		}

		inArea.close();
		in.close();
		output.close();
	}

}

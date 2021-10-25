package sumProcesos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class lanzador {

	public static void main(String[] args) {

		lanzarSumador(principal.class, 1, 5, 6, 10, "result1.txt", "result2.txt");

		resultado();
		
	}

	public static void lanzarSumador(Class principal, Integer n1, Integer n2, Integer n3, Integer n4,
			String fichResultado1, String fichResultado2) {

		String javaHome = System.getProperty("java.home");

		String javaBin = javaHome + File.separator + "bin" + File.separator + "java";

		String classpath = System.getProperty("java.class.path");

		String className = principal.getCanonicalName();

		String clase = "sumProcesos.principal";
		ProcessBuilder pb;

		try {
			pb = new ProcessBuilder(javaBin, "-cp", classpath, className, n1.toString(), n2.toString());

			pb.redirectError(new File("errores.txt"));
			pb.redirectOutput(new File(fichResultado1));
			Process p = pb.start();

			pb = new ProcessBuilder(javaBin, "-cp", classpath, className, n3.toString(), n4.toString());

			pb.redirectError(new File("errores.txt"));
			pb.redirectOutput(new File(fichResultado2));
			Process p2 = pb.start();

			p.waitFor();
			p2.waitFor();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void resultado() {

		int resultado = 0;
		int iFch1 = 0;
		int iFch2 = 0;

		try {
			BufferedReader buff1 = new BufferedReader(new FileReader("result1.txt"));

			BufferedReader buff2 = new BufferedReader(new FileReader("result2.txt"));

			String sLinea = buff1.readLine();

			System.out.println("La primera suma es: "+sLinea);

			iFch1 = Integer.parseInt(sLinea);
			sLinea = buff2.readLine();
			System.out.println("La segunda suma es: "+sLinea);
			iFch2 = Integer.parseInt(sLinea);

			resultado = iFch1 + iFch2;
			System.out.println("El resultado final es: "+resultado);

			buff1.close();
			buff2.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
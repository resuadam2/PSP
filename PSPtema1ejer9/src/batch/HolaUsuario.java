package batch;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class HolaUsuario {

	public static void main(String[] args) throws IOException {

		List<String> list = new ArrayList<String>();
		
		String line;
		String ruta="helloBatch.bat";
		String mensaje = JOptionPane.showInputDialog("Cual es tu nombre?: ");

		try {
			File bat = new File(ruta);
			Process pb = new ProcessBuilder(bat.getAbsolutePath(), mensaje).start();

			InputStream is = pb.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			while ((line = br.readLine()) != null) {
				list.add(line);
			}

			String mostrar = null;
			
	        for (String saludo : list) {
	            mostrar = saludo;
	        }
	        
			JOptionPane.showMessageDialog(null, mostrar);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

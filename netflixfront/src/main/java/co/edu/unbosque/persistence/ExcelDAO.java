package co.edu.unbosque.persistence;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.GsonBuilder;
import com.opencsv.CSVWriter;

import co.edu.unbosque.model.ExcelDTO;

public class ExcelDAO implements CRUDOperation<ExcelDTO, ExcelDTO> {
	ArrayList<ExcelDTO> excelList;

	public ExcelDAO() {
		excelList = new ArrayList<>();
	}

	public void exportToCSV(String filePath, ExcelDTO newUser) {
		boolean fileExists = new File(filePath).exists();

		try (CSVWriter writer = new CSVWriter(new FileWriter(filePath, true))) {
			if (!fileExists) {
				String[] header = { "Usuario", "Fecha y Hora" };
				writer.writeNext(header);
			}

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String currentDateTime = LocalDateTime.now().format(formatter);
			String[] data = { newUser.getUser(), currentDateTime };
			writer.writeNext(data);

			System.out.println("Dato agregado al CSV correctamente: " + filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void openCSV(String filePath) {
		File file = new File(filePath);
		if (file.exists() && Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().open(file);
			} catch (IOException e) {
				System.out.println("Error al abrir el archivo: " + e.getMessage());
			}
		} else {
			System.out.println("No se puede abrir el archivo automáticamente en este sistema.");
		}
	}
	
	

	@Override
	public String crear(ExcelDTO nuevoDato) {

		return ExternalHTTPRequestHandler.doPost("http://localhost:8082/excel/crearjson",
				new GsonBuilder().create().toJson(nuevoDato));
	}

	@Override
	public void eliminar(String nuevoDato) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(int posicionE) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar(ExcelDTO nuevoDato) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<ExcelDTO> buscarTodo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExcelDTO buscarUno(int posicionB) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExcelDTO find(ExcelDTO toFind) {
		// TODO Auto-generated method stub
		return null;
	}

}

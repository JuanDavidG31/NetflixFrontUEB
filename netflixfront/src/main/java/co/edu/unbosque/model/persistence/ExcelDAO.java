package co.edu.unbosque.model.persistence;

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

/**
 * Clase que implementa la interfaz CRUDOperation para la manipulación de datos
 * de ExcelDTO. Esta clase proporciona métodos para exportar datos a un archivo
 * CSV, abrir un archivo CSV, y realizar operaciones CRUD a través de una API
 * HTTP externa.
 */
public class ExcelDAO implements CRUDOperation<ExcelDTO, ExcelDTO> {
	/**
	 * Lista de objetos ExcelDTO.
	 */
	ArrayList<ExcelDTO> excelList;

	/**
	 * Constructor para ExcelDAO. Inicializa la lista de ExcelDTO.
	 */
	public ExcelDAO() {
		excelList = new ArrayList<>();
	}

	/**
	 * Exporta los datos del nuevo usuario a un archivo CSV. Si el archivo no
	 * existe, crea uno nuevo con encabezados.
	 *
	 * @param filePath La ruta del archivo CSV.
	 * @param newUser  El objeto ExcelDTO que contiene los datos del nuevo usuario.
	 */
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

	/**
	 * Abre un archivo CSV utilizando la aplicación predeterminada del sistema.
	 *
	 * @param filePath La ruta del archivo CSV.
	 */
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

	/**
	 * Crea un nuevo registro de ExcelDTO enviando una solicitud POST a una API HTTP
	 * externa.
	 *
	 * @param nuevoDato El objeto ExcelDTO a crear.
	 * @return La respuesta de la API HTTP como una cadena.
	 */
	@Override
	public String crear(ExcelDTO nuevoDato) {

		return ExternalHTTPRequestHandler.doPost("http://192.168.1.228:8081/netflixback-0.0.2-SNAPSHOT/excel/crearjson",
				new GsonBuilder().create().toJson(nuevoDato));
	}

	/**
	 * Elimina un registro de ExcelDTO basado en una cadena de identificación.
	 * (Método no implementado).
	 *
	 * @param nuevoDato La cadena que identifica el registro a eliminar.
	 */
	@Override
	public void eliminar(String nuevoDato) {
		// TODO Auto-generated method stub

	}

	/**
	 * Elimina un registro de ExcelDTO basado en su posición en la lista. (Método no
	 * implementado).
	 *
	 * @param posicionE La posición del registro a eliminar.
	 */
	@Override
	public void eliminar(int posicionE) {
		// TODO Auto-generated method stub

	}

	/**
	 * Actualiza un registro de ExcelDTO existente. (Método no implementado).
	 *
	 * @param nuevoDato El objeto ExcelDTO con los datos actualizados.
	 */
	@Override
	public void actualizar(ExcelDTO nuevoDato) {
		// TODO Auto-generated method stub

	}

	/**
	 * Busca y devuelve todos los registros de ExcelDTO. (Método no implementado).
	 *
	 * @return Una lista de todos los registros de ExcelDTO.
	 */
	@Override
	public ArrayList<ExcelDTO> buscarTodo() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Busca y devuelve un registro de ExcelDTO basado en su posición en la lista.
	 * (Método no implementado).
	 *
	 * @param posicionB La posición del registro a buscar.
	 * @return El registro de ExcelDTO encontrado, o null si no se encuentra.
	 */
	@Override
	public ExcelDTO buscarUno(int posicionB) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Busca y devuelve un registro de ExcelDTO basado en un objeto de búsqueda.
	 * (Método no implementado).
	 *
	 * @param toFind El objeto ExcelDTO a buscar.
	 * @return El registro de ExcelDTO encontrado, o null si no se encuentra.
	 */
	@Override
	public ExcelDTO find(ExcelDTO toFind) {
		// TODO Auto-generated method stub
		return null;
	}

}

package co.edu.unbosque.persistence;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import co.edu.unbosque.model.ExcelDTO;
import co.edu.unbosque.model.MovieDTO;
import co.edu.unbosque.model.UserDTO;

/**
 * Clase que maneja las solicitudes HTTP externas. Proporciona métodos para
 * realizar solicitudes GET, POST, PUT y DELETE, así como para parsear
 * respuestas JSON a objetos Java.
 */
public class ExternalHTTPRequestHandler {
	/**
	 * Cliente HTTP reutilizable con configuración predeterminada.
	 */
	private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2)
			.connectTimeout(Duration.ofSeconds(5)).build();

	/**
	 * Realiza una solicitud GET a la URL especificada y parsea la respuesta JSON.
	 *
	 * @param url La URL a la que se realizará la solicitud GET.
	 * @return La respuesta JSON formateada como una cadena legible.
	 */
	public static String doGetAndParse(String url) {
		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url))
				.header("Content-type", "application/json").build();
		HttpResponse<String> response = null;
		try {
			response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("status code -> " + response.statusCode());
		String uglyJsonString = response.body();
		return prettyPrintUsingGson(uglyJsonString);
	}

	/**
	 * Formatea una cadena JSON para que sea legible.
	 *
	 * @param uglyJsonString La cadena JSON sin formato.
	 * @return La cadena JSON formateada.
	 */
	private static String prettyPrintUsingGson(String uglyJsonString) {
		Gson gson = new GsonBuilder().setLenient().setPrettyPrinting().create();
		JsonElement jsonElement = JsonParser.parseString(uglyJsonString);
		String prettyJsonString = gson.toJson(jsonElement);

		return prettyJsonString;
	}

	/**
	 * Realiza una solicitud POST a la URL especificada con el JSON proporcionado.
	 *
	 * @param url  La URL a la que se realizará la solicitud POST.
	 * @param json La cadena JSON que se enviará en el cuerpo de la solicitud.
	 * @return El código de estado de la respuesta HTTP como una cadena.
	 */
	public static String doPost(String url, String json) {
		HttpRequest solicitud = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(json))
				.uri(URI.create(url)).header("Content-Type", "application/json").build();
		HttpResponse<String> response = null;
		try {
			response = HTTP_CLIENT.send(solicitud, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return String.valueOf(response.statusCode());
	}

	/**
	 * Realiza una solicitud PUT a la URL especificada con el JSON proporcionado.
	 *
	 * @param url  La URL a la que se realizará la solicitud PUT.
	 * @param json La cadena JSON que se enviará en el cuerpo de la solicitud.
	 * @return El código de estado de la respuesta HTTP como una cadena.
	 */
	public static String doPut(String url, String json) {
		HttpRequest solicitud = HttpRequest.newBuilder().PUT(HttpRequest.BodyPublishers.ofString(json))
				.uri(URI.create(url)).header("Content-Type", "application/json").build();
		HttpResponse<String> response = null;
		try {
			response = HTTP_CLIENT.send(solicitud, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(response.statusCode());
		return String.valueOf(response.statusCode());
	}

	/**
	 * Realiza una solicitud DELETE a la URL especificada.
	 *
	 * @param url La URL a la que se realizará la solicitud DELETE.
	 * @return El código de estado de la respuesta HTTP como una cadena.
	 */
	public static String doDelete(String url) {
		HttpRequest solicitud = HttpRequest.newBuilder().DELETE().uri(URI.create(url))
				.header("Content-Type", "application/json").build();

		HttpResponse<String> response = null;
		try {
			response = HTTP_CLIENT.send(solicitud, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}

		return String.valueOf(response.statusCode());
	}

	/**
	 * Realiza una solicitud GET para obtener todos los usuarios y parsea la
	 * respuesta JSON a una lista de UserDTO.
	 *
	 * @param url La URL a la que se realizará la solicitud GET.
	 * @return Una lista de objetos UserDTO.
	 */
	public static ArrayList<UserDTO> doGetAllUsuarios(String url) {
		HttpRequest solicitud = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

		HttpResponse<String> answer = null;
		try {
			answer = HTTP_CLIENT.send(solicitud, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}

		String json = answer.body();

		Gson gson = new GsonBuilder().create();
		UserDTO[] userArray = gson.fromJson(json, UserDTO[].class);

		return new ArrayList<>(Arrays.asList(userArray));
	}

	/**
	 * Realiza una solicitud GET para obtener todos los registros de Excel y parsea
	 * la respuesta JSON a una lista de ExcelDTO.
	 *
	 * @param url La URL a la que se realizará la solicitud GET.
	 * @return Una lista de objetos ExcelDTO.
	 */
	public static ArrayList<ExcelDTO> doGetAllExcel(String url) {
		HttpRequest solicitud = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

		HttpResponse<String> answer = null;
		try {
			answer = HTTP_CLIENT.send(solicitud, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}

		String json = answer.body();

		Gson gson = new GsonBuilder().create();
		ExcelDTO[] excelArray = gson.fromJson(json, ExcelDTO[].class);

		return new ArrayList<>(Arrays.asList(excelArray));
	}

	/**
	 * Realiza una solicitud GET para obtener todas las películas y parsea la
	 * respuesta JSON a una lista de MovieDTO.
	 *
	 * @param url La URL a la que se realizará la solicitud GET.
	 * @return Una lista de objetos MovieDTO.
	 */
	public static ArrayList<MovieDTO> doGetAllMovies(String url) {
		HttpRequest solicitud = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

		HttpResponse<String> answer = null;
		try {
			answer = HTTP_CLIENT.send(solicitud, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}

		String json = answer.body();

		Gson gson = new GsonBuilder().create();
		MovieDTO[] movieArray = gson.fromJson(json, MovieDTO[].class);

		return new ArrayList<>(Arrays.asList(movieArray));
	}

}

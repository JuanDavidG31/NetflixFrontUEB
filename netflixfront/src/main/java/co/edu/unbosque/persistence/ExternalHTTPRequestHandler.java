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
import co.edu.unbosque.model.UserDTO;

public class ExternalHTTPRequestHandler {
	private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2)
			.connectTimeout(Duration.ofSeconds(5)).build();

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

	private static String prettyPrintUsingGson(String uglyJsonString) {
		Gson gson = new GsonBuilder().setLenient().setPrettyPrinting().create();
		JsonElement jsonElement = JsonParser.parseString(uglyJsonString);
		String prettyJsonString = gson.toJson(jsonElement);

		return prettyJsonString;
	}

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

}

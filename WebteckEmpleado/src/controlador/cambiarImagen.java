package controlador;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/cambiarImagen")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
public class cambiarImagen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter salida = response.getWriter();

		response.setContentType("text/html");

		// este salida.append nos pintara la pagina web
		salida.append("<!DOCTYPE html>" + "<html>" + "<body>" + "<h1> Selecciona un fichero para subir </h1>"
				+ "<form action= '' method= 'post' enctype= 'multipart/form-data'>"
				+ "<input type='file' name='fname' />" + "<br />" + "<input type='submit' value='Enviar' />"
				+ "<button type = 'button' onClick='window.location.replace(\"Principal\")'>Cancelar</button>"
				+ "</form>" + "</body>" + "</html>");

	}

	private static final String UPLOAD_DIRECTORY = "Imagenes";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter salida = response.getWriter();

		// Multipart RFC 7578

		// Obtenemos una ruta en el servidor para guardar el archivo
		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;

		// Si la ruta no existe la crearemos
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		// Lo utilizaremos para guardar el nombre del archivo
		String fileName = null;

		// Obtenemos el archivo y lo guardamos a disco
		for (Part part : request.getParts()) {
			fileName = getFileName(part);
			part.write(uploadPath + File.separator + fileName);
		}

		salida.print("successfully uploaded");
		salida.print("<br />");
		salida.print("<br />");

		// Si es una imagen la mostramos
		if (fileName.matches(".+\\.(jpg|png)"))
			salida.print("<img src=\"Imagenes/" + fileName + "\" />");
	}

	// Obtiene el nombre del archivo, sino lo llamaremos desconocido.txt
	private String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename"))
				return content.substring(content.indexOf("=") + 2, content.length() - 1);
		}
		return "desconocido.txt";
	}

}

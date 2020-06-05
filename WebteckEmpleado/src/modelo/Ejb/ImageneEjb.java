package modelo.Ejb;

import java.io.File;
import java.io.IOException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

@Stateless
@LocalBean
/**
 * este metodo guarda la imagen del usuario
 * 
 * @author cristian
 *
 */
public class ImageneEjb {

	private static final String UPLOAD_DIRECTORY = "Imagenes";

	public String guardarImagen(HttpServletRequest request, ServletContext context)
			throws IOException, ServletException {

		String uploadPath = context.getRealPath("") + File.separator + UPLOAD_DIRECTORY;
		File uploadDir = new File(uploadPath);

		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		// Lo utilizaremos para guardar el nombre del archivo
		String fileName = null;

		// Obtenemos el archivo y lo guardamos a disco
		for (javax.servlet.http.Part part : request.getParts()) {
			fileName = getFileName(part);
			part.write(uploadPath + File.separator + fileName);
		}
		return fileName;
	}

	// Obtiene el nombre del archivo, sino lo llamaremos desconocido.txt
	private String getFileName(javax.servlet.http.Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename"))
				return content.substring(content.indexOf("=") + 2, content.length() - 1);
		}
		return "desconocido.txt";
	}
/**
 * este metodo siver para subir la imagen en disco de un nuevo producto
 * @param request
 * @param context
 * @return
 * @throws IOException
 * @throws ServletException
 */
	public String guardarImagen1(HttpServletRequest request, ServletContext context)
			throws IOException, ServletException {

		String uploadPath = context.getRealPath("") + File.separator + UPLOAD_DIRECTORY;
		File uploadDir = new File(uploadPath);

		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		// Lo utilizaremos para guardar el nombre del archivo
		String fileName = null;

		// Obtenemos el archivo y lo guardamos a disco
		for (Part part : request.getParts()) {

			String nombre = getFileName(part);

			if (!nombre.equals("desconocido.txt") && !nombre.equals("")) {
				fileName = nombre;
				part.write(uploadPath + File.separator + fileName);
			}
		}
		return fileName;
	}

}

package modelo.Ejb;

import java.io.File;
import java.io.IOException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


@Stateless
@LocalBean
/**
 * este metodo guarda la imagen del usuario
 * @author cristian
 *
 */
public class ImagenesEjb {

	private static final String UPLOAD_DIRECTORY = "Imagenes";

	public String guardarImagen(HttpServletRequest request, ServletContext context)
			throws IOException,  ServletException {

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

}

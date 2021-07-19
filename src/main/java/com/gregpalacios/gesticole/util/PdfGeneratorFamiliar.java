package com.gregpalacios.gesticole.util;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.format.DateTimeFormatter;

import org.apache.poi.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import com.gregpalacios.gesticole.model.Familiar;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfGeneratorFamiliar {

	private static final Logger logger = LoggerFactory.getLogger(PdfGeneratorAlumno.class);

	public static ByteArrayInputStream objetoToPdf(Familiar familiar, String basePath) throws IOException {
		Document document = new Document(PageSize.A4, 36, 36, 90, 36);
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			PdfWriter writer = PdfWriter.getInstance(document, out);

			HeaderFooterPdf event = new HeaderFooterPdf();
			writer.setPageEvent(event);

			Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			titleFont.setSize(18);
			titleFont.setColor(Color.WHITE);
			
			Font subTitleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			subTitleFont.setSize(14);
			subTitleFont.setColor(Color.BLACK);

			PdfPTable titulo = new PdfPTable(1);
			titulo.setWidthPercentage(100);

			PdfPCell cell_0;
			cell_0 = new PdfPCell(new Phrase(""));
			cell_0.setMinimumHeight(20);
			cell_0.setBorder(0);

			PdfPCell cell_title;
			cell_title = new PdfPCell(new Phrase("FICHA DE FAMILIAR", titleFont));
			cell_title.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_title.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell_title.setBackgroundColor(Color.DARK_GRAY);
			cell_title.setMinimumHeight(40);
			cell_title.setBorder(0);
			
			InputStream inputStream;
			if(familiar.getFoto() == null) {
				if(familiar.getSexo().getIdSexo() == 1) {
					File file = new ClassPathResource("static/img/foto-masculino.png").getFile();
					inputStream = new FileInputStream(file);
				} else {
					File file = new ClassPathResource("static/img/foto-femenino.png").getFile();
					inputStream = new FileInputStream(file);
				}
			} else {
				File file = new File(basePath+familiar.getFoto());
				inputStream = new FileInputStream(file.getPath());
			}
			
			byte[] bytes = IOUtils.toByteArray(inputStream);
			Image foto = Image.getInstance(bytes);
			foto.scaleToFit(100, 100);
			foto.setUseVariableBorders(true);
			foto.setBorderColor(Color.BLACK);
			foto.setBorderWidthTop(1);
			foto.setBorderWidthBottom(1);
			foto.setBorderWidthLeft(1);
			foto.setBorderWidthRight(1);
			inputStream.close();
			
			PdfPCell cell_image;
			cell_image = new PdfPCell(foto);
			cell_image.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell_image.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell_image.setMinimumHeight(50);
			cell_image.setBorder(0);
			
			PdfPCell cell_subTitle;
			cell_subTitle = new PdfPCell(new Phrase("INFORMACIÓN GENERAL", subTitleFont));
			cell_subTitle.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_subTitle.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell_subTitle.setMinimumHeight(20);
			cell_subTitle.setBorder(0);

			titulo.addCell(cell_0);
			titulo.addCell(cell_title);
			titulo.addCell(cell_0);
			titulo.addCell(cell_image);
			titulo.addCell(cell_0);
			titulo.addCell(cell_subTitle);
			titulo.addCell(cell_0);

			Font tableHeadFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

			PdfPTable contenido = new PdfPTable(2);
			contenido.setWidthPercentage(100);
			contenido.setWidths(new int[] { 2, 3 });

			PdfPCell cell_1;
			cell_1 = new PdfPCell(new Phrase("Código", tableHeadFont));
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setPadding(5);
			cell_1.setBackgroundColor(Color.decode("#F5F7F7"));
			contenido.addCell(cell_1);

			cell_1 = new PdfPCell(new Phrase(familiar.getIdFamiliar().toString()));
			cell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_1.setPadding(5);
			contenido.addCell(cell_1);

			PdfPCell cell_2;
			cell_2 = new PdfPCell(new Phrase("Nombres", tableHeadFont));
			cell_2.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_2.setPadding(5);
			cell_2.setBackgroundColor(Color.decode("#F5F7F7"));
			contenido.addCell(cell_2);

			cell_2 = new PdfPCell(new Phrase(familiar.getNombres()));
			cell_2.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_2.setPadding(5);
			contenido.addCell(cell_2);

			PdfPCell cell_3;
			cell_3 = new PdfPCell(new Phrase("Apellidos", tableHeadFont));
			cell_3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_3.setPadding(5);
			cell_3.setBackgroundColor(Color.decode("#F5F7F7"));
			contenido.addCell(cell_3);

			cell_3 = new PdfPCell(new Phrase(familiar.getApellidos()));
			cell_3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_3.setPadding(5);
			contenido.addCell(cell_3);

			PdfPCell cell_4;
			cell_4 = new PdfPCell(new Phrase("Tipo Documento", tableHeadFont));
			cell_4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_4.setPadding(5);
			cell_4.setBackgroundColor(Color.decode("#F5F7F7"));
			contenido.addCell(cell_4);

			cell_4 = new PdfPCell(new Phrase(familiar.getTipoDocumento().getDescripcion()));
			cell_4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_4.setPadding(5);
			contenido.addCell(cell_4);
			
			PdfPCell cell_5;
			cell_5 = new PdfPCell(new Phrase("Número Documento", tableHeadFont));
			cell_5.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_5.setPadding(5);
			cell_5.setBackgroundColor(Color.decode("#F5F7F7"));
			contenido.addCell(cell_5);

			cell_5 = new PdfPCell(new Phrase(familiar.getNumDocumento()));
			cell_5.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_5.setPadding(5);
			contenido.addCell(cell_5);
			
			PdfPCell cell_6;
			cell_6 = new PdfPCell(new Phrase("Fecha Nacimiento", tableHeadFont));
			cell_6.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_6.setPadding(5);
			cell_6.setBackgroundColor(Color.decode("#F5F7F7"));
			contenido.addCell(cell_6);

			cell_6 = new PdfPCell(new Phrase(familiar.getFechaNac().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
			cell_6.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_6.setPadding(5);
			contenido.addCell(cell_6);
			
			PdfPCell cell_7;
			cell_7 = new PdfPCell(new Phrase("Sexo", tableHeadFont));
			cell_7.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_7.setPadding(5);
			cell_7.setBackgroundColor(Color.decode("#F5F7F7"));
			contenido.addCell(cell_7);

			cell_7 = new PdfPCell(new Phrase(familiar.getSexo().getDescripcion()));
			cell_7.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_7.setPadding(5);
			contenido.addCell(cell_7);
			
			PdfPCell cell_8;
			cell_8 = new PdfPCell(new Phrase("Teléfono Celular", tableHeadFont));
			cell_8.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_8.setPadding(5);
			cell_8.setBackgroundColor(Color.decode("#F5F7F7"));
			contenido.addCell(cell_8);

			cell_8 = new PdfPCell(new Phrase(familiar.getTelCelular()));
			cell_8.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_8.setPadding(5);
			contenido.addCell(cell_8);
			
			PdfPCell cell_9;
			cell_9 = new PdfPCell(new Phrase("Teléfono Fijo", tableHeadFont));
			cell_9.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_9.setPadding(5);
			cell_9.setBackgroundColor(Color.decode("#F5F7F7"));
			contenido.addCell(cell_9);

			cell_9 = new PdfPCell(new Phrase(familiar.getTelFijo()));
			cell_9.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_9.setPadding(5);
			contenido.addCell(cell_9);
			
			PdfPCell cell_10;
			cell_10 = new PdfPCell(new Phrase("Correo", tableHeadFont));
			cell_10.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_10.setPadding(5);
			cell_10.setBackgroundColor(Color.decode("#F5F7F7"));
			contenido.addCell(cell_10);

			cell_10 = new PdfPCell(new Phrase(familiar.getCorreo()));
			cell_10.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_10.setPadding(5);
			contenido.addCell(cell_10);
			
			PdfPCell cell_11;
			cell_11 = new PdfPCell(new Phrase("Familiar del Alumno", tableHeadFont));
			cell_11.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_11.setPadding(5);
			cell_11.setBackgroundColor(Color.decode("#F5F7F7"));
			contenido.addCell(cell_11);

			cell_11 = new PdfPCell(new Phrase(familiar.getAlumno().getNombres() + ' ' + familiar.getAlumno().getApellidos()));
			cell_11.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_11.setPadding(5);
			contenido.addCell(cell_11);
			
			PdfPCell cell_12;
			cell_12 = new PdfPCell(new Phrase("Parentesco", tableHeadFont));
			cell_12.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_12.setPadding(5);
			cell_12.setBackgroundColor(Color.decode("#F5F7F7"));
			contenido.addCell(cell_12);

			cell_12 = new PdfPCell(new Phrase(familiar.getParentesco().getDescripcion()));
			cell_12.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell_12.setPadding(5);
			contenido.addCell(cell_12);

			document.open();
			document.add(titulo);
			document.add(contenido);
			document.close();

		} catch (DocumentException ex) {

			logger.error("Error occurred: {0}", ex);
		}

		return new ByteArrayInputStream(out.toByteArray());
	}
}

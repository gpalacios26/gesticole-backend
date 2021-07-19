package com.gregpalacios.gesticole.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.gregpalacios.gesticole.model.Personal;

public class ExcelGeneratorPersonal {

	public static ByteArrayInputStream listadoToExcel(List<Personal> personal) throws IOException {
		String[] COLUMNs = { "ID", "Nombres", "Apellidos", "Tipo Documento", "Número Documento", "Fecha Nacimiento", 
				"Sexo", "Teléfono Celular", "Teléfono Fijo", "Correo", "Tipo Cargo", "Cargo" };
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			Sheet sheet = workbook.createSheet("Personal");
			
            Font titleFont = workbook.createFont();
            titleFont.setBold(true);
            titleFont.setColor(IndexedColors.WHITE.getIndex());
            titleFont.setFontHeightInPoints((short) 14);
            
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.WHITE.getIndex());
			headerFont.setFontHeightInPoints((short) 12);
			
			Font bodyFont = workbook.createFont(); 
			bodyFont.setBold(false);
			bodyFont.setColor(IndexedColors.BLACK.getIndex());
			bodyFont.setFontHeightInPoints((short) 10);
			
			CellStyle copyCellStyle = workbook.createCellStyle();
			copyCellStyle.setFont(titleFont);
			copyCellStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.getIndex());
			copyCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			copyCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			copyCellStyle.setAlignment(HorizontalAlignment.CENTER);
			
			CellStyle titleCellStyle = workbook.createCellStyle();
			titleCellStyle.setFont(headerFont);
			titleCellStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.getIndex());
			titleCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			titleCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			titleCellStyle.setAlignment(HorizontalAlignment.LEFT);
            
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerCellStyle.setFont(headerFont);
            headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
            headerCellStyle.setBorderLeft(BorderStyle.THIN);
            headerCellStyle.setBorderRight(BorderStyle.THIN);
            headerCellStyle.setBorderTop(BorderStyle.THIN);
            headerCellStyle.setBorderBottom(BorderStyle.THIN);
            headerCellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
            headerCellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
            headerCellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
            headerCellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
            
            CellStyle BodyCellStyle = workbook.createCellStyle();
            BodyCellStyle.setVerticalAlignment(VerticalAlignment.JUSTIFY);
            BodyCellStyle.setAlignment(HorizontalAlignment.JUSTIFY);
            BodyCellStyle.setFont(bodyFont);
            BodyCellStyle.setBorderLeft(BorderStyle.THIN);
            BodyCellStyle.setBorderRight(BorderStyle.THIN);
            BodyCellStyle.setBorderTop(BorderStyle.THIN);
            BodyCellStyle.setBorderBottom(BorderStyle.THIN);
            BodyCellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
            BodyCellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
            BodyCellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
            BodyCellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
            
            Row rowCopy = sheet.createRow(0);
            rowCopy.setHeightInPoints(30);
            Cell cell_App = rowCopy.createCell(0);
            cell_App.setCellValue("GestiCole - Sistema de Gestión Académica de Colegios");
            cell_App.setCellStyle(copyCellStyle);
            
            Row rowTitulo = sheet.createRow(1);
            rowTitulo.setHeightInPoints(30);
            Cell cell_Title = rowTitulo.createCell(0);
            cell_Title.setCellValue("LISTADO DE PERSONAL");
            cell_Title.setCellStyle(titleCellStyle);
            
            sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$L$1"));
            sheet.addMergedRegion(CellRangeAddress.valueOf("$A$2:$L$2"));

			Row headerRow = sheet.createRow(3);

			// Header
			for (int col = 0; col < COLUMNs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(COLUMNs[col]);
				cell.setCellStyle(headerCellStyle);
			}

			// Content
			int rowIdx = 4;
			for (Personal datos : personal) {
				Row row = sheet.createRow(rowIdx++);

				Cell cell_1 = row.createCell(0);
				cell_1.setCellValue(datos.getIdPersonal());
				cell_1.setCellStyle(BodyCellStyle);
				
				Cell cell_2 = row.createCell(1);
				cell_2.setCellValue(datos.getNombres());
				cell_2.setCellStyle(BodyCellStyle);
				
				Cell cell_3 = row.createCell(2);
				cell_3.setCellValue(datos.getApellidos());
				cell_3.setCellStyle(BodyCellStyle);
				
				Cell cell_4 = row.createCell(3);
				cell_4.setCellValue(datos.getTipoDocumento().getDescripcion());
				cell_4.setCellStyle(BodyCellStyle);
				
				Cell cell_5 = row.createCell(4);
				cell_5.setCellValue(datos.getNumDocumento());
				cell_5.setCellStyle(BodyCellStyle);
				
				Cell cell_6 = row.createCell(5);
				cell_6.setCellValue(datos.getFechaNac().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				cell_6.setCellStyle(BodyCellStyle);
				
				Cell cell_7 = row.createCell(6);
				cell_7.setCellValue(datos.getSexo().getDescripcion());
				cell_7.setCellStyle(BodyCellStyle);
				
				Cell cell_8 = row.createCell(7);
				cell_8.setCellValue(datos.getTelCelular());
				cell_8.setCellStyle(BodyCellStyle);
				
				Cell cell_9 = row.createCell(8);
				cell_9.setCellValue(datos.getTelFijo());
				cell_9.setCellStyle(BodyCellStyle);
				
				Cell cell_10 = row.createCell(9);
				cell_10.setCellValue(datos.getCorreo());
				cell_10.setCellStyle(BodyCellStyle);
				
				Cell cell_11 = row.createCell(10);
				cell_11.setCellValue(datos.getTipoPersonal().getDescripcion());
				cell_11.setCellStyle(BodyCellStyle);
				
				Cell cell_12 = row.createCell(11);
				cell_12.setCellValue(datos.getCargo());
				cell_12.setCellStyle(BodyCellStyle);
			}

			// Resize all columns to fit the content size
			for (int i = 0; i < COLUMNs.length; i++) {
				sheet.autoSizeColumn(i);
			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}
}

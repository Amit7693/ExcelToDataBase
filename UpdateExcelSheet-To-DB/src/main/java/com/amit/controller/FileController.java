package com.amit.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.amit.service.FileUploadService;

@Controller
public class FileController {

	@Autowired
	FileUploadService fileUploadService;

	@RequestMapping(value = "/uploadpage", method = RequestMethod.GET)
	public ModelAndView fileUploadPage() {
		return new ModelAndView("upload");
	}

	@RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
	public ModelAndView singleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {

		// If File is Empty
		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return new ModelAndView("upload", "message", "Please select a file to upload");
		}

		// If File is .xls
		if (file.getOriginalFilename().endsWith(".xls")) {
			System.out.println(".xls file found");
			try {

				// Retrive the file and write somewhere else
				byte[] bytes = file.getBytes();
				Path path = Paths.get("c://tempfile//" + file.getOriginalFilename());
				Files.write(path, bytes);

				System.out.println("write complete"); // write complete to temp
														// folder
				FileInputStream fis = new FileInputStream("c://tempfile//" + file.getOriginalFilename());
				HSSFWorkbook workbook=new HSSFWorkbook(fis);
				String type="HSSF";
				fileUploadService.uploadFileData(workbook, type);

				redirectAttributes.addFlashAttribute("message",
						"Your file successfully uploaded '" + file.getOriginalFilename() + "'");

			} catch (IOException e) {
				redirectAttributes.addFlashAttribute("message",
						"Failure occured during upload '" + file.getOriginalFilename() + "'");
				e.printStackTrace();
			}
		}

		// If file is .xlsx
		if (file.getOriginalFilename().endsWith(".xlsx")) {
			System.out.println(".xlsx file found");
			try {

				// Retrive the file and write somewhere else
				byte[] bytes = file.getBytes();
				Path path = Paths.get("c://tempfile//" + file.getOriginalFilename());
				Files.write(path, bytes);

				System.out.println("write complete"); 
														
				FileInputStream fis = new FileInputStream("c://tempfile//" + file.getOriginalFilename());
				
				XSSFWorkbook workbook=new XSSFWorkbook(fis);
				String type="XSSF";
				fileUploadService.uploadFileData(workbook, type);

				redirectAttributes.addFlashAttribute("message",
						"Your file successfully uploaded '" + file.getOriginalFilename() + "'");

			} catch (IOException e) {
				redirectAttributes.addFlashAttribute("message",
						"Failure occured during upload '" + file.getOriginalFilename() + "'");
				e.printStackTrace();
			}
		}

		return new ModelAndView("upload", "message", "file uploaded '" + file.getOriginalFilename() + "'");
	}
}

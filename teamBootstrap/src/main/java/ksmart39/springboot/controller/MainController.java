package ksmart39.springboot.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model
						,@RequestParam(name = "loginResult", required = false) String loginResult) {
	
		ModelAndView mav = new ModelAndView();
		mav.addObject("title","teamoneERP");
		mav.setViewName("login");
		if(loginResult != null) model.addAttribute("loginResult", loginResult);
		
		return "login/index";
	}
	
	@GetMapping("/mesmain")
	public String mesmain(Model model) {
		return "/mesmain";
	}
	
	
	//개발문서 다운로드
	@RequestMapping("/fileDownload")
	@ResponseBody
	public ResponseEntity<Resource> fileDownload(HttpServletResponse response, HttpServletRequest request, HttpSession session) throws IOException {
		
		//File file = new File(System.getProperty("user.dir") + "/src/main/resources/static/file/"+"team01QC_smartFactoryMes.xlsx");
		//cafe24배포할때 이걸로
		File file = new File(session.getServletContext().getRealPath("/WEB-INF/classes/static/file/"+"team01QC_smartFactoryMes.xlsx"));
		
	        Path path = Paths.get(file.getAbsolutePath());
	        Resource resource = new UrlResource(path.toUri());
	        String contentType = null;
	        contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
	        if(contentType == null) {
	            contentType = "application/octet-stream";
	        }
	        //ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
		/*
		 * HttpHeaders header = new HttpHeaders();
		 * header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" +
		 * file.getName()); header.add("Cache-Control",
		 * "no-cache, no-store, must-revalidate"); header.add("Pragma", "no-cache");
		 * header.add("Expires", "0");
		 */
	        
		
		return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
		
	}
	
	//완료보고서 다운로드
	@RequestMapping("/fileDownload2")
	@ResponseBody
	public ResponseEntity<Resource> fileDownload2(HttpServletResponse response, HttpServletRequest request, HttpSession session) throws IOException {
		
		//File file = new File(System.getProperty("user.dir") + "/src/main/resources/static/file/"+"team01QC_smartFactoryMes.docx");
		//cafe24배포할때 이걸로
		File file = new File(session.getServletContext().getRealPath("/WEB-INF/classes/static/file/"+"team01QC_smartFactoryMes.docx"));
		
		Path path = Paths.get(file.getAbsolutePath());
		Resource resource = new UrlResource(path.toUri());
		String contentType = null;
		contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		if(contentType == null) {
			contentType = "application/octet-stream";
		}
		//ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
		/*
		 * HttpHeaders header = new HttpHeaders();
		 * header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" +
		 * file.getName()); header.add("Cache-Control",
		 * "no-cache, no-store, must-revalidate"); header.add("Pragma", "no-cache");
		 * header.add("Expires", "0");
		 */
		
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
		
	}
}

package org.sis.board.controller;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.sis.board.model.MatchingAttachVO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.java.Log;
import net.coobird.thumbnailator.Thumbnailator;

@RestController
@RequestMapping("/upload_matching/*")
@Log
public class MatchingUploadController {
	
	@PostMapping("/deleteFile")
	public ResponseEntity<String> deleteFile(String fileName, String type){
		log.info("DeleteFile: "+ fileName);
		File file;
		
		try {
			file = new File("c:\\upload\\matching\\"+ URLDecoder.decode(fileName,"UTF-8"));
			file.delete();
			
			  if(type.equals("image")) { String largeFileName=
			  file.getAbsolutePath().replace("s_","");
			  log.info("largeFileName: "+largeFileName); file = new File(largeFileName);
			  file.delete(); }
			 
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("deleted",HttpStatus.OK);
		
	}
	
	
	@GetMapping("/getImage")
	public ResponseEntity<byte[]> getImage(String fileName){
		log.info("fileName: " + fileName);
		File file = new File("c:\\upload\\matching\\"+fileName);
		File watermarkImageFile = new File("c:\\upload\\logo.png");
		File changeFile = new File("c:\\upload\\matching\\"+fileName);
		addImageWatermark(watermarkImageFile, file, changeFile);
		log.info("file: "+file);
		
		ResponseEntity<byte[]> result = null;
		
		try {
			HttpHeaders header = new HttpHeaders();
			
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(changeFile),header,HttpStatus.OK);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value = "/newFiles", method = RequestMethod.POST)
	public ResponseEntity<List<MatchingAttachVO>> upload(MultipartFile[] uploadFile) {

		List<MatchingAttachVO> list = new ArrayList<>();
		String uploadFolder = "C://Upload//matching";
		String uploadFolderPath = getFolder();

		// make folder-----------------------------------
		File uploadPath = new File(uploadFolder, getFolder());
		log.info("upload path: " + uploadPath);

		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}

		for (MultipartFile multipartFile : uploadFile) {

			MatchingAttachVO matchingAttachVO = new MatchingAttachVO();

			log.info("-------------------------------------");
			log.info("Upload File Name: " + multipartFile.getOriginalFilename());
			String uploadFileName = multipartFile.getOriginalFilename();
			log.info("Upload File Size: " + multipartFile.getSize());

			matchingAttachVO.setFileName(uploadFileName);
			UUID uuid = UUID.randomUUID();

			uploadFileName = uuid.toString() + "_" + uploadFileName;
			

			try {
				FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
				Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 300, 300);
				thumbnail.close();
				
				
				File saveFile = new File(uploadPath, uploadFileName);
				multipartFile.transferTo(saveFile);

				matchingAttachVO.setUuid(uuid.toString());
				matchingAttachVO.setUploadPath(uploadFolderPath);
				matchingAttachVO.setImage(true);
				
				

				list.add(matchingAttachVO);
			} catch (Exception e) {
				e.printStackTrace();
			} // end catch
		} // end for
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);

		return str.replace("-", File.separator);
	}
	
	private static void addImageWatermark(File watermarkImageFile, File sourceImageFile, File destImageFile) {
		try {
			BufferedImage sourceImage = ImageIO.read(sourceImageFile);
			BufferedImage watermarkImage = ImageIO.read(watermarkImageFile);

			// initializes necessary graphic properties
			Graphics2D g2d = (Graphics2D) sourceImage.getGraphics();
			// 투명도
			AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
			g2d.setComposite(alphaChannel);

			// 워터마크 센터 공식
			int topLeftX = (sourceImage.getWidth() - watermarkImage.getWidth()) / 2;
			int topLeftY = (sourceImage.getHeight() - watermarkImage.getHeight()) / 2;

			System.out.println(sourceImage.getWidth() + " : " + sourceImage.getHeight());
			System.out.println(watermarkImage.getWidth() + " : " + watermarkImage.getHeight());
			System.out.println("x:" + topLeftX + "\ty:" + topLeftY);
			// 워터마크 좌하구석 공식
			int watermarkX = sourceImage.getWidth()-watermarkImage.getWidth();
			int watermarkY = sourceImage.getHeight()-watermarkImage.getHeight();
			
			System.out.println("x:" + watermarkX + "\ty:" + watermarkY);

			// paints the image watermark
			g2d.drawImage(watermarkImage, watermarkX, watermarkY, null);

			ImageIO.write(sourceImage, "png", destImageFile);
			g2d.dispose();

			System.out.println("The image watermark is added to the image.");

		} catch (IOException ex) {
			System.err.println(ex);
		}
	}

}

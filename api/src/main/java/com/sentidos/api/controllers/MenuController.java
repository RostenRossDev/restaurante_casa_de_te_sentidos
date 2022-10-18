package com.sentidos.api.controllers;

import com.google.zxing.WriterException;
import com.sentidos.api.dto.MenuDesktop;
import com.sentidos.api.dto.MenuDto;
import com.sentidos.api.dto.QRCodeGenerator;
import com.sentidos.api.enitiesWrapper.MenuWrapper;
import com.sentidos.api.entities.Menu;
import com.sentidos.api.services.MenuService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/menu/")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/static/imgQr/qr.png";

    @GetMapping
    public  ResponseEntity<Map<String, Object>> allMenu(){

        return null;
    }
    
    @GetMapping("{id}")
    public  ResponseEntity<Map<String, Object>> menuById(@PathVariable(value = "id") Long id){
    	Map<String, Object> response = new HashMap<String, Object>();
    	MenuDto menuDto = MenuWrapper.entityToDto(menuService.findById(id));
    	response.put("menu", menuDto);
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
    }

    @GetMapping("qr/{id}")
    public ResponseEntity<Map<String, Object>> QrMenuById(){
    	Map<String, Object> response = new HashMap<>();
    	
    	
    	return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
    }

    
    @GetMapping ("all/qr") 
    public ResponseEntity<Map<String, Object>> allQrMenu(){    	
    	Map<String, Object> response = new HashMap<>();
    	List<Menu> menues= menuService.allMenu();
    	List<String> menuesBase64String= new ArrayList<>();
    	
    	//byte[] image = new byte[0];
    	 
    		 menues.forEach(menu ->{
    			// Generate and Return Qr Code in Byte Array
    			byte[] image;
				try {
					image = QRCodeGenerator.getQRCodeImage("localhost:8080/api/v1/menu/".concat(menu.getId()+""),250,250);
					String qrcode = Base64.getEncoder().encodeToString(image);
					menuesBase64String.add(qrcode);
				} catch (WriterException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}   			
    		 });
             
             // Generate and Save Qr Code Image in static/image folder
             //QRCodeGenerator.generateQRCodeImage(medium,250,250,QR_CODE_IMAGE_PATH);
         
    	response.put("menues", menuesBase64String);
    	 
    	return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
    }
    
    
    @GetMapping("/all/desktop")
    public ResponseEntity<Map<String, Object>> allDesktop(){
    	Map<String, Object> response = new HashMap<>();
    	List<Menu> menues = menuService.allMenu();
    	List<MenuDesktop> menuesDesktop= new ArrayList<>();
    	menues.forEach(m->{
    		MenuDesktop dto = new MenuDesktop();
    		dto.setIsEnabled(dto.getIsEnabled());
    		dto.setMenuType(m.getMenuType().getType());
    		dto.setName(m.getName());
    		dto.setPrice(m.getPrice());
    		menuesDesktop.add(dto);
    	});
    	
    	response.put("menues", menuesDesktop);
    	return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
    }
 
}

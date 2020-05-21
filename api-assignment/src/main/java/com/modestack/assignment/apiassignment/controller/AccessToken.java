package com.modestack.assignment.apiassignment.controller;

import java.util.Random;

import org.springframework.stereotype.Component;

//Access token generation
@Component
public class AccessToken 
{     
	
	public String generateAccessToken() 
    { 
    	int len = 36; 
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
        String Small_chars = "abcdefghijklmnopqrstuvwxyz"; 
        String numbers = "0123456789"; 
  
        String values = Capital_chars + Small_chars + 
                        numbers; 
  
        
        Random rndm_method = new Random(); 
  
        char[] password = new char[len]; 
  
        for (int i = 0; i < len; i++) 
        { 
            password[i] = 
              values.charAt(rndm_method.nextInt(values.length())); 
  
        }
        
        return new String(password); 
    } 
} 

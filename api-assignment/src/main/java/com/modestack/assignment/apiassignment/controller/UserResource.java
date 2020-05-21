package com.modestack.assignment.apiassignment.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.modestack.assignment.apiassignment.article.Article;
import com.modestack.assignment.apiassignment.article.ArticleRepository;
import com.modestack.assignment.apiassignment.user.User;
import com.modestack.assignment.apiassignment.user.UserNotFoundException;
import com.modestack.assignment.apiassignment.user.UserRepository;

//this controller is being used for all incoming request.
@RestController
public class UserResource {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private AccessToken accessToken;
	
	@PostMapping("/register")
	public ResponseEntity registerUser(@RequestBody User user)
	{		
		Optional<User> userInDB = userRepository.findById(user.getUsername());		
		if(userInDB.isPresent())
			throw new UserNotFoundException("username is already registered: "+user.getUsername());
	
		userRepository.save(user);
		Map<String,String> responseMap = new HashMap();
		responseMap.put("message", "new user created");
		return new ResponseEntity(responseMap,HttpStatus.CREATED);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<Object> loginUser(@RequestBody User user)
	{		
		Optional<User> userInDB = userRepository.findById(user.getUsername());		
		if(!userInDB.isPresent())
			throw new UserNotFoundException("username is not registered: "+user.getUsername());
		
		if(!userInDB.get().getPassword().equals(user.getPassword())) 
			throw new UserNotFoundException("password is incorrect");
	
		Map<String,String> responseMap = new HashMap();
		responseMap.put("message", "Success");
		responseMap.put("accessToken", accessToken.generateAccessToken());
		
		Map<String,Map> bodyResponseMap = new HashMap();
		bodyResponseMap.put("body", responseMap);
		return new ResponseEntity(bodyResponseMap,HttpStatus.OK);
	}
	
	
	@PostMapping("/articles")
	public ResponseEntity addArticle(@RequestBody Article article)
	{		
		Optional<Article> articleInDB = articleRepository.findById(article.getTitle());		
		if(articleInDB.isPresent())
			throw new UserNotFoundException("Article is already created: "+article.getTitle());
	
		
		Optional<User> userInDB = userRepository.findById(article.getAuthor());		
		if(!userInDB.isPresent())
			throw new UserNotFoundException("Author is not registered: "+article.getAuthor());
	
		articleRepository.save(article);
		Map<String,String> responseMap = new HashMap();
		responseMap.put("message", "New article is created");
		return new ResponseEntity(responseMap,HttpStatus.CREATED);
	}
	
	@GetMapping("/articles")
	public ResponseEntity listArticles()
	{		
		List<Article> articleInDB = articleRepository.findAll();		
		if(articleInDB.isEmpty())
			throw new UserNotFoundException("No article found ");
	
		Map<String,List> responseMap = new HashMap();
		responseMap.put("data", articleInDB);
		return new ResponseEntity(responseMap,HttpStatus.OK);
	}
	
	

}


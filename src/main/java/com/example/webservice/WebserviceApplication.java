package com.example.webservice;

import model.Personne;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@SpringBootApplication
public class WebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebserviceApplication.class, args);
	}

	@GetMapping("/login/{name}/{pass}")
	public boolean login(@PathVariable("name") String name, @PathVariable("pass") String pass) {
		boolean res = false;
		if (name.compareTo("hasina")==0&&(pass.compareTo("hasina")==0)){
			res=true;
		}
		return res;
	}
	@GetMapping("/liste")
	public List<Personne> listePersonne(){
		List<Personne> list=new ArrayList<>();
		Personne[] personnes=new Personne[5];
		personnes[0]=new Personne(0,"hasina","hasina",5);
		personnes[1]=new Personne(1,"h","hasina",5);
		personnes[2]=new Personne(2,"haasina","hasina",5);
		personnes[3]=new Personne(3,"fitiavana","hasina",5);
		personnes[4]=new Personne(4,"hasina","hasina",5);
		for (int i=0;i< personnes.length;i++){
			list.add(personnes[i]);
		}
		return list;
	}
}

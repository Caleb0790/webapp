package fr.iocean.webapp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String foo() {
		return "Hello word";
	}

	@RequestMapping(value="/images/search/{annee}/{mois}/{jours}", method=RequestMethod.GET)
	@ResponseBody
	public String affiche(@PathVariable("annee") String annee, @PathVariable("mois") String mois, @PathVariable("jours") String jours, @RequestParam("sort") String sort) throws ParseException {

		SimpleDateFormat  formater = new SimpleDateFormat("ddmmyyyy");
		//SimpleDateFormat formater2 = new SimpleDateFormat("dd MMM yyyy");



		Date date=null;

			date= formater.parse(jours+mois+annee);
	
		//System.out.println(formater.format(date));
		return "Liste des images du " +date.toString()+ " triées par "+ sort ;
	}
}

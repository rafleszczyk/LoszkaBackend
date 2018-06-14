package io.modeling.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.modeling.models.Model;
import io.modeling.services.NewsService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class NewsController {

	@Autowired
	private NewsService newsService;
	
	@RequestMapping("/news")
	public List<Model> getNews() {
		return newsService.getAllNews();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/news/{id}")
	public Model getNewInfo(@PathVariable int id) {
		return newsService.findNewById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/news")
	public void addNew(@RequestBody Model newsModel) {
		newsService.addNews(newsModel);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/news/{id}")
	public void updateNew(@RequestBody Model newsModel, @PathVariable int id) {
		newsService.updateNews(id, newsModel);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/news/{id}")
	public void deleteAlley(@PathVariable int id) {
		newsService.deleteNews(id);
	}
}

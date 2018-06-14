package io.modeling.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.modeling.models.Model;

@Service
public class NewsService {

	@Autowired
	private NewsRepository newsRepository; 
	
	public List<Model> getAllNews() {
		List<Model> newsArray = new ArrayList<>();
		newsRepository.findAll().forEach(newsArray::add);
		return newsArray;
	}
	
	public Model findNewById(int id) {
		return newsRepository.findById(id).orElse(null);
	}
	
	public void addNews(Model newsModel) {
		newsRepository.save(newsModel);
	}
	
	public void deleteNews(int id) {
		newsRepository.deleteById(id);
	}
	
	public void updateNews(int id, Model newsModel) {
		newsRepository.save(newsModel);
	}
}

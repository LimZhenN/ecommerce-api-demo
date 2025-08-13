package com.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.repository.TagRepository;
import com.example.ecommerce.model.Tag;

@Service
public class TagService {
	
	@Autowired
	private TagRepository tagRepository;
	
	public Tag createTag(Tag tag) {
		return tagRepository.save(tag);
	}
	
	public List<Tag> getAllTag(){
		return tagRepository.findAll();
	}
	
	public List<Tag> getByTagId(List<Long> id){
		return tagRepository.findAllById(id);
	}

}

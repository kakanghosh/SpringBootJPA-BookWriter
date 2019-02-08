package com.welldev.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.welldev.models.Writer;
import com.welldev.services.WriterService;

@RestController
public class WriterController {

	@Autowired
	WriterService writerService;

	@RequestMapping("/writers")
	public List<Writer> writers() {
		return this.writerService.getWriters();
	}

	@RequestMapping("/writers/{id}")
	public Optional<Writer> getWriter(@PathVariable("id") Integer writerID) {
		return this.writerService.getSingleWriter(writerID);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/writers")
	public Writer insertWriter(@RequestBody Writer writer) {
		return this.writerService.addWriter(writer);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/writers/list")
	public List<Writer> insertWritersList(@RequestBody List<Writer> writersList) {
		this.writerService.addWritersList(writersList);
		return writersList;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/writers/{id}")
	public Writer updateWriter(@RequestBody Writer writer, @PathVariable("id") Integer id) {
		return this.writerService.updateWriter(id, writer);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/writers/{id}")
	public Boolean deleteWriter(@PathVariable("id") Integer id) {
		return this.writerService.deleteWriter(id);
	}
}

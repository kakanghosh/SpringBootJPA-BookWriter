package com.welldev.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.welldev.models.Writer;
import com.welldev.repositories.WriterRepository;

@Service
public class WriterService {
//	private List<Writer> writers = new ArrayList<Writer>(Arrays.asList(new Writer(1, "ABC"), new Writer(2, "DEF"),
//			new Writer(3, "GHI"), new Writer(4, "JKL"), new Writer(5, "MNO")));
	@Autowired
	private WriterRepository writerRepository;
	private List<Writer> writers = new ArrayList<Writer>();

	public List<Writer> getWriters() {
		try {
			this.setWriters(writerRepository.findAll());
			System.out.println(writers);
			return writers;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public void setWriters(List<Writer> writers) {
		this.writers = writers;
	}

	public Optional<Writer> getSingleWriter(Integer id) {
		Optional<Writer> writer = this.writerRepository.findById(id);
		return writer;
	}

	public Writer addWriter(Writer writer) {
		Writer writer2 = writerRepository.save(writer);
		System.out.println(writer2);
		return writer2;
	}

	public Writer updateWriter(Integer id, Writer writer) {
		writer.setId(id);
		return this.writerRepository.save(writer);
	}

	public Boolean deleteWriter(Integer id) {
		this.writerRepository.deleteById(id);
		return this.writerRepository.findById(id).equals(Optional.empty())? true : false;
	}

	public void addWritersList(List<Writer> writersList) {
		for (Writer writer : writersList) {
			this.addWriter(writer);
		}
	}

}

package com.odi.api.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.odi.api.entity.Album;
import com.odi.api.repository.AlbumsRepository;
import com.odi.api.service.IAlbumsService;

@Service
public class AlbumService implements IAlbumsService {
	
	@Autowired
	private AlbumsRepository albumRepo;

	@Override
	public List<Album> buscarTodos() {
		return albumRepo.findAll();
	}

	@Override
	public void guardar(Album album) {
		albumRepo.save(album);
		
	}

	@Override
	public void borrar(int idAlbum) {
		albumRepo.deleteById(idAlbum);
	}

	@Override
	public Optional<Album> buscarPorId(int id) {
		return albumRepo.findById(id);
	}

	@Override
	public Optional<Album> buscarPorTitulo(String nombre) {
		return albumRepo.findByTituloContaining(nombre);
	}

	

	





}

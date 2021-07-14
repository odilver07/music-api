package com.odi.api.service;

import java.util.List;
import java.util.Optional;
import com.odi.api.entity.Album;

public interface IAlbumsService {
	List<Album> buscarTodos();
	void guardar(Album album);
	void borrar(int idAlbum);
	Optional<Album> buscarPorId(int id);
	Optional<Album> buscarPorTitulo(String nombre);
}

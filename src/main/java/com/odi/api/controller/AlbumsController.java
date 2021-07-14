package com.odi.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.odi.api.entity.Album;
import com.odi.api.repository.AlbumsRepository;
import com.odi.api.service.IAlbumsService;

@RestController
@RequestMapping("/api")
public class AlbumsController {
	
	@Autowired
	private IAlbumsService albumService;
	
	@GetMapping("/buscar/{nombre}")
	public Optional<Album> buscarPorIdNombre(@PathVariable("nombre") String nombre) {
		
		try {
			int id = Integer.parseInt(nombre);
			return albumService.buscarPorId(id);
		}catch (Exception e) {
			return albumService.buscarPorTitulo(nombre);
		}
		
	}
	
	
	@GetMapping("/albums")
	public List<Album> buscarTodos(){
		return albumService.buscarTodos();
	}
	
	@PostMapping("/albums")
	public Album guardar(@RequestBody Album album) {
		albumService.guardar(album);
		return album;
	}
	
	@PutMapping("/albums")
	public Album modificar(@RequestBody Album album) {
		albumService.guardar(album);
		return album;
	}
	
	@DeleteMapping("/albums/{id}")
	public String borrar(@PathVariable("id") int idAlbum) {
		albumService.borrar(idAlbum);
		return "Registro eliminado";
	}

}

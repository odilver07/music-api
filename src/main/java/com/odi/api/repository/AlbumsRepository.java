package com.odi.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.odi.api.entity.Album;

public interface AlbumsRepository extends JpaRepository<Album, Integer> {
	
	Optional<Album> findByTituloContaining(String nombre);
}

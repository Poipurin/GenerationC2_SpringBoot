package cl.generation.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.generation.web.models.Auto;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Long>{

	Auto findByMarca(String marca);


	//logica de manipulacion de datos (CRUD+)
	//JPQL 
	
	//obtener lista de autos por marca
	@Query("SELECT a FROM Auto a WHERE a.marca = ?1")
	List<Auto> findAllByMarca(String marca);
	
	//obtener lista de autos por marca y color
		@Query("SELECT a FROM Auto a WHERE a.marca = ?1 and a.color = ?2")
		List<Auto> findAllByMarca(String marca, String color);

		//JPQL 	lista de todos los autos de un usuario
		@Query("select a from Auto a where a.usuario.id = ?1")
		List<Auto> findAllByUsuario(Long id);

	//query comun
		@Query(value="select * from autos a where a.marca = ?1;", nativeQuery = true)
		List<Auto> findAllByMarcaComun(String marca);
}	
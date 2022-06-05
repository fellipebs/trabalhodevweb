package com.example.blog.repository;
import java.util.List;
import java.util.Optional;

import com.example.blog.model.Favoritos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("FavoritosRepository")
public interface FavoritosRepository extends JpaRepository<Favoritos, Integer> {

    @Query(value = "SELECT * FROM FAVORITOS WHERE id_post = ?1", nativeQuery = true)
    List<Favoritos> getAllFavoritosByPostId(int id);   

    @Query(value = "SELECT COUNT(*) FROM FAVORITOS WHERE ID_POST = ?1 GROUP BY ID_POST", nativeQuery = true)
    Optional<Integer> getCountOfFavoritosByPostId(int id);

    @Query(value = "SELECT COUNT(*) FROM FAVORITOS WHERE ID_POST = ?1 AND ID_USUARIO = ?2", nativeQuery = true)
    int getFavoritoByUsuarioAndPost(int id_post, int id_usuario);
}

package com.gworld.manage.repository;

import com.gworld.manage.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
//    Optional<List<Board>> findAllByDelete_yn(boolean deleteYn, String typeCode);
}

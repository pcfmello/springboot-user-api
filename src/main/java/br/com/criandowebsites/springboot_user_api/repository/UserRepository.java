package br.com.criandowebsites.springboot_user_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.criandowebsites.springboot_user_api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

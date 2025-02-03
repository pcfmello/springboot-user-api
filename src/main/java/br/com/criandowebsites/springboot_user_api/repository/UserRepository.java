package br.com.criandowebsites.springboot_user_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.criandowebsites.springboot_user_api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

package com.kadir.financetracker.repository;
import com.kadir.financetracker.model.User; //Entity sınıfını import eder 
import org.springframework.data.jpa.repository.JpaRepository; //Spring Data JPA'nın temel repository fonksiyonlarını sağlayan arayüz
import java.util.Optional; 

public interface  JpUserRepository extendsaRepository<User, Long> {  //User: Repository'nin hangi entity ile çalışacağını belirtir
//Long: User entity'sinin primary key tipini (ID alanının tipi) belirtir
    Optional<User> findByUsername(String username);
}

package com.kadir.financetracker.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.*; //getter setter

@Entity //databasedeki bir tabloya karşılık gelir
@Table(name = "app_users") 
@Data //getter ve setter
@NoArgsConstructor //parametresiz bir constructor
@AllArgsConstructor //tüm fieldler için constructor

public class User{
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

 @Column(nullable = false, unique = true)
private String username;

@Column(nullable = false) //bu column boş olamaz
private String password;
private String email;

 @OneToMany(mappedBy = "user",fetch=FetchType.LAZY) // Bir kullanıcının birden çok işlemi olabilir,fetchtype performans için
    private List<Transaction> transactions; // Yeni eklenen alan
	
 @OneToOne(mappedBy = "user")
    private Budget budget; // Kullanıcının bütçe ayarları

}


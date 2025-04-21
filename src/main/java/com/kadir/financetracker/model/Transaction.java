package com.kadir.financetracker.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity  //burdaki kodların tabloyla eşleşeceğini belirtir
@Table(name="transactions")   //tablo adı özelleştirmesi

public class Transaction {
	@Id //Bu fieldin primary key olduğunu gösterir
	@GeneratedValue(strategy=GenerationType.IDENTITY) //id i gittikçe arttırır -nasıl olacağını gösterir
		private Long id;
		
@NotNull //burası null olamaz
private BigDecimal amount; //harcama miktarı için

@NotBlank  //burası boş olamaz 
private String description; //neye harcandı örneğin starbucks-kahve

private LocalDate date; //YY-MM-DD formatında tarihi tutar

@Enumerated(EnumType.STRING)
private TransactionType type; //işlemin türünü belirtir (GELIR veya GIDER).


@ManytoOne //bir kullanıcının birden çok işlemi olabilir
@JoinColumn(name="user_id",nullable=false) //veritabanında user_id adında foreign key oluşturur
private User user;


@ManytoOne //işlemleri kategoriye bağlar
@JoinColumn(name="category_id")
private Category category;//kategori örneğin yemek ulaşım

@Enumerated(EnumType.STRING)
private PaymentMethod paymentMethod; // NAKIT, KREDI_KARTI, BANK_TRANSFER

 private boolean isRecurring; // Tekrarlayan ödeme mi? (Abonelikler için)
}
 
	


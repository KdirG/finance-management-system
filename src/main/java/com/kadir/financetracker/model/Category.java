package com.kadir.financetracker.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Table(name="categories") //tabloya categories adını verdik
@Data 
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
   @Column(nullable = false, unique = true)
   @NotBlank(message="Kategori adı boş olamaz!")
    private String name; // "Yemek", "Fatura", "Tatil"

    @OneToMany(mappedBy = "category",fetch=FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true) //Cascade burda kategori içinde bir şey silindiğine
    private List<Transaction> transactions;                                                          //otomatik olarak silinmesini sağlar orphanremoval ise 
	                                                                                                    //İlişkisi kopan transaction'ları otomatik olarak siler.
	
	
}	
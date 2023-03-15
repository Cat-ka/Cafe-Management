package com.cafe.POJO;

import com.cafe.wrapper.ProductWrapper;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;


@NamedQuery(name = "Product.getAllProducts", query = "select new com.cafe.wrapper.ProductWrapper(p.id, p.name, " +
        "p.description, p.price, p.status, p.category.id, p.category.name) from Product p")

@NamedQuery(name = "Product.updateProductStatus", query = "update Product p set p.status=:status where p.id=:id")
//status a id si dotiahne z ProductDao, z tých @Param

@NamedQuery(name = "Product.getProductByCategory", query = "select new com.cafe.wrapper.ProductWrapper(p.id, p.name) " +
        "from Product p where p.category.id=:id and p.status='true'")
//podľa tohto query sme v ProductWraper vytvorili aj konštruktor... aby sa nám vytvorili požadované ProduktWrapery

@NamedQuery(name = "Product.getProductById", query = "select new com.cafe.wrapper.ProductWrapper(p.id, " +
        "p.name, p.description, p.price) from Product p where p.id=:id")


@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "product")
public class Product implements Serializable {

    public static final Long serialVersionUid = 123456L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    //vytváram asociáciu s kategóriou
    //many products to one category
    @ManyToOne(fetch = FetchType.LAZY)
    //toto znamená že categoria bude načítaná až vtedy keď ju budeme chcieť načítať
    @JoinColumn(name = "category_fk", nullable = false)
    private Category category;


    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Integer price;

    @Column(name = "status")
    private String status;
}

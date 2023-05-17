//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "images")
public class Image {

    @Id
    @Column(name = "image_id")
    private Integer imageId;
    private Integer size;
    private String path;
    private String type;
    private String token;

    private Integer image_bookId;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "image")
    private Book imageBook;

}

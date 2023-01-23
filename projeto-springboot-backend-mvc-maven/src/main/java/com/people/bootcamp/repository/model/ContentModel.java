package com.people.bootcamp.repository.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_Content")
public class ContentModel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", unique = true)
    @NotEmpty(message = "title cannot be empty")
    @NotNull(message = "title cannot be null")
    private String title;

    @Column(name = "description", unique = true)
    @NotEmpty(message = "description cannot be empty")
    @NotNull(message = "description cannot be null")
    private String description;

    @Column(name = "type_Content", unique = true)
    @NotEmpty(message = "type_Content cannot be empty")
    @NotNull(message = "type_Content cannot be null")
    private String typeContent;
    
    @Column(name = "url_Content", unique = true)
    @NotEmpty(message = "url_Content cannot be empty")
    @NotNull(message = "url_Content cannot be null")
    private String urlContent;
    
    @Column(name = "url_Image", unique = true)
    @NotEmpty(message = "url_Image cannot be empty")
    @NotNull(message = "url_Image cannot be null")
    private String urlImage;

    @ManyToMany(mappedBy = "contents")
    private List<TrailModel> trails;

    @ManyToMany(mappedBy = "contents")
    List<UserModel> users;

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (!(obj instanceof ContentModel)){
            return false;
        }
        ContentModel other = (ContentModel) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        }else if (!id.equals(other.id)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }


}
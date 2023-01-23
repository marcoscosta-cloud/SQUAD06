package com.people.bootcamp.repository.model;

import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "TBL_Trail")
public class TrailModel {

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

    @Column(name = "url", unique = true)
    @NotEmpty(message = "url cannot be empty")
    @NotNull(message = "url cannot be null")
    private String url;
    
    @Column(name = "code", unique = true)
    @NotEmpty(message = "code cannot be empty")
    @NotNull(message = "code cannot be null")
    private String code;

    // Uni-directional many-to-many association to Content
    @ManyToMany()
    @JoinTable(name="tbl_contents_trails", joinColumns=@JoinColumn(name="TRAIL_ID"),
            inverseJoinColumns=@JoinColumn(name="CONTENTS_ID")) //@JoinTable is used to map Join table in database
    private List<ContentModel> contents;
    
}

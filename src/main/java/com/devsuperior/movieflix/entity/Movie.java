package com.devsuperior.movieflix.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String subTitle;
	private String synopsis;
	private Integer year;
	private String imgUrl;
	
	@ManyToOne
	private Genre genre;
	
	@OneToMany(mappedBy = "movie")
	@Setter(AccessLevel.NONE)
	private Set<Review> reviews = new HashSet<>();
}

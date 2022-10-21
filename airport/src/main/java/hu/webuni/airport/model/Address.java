package hu.webuni.airport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Audited
@Entity
public class Address {

	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include()
	private long id;
	
	private String country;
	private String city;
	private String street;
	private String zip;
	
}

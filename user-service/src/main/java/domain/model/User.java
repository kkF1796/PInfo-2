package domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@Entity
@DiscriminatorColumn(name = "userId")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// No subclass yet
//@ApiModel(subTypes = {Bond.class, Stock.class, Deposit.class, Loan.class, Warrant.class}, discriminator = "userType")
public abstract class User {

	@Id
	@Column(name="userId", insertable=false, updatable=false)
	@SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
	private Long userId;

	@NotNull
	private String userName;

	@NotNull
	private String email;

	/*@NotNull
	private List<Recipe> favoriteRecipes;

	@NotNull
	private Date registerDate;

	@NotNull
	private float userRating;*/

}

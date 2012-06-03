import java.io.Serializable;
import javax.persistence.*;

@Entity
public class HautFait implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	@Id
	private String name;
	
	public HautFait() {
		super();
	}
   
}

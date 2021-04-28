package matt.restmicroservice.modals;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AppUserDTO {

	public AppUserDTO(Integer id, String email, String name) {
		// TODO Auto-generated constructor stub
	}
	private Integer id;
	private String name;
	private String email;
}

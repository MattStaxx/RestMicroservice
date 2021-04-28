package matt.RestMicroservice.modals;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AppUserDTO {

	private Integer id;
	private String name;
	private String email;
}

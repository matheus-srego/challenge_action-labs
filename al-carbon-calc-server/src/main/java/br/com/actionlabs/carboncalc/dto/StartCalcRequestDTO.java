package br.com.actionlabs.carboncalc.dto;

import br.com.actionlabs.carboncalc.utils.CONSTANTS;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StartCalcRequestDTO {

  @NotBlank(message = CONSTANTS.NAME_NOT_BLANK)
  private String name;

  @NotBlank(message = CONSTANTS.EMAIL_NOT_BLANK)
  @Email(message = CONSTANTS.EMAIL_INVALID)
  private String email;

  @NotBlank(message = CONSTANTS.UF_NOT_BLANK)
  private String uf;

  @NotBlank(message = CONSTANTS.PHONE_NOT_BLANK)
  private String phoneNumber;

}

package mzatka.bankappbackend.models.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ConfirmationPasswordDto implements Dto {

  @NotNull @NotBlank private String password;
}

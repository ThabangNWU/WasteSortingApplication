package com.enviro.assessment.grad001.LebeleThabangAdmore.requests;

import jakarta.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;

public record RecyclingTipRequest(@NonNull @NotBlank String tip) {
}

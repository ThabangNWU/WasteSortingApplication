package com.enviro.assessment.grad001.LebeleThabangAdmore.exceptions;

import java.time.LocalDateTime;

public record ApiError(String path,
                       String message,
                       int statusCode,
                       LocalDateTime localDateTime
) {
}

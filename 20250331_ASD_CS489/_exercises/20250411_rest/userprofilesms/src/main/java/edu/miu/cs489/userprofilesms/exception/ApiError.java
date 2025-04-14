package edu.miu.cs489.userprofilesms.exception;

import java.time.Instant;

public record ApiError(String message, String path, Integer statusCode, Instant timestamp) {
}

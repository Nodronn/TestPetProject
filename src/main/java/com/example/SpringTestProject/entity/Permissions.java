package com.example.SpringTestProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Permissions {
    SECURE("secure"),
    UNSECURE("unsecure");

    private final String permission;
}


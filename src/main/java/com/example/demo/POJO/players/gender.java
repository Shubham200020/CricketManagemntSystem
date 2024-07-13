package com.example.demo.POJO.players;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name="gender")

public enum gender {
	Male,
	FEMALE,
	Other
}

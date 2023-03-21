package com.epam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.epam.repo.UserRepository;

@ComponentScan(basePackages = {"com.epam.repo"})
public class Config {

}

package com.example.passwordvalidator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.regex.Pattern;

@Service
public class PasswordService {

    private static final Logger logger = LoggerFactory.getLogger(PasswordService.class);

    public boolean isPasswordValid(String password) {
        if (password == null) {
            logger.warn("Senha inválida: o campo 'password' não pode ser vazio.");
            return false;
        }
        logger.info("Validando senha: {}", password);

        if (password.length() < 9) {
            logger.warn("Senha inválida: deve ter nove ou mais caracteres.");
            return false;
        }

        if (!Pattern.compile("[0-9]").matcher(password).find()) {
            logger.warn("Senha inválida: deve conter pelo menos 1 dígito.");
            return false;
        }

        if (!Pattern.compile("[a-z]").matcher(password).find()) {
            logger.warn("Senha inválida: deve conter pelo menos 1 letra minúscula.");
            return false;
        }

        if (!Pattern.compile("[A-Z]").matcher(password).find()) {
            logger.warn("Senha inválida: deve conter pelo menos 1 letra maiúscula.");
            return false;
        }

        if (!Pattern.compile("[!@#$%^&*()\\-+]").matcher(password).find()) {
            logger.warn("Senha inválida: deve conter pelo menos 1 caractere especial.");
            return false;
        }

        if (password.chars().distinct().count() != password.length()) {
            logger.warn("Senha inválida: não pode conter caracteres repetidos.");
            return false;
        }

        if (password.contains(" ")) {
            logger.warn("Senha inválida: não pode conter espaços em branco.");
            return false;
        }

        logger.info("Senha válida.");
        return true;
    }
}